package com.altria.dialog.decoders.ericsson;

public class NbrCellData {
    private Integer nbrCellPCI;
    private Integer nbrCellRSRP;
    private Integer nbrCellRSRQ;
    private Integer nbrCellId;
    private Integer nbrCellEARFCN;

    public NbrCellData() {
    }

    public NbrCellData(Integer nbrCellPCI, Integer nbrCellRSRP, Integer nbrCellRSRQ) {
        this.nbrCellPCI = nbrCellPCI;
        this.nbrCellRSRP = nbrCellRSRP;
        this.nbrCellRSRQ = nbrCellRSRQ;
    }

    public Integer getNbrCellEARFCN() {
        return nbrCellEARFCN;
    }

    public void setNbrCellEARFCN(Integer nbrCellEARFCN) {
        this.nbrCellEARFCN = nbrCellEARFCN;
    }

    public Integer getNbrCellPCI() {
        return nbrCellPCI;
    }

    public void setNbrCellPCI(Integer nbrCellPCI) {
        this.nbrCellPCI = nbrCellPCI;
    }

    public Integer getNbrCellRSRP() {
        return nbrCellRSRP;
    }

    public void setNbrCellRSRP(Integer nbrCellRSRP) {
        this.nbrCellRSRP = nbrCellRSRP;
    }

    public Integer getNbrCellRSRQ() {
        return nbrCellRSRQ;
    }

    public void setNbrCellRSRQ(Integer nbrCellRSRQ) {
        this.nbrCellRSRQ = nbrCellRSRQ;
    }

    public Integer getNbrCellId() {
        return nbrCellId;
    }

    public void setNbrCellId(Integer nbrCellId) {
        this.nbrCellId = nbrCellId;
    }
}
