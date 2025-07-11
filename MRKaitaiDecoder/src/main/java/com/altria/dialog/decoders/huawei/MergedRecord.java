package com.altria.dialog.decoders.huawei;

import com.altria.dialog.decoders.common.ConversionHelper;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.UUID;

public class MergedRecord {
    public final static String CSV_HEADER_DEFAULT = "MMES1APID,eNodeB_UE_SIAP_ID,User_Latitude_Sign,User_Latitude,User_Longitude,User_Altitude,TA,callid,Timestamp,Serving_Cell_Id,Serving_Cell_EARFCN,Serving_Cell_Latitude,Serving_Cell_Longitude,Serving_Cell_RSRP,Serving_Cell_RSRQ,Nbr_Cell_1_Id,Nbr_Cell_1_EARFCN,Nbr_Cell_1_Latitude,Nbr_Cell_1_Longitude,Nbr_Cell_1_RSRP,Nbr_Cell_1_RSRQ,Nbr_Cell_2_Id,Nbr_Cell_2_EARFCN,Nbr_Cell_2_Latitude,Nbr_Cell_2_Longitude,Nbr_Cell_2_RSRP,Nbr_Cell_2_RSRQ,Nbr_Cell_3_Id,Nbr_Cell_3_EARFCN,Nbr_Cell_3_Latitude,Nbr_Cell_3_Longitude,Nbr_Cell_3_RSRP,Nbr_Cell_3_RSRQ,Nbr_Cell_4_Id,Nbr_Cell_4_EARFCN,Nbr_Cell_4_Latitude,Nbr_Cell_4_Longitude,Nbr_Cell_4_RSRP,Nbr_Cell_4_RSRQ,Nbr_Cell_5_Id,Nbr_Cell_5_EARFCN,Nbr_Cell_5_Latitude,Nbr_Cell_5_Longitude,Nbr_Cell_5_RSRP,Nbr_Cell_5_RSRQ,Nbr_Cell_6_Id,Nbr_Cell_6_EARFCN,Nbr_Cell_6_Latitude,Nbr_Cell_6_Longitude,Nbr_Cell_6_RSRP,Nbr_Cell_6_RSRQ,Datetime";
    public final static String CSV_HEADER_NEWORDER2 = "Datetime,MMES1APID,Serving_Cell_Id,Serving_Cell_EARFCN,Serving_Cell_RSRP,Serving_Cell_RSRQ,Nbr_Cell_1_Id,Nbr_Cell_1_EARFCN,Nbr_Cell_1_RSRP,Nbr_Cell_1_RSRQ,Nbr_Cell_2_Id,Nbr_Cell_2_EARFCN,Nbr_Cell_2_RSRP,Nbr_Cell_2_RSRQ,Nbr_Cell_3_Id,Nbr_Cell_3_EARFCN,Nbr_Cell_3_RSRP,Nbr_Cell_3_RSRQ,Nbr_Cell_4_Id,Nbr_Cell_4_EARFCN,Nbr_Cell_4_RSRP,Nbr_Cell_4_RSRQ,Nbr_Cell_5_Id,Nbr_Cell_5_EARFCN,Nbr_Cell_5_RSRP,Nbr_Cell_5_RSRQ,Nbr_Cell_6_Id,Nbr_Cell_6_EARFCN,Nbr_Cell_6_RSRP,Nbr_Cell_6_RSRQ,Nbr_Cell_7_Id,Nbr_Cell_7_EARFCN,Nbr_Cell_7_RSRP,Nbr_Cell_7_RSRQ,Nbr_Cell_8_Id,Nbr_Cell_8_EARFCN,Nbr_Cell_8_RSRP,Nbr_Cell_8_RSRQ,TA,User_Latitude,User_Longitude,User_Altitude,callid,eNodeB_UE_SIAP_ID,_fn,_fid,_rid,_geohash";

    private long rid;
    private Long mtmsi;
    private Long mtmsi2;
    private Integer userLatSign;
    private Float userLatitude;
    private Float userLongitude;
    private Float userAltitude;
    private Long delayEvent;
    private Long callId;
    private Long powerTimeStamp;
    private Long serviceCellId;
    private Integer serviceEARFCN;
    private Float latitude;
    private Float longitude;
    private Integer serviceCellRsrp;
    private Integer serviceCellRsrq;
    private String fileName;
    private UUID fileId;
    private String geoHash;

    private List<NbrRecord> nbrRecords = new ArrayList<>();
    private LocalDateTime powerDateTime;

    public LocalDateTime getPowerDateTime() {
        return powerDateTime;
    }

    public void setPowerDateTime(LocalDateTime powerDateTime) {
        this.powerDateTime = powerDateTime;
    }

    public List<NbrRecord> getNbrRecords() {
        return nbrRecords;
    }

    public void setNbrRecords(List<NbrRecord> nbrRecords) {
        this.nbrRecords = nbrRecords;
    }

