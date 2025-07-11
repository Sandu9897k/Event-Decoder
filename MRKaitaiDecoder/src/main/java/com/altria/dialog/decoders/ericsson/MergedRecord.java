package com.altria.dialog.decoders.ericsson;

import com.altria.dialog.decoders.common.ConversionHelper;

import java.security.PublicKey;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.UUID;

public class MergedRecord {
    public final static String CSV_HEADER_DEFAULT = "Datetime,Serving_Cell_Id,Serving_Cell_EARFCN,MMES1APID,Serving_Cell_RSRP,Serving_Cell_RSRQ,Nbr_Cell_1_PCI,Nbr_Cell_1_RSRP,Nbr_Cell_1_RSRQ,Nbr_Cell_2_PCI,Nbr_Cell_2_RSRP,Nbr_Cell_2_RSRQ,Nbr_Cell_3_PCI,Nbr_Cell_3_RSRP,Nbr_Cell_3_RSRQ,Nbr_Cell_4_PCI,Nbr_Cell_4_RSRP,Nbr_Cell_4_RSRQ,Nbr_Cell_5_PCI,Nbr_Cell_5_RSRP,Nbr_Cell_5_RSRQ,Nbr_Cell_6_PCI,Nbr_Cell_6_RSRP,Nbr_Cell_6_RSRQ,Nbr_Cell_7_PCI,Nbr_Cell_7_RSRP,Nbr_Cell_7_RSRQ,Nbr_Cell_8_PCI,Nbr_Cell_8_RSRP,Nbr_Cell_8_RSRQ,User_Latutude_Sign,User_Latitude,User_Longitude,callid,eNodeB_UE_SIAP_ID,TA";
    public final static String CSV_HEADER_NEWORDER2 = "Datetime,MMES1APID,Serving_Cell_Id,Serving_Cell_EARFCN,Serving_Cell_RSRP,Serving_Cell_RSRQ,Nbr_Cell_1_Id,Nbr_Cell_1_EARFCN,Nbr_Cell_1_RSRP,Nbr_Cell_1_RSRQ,Nbr_Cell_2_Id,Nbr_Cell_2_EARFCN,Nbr_Cell_2_RSRP,Nbr_Cell_2_RSRQ,Nbr_Cell_3_Id,Nbr_Cell_3_EARFCN,Nbr_Cell_3_RSRP,Nbr_Cell_3_RSRQ,Nbr_Cell_4_Id,Nbr_Cell_4_EARFCN,Nbr_Cell_4_RSRP,Nbr_Cell_4_RSRQ,Nbr_Cell_5_Id,Nbr_Cell_5_EARFCN,Nbr_Cell_5_RSRP,Nbr_Cell_5_RSRQ,Nbr_Cell_6_Id,Nbr_Cell_6_EARFCN,Nbr_Cell_6_RSRP,Nbr_Cell_6_RSRQ,Nbr_Cell_7_Id,Nbr_Cell_7_EARFCN,Nbr_Cell_7_RSRP,Nbr_Cell_7_RSRQ,Nbr_Cell_8_Id,Nbr_Cell_8_EARFCN,Nbr_Cell_8_RSRP,Nbr_Cell_8_RSRQ,TA,User_Latitude,User_Longitude,User_Altitude,callid,eNodeB_UE_SIAP_ID,_fn,_fid,_rid,_geohash";
    public final static int MAX_NBR_CELL_DATA_SIZE = 8;

    private long rid;
    private LocalDateTime dateTime;
    private Integer hour;
    private Integer minute;
    private Integer second;
    private Integer millisecond;
    private Long servingCellId;
    private Long servingCellEARFCN;
    private Long mmes1apid;
    private Integer servingCellRSRP;
    private Integer servingCellRSRQ;
    private Integer userLatitudeSign;
    private Float userLatitude;
    private Float userLongitude;
    private Long callId;
    private Long eNodeBUESIAPId;
    private Integer ta;
    private String datetimeStr;
    private List<NbrCellData> nbrCellDataList;
    private String fileName;
    private UUID fileId;
    private String geoHash;

    // New records after merging with nbrmap
    private Long eNBId;

    public LocalDateTime getDateTime() {
        return dateTime;
    }

