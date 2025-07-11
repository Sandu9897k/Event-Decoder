package com.altria.dialog.parsers.kaitai.ericsson;

import io.kaitai.struct.CustomDecoder;

public class EmptyDataProducer implements CustomDecoder {
    @Override
    public byte[] decode(byte[] src) {
        // Simply return empty data as we don't care
        return null;
    }
}
