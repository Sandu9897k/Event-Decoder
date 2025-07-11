package com.altria.dialog.decoders.ericsson;

import com.altria.dialog.decoders.common.DecoderBase;
import com.altria.dialog.decoders.common.DecoderInput;
import com.altria.dialog.decoders.common.DecoderOutput;
import com.altria.dialog.decoders.common.KaitaiFieldExclusionStrategy;
import com.altria.dialog.parsers.kaitai.ericsson.EricssonEventFile;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import io.kaitai.struct.ByteBufferKaitaiStream;

import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;

public class Ericsson2JsonDecoder extends DecoderBase {
    public static final String ALL_CHANNEL = "all";
    public static final int EVENT_TYPE_4 = 4;
    public static final int EVENT_ID_3108 = 3108;
    public static final int EVENT_ID_3112 = 3112;

    @Override
    public DecoderOutput convert(DecoderInput input) {
        OutputStream outStream = input.getOutputChannel(ALL_CHANNEL).getOutputStream();
        DecoderOutput output = new DecoderOutput(input);
        int outputRecordCount = 0;
        try (
                OutputStreamWriter writer = new OutputStreamWriter(outStream);
                ByteBufferKaitaiStream kaitaiStream = new ByteBufferKaitaiStream(input.getInputBytes())
        ) {
            Gson gson = new GsonBuilder()
                    .setExclusionStrategies(new EricssonFieldExclusionStrategy())
                    .create();

            EricssonEventFile eventFile = new EricssonEventFile(kaitaiStream);
            for (EricssonEventFile.TEventRecord record: eventFile.eventRecords()) {
                // We only need events with type 4 and id 3108 or id 3112
                if (record.eventHeader().eventType() == EVENT_TYPE_4 &&
                        (record.eventHeader().eventId() == EVENT_ID_3108 || record.eventHeader().eventId() == EVENT_ID_3112)) {
                    String json = gson.toJson(record);
                    writer.write(json);
                    writer.write('\n');
                    outputRecordCount++;
                }
            }

            input.getOutputChannel(ALL_CHANNEL).setRecordCount(eventFile.eventRecords().size());
            input.getOutputChannel(ALL_CHANNEL).setOutputRecordCount(outputRecordCount);

        } catch (IOException e) {
            output.setStatus(Status.ERROR);
            output.setException(e);
        }

        return output;
    }
}
