package com.altria.dialog.decoders.ericsson;

import com.altria.dialog.decoders.common.CollectionHelper;
import com.altria.dialog.decoders.common.ConversionHelper;
import com.altria.dialog.decoders.common.OutputChannel;
import com.altria.dialog.decoders.common.RecordLookupService;
import com.altria.dialog.parsers.kaitai.ericsson.EricssonEventFile;
import com.altria.dialog.parsers.kaitai.ericsson.EricssonEventFile.TEventRecord;
import com.altria.dialog.parsers.proto.ericsson.EricssonPmEventOuterClass;
import com.altria.dialog.utils.EricssonCsvWriterUtil;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.time.Duration;
import java.time.LocalTime;
import java.time.temporal.ChronoUnit;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static com.altria.dialog.constant.AppConstant.NETWORK_TYPE_4G;
import static com.altria.dialog.constant.AppConstant.NETWORK_TYPE_5G;
import static com.altria.dialog.utils.EventIDUtils.VALID_EVENT_IDS_ERICSSON_4G;
import static com.altria.dialog.utils.EventIDUtils.VALID_EVENT_IDS_ERICSSON_5G;

public class EricssonEventsReducer {

    private EricssonCsvWriterUtil ericssonCsvWriterUtil;

    public static final String CSV_HEADER_3112_LOC = "Datetime,Within_Start_&_End_Time,Global_Cell_Id,MMES1APID,Serving_Cell_RSRP,Serving_Cell_RSRQ," +
            "Mdt_M1_Frequency,Mdt_M1_Horizontal_Velocity_Bearing,Mdt_M1_Horizontal_Velocity_Horizontal_Speed,Mdt_M1_Horizontal_Velocity_Spare,Mdt_M1_Gnss_Tod_Msec," +
            "Physical_Cell_1_Id,Nbr_Cell_1_RSRP,Nbr_Cell_1_RSRQ," +
            "Physical_Cell_2_Id,Nbr_Cell_2_RSRP,Nbr_Cell_2_RSRQ," +
            "Physical_Cell_3_Id,Nbr_Cell_3_RSRP,Nbr_Cell_3_RSRQ," +
            "Physical_Cell_4_Id,Nbr_Cell_4_RSRP,Nbr_Cell_4_RSRQ," +
            "Physical_Cell_5_Id,Nbr_Cell_5_RSRP,Nbr_Cell_5_RSRQ," +
            "Physical_Cell_6_Id,Nbr_Cell_6_RSRP,Nbr_Cell_6_RSRQ," +
            "Physical_Cell_7_Id,Nbr_Cell_7_RSRP,Nbr_Cell_7_RSRQ," +
            "Physical_Cell_8_Id,Nbr_Cell_8_RSRP,Nbr_Cell_8_RSRQ," +
            "Shape_Type,User_Latitude,User_Longitude,User_Altitude,Geo_Hash,Callid,eNodeBUESIAPId";

    private final ArrayList<TEventRecord> eventId3112LocList = new ArrayList<>();

    public Map<Long, List<TEventRecord>> getEricssonEventRecordsMap() {
        return ericssonEventRecordsMap;
    }

    private final Map<Long, List<EricssonEventFile.TEventRecord>> ericssonEventRecordsMap = new HashMap<>();
    private ArrayList<TEventRecord> eventRecords;
    private FilenameTimeInfo filenameTimeInfo;
    private SessionMap sessions;
    private String fileName;
    private UUID fileId = UUID.randomUUID();
    private long rid = 1;
    private HashSet<String> nbrKeyFoundMap = new HashSet<String>();
    private HashSet<String> nbrKeyNotFoundMap = new HashSet<String>();
    private ArrayList<EricssonPmEventOuterClass.PmEvent> eventRecords5G;
    private ByteArrayInputStream inputStream5g;

    public Map<Long, List<EricssonPmEventOuterClass.PmEvent>> getEricsson5gEventRecordsMap() {
        return ericsson5gEventRecordsMap;
    }

