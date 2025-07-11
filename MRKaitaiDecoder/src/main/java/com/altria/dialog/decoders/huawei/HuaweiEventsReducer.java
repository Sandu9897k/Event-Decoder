package com.altria.dialog.decoders.huawei;

import com.altria.dialog.decoders.common.ConversionHelper;
import com.altria.dialog.decoders.common.OutputChannel;
import com.altria.dialog.decoders.common.RecordLookupService;
import com.altria.dialog.parsers.kaitai.huawei.HuaweiChrEventFile;
import com.altria.dialog.utils.EventIDUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static com.altria.dialog.utils.EventIDUtils.VALID_EVENT_IDS_HUAWEI_4G;

public class HuaweiEventsReducer {

    private static final Logger LOGGER = LogManager.getLogger(HuaweiEventsReducer.class);

    // Merged column definitions
    // ['MMES1APID', 'eNodeB_UE_SIAP_ID', 'User_Latitude_Sign', 'User_Latitude', 'User_Longitude', 'User_Altitude', 'TA', 'callid', 'Timestamp',
    //  'Serving_Cell_Id', 'Serving_Cell_EARFCN', 'Serving_Cell_Latitude', 'Serving_Cell_Longitude', 'Serving_Cell_RSRP', 'Serving_Cell_RSRQ',
    //      'Nbr_Cell_1_Id', 'Nbr_Cell_1_EARFCN', 'Nbr_Cell_1_Latitude', 'Nbr_Cell_1_Longitude', 'Nbr_Cell_1_RSRP', 'Nbr_Cell_1_RSRQ',
    //      'Nbr_Cell_2_Id', 'Nbr_Cell_2_EARFCN', 'Nbr_Cell_2_Latitude', 'Nbr_Cell_2_Longitude', 'Nbr_Cell_2_RSRP', 'Nbr_Cell_2_RSRQ',
    //      'Nbr_Cell_3_Id', 'Nbr_Cell_3_EARFCN', 'Nbr_Cell_3_Latitude', 'Nbr_Cell_3_Longitude', 'Nbr_Cell_3_RSRP', 'Nbr_Cell_3_RSRQ',
    //      'Nbr_Cell_4_Id', 'Nbr_Cell_4_EARFCN', 'Nbr_Cell_4_Latitude', 'Nbr_Cell_4_Longitude', 'Nbr_Cell_4_RSRP', 'Nbr_Cell_4_RSRQ',
    //      'Nbr_Cell_5_Id', 'Nbr_Cell_5_EARFCN', 'Nbr_Cell_5_Latitude', 'Nbr_Cell_5_Longitude', 'Nbr_Cell_5_RSRP', 'Nbr_Cell_5_RSRQ',
    //      'Nbr_Cell_6_Id', 'Nbr_Cell_6_EARFCN', 'Nbr_Cell_6_Latitude', 'Nbr_Cell_6_Longitude', 'Nbr_Cell_6_RSRP', 'Nbr_Cell_6_RSRQ']

    // [98568893, 1492494, nan, nan, nan, nan, 240, 171531812, 1612732781391, 5551617, 1650.0, 0, 0, 43, 20, 5551636, 1650.0, 0, 0, 38, 14, 5321217, 1650.0, 0, 0, 34, 22, None, None, None, None, None, None, None, None, None, None, None, None, None, None, None, None, None, None, None, None, None, None, None, None]

