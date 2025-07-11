package com.altria.dialog.utils;

import java.io.*;

public class StreamUtils {
    public static int fillBuffer(InputStream source, byte[] destination, boolean ensureCapacity) throws IOException {
        int bytesRead;
        int len;
        for(bytesRead = 0; bytesRead < destination.length; bytesRead += len) {
            len = source.read(destination, bytesRead, destination.length - bytesRead);
            if (len < 0) {
                if (ensureCapacity) {
                    throw new EOFException();
                }
                break;
            }
        }
        return bytesRead;
    }

    public static byte[] getBytesBuffer(String fileName) throws IOException {
        File f = new File(fileName);
        long fileSize = f.length();
        final byte[] bytes = new byte[(int)fileSize]; // NOTE: we hope we don't files over 2GB
        try (
                FileInputStream fIn = new FileInputStream(f)
        ) {
            StreamUtils.fillBuffer(fIn, bytes, true);
        }
        return bytes;
    }
}
