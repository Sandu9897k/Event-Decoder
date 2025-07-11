package com.altria.dialog.decoders.common;

import java.io.OutputStream;

public class OutputChannel {
    private String channelName;
    private int recordCount;
    private int outputRecordCount;
    private OutputStream outputStream;
    private String outputFileName;
    private  int lookupSuccessCount;
    private int lookupFailCount;

    public OutputChannel(String name, OutputStream outputStream) {
        this.channelName = name;
        this.outputStream = outputStream;
    }

    public void setRecordCount(int recordCount) {
        this.recordCount = recordCount;
    }

    public String getChannelName() {
        return channelName;
    }

    public int getRecordCount() {
        return recordCount;
    }

    public OutputStream getOutputStream() {
        return outputStream;
    }

    public String getOutputFileName() {
        return outputFileName;
    }

    public int getOutputRecordCount() {
        return outputRecordCount;
    }

    public void setOutputRecordCount(int outputRecordCount) {
        this.outputRecordCount = outputRecordCount;
    }

    public int getLookupSuccessCount() {
        return lookupSuccessCount;
    }

    public int getLookupFailCount() {
        return lookupFailCount;
    }

    public void setLookupSuccessCount(int lookupSuccessCount) { this.lookupSuccessCount = lookupSuccessCount; }

    public void setLookupFailCount(int lookupFailCount) { this.lookupFailCount = lookupFailCount; }
}
