package com.altria.dialog.decoders.huawei;

import com.altria.dialog.decoders.common.*;
import com.altria.dialog.parsers.kaitai.huawei.HuaweiChrEventFile;
import com.altria.dialog.utils.HuaweiChrCsvWriterUtil;
import io.kaitai.struct.ByteBufferKaitaiStream;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.ZoneId;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import static com.altria.dialog.decoders.huawei.HuaweiEventsReducer.CSV_HEADER_4867;
import static com.altria.dialog.utils.EventIDUtils.*;

public class Huawei2MergedCSVDecoder extends DecoderBase {

    private static final Logger LOGGER = LogManager.getLogger(Huawei2MergedCSVDecoder.class);
//    public static final String ALL_CHANNEL = "all";
//
//    public static final String HUAWEI_4867_CHANNEL = "huawei_4867";

    @Override
    public DecoderOutput convert(DecoderInput input) {
        MergedCSVDecoderInput decoderInput = (MergedCSVDecoderInput) input;
        DecoderOutput output = new DecoderOutput(decoderInput);

        try {
            ByteBufferKaitaiStream kaitaiStream = new ByteBufferKaitaiStream(input.getInputBytes());
            try {
                HuaweiChrEventFile eventFile = new HuaweiChrEventFile(kaitaiStream);
                ZoneId zoneId = decoderInput.getTimeZoneId() == null ?
                        ConversionHelper.ZONE_COLOMBO : decoderInput.getTimeZoneId();
                String fileName = decoderInput.getFileName();
                boolean headerEnable = decoderInput.getHeaderOption();

                // Create reducer
                HuaweiEventsReducer reducer = new HuaweiEventsReducer(
                        eventFile.eventRecords(),
                        true,
                        decoderInput.getLookupServiceMap(),
                        zoneId,
                        fileName,
                        headerEnable
                );


                //Todo: uncomment 2024-04-19
                reducer.reduce();
                //now eventIdRecordMap from reducer contains event id, record map

//                reducer.mergeMaps();
                //Todo write to csv -hardcoded
                //need to correct writer
//                Set<Integer> usedEventIds = reducer.getEventIdRecordMap().keySet();
//                for (Integer eventId : usedEventIds) {
//                    String channelId = GET_ID_CHANNEL_MAP_HUAWEI.get(eventId);
//                    if (channelId == null) continue;
//
//                    String channelOutputFile = parentPath + "\\" + channelId + "_" + path.getFileName().toString();
//                    FileOutputStream f = new FileOutputStream(channelOutputFile);
//                    channelOutputStreams.put(channelId, f);
//
//                    input.addChannel(new OutputChannel(channelId, f))
//                            .addFileName(channelId, channelOutputFile);
//                }

                processChannelForEvents(decoderInput, reducer, headerEnable, output);

//                processChannel(HUAWEI_4867_CHANNEL, decoderInput, reducer, headerEnable, output);
//                processChannel(ALL_CHANNEL, decoderInput, reducer, headerEnable, output);

            } finally {
                kaitaiStream.close();
            }
        } catch (IOException ioe) {
            output.setStatus(Status.ERROR);
            output.setException(ioe);
        }

        return output;
    }

    private void processChannelForEvents(MergedCSVDecoderInput decoderInput, HuaweiEventsReducer reducer, boolean headerEnable, DecoderOutput output) throws IOException {
        Map<Integer, List<HuaweiEventsReducer.Tuple<HuaweiChrEventFile.TEventRecord, Long, Long, Long>>> eventRecords= reducer.getEventIdRecordMap();

        HuaweiChrCsvWriterUtil huaweiChrCsvWriterUtil = new HuaweiChrCsvWriterUtil();
        for(Map.Entry<Integer, List<HuaweiEventsReducer.Tuple<HuaweiChrEventFile.TEventRecord, Long, Long, Long>>> entry: eventRecords.entrySet()){
            int eventId = entry.getKey();
            List<HuaweiEventsReducer.Tuple<HuaweiChrEventFile.TEventRecord, Long, Long, Long>> records = entry.getValue();
            String channel_id = GET_ID_CHANNEL_MAP_HUAWEI.get(eventId);

            if (channel_id == null || records.isEmpty()) {
                continue;
            }

            String header = GET_ID_CSV_HEADER_MAP_HUAWEI.get(eventId);

            OutputChannel channel = decoderInput.getOutputChannel(channel_id);

            try (
                    OutputStreamWriter writer = new OutputStreamWriter(channel.getOutputStream());
            ) {
                if (headerEnable) {
                    writer.write(header);
                    writer.write('\n');
                }
                for (HuaweiEventsReducer.Tuple<HuaweiChrEventFile.TEventRecord, Long, Long, Long> eventRecord : records) {
                    writer.write(huaweiChrCsvWriterUtil.writeCsv(eventId, eventRecord, decoderInput));
                    writer.write('\n');
                }
                System.out.println("Completed" + eventId);

            } catch (Exception e) {
                LOGGER.error("====== ERROR OCCURRED ======", e);
                e.printStackTrace();
            }

        }
    }

//    private void processChannel(String channelId, MergedCSVDecoderInput decoderInput, HuaweiEventsReducer reducer, boolean headerEnable, DecoderOutput output) throws IOException {
//        OutputChannel channel = decoderInput.getOutputChannel(channelId);
//        if (channel != null) {
//            try (OutputStreamWriter writer = new OutputStreamWriter(channel.getOutputStream())) {
//                // Write channel-specific data
//                switch (channelId) {
//                    case HUAWEI_4867_CHANNEL:
//                        reducer.writeToCsv4867(decoderInput, CSV_HEADER_4867, writer, headerEnable);
//                        channel.setOutputRecordCount((int) reducer.getEventIdX1303M1InterFreqMdtListSize());
//                        channel.setRecordCount((int) reducer.getEventIdX1303M1InterFreqMdtListSize());
//                        break;
//                    case ALL_CHANNEL:
//                        List<MergedRecord> mergedRecords = reducer.getMergedRecords();
//                        if (headerEnable == true) {
//                            writer.write(MergedRecord.CSV_HEADER_NEWORDER2);
//                            writer.write('\n');
//                        }
//                        for (MergedRecord r : mergedRecords) {
//                            writer.write(r.toCSVOrder2());
//                            writer.write('\n');
//                        }
//                        channel.setRecordCount(reducer.getMergedRecords().size());
//                        channel.setOutputRecordCount(reducer.getMergedRecords().size());
//                        break;
//                }
//                channel.setLookupSuccessCount(reducer.getLookupSuccessCount());
//                channel.setLookupFailCount(reducer.getLookupFailCount());
//            }
//        }
//    }

}