    public static final String CSV_HEADER_4867 =
            "Datetime,MMES1APID,Serving_Cell_Id,Serving_Cell_EARFCN,Serving_Cell_RSRP,Serving_Cell_RSRQ," +
                    "Nbr_Cell_1_Id,Nbr_Cell_1_EARFCN,Nbr_Cell_1_CARRIER_FREQUENCY,Nbr_Cell_1_RSRP,Nbr_Cell_1_RSRQ," +
                    "Nbr_Cell_2_Id,Nbr_Cell_2_EARFCN,Nbr_Cell_2_CARRIER_FREQUENCY,Nbr_Cell_2_RSRP,Nbr_Cell_2_RSRQ," +
                    "Nbr_Cell_3_Id,Nbr_Cell_3_EARFCN,Nbr_Cell_3_CARRIER_FREQUENCY,Nbr_Cell_3_RSRP,Nbr_Cell_3_RSRQ," +
                    "Nbr_Cell_4_Id,Nbr_Cell_4_EARFCN,Nbr_Cell_4_CARRIER_FREQUENCY,Nbr_Cell_4_RSRP,Nbr_Cell_4_RSRQ," +
                    "Nbr_Cell_5_Id,Nbr_Cell_5_EARFCN,Nbr_Cell_5_CARRIER_FREQUENCY,Nbr_Cell_5_RSRP,Nbr_Cell_5_RSRQ," +
                    "Nbr_Cell_6_Id,Nbr_Cell_6_EARFCN,Nbr_Cell_6_CARRIER_FREQUENCY,Nbr_Cell_6_RSRP,Nbr_Cell_6_RSRQ," +
                    "Nbr_Cell_7_Id,Nbr_Cell_7_EARFCN,Nbr_Cell_7_CARRIER_FREQUENCY,Nbr_Cell_7_RSRP,Nbr_Cell_7_RSRQ," +
                    "Nbr_Cell_8_Id,Nbr_Cell_8_EARFCN,Nbr_Cell_8_CARRIER_FREQUENCY,Nbr_Cell_8_RSRP,Nbr_Cell_8_RSRQ," +
                    "Location_Present,Shape_Type,User_Latitude,User_Longitude,User_Altitude,Geo_Hash,Call_Id,";
//    public static final int EVENT_ID_x1001_PUBLIC_INFORMATION = 4097;
//    public static final int EVENT_ID_x1202_PERIOD_INTRA_FREQ_MEASUREMENT = 4610;
//    public static final int EVENT_ID_x1302_PERIOD_INTRA_FREQ_MR_MDT = 4866;
//    public static final int EVENT_ID_x1212_PERIOD_PRIVATE_UE_TA_MDT = 4626;
//    public static final int EVENT_ID_x1211_PERIOD_UE_TA_MR = 4625;
//    public static final int EVENT_ID_x1303_M1_INTER_FREQ_MDT = 4867;
//    public static final int EVENT_ID_x1304_M2_PERIOD_PRIVATE_UE_MEAS_MDT = 4868;
//    public static final int EVENT_ID_x1306_M4_PERIOD_PRIVATE_THROUGHPUT_MDT = 4870;
//    public static final int EVENT_ID_x1307_M5_PERIOD_PRIVATE_THROUGHPUT_MDT = 4871;
//    public static final int  EVENT_ID_x1308_RLF_REPORT = 4872;
//    public static final int  EVENT_ID_x1309_PERIOD_PRIVATE_CONNEST_FAIL_REPORT = 4873;
//    public static final int  EVENT_ID_x1312_PERIOD_UE_UL_PDCP_DELAY_MDT = 4882;
//    public static final int  EVENT_ID_x1314_PERIOD_PRIVATE_PKTLOSS_RATE_MR = 4884;
//    public static final int  EVENT_ID_x1321_PERIOD_PRIVATE_UE_MEAS_M2_EXT_MDT=  4897;
//    public static final int  EVENT_ID_x1322_PERIOD_PRIVATE_THROUGHPUT_MEAS_M5_EXT_MDT = 4898;
//    public static final int  EVENT_ID_x1205_UE_PERIOD_RADIO_LINK_MR= 4613;
    //Todo add new event-added
    public static final int TOTAL_NBR_CELL_COUNT = 6;
    public static final int TOTAL_NBR_CELL_COUNT_ORDER2 = 8;


    private ArrayList<HuaweiChrEventFile.TEventRecord> eventRecords;
    private boolean requiredNull = true;
    private RecordLookupService pciLookupService;
    private RecordLookupService earfcnLookupService;
    private List<MergedRecord> mergedRecords;
    private ZoneId zoneId;
    private String fileName;
    private boolean headerEnable;
    private HashSet<String> nbrKeyFoundMap = new HashSet<String>();
    private HashSet<String> nbrKeyNotFoundMap = new HashSet<String>();

    private final HashMap<Long, long[]> mtmsiMap = new HashMap<>();
    private final PowerMap<PowerMapValue> powerMap = new PowerMap<>();
    private final PowerMap<Long> delayMap = new PowerMap();

