package com.altria.dialog.decoders.common;

public abstract class DecoderBase {
    public enum Status {
        SUCCESS,
        ERROR
    }

    public abstract DecoderOutput convert(DecoderInput input);
}
