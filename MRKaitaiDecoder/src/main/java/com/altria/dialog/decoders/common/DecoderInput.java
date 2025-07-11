package com.altria.dialog.decoders.common;

import java.util.HashMap;

public class DecoderInput {
    private HashMap<String, OutputChannel> channels;

    private HashMap<String, String> fileNames;
    private byte[] inputBytes;

    public DecoderInput(byte[] input, int outChannelCount, int fileNameCount) {
        this.channels = new HashMap<>(outChannelCount);
        this.inputBytes = input;
        this.fileNames = new HashMap<>(fileNameCount);
    }

    public DecoderInput addChannel(OutputChannel channel) {
        this.channels.put(channel.getChannelName(), channel);
        return this;
    }

    public DecoderInput addFileName(String nameReference, String fileName) {
        this.fileNames.put(nameReference, fileName);
        return this;
    }

    public String getOutputFile(String nameReference) {
        return this.fileNames.get(nameReference);
    }

    public OutputChannel getOutputChannel(String name) {
        return this.channels.get(name);
    }

    public byte[] getInputBytes() {
        return inputBytes;
    }
}