    private final ArrayList<Tuple<HuaweiChrEventFile.TEventRecord, Long, Long, Long>> eventIdX1303M1InterFreqMdtList = new ArrayList<>();
    private final Map<Integer, List<Tuple<HuaweiChrEventFile.TEventRecord, Long, Long, Long>>> eventIdRecordMap = new HashMap<>();


    public class Tuple<EventRecord, TimeStamp, ServCellId, CallId> {
        public final EventRecord eventRecord;
        public final TimeStamp timeStamp;
        public final ServCellId servCellId;
        public final CallId callId;

        public Tuple(EventRecord eventRecord, TimeStamp timeStamp, ServCellId servCellId, CallId callId) {
            this.eventRecord = eventRecord;
            this.timeStamp = timeStamp;
            this.servCellId = servCellId;
            this.callId = callId;
        }
    }

    public HuaweiEventsReducer(ArrayList<HuaweiChrEventFile.TEventRecord> eventRecords,
                               boolean requiredNull,
                               HashMap<String, RecordLookupService> lookupServiceMap,
                               ZoneId zoneId,
                               String fileName,
                               boolean headerEnable) {
        this.eventRecords = eventRecords;
        this.requiredNull = requiredNull;

        this.pciLookupService = lookupServiceMap.get(HuaweiConstants.PCI_LOOKUP_SERVICE);
        this.earfcnLookupService = lookupServiceMap.get(HuaweiConstants.EARFCN_LOOKUP_SERVICE);
        this.zoneId = zoneId;
        this.fileName = fileName;
        this.headerEnable = headerEnable;
    }

    public void mergeMaps() {
        UUID fileId = UUID.randomUUID();
        long rid = 1;
        String escapedFileName = "\"" + fileName + "\"";
        List<MergedRecord> records = new ArrayList<>();
        for (Long callId : this.powerMap.callIdKeys()) {
            long[] mtmsiTuple = mtmsiMap.get(callId);
            if (mtmsiTuple == null) continue;
            // The following logic is not verified yet as the original code has a bug
            Set<Long> delayMapServSellIds = this.delayMap.servCellIdKeys(callId);

            for (Long servCellId : this.powerMap.servCellIdKeys(callId)) {
                if (!delayMapServSellIds.contains(servCellId)) continue;

                for (Long powerTimeStamp : this.powerMap.timestampKeys(callId, servCellId)) {
                    Set<Long> delayTimestamps = this.delayMap.timestampKeys(callId, servCellId);
                    Long delayTimestamp = ConversionHelper.minGapValue(delayTimestamps, powerTimeStamp);
                    PowerMapValue powerEvent = this.powerMap.get(callId, servCellId, powerTimeStamp);
                    Long delayEvent = this.delayMap.get(callId, servCellId, delayTimestamp);
                    UserLocation userLocation = powerEvent.getUserLocation();

                    MergedRecord record = new MergedRecord();
                    record.setRid(rid);
                    record.setMtmsi(mtmsiTuple[0]);
                    record.setMtmsi2(mtmsiTuple[1]);
                    record.setDelayEvent(delayEvent);

                    if (!userLocation.isEmpty()) {
                        float userLat = ConversionHelper.convertLatitude(userLocation.getDegreesLatitude(), userLocation.getLatitudeSign());
                        float userLon = ConversionHelper.convertLongitude(userLocation.getDegreesLongitude());
                        float userAlt = userLocation.getAltitude() * (userLocation.getAltitudeDirection() == 0 ? 1 : -1);
                        record.setUserLatSign(userLocation.getLatitudeSign());
                        record.setUserLatitude(userLat);
                        record.setUserLongitude(userLon);
                        record.setUserAltitude(userAlt);
                        record.setGeoHash(ConversionHelper.generateGeoHash(userLat, userLon));
                    }

                    record.setCallId(callId);
                    record.setPowerTimeStamp(powerTimeStamp);
                    record.setPowerDateTime(ConversionHelper.convertTimestampToDateTimeOfZone(powerTimeStamp, this.zoneId));
                    record.setServiceCellId(servCellId);
                    record.setServiceEARFCN(powerEvent.getServEARFCN());
                    record.setLatitude(0.0f);
                    record.setLongitude(0.0f);
                    record.setServiceCellRsrp(powerEvent.getServCellRsrp());
                    record.setServiceCellRsrq(powerEvent.getServCellRsrq());
                    record.setFileName(escapedFileName);
                    record.setFileId(fileId);

                    List<MergedRecord.NbrRecord> nbrRecords = record.getNbrRecords();
                    for (CellInfo nbrCell : powerEvent.getOutputCellArray()) {
                        MergedRecord.NbrRecord nbrRecord = new MergedRecord.NbrRecord();
                        nbrRecord.setCellId(nbrCell.getCurrentCI());
                        nbrRecord.setEarfcn(nbrCell.getEARFCN());
                        nbrRecord.setLat(0.0f);
                        nbrRecord.setLon(0.0f);
                        nbrRecord.setRsrp(nbrCell.getRsrp());
                        nbrRecord.setRsrq(nbrCell.getRsrq());
                        nbrRecords.add(nbrRecord);
                    }

                    // Add empty nbr records up to TOTAL_NBR_CELL_COUNT or TOTAL_NBR_CELL_COUNT_ORDER2
                    // Existing logic utils.py new_order2 has 7 and 8
                    int emptyNbrCellCount = TOTAL_NBR_CELL_COUNT_ORDER2 - powerEvent.getOutputCellArray().size();
                    if (emptyNbrCellCount > 0) {
                        nbrRecords.addAll(IntStream.range(0, emptyNbrCellCount)
                                .mapToObj(i -> new MergedRecord.NbrRecord())
                                .collect(Collectors.toList()));
                    }
                    records.add(record);
                    rid += 1;
                }
            }
        }
        // System.out.println(records.size());
        this.mergedRecords = records;
    }

