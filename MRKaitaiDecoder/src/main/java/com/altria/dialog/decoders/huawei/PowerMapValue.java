package com.altria.dialog.decoders.huawei;

import java.util.ArrayList;

public class PowerMapValue {
    private int servCellRsrp;
    private int servCellRsrq;
    private ArrayList<CellInfo> outputCellArray;
    private UserLocation userLocation;
    private int servEARFCN;

    public PowerMapValue(int servCellRsrp, int servCellRsrq, ArrayList<CellInfo> outputCellArray, UserLocation userLocation, int servEARFCN) {
        this.servCellRsrp = servCellRsrp;
        this.servCellRsrq = servCellRsrq;
        this.outputCellArray = outputCellArray;
        this.userLocation = userLocation;
        this.servEARFCN = servEARFCN;
    }

    public int getServCellRsrp() {
        return servCellRsrp;
    }

    public int getServCellRsrq() {
        return servCellRsrq;
    }

    public ArrayList<CellInfo> getOutputCellArray() {
        return outputCellArray;
    }

    public UserLocation getUserLocation() {
        return userLocation;
    }

    public int getServEARFCN() {
        return servEARFCN;
    }
}
