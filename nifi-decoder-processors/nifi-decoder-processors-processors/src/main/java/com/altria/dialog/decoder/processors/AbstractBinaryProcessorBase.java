package com.altria.dialog.decoder.processors;

import com.altria.dialog.decoders.common.DecoderBase;
import com.altria.dialog.decoders.common.DecoderInput;
import com.altria.dialog.decoders.common.DecoderOutput;
import com.altria.dialog.decoders.common.OutputChannel;
import org.apache.nifi.annotation.lifecycle.OnScheduled;
import org.apache.nifi.components.PropertyDescriptor;
import org.apache.nifi.flowfile.FlowFile;
import org.apache.nifi.flowfile.attributes.CoreAttributes;
import org.apache.nifi.flowfile.attributes.FragmentAttributes;
import org.apache.nifi.processor.*;
import org.apache.nifi.processor.exception.ProcessException;
import org.apache.nifi.processor.util.StandardValidators;
import org.apache.nifi.stream.io.StreamUtils;
import org.apache.nifi.util.StopWatch;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.*;
import java.util.concurrent.TimeUnit;

public abstract class AbstractBinaryProcessorBase extends AbstractProcessor {

    public static final String FRAGMENT_ID = FragmentAttributes.FRAGMENT_ID.key();
    //    public static final String RECORD_COUNT = "record.count";
//    public static final String OUTPUT_RECORD_COUNT = "output.record.count";
    public static final String SEGMENT_ORIGINAL_FILENAME = FragmentAttributes.SEGMENT_ORIGINAL_FILENAME.key();
    public static final String RECORD_TYPE = "record.type";
    public static final String ELAPSED_TIME_IN_MS = "elapsed.time.ms";
//    public static final String LOOKUP_SUCCESS_COUNT = "lookup.success.count";
//    public static final String LOOKUP_FAIL_COUNT = "lookup.fail.count";

    public static final PropertyDescriptor SUFFIX_ALL_RECORD = new PropertyDescriptor
            .Builder().name("SUFFIX_ALL_RECORD")
            .displayName("file suffix")
            .description("Suffix for file containing all records")
            .defaultValue("all")
            .required(true)
            .addValidator(StandardValidators.NON_EMPTY_VALIDATOR)
            .build();

    static final Relationship REL_CONVERTED = new Relationship.Builder()
            .name("converted")
            .description("JSON converted data of the original FlowFile will be routed to this relationship.")
            .build();

    static final Relationship REL_ORIGINAL = new Relationship.Builder()
            .name("original")
            .description("Upon successfully conversion of an input FlowFile, the original FlowFile will be sent to this relationship.")
            .build();

    static final Relationship REL_FAILURE = new Relationship.Builder()
            .name("failure")
            .description("If a FlowFile cannot be transformed from the configured input format to the configured output format, "
                    + "the unchanged FlowFile will be routed to this relationship.")
            .build();

    protected List<PropertyDescriptor> descriptors;

    protected Set<Relationship> relationships;

    @Override
    protected void init(final ProcessorInitializationContext context) {
        final List<PropertyDescriptor> descriptors = new ArrayList<>();
        descriptors.add(SUFFIX_ALL_RECORD);
        this.addPropertyDescriptors(descriptors);
        this.descriptors = Collections.unmodifiableList(descriptors);

        final Set<Relationship> relationships = new HashSet<>();
        relationships.add(REL_CONVERTED);
        relationships.add(REL_ORIGINAL);
        relationships.add(REL_FAILURE);
        this.relationships = Collections.unmodifiableSet(relationships);
    }

    @Override
    public Set<Relationship> getRelationships() {
        return this.relationships;
    }

    @Override
    public final List<PropertyDescriptor> getSupportedPropertyDescriptors() {
        return descriptors;
    }

    @OnScheduled
    public void onScheduled(final ProcessContext context) {

    }

    protected static Map<String, String> buildChannelAttributes(
            String channelFileName,
//            int recordCount,
//            int outputRecordCount,
            String recordType,
            String originalFileName,
            String fragmentId,
            long timeElapsed
//            int outputSuccessLookupCount,
//            int outputFailLookupCount
    ) {
        final Map<String, String> attributes = new HashMap<>(7);

        attributes.put(CoreAttributes.FILENAME.key(), channelFileName);
//        attributes.put(RECORD_COUNT, String.valueOf(recordCount));
//        attributes.put(OUTPUT_RECORD_COUNT, String.valueOf(outputRecordCount));
        attributes.put(RECORD_TYPE, recordType.toUpperCase());
        attributes.put(SEGMENT_ORIGINAL_FILENAME, originalFileName);
        attributes.put(FRAGMENT_ID, fragmentId);
        attributes.put(ELAPSED_TIME_IN_MS, String.valueOf(timeElapsed));
//        attributes.put(LOOKUP_SUCCESS_COUNT, String.valueOf(outputSuccessLookupCount));
//        attributes.put(LOOKUP_FAIL_COUNT, String.valueOf(outputFailLookupCount));

        return attributes;
    }

//    protected abstract DecoderInput buildDecoderInput(byte[] inputBytes, OutputStream os, String inputFileName, String outputFileName);