    public Map<Integer, List<Tuple<HuaweiChrEventFile.TEventRecord, Long, Long, Long>>> getEventIdRecordMap() {
        return eventIdRecordMap;
    }

    public List<MergedRecord> getMergedRecords() {
        return mergedRecords;
    }

    public int getLookupSuccessCount() {
        return nbrKeyFoundMap.size();
    }

    public int getLookupFailCount() {
        return nbrKeyNotFoundMap.size();
    }


    public void reduce() {
        for (HuaweiChrEventFile.TEventRecord event : this.eventRecords) {
            HuaweiChrEventFile.TChrHeader chrHeader = event.chrHeader();

            if (chrHeader.datetimeDay() > 31 || chrHeader.datetimeMillisecond() >= 1000) {
                // Ignore this record
                continue;
            }

            int eventId = chrHeader.eventId();
            long callId = chrHeader.callId();
            long servCellId = chrHeader.eNodeBid() * 256 + chrHeader.cellId();
            // Header time is in UTC - Developer Guide page 8
            long timestamp = this.calculateTimeStamp(chrHeader);

            if (timestamp < 0) {
                // Wrongly decoded event found skipping
                continue;
            }
            //Todo:04-19

            if (VALID_EVENT_IDS_HUAWEI_4G.contains((eventId))){
                Tuple<HuaweiChrEventFile.TEventRecord, Long, Long, Long> tuple = new Tuple<>(event, timestamp, servCellId, callId);
                eventIdRecordMap
                        .computeIfAbsent(eventId, k -> new ArrayList<>())
                        .add(tuple);
            }
        }
    }

    //added by Sanduni on 09/04/2024
    private void extractEventType4867(long callId, long servCellId, long timestamp, HuaweiChrEventFile.TEventRecord event) {
        eventIdX1303M1InterFreqMdtList.add(new Tuple<>(event, timestamp, servCellId, callId));
    }

    private void extractEventType4626(long callId, long servCellId, long timestamp, HuaweiChrEventFile.TEventRecord event) {
        HuaweiChrEventFile.TPeriodUeTaMdt body = event.periodUeTaMdt();
        delayMap.put(callId, servCellId, timestamp, body.ta());
    }

    private void extractEventType4625(long callId, long servCellId, long timestamp, HuaweiChrEventFile.TEventRecord event) {
        //System.out.println("Added Event ID 4625 on 25th October 2023 by Dulanjali");
        HuaweiChrEventFile.TPeriodUeTaMr body = event.periodUeTaMr();
        delayMap.put(callId, servCellId, timestamp, body.ta());
    }

