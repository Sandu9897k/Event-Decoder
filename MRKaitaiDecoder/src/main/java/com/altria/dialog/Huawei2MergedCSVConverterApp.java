package com.altria.dialog;

import com.altria.dialog.decoders.common.*;
import com.altria.dialog.decoders.huawei.*;
import com.altria.dialog.utils.StreamUtils;

import java.io.ByteArrayOutputStream;
import java.io.File;

import java.io.FileOutputStream;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;

import static com.altria.dialog.utils.EventIDUtils.GET_ID_CHANNEL_MAP_HUAWEI;

// java -cp mr-kaitai-decoder-1.0.0.jar com.altria.dialog.Huawei2MergedCSVConverterApp ../../../mr-kaitai/data/1_9817_all.dat  198.json
public class Huawei2MergedCSVConverterApp {

    public static void main(String[] args) {
//        if (args.length != 5) {
//            System.out.println("Usage: Huawei2MergedCSVConverterApp <infile> <outfile> <earfcn_map_file> <pci_map_file> <header_option(true/false)>");
//            System.exit(-1);
//        }
//
//        System.out.println(args[0] + "," + args[1] + "," + args[2] + "," + args[3] + "," + args[4]);
//
//        String infile = args[0];
//        String outfile = args[1];
//        String earfcnMapFile = args[2];
//        String pciMapFile = args[3];
//        boolean headerEnable = Boolean.parseBoolean(args[4]);

        String inputDirectory = "D:/code_bases/Event Decoder/Huawei Testing_04_06_2025/Somananda_Rd-CM2187-BDGHOP";
        String earfcnMapFile = "D:/code_bases/Event Decoder/Huawei_Testing_250218/huawei_earfcnmap (1).csv";
        String pciMapFile = "D:/code_bases/Event Decoder/Huawei_Testing_250218/huawei_nbrmapp_withkey (1).csv";
        boolean headerEnable = true;

        File directory = new File(inputDirectory);
        File[] logFiles = directory.listFiles((dir, name) -> name.toLowerCase().endsWith(".log"));

        if (logFiles != null) {
            for (File logFile : logFiles) {
                try {
                    // Create input and output file paths
                    String infile = logFile.getAbsolutePath();
                    String outfile = infile.replace(".log", ".csv");

                    Path path = Paths.get(outfile);

                    Path parent = path.getParent();
                    String parentPath;
                    if (parent != null) {
                        parentPath = parent.toString();
                    } else {
                        parentPath = ".";
                    }


                    System.out.println("Processing file: " + logFile.getName());

                    processFile(infile,headerEnable, path, parentPath);

                } catch (Exception e) {
                    System.err.println("Error processing file: " + logFile.getName());
                    e.printStackTrace();
                    // Continue with next file even if current file fails
                    continue;
                }
            }
        }
    }

    private static void processFile(String infile, boolean headerEnable, Path path, String parentPath) {
        String fileName = new File(infile).getName();

        DecoderOutput out = null;

        try {
            //            RecordLookupService earfcnLookupService = new CsvFileLookupService(earfcnMapFile, HuaweiConstants.EARFCN_LOOKUP_FIELD_KEY);
//            RecordLookupService pciLookupService = new CsvFileLookupService(pciMapFile, HuaweiConstants.PCI_LOOKUP_FIELD_KEY);
//            HashMap<String, RecordLookupService> lookupServiceMap = new HashMap<>();
//            lookupServiceMap.put(HuaweiConstants.EARFCN_LOOKUP_SERVICE, earfcnLookupService);
//            lookupServiceMap.put(HuaweiConstants.PCI_LOOKUP_SERVICE, pciLookupService);
            Map<String, FileOutputStream> channelOutputStreams = new HashMap<>();

            MergedCSVDecoderInput input = new MergedCSVDecoderInput(
                    StreamUtils.getBytesBuffer(infile),
                    1,
                    1,
                    ConversionHelper.ZONE_SYDNEY,
                    fileName,
                    headerEnable
            );

            for (Map.Entry<Integer, String> entry : GET_ID_CHANNEL_MAP_HUAWEI.entrySet()) {
                String channelId = entry.getValue();
                String channelOutputFile = parentPath + "\\" + channelId + "_" + path.getFileName().toString();

                FileOutputStream f = new FileOutputStream(channelOutputFile);
                channelOutputStreams.put(channelId, f);

                input.addChannel(new OutputChannel(channelId, f))
                        .addFileName(channelId, channelOutputFile);
            }

            out = new Huawei2MergedCSVDecoder().convert(input);

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


