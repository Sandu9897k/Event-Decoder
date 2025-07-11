package com.altria.dialog.decoder.processors;

import com.altria.dialog.decoders.common.ConversionHelper;
import com.altria.dialog.decoders.common.DecoderBase;
import com.altria.dialog.decoders.common.DecoderInput;
import com.altria.dialog.decoders.common.OutputChannel;
import com.altria.dialog.decoders.huawei.Huawei2MergedCSVDecoder;
import com.altria.dialog.decoders.huawei.MergedCSVDecoderInput;
import org.apache.nifi.annotation.documentation.CapabilityDescription;
import org.apache.nifi.annotation.documentation.SeeAlso;
import org.apache.nifi.annotation.documentation.Tags;
import org.apache.nifi.components.PropertyDescriptor;
import org.apache.nifi.processor.ProcessContext;
import org.apache.nifi.processor.util.StandardValidators;

import java.io.ByteArrayOutputStream;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.ZoneId;
import java.util.List;
import java.util.Map;

import static com.altria.dialog.utils.EventIDUtils.GET_ID_CHANNEL_MAP_HUAWEI;

@Tags({"Huawei", "Binary", "CSV", "Merged decoder"})
@CapabilityDescription("Converts Huawei binary stream to CSV format with record merging")
@SeeAlso({EricssonBinaryCSVMergeProcessor.class})
public class HuaweiBinaryCSVMergeProcessor extends AbstractBinaryProcessorBase {
//    public static final PropertyDescriptor EARFCN_LOOKUP_SERVICE =
//            new PropertyDescriptor.Builder()
//                    .name("EARFCN CSV Lookup service")
//                    .displayName("EARFCN CSV Lookup Service")
//                    .description("The lookup service with the 'huawei_earfcnmap.csv' records")
//                    .identifiesControllerService(LookupService.class)
//                    .required(true)
//                    .build();
//
//    public static final PropertyDescriptor PCI_LOOKUP_SERVICE =
//            new PropertyDescriptor.Builder()
//                    .name("PCI CSV Lookup service")
//                    .displayName("PCI CSV Lookup Service")
//                    .description("The lookup service with the 'huawei_nbrmapp_withkey.csv' records")
//                    .identifiesControllerService(LookupService.class)
//                    .required(true)
//                    .build();

    public static final PropertyDescriptor DATETIME_ZONE_ID = new PropertyDescriptor
            .Builder().name("Datetime ZoneId")
            .displayName("Datetime ZoneId")
            .description("Correct Timezone Id used to convert UTC to Local date time")
            .defaultValue("Asia/Colombo")
            .addValidator(StandardValidators.NON_EMPTY_VALIDATOR)
            .required(false)
            .build();

    public static final PropertyDescriptor HEADER_ENABLE = new PropertyDescriptor
            .Builder().name("Header enable")
            .displayName("header enable")
            .description("Header enable option for output file")
            .addValidator(StandardValidators.BOOLEAN_VALIDATOR)
            .allowableValues("true", "false")
            .defaultValue("true")
            .required(true)
            .build();

    //    private LookupService earfcnNiFiLookupService;
//    private LookupService pciNiFiLookupService;
    private ZoneId zoneId;
    private boolean headerEnable;

    @Override
    protected void addPropertyDescriptors(List<PropertyDescriptor> descriptors) {
//        descriptors.add(EARFCN_LOOKUP_SERVICE);
//        descriptors.add(PCI_LOOKUP_SERVICE);
        descriptors.add(DATETIME_ZONE_ID);
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
//                lookupServiceMap,
                zoneId,
                inputFileName,
                headerEnable
        );

        for (Map.Entry<Integer, String> entry : GET_ID_CHANNEL_MAP_HUAWEI.entrySet()) {
            String channelId = entry.getValue();
            String channelOutputFile = parentPath + "\\" + channelId + "_" + path.getFileName().toString();

            ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
            channelOutputStreams.put(channelId, outputStream);

            input.addChannel(new OutputChannel(channelId, outputStream))
                    .addFileName(channelId, channelOutputFile);
        }

