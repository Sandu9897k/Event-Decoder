package com.altria.dialog;

import com.altria.dialog.decoders.common.DecoderBase;
import com.altria.dialog.decoders.common.DecoderInput;
import com.altria.dialog.decoders.common.DecoderOutput;
import com.altria.dialog.decoders.common.OutputChannel;
import com.altria.dialog.decoders.ericsson.Ericsson2JsonDecoder;
import com.altria.dialog.utils.StreamUtils;

import java.io.FileOutputStream;

// java -cp mr-kaitai-decoder-1.0.0.jar com.altria.dialog.EricssonConverterApp ../../../mr-kaitai/data/1_9817_all.dat  198.json

public class EricssonConverterApp {

    public static void main(String[] args) {
        if (args.length != 2) {
            System.out.println("Usage: EricssonConvererApp <infile> <outfile>");
            System.exit(-1);
        }

        System.out.println(args[0] + "," + args[1]);

        DecoderOutput out = null;

        try (
                FileOutputStream fOut = new FileOutputStream(args[1]);
        ) {
            out = new Ericsson2JsonDecoder()
                    .convert(new DecoderInput(StreamUtils.getBytesBuffer(args[0]), 1,1)
                            .addChannel(new OutputChannel(Ericsson2JsonDecoder.ALL_CHANNEL, fOut)));
        } catch (Exception e) {
            System.err.println("Error in converting file: " + args[0] + " error:" + e.toString());
        }

        if (out != null && out.getStatus() == DecoderBase.Status.SUCCESS) {
            System.out.println(String.format("File converted successfully with (%d/%d) records",
                    out.getOutputChannel(Ericsson2JsonDecoder.ALL_CHANNEL).getOutputRecordCount(),
                    out.getOutputChannel(Ericsson2JsonDecoder.ALL_CHANNEL).getRecordCount()));
        } else {
            System.err.println("Error in converting file: " + args[0] + " error:" + out.getException().toString());
        }
    }
}