    public Integer getHour() {
        return hour;
    }

    public Integer getMinute() {
        return minute;
    }

    public Integer getSecond() {
        return second;
    }

    public Integer getMillisecond() {
        return millisecond;
    }

    public Long getServingCellId() {
        return servingCellId;
    }

    public Long getServingCellEARFCN() {
        return servingCellEARFCN;
    }

    public Long getMmes1apid() {
        return mmes1apid;
    }

    public Integer getServingCellRSRP() {
        return servingCellRSRP;
    }

    public Integer getServingCellRSRQ() {
        return servingCellRSRQ;
    }

    public Integer getUserLatitudeSign() {
        return userLatitudeSign;
    }

    public Float getUserLatitude() {
        return userLatitude;
    }

    public Float getUserLongitude() {
        return userLongitude;
    }

    public Long getCallId() {
        return callId;
    }

    public Long geteNodeBUESIAPId() {
        return eNodeBUESIAPId;
    }

    public Integer getTa() {
        return ta;
    }

    public String getFileName() { return fileName; }

    public UUID getfileId() { return fileId; }


    public void setHour(Integer hour) {

        this.hour = hour;
    }

    public void setMinute(Integer minute) {

        this.minute = minute;
    }

    public void setSecond(Integer second) {

        this.second = second;
    }

    public void setMillisecond(Integer millisecond) {

        this.millisecond = millisecond;
    }

    public void setServingCellId(Long servingCellId) {

        this.servingCellId = servingCellId;
    }

    public void setServingCellEARFCN(Long servingCellEARFCN) {

        this.servingCellEARFCN = servingCellEARFCN;
    }

    public void setMmes1apid(Long mmes1apid) {

        this.mmes1apid = mmes1apid;
    }

    public void setServingCellRSRP(Integer servingCellRSRP) {

        this.servingCellRSRP = servingCellRSRP;
    }

    public void setServingCellRSRQ(Integer servingCellRSRQ) {

        this.servingCellRSRQ = servingCellRSRQ;
    }

    public void setUserLatitudeSign(int latitudeSign) {

        this.userLatitudeSign = latitudeSign;
    }

    public void setUserLatitude(Float userLatitude) {

        this.userLatitude = userLatitude;

    }

    public void setUserLongitude(Float userLongitude) {

        this.userLongitude = userLongitude;

    }

    public void setCallId(Long callId) {

        this.callId = callId;
    }

    public void seteNodeBUESIAPId(Long eNodeBUESIAPId) {

        this.eNodeBUESIAPId = eNodeBUESIAPId;
    }


    public void setTA(Integer ta) {

        this.ta = ta;
    }

    public void setDatetimeStr(String datetimeStr) {

        this.datetimeStr = datetimeStr;
    }

    public void setFileName(String fileName) {

        this.fileName = fileName;
    }
    public void setfileId(UUID fileId) {

        this.fileId = fileId;
    }
    public void setRid(long rid) {

        this.rid = rid;
    }

    public void setGeoHash(String geoHash) {

        this.geoHash = geoHash;
    }

    public String getDatetimeStr() {
        return datetimeStr;
    }

    /**
     * Set NbrCellData, (no id range validation)
     * @param id should be between 1-8 inclusive
     * @param data
     */
    public void setNbrCellData(int id, NbrCellData data) {
        this.nbrCellDataList.set(id - 1, data);
    }

    /**
     * Get NbrCellData by id, (no id range validation)
     * @param id should be between 1-8 inclusive
     * @return
     */
    public NbrCellData getNbrCellData(int id) {
        return this.nbrCellDataList.get(id - 1);
    }

    public void setENBID(long eNBId) {
        this.eNBId = eNBId;
    }

    public Long geteNBId() {
        return eNBId;
    }

    public MergedRecord() {
        this.nbrCellDataList = IntStream.range(0,MAX_NBR_CELL_DATA_SIZE).mapToObj(i -> new NbrCellData()).collect(Collectors.toList());
    }

