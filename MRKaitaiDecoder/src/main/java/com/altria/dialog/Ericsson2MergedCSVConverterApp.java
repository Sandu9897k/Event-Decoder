package com.altria.dialog;

import com.altria.dialog.decoders.common.DecoderBase;
import com.altria.dialog.decoders.common.DecoderOutput;
import com.altria.dialog.decoders.common.OutputChannel;
import com.altria.dialog.decoders.common.RecordLookupService;
import com.altria.dialog.decoders.ericsson.Ericsson2MergedCSVDecoder;
import com.altria.dialog.decoders.ericsson.MergedCSVDecoderInput;
import com.altria.dialog.utils.StreamUtils;

import java.io.File;
import java.io.FileOutputStream;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static com.altria.dialog.constant.AppConstant.NETWORK_TYPE_4G;
import static com.altria.dialog.constant.AppConstant.NETWORK_TYPE_5G;
import static com.altria.dialog.utils.EventIDUtils.GET_ID_CHANNEL_MAP_ERICSSON_4G;
import static com.altria.dialog.utils.EventIDUtils.GET_ID_CHANNEL_MAP_ERICSSON_5G;

// java -cp mr-kaitai-decoder-1.0.0.jar com.altria.dialog.EricssonConverterApp ../../../mr-kaitai/data/1_9817_all.dat  198.json

public class Ericsson2MergedCSVConverterApp {


    public static void main(String[] args) {
//        if (args.length != 4) {
//            System.out.println("Usage: Ericsson2MergedCSVConverterApp <infile> <outfile> <nbrmap_file>  <header_option(true/false)>");
//            System.exit(-1);
//        }
//        System.out.println(args[0] + "," + args[1] + "," + args[2]+"," + args[3]);
//
//        String infile = args[0];
//        String outfile = args[1];
//        String nbrMapFile = args[2];
//        boolean headerEnable= Boolean.parseBoolean(args[3]);

        String inputDirectory = "D:/code_bases/Event Decoder/Ericson Testing 5G June";
        boolean headerEnable = true;

        File directory = new File(inputDirectory);
        File[] logFiles = directory.listFiles((dir, name) -> name.toLowerCase().endsWith(".gpb") || name.toLowerCase().endsWith(".bin"));

        if (logFiles != null) {
            for (File logFile : logFiles) {
                try {
                    // Create input and output file paths
                    String infile = logFile.getAbsolutePath();
                    String outfile = infile.replaceAll("(?i)\\.(gpb|bin)$", ".csv");

                    Path path = Paths.get(outfile);

                    Path parent = path.getParent();
                    String parentPath;
                    if (parent != null) {
                        parentPath = parent.toString();
                    } else {
                        parentPath = ".";
                    }


                    System.out.println("Processing file: " + logFile.getName());
                    processEricsonFile(infile, headerEnable, path, parentPath);

//                    processEricson5GFile(infile, headerEnable, path, parentPath, type);

                } catch (Exception e) {
                    System.err.println("Error processing file: " + logFile.getName());
                    e.printStackTrace();
                    // Continue with next file even if current file fails
                    continue;
                }
            }
        }
    }

    private static void processEricsonFile(String infile, boolean headerEnable, Path path, String parentPath) {
        String fileName = new File(infile).getName();

        DecoderOutput out = null;

        try {
            Map<String, FileOutputStream> channelOutputStreams = new HashMap<>();
            MergedCSVDecoderInput input = new MergedCSVDecoderInput(
                    StreamUtils.getBytesBuffer(infile),
                    1,
                    1,
                    fileName,
                    headerEnable);

            Set<Map.Entry<Long, String>> entrySet = Set.of();

            String networkType = "";
            Pattern pattern = Pattern.compile("MeContext=([^,]+)");
            Matcher matcher = pattern.matcher(fileName);
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

                FileOutputStream f = new FileOutputStream(channelOutputFile);
                channelOutputStreams.put(channelId, f);

                input.addChannel(new OutputChannel(channelId, f))
                        .addFileName(channelId, channelOutputFile);
            }

            out = new Ericsson2MergedCSVDecoder().convert(input);

        } catch (Exception e) {
            System.err.println("Error in converting file: " + infile + " error:" + e.toString());
        }

        if (out != null && out.getStatus() == DecoderBase.Status.SUCCESS) {
            System.out.println("File converted successfully");
        } else {
            System.err.println("Error in converting file: " + infile + " error:" + out.getException().toString());
        }
    }
}

//        if (logFiles != null) {
//
//        String fileName = new File(infile).getName();
//
//        Path path = Paths.get(outfile);
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
//        System.out.println("Start " + LocalDateTime.now());
//        DecoderOutput out = null;
//        try (
//                FileOutputStream fOut = new FileOutputStream(outfile)
//        ) {
//            RecordLookupService nbrLookupService = new CsvFileLookupService(nbrMapFile, EricssonConstants.NBR_LOOKUP_FIELD_KEY);
//            HashMap<String, RecordLookupService> lookupServiceMap = new HashMap<>();
//            lookupServiceMap.put(EricssonConstants.NBR_LOOKUP_SERVICE, nbrLookupService);
//
//            out = new Ericsson2MergedCSVDecoder()
//                    .convert(new MergedCSVDecoderInput(StreamUtils.getBytesBuffer(infile), 1,1, fileName, lookupServiceMap, headerEnable)
//                            .addChannel(new OutputChannel(Ericsson2MergedCSVDecoder.ALL_CHANNEL, fOut)).addFileName(Ericsson2MergedCSVDecoder.ERICSON_3112_CHANNEL, outfile3112ericson));
//
//        } catch (Exception e) {
//            System.err.println("Error in converting file: " + args[0] + " error:" + e.toString());
//        }

//        if (out != null && out.getStatus() == DecoderBase.Status.SUCCESS) {
//            System.out.println(String.format("File converted successfully with (%d/%d) records\n" +
//                            "success nbr lookup count : %d \n" +
//                            "Failed nbr lookup count : %d",
//                    out.getOutputChannel(Ericsson2MergedCSVDecoder.ALL_CHANNEL).getOutputRecordCount(),
//                    out.getOutputChannel(Ericsson2MergedCSVDecoder.ALL_CHANNEL).getRecordCount(),
//                    out.getOutputChannel(Ericsson2MergedCSVDecoder.ALL_CHANNEL).getLookupSuccessCount(),
//                    out.getOutputChannel(Ericsson2MergedCSVDecoder.ALL_CHANNEL).getLookupFailCount()));
//            System.out.println("End " + LocalDateTime.now());
//        } else {
//            out.getException().printStackTrace();
//            System.err.println("Error in converting file: " + args[0] + " error:" + out.getException().toString());
//        }
//    }
//}
