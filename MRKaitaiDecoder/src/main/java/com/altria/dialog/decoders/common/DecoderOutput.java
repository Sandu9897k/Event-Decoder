package com.altria.dialog.decoders.common;

public class DecoderOutput {
    private Exception exception;
    private DecoderBase.Status status = DecoderBase.Status.SUCCESS;
    private DecoderInput input;

    public DecoderOutput(DecoderInput input) {
        this.input = input;
    }

    public Exception getException() {
        return exception;
    }

    public void setException(Exception exception) {
        this.exception = exception;
    }

    public DecoderBase.Status getStatus() {
        return status;
    }

    public void setStatus(DecoderBase.Status status) {
        this.status = status;
    }

    public DecoderInput getInput() {
        return input;
    }

    public OutputChannel getOutputChannel(String name) { return this.input.getOutputChannel(name); }
}