    private void extractEventType4866(long callId, long servCellId, long timestamp, HuaweiChrEventFile.TEventRecord event) {
        HuaweiChrEventFile.TM1IntraFreqMdt body = event.m1IntraFreqMdt();
        int cellCount = body.nCellCount();
        if (cellCount <= 0) {
            return;
        }

        UserLocation userLocation = null;

        if (body.locationInfoPresent() == 1) {
            if (body.shapeType() == 2) {
                HuaweiChrEventFile.TEllipsoidPointWithAltitudeInfo shape = body.ellipsoidPointWithAltitudeInfo();
                userLocation = new UserLocation(shape.degreesLatitude(),
                        shape.degreesLongitude(),
                        shape.latitudeSign(),
                        shape.altitude(),
                        shape.altitudeDirection());
            } else if (body.shapeType() == 5) {
                HuaweiChrEventFile.TEllipsoidPointWithAltitudAndUncertaintyEllipsoidInfo shape = body.ellipsoidPointWithAltitudAndUncertaintyEllipsoidInfo();
                userLocation = new UserLocation(shape.degreesLatitude(),
                        shape.degreesLongitude(),
                        shape.latitudeSign(),
                        shape.altitude(),
                        shape.altitudeDirection());
            } else if (this.requiredNull) {
                userLocation = new UserLocation();
            } else {
                return;
            }
        } else if (this.requiredNull) {
            userLocation = new UserLocation();
        } else {
            return;
        }

        ArrayList<HuaweiChrEventFile.TM1IntraFreqMdtCellInfo> cellArray = body.cellInfoList();
        ArrayList<CellInfo> outputCellArray = new ArrayList<>(cellCount);
        Map<String, String> earfcnValue = this.earfcnLookupService.lookup(Long.toString(servCellId));
        if (earfcnValue == null) {
            // TODO: Didn't find the value, return or use default value
            return;
        }
        int servEARFCN = Integer.parseInt(earfcnValue.get(HuaweiConstants.EARFCN_LOOKUP_FIELD_EARFCN));
        // Resolving cells
        for (int i = 0; i < cellCount; i++) {
            HuaweiChrEventFile.TM1IntraFreqMdtCellInfo cellInfo = cellArray.get(i);
            int pci = cellInfo.pci();
            // since intra nbr_EARFCN==serv_EARFCN
            String key = String.format("%d_%d", servCellId, pci);
            // System.out.println("PCIKEY: " + key);
            Map<String, String> cellValue = this.pciLookupService.lookup(key);
            if (cellValue == null) {
                nbrKeyNotFoundMap.add(key);
                continue;
            }
            int nbrCellId = Integer.parseInt(cellValue.get(HuaweiConstants.PCI_LOOKUP_FIELD_NBR_CELL_ID));
            outputCellArray.add(new CellInfo(servEARFCN, nbrCellId, pci, cellInfo.rsrp(), cellInfo.rsrq()));
            nbrKeyFoundMap.add(key);
        }

        int servCellRsrp = body.servingCellRsrp();
        int servCellRsrq = body.servingCellRsrq();
        PowerMapValue powerMapValue = new PowerMapValue(servCellRsrp,
                servCellRsrq,
                outputCellArray,
                userLocation,
                servEARFCN);

        powerMap.put(callId, servCellId, timestamp, powerMapValue);
    }

