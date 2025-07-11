package com.altria.dialog.decoders.huawei;

import com.altria.dialog.decoders.common.DecoderBase;
import com.altria.dialog.decoders.common.DecoderInput;
import com.altria.dialog.decoders.common.DecoderOutput;
import com.altria.dialog.decoders.common.KaitaiFieldExclusionStrategy;
import com.altria.dialog.parsers.kaitai.huawei.HuaweiChrEventFile;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import io.kaitai.struct.ByteBufferKaitaiStream;

import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;

public class Huawei2JsonDecoder extends DecoderBase {
    public static final String ALL_CHANNEL = "all";

    @Override
    public DecoderOutput convert(DecoderInput input) {
        OutputStream outStream = input.getOutputChannel(ALL_CHANNEL).getOutputStream();
        DecoderOutput output = new DecoderOutput(input);
        try (
                OutputStreamWriter writer = new OutputStreamWriter(outStream);
                ByteBufferKaitaiStream kaitaiStream = new ByteBufferKaitaiStream(input.getInputBytes())
        ) {
            Gson gson = new GsonBuilder()
                    .setExclusionStrategies(new KaitaiFieldExclusionStrategy())
                    .create();

            HuaweiChrEventFile eventFile = new HuaweiChrEventFile(kaitaiStream);
            for (HuaweiChrEventFile.TEventRecord record: eventFile.eventRecords()) {
                String json = gson.toJson(record);
                writer.write(json);
                writer.write('\n');
            }

            int totalInputRecords = eventFile.eventRecords().size();
            input.getOutputChannel(ALL_CHANNEL).setRecordCount(totalInputRecords);
            // If we're not sure that incoming file has events that we don't support get the
            // correct filtering inside the above 'for' loop and also the count
            input.getOutputChannel(ALL_CHANNEL).setOutputRecordCount(totalInputRecords);

        } catch (IOException e) {
            output.setStatus(Status.ERROR);
            output.setException(e);
        }

        return output;
    }
}