    private final Map<Long, List<EricssonPmEventOuterClass.PmEvent>> ericsson5gEventRecordsMap = new HashMap<>();

    public List<MergedRecord> getMergedRecords() {
        return mergedRecords;
    }

    public int getLookupSuccessCount() {
        return nbrKeyFoundMap.size();
    }

    public int getLookupFailCount() {
        return nbrKeyNotFoundMap.size();
    }


    private List<MergedRecord> mergedRecords;
    private RecordLookupService nbrLookupService;

    private static Comparator<AbstractMap.SimpleEntry<LocalTime, ?>> localTimeComparator = Comparator.comparing(AbstractMap.SimpleEntry::getKey);

    public EricssonEventsReducer(ArrayList<TEventRecord> eventRecords, String filename) {
        this.eventRecords = eventRecords;
        this.filenameTimeInfo = FilenameTimeInfo.build(filename);
        this.fileName = filename;
    }

    public EricssonEventsReducer(ByteArrayInputStream inputStream5g, String fileName) {
        this.inputStream5g = inputStream5g;
        this.filenameTimeInfo = FilenameTimeInfo.build(fileName);
    }


    public void add5GEvents(EricssonPmEventOuterClass.PmEvent event) {
        eventRecords5G.add(event);
    }


    public void lookupAndAppendGlobalCellId() {
        List<MergedRecord> mergedRecords = this.mergedRecords;
        for (MergedRecord record : mergedRecords) {
            lookupAndAppendGlobalCellId(record);
        }
    }

    private void lookupAndAppendGlobalCellId(MergedRecord record) {
        record.setENBID(record.getServingCellId() / 256);

        for (int id = 1; id <= MergedRecord.MAX_NBR_CELL_DATA_SIZE; id++) {
            NbrCellData nbrCellData = record.getNbrCellData(id);
            if (nbrCellData.getNbrCellPCI() != null && nbrCellData.getNbrCellPCI() == ConversionHelper.TWO_BYTE_INVALID_VALUE) {
                nbrCellData.setNbrCellPCI(null);
            }

            if (nbrCellData.getNbrCellRSRP() != null && nbrCellData.getNbrCellRSRP() == ConversionHelper.ONE_BYTE_INVALID_VALUE) {
                nbrCellData.setNbrCellRSRP(null);
            }

            if (nbrCellData.getNbrCellRSRQ() != null && nbrCellData.getNbrCellRSRQ() == ConversionHelper.ONE_BYTE_INVALID_VALUE) {
                nbrCellData.setNbrCellRSRQ(null);
            }

            if (nbrCellData.getNbrCellPCI() != null) {
                String key = String.format("%d_%d_%d", record.geteNBId(), record.getServingCellEARFCN(), nbrCellData.getNbrCellPCI());
                Map<String, String> lookupRecord = this.nbrLookupService.lookup(key);
                if (lookupRecord != null && lookupRecord.containsKey(EricssonConstants.NBR_LOOKUP_GLOBAL_CELL_ID)) {
                    nbrCellData.setNbrCellId(Integer.parseInt(lookupRecord.get(EricssonConstants.NBR_LOOKUP_GLOBAL_CELL_ID)));
                    nbrKeyFoundMap.add(key);
                } else {
                    nbrKeyNotFoundMap.add(key);
                }

            }
        }
    }