    private void extractEventType4610(long callId, long servCellId, long timestamp, HuaweiChrEventFile.TEventRecord event) {
        HuaweiChrEventFile.TPeriodIntraFrepMeasurement body = event.periodIntraFrepMr();
        int cellCount = body.nCellCount();
        if (cellCount <= 0 || !this.requiredNull) {
            return;
        }
        UserLocation userLocation = new UserLocation();
        ArrayList<HuaweiChrEventFile.TENcellInfo> cellArray = body.cellInfoList();
        ArrayList<CellInfo> outputCellArray = new ArrayList<>(cellCount);

        Map<String, String> earfcnValue = this.earfcnLookupService.lookup(Long.toString(servCellId));
        if (earfcnValue == null) {
            // Didn't find the value
            return;
        }

        int servEARFCN = Integer.parseInt(earfcnValue.get(HuaweiConstants.EARFCN_LOOKUP_FIELD_EARFCN));

        // Resolving cells
        for (int i = 0; i < cellCount; i++) {
            HuaweiChrEventFile.TENcellInfo cellInfo = cellArray.get(i);
            int pci = cellInfo.pci();
            // Since intra nbr_EARFCN==serv_EARFCN
            String key = String.format("%d_%d", servCellId, pci);
            // System.out.println("PCIKEY: " + key);
            Map<String, String> cellValue = this.pciLookupService.lookup(key);
            if (cellValue == null) {
                nbrKeyNotFoundMap.add(key);
                continue;
            }

            int nbrCellId = Integer.parseInt(cellValue.get(HuaweiConstants.PCI_LOOKUP_FIELD_NBR_CELL_ID));
            outputCellArray.add(new CellInfo(servEARFCN, nbrCellId, pci, cellInfo.rsrp(), cellInfo.rsrq()));
            nbrKeyFoundMap.add(key);
        }

        int servCellRsrp = body.rsrpRslt();
        int servCellRsrq = body.rsrqRslt();
        PowerMapValue powerMapValue = new PowerMapValue(servCellRsrp,
                servCellRsrq,
                outputCellArray,
                userLocation,
                servEARFCN);

        powerMap.put(callId, servCellId, timestamp, powerMapValue);
    }

    private void extractEventType4097(long callId, HuaweiChrEventFile.TEventRecord event) {
        HuaweiChrEventFile.TPublicInformation body = event.publicInformation();
        long mtmsi = body.mmeUeS1apId();
        long mtmsi2 = body.enodebUeSiapId();
        long[] pair = {mtmsi, mtmsi2};
        this.mtmsiMap.put(callId, pair);
    }


    /**
     * Give a header return the timestamp in milliseconds
     *
     * @param chrHeader
     */
    private long calculateTimeStamp(HuaweiChrEventFile.TChrHeader chrHeader) {
        return ConversionHelper.convertDateTime2Timestamp(
                chrHeader.datetimeYear(),
                chrHeader.datetimeMonth(),
                chrHeader.datetimeDay(),
                chrHeader.datetimeHour(),
                chrHeader.datetimeMinute(),
                chrHeader.datetimeSecond(),
                chrHeader.datetimeMillisecond());
    }

    public long getEventIdX1303M1InterFreqMdtListSize() {
        return eventIdX1303M1InterFreqMdtList.size();
    }

    //added by Sanduni on 09/04/2024
    public void writeToCsv4867(MergedCSVDecoderInput decoderInput, String csvHeader, Writer writer, Boolean headerEnable) throws IOException {

        if (eventIdX1303M1InterFreqMdtList.size() == 0) {
            return;
        }

        if (headerEnable) {
            writer.write(CSV_HEADER_4867 + '\n');
        }
        for (Tuple<HuaweiChrEventFile.TEventRecord, Long, Long, Long> tuple : eventIdX1303M1InterFreqMdtList) {
            writer.write(this.toCSVOrderEvent4867(tuple));
            writer.write('\n');
        }


//        OutputChannel outputChannel = decoderInput.getOutputChannel(Huawei2MergedCSVDecoder.HUAWEI_4867_CHANNEL);
//        OutputStream outStream = outputChannel.getOutputStream();
//
//        try (
////                FileOutputStream fOut4867huawei = new FileOutputStream(decoderInput.getOutputFile(Huawei2MergedCSVDecoder.HUAWEI_4897_CHANNEL));
////                OutputStreamWriter writerHuawei4867 = new OutputStreamWriter(fOut4867huawei)
//                OutputStreamWriter writerHuawei4867 = new OutputStreamWriter(outStream);
//        ) {
//            if (headerEnable) {
//                writerHuawei4867.write(CSV_HEADER_4867 + '\n');
//            }
//            for (Tuple<HuaweiChrEventFile.TEventRecord, Long, Long, Long> tuple : eventIdX1303M1InterFreqMdtList) {
//                writerHuawei4867.write(this.toCSVOrderEvent4867(tuple));
//                writerHuawei4867.write('\n');
//            }
//
//        } catch (Exception e) {
//            LOGGER.error("====== ERROR OCCURRED ======", e);
//            e.printStackTrace();
//        }
    }

