package com.altria.dialog.decoders.ericsson;

import com.altria.dialog.decoders.common.DecoderInput;
import com.altria.dialog.decoders.common.RecordLookupService;

import java.util.HashMap;

public class MergedCSVDecoderInput extends DecoderInput {
//    public HashMap<String, RecordLookupService> getLookupServiceMap() {
//        return lookupServiceMap;
//    }
//
//    HashMap<String, RecordLookupService> lookupServiceMap;

    private String fileName;
    private boolean headerEnable;
    private String networkType;

    public String getNetworkType() {
        return networkType;
    }

    public void setNetworkType(String networkType) {
        this.networkType = networkType;
    }

    public String getFileName() {
        return fileName;
    }

    public boolean getHeaderOption() {
        return headerEnable;
    }

    public MergedCSVDecoderInput(byte[] input, int outChannelCount, int outputFileCount, String fileName, boolean headerEnable) {
        super(input, outChannelCount, outputFileCount);
        this.fileName = fileName;
        this.headerEnable = headerEnable;
    }


//    public MergedCSVDecoderInput(byte[] input, int outChannelCount, int outputFileCount, String fileName, HashMap<String, RecordLookupService> lookupServiceMap, boolean headerEnable) {
//        super(input, outChannelCount, outputFileCount);
//        this.fileName = fileName;
//        this.lookupServiceMap = lookupServiceMap;
//        this.headerEnable = headerEnable;
//    }
//
//    public MergedCSVDecoderInput(byte[] input, int outChannelCount, int fileNameCount, HashMap<String, RecordLookupService> lookupServiceMap, String fileName, boolean headerEnable, String networkType) {
//        super(input, outChannelCount, fileNameCount);
//        this.lookupServiceMap = lookupServiceMap;
//        this.fileName = fileName;
//        this.headerEnable = headerEnable;
//        this.networkType = networkType;
//    }
}