    public String toCSV() {
        StringBuilder b = new StringBuilder();
        b.append(Objects.toString(this.datetimeStr, ""))                    // Datetime
        .append(",").append(Objects.toString(this.servingCellId, ""))       // Serving_Cell_Id
        .append(",").append(Objects.toString(this.servingCellEARFCN, ""))   // Serving_Cell_EARFCN
        .append(",").append(Objects.toString(this.mmes1apid, ""))           // MMES1APID
        .append(",").append(Objects.toString(this.servingCellRSRP,""))      // Serving_Cell_RSRP
        .append(",").append(Objects.toString(this.servingCellRSRQ, ""));    // Serving_Cell_RSRQ

        // Adding Nbr_cell_[n]_PCI, Nbr_Cell_[n]_RSRP, Nbr_Cell_[n]_RSRQ, where n: 1-8
        for (int i = 0; i < MAX_NBR_CELL_DATA_SIZE; i++) {
            NbrCellData nbrCellData = this.nbrCellDataList.get(i);
            b.append(",").append(Objects.toString(nbrCellData.getNbrCellPCI(), ""))
             .append(",").append(Objects.toString(nbrCellData.getNbrCellRSRP(), ""))
             .append(",").append(Objects.toString(nbrCellData.getNbrCellRSRQ(), ""));
        }

        b.append(",").append(Objects.toString(this.userLatitudeSign, ""))    // User_Latutude_Sign
        .append(",").append(Objects.toString(this.userLatitude, ""))        // User_Latitude
        .append(",").append(Objects.toString(this.userLongitude, ""))       // User_Longitude
        .append(",").append(Objects.toString(this.callId, ""))              // callid
        .append(",").append(Objects.toString(this.eNodeBUESIAPId, ""))      // eNodeB_UE_SIAP_ID
        .append(",").append(Objects.toString(this.ta, ""));     // TA

        return b.toString();
    }

    public String toCSVOrder2() {
        StringBuilder b = new StringBuilder();
        b.append(Objects.toString(this.datetimeStr, ""))                    // Datetime                               //record id
        .append(",").append(Objects.toString(this.mmes1apid, ""))           // MMES1APID
        .append(",").append(Objects.toString(this.servingCellId, ""))       // Serving_Cell_Id
        .append(",").append(Objects.toString(this.servingCellEARFCN, ""))   // Serving_Cell_EARFCN
        .append(",").append(Objects.toString(this.servingCellRSRP,""))      // Serving_Cell_RSRP
        .append(",").append(Objects.toString(this.servingCellRSRQ, ""));    // Serving_Cell_RSRQ

        // Adding Nbr_Cell_[n]_Id, Nbr_Cell_[n]_EARFCN, Nbr_Cell_[n]_RSRP, Nbr_Cell_[n]_RSRQ, where n: 1-8
        for (int i = 0; i < MAX_NBR_CELL_DATA_SIZE; i++) {
            NbrCellData nbrCellData = this.nbrCellDataList.get(i);
            b.append(",").append(Objects.toString(nbrCellData.getNbrCellId(), ""))      // Nbr_Cell_[n]_Id
            .append(",").append(Objects.toString(nbrCellData.getNbrCellEARFCN(), ""))   // Nbr_Cell_[n]_EARFCN - always empty
            .append(",").append(Objects.toString(nbrCellData.getNbrCellRSRP(), ""))     // Nbr_Cell_[n]_RSRP
            .append(",").append(Objects.toString(nbrCellData.getNbrCellRSRQ(), ""));    // Nbr_Cell_[n]_RSRQ
        }

        b.append(",").append(Objects.toString(this.ta, ""))                     // TA
        .append(",").append(Objects.toString(this.userLatitude, ""))            // User_Latitude
        .append(",").append(Objects.toString(this.userLongitude, ""))           // User_Longitude
        .append(",")                                                                     // User_Altitude - always empty
        .append(",").append(Objects.toString(this.callId, ""))                  // callid
        .append(",").append(Objects.toString(this.eNodeBUESIAPId, ""))          // eNodeB_UE_SIAP_ID
        .append(",").append(Objects.toString(this.fileName, ""))                //file name
        .append(",").append(Objects.toString(this.fileId, ""))                   //fileId
        .append(",").append(Objects.toString(this.rid, ""))                    // record id
        .append(",").append(Objects.toString(this.geoHash, ""));              //geoHash

        return b.toString();
    }
}
