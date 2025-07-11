package com.altria.dialog.decoders.huawei;

import com.altria.dialog.decoders.common.DecoderInput;
import com.altria.dialog.decoders.common.RecordLookupService;

import java.time.ZoneId;
import java.util.HashMap;

public class MergedCSVDecoderInput extends DecoderInput {

    protected ZoneId timeZoneId;
    protected String filename;
    protected boolean headerEnable;


    public ZoneId getTimeZoneId() {
        return timeZoneId;
    }

    public String getFileName () { return filename; }

    public boolean getHeaderOption() { return headerEnable; }

    public HashMap<String, RecordLookupService> getLookupServiceMap() {
        return lookupServiceMap;
    }

    HashMap<String, RecordLookupService> lookupServiceMap;

    public MergedCSVDecoderInput(byte[] input, int outChannelCount, int outputFileCount, HashMap<String, RecordLookupService> lookupServiceMap, ZoneId timeZoneId, String inputFile, boolean headerEnable) {
        super(input, outChannelCount, outputFileCount);
        this.lookupServiceMap = lookupServiceMap;
        this.timeZoneId = timeZoneId;
        this.filename= inputFile;
        this.headerEnable= headerEnable;
    }

    public MergedCSVDecoderInput(byte[] input, int outChannelCount, int outputFileCount, ZoneId timeZoneId, String inputFile, boolean headerEnable) {
        super(input, outChannelCount, outputFileCount);
        this.timeZoneId = timeZoneId;
        this.filename= inputFile;
        this.headerEnable= headerEnable;
    }

    public MergedCSVDecoderInput(byte[] input, int outChannelCount, int outputFileCount, HashMap<String, RecordLookupService> lookupServiceMap) {
        super(input, outChannelCount, outputFileCount);
        this.lookupServiceMap = lookupServiceMap;
    }
}