    //added by Sanduni on 09/04/2024
    public String toCSVOrderEvent4867(Tuple<HuaweiChrEventFile.TEventRecord, Long, Long, Long> event4897Tuple) {
        HuaweiChrEventFile.TM1InterFreqMdt body = event4897Tuple.eventRecord.m1InterFreqMdt();
        LocalDateTime time = (ConversionHelper.convertTimestampToDateTimeOfZone(event4897Tuple.timeStamp, this.zoneId));

        long servCellId = event4897Tuple.servCellId;
        long callId = event4897Tuple.callId;
        Map<String, String> earfcnValue = this.earfcnLookupService.lookup(Long.toString(servCellId));
        String servEARFCN = "";
        if (earfcnValue != null) {
            servEARFCN = Objects.toString(Integer.parseInt(earfcnValue.get(HuaweiConstants.EARFCN_LOOKUP_FIELD_EARFCN)), "");
        }

        StringBuilder b = new StringBuilder();
        b.append(time == null ? "" : time.format(ConversionHelper.HUAWEI_DATETIME_FORMATTER)).append(",");// Datetime
        b.append(Objects.toString(body.measurementId(), "")).append(",");
        b.append(Objects.toString(servCellId, "")).append(",");
        b.append(servEARFCN).append(",");
        b.append(Objects.toString(body.servingCellRsrp(), "")).append(",");
        b.append(Objects.toString(body.servingCellRsrq(), "")).append(",");

        int cellCount = body.nCellCount();

        for (int i = 0; i < cellCount; i++) {
            b.append(Objects.toString(body.cellInfoList().get(i).cellId(), "")).append(",");
            b.append(Objects.toString(body.cellInfoList().get(i).pci(), "")).append(",");
            b.append(Objects.toString(body.cellInfoList().get(i).carrierFrequency(), "")).append(",");
            b.append(Objects.toString(body.cellInfoList().get(i).rsrp(), "")).append(",");
            b.append(Objects.toString(body.cellInfoList().get(i).rsrq(), "")).append(",");
        }

        for (int j = 0; j < TOTAL_NBR_CELL_COUNT_ORDER2 - cellCount; j++) {
            b.append(",,,,,");
        }

        b.append(Objects.toString(body.locationInfoPresent(), "")).append(",");
        b.append(Objects.toString(body.shapeType(), "")).append(",");

        UserLocation userLocation = null;

        if (body.locationInfoPresent() == 1) {
            if (body.shapeType() == 2) {
                HuaweiChrEventFile.TEllipsoidPointWithAltitudeInfo shape = body.ellipsoidPointWithAltitudeInfo();
                userLocation = new UserLocation(shape.degreesLatitude(),
                        shape.degreesLongitude(),
                        shape.latitudeSign(),
                        shape.altitude(),
                        shape.altitudeDirection());
            } else if (body.shapeType() == 5) {
                HuaweiChrEventFile.TEllipsoidPointWithAltitudAndUncertaintyEllipsoidInfo shape = body.ellipsoidPointWithAltitudAndUncertaintyEllipsoidInfo();
                userLocation = new UserLocation(shape.degreesLatitude(),
                        shape.degreesLongitude(),
                        shape.latitudeSign(),
                        shape.altitude(),
                        shape.altitudeDirection());
            }
        }

        if (userLocation == null) {
            b.append(",,,,");

        } else {
            float userLat = ConversionHelper.convertLatitude(userLocation.getDegreesLatitude(), userLocation.getLatitudeSign());
            float userLon = ConversionHelper.convertLongitude(userLocation.getDegreesLongitude());
            float userAlt = userLocation.getAltitude() * (userLocation.getAltitudeDirection() == 0 ? 1 : -1);
            String geoHash = ConversionHelper.generateGeoHash(userLat, userLon);

            b.append(Objects.toString(userLat, "")).append(",");
            b.append(Objects.toString(userLon, "")).append(",");
            b.append(Objects.toString(userAlt, "")).append(",");
            b.append(geoHash).append(",");
        }
        b.append(Objects.toString(callId, "")).append(",");

        return b.toString();
    }
}