    public void buildSessions(String networkType) throws IOException {
        if (networkType.equals(NETWORK_TYPE_4G)) {
            for (TEventRecord event : this.eventRecords) {
                long eventId = event.eventHeader().eventId();
                if (VALID_EVENT_IDS_ERICSSON_4G.contains(eventId)) {
                    List<EricssonEventFile.TEventRecord> eventRecords = ericssonEventRecordsMap.getOrDefault(eventId, new ArrayList<>());
                    eventRecords.add(event);
                    ericssonEventRecordsMap.put(eventId, eventRecords);
                }
            }
        } else if (networkType.equals(NETWORK_TYPE_5G)) {
            EricssonPmEventOuterClass.PmEvent event;
            while ((event = EricssonPmEventOuterClass.PmEvent.parseDelimitedFrom(inputStream5g)) != null) {
                if (event.getGroupValue() == 3) {
                    long eventId = event.getEventId();
                    if (VALID_EVENT_IDS_ERICSSON_5G.contains(eventId)) {
                        List<EricssonPmEventOuterClass.PmEvent> eventRecords5g = ericsson5gEventRecordsMap.getOrDefault(eventId, new ArrayList<>());
                        eventRecords5g.add(event);
                        ericsson5gEventRecordsMap.put(eventId, eventRecords5g);
                    }

                }
            }

        }

    }

//    public void buildCsvListWithTA() {
//        List<MergedRecord> outputRecords = new ArrayList<>();
//
//        List<Event3112BodyWrapper> recordsWithTA = this.buildRecordsWithTACombined();
//        for (Event3112BodyWrapper wrapper : recordsWithTA) {
//            EricssonEventFile.TEvent3112Body record = wrapper.getRecord();
//            int shapeType = record.mdtM1LocationCoordinates();
//            LocationPart locationPart;
//            if (shapeType != ConversionHelper.ONE_BYTE_INVALID_VALUE) {
//                locationPart = this.findLocationPart(record, shapeType);
//            } else {
//                locationPart = new LocationPart(); // Empty dummy
//            }
//            wrapper.setLocation(locationPart);
//            MergedRecord csvRecord = buildCsvRecord(wrapper);
//
//            String ymd = buildDateTime(csvRecord, this.filenameTimeInfo);
//            if (ymd.compareTo(this.filenameTimeInfo.getStartYmd()) > 0 && ymd.compareTo(this.filenameTimeInfo.getEndYmd()) < 0) {
//                csvRecord.setDatetimeStr(ymd);
//                // We can call lookupAndAppendGlobalCellId(MergedRecord record) here to avoid unnecessary loop again if needed
//                // lookupAndAppendGlobalCellId(csvRecord);
//                csvRecord.setRid(rid);
//                outputRecords.add(csvRecord);
//                rid += 1;
//            }
//        }
//
//        this.mergedRecords = outputRecords;
//    }

    private String buildDateTime(MergedRecord csvRecord, FilenameTimeInfo fti) {
        int hour = ((csvRecord.getHour() + fti.getHourInc()) +
                ((csvRecord.getMinute() + fti.getMinuteInc()) / 60)) % 24;
        int minute = (csvRecord.getMinute() + fti.getMinuteInc()) % 60;
        int second = csvRecord.getSecond();
        int millisecond = csvRecord.getMillisecond();

        String ymd = String.format("%s-%s-%s %02d:%02d:%02d.%03d",
                fti.getYear(), fti.getMonth(), fti.getDate(),
                hour, minute, second, millisecond);

        return ymd;
    }

