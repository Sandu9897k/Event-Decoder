package com.altria.dialog.decoder.processors;

import com.altria.dialog.decoders.common.DecoderBase;
import com.altria.dialog.decoders.common.DecoderInput;
import com.altria.dialog.decoders.common.OutputChannel;
import com.altria.dialog.decoders.ericsson.Ericsson2MergedCSVDecoder;
import com.altria.dialog.decoders.ericsson.MergedCSVDecoderInput;
import org.apache.nifi.annotation.documentation.CapabilityDescription;
import org.apache.nifi.annotation.documentation.SeeAlso;
import org.apache.nifi.annotation.documentation.Tags;
import org.apache.nifi.components.PropertyDescriptor;
import org.apache.nifi.processor.ProcessContext;
import org.apache.nifi.processor.util.StandardValidators;

import java.io.ByteArrayOutputStream;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static com.altria.dialog.constant.AppConstant.NETWORK_TYPE_4G;
import static com.altria.dialog.constant.AppConstant.NETWORK_TYPE_5G;
import static com.altria.dialog.utils.EventIDUtils.GET_ID_CHANNEL_MAP_ERICSSON_4G;
import static com.altria.dialog.utils.EventIDUtils.GET_ID_CHANNEL_MAP_ERICSSON_5G;

@Tags({"Ericsson", "Binary", "CSV", "Merged decoder"})
@CapabilityDescription("Converts Ericsson binary stream to CSV format with record merging")
@SeeAlso({HuaweiBinaryCSVMergeProcessor.class})
public class EricssonBinaryCSVMergeProcessor extends AbstractBinaryProcessorBase {
//    public static final PropertyDescriptor NBRMAP_LOOKUP_SERVICE =
//            new PropertyDescriptor.Builder()
//                    .name("NBRMAP CSV Lookup service")
//                    .displayName("NBRMAP CSV Lookup Service")
//                    .description("The lookup service with the 'ericsson_nbrmap_with_key.csv' records")
//                    .identifiesControllerService(LookupService.class)
//                    .required(true)
//                    .build();

    public static final PropertyDescriptor HEADER_ENABLE = new PropertyDescriptor
            .Builder().name("Header enable")
            .displayName("header enable")
            .description("Header enable option for output file")
            .addValidator(StandardValidators.BOOLEAN_VALIDATOR)
            .allowableValues("true", "false")
            .defaultValue("true")
            .required(true)
            .build();


//    private LookupService nbrNiFiLookupService;

    private boolean headerEnable;

    @Override
    protected void addPropertyDescriptors(List<PropertyDescriptor> descriptors) {
//        descriptors.add(NBRMAP_LOOKUP_SERVICE);
        descriptors.add(HEADER_ENABLE);
    }

    @Override
    protected DecoderInput buildDecoderMultiInput(byte[] inputBytes, Map<String, ByteArrayOutputStream> channelOutputStreams, String inputFileName, String outputFileName) {
        Path path = Paths.get(outputFileName);
        Path parent = path.getParent();
        String parentPath = (parent != null) ? parent.toString() : ".";
        final MergedCSVDecoderInput input = new MergedCSVDecoderInput(
                inputBytes,
                1,
                1,
                inputFileName,
                headerEnable
        );

        Set<Map.Entry<Long, String>> entrySet = Set.of();

        String networkType = "";
        Pattern pattern = Pattern.compile("MeContext=([^,]+)");
        Matcher matcher = pattern.matcher(inputFileName);
        if (matcher.find()) {
            String meContext = matcher.group(1);
            if (meContext.endsWith("-N")) {
                networkType = NETWORK_TYPE_5G;
                entrySet = GET_ID_CHANNEL_MAP_ERICSSON_5G.entrySet();
            } else {
                networkType = NETWORK_TYPE_4G;
                entrySet = GET_ID_CHANNEL_MAP_ERICSSON_4G.entrySet();
            }
        }
        input.setNetworkType(networkType);

        for (Map.Entry<Long, String> entry : entrySet) {
            String channelId = entry.getValue();
            String channelOutputFile = parentPath + "\\" + channelId + "_" + path.getFileName().toString();

            ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
            channelOutputStreams.put(channelId, outputStream);

            input.addChannel(new OutputChannel(channelId, outputStream))
                    .addFileName(channelId, channelOutputFile);
        }

        return input;
    }

    @Override
    protected String getChannelFileName(String inputFileName, String channelId, String suffix) {
        return inputFileName + "_" + channelId + "_" + suffix + ".csv";
    }

//    @Override
//    protected DecoderInput buildDecoderInput(byte[] inputBytes, OutputStream os, String inputFileName, String outputFileName) {
//        RecordLookupService nbrNiFiLookupService = new NiFiLookupServiceWrapper(this.nbrNiFiLookupService);
//        HashMap<String, RecordLookupService> lookupServiceMap = new HashMap<>();
////        lookupServiceMap.put(EricssonConstants.NBR_LOOKUP_SERVICE, nbrNiFiLookupService);
//        Path path = Paths.get(outputFileName);
//
//        Path parent = path.getParent();
//        String parentPath;
//        if (parent != null) {
//            parentPath = parent.toString();
//        } else {
//            parentPath = "."; // or some other default directory path, often the current directory
//        }
//
//        String outfile3112ericson = parentPath + "\\m1_" + path.getFileName().toString();
//
//
//        final DecoderInput input = new MergedCSVDecoderInput(inputBytes, 1, 1,inputFileName, headerEnable)
//                .addChannel(new OutputChannel(Ericsson2MergedCSVDecoder.ALL_CHANNEL, os)).addFileName(Ericsson2MergedCSVDecoder.ERICSON_3112_CHANNEL, outfile3112ericson);
//
//        return input;
//    }

    @Override
    public void onScheduled(ProcessContext context) {
//        this.nbrNiFiLookupService = context.getProperty(NBRMAP_LOOKUP_SERVICE).asControllerService(LookupService.class);
        this.headerEnable = context.getProperty(HEADER_ENABLE).asBoolean();
    }

    @Override
    protected DecoderBase buildDecoder() {
        final Ericsson2MergedCSVDecoder decoder = new Ericsson2MergedCSVDecoder();
        return decoder;
    }

//    @Override
//    protected String getOutChannelName() {
//        return Ericsson2MergedCSVDecoder.ALL_CHANNEL;
//    }

    @Override
    protected String getOutFileName(String inputFileName, String suffix) {
        return inputFileName + "_" + suffix + ".csv";
    }
}