    public Long getMtmsi() {
        return mtmsi;
    }

    public void setMtmsi(Long mtmsi) {
        this.mtmsi = mtmsi;
    }

    public Long getMtmsi2() {
        return mtmsi2;
    }

    public void setMtmsi2(Long mtmsi2) {
        this.mtmsi2 = mtmsi2;
    }

    public Integer getUserLatSign() {
        return userLatSign;
    }

    public void setUserLatSign(Integer userLatSign) {
        this.userLatSign = userLatSign;
    }

    public Float getUserLatitude() {
        return userLatitude;
    }

    public void setUserLatitude(Float userLatitude) {
        this.userLatitude = userLatitude;
    }

    public Float getUserLongitude() {
        return userLongitude;
    }

    public void setUserLongitude(Float userLongitude) {
        this.userLongitude = userLongitude;
    }

    public Float getUserAltitude() {
        return userAltitude;
    }

    public void setUserAltitude(Float userAltitude) {
        this.userAltitude = userAltitude;
    }

    public Long getDelayEvent() {
        return delayEvent;
    }

    public void setDelayEvent(Long delayEvent) {
        this.delayEvent = delayEvent;
    }

    public Long getCallId() {
        return callId;
    }

    public void setCallId(Long callId) {
        this.callId = callId;
    }

    public Long getPowerTimeStamp() {
        return powerTimeStamp;
    }

    public void setPowerTimeStamp(Long powerTimeStamp) {
        this.powerTimeStamp = powerTimeStamp;
    }

    public Long getServiceCellId() {
        return serviceCellId;
    }

    public void setServiceCellId(Long serviceCellId) {
        this.serviceCellId = serviceCellId;
    }

    public Integer getServiceEARFCN() {
        return serviceEARFCN;
    }

    public void setServiceEARFCN(Integer serviceEARFCN) {
        this.serviceEARFCN = serviceEARFCN;
    }

    public Float getLatitude() {
        return latitude;
    }

    public void setLatitude(Float latitude) {
        this.latitude = latitude;
    }

    public Float getLongitude() {
        return longitude;
    }

    public void setLongitude(Float longitude) {
        this.longitude = longitude;
    }

    public Integer getServiceCellRsrp() {
        return serviceCellRsrp;
    }

    public void setServiceCellRsrp(Integer serviceCellRsrp) {
        this.serviceCellRsrp = serviceCellRsrp;
    }

    public Integer getServiceCellRsrq() {
        return serviceCellRsrq;
    }

    public void setServiceCellRsrq(Integer serviceCellRsrq) {
        this.serviceCellRsrq = serviceCellRsrq;
    }

    public void setFileName(String fileName) { this.fileName = fileName; }

    public void setFileId(UUID fileId) {
        this.fileId = fileId;
    }

    public void setRid(long rid) { this.rid = rid; }

    public void setGeoHash(String geoHash) { this.geoHash = geoHash; }

    /**
     * Create CSV string using this record, no need to escape data as all elements either int or long
     * @return
     */
    public String toCSV() {
        StringBuilder b = new StringBuilder();
        b.append(Objects.toString(this.mtmsi, "")).append(",")              // MMES1APID
         .append(Objects.toString(this.mtmsi2, "")).append(",")             // eNodeB_UE_SIAP_ID
         .append(Objects.toString(this.userLatSign, "")).append(",")        // User_Latitude_Sign
         .append(Objects.toString(this.userLatitude, "")).append(",")       // User_Latitude
         .append(Objects.toString(this.userLongitude, "")).append(",")      // User_Longitude
         .append(Objects.toString(this.userAltitude, "")).append(",")       // User_Altitude
         .append(Objects.toString(this.delayEvent, "")).append(",")         // TA
         .append(Objects.toString(this.callId, "")).append(",")             // callid
         .append(Objects.toString(this.powerTimeStamp, "")).append(",")     // Timestamp
         .append(Objects.toString(this.serviceCellId, "")).append(",")      // Serving_Cell_Id
         .append(Objects.toString(this.serviceEARFCN, "")).append(",")      // Serving_Cell_EARFCN
         .append(Objects.toString(this.latitude, "")).append(",")           // Serving_Cell_Latitude
         .append(Objects.toString(this.longitude, "")).append(",")          // Serving_Cell_Longitude
         .append(Objects.toString(this.serviceCellRsrp, "")).append(",")    // Serving_Cell_RSRP
         .append(Objects.toString(this.serviceCellRsrq, ""));               // Serving_Cell_RSRQ

        String nbrRecords = this.nbrRecords.stream()
                .map(r -> r.toCSV()).collect(Collectors.joining(","));
        b.append(",").append(nbrRecords);
        b.append(",").append(this.powerDateTime == null ? "" : this.powerDateTime.format(ConversionHelper.HUAWEI_DATETIME_FORMATTER)); // Datetime
        return b.toString();
    }