    private MergedRecord buildCsvRecord(Event3112BodyWrapper wrapper) {
        MergedRecord csvRecord = new MergedRecord();
        EricssonEventFile.TEvent3112Body rec = wrapper.getRecord();

        csvRecord.setHour(ConversionHelper.NullIf1ByteInvalid(rec.timestampHour()));
        csvRecord.setMinute(ConversionHelper.NullIf1ByteInvalid(rec.timestampMinute()));
        csvRecord.setSecond(ConversionHelper.NullIf1ByteInvalid(rec.timestampSecond()));
        csvRecord.setMillisecond(ConversionHelper.NullIf2ByteInvalid(rec.timestampMillisecond()));
        csvRecord.setServingCellId(ConversionHelper.NullIf4ByteInvalid(rec.globalCellId()));
        csvRecord.setServingCellEARFCN(ConversionHelper.NullIf3ByteInvalid(rec.mdtM1Frequency()));
        csvRecord.setMmes1apid(ConversionHelper.NullIf4ByteInvalid(rec.mmes1apid()));
        csvRecord.setServingCellRSRP(ConversionHelper.NullIf1ByteInvalid(rec.rsrpServing()));
        csvRecord.setServingCellRSRQ(ConversionHelper.NullIf1ByteInvalid(rec.rsrqServing()));

        csvRecord.setNbrCellData(1, new NbrCellData(
                ConversionHelper.NullIf2ByteInvalid(rec.physicalCellId1()),
                ConversionHelper.NullIf1ByteInvalid(rec.rsrpResult1()),
                ConversionHelper.NullIf1ByteInvalid(rec.rsrqResult1())));

        csvRecord.setNbrCellData(2, new NbrCellData(
                ConversionHelper.NullIf2ByteInvalid(rec.physicalCellId2()),
                ConversionHelper.NullIf1ByteInvalid(rec.rsrpResult2()),
                ConversionHelper.NullIf1ByteInvalid(rec.rsrqResult2())));

        csvRecord.setNbrCellData(3, new NbrCellData(
                ConversionHelper.NullIf2ByteInvalid(rec.physicalCellId3()),
                ConversionHelper.NullIf1ByteInvalid(rec.rsrpResult3()),
                ConversionHelper.NullIf1ByteInvalid(rec.rsrqResult3())));

        csvRecord.setNbrCellData(4, new NbrCellData(
                ConversionHelper.NullIf2ByteInvalid(rec.physicalCellId4()),
                ConversionHelper.NullIf1ByteInvalid(rec.rsrpResult4()),
                ConversionHelper.NullIf1ByteInvalid(rec.rsrqResult4())));

        csvRecord.setNbrCellData(5, new NbrCellData(
                ConversionHelper.NullIf2ByteInvalid(rec.physicalCellId5()),
                ConversionHelper.NullIf1ByteInvalid(rec.rsrpResult5()),
                ConversionHelper.NullIf1ByteInvalid(rec.rsrqResult5())));

        csvRecord.setNbrCellData(6, new NbrCellData(
                ConversionHelper.NullIf2ByteInvalid(rec.physicalCellId6()),
                ConversionHelper.NullIf1ByteInvalid(rec.rsrpResult6()),
                ConversionHelper.NullIf1ByteInvalid(rec.rsrqResult6())));

        csvRecord.setNbrCellData(7, new NbrCellData(
                ConversionHelper.NullIf2ByteInvalid(rec.physicalCellId7()),
                ConversionHelper.NullIf1ByteInvalid(rec.rsrpResult7()),
                ConversionHelper.NullIf1ByteInvalid(rec.rsrqResult7())));

        csvRecord.setNbrCellData(8, new NbrCellData(
                ConversionHelper.NullIf2ByteInvalid(rec.physicalCellId8()),
                ConversionHelper.NullIf1ByteInvalid(rec.rsrpResult8()),
                ConversionHelper.NullIf1ByteInvalid(rec.rsrqResult8())));

        csvRecord.setUserLatitudeSign(wrapper.getLocationPart().getLatitudeSign());
        csvRecord.setUserLatitude(wrapper.getLocationPart().getDegreesLatitude());
        csvRecord.setUserLongitude(wrapper.getLocationPart().getDegreesLongitude());

        if (csvRecord.getUserLatitude() != null && csvRecord.getUserLongitude() != null) {
            csvRecord.setGeoHash(ConversionHelper.generateGeoHash(csvRecord.getUserLatitude(), csvRecord.getUserLongitude()));
        }
        csvRecord.setCallId(ConversionHelper.NullIf3ByteInvalid(rec.traceRecordingSessionRef()));
        csvRecord.seteNodeBUESIAPId(ConversionHelper.NullIf3ByteInvalid(rec.enbs1apid()));

        csvRecord.setTA(wrapper.getTa());
        String escapedFileName = "\"" + fileName + "\"";
        csvRecord.setFileName(escapedFileName);
        csvRecord.setfileId(fileId);

        return csvRecord;
    }