        return input;
        // Initialize decoder input


//        // Define all Huawei channels and their file prefixes
//        Map<String, String> channelPrefixes = new HashMap<>();
//        channelPrefixes.put(Huawei2MergedCSVDecoder.HUAWEI_4867_CHANNEL, "m1_");
//        channelPrefixes.put(Huawei2MergedCSVDecoder.ALL_CHANNEL, "m2_");
//
//        // Add more channels as needed
//
//        // Add channels and their output streams
//        for (Map.Entry<String, String> channelEntry : channelPrefixes.entrySet()) {
//            String channelId = channelEntry.getKey();
//            String prefix = channelEntry.getValue();
//
//            // Create output stream for this channel
//            ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
//            channelOutputStreams.put(channelId, outputStream);
//
//            // Create output file path for this channel
//            String channelOutputFile = parentPath + prefix + path.getFileName().toString();
//
//            // Add channel to decoder input
//            input.addChannel(new OutputChannel(channelId, outputStream))
//                    .addFileName(channelId, channelOutputFile);
//        }
//
//        return input;
    }

//    @Override
//    protected DecoderInput buildDecoderInput(byte[] inputBytes, OutputStream os, String inputFileName, String outputFile) {
//        RecordLookupService earfcnLookupService = new NiFiLookupServiceWrapper(this.earfcnNiFiLookupService);
//        RecordLookupService pciLookupService = new NiFiLookupServiceWrapper(this.pciNiFiLookupService);
//        HashMap<String, RecordLookupService> lookupServiceMap = new HashMap<>();
//        lookupServiceMap.put(HuaweiConstants.EARFCN_LOOKUP_SERVICE, earfcnLookupService);
//        lookupServiceMap.put(HuaweiConstants.PCI_LOOKUP_SERVICE, pciLookupService);
//        Path path = Paths.get(outputFile);
//
//
//        Path parent = path.getParent();
//        String parentPath;
//        if (parent != null) {
//            parentPath = parent.toString();
//        } else {
//            parentPath = "."; // or some other default directory path, often the current directory
//        }
//
//        String outfile4867huawei = parentPath + "\\m1_" + path.getFileName().toString();
//
//
//        final DecoderInput input = new MergedCSVDecoderInput(inputBytes, 1, 1, lookupServiceMap, zoneId, inputFileName, headerEnable)
//                .addChannel(new OutputChannel(Huawei2MergedCSVDecoder.ALL_CHANNEL, os)).addFileName(Huawei2MergedCSVDecoder.HUAWEI_4867_CHANNEL, outfile4867huawei);
//
//        return input;
//    }

    @Override
    public void onScheduled(ProcessContext context) {
//        this.earfcnNiFiLookupService = context.getProperty(EARFCN_LOOKUP_SERVICE).asControllerService(LookupService.class);
//        this.pciNiFiLookupService = context.getProperty(PCI_LOOKUP_SERVICE).asControllerService(LookupService.class);
        this.headerEnable = context.getProperty(HEADER_ENABLE).asBoolean();
        String zoneIdStr = context.getProperty(DATETIME_ZONE_ID).getValue();
        if (zoneIdStr == null) {
            this.zoneId = ConversionHelper.ZONE_COLOMBO;
        } else {
            this.zoneId = ZoneId.of(zoneIdStr);
        }
    }

    @Override
    protected DecoderBase buildDecoder() {
        final Huawei2MergedCSVDecoder decoder = new Huawei2MergedCSVDecoder();
        return decoder;
    }

//    @Override
//    protected String getOutChannelName() {
//        return Huawei2MergedCSVDecoder.ALL_CHANNEL;
//    }

    @Override
    protected String getOutFileName(String inputFileName, String suffix) {
        return inputFileName + "_" + suffix + ".csv";
    }

    @Override
    protected String getChannelFileName(String inputFileName, String channelId, String suffix) {
        return inputFileName + "_" + channelId + "_" + suffix + ".csv";
    }


}
