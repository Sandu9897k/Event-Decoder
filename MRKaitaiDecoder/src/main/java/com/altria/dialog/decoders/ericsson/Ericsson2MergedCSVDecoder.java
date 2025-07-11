package com.altria.dialog.decoders.ericsson;

import com.altria.dialog.decoders.common.DecoderBase;
import com.altria.dialog.decoders.common.DecoderInput;
import com.altria.dialog.decoders.common.DecoderOutput;
import com.altria.dialog.decoders.common.OutputChannel;
import com.altria.dialog.parsers.kaitai.ericsson.EricssonEventFile;
import com.altria.dialog.parsers.proto.ericsson.EricssonPmEventOuterClass;
import com.altria.dialog.utils.EricssonCsvWriterUtil;
import io.kaitai.struct.ByteBufferKaitaiStream;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.*;
import java.util.List;
import java.util.Map;

import static com.altria.dialog.constant.AppConstant.NETWORK_TYPE_4G;
import static com.altria.dialog.constant.AppConstant.NETWORK_TYPE_5G;
import static com.altria.dialog.utils.EventIDUtils.*;

public class Ericsson2MergedCSVDecoder extends DecoderBase {

    public static final String ALL_CHANNEL = "all";

    public static final String ERICSON_3112_CHANNEL = "ericson3112channel";

    private static final Logger LOGGER = LogManager.getLogger(Ericsson2MergedCSVDecoder.class);

    @Override
    public DecoderOutput convert(DecoderInput input) {
        MergedCSVDecoderInput decoderInput = (MergedCSVDecoderInput) input;
        DecoderOutput output = new DecoderOutput(decoderInput);
        boolean headerEnable = decoderInput.getHeaderOption();
        String networkType = decoderInput.getNetworkType();
        try {
            String fileName = decoderInput.getFileName();
            FilenameTimeInfo filenameTimeInfo = FilenameTimeInfo.build(fileName);
            if (networkType.equals(NETWORK_TYPE_5G)) {
                ByteArrayInputStream inputStream = new ByteArrayInputStream(input.getInputBytes());
                EricssonEventsReducer reducer = new EricssonEventsReducer(inputStream, decoderInput.getFileName());
                reducer.buildSessions(networkType);
                processChannelForEricssonEvents5g(decoderInput, reducer, headerEnable, output, filenameTimeInfo);
            } else if (networkType.equals(NETWORK_TYPE_4G)) {
                ByteBufferKaitaiStream kaitaiStream = new ByteBufferKaitaiStream(input.getInputBytes());
                EricssonEventFile eventFile = new EricssonEventFile(kaitaiStream);
                EricssonEventsReducer reducer = new EricssonEventsReducer(eventFile.eventRecords(),
                        fileName);
                reducer.buildSessions(networkType);
                processChannelForEricssonEvents4g(decoderInput, reducer, headerEnable, output, filenameTimeInfo);
            }
        } catch (IOException ioe) {
            output.setStatus(Status.ERROR);
            output.setException(ioe);
        }
        return output;
    }


    public void processChannelForEricssonEvents4g(MergedCSVDecoderInput decoderInput,
                                                EricssonEventsReducer reducer,
                                                boolean headerEnable, DecoderOutput output,
                                                FilenameTimeInfo filenameTimeInfo) throws IOException {

        EricssonCsvWriterUtil ericssonCsvWriterUtil = new EricssonCsvWriterUtil();
        Map<Long, List<EricssonEventFile.TEventRecord>> eventRecords = reducer.getEricssonEventRecordsMap();
        for (Map.Entry<Long, List<EricssonEventFile.TEventRecord>> entry : eventRecords.entrySet()) {
            long eventId = entry.getKey();
            List<EricssonEventFile.TEventRecord> records = entry.getValue();
            String channel_id = GET_ID_CHANNEL_MAP_ERICSSON_4G.get(eventId);

            if (channel_id == null || records.isEmpty()) {
                continue;
            }
            String header = GET_ID_CSV_HEADER_MAP_ERICSSON_4G.get(eventId);

            OutputChannel channel = decoderInput.getOutputChannel(channel_id);
            try (OutputStreamWriter writer = new OutputStreamWriter(channel.getOutputStream())) {
                if (headerEnable) {
                    writer.write(header);
                    writer.write('\n');
                }
                for (EricssonEventFile.TEventRecord eventRecord : records) {
                    writer.write(ericssonCsvWriterUtil.writeEricssonCsv4g(eventId, eventRecord, decoderInput, filenameTimeInfo));
                    writer.write('\n');
                }
            } catch (Exception e) {
                LOGGER.error("====== ERROR OCCURRED ======", e);
                e.printStackTrace();
            }
        }
    }
    public void processChannelForEricssonEvents5g(MergedCSVDecoderInput decoderInput,
                                                EricssonEventsReducer reducer,
                                                boolean headerEnable, DecoderOutput output,
                                                FilenameTimeInfo filenameTimeInfo) throws IOException {

        EricssonCsvWriterUtil ericssonCsvWriterUtil = new EricssonCsvWriterUtil();
        Map<Long, List<EricssonPmEventOuterClass.PmEvent>> eventRecords = reducer.getEricsson5gEventRecordsMap();

        for (Map.Entry<Long, List<EricssonPmEventOuterClass.PmEvent>> entry : eventRecords.entrySet()) {
            long eventId = entry.getKey();
            List<EricssonPmEventOuterClass.PmEvent> records = entry.getValue();
            String channel_id = GET_ID_CHANNEL_MAP_ERICSSON_5G.get(eventId);

            if (channel_id == null || records.isEmpty()) {
                continue;
            }

            String header = GET_ID_CSV_HEADER_MAP_ERICSSON_5G.get(eventId);

            OutputChannel channel = decoderInput.getOutputChannel(channel_id);
            try (OutputStreamWriter writer = new OutputStreamWriter(channel.getOutputStream())) {
                if (headerEnable) {
                    writer.write(header);
                    writer.write('\n');
                }
                for (EricssonPmEventOuterClass.PmEvent eventRecord : records) {
                    writer.write(ericssonCsvWriterUtil.writeEricssonCsv5g(eventId, eventRecord, decoderInput, filenameTimeInfo));
                    writer.write('\n');
                }

            } catch (Exception e) {
                LOGGER.error("====== ERROR OCCURRED ======", e);
                e.printStackTrace();
            }
        }
    }


}