    private LocationPart findLocationPart(EricssonEventFile.TEvent3112Body record, int shapeType) {
        switch (shapeType) {
            case 0:
                EricssonEventFile.TEllipsoidPoint loc0 = record.mdtM1EllipsoidPoint();
                return new LocationPart(loc0.degreesLatitude(), loc0.degreesLongitude(), loc0.latitudeSign());
            case 1:
                EricssonEventFile.TEllipsoidPointWithAlti loc1 = record.mdtM1EllipsoidPointWithAlti();
                return new LocationPart(loc1.degreesLatitude(), loc1.degreesLongitude(), loc1.latitudeSign());
            case 2:
                EricssonEventFile.TEllipsoidPointWithUncerCircle loc2 = record.mdtM1EllipsoidPointWithUncerCircle();
                return new LocationPart(loc2.degreesLatitude(), loc2.degreesLongitude(), loc2.latitudeSign());
            case 3:
                EricssonEventFile.TEllipsoidPointWithUncerEllipse loc3 = record.mdtM1EllipsoidPointWithUncerEllipse();
                return new LocationPart(loc3.degreesLatitude(), loc3.degreesLongitude(), loc3.latitudeSign());
            case 4:
                EricssonEventFile.TEllipsoidPointWithAltiAndUncerEllipsoid loc4 = record.mdtM1EllipsoidPointWithAltiAndUncerEllipsoid();
                return new LocationPart(loc4.degreesLatitude(), loc4.degreesLongitude(), loc4.latitudeSign());
            case 5:
                EricssonEventFile.TEllipsoidArc loc5 = record.mdtM1EllipsoidArc();
                return new LocationPart(loc5.degreesLatitude(), loc5.degreesLongitude(), loc5.latitudeSign());
            case 6:
                EricssonEventFile.TPolygon loc6 = record.mdtM1Polygon1();
                return new LocationPart(loc6.degreesLatitude(), loc6.degreesLongitude(), loc6.latitudeSign());
            case 7:
                EricssonEventFile.TPolygon loc7 = record.mdtM1Polygon2();
                return new LocationPart(loc7.degreesLatitude(), loc7.degreesLongitude(), loc7.latitudeSign());
            case 8:
                EricssonEventFile.TPolygon loc8 = record.mdtM1Polygon3();
                return new LocationPart(loc8.degreesLatitude(), loc8.degreesLongitude(), loc8.latitudeSign());
            case 9:
                EricssonEventFile.TPolygon loc9 = record.mdtM1Polygon4();
                return new LocationPart(loc9.degreesLatitude(), loc9.degreesLongitude(), loc9.latitudeSign());
            case 10:
                EricssonEventFile.TPolygon loc10 = record.mdtM1Polygon5();
                return new LocationPart(loc10.degreesLatitude(), loc10.degreesLongitude(), loc10.latitudeSign());
            case 11:
                EricssonEventFile.TPolygon loc11 = record.mdtM1Polygon6();
                return new LocationPart(loc11.degreesLatitude(), loc11.degreesLongitude(), loc11.latitudeSign());
            case 12:
                EricssonEventFile.TPolygon loc12 = record.mdtM1Polygon7();
                return new LocationPart(loc12.degreesLatitude(), loc12.degreesLongitude(), loc12.latitudeSign());
            default:
                return new LocationPart();
        }
    }


