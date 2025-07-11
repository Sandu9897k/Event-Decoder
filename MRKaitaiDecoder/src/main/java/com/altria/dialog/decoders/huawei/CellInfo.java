package com.altria.dialog.decoders.huawei;

public class CellInfo {
    private int earfcn;
    private int currentCI;
    private int pci;
    private int rsrp;
    private int rsrq;

    public CellInfo(int earfcn, int nbrCellId, int pci, int rsrp, int rsrq) {
        this.earfcn = earfcn;
        this.currentCI = nbrCellId;
        this.pci = pci;
        this.rsrp = rsrp;
        this.rsrq = rsrq;
    }

    public int getPci() {
        return pci;
    }

    public void setPci(int pci) {
        this.pci = pci;
    }

    public int getRsrp() {
        return rsrp;
    }

    public void setRsrp(int rsrp) {
        this.rsrp = rsrp;
    }

    public int getRsrq() {
        return rsrq;
    }

    public void setRsrq(int rsrq) {
        this.rsrq = rsrq;
    }

    public int getEARFCN() {
        return earfcn;
    }

    public void setEARFCN(int earfcn) {
        this.earfcn = earfcn;
    }

    public int getCurrentCI() {
        return currentCI;
    }

    public void setCurrentCI(int currentCI) {
        this.currentCI = currentCI;
    }
}