    public String toCSVOrder2() {
        StringBuilder b = new StringBuilder();
        b.append(this.powerDateTime == null ? "" : this.powerDateTime.format(ConversionHelper.HUAWEI_DATETIME_FORMATTER)).append(",") // Datetime
         .append(Objects.toString(this.mtmsi, "")).append(",")              // MMES1APID
         .append(Objects.toString(this.serviceCellId, "")).append(",")      // Serving_Cell_Id
         .append(Objects.toString(this.serviceEARFCN, "")).append(",")      // Serving_Cell_EARFCN
         .append(Objects.toString(this.serviceCellRsrp, "")).append(",")    // Serving_Cell_RSRP
         .append(Objects.toString(this.serviceCellRsrq, ""));               // Serving_Cell_RSRQ

        String nbrRecords = this.nbrRecords.stream()
                .map(r -> r.toCSVOrder2()).collect(Collectors.joining(","));
        b.append(",").append(nbrRecords);

        b.append(",").append(Objects.toString(this.delayEvent, "")).append(",")  // TA
                .append(Objects.toString(this.userLatitude, "")).append(",")       // User_Latitude
                .append(Objects.toString(this.userLongitude, "")).append(",")      // User_Longitude
                .append(Objects.toString(this.userAltitude, "")).append(",")       // User_Altitude
                .append(Objects.toString(this.callId, "")).append(",")             // callid
                .append(Objects.toString(this.mtmsi2, "")).append(",")             // eNodeB_UE_SIAP_ID
                .append(Objects.toString(this.fileName, "")).append(",")          //file name
                .append(Objects.toString(this.fileId, "")).append(",")            // fid
                .append(Objects.toString(this.rid, "")).append(",")              //record Id
                .append(Objects.toString(this.geoHash, ""));                     //geoHash

        return b.toString();
    }


    public static class NbrRecord {
        private Integer cellId;
        private Integer earfcn;
        private Float lat;
        private Float lon;
        private Integer rsrp;
        private Integer rsrq;
        private Integer carrier_frequency;

        public Float getLat() {
            return lat;
        }

        public void setLat(Float lat) {
            this.lat = lat;
        }

        public Float getLon() {
            return lon;
        }

        public void setLon(Float lon) {
            this.lon = lon;
        }

        public Integer getCellId() {
            return cellId;
        }

        public void setCellId(Integer cellId) {
            this.cellId = cellId;
        }

        public Integer getEarfcn() {
            return earfcn;
        }

        public void setEarfcn(Integer earfcn) {
            this.earfcn = earfcn;
        }

        public Integer getRsrp() {
            return rsrp;
        }

        public void setRsrp(Integer rsrp) {
            this.rsrp = rsrp;
        }

        public Integer getRsrq() {
            return rsrq;
        }

        public void setRsrq(Integer rsrq) {
            this.rsrq = rsrq;
        }

        public String toCSV() {
            return new StringBuilder()
                    .append(Objects.toString(this.cellId, "")).append(",")  // Nbr_Cell_[1-6]_Id
                    .append(Objects.toString(this.earfcn, "")).append(",")  // Nbr_Cell_[1-6]_EARFCN
                    .append(Objects.toString(this.lat, "")).append(",")     // Nbr_Cell_[1-6]_Latitude
                    .append(Objects.toString(this.lon, "")).append(",")     // Nbr_Cell_[1-6]_Longitude
                    .append(Objects.toString(this.rsrp, "")).append(",")    // Nbr_Cell_[1-6]_RSRP
                    .append(Objects.toString(this.rsrq, "")).toString();    // Nbr_Cell_[1-6]_RSRQ
        }

        public String toCSVOrder2() {
            return new StringBuilder()
                    .append(Objects.toString(this.cellId, "")).append(",")  // Nbr_Cell_[1-6]_Id
                    .append(Objects.toString(this.earfcn, "")).append(",")  // Nbr_Cell_[1-6]_EARFCN
                    .append(Objects.toString(this.rsrp, "")).append(",")    // Nbr_Cell_[1-6]_RSRP
                    .append(Objects.toString(this.rsrq, "")).toString();    // Nbr_Cell_[1-6]_RSRQ
        }

        public String toCSVOrder3() {
            return new StringBuilder()
                    .append(Objects.toString(this.cellId, "")).append(",")  // Nbr_Cell_[1-6]_Id
                    .append(Objects.toString(this.earfcn, "")).append(",")  // Nbr_Cell_[1-6]_EARFCN
                    .append(Objects.toString(this.rsrp, "")).append(",")    // Nbr_Cell_[1-6]_RSRP
                    .append(Objects.toString(this.rsrq, "")).append(",")    // Nbr_Cell_[1-6]_RSRQ
                    .append(Objects.toString(this.carrier_frequency, "")).toString();    
            
        }
    }
}