    private List<Event3112BodyWrapper> combine(List<EricssonEventFile.TEvent3112Body> locationRecords,
                                               List<EricssonEventFile.TEvent3108Body> taRecords) {
        List<AbstractMap.SimpleEntry<LocalTime, Integer>> taTuples = getTATuples(taRecords);
        List<AbstractMap.SimpleEntry<LocalTime, Event3112BodyWrapper>> locTuples = getLocTuples(locationRecords);

        int taIndex = 0;
        int taSize = taTuples.size();
        int locIndex = 0;
        int locSize = locTuples.size();

        // Checking minute could cause an issue, so better go with 15 miinutes in milliseconds, python uses timedelta
        long minGapInMillis = ConversionHelper.GAP_15MIN_IN_MILLISECONDS;
        while (locIndex < locSize && taIndex < taSize) {
            LocalTime locTime = locTuples.get(locIndex).getKey();
            Event3112BodyWrapper locRecord = locTuples.get(locIndex).getValue();
            LocalTime taTime = taTuples.get(taIndex).getKey();
            Integer taVal = taTuples.get(taIndex).getValue();
            long gapInMillis = Duration.between(locTime, taTime).abs().toMillis();
            if (gapInMillis < minGapInMillis) {
                minGapInMillis = gapInMillis;
                locRecord.setTa(taVal);
                taIndex++;
            } else {
                minGapInMillis = ConversionHelper.GAP_15MIN_IN_MILLISECONDS;
                locIndex++;
            }
        }

        return locTuples.stream().map(r -> r.getValue()).collect(Collectors.toList());
    }

    /**
     * Extract TA dictionary where key is time and value is timing advance
     *
     * @param taRecords 3108 records
     * @return
     */
    private List<AbstractMap.SimpleEntry<LocalTime, Integer>> getTATuples(List<EricssonEventFile.TEvent3108Body> taRecords) {
        HashMap<LocalTime, Integer> taMap = new HashMap<>();

        for (EricssonEventFile.TEvent3108Body record : taRecords) {
            LocalTime time = LocalTime.of(record.startTimestampHour(),
                    record.startTimestampMinute(),
                    record.startTimestampSecond(),
                    record.startTimestampMillisecond() * ConversionHelper.NONSECONDS_PER_MILLI);
            int taIntervalInMilliSeconds = record.taInterval();
            ArrayList<Integer> ta = record.ta();

            // NOTE: LocalTime will wrap around midnight, but python timedelta will consider it as 1 day +
            // NOTE: Again python code seems incorrect considering timdelta is for duration not to be used to represet start time
            Map<LocalTime, Integer> timeArray = IntStream.range(0, ta.size()).boxed()
                    .collect(Collectors.toMap(
                            i -> time.plus(i * taIntervalInMilliSeconds, ChronoUnit.MILLIS),
                            i -> ta.get(i)));

            // DEBUG only
            // List<AbstractMap.SimpleEntry<LocalTime, Integer>> DO_TIMEARRAY = timeArray.keySet().stream().sorted().map(key -> new AbstractMap.SimpleEntry<>(key, timeArray.get(key))).collect(Collectors.toList());
            CollectionHelper.updateMap(taMap, timeArray);
        }

        List<AbstractMap.SimpleEntry<LocalTime, Integer>> taTuples = taMap.keySet().stream()
                .filter(key -> taMap.get(key) != ConversionHelper.TWO_BYTE_INVALID_VALUE)
                .sorted()
                .map(key -> new AbstractMap.SimpleEntry<>(key, taMap.get(key)))
                .collect(Collectors.toList());

        return taTuples;
    }

    private List<AbstractMap.SimpleEntry<LocalTime, Event3112BodyWrapper>> getLocTuples(List<EricssonEventFile.TEvent3112Body> locRecords) {
        List<AbstractMap.SimpleEntry<LocalTime, Event3112BodyWrapper>> locTuples = new ArrayList<>();
        for (EricssonEventFile.TEvent3112Body record : locRecords) {
            LocalTime time = LocalTime.of(record.timestampHour(),
                    record.timestampMinute(),
                    record.timestampSecond(),
                    record.timestampMillisecond() * ConversionHelper.NONSECONDS_PER_MILLI);
            locTuples.add(new AbstractMap.SimpleEntry<>(time, new Event3112BodyWrapper(record)));
        }

        return locTuples.stream().sorted(localTimeComparator).collect(Collectors.toList());
    }

    public long getEventId3112LocSize() {
        return eventId3112LocList.size();
    }