    protected abstract DecoderBase buildDecoder();

//    protected abstract String getOutChannelName();

    protected abstract String getOutFileName(String inputFileName, String suffx);

    protected void addPropertyDescriptors(List<PropertyDescriptor> descriptors) {

    }

    protected abstract DecoderInput buildDecoderMultiInput(byte[] inputBytes, Map<String, ByteArrayOutputStream> channelOutputStreams, String inputFileName, String suffix);

    protected abstract String getChannelFileName(String inputFileName, String channelId, String suffix);

    @Override
    public void onTrigger(ProcessContext context, ProcessSession session) throws ProcessException {
        FlowFile original = session.get();
        if (original == null) {
            return;
        }

        final StopWatch stopWatch = new StopWatch(true);
        final String fragmentId = UUID.randomUUID().toString();
        final List<FlowFile> outputs = new ArrayList<>();


        byte[] bytes;
        try (ByteArrayOutputStream baos = new ByteArrayOutputStream()) {
            session.read(original, inputStream -> StreamUtils.copy(inputStream, baos));
            bytes = baos.toByteArray();
        } catch (IOException e) {
            getLogger().error("Failed to read FlowFile {} due to {}", new Object[]{original, e}, e);
            session.transfer(original, REL_FAILURE);
            return;
        }

        if (bytes.length == 0) {
            getLogger().warn("FlowFile {} is empty, transferring to failure relationship.", new Object[]{original});
            session.transfer(original, REL_FAILURE);
            return;
        }

        try {
            Map<String, ByteArrayOutputStream> channelOutputStreams = new HashMap<>();
            String inputFileName = original.getAttribute(CoreAttributes.FILENAME.key());
            String suffixAllRecord = context.getProperty(SUFFIX_ALL_RECORD).getValue();
            final String outputFileName = getOutFileName(inputFileName, suffixAllRecord);

            final DecoderInput decoderInput = buildDecoderMultiInput(
                    bytes,
                    channelOutputStreams,
                    inputFileName,
                    outputFileName
            );

            final DecoderBase decoder = buildDecoder();
            DecoderOutput dOut = decoder.convert(decoderInput);
            stopWatch.stop();

            if (dOut != null && dOut.getStatus() != DecoderBase.Status.ERROR) {
                for (Map.Entry<String, ByteArrayOutputStream> entry : channelOutputStreams.entrySet()) {
                    String channelId = entry.getKey();
                    ByteArrayOutputStream outputStream = entry.getValue();

                    if (outputStream.size() > 0) {
                        FlowFile channelFF = session.create(original);
                        channelFF = session.write(channelFF, out -> {
                            try {
                                outputStream.writeTo(out);
                            } finally {
                                outputStream.close();
                            }
                        });

                        String channelFileName = getChannelFileName(inputFileName, channelId, suffixAllRecord);
                        OutputChannel channelOutput = dOut.getOutputChannel(channelId);

                        Map<String, String> attributes = buildChannelAttributes(
                                channelFileName,
//                                channelOutput.getRecordCount(),
//                                channelOutput.getOutputRecordCount(),
                                channelId,
                                inputFileName,
                                fragmentId,
                                stopWatch.getDuration(TimeUnit.MILLISECONDS)
//                                channelOutput.getLookupSuccessCount(),
//                                channelOutput.getLookupFailCount()
                        );

                        channelFF = session.putAllAttributes(channelFF, attributes);
                        outputs.add(channelFF);
                    }
                }

                session.transfer(original, REL_ORIGINAL);
                for (FlowFile outFF : outputs) {
                    session.transfer(outFF, REL_CONVERTED);
                }
            } else {
                throw new ProcessException("Failed to decode incoming data: " +
                        (dOut != null ? dOut.getStatus() + " " + dOut.getException().getMessage() : "null output"));
            }
        } catch (Exception e) {
            getLogger().error("Failed to decode {} due to {}", new Object[]{original, e}, e);
            for (FlowFile outFF : outputs) {
                session.remove(outFF);
            }
            session.transfer(original, REL_FAILURE);
        }

    }
}