    public void writeToCsv3112Loc(MergedCSVDecoderInput decoderInput, boolean headerEnable) {
        if (eventId3112LocList.size() == 0) {
            return;
        }

        OutputChannel outputChannel = decoderInput.getOutputChannel(Ericsson2MergedCSVDecoder.ALL_CHANNEL);
        OutputStream outStream = outputChannel.getOutputStream();

        try (
                //FileOutputStream fOut3112ericson = new FileOutputStream(decoderInput.getOutputFile(Ericsson2MergedCSVDecoder.ERICSON_3112_CHANNEL));
                OutputStreamWriter writerEricson3112 = new OutputStreamWriter(outStream)
        ) {
            if (headerEnable) {
                writerEricson3112.write(CSV_HEADER_3112_LOC + "\n");
            }
            for (TEventRecord eventRecord : eventId3112LocList) {
                writerEricson3112.write(this.toCSVOrderEvent3112(eventRecord));
                writerEricson3112.write('\n');
            }

        } catch (IOException ioe) {
            ioe.printStackTrace();
        }

    }

    //11-04-2024 added by sanduni
    private String toCSVOrderEvent3112(TEventRecord eventRecord) {
        EricssonEventFile.TEvent3112Body body = eventRecord.event3112Body();

        StringBuilder b = new StringBuilder();
        MergedRecord csvRecord = new MergedRecord();
        csvRecord.setHour(ConversionHelper.NullIf1ByteInvalid(body.timestampHour()));
        csvRecord.setMinute(ConversionHelper.NullIf1ByteInvalid(body.timestampMinute()));
        csvRecord.setSecond(ConversionHelper.NullIf1ByteInvalid(body.timestampSecond()));
        csvRecord.setMillisecond(ConversionHelper.NullIf2ByteInvalid(body.timestampMillisecond()));

        String ymd = buildDateTime(csvRecord, this.filenameTimeInfo);
        b.append(ymd).append(",");

        if (ymd.compareTo(this.filenameTimeInfo.getStartYmd()) > 0 && ymd.compareTo(this.filenameTimeInfo.getEndYmd()) < 0) {
            b.append("True").append(",");
        } else {
            b.append("False").append(",");
        }

        b.append(Objects.toString(ConversionHelper.NullIf4ByteInvalid(body.globalCellId()), "")).append(",");
        b.append(Objects.toString(ConversionHelper.NullIf4ByteInvalid(body.mmes1apid()), "")).append(",");
        //15-04-2024 If needed Add EARFCN (not a field in struct), added by Sanduni
        b.append(Objects.toString(ConversionHelper.NullIf1ByteInvalid(body.rsrpServing()), "")).append(",");
        b.append(Objects.toString(ConversionHelper.NullIf1ByteInvalid(body.rsrqServing()), "")).append(",");

        b.append(Objects.toString(ConversionHelper.NullIf3ByteInvalid(body.mdtM1Frequency()), "")).append(",");
        b.append(Objects.toString(ConversionHelper.NullIf1ByteInvalid(body.mdtM1HorizontalVelocity().bearing()), "")).append(",");
        b.append(Objects.toString(ConversionHelper.NullIf3ByteInvalid(body.mdtM1HorizontalVelocity().horizontalSpeed()), "")).append(",");
        b.append(Objects.toString(body.mdtM1HorizontalVelocity().spare(), "")).append(",");
        b.append(Objects.toString(ConversionHelper.NullIf3ByteInvalid(body.paramMdtM1GnssTodMsec()), "")).append(",");

        b.append(Objects.toString(ConversionHelper.NullIf2ByteInvalid(body.physicalCellId1()), "")).append(",");
        //15-04-2024 If needed add nbr cell EARFCN(not a field in struct, previously set as empty), added by Sanduni
        b.append(Objects.toString(ConversionHelper.NullIf1ByteInvalid(body.rsrpResult1()), "")).append(",");
        b.append(Objects.toString(ConversionHelper.NullIf1ByteInvalid(body.rsrqResult1()), "")).append(",");

        b.append(Objects.toString(ConversionHelper.NullIf2ByteInvalid(body.physicalCellId2()), "")).append(",");
        b.append(Objects.toString(ConversionHelper.NullIf1ByteInvalid(body.rsrpResult2()), "")).append(",");
        b.append(Objects.toString(ConversionHelper.NullIf1ByteInvalid(body.rsrqResult2()), "")).append(",");

        b.append(Objects.toString(ConversionHelper.NullIf2ByteInvalid(body.physicalCellId3()), "")).append(",");
        b.append(Objects.toString(ConversionHelper.NullIf1ByteInvalid(body.rsrpResult3()), "")).append(",");
        b.append(Objects.toString(ConversionHelper.NullIf1ByteInvalid(body.rsrqResult3()), "")).append(",");

        b.append(Objects.toString(ConversionHelper.NullIf2ByteInvalid(body.physicalCellId4()), "")).append(",");
        b.append(Objects.toString(ConversionHelper.NullIf1ByteInvalid(body.rsrpResult4()), "")).append(",");
        b.append(Objects.toString(ConversionHelper.NullIf1ByteInvalid(body.rsrqResult4()), "")).append(",");

        b.append(Objects.toString(ConversionHelper.NullIf2ByteInvalid(body.physicalCellId5()), "")).append(",");
        b.append(Objects.toString(ConversionHelper.NullIf1ByteInvalid(body.rsrpResult5()), "")).append(",");
        b.append(Objects.toString(ConversionHelper.NullIf1ByteInvalid(body.rsrqResult5()), "")).append(",");

        b.append(Objects.toString(ConversionHelper.NullIf2ByteInvalid(body.physicalCellId6()), "")).append(",");
        b.append(Objects.toString(ConversionHelper.NullIf1ByteInvalid(body.rsrpResult6()), "")).append(",");
        b.append(Objects.toString(ConversionHelper.NullIf1ByteInvalid(body.rsrqResult6()), "")).append(",");

        b.append(Objects.toString(ConversionHelper.NullIf2ByteInvalid(body.physicalCellId7()), "")).append(",");
        b.append(Objects.toString(ConversionHelper.NullIf1ByteInvalid(body.rsrpResult7()), "")).append(",");
        b.append(Objects.toString(ConversionHelper.NullIf1ByteInvalid(body.rsrqResult7()), "")).append(",");

        b.append(Objects.toString(ConversionHelper.NullIf2ByteInvalid(body.physicalCellId8()), "")).append(",");
        b.append(Objects.toString(ConversionHelper.NullIf1ByteInvalid(body.rsrpResult8()), "")).append(",");
        b.append(Objects.toString(ConversionHelper.NullIf1ByteInvalid(body.rsrqResult8()), "")).append(",");
        b.append(Objects.toString(ConversionHelper.NullIf1ByteInvalid(body.mdtM1LocationCoordinates()), "")).append(",");

        int shapeType = body.mdtM1LocationCoordinates();
        LocationPart locationPart;
        if (shapeType != ConversionHelper.ONE_BYTE_INVALID_VALUE) {
            locationPart = this.findLocationPart(body, shapeType);
        } else {
            locationPart = new LocationPart(); // Empty dummy
        }

        b.append(Objects.toString(locationPart.getDegreesLatitude(), "")).append(",");
        b.append(Objects.toString(locationPart.getDegreesLongitude(), "")).append(",");
        //15-04-2024 If needed, add altitude(not a field in struct, previously set as empty), added by Sanduni
        b.append(",");

        if (locationPart.getDegreesLatitude() != null && locationPart.getDegreesLongitude() != null) {
            b.append(Objects.toString(ConversionHelper.generateGeoHash(locationPart.getDegreesLatitude(), locationPart.getDegreesLongitude()), "")).append(",");
        } else {
            b.append(",");
        }

        b.append(Objects.toString(ConversionHelper.NullIf3ByteInvalid(body.traceRecordingSessionRef()), "")).append(","); //callId
        b.append(Objects.toString(ConversionHelper.NullIf3ByteInvalid(body.enbs1apid()), "")).append(","); //eNodeBUESIAPId

        return b.toString();
    }


}
