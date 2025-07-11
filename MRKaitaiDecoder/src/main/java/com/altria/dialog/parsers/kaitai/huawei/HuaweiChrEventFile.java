package com.altria.dialog.parsers.kaitai.huawei;
// This is a generated file! Please edit source .ksy file and use kaitai-struct-compiler to rebuild

import io.kaitai.struct.ByteBufferKaitaiStream;
import io.kaitai.struct.KaitaiStruct;
import io.kaitai.struct.KaitaiStream;
import java.io.IOException;
import java.util.ArrayList;

public class HuaweiChrEventFile extends KaitaiStruct {
    public static HuaweiChrEventFile fromFile(String fileName) throws IOException {
        return new HuaweiChrEventFile(new ByteBufferKaitaiStream(fileName));
    }

    public HuaweiChrEventFile(KaitaiStream _io) {
        this(_io, null, null);
    }

    public HuaweiChrEventFile(KaitaiStream _io, KaitaiStruct _parent) {
        this(_io, _parent, null);
    }

    public HuaweiChrEventFile(KaitaiStream _io, KaitaiStruct _parent, HuaweiChrEventFile _root) {
        super(_io);
        this._parent = _parent;
        this._root = _root == null ? this : _root;
        _read();
    }
    private void _read() {
        this.fileHeader = new TFileHeader(this._io, this, _root);
        this.eventRecords = new ArrayList<TEventRecord>();
        {
            int i = 0;
            while (!this._io.isEof()) {
                this.eventRecords.add(new TEventRecord(this._io, this, _root));
                i++;
            }
        }
    }
    public static class TENcellInfo extends KaitaiStruct {
        public static TENcellInfo fromFile(String fileName) throws IOException {
            return new TENcellInfo(new ByteBufferKaitaiStream(fileName));
        }

        public TENcellInfo(KaitaiStream _io) {
            this(_io, null, null);
        }

        public TENcellInfo(KaitaiStream _io, HuaweiChrEventFile.TPeriodIntraFrepMeasurement _parent) {
            this(_io, _parent, null);
        }

        public TENcellInfo(KaitaiStream _io, HuaweiChrEventFile.TPeriodIntraFrepMeasurement _parent, HuaweiChrEventFile _root) {
            super(_io);
            this._parent = _parent;
            this._root = _root;
            _read();
        }
        private void _read() {
            this.pci = this._io.readU2be();
            this.rsrp = this._io.readU1();
            this.rsrq = this._io.readU1();
        }
        private int pci;
        private int rsrp;
        private int rsrq;
        private HuaweiChrEventFile _root;
        private HuaweiChrEventFile.TPeriodIntraFrepMeasurement _parent;
        public int pci() { return pci; }
        public int rsrp() { return rsrp; }
        public int rsrq() { return rsrq; }
        public HuaweiChrEventFile _root() { return _root; }
        public HuaweiChrEventFile.TPeriodIntraFrepMeasurement _parent() { return _parent; }
    }
    public static class TPeriodPrivateThroughputMeasurementM5extmdt extends KaitaiStruct {
        public static TPeriodPrivateThroughputMeasurementM5extmdt fromFile(String fileName) throws IOException {
            return new TPeriodPrivateThroughputMeasurementM5extmdt(new ByteBufferKaitaiStream(fileName));
        }

        public TPeriodPrivateThroughputMeasurementM5extmdt(KaitaiStream _io) {
            this(_io, null, null);
        }

        public TPeriodPrivateThroughputMeasurementM5extmdt(KaitaiStream _io, HuaweiChrEventFile.TEventRecord _parent) {
            this(_io, _parent, null);
        }

        public TPeriodPrivateThroughputMeasurementM5extmdt(KaitaiStream _io, HuaweiChrEventFile.TEventRecord _parent, HuaweiChrEventFile _root) {
            super(_io);
            this._parent = _parent;
            this._root = _root;
            _read();
        }
        private void _read() {
            this.ulMcs = this._io.readU4be();
            this.dlMcs = this._io.readU4be();
        }
        private long ulMcs;
        private long dlMcs;
        private HuaweiChrEventFile _root;
        private HuaweiChrEventFile.TEventRecord _parent;
        public long ulMcs() { return ulMcs; }
        public long dlMcs() { return dlMcs; }
        public HuaweiChrEventFile _root() { return _root; }
        public HuaweiChrEventFile.TEventRecord _parent() { return _parent; }
    }
    public static class TEventRecord extends KaitaiStruct {
        public static TEventRecord fromFile(String fileName) throws IOException {
            return new TEventRecord(new ByteBufferKaitaiStream(fileName));
        }

        public TEventRecord(KaitaiStream _io) {
            this(_io, null, null);
        }

        public TEventRecord(KaitaiStream _io, HuaweiChrEventFile _parent) {
            this(_io, _parent, null);
        }

        public TEventRecord(KaitaiStream _io, HuaweiChrEventFile _parent, HuaweiChrEventFile _root) {
            super(_io);
            this._parent = _parent;
            this._root = _root;
            _read();
        }
        private void _read() {
            this.chrHeader = new TChrHeader(this._io, this, _root);
            if (chrHeader().eventId() == 4097) {
                this.publicInformation = new TPublicInformation(this._io, this, _root);
            }
            if (chrHeader().eventId() == 4610) {
                this.periodIntraFrepMr = new TPeriodIntraFrepMeasurement(this._io, this, _root);
            }
            if (chrHeader().eventId() == 4625) {
                this.periodUeTaMr = new TPeriodUeTaMr(this._io, this, _root);
            }
            if (chrHeader().eventId() == 4626) {
                this.periodUeTaMdt = new TPeriodUeTaMdt(this._io, this, _root);
            }
            if (chrHeader().eventId() == 4866) {
                this.m1IntraFreqMdt = new TM1IntraFreqMdt(this._io, this, _root);
            }
            if (chrHeader().eventId() == 4867) {
                this.m1InterFreqMdt = new TM1InterFreqMdt(this._io, this, _root);
            }
            if (chrHeader().eventId() == 4868) {
                this.periodPrivateUeMeasurementM2mdt = new TPeriodPrivateUeMeasurementM2mdt(this._io, this, _root);
            }
            if (chrHeader().eventId() == 4870) {
                this.periodPrivateThroughputMeasurementM4mdt = new TPeriodPrivateThroughputMeasurementM4mdt(this._io, this, _root);
            }
            if (chrHeader().eventId() == 4871) {
                this.periodPrivateThroughputMeasurementM5mdt = new TPeriodPrivateThroughputMeasurementM5mdt(this._io, this, _root);
            }
            if (chrHeader().eventId() == 4872) {
                this.rlfReport = new TRlfReport(this._io, this, _root);
            }
            if (chrHeader().eventId() == 4873) {
                this.periodPrivateConnestFailReport = new TPeriodPrivateConnestFailReport(this._io, this, _root);
            }
            if (chrHeader().eventId() == 4882) {
                this.periodUeUlpdcpdelayMdt = new TPeriodUeUlpdcpdelayMdt(this._io, this, _root);
            }
            if (chrHeader().eventId() == 4884) {
                this.periodPrivatePktlossrateMr = new TPeriodPrivatePktlossrateMr(this._io, this, _root);
            }
            if (chrHeader().eventId() == 4897) {
                this.periodPrivateUeMeasurementM2extmdt = new TPeriodPrivateUeMeasurementM2extmdt(this._io, this, _root);
            }
            if (chrHeader().eventId() == 4898) {
                this.periodPrivateThroughputMeasurementM5extmdt = new TPeriodPrivateThroughputMeasurementM5extmdt(this._io, this, _root);
            }
            if (chrHeader().eventId() == 4613) {
                this.uePeriodRadioLinkMr = new TUePeriodRadioLinkMr(this._io, this, _root);
            }
            if (chrHeader().eventId() == 4108) {
                this.radioLinkFailureReport = new TRadioLinkFailureReport(this._io, this, _root);
            }
            if (chrHeader().eventId() == 4609) {
                this.ueEventMr = new TUeEventMr(this._io, this, _root);
            }
            if (chrHeader().eventId() == 4611) {
                this.periodInterFreqMr = new TPeriodInterFreqMr(this._io, this, _root);
            }
            if (chrHeader().eventId() == 4612) {
                this.periodInterRatMr = new TPeriodInterRatMr(this._io, this, _root);
            }
            if (chrHeader().eventId() == 4614) {
                this.periodIntraFreqMrMdt = new TPeriodIntraFreqMrMdt(this._io, this, _root);
            }
            if (chrHeader().eventId() == 4615) {
                this.periodInterFreqMrMdt = new TPeriodInterFreqMrMdt(this._io, this, _root);
            }
            if (chrHeader().eventId() == 4617) {
                this.uePeriodRadioLinkMrMdt = new TUePeriodRadioLinkMrMdt(this._io, this, _root);
            }
            if ( ((chrHeader().eventId() != 4613) && (chrHeader().eventId() != 4108) && (chrHeader().eventId() != 4882) && (chrHeader().eventId() != 4898) && (chrHeader().eventId() != 4897) && (chrHeader().eventId() != 4884) && (chrHeader().eventId() != 4873) && (chrHeader().eventId() != 4872) && (chrHeader().eventId() != 4871) && (chrHeader().eventId() != 4868) && (chrHeader().eventId() != 4870) && (chrHeader().eventId() != 4625) && (chrHeader().eventId() != 4097) && (chrHeader().eventId() != 4610) && (chrHeader().eventId() != 4626) && (chrHeader().eventId() != 4866) && (chrHeader().eventId() != 4867) && (chrHeader().eventId() != 4617) && (chrHeader().eventId() != 4615) && (chrHeader().eventId() != 4614) && (chrHeader().eventId() != 4612) && (chrHeader().eventId() != 4611) && (chrHeader().eventId() != 4609)) ) {
                this.unsupported = this._io.readBytes((chrHeader().eventLength() - 21));
            }
        }
        private TChrHeader chrHeader;
        private TPublicInformation publicInformation;
        private TPeriodIntraFrepMeasurement periodIntraFrepMr;
        private TPeriodUeTaMr periodUeTaMr;
        private TPeriodUeTaMdt periodUeTaMdt;
        private TM1IntraFreqMdt m1IntraFreqMdt;
        private TM1InterFreqMdt m1InterFreqMdt;
        private TPeriodPrivateUeMeasurementM2mdt periodPrivateUeMeasurementM2mdt;
        private TPeriodPrivateThroughputMeasurementM4mdt periodPrivateThroughputMeasurementM4mdt;
        private TPeriodPrivateThroughputMeasurementM5mdt periodPrivateThroughputMeasurementM5mdt;
        private TRlfReport rlfReport;
        private TPeriodPrivateConnestFailReport periodPrivateConnestFailReport;
        private TPeriodUeUlpdcpdelayMdt periodUeUlpdcpdelayMdt;
        private TPeriodPrivatePktlossrateMr periodPrivatePktlossrateMr;
        private TPeriodPrivateUeMeasurementM2extmdt periodPrivateUeMeasurementM2extmdt;
        private TPeriodPrivateThroughputMeasurementM5extmdt periodPrivateThroughputMeasurementM5extmdt;
        private TUePeriodRadioLinkMr uePeriodRadioLinkMr;
        private TRadioLinkFailureReport radioLinkFailureReport;
        private TUeEventMr ueEventMr;
        private TPeriodInterFreqMr periodInterFreqMr;
        private TPeriodInterRatMr periodInterRatMr;
        private TPeriodIntraFreqMrMdt periodIntraFreqMrMdt;
        private TPeriodInterFreqMrMdt periodInterFreqMrMdt;
        private TUePeriodRadioLinkMrMdt uePeriodRadioLinkMrMdt;
        private byte[] unsupported;
        private HuaweiChrEventFile _root;
        private HuaweiChrEventFile _parent;
        public TChrHeader chrHeader() { return chrHeader; }
        public TPublicInformation publicInformation() { return publicInformation; }
        public TPeriodIntraFrepMeasurement periodIntraFrepMr() { return periodIntraFrepMr; }
        public TPeriodUeTaMr periodUeTaMr() { return periodUeTaMr; }
        public TPeriodUeTaMdt periodUeTaMdt() { return periodUeTaMdt; }
        public TM1IntraFreqMdt m1IntraFreqMdt() { return m1IntraFreqMdt; }
        public TM1InterFreqMdt m1InterFreqMdt() { return m1InterFreqMdt; }
        public TPeriodPrivateUeMeasurementM2mdt periodPrivateUeMeasurementM2mdt() { return periodPrivateUeMeasurementM2mdt; }
        public TPeriodPrivateThroughputMeasurementM4mdt periodPrivateThroughputMeasurementM4mdt() { return periodPrivateThroughputMeasurementM4mdt; }
        public TPeriodPrivateThroughputMeasurementM5mdt periodPrivateThroughputMeasurementM5mdt() { return periodPrivateThroughputMeasurementM5mdt; }
        public TRlfReport rlfReport() { return rlfReport; }
        public TPeriodPrivateConnestFailReport periodPrivateConnestFailReport() { return periodPrivateConnestFailReport; }
        public TPeriodUeUlpdcpdelayMdt periodUeUlpdcpdelayMdt() { return periodUeUlpdcpdelayMdt; }
        public TPeriodPrivatePktlossrateMr periodPrivatePktlossrateMr() { return periodPrivatePktlossrateMr; }
        public TPeriodPrivateUeMeasurementM2extmdt periodPrivateUeMeasurementM2extmdt() { return periodPrivateUeMeasurementM2extmdt; }
        public TPeriodPrivateThroughputMeasurementM5extmdt periodPrivateThroughputMeasurementM5extmdt() { return periodPrivateThroughputMeasurementM5extmdt; }
        public TUePeriodRadioLinkMr uePeriodRadioLinkMr() { return uePeriodRadioLinkMr; }
        public TRadioLinkFailureReport radioLinkFailureReport() { return radioLinkFailureReport; }
        public TUeEventMr ueEventMr() { return ueEventMr; }
        public TPeriodInterFreqMr periodInterFreqMr() { return periodInterFreqMr; }
        public TPeriodInterRatMr periodInterRatMr() { return periodInterRatMr; }
        public TPeriodIntraFreqMrMdt periodIntraFreqMrMdt() { return periodIntraFreqMrMdt; }
        public TPeriodInterFreqMrMdt periodInterFreqMrMdt() { return periodInterFreqMrMdt; }
        public TUePeriodRadioLinkMrMdt uePeriodRadioLinkMrMdt() { return uePeriodRadioLinkMrMdt; }
        public byte[] unsupported() { return unsupported; }
        public HuaweiChrEventFile _root() { return _root; }
        public HuaweiChrEventFile _parent() { return _parent; }
    }
    public static class TPeriodPrivateConnestFailReport extends KaitaiStruct {
        public static TPeriodPrivateConnestFailReport fromFile(String fileName) throws IOException {
            return new TPeriodPrivateConnestFailReport(new ByteBufferKaitaiStream(fileName));
        }

        public TPeriodPrivateConnestFailReport(KaitaiStream _io) {
            this(_io, null, null);
        }

        public TPeriodPrivateConnestFailReport(KaitaiStream _io, HuaweiChrEventFile.TEventRecord _parent) {
            this(_io, _parent, null);
        }

        public TPeriodPrivateConnestFailReport(KaitaiStream _io, HuaweiChrEventFile.TEventRecord _parent, HuaweiChrEventFile _root) {
            super(_io);
            this._parent = _parent;
            this._root = _root;
            _read();
        }
        private void _read() {
            this.failedCellId = this._io.readU4be();
            this.servingCellRsrp = this._io.readU1();
            this.servingCellRsrq = this._io.readU1();
            this.numPreamblesSent = this._io.readU1();
            this.contentionDetectedFlag = this._io.readU1();
            this.maxTxPowerReachedFlag = this._io.readU1();
            this.timeFromFailure = this._io.readU4be();
            this.eutranNcellMrValidFlag = this._io.readU1();
            this.eutranCarrierFrequencyCount = this._io.readU1();
            this.eutranCarrierFrequencyList = new ArrayList<TEutranCarrierInfo>();
            for (int i = 0; i < eutranCarrierFrequencyCount(); i++) {
                this.eutranCarrierFrequencyList.add(new TEutranCarrierInfo(this._io, this, _root));
            }
            this.utranNcellMrValidFlag = this._io.readU1();
            this.utranCarrierFrequencyCount = this._io.readU1();
            this.utranCarrierFrequencyList = new ArrayList<TUtranCarrierInfo>();
            for (int i = 0; i < utranCarrierFrequencyCount(); i++) {
                this.utranCarrierFrequencyList.add(new TUtranCarrierInfo(this._io, this, _root));
            }
            this.geranNcellMrValidFlag = this._io.readU1();
            this.geranNcellCount = this._io.readU1();
            this.geranNcellInfoList = new ArrayList<TGeranNcellInfo>();
            for (int i = 0; i < geranNcellCount(); i++) {
                this.geranNcellInfoList.add(new TGeranNcellInfo(this._io, this, _root));
            }
            this.cdma2000NcellMrValidFlag = this._io.readU1();
            this.cdma2000CarrierFrequencyCount = this._io.readU1();
            this.cdma2000CarrierFrequencyList = new ArrayList<TCdma2000CarrierInfo>();
            for (int i = 0; i < cdma2000CarrierFrequencyCount(); i++) {
                this.cdma2000CarrierFrequencyList.add(new TCdma2000CarrierInfo(this._io, this, _root));
            }
            this.locationInfoPresent = this._io.readU1();
            if (locationInfoPresent() == 1) {
                this.shapeType = this._io.readU1();
            }
            if ( ((locationInfoPresent() == 1) && (shapeType() == 0)) ) {
                this.undefinedInfo = new TUndefinedInfo(this._io, this, _root);
            }
            if ( ((locationInfoPresent() == 1) && (shapeType() == 1)) ) {
                this.ellipsoidPointInfo = new TEllipsoidPointInfo(this._io, this, _root);
            }
            if ( ((locationInfoPresent() == 1) && (shapeType() == 2)) ) {
                this.ellipsoidPointWithAltitudeInfo = new TEllipsoidPointWithAltitudeInfo(this._io, this, _root);
            }
            if ( ((locationInfoPresent() == 1) && (shapeType() == 3)) ) {
                this.ellipsoidPointWithUncertaintyCircleInfo = new TEllipsoidPointWithUncertaintyCircleInfo(this._io, this, _root);
            }
            if ( ((locationInfoPresent() == 1) && (shapeType() == 4)) ) {
                this.ellipsoidPointWithUncertaintyEllipseInfo = new TEllipsoidPointWithUncertaintyEllipseInfo(this._io, this, _root);
            }
            if ( ((locationInfoPresent() == 1) && (shapeType() == 5)) ) {
                this.ellipsoidPointWithAltitudAndUncertaintyEllipsoidInfo = new TEllipsoidPointWithAltitudAndUncertaintyEllipsoidInfo(this._io, this, _root);
            }
        }
        private long failedCellId;
        private int servingCellRsrp;
        private int servingCellRsrq;
        private int numPreamblesSent;
        private int contentionDetectedFlag;
        private int maxTxPowerReachedFlag;
        private long timeFromFailure;
        private int eutranNcellMrValidFlag;
        private int eutranCarrierFrequencyCount;
        private ArrayList<TEutranCarrierInfo> eutranCarrierFrequencyList;
        private int utranNcellMrValidFlag;
        private int utranCarrierFrequencyCount;
        private ArrayList<TUtranCarrierInfo> utranCarrierFrequencyList;
        private int geranNcellMrValidFlag;
        private int geranNcellCount;
        private ArrayList<TGeranNcellInfo> geranNcellInfoList;
        private int cdma2000NcellMrValidFlag;
        private int cdma2000CarrierFrequencyCount;
        private ArrayList<TCdma2000CarrierInfo> cdma2000CarrierFrequencyList;
        private int locationInfoPresent;
        private Integer shapeType;
        private TUndefinedInfo undefinedInfo;
        private TEllipsoidPointInfo ellipsoidPointInfo;
        private TEllipsoidPointWithAltitudeInfo ellipsoidPointWithAltitudeInfo;
        private TEllipsoidPointWithUncertaintyCircleInfo ellipsoidPointWithUncertaintyCircleInfo;
        private TEllipsoidPointWithUncertaintyEllipseInfo ellipsoidPointWithUncertaintyEllipseInfo;
        private TEllipsoidPointWithAltitudAndUncertaintyEllipsoidInfo ellipsoidPointWithAltitudAndUncertaintyEllipsoidInfo;
        private HuaweiChrEventFile _root;
        private HuaweiChrEventFile.TEventRecord _parent;
        public long failedCellId() { return failedCellId; }
        public int servingCellRsrp() { return servingCellRsrp; }
        public int servingCellRsrq() { return servingCellRsrq; }
        public int numPreamblesSent() { return numPreamblesSent; }
        public int contentionDetectedFlag() { return contentionDetectedFlag; }
        public int maxTxPowerReachedFlag() { return maxTxPowerReachedFlag; }
        public long timeFromFailure() { return timeFromFailure; }
        public int eutranNcellMrValidFlag() { return eutranNcellMrValidFlag; }
        public int eutranCarrierFrequencyCount() { return eutranCarrierFrequencyCount; }
        public ArrayList<TEutranCarrierInfo> eutranCarrierFrequencyList() { return eutranCarrierFrequencyList; }
        public int utranNcellMrValidFlag() { return utranNcellMrValidFlag; }
        public int utranCarrierFrequencyCount() { return utranCarrierFrequencyCount; }
        public ArrayList<TUtranCarrierInfo> utranCarrierFrequencyList() { return utranCarrierFrequencyList; }
        public int geranNcellMrValidFlag() { return geranNcellMrValidFlag; }
        public int geranNcellCount() { return geranNcellCount; }
        public ArrayList<TGeranNcellInfo> geranNcellInfoList() { return geranNcellInfoList; }
        public int cdma2000NcellMrValidFlag() { return cdma2000NcellMrValidFlag; }
        public int cdma2000CarrierFrequencyCount() { return cdma2000CarrierFrequencyCount; }
        public ArrayList<TCdma2000CarrierInfo> cdma2000CarrierFrequencyList() { return cdma2000CarrierFrequencyList; }
        public int locationInfoPresent() { return locationInfoPresent; }
        public Integer shapeType() { return shapeType; }
        public TUndefinedInfo undefinedInfo() { return undefinedInfo; }
        public TEllipsoidPointInfo ellipsoidPointInfo() { return ellipsoidPointInfo; }
        public TEllipsoidPointWithAltitudeInfo ellipsoidPointWithAltitudeInfo() { return ellipsoidPointWithAltitudeInfo; }
        public TEllipsoidPointWithUncertaintyCircleInfo ellipsoidPointWithUncertaintyCircleInfo() { return ellipsoidPointWithUncertaintyCircleInfo; }
        public TEllipsoidPointWithUncertaintyEllipseInfo ellipsoidPointWithUncertaintyEllipseInfo() { return ellipsoidPointWithUncertaintyEllipseInfo; }
        public TEllipsoidPointWithAltitudAndUncertaintyEllipsoidInfo ellipsoidPointWithAltitudAndUncertaintyEllipsoidInfo() { return ellipsoidPointWithAltitudAndUncertaintyEllipsoidInfo; }
        public HuaweiChrEventFile _root() { return _root; }
        public HuaweiChrEventFile.TEventRecord _parent() { return _parent; }
    }
    public static class TPeriodInterFreqMrMdt extends KaitaiStruct {
        public static TPeriodInterFreqMrMdt fromFile(String fileName) throws IOException {
            return new TPeriodInterFreqMrMdt(new ByteBufferKaitaiStream(fileName));
        }

        public TPeriodInterFreqMrMdt(KaitaiStream _io) {
            this(_io, null, null);
        }

        public TPeriodInterFreqMrMdt(KaitaiStream _io, HuaweiChrEventFile.TEventRecord _parent) {
            this(_io, _parent, null);
        }

        public TPeriodInterFreqMrMdt(KaitaiStream _io, HuaweiChrEventFile.TEventRecord _parent, HuaweiChrEventFile _root) {
            super(_io);
            this._parent = _parent;
            this._root = _root;
            _read();
        }
        private void _read() {
            this.measurementId = this._io.readU1();
            this.servingCellRsrp = this._io.readU1();
            this.servingCellRsrq = this._io.readU1();
            this.ncellCount = this._io.readU1();
            this.ncellInfoList = new ArrayList<TInterFreqMdtNcellInfo>();
            for (int i = 0; i < ncellCount(); i++) {
                this.ncellInfoList.add(new TInterFreqMdtNcellInfo(this._io, this, _root));
            }
        }
        private int measurementId;
        private int servingCellRsrp;
        private int servingCellRsrq;
        private int ncellCount;
        private ArrayList<TInterFreqMdtNcellInfo> ncellInfoList;
        private HuaweiChrEventFile _root;
        private HuaweiChrEventFile.TEventRecord _parent;
        public int measurementId() { return measurementId; }
        public int servingCellRsrp() { return servingCellRsrp; }
        public int servingCellRsrq() { return servingCellRsrq; }
        public int ncellCount() { return ncellCount; }
        public ArrayList<TInterFreqMdtNcellInfo> ncellInfoList() { return ncellInfoList; }
        public HuaweiChrEventFile _root() { return _root; }
        public HuaweiChrEventFile.TEventRecord _parent() { return _parent; }
    }
    public static class TUePeriodRadioLinkMr extends KaitaiStruct {
        public static TUePeriodRadioLinkMr fromFile(String fileName) throws IOException {
            return new TUePeriodRadioLinkMr(new ByteBufferKaitaiStream(fileName));
        }

        public TUePeriodRadioLinkMr(KaitaiStream _io) {
            this(_io, null, null);
        }

        public TUePeriodRadioLinkMr(KaitaiStream _io, HuaweiChrEventFile.TEventRecord _parent) {
            this(_io, _parent, null);
        }

        public TUePeriodRadioLinkMr(KaitaiStream _io, HuaweiChrEventFile.TEventRecord _parent, HuaweiChrEventFile _root) {
            super(_io);
            this._parent = _parent;
            this._root = _root;
            _read();
        }
        private void _read() {
            this.uePhr = this._io.readU1();
            this.dlWidebandCqiCode0 = this._io.readU1();
            this.dlWidebandCqiCode1 = this._io.readU1();
            this.ulDmrsSinr = this._io.readS4be();
            this.taValue = this._io.readU4be();
            this.preambleTaValue = this._io.readU4be();
            this.ulSrsSinr = this._io.readS4be();
        }
        private int uePhr;
        private int dlWidebandCqiCode0;
        private int dlWidebandCqiCode1;
        private int ulDmrsSinr;
        private long taValue;
        private long preambleTaValue;
        private int ulSrsSinr;
        private HuaweiChrEventFile _root;
        private HuaweiChrEventFile.TEventRecord _parent;
        public int uePhr() { return uePhr; }
        public int dlWidebandCqiCode0() { return dlWidebandCqiCode0; }
        public int dlWidebandCqiCode1() { return dlWidebandCqiCode1; }
        public int ulDmrsSinr() { return ulDmrsSinr; }
        public long taValue() { return taValue; }
        public long preambleTaValue() { return preambleTaValue; }
        public int ulSrsSinr() { return ulSrsSinr; }
        public HuaweiChrEventFile _root() { return _root; }
        public HuaweiChrEventFile.TEventRecord _parent() { return _parent; }
    }
    public static class TEutranNcellInfoList extends KaitaiStruct {
        public static TEutranNcellInfoList fromFile(String fileName) throws IOException {
            return new TEutranNcellInfoList(new ByteBufferKaitaiStream(fileName));
        }

        public TEutranNcellInfoList(KaitaiStream _io) {
            this(_io, null, null);
        }

        public TEutranNcellInfoList(KaitaiStream _io, KaitaiStruct _parent) {
            this(_io, _parent, null);
        }

        public TEutranNcellInfoList(KaitaiStream _io, KaitaiStruct _parent, HuaweiChrEventFile _root) {
            super(_io);
            this._parent = _parent;
            this._root = _root;
            _read();
        }
        private void _read() {
            this.pci = this._io.readU2be();
            this.rsrp = this._io.readU1();
            this.rsrq = this._io.readU1();
        }
        private int pci;
        private int rsrp;
        private int rsrq;
        private HuaweiChrEventFile _root;
        private KaitaiStruct _parent;
        public int pci() { return pci; }
        public int rsrp() { return rsrp; }
        public int rsrq() { return rsrq; }
        public HuaweiChrEventFile _root() { return _root; }
        public KaitaiStruct _parent() { return _parent; }
    }
    public static class TPeriodPrivateThroughputMeasurementM4mdt extends KaitaiStruct {
        public static TPeriodPrivateThroughputMeasurementM4mdt fromFile(String fileName) throws IOException {
            return new TPeriodPrivateThroughputMeasurementM4mdt(new ByteBufferKaitaiStream(fileName));
        }

        public TPeriodPrivateThroughputMeasurementM4mdt(KaitaiStream _io) {
            this(_io, null, null);
        }

        public TPeriodPrivateThroughputMeasurementM4mdt(KaitaiStream _io, HuaweiChrEventFile.TEventRecord _parent) {
            this(_io, _parent, null);
        }

        public TPeriodPrivateThroughputMeasurementM4mdt(KaitaiStream _io, HuaweiChrEventFile.TEventRecord _parent, HuaweiChrEventFile _root) {
            super(_io);
            this._parent = _parent;
            this._root = _root;
            _read();
        }
        private void _read() {
            this.eRabCount = this._io.readU1();
            this.eRabThroughputStatList = new ArrayList<TERabThroughputStatM4mdt>();
            for (int i = 0; i < eRabCount(); i++) {
                this.eRabThroughputStatList.add(new TERabThroughputStatM4mdt(this._io, this, _root));
            }
        }
        private int eRabCount;
        private ArrayList<TERabThroughputStatM4mdt> eRabThroughputStatList;
        private HuaweiChrEventFile _root;
        private HuaweiChrEventFile.TEventRecord _parent;
        public int eRabCount() { return eRabCount; }
        public ArrayList<TERabThroughputStatM4mdt> eRabThroughputStatList() { return eRabThroughputStatList; }
        public HuaweiChrEventFile _root() { return _root; }
        public HuaweiChrEventFile.TEventRecord _parent() { return _parent; }
    }
    public static class TPeriodUeTaMdt extends KaitaiStruct {
        public static TPeriodUeTaMdt fromFile(String fileName) throws IOException {
            return new TPeriodUeTaMdt(new ByteBufferKaitaiStream(fileName));
        }

        public TPeriodUeTaMdt(KaitaiStream _io) {
            this(_io, null, null);
        }

        public TPeriodUeTaMdt(KaitaiStream _io, HuaweiChrEventFile.TEventRecord _parent) {
            this(_io, _parent, null);
        }

        public TPeriodUeTaMdt(KaitaiStream _io, HuaweiChrEventFile.TEventRecord _parent, HuaweiChrEventFile _root) {
            super(_io);
            this._parent = _parent;
            this._root = _root;
            _read();
        }
        private void _read() {
            this.ta = this._io.readU4be();
        }
        private long ta;
        private HuaweiChrEventFile _root;
        private HuaweiChrEventFile.TEventRecord _parent;
        public long ta() { return ta; }
        public HuaweiChrEventFile _root() { return _root; }
        public HuaweiChrEventFile.TEventRecord _parent() { return _parent; }
    }
    public static class TEllipsoidPointWithAltitudAndUncertaintyEllipsoidInfo extends KaitaiStruct {
        public static TEllipsoidPointWithAltitudAndUncertaintyEllipsoidInfo fromFile(String fileName) throws IOException {
            return new TEllipsoidPointWithAltitudAndUncertaintyEllipsoidInfo(new ByteBufferKaitaiStream(fileName));
        }

        public TEllipsoidPointWithAltitudAndUncertaintyEllipsoidInfo(KaitaiStream _io) {
            this(_io, null, null);
        }

        public TEllipsoidPointWithAltitudAndUncertaintyEllipsoidInfo(KaitaiStream _io, KaitaiStruct _parent) {
            this(_io, _parent, null);
        }

        public TEllipsoidPointWithAltitudAndUncertaintyEllipsoidInfo(KaitaiStream _io, KaitaiStruct _parent, HuaweiChrEventFile _root) {
            super(_io);
            this._parent = _parent;
            this._root = _root;
            _read();
        }
        private void _read() {
            this.latitudeSign = this._io.readU1();
            this.degreesLatitude = this._io.readU4be();
            this.degreesLongitude = this._io.readU4be();
            this.altitudeDirection = this._io.readU1();
            this.altitude = this._io.readU2be();
            this.uncertaintySemiMajor = this._io.readU1();
            this.uncertaintySemiMinor = this._io.readU1();
            this.orientationMajorAxis = this._io.readU1();
            this.uncertaintyAltitude = this._io.readU1();
            this.confidence = this._io.readU1();
        }
        private int latitudeSign;
        private long degreesLatitude;
        private long degreesLongitude;
        private int altitudeDirection;
        private int altitude;
        private int uncertaintySemiMajor;
        private int uncertaintySemiMinor;
        private int orientationMajorAxis;
        private int uncertaintyAltitude;
        private int confidence;
        private HuaweiChrEventFile _root;
        private KaitaiStruct _parent;
        public int latitudeSign() { return latitudeSign; }
        public long degreesLatitude() { return degreesLatitude; }
        public long degreesLongitude() { return degreesLongitude; }
        public int altitudeDirection() { return altitudeDirection; }
        public int altitude() { return altitude; }
        public int uncertaintySemiMajor() { return uncertaintySemiMajor; }
        public int uncertaintySemiMinor() { return uncertaintySemiMinor; }
        public int orientationMajorAxis() { return orientationMajorAxis; }
        public int uncertaintyAltitude() { return uncertaintyAltitude; }
        public int confidence() { return confidence; }
        public HuaweiChrEventFile _root() { return _root; }
        public KaitaiStruct _parent() { return _parent; }
    }
    public static class TPeriodPrivatePktlossrateMr extends KaitaiStruct {
        public static TPeriodPrivatePktlossrateMr fromFile(String fileName) throws IOException {
            return new TPeriodPrivatePktlossrateMr(new ByteBufferKaitaiStream(fileName));
        }

        public TPeriodPrivatePktlossrateMr(KaitaiStream _io) {
            this(_io, null, null);
        }

        public TPeriodPrivatePktlossrateMr(KaitaiStream _io, HuaweiChrEventFile.TEventRecord _parent) {
            this(_io, _parent, null);
        }

        public TPeriodPrivatePktlossrateMr(KaitaiStream _io, HuaweiChrEventFile.TEventRecord _parent, HuaweiChrEventFile _root) {
            super(_io);
            this._parent = _parent;
            this._root = _root;
            _read();
        }
        private void _read() {
            this.qciCount = this._io.readU1();
            this.packetLossInfoList = new ArrayList<TPacketLossInfo>();
            for (int i = 0; i < qciCount(); i++) {
                this.packetLossInfoList.add(new TPacketLossInfo(this._io, this, _root));
            }
        }
        private int qciCount;
        private ArrayList<TPacketLossInfo> packetLossInfoList;
        private HuaweiChrEventFile _root;
        private HuaweiChrEventFile.TEventRecord _parent;
        public int qciCount() { return qciCount; }
        public ArrayList<TPacketLossInfo> packetLossInfoList() { return packetLossInfoList; }
        public HuaweiChrEventFile _root() { return _root; }
        public HuaweiChrEventFile.TEventRecord _parent() { return _parent; }
    }
    public static class TLocationInfo extends KaitaiStruct {
        public static TLocationInfo fromFile(String fileName) throws IOException {
            return new TLocationInfo(new ByteBufferKaitaiStream(fileName));
        }

        public TLocationInfo(KaitaiStream _io) {
            this(_io, null, null);
        }

        public TLocationInfo(KaitaiStream _io, KaitaiStruct _parent) {
            this(_io, _parent, null);
        }

        public TLocationInfo(KaitaiStream _io, KaitaiStruct _parent, HuaweiChrEventFile _root) {
            super(_io);
            this._parent = _parent;
            this._root = _root;
            _read();
        }
        private void _read() {
            this.shapeType = this._io.readU1();
            switch (shapeType()) {
                case 0: {
                    this.shapeData = new TUndefinedInfo(this._io, this, _root);
                    break;
                }
                case 4: {
                    this.shapeData = new TEllipsoidPointWithUncertaintyEllipseInfo(this._io, this, _root);
                    break;
                }
                case 1: {
                    this.shapeData = new TEllipsoidPointInfo(this._io, this, _root);
                    break;
                }
                case 3: {
                    this.shapeData = new TEllipsoidPointWithUncertaintyCircleInfo(this._io, this, _root);
                    break;
                }
                case 5: {
                    this.shapeData = new TEllipsoidPointWithAltitudAndUncertaintyEllipsoidInfo(this._io, this, _root);
                    break;
                }
                case 2: {
                    this.shapeData = new TEllipsoidPointWithAltitudeInfo(this._io, this, _root);
                    break;
                }
            }
        }
        private int shapeType;
        private KaitaiStruct shapeData;
        private HuaweiChrEventFile _root;
        private KaitaiStruct _parent;
        public int shapeType() { return shapeType; }
        public KaitaiStruct shapeData() { return shapeData; }
        public HuaweiChrEventFile _root() { return _root; }
        public KaitaiStruct _parent() { return _parent; }
    }
    public static class TFailedPcellInfo extends KaitaiStruct {
        public static TFailedPcellInfo fromFile(String fileName) throws IOException {
            return new TFailedPcellInfo(new ByteBufferKaitaiStream(fileName));
        }

        public TFailedPcellInfo(KaitaiStream _io) {
            this(_io, null, null);
        }

        public TFailedPcellInfo(KaitaiStream _io, HuaweiChrEventFile.TRlfReport _parent) {
            this(_io, _parent, null);
        }

        public TFailedPcellInfo(KaitaiStream _io, HuaweiChrEventFile.TRlfReport _parent, HuaweiChrEventFile _root) {
            super(_io);
            this._parent = _parent;
            this._root = _root;
            _read();
        }
        private void _read() {
            this.cellType = this._io.readU1();
            if (cellType() == 1) {
                this.globalCellIdInfo = new TGlobalCellIdInfo(this._io, this, _root);
            }
            if (cellType() == 2) {
                this.pciArfcnInfo = new TPciArfcnInfo(this._io, this, _root);
            }
        }
        private int cellType;
        private TGlobalCellIdInfo globalCellIdInfo;
        private TPciArfcnInfo pciArfcnInfo;
        private HuaweiChrEventFile _root;
        private HuaweiChrEventFile.TRlfReport _parent;
        public int cellType() { return cellType; }
        public TGlobalCellIdInfo globalCellIdInfo() { return globalCellIdInfo; }
        public TPciArfcnInfo pciArfcnInfo() { return pciArfcnInfo; }
        public HuaweiChrEventFile _root() { return _root; }
        public HuaweiChrEventFile.TRlfReport _parent() { return _parent; }
    }
    public static class TUeTdScdmaNcellInfo extends KaitaiStruct {
        public static TUeTdScdmaNcellInfo fromFile(String fileName) throws IOException {
            return new TUeTdScdmaNcellInfo(new ByteBufferKaitaiStream(fileName));
        }

        public TUeTdScdmaNcellInfo(KaitaiStream _io) {
            this(_io, null, null);
        }

        public TUeTdScdmaNcellInfo(KaitaiStream _io, KaitaiStruct _parent) {
            this(_io, _parent, null);
        }

        public TUeTdScdmaNcellInfo(KaitaiStream _io, KaitaiStruct _parent, HuaweiChrEventFile _root) {
            super(_io);
            this._parent = _parent;
            this._root = _root;
            _read();
        }
        private void _read() {
            this.ncellCount = this._io.readU1();
            this.ncellList = new ArrayList<TTdscdmaNcellInfo>();
            for (int i = 0; i < ncellCount(); i++) {
                this.ncellList.add(new TTdscdmaNcellInfo(this._io, this, _root));
            }
        }
        private int ncellCount;
        private ArrayList<TTdscdmaNcellInfo> ncellList;
        private HuaweiChrEventFile _root;
        private KaitaiStruct _parent;
        public int ncellCount() { return ncellCount; }
        public ArrayList<TTdscdmaNcellInfo> ncellList() { return ncellList; }
        public HuaweiChrEventFile _root() { return _root; }
        public KaitaiStruct _parent() { return _parent; }
    }
    public static class TEllipsoidPointWithAltitudeInfo extends KaitaiStruct {
        public static TEllipsoidPointWithAltitudeInfo fromFile(String fileName) throws IOException {
            return new TEllipsoidPointWithAltitudeInfo(new ByteBufferKaitaiStream(fileName));
        }

        public TEllipsoidPointWithAltitudeInfo(KaitaiStream _io) {
            this(_io, null, null);
        }

        public TEllipsoidPointWithAltitudeInfo(KaitaiStream _io, KaitaiStruct _parent) {
            this(_io, _parent, null);
        }

        public TEllipsoidPointWithAltitudeInfo(KaitaiStream _io, KaitaiStruct _parent, HuaweiChrEventFile _root) {
            super(_io);
            this._parent = _parent;
            this._root = _root;
            _read();
        }
        private void _read() {
            this.latitudeSign = this._io.readU1();
            this.degreesLatitude = this._io.readU4be();
            this.degreesLongitude = this._io.readU4be();
            this.altitudeDirection = this._io.readU1();
            this.altitude = this._io.readU2be();
        }
        private int latitudeSign;
        private long degreesLatitude;
        private long degreesLongitude;
        private int altitudeDirection;
        private int altitude;
        private HuaweiChrEventFile _root;
        private KaitaiStruct _parent;
        public int latitudeSign() { return latitudeSign; }
        public long degreesLatitude() { return degreesLatitude; }
        public long degreesLongitude() { return degreesLongitude; }
        public int altitudeDirection() { return altitudeDirection; }
        public int altitude() { return altitude; }
        public HuaweiChrEventFile _root() { return _root; }
        public KaitaiStruct _parent() { return _parent; }
    }
    public static class TPeriodIntraFreqMrMdt extends KaitaiStruct {
        public static TPeriodIntraFreqMrMdt fromFile(String fileName) throws IOException {
            return new TPeriodIntraFreqMrMdt(new ByteBufferKaitaiStream(fileName));
        }

        public TPeriodIntraFreqMrMdt(KaitaiStream _io) {
            this(_io, null, null);
        }

        public TPeriodIntraFreqMrMdt(KaitaiStream _io, HuaweiChrEventFile.TEventRecord _parent) {
            this(_io, _parent, null);
        }

        public TPeriodIntraFreqMrMdt(KaitaiStream _io, HuaweiChrEventFile.TEventRecord _parent, HuaweiChrEventFile _root) {
            super(_io);
            this._parent = _parent;
            this._root = _root;
            _read();
        }
        private void _read() {
            this.measurementId = this._io.readU1();
            this.servingCellRsrp = this._io.readU1();
            this.servingCellRsrq = this._io.readU1();
            this.ncellCount = this._io.readU1();
            this.ncellInfoList = new ArrayList<TIntraFreqMdtNcellInfo>();
            for (int i = 0; i < ncellCount(); i++) {
                this.ncellInfoList.add(new TIntraFreqMdtNcellInfo(this._io, this, _root));
            }
        }
        private int measurementId;
        private int servingCellRsrp;
        private int servingCellRsrq;
        private int ncellCount;
        private ArrayList<TIntraFreqMdtNcellInfo> ncellInfoList;
        private HuaweiChrEventFile _root;
        private HuaweiChrEventFile.TEventRecord _parent;
        public int measurementId() { return measurementId; }
        public int servingCellRsrp() { return servingCellRsrp; }
        public int servingCellRsrq() { return servingCellRsrq; }
        public int ncellCount() { return ncellCount; }
        public ArrayList<TIntraFreqMdtNcellInfo> ncellInfoList() { return ncellInfoList; }
        public HuaweiChrEventFile _root() { return _root; }
        public HuaweiChrEventFile.TEventRecord _parent() { return _parent; }
    }
    public static class TUeNoNeighborCell extends KaitaiStruct {
        public static TUeNoNeighborCell fromFile(String fileName) throws IOException {
            return new TUeNoNeighborCell(new ByteBufferKaitaiStream(fileName));
        }

        public TUeNoNeighborCell(KaitaiStream _io) {
            this(_io, null, null);
        }

        public TUeNoNeighborCell(KaitaiStream _io, HuaweiChrEventFile.TUeEventNcellInfo _parent) {
            this(_io, _parent, null);
        }

        public TUeNoNeighborCell(KaitaiStream _io, HuaweiChrEventFile.TUeEventNcellInfo _parent, HuaweiChrEventFile _root) {
            super(_io);
            this._parent = _parent;
            this._root = _root;
            _read();
        }
        private void _read() {
            this.reserved = this._io.readU1();
        }
        private int reserved;
        private HuaweiChrEventFile _root;
        private HuaweiChrEventFile.TUeEventNcellInfo _parent;
        public int reserved() { return reserved; }
        public HuaweiChrEventFile _root() { return _root; }
        public HuaweiChrEventFile.TUeEventNcellInfo _parent() { return _parent; }
    }
    public static class TFailedPcellInfo100c extends KaitaiStruct {
        public static TFailedPcellInfo100c fromFile(String fileName) throws IOException {
            return new TFailedPcellInfo100c(new ByteBufferKaitaiStream(fileName));
        }

        public TFailedPcellInfo100c(KaitaiStream _io) {
            this(_io, null, null);
        }

        public TFailedPcellInfo100c(KaitaiStream _io, HuaweiChrEventFile.TRadioLinkFailureReport _parent) {
            this(_io, _parent, null);
        }

        public TFailedPcellInfo100c(KaitaiStream _io, HuaweiChrEventFile.TRadioLinkFailureReport _parent, HuaweiChrEventFile _root) {
            super(_io);
            this._parent = _parent;
            this._root = _root;
            _read();
        }
        private void _read() {
            this.cellType = this._io.readU1();
            if (cellType() == 1) {
                this.globalCellIdInfo = new TGlobalCellIdInfo(this._io, this, _root);
            }
            if (cellType() == 2) {
                this.pciArfcnInfo = new TPciArfcnInfo100c(this._io, this, _root);
            }
        }
        private int cellType;
        private TGlobalCellIdInfo globalCellIdInfo;
        private TPciArfcnInfo100c pciArfcnInfo;
        private HuaweiChrEventFile _root;
        private HuaweiChrEventFile.TRadioLinkFailureReport _parent;
        public int cellType() { return cellType; }
        public TGlobalCellIdInfo globalCellIdInfo() { return globalCellIdInfo; }
        public TPciArfcnInfo100c pciArfcnInfo() { return pciArfcnInfo; }
        public HuaweiChrEventFile _root() { return _root; }
        public HuaweiChrEventFile.TRadioLinkFailureReport _parent() { return _parent; }
    }
    public static class TPciArfcnInfo extends KaitaiStruct {
        public static TPciArfcnInfo fromFile(String fileName) throws IOException {
            return new TPciArfcnInfo(new ByteBufferKaitaiStream(fileName));
        }

        public TPciArfcnInfo(KaitaiStream _io) {
            this(_io, null, null);
        }

        public TPciArfcnInfo(KaitaiStream _io, HuaweiChrEventFile.TFailedPcellInfo _parent) {
            this(_io, _parent, null);
        }

        public TPciArfcnInfo(KaitaiStream _io, HuaweiChrEventFile.TFailedPcellInfo _parent, HuaweiChrEventFile _root) {
            super(_io);
            this._parent = _parent;
            this._root = _root;
            _read();
        }
        private void _read() {
            this.pci = this._io.readU2be();
            this.carrierFrequency = this._io.readU4be();
        }
        private int pci;
        private long carrierFrequency;
        private HuaweiChrEventFile _root;
        private HuaweiChrEventFile.TFailedPcellInfo _parent;
        public int pci() { return pci; }
        public long carrierFrequency() { return carrierFrequency; }
        public HuaweiChrEventFile _root() { return _root; }
        public HuaweiChrEventFile.TFailedPcellInfo _parent() { return _parent; }
    }
    public static class TUeGeranNcellInfo extends KaitaiStruct {
        public static TUeGeranNcellInfo fromFile(String fileName) throws IOException {
            return new TUeGeranNcellInfo(new ByteBufferKaitaiStream(fileName));
        }

        public TUeGeranNcellInfo(KaitaiStream _io) {
            this(_io, null, null);
        }

        public TUeGeranNcellInfo(KaitaiStream _io, KaitaiStruct _parent) {
            this(_io, _parent, null);
        }

        public TUeGeranNcellInfo(KaitaiStream _io, KaitaiStruct _parent, HuaweiChrEventFile _root) {
            super(_io);
            this._parent = _parent;
            this._root = _root;
            _read();
        }
        private void _read() {
            this.ncellCount = this._io.readU1();
            this.ncellList = new ArrayList<TGeranNcellInfo>();
            for (int i = 0; i < ncellCount(); i++) {
                this.ncellList.add(new TGeranNcellInfo(this._io, this, _root));
            }
        }
        private int ncellCount;
        private ArrayList<TGeranNcellInfo> ncellList;
        private HuaweiChrEventFile _root;
        private KaitaiStruct _parent;
        public int ncellCount() { return ncellCount; }
        public ArrayList<TGeranNcellInfo> ncellList() { return ncellList; }
        public HuaweiChrEventFile _root() { return _root; }
        public KaitaiStruct _parent() { return _parent; }
    }
    public static class TUeWcdmaNcellInfo extends KaitaiStruct {
        public static TUeWcdmaNcellInfo fromFile(String fileName) throws IOException {
            return new TUeWcdmaNcellInfo(new ByteBufferKaitaiStream(fileName));
        }

        public TUeWcdmaNcellInfo(KaitaiStream _io) {
            this(_io, null, null);
        }

        public TUeWcdmaNcellInfo(KaitaiStream _io, KaitaiStruct _parent) {
            this(_io, _parent, null);
        }

        public TUeWcdmaNcellInfo(KaitaiStream _io, KaitaiStruct _parent, HuaweiChrEventFile _root) {
            super(_io);
            this._parent = _parent;
            this._root = _root;
            _read();
        }
        private void _read() {
            this.ncellCount = this._io.readU1();
            this.ncellList = new ArrayList<TWcdmaNcellInfo>();
            for (int i = 0; i < ncellCount(); i++) {
                this.ncellList.add(new TWcdmaNcellInfo(this._io, this, _root));
            }
        }
        private int ncellCount;
        private ArrayList<TWcdmaNcellInfo> ncellList;
        private HuaweiChrEventFile _root;
        private KaitaiStruct _parent;
        public int ncellCount() { return ncellCount; }
        public ArrayList<TWcdmaNcellInfo> ncellList() { return ncellList; }
        public HuaweiChrEventFile _root() { return _root; }
        public KaitaiStruct _parent() { return _parent; }
    }
    public static class TPeriodIntraFrepMeasurement extends KaitaiStruct {
        public static TPeriodIntraFrepMeasurement fromFile(String fileName) throws IOException {
            return new TPeriodIntraFrepMeasurement(new ByteBufferKaitaiStream(fileName));
        }

        public TPeriodIntraFrepMeasurement(KaitaiStream _io) {
            this(_io, null, null);
        }

        public TPeriodIntraFrepMeasurement(KaitaiStream _io, HuaweiChrEventFile.TEventRecord _parent) {
            this(_io, _parent, null);
        }

        public TPeriodIntraFrepMeasurement(KaitaiStream _io, HuaweiChrEventFile.TEventRecord _parent, HuaweiChrEventFile _root) {
            super(_io);
            this._parent = _parent;
            this._root = _root;
            _read();
        }
        private void _read() {
            this.measurementId = this._io.readU1();
            this.rsrpRslt = this._io.readU1();
            this.rsrqRslt = this._io.readU1();
            this.nCellCount = this._io.readU1();
            if (nCellCount() > 0) {
                this.cellInfoList = new ArrayList<TENcellInfo>();
                for (int i = 0; i < nCellCount(); i++) {
                    this.cellInfoList.add(new TENcellInfo(this._io, this, _root));
                }
            }
        }
        private int measurementId;
        private int rsrpRslt;
        private int rsrqRslt;
        private int nCellCount;
        private ArrayList<TENcellInfo> cellInfoList;
        private HuaweiChrEventFile _root;
        private HuaweiChrEventFile.TEventRecord _parent;
        public int measurementId() { return measurementId; }
        public int rsrpRslt() { return rsrpRslt; }
        public int rsrqRslt() { return rsrqRslt; }
        public int nCellCount() { return nCellCount; }
        public ArrayList<TENcellInfo> cellInfoList() { return cellInfoList; }
        public HuaweiChrEventFile _root() { return _root; }
        public HuaweiChrEventFile.TEventRecord _parent() { return _parent; }
    }
    public static class TPciArfcnInfo100c extends KaitaiStruct {
        public static TPciArfcnInfo100c fromFile(String fileName) throws IOException {
            return new TPciArfcnInfo100c(new ByteBufferKaitaiStream(fileName));
        }

        public TPciArfcnInfo100c(KaitaiStream _io) {
            this(_io, null, null);
        }

        public TPciArfcnInfo100c(KaitaiStream _io, HuaweiChrEventFile.TFailedPcellInfo100c _parent) {
            this(_io, _parent, null);
        }

        public TPciArfcnInfo100c(KaitaiStream _io, HuaweiChrEventFile.TFailedPcellInfo100c _parent, HuaweiChrEventFile _root) {
            super(_io);
            this._parent = _parent;
            this._root = _root;
            _read();
        }
        private void _read() {
            this.pci = this._io.readU2be();
            this.carrierFrequency = this._io.readU2be();
        }
        private int pci;
        private int carrierFrequency;
        private HuaweiChrEventFile _root;
        private HuaweiChrEventFile.TFailedPcellInfo100c _parent;
        public int pci() { return pci; }
        public int carrierFrequency() { return carrierFrequency; }
        public HuaweiChrEventFile _root() { return _root; }
        public HuaweiChrEventFile.TFailedPcellInfo100c _parent() { return _parent; }
    }
    public static class TPeriodInterFreqMr extends KaitaiStruct {
        public static TPeriodInterFreqMr fromFile(String fileName) throws IOException {
            return new TPeriodInterFreqMr(new ByteBufferKaitaiStream(fileName));
        }

        public TPeriodInterFreqMr(KaitaiStream _io) {
            this(_io, null, null);
        }

        public TPeriodInterFreqMr(KaitaiStream _io, HuaweiChrEventFile.TEventRecord _parent) {
            this(_io, _parent, null);
        }

        public TPeriodInterFreqMr(KaitaiStream _io, HuaweiChrEventFile.TEventRecord _parent, HuaweiChrEventFile _root) {
            super(_io);
            this._parent = _parent;
            this._root = _root;
            _read();
        }
        private void _read() {
            this.measurementId = this._io.readU1();
            this.servingCellRsrp = this._io.readU1();
            this.servingCellRsrq = this._io.readU1();
            this.ncellCount = this._io.readU1();
            this.ncellInfoList = new ArrayList<TInterFreqNcellInfo>();
            for (int i = 0; i < ncellCount(); i++) {
                this.ncellInfoList.add(new TInterFreqNcellInfo(this._io, this, _root));
            }
        }
        private int measurementId;
        private int servingCellRsrp;
        private int servingCellRsrq;
        private int ncellCount;
        private ArrayList<TInterFreqNcellInfo> ncellInfoList;
        private HuaweiChrEventFile _root;
        private HuaweiChrEventFile.TEventRecord _parent;
        public int measurementId() { return measurementId; }
        public int servingCellRsrp() { return servingCellRsrp; }
        public int servingCellRsrq() { return servingCellRsrq; }
        public int ncellCount() { return ncellCount; }
        public ArrayList<TInterFreqNcellInfo> ncellInfoList() { return ncellInfoList; }
        public HuaweiChrEventFile _root() { return _root; }
        public HuaweiChrEventFile.TEventRecord _parent() { return _parent; }
    }
    public static class TPreviousPcellInfo extends KaitaiStruct {
        public static TPreviousPcellInfo fromFile(String fileName) throws IOException {
            return new TPreviousPcellInfo(new ByteBufferKaitaiStream(fileName));
        }

        public TPreviousPcellInfo(KaitaiStream _io) {
            this(_io, null, null);
        }

        public TPreviousPcellInfo(KaitaiStream _io, KaitaiStruct _parent) {
            this(_io, _parent, null);
        }

        public TPreviousPcellInfo(KaitaiStream _io, KaitaiStruct _parent, HuaweiChrEventFile _root) {
            super(_io);
            this._parent = _parent;
            this._root = _root;
            _read();
        }
        private void _read() {
            this.plmn = new TPlmnFormat1(this._io, this, _root);
            this.cellId = this._io.readU4be();
        }
        private TPlmnFormat1 plmn;
        private long cellId;
        private HuaweiChrEventFile _root;
        private KaitaiStruct _parent;
        public TPlmnFormat1 plmn() { return plmn; }
        public long cellId() { return cellId; }
        public HuaweiChrEventFile _root() { return _root; }
        public KaitaiStruct _parent() { return _parent; }
    }
    public static class TRadioLinkFailureReport extends KaitaiStruct {
        public static TRadioLinkFailureReport fromFile(String fileName) throws IOException {
            return new TRadioLinkFailureReport(new ByteBufferKaitaiStream(fileName));
        }

        public TRadioLinkFailureReport(KaitaiStream _io) {
            this(_io, null, null);
        }

        public TRadioLinkFailureReport(KaitaiStream _io, HuaweiChrEventFile.TEventRecord _parent) {
            this(_io, _parent, null);
        }

        public TRadioLinkFailureReport(KaitaiStream _io, HuaweiChrEventFile.TEventRecord _parent, HuaweiChrEventFile _root) {
            super(_io);
            this._parent = _parent;
            this._root = _root;
            _read();
        }
        private void _read() {
            this.servingCellRsrp = this._io.readU1();
            this.servingCellRsrq = this._io.readU1();
            this.failedPcellInfo = new TFailedPcellInfo100c(this._io, this, _root);
            this.reEstablishmentCellInfo = new TReEstablishmentCellInfo(this._io, this, _root);
            this.timeConnectionFailure = this._io.readU2be();
            this.connectionFailureType = this._io.readU1();
            this.previousPcellInfo = new TPreviousPcellInfo(this._io, this, _root);
            this.eutranNcellMrValidFlag = this._io.readU1();
            this.eutranCarrierFrequencyCount = this._io.readU1();
            this.eutranCarrierFrequencyList = new ArrayList<TEutranCarrierInfo100c>();
            for (int i = 0; i < eutranCarrierFrequencyCount(); i++) {
                this.eutranCarrierFrequencyList.add(new TEutranCarrierInfo100c(this._io, this, _root));
            }
            this.utranNcellMrValidFlag = this._io.readU1();
            this.utranCarrierFrequencyCount = this._io.readU1();
            this.utranCarrierFrequencyList = new ArrayList<TUtranCarrierInfo>();
            for (int i = 0; i < utranCarrierFrequencyCount(); i++) {
                this.utranCarrierFrequencyList.add(new TUtranCarrierInfo(this._io, this, _root));
            }
            this.geranNcellMrValidFlag = this._io.readU1();
            this.geranNcellCount = this._io.readU1();
            this.geranNcellInfoList = new ArrayList<TGeranNcellInfo>();
            for (int i = 0; i < geranNcellCount(); i++) {
                this.geranNcellInfoList.add(new TGeranNcellInfo(this._io, this, _root));
            }
            this.cdma2000NcellMrValidFlag = this._io.readU1();
            this.cdma2000CarrierFrequencyCount = this._io.readU1();
            this.cdma2000CarrierFrequencyList = new ArrayList<TCdma2000CarrierInfo>();
            for (int i = 0; i < cdma2000CarrierFrequencyCount(); i++) {
                this.cdma2000CarrierFrequencyList.add(new TCdma2000CarrierInfo(this._io, this, _root));
            }
        }
        private int servingCellRsrp;
        private int servingCellRsrq;
        private TFailedPcellInfo100c failedPcellInfo;
        private TReEstablishmentCellInfo reEstablishmentCellInfo;
        private int timeConnectionFailure;
        private int connectionFailureType;
        private TPreviousPcellInfo previousPcellInfo;
        private int eutranNcellMrValidFlag;
        private int eutranCarrierFrequencyCount;
        private ArrayList<TEutranCarrierInfo100c> eutranCarrierFrequencyList;
        private int utranNcellMrValidFlag;
        private int utranCarrierFrequencyCount;
        private ArrayList<TUtranCarrierInfo> utranCarrierFrequencyList;
        private int geranNcellMrValidFlag;
        private int geranNcellCount;
        private ArrayList<TGeranNcellInfo> geranNcellInfoList;
        private int cdma2000NcellMrValidFlag;
        private int cdma2000CarrierFrequencyCount;
        private ArrayList<TCdma2000CarrierInfo> cdma2000CarrierFrequencyList;
        private HuaweiChrEventFile _root;
        private HuaweiChrEventFile.TEventRecord _parent;
        public int servingCellRsrp() { return servingCellRsrp; }
        public int servingCellRsrq() { return servingCellRsrq; }
        public TFailedPcellInfo100c failedPcellInfo() { return failedPcellInfo; }
        public TReEstablishmentCellInfo reEstablishmentCellInfo() { return reEstablishmentCellInfo; }
        public int timeConnectionFailure() { return timeConnectionFailure; }
        public int connectionFailureType() { return connectionFailureType; }
        public TPreviousPcellInfo previousPcellInfo() { return previousPcellInfo; }
        public int eutranNcellMrValidFlag() { return eutranNcellMrValidFlag; }
        public int eutranCarrierFrequencyCount() { return eutranCarrierFrequencyCount; }
        public ArrayList<TEutranCarrierInfo100c> eutranCarrierFrequencyList() { return eutranCarrierFrequencyList; }
        public int utranNcellMrValidFlag() { return utranNcellMrValidFlag; }
        public int utranCarrierFrequencyCount() { return utranCarrierFrequencyCount; }
        public ArrayList<TUtranCarrierInfo> utranCarrierFrequencyList() { return utranCarrierFrequencyList; }
        public int geranNcellMrValidFlag() { return geranNcellMrValidFlag; }
        public int geranNcellCount() { return geranNcellCount; }
        public ArrayList<TGeranNcellInfo> geranNcellInfoList() { return geranNcellInfoList; }
        public int cdma2000NcellMrValidFlag() { return cdma2000NcellMrValidFlag; }
        public int cdma2000CarrierFrequencyCount() { return cdma2000CarrierFrequencyCount; }
        public ArrayList<TCdma2000CarrierInfo> cdma2000CarrierFrequencyList() { return cdma2000CarrierFrequencyList; }
        public HuaweiChrEventFile _root() { return _root; }
        public HuaweiChrEventFile.TEventRecord _parent() { return _parent; }
    }
    public static class TUeEventNcellInfo extends KaitaiStruct {
        public static TUeEventNcellInfo fromFile(String fileName) throws IOException {
            return new TUeEventNcellInfo(new ByteBufferKaitaiStream(fileName));
        }

        public TUeEventNcellInfo(KaitaiStream _io) {
            this(_io, null, null);
        }

        public TUeEventNcellInfo(KaitaiStream _io, HuaweiChrEventFile.TUeEventMr _parent) {
            this(_io, _parent, null);
        }

        public TUeEventNcellInfo(KaitaiStream _io, HuaweiChrEventFile.TUeEventMr _parent, HuaweiChrEventFile _root) {
            super(_io);
            this._parent = _parent;
            this._root = _root;
            _read();
        }
        private void _read() {
            this.ncellType = this._io.readU1();
            if (ncellType() == 1) {
                this.eutranNcellInfo = new TUeEutranNcellInfo(this._io, this, _root);
            }
            if (ncellType() == 2) {
                this.wcdmaNcellInfo = new TUeWcdmaNcellInfo(this._io, this, _root);
            }
            if (ncellType() == 3) {
                this.geranNcellInfo = new TUeGeranNcellInfo(this._io, this, _root);
            }
            if (ncellType() == 4) {
                this.cdma2000NcellInfo = new TUeCdma2000NcellInfo(this._io, this, _root);
            }
            if (ncellType() == 5) {
                this.tdScdmaNcellInfo = new TUeTdScdmaNcellInfo(this._io, this, _root);
            }
            if (ncellType() == 6) {
                this.nrNcellInfo = new TUeNrNcellInfo(this._io, this, _root);
            }
            if (ncellType() == 255) {
                this.noNeighborCell = new TUeNoNeighborCell(this._io, this, _root);
            }
        }
        private int ncellType;
        private TUeEutranNcellInfo eutranNcellInfo;
        private TUeWcdmaNcellInfo wcdmaNcellInfo;
        private TUeGeranNcellInfo geranNcellInfo;
        private TUeCdma2000NcellInfo cdma2000NcellInfo;
        private TUeTdScdmaNcellInfo tdScdmaNcellInfo;
        private TUeNrNcellInfo nrNcellInfo;
        private TUeNoNeighborCell noNeighborCell;
        private HuaweiChrEventFile _root;
        private HuaweiChrEventFile.TUeEventMr _parent;
        public int ncellType() { return ncellType; }
        public TUeEutranNcellInfo eutranNcellInfo() { return eutranNcellInfo; }
        public TUeWcdmaNcellInfo wcdmaNcellInfo() { return wcdmaNcellInfo; }
        public TUeGeranNcellInfo geranNcellInfo() { return geranNcellInfo; }
        public TUeCdma2000NcellInfo cdma2000NcellInfo() { return cdma2000NcellInfo; }
        public TUeTdScdmaNcellInfo tdScdmaNcellInfo() { return tdScdmaNcellInfo; }
        public TUeNrNcellInfo nrNcellInfo() { return nrNcellInfo; }
        public TUeNoNeighborCell noNeighborCell() { return noNeighborCell; }
        public HuaweiChrEventFile _root() { return _root; }
        public HuaweiChrEventFile.TUeEventMr _parent() { return _parent; }
    }
    public static class TTdscdmaNcellInfo extends KaitaiStruct {
        public static TTdscdmaNcellInfo fromFile(String fileName) throws IOException {
            return new TTdscdmaNcellInfo(new ByteBufferKaitaiStream(fileName));
        }

        public TTdscdmaNcellInfo(KaitaiStream _io) {
            this(_io, null, null);
        }

        public TTdscdmaNcellInfo(KaitaiStream _io, HuaweiChrEventFile.TUeTdScdmaNcellInfo _parent) {
            this(_io, _parent, null);
        }

        public TTdscdmaNcellInfo(KaitaiStream _io, HuaweiChrEventFile.TUeTdScdmaNcellInfo _parent, HuaweiChrEventFile _root) {
            super(_io);
            this._parent = _parent;
            this._root = _root;
            _read();
        }
        private void _read() {
            this.pci = this._io.readU1();
            this.pccpchRscp = this._io.readS1();
        }
        private int pci;
        private byte pccpchRscp;
        private HuaweiChrEventFile _root;
        private HuaweiChrEventFile.TUeTdScdmaNcellInfo _parent;
        public int pci() { return pci; }
        public byte pccpchRscp() { return pccpchRscp; }
        public HuaweiChrEventFile _root() { return _root; }
        public HuaweiChrEventFile.TUeTdScdmaNcellInfo _parent() { return _parent; }
    }
    public static class TUeEventMr extends KaitaiStruct {
        public static TUeEventMr fromFile(String fileName) throws IOException {
            return new TUeEventMr(new ByteBufferKaitaiStream(fileName));
        }

        public TUeEventMr(KaitaiStream _io) {
            this(_io, null, null);
        }

        public TUeEventMr(KaitaiStream _io, HuaweiChrEventFile.TEventRecord _parent) {
            this(_io, _parent, null);
        }

        public TUeEventMr(KaitaiStream _io, HuaweiChrEventFile.TEventRecord _parent, HuaweiChrEventFile _root) {
            super(_io);
            this._parent = _parent;
            this._root = _root;
            _read();
        }
        private void _read() {
            this.measurementId = this._io.readU1();
            this.eventType = this._io.readU1();
            this.servingCellPci = this._io.readU2be();
            this.servingCellRsrp = this._io.readU1();
            this.servingCellRsrq = this._io.readU1();
            this.ueEventNcellInfo = new TUeEventNcellInfo(this._io, this, _root);
        }
        private int measurementId;
        private int eventType;
        private int servingCellPci;
        private int servingCellRsrp;
        private int servingCellRsrq;
        private TUeEventNcellInfo ueEventNcellInfo;
        private HuaweiChrEventFile _root;
        private HuaweiChrEventFile.TEventRecord _parent;
        public int measurementId() { return measurementId; }
        public int eventType() { return eventType; }
        public int servingCellPci() { return servingCellPci; }
        public int servingCellRsrp() { return servingCellRsrp; }
        public int servingCellRsrq() { return servingCellRsrq; }
        public TUeEventNcellInfo ueEventNcellInfo() { return ueEventNcellInfo; }
        public HuaweiChrEventFile _root() { return _root; }
        public HuaweiChrEventFile.TEventRecord _parent() { return _parent; }
    }
    public static class TInterFreqMdtNcellInfo extends KaitaiStruct {
        public static TInterFreqMdtNcellInfo fromFile(String fileName) throws IOException {
            return new TInterFreqMdtNcellInfo(new ByteBufferKaitaiStream(fileName));
        }

        public TInterFreqMdtNcellInfo(KaitaiStream _io) {
            this(_io, null, null);
        }

        public TInterFreqMdtNcellInfo(KaitaiStream _io, HuaweiChrEventFile.TPeriodInterFreqMrMdt _parent) {
            this(_io, _parent, null);
        }

        public TInterFreqMdtNcellInfo(KaitaiStream _io, HuaweiChrEventFile.TPeriodInterFreqMrMdt _parent, HuaweiChrEventFile _root) {
            super(_io);
            this._parent = _parent;
            this._root = _root;
            _read();
        }
        private void _read() {
            this.cellId = this._io.readU4be();
            this.pci = this._io.readU2be();
            this.carrierFrequency = this._io.readU2be();
            this.rsrp = this._io.readU1();
            this.rsrq = this._io.readU1();
        }
        private long cellId;
        private int pci;
        private int carrierFrequency;
        private int rsrp;
        private int rsrq;
        private HuaweiChrEventFile _root;
        private HuaweiChrEventFile.TPeriodInterFreqMrMdt _parent;
        public long cellId() { return cellId; }
        public int pci() { return pci; }
        public int carrierFrequency() { return carrierFrequency; }
        public int rsrp() { return rsrp; }
        public int rsrq() { return rsrq; }
        public HuaweiChrEventFile _root() { return _root; }
        public HuaweiChrEventFile.TPeriodInterFreqMrMdt _parent() { return _parent; }
    }
    public static class TUeCdma2000NcellInfo extends KaitaiStruct {
        public static TUeCdma2000NcellInfo fromFile(String fileName) throws IOException {
            return new TUeCdma2000NcellInfo(new ByteBufferKaitaiStream(fileName));
        }

        public TUeCdma2000NcellInfo(KaitaiStream _io) {
            this(_io, null, null);
        }

        public TUeCdma2000NcellInfo(KaitaiStream _io, KaitaiStruct _parent) {
            this(_io, _parent, null);
        }

        public TUeCdma2000NcellInfo(KaitaiStream _io, KaitaiStruct _parent, HuaweiChrEventFile _root) {
            super(_io);
            this._parent = _parent;
            this._root = _root;
            _read();
        }
        private void _read() {
            this.ncellCount = this._io.readU1();
            this.ncellList = new ArrayList<TCdma2000NcellInfoList>();
            for (int i = 0; i < ncellCount(); i++) {
                this.ncellList.add(new TCdma2000NcellInfoList(this._io, this, _root));
            }
        }
        private int ncellCount;
        private ArrayList<TCdma2000NcellInfoList> ncellList;
        private HuaweiChrEventFile _root;
        private KaitaiStruct _parent;
        public int ncellCount() { return ncellCount; }
        public ArrayList<TCdma2000NcellInfoList> ncellList() { return ncellList; }
        public HuaweiChrEventFile _root() { return _root; }
        public KaitaiStruct _parent() { return _parent; }
    }
    public static class TEllipsoidPointWithUncertaintyCircleInfo extends KaitaiStruct {
        public static TEllipsoidPointWithUncertaintyCircleInfo fromFile(String fileName) throws IOException {
            return new TEllipsoidPointWithUncertaintyCircleInfo(new ByteBufferKaitaiStream(fileName));
        }

        public TEllipsoidPointWithUncertaintyCircleInfo(KaitaiStream _io) {
            this(_io, null, null);
        }

        public TEllipsoidPointWithUncertaintyCircleInfo(KaitaiStream _io, KaitaiStruct _parent) {
            this(_io, _parent, null);
        }

        public TEllipsoidPointWithUncertaintyCircleInfo(KaitaiStream _io, KaitaiStruct _parent, HuaweiChrEventFile _root) {
            super(_io);
            this._parent = _parent;
            this._root = _root;
            _read();
        }
        private void _read() {
            this.latitudeSign = this._io.readU1();
            this.degreesLatitude = this._io.readU4be();
            this.degreesLongitude = this._io.readU4be();
            this.uncertainty = this._io.readU1();
        }
        private int latitudeSign;
        private long degreesLatitude;
        private long degreesLongitude;
        private int uncertainty;
        private HuaweiChrEventFile _root;
        private KaitaiStruct _parent;
        public int latitudeSign() { return latitudeSign; }
        public long degreesLatitude() { return degreesLatitude; }
        public long degreesLongitude() { return degreesLongitude; }
        public int uncertainty() { return uncertainty; }
        public HuaweiChrEventFile _root() { return _root; }
        public KaitaiStruct _parent() { return _parent; }
    }
    public static class TCdma2000NcellInfoList extends KaitaiStruct {
        public static TCdma2000NcellInfoList fromFile(String fileName) throws IOException {
            return new TCdma2000NcellInfoList(new ByteBufferKaitaiStream(fileName));
        }

        public TCdma2000NcellInfoList(KaitaiStream _io) {
            this(_io, null, null);
        }

        public TCdma2000NcellInfoList(KaitaiStream _io, KaitaiStruct _parent) {
            this(_io, _parent, null);
        }

        public TCdma2000NcellInfoList(KaitaiStream _io, KaitaiStruct _parent, HuaweiChrEventFile _root) {
            super(_io);
            this._parent = _parent;
            this._root = _root;
            _read();
        }
        private void _read() {
            this.pci = this._io.readU2be();
            this.pilotPnPhase = this._io.readU2be();
            this.pilotStrength = this._io.readU1();
        }
        private int pci;
        private int pilotPnPhase;
        private int pilotStrength;
        private HuaweiChrEventFile _root;
        private KaitaiStruct _parent;
        public int pci() { return pci; }
        public int pilotPnPhase() { return pilotPnPhase; }
        public int pilotStrength() { return pilotStrength; }
        public HuaweiChrEventFile _root() { return _root; }
        public KaitaiStruct _parent() { return _parent; }
    }
    public static class TUtranNcellInfoList extends KaitaiStruct {
        public static TUtranNcellInfoList fromFile(String fileName) throws IOException {
            return new TUtranNcellInfoList(new ByteBufferKaitaiStream(fileName));
        }

        public TUtranNcellInfoList(KaitaiStream _io) {
            this(_io, null, null);
        }

        public TUtranNcellInfoList(KaitaiStream _io, HuaweiChrEventFile.TUtranCarrierInfo _parent) {
            this(_io, _parent, null);
        }

        public TUtranNcellInfoList(KaitaiStream _io, HuaweiChrEventFile.TUtranCarrierInfo _parent, HuaweiChrEventFile _root) {
            super(_io);
            this._parent = _parent;
            this._root = _root;
            _read();
        }
        private void _read() {
            this.pci = this._io.readU2be();
            this.rscp = this._io.readS1();
            this.ecNo = this._io.readU1();
        }
        private int pci;
        private byte rscp;
        private int ecNo;
        private HuaweiChrEventFile _root;
        private HuaweiChrEventFile.TUtranCarrierInfo _parent;
        public int pci() { return pci; }
        public byte rscp() { return rscp; }
        public int ecNo() { return ecNo; }
        public HuaweiChrEventFile _root() { return _root; }
        public HuaweiChrEventFile.TUtranCarrierInfo _parent() { return _parent; }
    }
    public static class TChrHeader extends KaitaiStruct {
        public static TChrHeader fromFile(String fileName) throws IOException {
            return new TChrHeader(new ByteBufferKaitaiStream(fileName));
        }

        public TChrHeader(KaitaiStream _io) {
            this(_io, null, null);
        }

        public TChrHeader(KaitaiStream _io, HuaweiChrEventFile.TEventRecord _parent) {
            this(_io, _parent, null);
        }

        public TChrHeader(KaitaiStream _io, HuaweiChrEventFile.TEventRecord _parent, HuaweiChrEventFile _root) {
            super(_io);
            this._parent = _parent;
            this._root = _root;
            _read();
        }
        private void _read() {
            this.eventId = this._io.readU2be();
            this.eventLength = this._io.readU4be();
            this.eNodeBid = this._io.readU4be();
            this.cellId = this._io.readU1();
            this.callId = this._io.readU4be();
            this.datetimeYear = this._io.readU1();
            this.datetimeMonth = this._io.readU1();
            this.datetimeDay = this._io.readU1();
            this.datetimeHour = this._io.readU1();
            this.datetimeMinute = this._io.readU1();
            this.datetimeSecond = this._io.readU1();
            this.datetimeMillisecond = this._io.readU2be();
            this.extendHeadLen = this._io.readU1();
            this.itemtypeAndReserved = this._io.readU1();
            this.cRnti = this._io.readU2be();
        }
        private int eventId;
        private long eventLength;
        private long eNodeBid;
        private int cellId;
        private long callId;
        private int datetimeYear;
        private int datetimeMonth;
        private int datetimeDay;
        private int datetimeHour;
        private int datetimeMinute;
        private int datetimeSecond;
        private int datetimeMillisecond;
        private int extendHeadLen;
        private int itemtypeAndReserved;
        private int cRnti;
        private HuaweiChrEventFile _root;
        private HuaweiChrEventFile.TEventRecord _parent;
        public int eventId() { return eventId; }
        public long eventLength() { return eventLength; }
        public long eNodeBid() { return eNodeBid; }
        public int cellId() { return cellId; }
        public long callId() { return callId; }
        public int datetimeYear() { return datetimeYear; }
        public int datetimeMonth() { return datetimeMonth; }
        public int datetimeDay() { return datetimeDay; }
        public int datetimeHour() { return datetimeHour; }
        public int datetimeMinute() { return datetimeMinute; }
        public int datetimeSecond() { return datetimeSecond; }
        public int datetimeMillisecond() { return datetimeMillisecond; }
        public int extendHeadLen() { return extendHeadLen; }
        public int itemtypeAndReserved() { return itemtypeAndReserved; }
        public int cRnti() { return cRnti; }
        public HuaweiChrEventFile _root() { return _root; }
        public HuaweiChrEventFile.TEventRecord _parent() { return _parent; }
    }
    public static class TERabThroughputStatM4mdt extends KaitaiStruct {
        public static TERabThroughputStatM4mdt fromFile(String fileName) throws IOException {
            return new TERabThroughputStatM4mdt(new ByteBufferKaitaiStream(fileName));
        }

        public TERabThroughputStatM4mdt(KaitaiStream _io) {
            this(_io, null, null);
        }

        public TERabThroughputStatM4mdt(KaitaiStream _io, HuaweiChrEventFile.TPeriodPrivateThroughputMeasurementM4mdt _parent) {
            this(_io, _parent, null);
        }

        public TERabThroughputStatM4mdt(KaitaiStream _io, HuaweiChrEventFile.TPeriodPrivateThroughputMeasurementM4mdt _parent, HuaweiChrEventFile _root) {
            super(_io);
            this._parent = _parent;
            this._root = _root;
            _read();
        }
        private void _read() {
            this.eRabId = this._io.readU1();
            this.qci = this._io.readU1();
            this.ulDataVolume = this._io.readU4be();
            this.dlDataVolume = this._io.readU4be();
        }
        private int eRabId;
        private int qci;
        private long ulDataVolume;
        private long dlDataVolume;
        private HuaweiChrEventFile _root;
        private HuaweiChrEventFile.TPeriodPrivateThroughputMeasurementM4mdt _parent;
        public int eRabId() { return eRabId; }
        public int qci() { return qci; }
        public long ulDataVolume() { return ulDataVolume; }
        public long dlDataVolume() { return dlDataVolume; }
        public HuaweiChrEventFile _root() { return _root; }
        public HuaweiChrEventFile.TPeriodPrivateThroughputMeasurementM4mdt _parent() { return _parent; }
    }
    public static class TUePeriodRadioLinkMrMdt extends KaitaiStruct {
        public static TUePeriodRadioLinkMrMdt fromFile(String fileName) throws IOException {
            return new TUePeriodRadioLinkMrMdt(new ByteBufferKaitaiStream(fileName));
        }

        public TUePeriodRadioLinkMrMdt(KaitaiStream _io) {
            this(_io, null, null);
        }

        public TUePeriodRadioLinkMrMdt(KaitaiStream _io, HuaweiChrEventFile.TEventRecord _parent) {
            this(_io, _parent, null);
        }

        public TUePeriodRadioLinkMrMdt(KaitaiStream _io, HuaweiChrEventFile.TEventRecord _parent, HuaweiChrEventFile _root) {
            super(_io);
            this._parent = _parent;
            this._root = _root;
            _read();
        }
        private void _read() {
            this.uePhr = this._io.readU1();
            this.dlWidebandCqiCode0 = this._io.readU1();
            this.dlWidebandCqiCode1 = this._io.readU1();
            this.ulDmrsSinr = this._io.readS4be();
            this.taValue = this._io.readU4be();
            this.preambleTaValue = this._io.readU4be();
        }
        private int uePhr;
        private int dlWidebandCqiCode0;
        private int dlWidebandCqiCode1;
        private int ulDmrsSinr;
        private long taValue;
        private long preambleTaValue;
        private HuaweiChrEventFile _root;
        private HuaweiChrEventFile.TEventRecord _parent;
        public int uePhr() { return uePhr; }
        public int dlWidebandCqiCode0() { return dlWidebandCqiCode0; }
        public int dlWidebandCqiCode1() { return dlWidebandCqiCode1; }
        public int ulDmrsSinr() { return ulDmrsSinr; }
        public long taValue() { return taValue; }
        public long preambleTaValue() { return preambleTaValue; }
        public HuaweiChrEventFile _root() { return _root; }
        public HuaweiChrEventFile.TEventRecord _parent() { return _parent; }
    }
    public static class TIntraFreqMdtNcellInfo extends KaitaiStruct {
        public static TIntraFreqMdtNcellInfo fromFile(String fileName) throws IOException {
            return new TIntraFreqMdtNcellInfo(new ByteBufferKaitaiStream(fileName));
        }

        public TIntraFreqMdtNcellInfo(KaitaiStream _io) {
            this(_io, null, null);
        }

        public TIntraFreqMdtNcellInfo(KaitaiStream _io, HuaweiChrEventFile.TPeriodIntraFreqMrMdt _parent) {
            this(_io, _parent, null);
        }

        public TIntraFreqMdtNcellInfo(KaitaiStream _io, HuaweiChrEventFile.TPeriodIntraFreqMrMdt _parent, HuaweiChrEventFile _root) {
            super(_io);
            this._parent = _parent;
            this._root = _root;
            _read();
        }
        private void _read() {
            this.pci = this._io.readU2be();
            this.rsrp = this._io.readU1();
            this.rsrq = this._io.readU1();
        }
        private int pci;
        private int rsrp;
        private int rsrq;
        private HuaweiChrEventFile _root;
        private HuaweiChrEventFile.TPeriodIntraFreqMrMdt _parent;
        public int pci() { return pci; }
        public int rsrp() { return rsrp; }
        public int rsrq() { return rsrq; }
        public HuaweiChrEventFile _root() { return _root; }
        public HuaweiChrEventFile.TPeriodIntraFreqMrMdt _parent() { return _parent; }
    }
    public static class TPeriodPrivateUeMeasurementM2extmdt extends KaitaiStruct {
        public static TPeriodPrivateUeMeasurementM2extmdt fromFile(String fileName) throws IOException {
            return new TPeriodPrivateUeMeasurementM2extmdt(new ByteBufferKaitaiStream(fileName));
        }

        public TPeriodPrivateUeMeasurementM2extmdt(KaitaiStream _io) {
            this(_io, null, null);
        }

        public TPeriodPrivateUeMeasurementM2extmdt(KaitaiStream _io, HuaweiChrEventFile.TEventRecord _parent) {
            this(_io, _parent, null);
        }

        public TPeriodPrivateUeMeasurementM2extmdt(KaitaiStream _io, HuaweiChrEventFile.TEventRecord _parent, HuaweiChrEventFile _root) {
            super(_io);
            this._parent = _parent;
            this._root = _root;
            _read();
        }
        private void _read() {
            this.ulRetransErrorNumber = this._io.readU4be();
            this.ulCrcInitTransTotalNumber = this._io.readU4be();
            this.dlRetransErrorNumber = this._io.readU4be();
            this.dlCode0InitTransTotalNumber = this._io.readU4be();
            this.dlCode1InitTransTotalNumber = this._io.readU4be();
            this.ulRbUsedNumber = this._io.readU4be();
            this.dlRbUsedNumber = this._io.readU4be();
            this.dlWidebandCqiCode0 = this._io.readU1();
            this.dlWidebandCqiCode1 = this._io.readU1();
            this.rankIndication = this._io.readU1();
        }
        private long ulRetransErrorNumber;
        private long ulCrcInitTransTotalNumber;
        private long dlRetransErrorNumber;
        private long dlCode0InitTransTotalNumber;
        private long dlCode1InitTransTotalNumber;
        private long ulRbUsedNumber;
        private long dlRbUsedNumber;
        private int dlWidebandCqiCode0;
        private int dlWidebandCqiCode1;
        private int rankIndication;
        private HuaweiChrEventFile _root;
        private HuaweiChrEventFile.TEventRecord _parent;
        public long ulRetransErrorNumber() { return ulRetransErrorNumber; }
        public long ulCrcInitTransTotalNumber() { return ulCrcInitTransTotalNumber; }
        public long dlRetransErrorNumber() { return dlRetransErrorNumber; }
        public long dlCode0InitTransTotalNumber() { return dlCode0InitTransTotalNumber; }
        public long dlCode1InitTransTotalNumber() { return dlCode1InitTransTotalNumber; }
        public long ulRbUsedNumber() { return ulRbUsedNumber; }
        public long dlRbUsedNumber() { return dlRbUsedNumber; }
        public int dlWidebandCqiCode0() { return dlWidebandCqiCode0; }
        public int dlWidebandCqiCode1() { return dlWidebandCqiCode1; }
        public int rankIndication() { return rankIndication; }
        public HuaweiChrEventFile _root() { return _root; }
        public HuaweiChrEventFile.TEventRecord _parent() { return _parent; }
    }
    public static class TPacketLossInfo extends KaitaiStruct {
        public static TPacketLossInfo fromFile(String fileName) throws IOException {
            return new TPacketLossInfo(new ByteBufferKaitaiStream(fileName));
        }

        public TPacketLossInfo(KaitaiStream _io) {
            this(_io, null, null);
        }

        public TPacketLossInfo(KaitaiStream _io, HuaweiChrEventFile.TPeriodPrivatePktlossrateMr _parent) {
            this(_io, _parent, null);
        }

        public TPacketLossInfo(KaitaiStream _io, HuaweiChrEventFile.TPeriodPrivatePktlossrateMr _parent, HuaweiChrEventFile _root) {
            super(_io);
            this._parent = _parent;
            this._root = _root;
            _read();
        }
        private void _read() {
            this.qci = this._io.readU1();
            this.dlPacketTotal = this._io.readU4be();
            this.dlUuPacketLoss = this._io.readU4be();
            this.dlPdcpPacketLoss = this._io.readU4be();
            this.ulPacketTotal = this._io.readU4be();
            this.ulPacketLoss = this._io.readU4be();
        }
        private int qci;
        private long dlPacketTotal;
        private long dlUuPacketLoss;
        private long dlPdcpPacketLoss;
        private long ulPacketTotal;
        private long ulPacketLoss;
        private HuaweiChrEventFile _root;
        private HuaweiChrEventFile.TPeriodPrivatePktlossrateMr _parent;
        public int qci() { return qci; }
        public long dlPacketTotal() { return dlPacketTotal; }
        public long dlUuPacketLoss() { return dlUuPacketLoss; }
        public long dlPdcpPacketLoss() { return dlPdcpPacketLoss; }
        public long ulPacketTotal() { return ulPacketTotal; }
        public long ulPacketLoss() { return ulPacketLoss; }
        public HuaweiChrEventFile _root() { return _root; }
        public HuaweiChrEventFile.TPeriodPrivatePktlossrateMr _parent() { return _parent; }
    }
    public static class TGeranNcellInfo extends KaitaiStruct {
        public static TGeranNcellInfo fromFile(String fileName) throws IOException {
            return new TGeranNcellInfo(new ByteBufferKaitaiStream(fileName));
        }

        public TGeranNcellInfo(KaitaiStream _io) {
            this(_io, null, null);
        }

        public TGeranNcellInfo(KaitaiStream _io, KaitaiStruct _parent) {
            this(_io, _parent, null);
        }

        public TGeranNcellInfo(KaitaiStream _io, KaitaiStruct _parent, HuaweiChrEventFile _root) {
            super(_io);
            this._parent = _parent;
            this._root = _root;
            _read();
        }
        private void _read() {
            this.networkColourCode = this._io.readU1();
            this.baseStateColourCode = this._io.readU1();
            this.arfcn = this._io.readU2be();
            this.bindIndicator = this._io.readU1();
            this.rssi = this._io.readU1();
        }
        private int networkColourCode;
        private int baseStateColourCode;
        private int arfcn;
        private int bindIndicator;
        private int rssi;
        private HuaweiChrEventFile _root;
        private KaitaiStruct _parent;
        public int networkColourCode() { return networkColourCode; }
        public int baseStateColourCode() { return baseStateColourCode; }
        public int arfcn() { return arfcn; }
        public int bindIndicator() { return bindIndicator; }
        public int rssi() { return rssi; }
        public HuaweiChrEventFile _root() { return _root; }
        public KaitaiStruct _parent() { return _parent; }
    }
    public static class TUndefinedInfo extends KaitaiStruct {
        public static TUndefinedInfo fromFile(String fileName) throws IOException {
            return new TUndefinedInfo(new ByteBufferKaitaiStream(fileName));
        }

        public TUndefinedInfo(KaitaiStream _io) {
            this(_io, null, null);
        }

        public TUndefinedInfo(KaitaiStream _io, KaitaiStruct _parent) {
            this(_io, _parent, null);
        }

        public TUndefinedInfo(KaitaiStream _io, KaitaiStruct _parent, HuaweiChrEventFile _root) {
            super(_io);
            this._parent = _parent;
            this._root = _root;
            _read();
        }
        private void _read() {
            this.latitudeSign = this._io.readU1();
            this.degreesLatitude = this._io.readU4be();
            this.degreesLongitude = this._io.readU4be();
            this.altitudeSign = this._io.readU1();
            this.degreesAltitude = this._io.readU2be();
            this.uncertaintyCycle = this._io.readU1();
        }
        private int latitudeSign;
        private long degreesLatitude;
        private long degreesLongitude;
        private int altitudeSign;
        private int degreesAltitude;
        private int uncertaintyCycle;
        private HuaweiChrEventFile _root;
        private KaitaiStruct _parent;
        public int latitudeSign() { return latitudeSign; }
        public long degreesLatitude() { return degreesLatitude; }
        public long degreesLongitude() { return degreesLongitude; }
        public int altitudeSign() { return altitudeSign; }
        public int degreesAltitude() { return degreesAltitude; }
        public int uncertaintyCycle() { return uncertaintyCycle; }
        public HuaweiChrEventFile _root() { return _root; }
        public KaitaiStruct _parent() { return _parent; }
    }
    public static class TPeriodPrivateUeMeasurementM2mdt extends KaitaiStruct {
        public static TPeriodPrivateUeMeasurementM2mdt fromFile(String fileName) throws IOException {
            return new TPeriodPrivateUeMeasurementM2mdt(new ByteBufferKaitaiStream(fileName));
        }

        public TPeriodPrivateUeMeasurementM2mdt(KaitaiStream _io) {
            this(_io, null, null);
        }

        public TPeriodPrivateUeMeasurementM2mdt(KaitaiStream _io, HuaweiChrEventFile.TEventRecord _parent) {
            this(_io, _parent, null);
        }

        public TPeriodPrivateUeMeasurementM2mdt(KaitaiStream _io, HuaweiChrEventFile.TEventRecord _parent, HuaweiChrEventFile _root) {
            super(_io);
            this._parent = _parent;
            this._root = _root;
            _read();
        }
        private void _read() {
            this.uePhr = this._io.readU1();
        }
        private int uePhr;
        private HuaweiChrEventFile _root;
        private HuaweiChrEventFile.TEventRecord _parent;
        public int uePhr() { return uePhr; }
        public HuaweiChrEventFile _root() { return _root; }
        public HuaweiChrEventFile.TEventRecord _parent() { return _parent; }
    }
    public static class TUlPdcpDelayResult extends KaitaiStruct {
        public static TUlPdcpDelayResult fromFile(String fileName) throws IOException {
            return new TUlPdcpDelayResult(new ByteBufferKaitaiStream(fileName));
        }

        public TUlPdcpDelayResult(KaitaiStream _io) {
            this(_io, null, null);
        }

        public TUlPdcpDelayResult(KaitaiStream _io, HuaweiChrEventFile.TPeriodUeUlpdcpdelayMdt _parent) {
            this(_io, _parent, null);
        }

        public TUlPdcpDelayResult(KaitaiStream _io, HuaweiChrEventFile.TPeriodUeUlpdcpdelayMdt _parent, HuaweiChrEventFile _root) {
            super(_io);
            this._parent = _parent;
            this._root = _root;
            _read();
        }
        private void _read() {
            this.qciId = this._io.readU1();
            this.excessDelay = this._io.readU1();
        }
        private int qciId;
        private int excessDelay;
        private HuaweiChrEventFile _root;
        private HuaweiChrEventFile.TPeriodUeUlpdcpdelayMdt _parent;
        public int qciId() { return qciId; }
        public int excessDelay() { return excessDelay; }
        public HuaweiChrEventFile _root() { return _root; }
        public HuaweiChrEventFile.TPeriodUeUlpdcpdelayMdt _parent() { return _parent; }
    }
    public static class TFileHeader extends KaitaiStruct {
        public static TFileHeader fromFile(String fileName) throws IOException {
            return new TFileHeader(new ByteBufferKaitaiStream(fileName));
        }

        public TFileHeader(KaitaiStream _io) {
            this(_io, null, null);
        }

        public TFileHeader(KaitaiStream _io, HuaweiChrEventFile _parent) {
            this(_io, _parent, null);
        }

        public TFileHeader(KaitaiStream _io, HuaweiChrEventFile _parent, HuaweiChrEventFile _root) {
            super(_io);
            this._parent = _parent;
            this._root = _root;
            _read();
        }
        private void _read() {
            this.mainVersion = this._io.readU1();
            this.subVersion = this._io.readU1();
            this.traceNo = this._io.readU4be();
            this.reserved = this._io.readBytes(26);
        }
        private int mainVersion;
        private int subVersion;
        private long traceNo;
        private byte[] reserved;
        private HuaweiChrEventFile _root;
        private HuaweiChrEventFile _parent;
        public int mainVersion() { return mainVersion; }
        public int subVersion() { return subVersion; }
        public long traceNo() { return traceNo; }
        public byte[] reserved() { return reserved; }
        public HuaweiChrEventFile _root() { return _root; }
        public HuaweiChrEventFile _parent() { return _parent; }
    }
    public static class TPeriodUeTaMr extends KaitaiStruct {
        public static TPeriodUeTaMr fromFile(String fileName) throws IOException {
            return new TPeriodUeTaMr(new ByteBufferKaitaiStream(fileName));
        }

        public TPeriodUeTaMr(KaitaiStream _io) {
            this(_io, null, null);
        }

        public TPeriodUeTaMr(KaitaiStream _io, HuaweiChrEventFile.TEventRecord _parent) {
            this(_io, _parent, null);
        }

        public TPeriodUeTaMr(KaitaiStream _io, HuaweiChrEventFile.TEventRecord _parent, HuaweiChrEventFile _root) {
            super(_io);
            this._parent = _parent;
            this._root = _root;
            _read();
        }
        private void _read() {
            this.ta = this._io.readU4be();
        }
        private long ta;
        private HuaweiChrEventFile _root;
        private HuaweiChrEventFile.TEventRecord _parent;
        public long ta() { return ta; }
        public HuaweiChrEventFile _root() { return _root; }
        public HuaweiChrEventFile.TEventRecord _parent() { return _parent; }
    }
    public static class TERabThroughputStatM5mdt extends KaitaiStruct {
        public static TERabThroughputStatM5mdt fromFile(String fileName) throws IOException {
            return new TERabThroughputStatM5mdt(new ByteBufferKaitaiStream(fileName));
        }

        public TERabThroughputStatM5mdt(KaitaiStream _io) {
            this(_io, null, null);
        }

        public TERabThroughputStatM5mdt(KaitaiStream _io, HuaweiChrEventFile.TPeriodPrivateThroughputMeasurementM5mdt _parent) {
            this(_io, _parent, null);
        }

        public TERabThroughputStatM5mdt(KaitaiStream _io, HuaweiChrEventFile.TPeriodPrivateThroughputMeasurementM5mdt _parent, HuaweiChrEventFile _root) {
            super(_io);
            this._parent = _parent;
            this._root = _root;
            _read();
        }
        private void _read() {
            this.eRabId = this._io.readU1();
            this.qci = this._io.readU1();
            this.ulDataVolumePerERab = this._io.readU4be();
            this.ulDataTransmissionTimePerERab = this._io.readU4be();
            this.dlDataVolumePerERab = this._io.readU4be();
            this.dlDataTransmissionTimePerERab = this._io.readU4be();
        }
        private int eRabId;
        private int qci;
        private long ulDataVolumePerERab;
        private long ulDataTransmissionTimePerERab;
        private long dlDataVolumePerERab;
        private long dlDataTransmissionTimePerERab;
        private HuaweiChrEventFile _root;
        private HuaweiChrEventFile.TPeriodPrivateThroughputMeasurementM5mdt _parent;
        public int eRabId() { return eRabId; }
        public int qci() { return qci; }
        public long ulDataVolumePerERab() { return ulDataVolumePerERab; }
        public long ulDataTransmissionTimePerERab() { return ulDataTransmissionTimePerERab; }
        public long dlDataVolumePerERab() { return dlDataVolumePerERab; }
        public long dlDataTransmissionTimePerERab() { return dlDataTransmissionTimePerERab; }
        public HuaweiChrEventFile _root() { return _root; }
        public HuaweiChrEventFile.TPeriodPrivateThroughputMeasurementM5mdt _parent() { return _parent; }
    }
    public static class TM1IntraFreqMdt extends KaitaiStruct {
        public static TM1IntraFreqMdt fromFile(String fileName) throws IOException {
            return new TM1IntraFreqMdt(new ByteBufferKaitaiStream(fileName));
        }

        public TM1IntraFreqMdt(KaitaiStream _io) {
            this(_io, null, null);
        }

        public TM1IntraFreqMdt(KaitaiStream _io, HuaweiChrEventFile.TEventRecord _parent) {
            this(_io, _parent, null);
        }

        public TM1IntraFreqMdt(KaitaiStream _io, HuaweiChrEventFile.TEventRecord _parent, HuaweiChrEventFile _root) {
            super(_io);
            this._parent = _parent;
            this._root = _root;
            _read();
        }
        private void _read() {
            this.measurementId = this._io.readU1();
            this.servingCellRsrp = this._io.readU1();
            this.servingCellRsrq = this._io.readU1();
            this.nCellCount = this._io.readU1();
            if (nCellCount() > 0) {
                this.cellInfoList = new ArrayList<TM1IntraFreqMdtCellInfo>();
                for (int i = 0; i < nCellCount(); i++) {
                    this.cellInfoList.add(new TM1IntraFreqMdtCellInfo(this._io, this, _root));
                }
            }
            this.locationInfoPresent = this._io.readU1();
            if (locationInfoPresent() == 1) {
                this.shapeType = this._io.readU1();
            }
            if ( ((locationInfoPresent() == 1) && (shapeType() == 0)) ) {
                this.undefinedInfo = new TUndefinedInfo(this._io, this, _root);
            }
            if ( ((locationInfoPresent() == 1) && (shapeType() == 1)) ) {
                this.ellipsoidPointInfo = new TEllipsoidPointInfo(this._io, this, _root);
            }
            if ( ((locationInfoPresent() == 1) && (shapeType() == 2)) ) {
                this.ellipsoidPointWithAltitudeInfo = new TEllipsoidPointWithAltitudeInfo(this._io, this, _root);
            }
            if ( ((locationInfoPresent() == 1) && (shapeType() == 3)) ) {
                this.ellipsoidPointWithUncertaintyCircleInfo = new TEllipsoidPointWithUncertaintyCircleInfo(this._io, this, _root);
            }
            if ( ((locationInfoPresent() == 1) && (shapeType() == 4)) ) {
                this.ellipsoidPointWithUncertaintyEllipseInfo = new TEllipsoidPointWithUncertaintyEllipseInfo(this._io, this, _root);
            }
            if ( ((locationInfoPresent() == 1) && (shapeType() == 5)) ) {
                this.ellipsoidPointWithAltitudAndUncertaintyEllipsoidInfo = new TEllipsoidPointWithAltitudAndUncertaintyEllipsoidInfo(this._io, this, _root);
            }
        }
        private int measurementId;
        private int servingCellRsrp;
        private int servingCellRsrq;
        private int nCellCount;
        private ArrayList<TM1IntraFreqMdtCellInfo> cellInfoList;
        private int locationInfoPresent;
        private Integer shapeType;
        private TUndefinedInfo undefinedInfo;
        private TEllipsoidPointInfo ellipsoidPointInfo;
        private TEllipsoidPointWithAltitudeInfo ellipsoidPointWithAltitudeInfo;
        private TEllipsoidPointWithUncertaintyCircleInfo ellipsoidPointWithUncertaintyCircleInfo;
        private TEllipsoidPointWithUncertaintyEllipseInfo ellipsoidPointWithUncertaintyEllipseInfo;
        private TEllipsoidPointWithAltitudAndUncertaintyEllipsoidInfo ellipsoidPointWithAltitudAndUncertaintyEllipsoidInfo;
        private HuaweiChrEventFile _root;
        private HuaweiChrEventFile.TEventRecord _parent;
        public int measurementId() { return measurementId; }
        public int servingCellRsrp() { return servingCellRsrp; }
        public int servingCellRsrq() { return servingCellRsrq; }
        public int nCellCount() { return nCellCount; }
        public ArrayList<TM1IntraFreqMdtCellInfo> cellInfoList() { return cellInfoList; }
        public int locationInfoPresent() { return locationInfoPresent; }
        public Integer shapeType() { return shapeType; }
        public TUndefinedInfo undefinedInfo() { return undefinedInfo; }
        public TEllipsoidPointInfo ellipsoidPointInfo() { return ellipsoidPointInfo; }
        public TEllipsoidPointWithAltitudeInfo ellipsoidPointWithAltitudeInfo() { return ellipsoidPointWithAltitudeInfo; }
        public TEllipsoidPointWithUncertaintyCircleInfo ellipsoidPointWithUncertaintyCircleInfo() { return ellipsoidPointWithUncertaintyCircleInfo; }
        public TEllipsoidPointWithUncertaintyEllipseInfo ellipsoidPointWithUncertaintyEllipseInfo() { return ellipsoidPointWithUncertaintyEllipseInfo; }
        public TEllipsoidPointWithAltitudAndUncertaintyEllipsoidInfo ellipsoidPointWithAltitudAndUncertaintyEllipsoidInfo() { return ellipsoidPointWithAltitudAndUncertaintyEllipsoidInfo; }
        public HuaweiChrEventFile _root() { return _root; }
        public HuaweiChrEventFile.TEventRecord _parent() { return _parent; }
    }
    public static class TPeriodPrivateThroughputMeasurementM5mdt extends KaitaiStruct {
        public static TPeriodPrivateThroughputMeasurementM5mdt fromFile(String fileName) throws IOException {
            return new TPeriodPrivateThroughputMeasurementM5mdt(new ByteBufferKaitaiStream(fileName));
        }

        public TPeriodPrivateThroughputMeasurementM5mdt(KaitaiStream _io) {
            this(_io, null, null);
        }

        public TPeriodPrivateThroughputMeasurementM5mdt(KaitaiStream _io, HuaweiChrEventFile.TEventRecord _parent) {
            this(_io, _parent, null);
        }

        public TPeriodPrivateThroughputMeasurementM5mdt(KaitaiStream _io, HuaweiChrEventFile.TEventRecord _parent, HuaweiChrEventFile _root) {
            super(_io);
            this._parent = _parent;
            this._root = _root;
            _read();
        }
        private void _read() {
            this.ulDataVolumePerUe = this._io.readU4be();
            this.ulDataVolumeLastTtiPerUe = this._io.readU4be();
            this.ulDataTransmissionTimePerUe = this._io.readU4be();
            this.dlDataVolumePerUe = this._io.readU4be();
            this.dlDataVolumeLastTtiPerUe = this._io.readU4be();
            this.dlDataTransmissionTimePerUe = this._io.readU4be();
            this.eRabCount = this._io.readU1();
            this.eRabThroughputStatList = new ArrayList<TERabThroughputStatM5mdt>();
            for (int i = 0; i < eRabCount(); i++) {
                this.eRabThroughputStatList.add(new TERabThroughputStatM5mdt(this._io, this, _root));
            }
        }
        private long ulDataVolumePerUe;
        private long ulDataVolumeLastTtiPerUe;
        private long ulDataTransmissionTimePerUe;
        private long dlDataVolumePerUe;
        private long dlDataVolumeLastTtiPerUe;
        private long dlDataTransmissionTimePerUe;
        private int eRabCount;
        private ArrayList<TERabThroughputStatM5mdt> eRabThroughputStatList;
        private HuaweiChrEventFile _root;
        private HuaweiChrEventFile.TEventRecord _parent;
        public long ulDataVolumePerUe() { return ulDataVolumePerUe; }
        public long ulDataVolumeLastTtiPerUe() { return ulDataVolumeLastTtiPerUe; }
        public long ulDataTransmissionTimePerUe() { return ulDataTransmissionTimePerUe; }
        public long dlDataVolumePerUe() { return dlDataVolumePerUe; }
        public long dlDataVolumeLastTtiPerUe() { return dlDataVolumeLastTtiPerUe; }
        public long dlDataTransmissionTimePerUe() { return dlDataTransmissionTimePerUe; }
        public int eRabCount() { return eRabCount; }
        public ArrayList<TERabThroughputStatM5mdt> eRabThroughputStatList() { return eRabThroughputStatList; }
        public HuaweiChrEventFile _root() { return _root; }
        public HuaweiChrEventFile.TEventRecord _parent() { return _parent; }
    }
    public static class TRlfReport extends KaitaiStruct {
        public static TRlfReport fromFile(String fileName) throws IOException {
            return new TRlfReport(new ByteBufferKaitaiStream(fileName));
        }

        public TRlfReport(KaitaiStream _io) {
            this(_io, null, null);
        }

        public TRlfReport(KaitaiStream _io, HuaweiChrEventFile.TEventRecord _parent) {
            this(_io, _parent, null);
        }

        public TRlfReport(KaitaiStream _io, HuaweiChrEventFile.TEventRecord _parent, HuaweiChrEventFile _root) {
            super(_io);
            this._parent = _parent;
            this._root = _root;
            _read();
        }
        private void _read() {
            this.servingCellRsrp = this._io.readU1();
            this.servingCellRsrq = this._io.readU1();
            this.failedPcellInfo = new TFailedPcellInfo(this._io, this, _root);
            this.reEstablishmentCellInfo = new TReEstablishmentCellInfo(this._io, this, _root);
            this.timeConnectionFailure = this._io.readU2be();
            this.connectionFailureType = this._io.readU1();
            this.previousPcellInfo = new TPreviousPcellInfo(this._io, this, _root);
            this.eutranNcellMrValidFlag = this._io.readU1();
            this.eutranCarrierFrequencyCount = this._io.readU1();
            this.eutranCarrierFrequencyList = new ArrayList<TEutranCarrierInfo>();
            for (int i = 0; i < eutranCarrierFrequencyCount(); i++) {
                this.eutranCarrierFrequencyList.add(new TEutranCarrierInfo(this._io, this, _root));
            }
            this.utranNcellMrValidFlag = this._io.readU1();
            this.utranCarrierFrequencyCount = this._io.readU1();
            this.utranCarrierFrequencyList = new ArrayList<TUtranCarrierInfo>();
            for (int i = 0; i < utranCarrierFrequencyCount(); i++) {
                this.utranCarrierFrequencyList.add(new TUtranCarrierInfo(this._io, this, _root));
            }
            this.geranNcellMrValidFlag = this._io.readU1();
            this.geranNcellCount = this._io.readU1();
            this.geranNcellInfoList = new ArrayList<TGeranNcellInfo>();
            for (int i = 0; i < geranNcellCount(); i++) {
                this.geranNcellInfoList.add(new TGeranNcellInfo(this._io, this, _root));
            }
            this.cdma2000NcellMrValidFlag = this._io.readU1();
            this.cdma2000CarrierFrequencyCount = this._io.readU1();
            this.cdma2000CarrierFrequencyList = new ArrayList<TCdma2000CarrierInfo>();
            for (int i = 0; i < cdma2000CarrierFrequencyCount(); i++) {
                this.cdma2000CarrierFrequencyList.add(new TCdma2000CarrierInfo(this._io, this, _root));
            }
            this.locationInfoPresent = this._io.readU1();
            if (locationInfoPresent() == 1) {
                this.shapeType = this._io.readU1();
            }
            if ( ((locationInfoPresent() == 1) && (shapeType() == 0)) ) {
                this.undefinedInfo = new TUndefinedInfo(this._io, this, _root);
            }
            if ( ((locationInfoPresent() == 1) && (shapeType() == 1)) ) {
                this.ellipsoidPointInfo = new TEllipsoidPointInfo(this._io, this, _root);
            }
            if ( ((locationInfoPresent() == 1) && (shapeType() == 2)) ) {
                this.ellipsoidPointWithAltitudeInfo = new TEllipsoidPointWithAltitudeInfo(this._io, this, _root);
            }
            if ( ((locationInfoPresent() == 1) && (shapeType() == 3)) ) {
                this.ellipsoidPointWithUncertaintyCircleInfo = new TEllipsoidPointWithUncertaintyCircleInfo(this._io, this, _root);
            }
            if ( ((locationInfoPresent() == 1) && (shapeType() == 4)) ) {
                this.ellipsoidPointWithUncertaintyEllipseInfo = new TEllipsoidPointWithUncertaintyEllipseInfo(this._io, this, _root);
            }
            if ( ((locationInfoPresent() == 1) && (shapeType() == 5)) ) {
                this.ellipsoidPointWithAltitudAndUncertaintyEllipsoidInfo = new TEllipsoidPointWithAltitudAndUncertaintyEllipsoidInfo(this._io, this, _root);
            }
        }
        private int servingCellRsrp;
        private int servingCellRsrq;
        private TFailedPcellInfo failedPcellInfo;
        private TReEstablishmentCellInfo reEstablishmentCellInfo;
        private int timeConnectionFailure;
        private int connectionFailureType;
        private TPreviousPcellInfo previousPcellInfo;
        private int eutranNcellMrValidFlag;
        private int eutranCarrierFrequencyCount;
        private ArrayList<TEutranCarrierInfo> eutranCarrierFrequencyList;
        private int utranNcellMrValidFlag;
        private int utranCarrierFrequencyCount;
        private ArrayList<TUtranCarrierInfo> utranCarrierFrequencyList;
        private int geranNcellMrValidFlag;
        private int geranNcellCount;
        private ArrayList<TGeranNcellInfo> geranNcellInfoList;
        private int cdma2000NcellMrValidFlag;
        private int cdma2000CarrierFrequencyCount;
        private ArrayList<TCdma2000CarrierInfo> cdma2000CarrierFrequencyList;
        private int locationInfoPresent;
        private Integer shapeType;
        private TUndefinedInfo undefinedInfo;
        private TEllipsoidPointInfo ellipsoidPointInfo;
        private TEllipsoidPointWithAltitudeInfo ellipsoidPointWithAltitudeInfo;
        private TEllipsoidPointWithUncertaintyCircleInfo ellipsoidPointWithUncertaintyCircleInfo;
        private TEllipsoidPointWithUncertaintyEllipseInfo ellipsoidPointWithUncertaintyEllipseInfo;
        private TEllipsoidPointWithAltitudAndUncertaintyEllipsoidInfo ellipsoidPointWithAltitudAndUncertaintyEllipsoidInfo;
        private HuaweiChrEventFile _root;
        private HuaweiChrEventFile.TEventRecord _parent;
        public int servingCellRsrp() { return servingCellRsrp; }
        public int servingCellRsrq() { return servingCellRsrq; }
        public TFailedPcellInfo failedPcellInfo() { return failedPcellInfo; }
        public TReEstablishmentCellInfo reEstablishmentCellInfo() { return reEstablishmentCellInfo; }
        public int timeConnectionFailure() { return timeConnectionFailure; }
        public int connectionFailureType() { return connectionFailureType; }
        public TPreviousPcellInfo previousPcellInfo() { return previousPcellInfo; }
        public int eutranNcellMrValidFlag() { return eutranNcellMrValidFlag; }
        public int eutranCarrierFrequencyCount() { return eutranCarrierFrequencyCount; }
        public ArrayList<TEutranCarrierInfo> eutranCarrierFrequencyList() { return eutranCarrierFrequencyList; }
        public int utranNcellMrValidFlag() { return utranNcellMrValidFlag; }
        public int utranCarrierFrequencyCount() { return utranCarrierFrequencyCount; }
        public ArrayList<TUtranCarrierInfo> utranCarrierFrequencyList() { return utranCarrierFrequencyList; }
        public int geranNcellMrValidFlag() { return geranNcellMrValidFlag; }
        public int geranNcellCount() { return geranNcellCount; }
        public ArrayList<TGeranNcellInfo> geranNcellInfoList() { return geranNcellInfoList; }
        public int cdma2000NcellMrValidFlag() { return cdma2000NcellMrValidFlag; }
        public int cdma2000CarrierFrequencyCount() { return cdma2000CarrierFrequencyCount; }
        public ArrayList<TCdma2000CarrierInfo> cdma2000CarrierFrequencyList() { return cdma2000CarrierFrequencyList; }
        public int locationInfoPresent() { return locationInfoPresent; }
        public Integer shapeType() { return shapeType; }
        public TUndefinedInfo undefinedInfo() { return undefinedInfo; }
        public TEllipsoidPointInfo ellipsoidPointInfo() { return ellipsoidPointInfo; }
        public TEllipsoidPointWithAltitudeInfo ellipsoidPointWithAltitudeInfo() { return ellipsoidPointWithAltitudeInfo; }
        public TEllipsoidPointWithUncertaintyCircleInfo ellipsoidPointWithUncertaintyCircleInfo() { return ellipsoidPointWithUncertaintyCircleInfo; }
        public TEllipsoidPointWithUncertaintyEllipseInfo ellipsoidPointWithUncertaintyEllipseInfo() { return ellipsoidPointWithUncertaintyEllipseInfo; }
        public TEllipsoidPointWithAltitudAndUncertaintyEllipsoidInfo ellipsoidPointWithAltitudAndUncertaintyEllipsoidInfo() { return ellipsoidPointWithAltitudAndUncertaintyEllipsoidInfo; }
        public HuaweiChrEventFile _root() { return _root; }
        public HuaweiChrEventFile.TEventRecord _parent() { return _parent; }
    }
    public static class TReEstablishmentCellInfo extends KaitaiStruct {
        public static TReEstablishmentCellInfo fromFile(String fileName) throws IOException {
            return new TReEstablishmentCellInfo(new ByteBufferKaitaiStream(fileName));
        }

        public TReEstablishmentCellInfo(KaitaiStream _io) {
            this(_io, null, null);
        }

        public TReEstablishmentCellInfo(KaitaiStream _io, KaitaiStruct _parent) {
            this(_io, _parent, null);
        }

        public TReEstablishmentCellInfo(KaitaiStream _io, KaitaiStruct _parent, HuaweiChrEventFile _root) {
            super(_io);
            this._parent = _parent;
            this._root = _root;
            _read();
        }
        private void _read() {
            this.plmn = new TPlmnFormat1(this._io, this, _root);
            this.cellId = this._io.readU4be();
        }
        private TPlmnFormat1 plmn;
        private long cellId;
        private HuaweiChrEventFile _root;
        private KaitaiStruct _parent;
        public TPlmnFormat1 plmn() { return plmn; }
        public long cellId() { return cellId; }
        public HuaweiChrEventFile _root() { return _root; }
        public KaitaiStruct _parent() { return _parent; }
    }
    public static class TEutranCarrierInfo extends KaitaiStruct {
        public static TEutranCarrierInfo fromFile(String fileName) throws IOException {
            return new TEutranCarrierInfo(new ByteBufferKaitaiStream(fileName));
        }

        public TEutranCarrierInfo(KaitaiStream _io) {
            this(_io, null, null);
        }

        public TEutranCarrierInfo(KaitaiStream _io, KaitaiStruct _parent) {
            this(_io, _parent, null);
        }

        public TEutranCarrierInfo(KaitaiStream _io, KaitaiStruct _parent, HuaweiChrEventFile _root) {
            super(_io);
            this._parent = _parent;
            this._root = _root;
            _read();
        }
        private void _read() {
            this.arfcn = this._io.readU4be();
            this.ncellCount = this._io.readU1();
            this.ncellInfoList = new ArrayList<TEutranNcellInfoList>();
            for (int i = 0; i < ncellCount(); i++) {
                this.ncellInfoList.add(new TEutranNcellInfoList(this._io, this, _root));
            }
        }
        private long arfcn;
        private int ncellCount;
        private ArrayList<TEutranNcellInfoList> ncellInfoList;
        private HuaweiChrEventFile _root;
        private KaitaiStruct _parent;
        public long arfcn() { return arfcn; }
        public int ncellCount() { return ncellCount; }
        public ArrayList<TEutranNcellInfoList> ncellInfoList() { return ncellInfoList; }
        public HuaweiChrEventFile _root() { return _root; }
        public KaitaiStruct _parent() { return _parent; }
    }
    public static class TWcdmaNcellInfo extends KaitaiStruct {
        public static TWcdmaNcellInfo fromFile(String fileName) throws IOException {
            return new TWcdmaNcellInfo(new ByteBufferKaitaiStream(fileName));
        }

        public TWcdmaNcellInfo(KaitaiStream _io) {
            this(_io, null, null);
        }

        public TWcdmaNcellInfo(KaitaiStream _io, HuaweiChrEventFile.TUeWcdmaNcellInfo _parent) {
            this(_io, _parent, null);
        }

        public TWcdmaNcellInfo(KaitaiStream _io, HuaweiChrEventFile.TUeWcdmaNcellInfo _parent, HuaweiChrEventFile _root) {
            super(_io);
            this._parent = _parent;
            this._root = _root;
            _read();
        }
        private void _read() {
            this.pci = this._io.readU2be();
            this.rscp = this._io.readS1();
            this.ecNo = this._io.readU1();
        }
        private int pci;
        private byte rscp;
        private int ecNo;
        private HuaweiChrEventFile _root;
        private HuaweiChrEventFile.TUeWcdmaNcellInfo _parent;
        public int pci() { return pci; }
        public byte rscp() { return rscp; }
        public int ecNo() { return ecNo; }
        public HuaweiChrEventFile _root() { return _root; }
        public HuaweiChrEventFile.TUeWcdmaNcellInfo _parent() { return _parent; }
    }
    public static class TPeriodInterRatMr extends KaitaiStruct {
        public static TPeriodInterRatMr fromFile(String fileName) throws IOException {
            return new TPeriodInterRatMr(new ByteBufferKaitaiStream(fileName));
        }

        public TPeriodInterRatMr(KaitaiStream _io) {
            this(_io, null, null);
        }

        public TPeriodInterRatMr(KaitaiStream _io, HuaweiChrEventFile.TEventRecord _parent) {
            this(_io, _parent, null);
        }

        public TPeriodInterRatMr(KaitaiStream _io, HuaweiChrEventFile.TEventRecord _parent, HuaweiChrEventFile _root) {
            super(_io);
            this._parent = _parent;
            this._root = _root;
            _read();
        }
        private void _read() {
            this.measurementId = this._io.readU1();
            this.servingCellRsrp = this._io.readU1();
            this.servingCellRsrq = this._io.readU1();
            this.ncellType = this._io.readU1();
            switch (ncellType()) {
                case 2: {
                    this.ncellInfo = new TUeWcdmaNcellInfo(this._io, this, _root);
                    break;
                }
                case 3: {
                    this.ncellInfo = new TUeGeranNcellInfo(this._io, this, _root);
                    break;
                }
                case 4: {
                    this.ncellInfo = new TUeCdma2000NcellInfo(this._io, this, _root);
                    break;
                }
                case 5: {
                    this.ncellInfo = new TUeTdScdmaNcellInfo(this._io, this, _root);
                    break;
                }
            }
        }
        private int measurementId;
        private int servingCellRsrp;
        private int servingCellRsrq;
        private int ncellType;
        private KaitaiStruct ncellInfo;
        private HuaweiChrEventFile _root;
        private HuaweiChrEventFile.TEventRecord _parent;
        public int measurementId() { return measurementId; }
        public int servingCellRsrp() { return servingCellRsrp; }
        public int servingCellRsrq() { return servingCellRsrq; }
        public int ncellType() { return ncellType; }
        public KaitaiStruct ncellInfo() { return ncellInfo; }
        public HuaweiChrEventFile _root() { return _root; }
        public HuaweiChrEventFile.TEventRecord _parent() { return _parent; }
    }
    public static class TGlobalCellIdInfo extends KaitaiStruct {
        public static TGlobalCellIdInfo fromFile(String fileName) throws IOException {
            return new TGlobalCellIdInfo(new ByteBufferKaitaiStream(fileName));
        }

        public TGlobalCellIdInfo(KaitaiStream _io) {
            this(_io, null, null);
        }

        public TGlobalCellIdInfo(KaitaiStream _io, KaitaiStruct _parent) {
            this(_io, _parent, null);
        }

        public TGlobalCellIdInfo(KaitaiStream _io, KaitaiStruct _parent, HuaweiChrEventFile _root) {
            super(_io);
            this._parent = _parent;
            this._root = _root;
            _read();
        }
        private void _read() {
            this.plmn = new TPlmnFormat1(this._io, this, _root);
            this.cellId = this._io.readU4be();
        }
        private TPlmnFormat1 plmn;
        private long cellId;
        private HuaweiChrEventFile _root;
        private KaitaiStruct _parent;
        public TPlmnFormat1 plmn() { return plmn; }
        public long cellId() { return cellId; }
        public HuaweiChrEventFile _root() { return _root; }
        public KaitaiStruct _parent() { return _parent; }
    }
    public static class TCdma2000CarrierInfo extends KaitaiStruct {
        public static TCdma2000CarrierInfo fromFile(String fileName) throws IOException {
            return new TCdma2000CarrierInfo(new ByteBufferKaitaiStream(fileName));
        }

        public TCdma2000CarrierInfo(KaitaiStream _io) {
            this(_io, null, null);
        }

        public TCdma2000CarrierInfo(KaitaiStream _io, KaitaiStruct _parent) {
            this(_io, _parent, null);
        }

        public TCdma2000CarrierInfo(KaitaiStream _io, KaitaiStruct _parent, HuaweiChrEventFile _root) {
            super(_io);
            this._parent = _parent;
            this._root = _root;
            _read();
        }
        private void _read() {
            this.arfcn = this._io.readU2be();
            this.bandClass = this._io.readU1();
            this.ncellCount = this._io.readU1();
            this.ncellInfoList = new ArrayList<TCdma2000NcellInfoList>();
            for (int i = 0; i < ncellCount(); i++) {
                this.ncellInfoList.add(new TCdma2000NcellInfoList(this._io, this, _root));
            }
        }
        private int arfcn;
        private int bandClass;
        private int ncellCount;
        private ArrayList<TCdma2000NcellInfoList> ncellInfoList;
        private HuaweiChrEventFile _root;
        private KaitaiStruct _parent;
        public int arfcn() { return arfcn; }
        public int bandClass() { return bandClass; }
        public int ncellCount() { return ncellCount; }
        public ArrayList<TCdma2000NcellInfoList> ncellInfoList() { return ncellInfoList; }
        public HuaweiChrEventFile _root() { return _root; }
        public KaitaiStruct _parent() { return _parent; }
    }
    public static class TEllipsoidPointWithUncertaintyEllipseInfo extends KaitaiStruct {
        public static TEllipsoidPointWithUncertaintyEllipseInfo fromFile(String fileName) throws IOException {
            return new TEllipsoidPointWithUncertaintyEllipseInfo(new ByteBufferKaitaiStream(fileName));
        }

        public TEllipsoidPointWithUncertaintyEllipseInfo(KaitaiStream _io) {
            this(_io, null, null);
        }

        public TEllipsoidPointWithUncertaintyEllipseInfo(KaitaiStream _io, KaitaiStruct _parent) {
            this(_io, _parent, null);
        }

        public TEllipsoidPointWithUncertaintyEllipseInfo(KaitaiStream _io, KaitaiStruct _parent, HuaweiChrEventFile _root) {
            super(_io);
            this._parent = _parent;
            this._root = _root;
            _read();
        }
        private void _read() {
            this.latitudeSign = this._io.readU1();
            this.degreesLatitude = this._io.readU4be();
            this.degreesLongitude = this._io.readU4be();
            this.uncertaintySemiMajor = this._io.readU1();
            this.uncertaintySemiMinor = this._io.readU1();
            this.orientationMajorAxis = this._io.readU1();
            this.confidence = this._io.readU1();
        }
        private int latitudeSign;
        private long degreesLatitude;
        private long degreesLongitude;
        private int uncertaintySemiMajor;
        private int uncertaintySemiMinor;
        private int orientationMajorAxis;
        private int confidence;
        private HuaweiChrEventFile _root;
        private KaitaiStruct _parent;
        public int latitudeSign() { return latitudeSign; }
        public long degreesLatitude() { return degreesLatitude; }
        public long degreesLongitude() { return degreesLongitude; }
        public int uncertaintySemiMajor() { return uncertaintySemiMajor; }
        public int uncertaintySemiMinor() { return uncertaintySemiMinor; }
        public int orientationMajorAxis() { return orientationMajorAxis; }
        public int confidence() { return confidence; }
        public HuaweiChrEventFile _root() { return _root; }
        public KaitaiStruct _parent() { return _parent; }
    }
    public static class TInterFreqNcellInfo extends KaitaiStruct {
        public static TInterFreqNcellInfo fromFile(String fileName) throws IOException {
            return new TInterFreqNcellInfo(new ByteBufferKaitaiStream(fileName));
        }

        public TInterFreqNcellInfo(KaitaiStream _io) {
            this(_io, null, null);
        }

        public TInterFreqNcellInfo(KaitaiStream _io, HuaweiChrEventFile.TPeriodInterFreqMr _parent) {
            this(_io, _parent, null);
        }

        public TInterFreqNcellInfo(KaitaiStream _io, HuaweiChrEventFile.TPeriodInterFreqMr _parent, HuaweiChrEventFile _root) {
            super(_io);
            this._parent = _parent;
            this._root = _root;
            _read();
        }
        private void _read() {
            this.pci = this._io.readU2be();
            this.rsrp = this._io.readU1();
            this.rsrq = this._io.readU1();
        }
        private int pci;
        private int rsrp;
        private int rsrq;
        private HuaweiChrEventFile _root;
        private HuaweiChrEventFile.TPeriodInterFreqMr _parent;
        public int pci() { return pci; }
        public int rsrp() { return rsrp; }
        public int rsrq() { return rsrq; }
        public HuaweiChrEventFile _root() { return _root; }
        public HuaweiChrEventFile.TPeriodInterFreqMr _parent() { return _parent; }
    }
    public static class TUeNrNcellInfo extends KaitaiStruct {
        public static TUeNrNcellInfo fromFile(String fileName) throws IOException {
            return new TUeNrNcellInfo(new ByteBufferKaitaiStream(fileName));
        }

        public TUeNrNcellInfo(KaitaiStream _io) {
            this(_io, null, null);
        }

        public TUeNrNcellInfo(KaitaiStream _io, HuaweiChrEventFile.TUeEventNcellInfo _parent) {
            this(_io, _parent, null);
        }

        public TUeNrNcellInfo(KaitaiStream _io, HuaweiChrEventFile.TUeEventNcellInfo _parent, HuaweiChrEventFile _root) {
            super(_io);
            this._parent = _parent;
            this._root = _root;
            _read();
        }
        private void _read() {
            this.ncellCount = this._io.readU1();
            this.ncellList = new ArrayList<TNrNcellInfo>();
            for (int i = 0; i < ncellCount(); i++) {
                this.ncellList.add(new TNrNcellInfo(this._io, this, _root));
            }
        }
        private int ncellCount;
        private ArrayList<TNrNcellInfo> ncellList;
        private HuaweiChrEventFile _root;
        private HuaweiChrEventFile.TUeEventNcellInfo _parent;
        public int ncellCount() { return ncellCount; }
        public ArrayList<TNrNcellInfo> ncellList() { return ncellList; }
        public HuaweiChrEventFile _root() { return _root; }
        public HuaweiChrEventFile.TUeEventNcellInfo _parent() { return _parent; }
    }
    public static class TM1InterFreqMdt extends KaitaiStruct {
        public static TM1InterFreqMdt fromFile(String fileName) throws IOException {
            return new TM1InterFreqMdt(new ByteBufferKaitaiStream(fileName));
        }

        public TM1InterFreqMdt(KaitaiStream _io) {
            this(_io, null, null);
        }

        public TM1InterFreqMdt(KaitaiStream _io, HuaweiChrEventFile.TEventRecord _parent) {
            this(_io, _parent, null);
        }

        public TM1InterFreqMdt(KaitaiStream _io, HuaweiChrEventFile.TEventRecord _parent, HuaweiChrEventFile _root) {
            super(_io);
            this._parent = _parent;
            this._root = _root;
            _read();
        }
        private void _read() {
            this.measurementId = this._io.readU1();
            this.servingCellRsrp = this._io.readU1();
            this.servingCellRsrq = this._io.readU1();
            this.nCellCount = this._io.readU1();
            if (nCellCount() > 0) {
                this.cellInfoList = new ArrayList<TM1InterFreqMdtCellInfo>();
                for (int i = 0; i < nCellCount(); i++) {
                    this.cellInfoList.add(new TM1InterFreqMdtCellInfo(this._io, this, _root));
                }
            }
            this.locationInfoPresent = this._io.readU1();
            if (locationInfoPresent() == 1) {
                this.shapeType = this._io.readU1();
            }
            if ( ((locationInfoPresent() == 1) && (shapeType() == 0)) ) {
                this.undefinedInfo = new TUndefinedInfo(this._io, this, _root);
            }
            if ( ((locationInfoPresent() == 1) && (shapeType() == 1)) ) {
                this.ellipsoidPointInfo = new TEllipsoidPointInfo(this._io, this, _root);
            }
            if ( ((locationInfoPresent() == 1) && (shapeType() == 2)) ) {
                this.ellipsoidPointWithAltitudeInfo = new TEllipsoidPointWithAltitudeInfo(this._io, this, _root);
            }
            if ( ((locationInfoPresent() == 1) && (shapeType() == 3)) ) {
                this.ellipsoidPointWithUncertaintyCircleInfo = new TEllipsoidPointWithUncertaintyCircleInfo(this._io, this, _root);
            }
            if ( ((locationInfoPresent() == 1) && (shapeType() == 4)) ) {
                this.ellipsoidPointWithUncertaintyEllipseInfo = new TEllipsoidPointWithUncertaintyEllipseInfo(this._io, this, _root);
            }
            if ( ((locationInfoPresent() == 1) && (shapeType() == 5)) ) {
                this.ellipsoidPointWithAltitudAndUncertaintyEllipsoidInfo = new TEllipsoidPointWithAltitudAndUncertaintyEllipsoidInfo(this._io, this, _root);
            }
        }
        private int measurementId;
        private int servingCellRsrp;
        private int servingCellRsrq;
        private int nCellCount;
        private ArrayList<TM1InterFreqMdtCellInfo> cellInfoList;
        private int locationInfoPresent;
        private Integer shapeType;
        private TUndefinedInfo undefinedInfo;
        private TEllipsoidPointInfo ellipsoidPointInfo;
        private TEllipsoidPointWithAltitudeInfo ellipsoidPointWithAltitudeInfo;
        private TEllipsoidPointWithUncertaintyCircleInfo ellipsoidPointWithUncertaintyCircleInfo;
        private TEllipsoidPointWithUncertaintyEllipseInfo ellipsoidPointWithUncertaintyEllipseInfo;
        private TEllipsoidPointWithAltitudAndUncertaintyEllipsoidInfo ellipsoidPointWithAltitudAndUncertaintyEllipsoidInfo;
        private HuaweiChrEventFile _root;
        private HuaweiChrEventFile.TEventRecord _parent;
        public int measurementId() { return measurementId; }
        public int servingCellRsrp() { return servingCellRsrp; }
        public int servingCellRsrq() { return servingCellRsrq; }
        public int nCellCount() { return nCellCount; }
        public ArrayList<TM1InterFreqMdtCellInfo> cellInfoList() { return cellInfoList; }
        public int locationInfoPresent() { return locationInfoPresent; }
        public Integer shapeType() { return shapeType; }
        public TUndefinedInfo undefinedInfo() { return undefinedInfo; }
        public TEllipsoidPointInfo ellipsoidPointInfo() { return ellipsoidPointInfo; }
        public TEllipsoidPointWithAltitudeInfo ellipsoidPointWithAltitudeInfo() { return ellipsoidPointWithAltitudeInfo; }
        public TEllipsoidPointWithUncertaintyCircleInfo ellipsoidPointWithUncertaintyCircleInfo() { return ellipsoidPointWithUncertaintyCircleInfo; }
        public TEllipsoidPointWithUncertaintyEllipseInfo ellipsoidPointWithUncertaintyEllipseInfo() { return ellipsoidPointWithUncertaintyEllipseInfo; }
        public TEllipsoidPointWithAltitudAndUncertaintyEllipsoidInfo ellipsoidPointWithAltitudAndUncertaintyEllipsoidInfo() { return ellipsoidPointWithAltitudAndUncertaintyEllipsoidInfo; }
        public HuaweiChrEventFile _root() { return _root; }
        public HuaweiChrEventFile.TEventRecord _parent() { return _parent; }
    }
    public static class TM1InterFreqMdtCellInfo extends KaitaiStruct {
        public static TM1InterFreqMdtCellInfo fromFile(String fileName) throws IOException {
            return new TM1InterFreqMdtCellInfo(new ByteBufferKaitaiStream(fileName));
        }

        public TM1InterFreqMdtCellInfo(KaitaiStream _io) {
            this(_io, null, null);
        }

        public TM1InterFreqMdtCellInfo(KaitaiStream _io, HuaweiChrEventFile.TM1InterFreqMdt _parent) {
            this(_io, _parent, null);
        }

        public TM1InterFreqMdtCellInfo(KaitaiStream _io, HuaweiChrEventFile.TM1InterFreqMdt _parent, HuaweiChrEventFile _root) {
            super(_io);
            this._parent = _parent;
            this._root = _root;
            _read();
        }
        private void _read() {
            this.cellId = this._io.readU4be();
            this.pci = this._io.readU2be();
            this.carrierFrequency = this._io.readU4be();
            this.rsrp = this._io.readU1();
            this.rsrq = this._io.readU1();
        }
        private long cellId;
        private int pci;
        private long carrierFrequency;
        private int rsrp;
        private int rsrq;
        private HuaweiChrEventFile _root;
        private HuaweiChrEventFile.TM1InterFreqMdt _parent;
        public long cellId() { return cellId; }
        public int pci() { return pci; }
        public long carrierFrequency() { return carrierFrequency; }
        public int rsrp() { return rsrp; }
        public int rsrq() { return rsrq; }
        public HuaweiChrEventFile _root() { return _root; }
        public HuaweiChrEventFile.TM1InterFreqMdt _parent() { return _parent; }
    }
    public static class TNrNcellInfo extends KaitaiStruct {
        public static TNrNcellInfo fromFile(String fileName) throws IOException {
            return new TNrNcellInfo(new ByteBufferKaitaiStream(fileName));
        }

        public TNrNcellInfo(KaitaiStream _io) {
            this(_io, null, null);
        }

        public TNrNcellInfo(KaitaiStream _io, HuaweiChrEventFile.TUeNrNcellInfo _parent) {
            this(_io, _parent, null);
        }

        public TNrNcellInfo(KaitaiStream _io, HuaweiChrEventFile.TUeNrNcellInfo _parent, HuaweiChrEventFile _root) {
            super(_io);
            this._parent = _parent;
            this._root = _root;
            _read();
        }
        private void _read() {
            this.pci = this._io.readU2be();
            this.carrierFreq = this._io.readU4be();
            this.rsrp = this._io.readU1();
        }
        private int pci;
        private long carrierFreq;
        private int rsrp;
        private HuaweiChrEventFile _root;
        private HuaweiChrEventFile.TUeNrNcellInfo _parent;
        public int pci() { return pci; }
        public long carrierFreq() { return carrierFreq; }
        public int rsrp() { return rsrp; }
        public HuaweiChrEventFile _root() { return _root; }
        public HuaweiChrEventFile.TUeNrNcellInfo _parent() { return _parent; }
    }
    public static class TEllipsoidPointInfo extends KaitaiStruct {
        public static TEllipsoidPointInfo fromFile(String fileName) throws IOException {
            return new TEllipsoidPointInfo(new ByteBufferKaitaiStream(fileName));
        }

        public TEllipsoidPointInfo(KaitaiStream _io) {
            this(_io, null, null);
        }

        public TEllipsoidPointInfo(KaitaiStream _io, KaitaiStruct _parent) {
            this(_io, _parent, null);
        }

        public TEllipsoidPointInfo(KaitaiStream _io, KaitaiStruct _parent, HuaweiChrEventFile _root) {
            super(_io);
            this._parent = _parent;
            this._root = _root;
            _read();
        }
        private void _read() {
            this.latitudeSign = this._io.readU1();
            this.degreesLatitude = this._io.readU4be();
            this.degreesLongitude = this._io.readU4be();
        }
        private int latitudeSign;
        private long degreesLatitude;
        private long degreesLongitude;
        private HuaweiChrEventFile _root;
        private KaitaiStruct _parent;
        public int latitudeSign() { return latitudeSign; }
        public long degreesLatitude() { return degreesLatitude; }
        public long degreesLongitude() { return degreesLongitude; }
        public HuaweiChrEventFile _root() { return _root; }
        public KaitaiStruct _parent() { return _parent; }
    }
    public static class TPublicInformation extends KaitaiStruct {
        public static TPublicInformation fromFile(String fileName) throws IOException {
            return new TPublicInformation(new ByteBufferKaitaiStream(fileName));
        }

        public TPublicInformation(KaitaiStream _io) {
            this(_io, null, null);
        }

        public TPublicInformation(KaitaiStream _io, HuaweiChrEventFile.TEventRecord _parent) {
            this(_io, _parent, null);
        }

        public TPublicInformation(KaitaiStream _io, HuaweiChrEventFile.TEventRecord _parent, HuaweiChrEventFile _root) {
            super(_io);
            this._parent = _parent;
            this._root = _root;
            _read();
        }
        private void _read() {
            this.plmn = new TPlmnFormat1(this._io, this, _root);
            this.mmeGroupId = this._io.readU2be();
            this.mmeCode = this._io.readU1();
            this.mtmsi = this._io.readU4be();
            this.mmeUeS1apId = this._io.readU4be();
            this.enodebUeSiapId = this._io.readU4be();
        }
        private TPlmnFormat1 plmn;
        private int mmeGroupId;
        private int mmeCode;
        private long mtmsi;
        private long mmeUeS1apId;
        private long enodebUeSiapId;
        private HuaweiChrEventFile _root;
        private HuaweiChrEventFile.TEventRecord _parent;
        public TPlmnFormat1 plmn() { return plmn; }
        public int mmeGroupId() { return mmeGroupId; }
        public int mmeCode() { return mmeCode; }
        public long mtmsi() { return mtmsi; }
        public long mmeUeS1apId() { return mmeUeS1apId; }
        public long enodebUeSiapId() { return enodebUeSiapId; }
        public HuaweiChrEventFile _root() { return _root; }
        public HuaweiChrEventFile.TEventRecord _parent() { return _parent; }
    }
    public static class TEutranCarrierInfo100c extends KaitaiStruct {
        public static TEutranCarrierInfo100c fromFile(String fileName) throws IOException {
            return new TEutranCarrierInfo100c(new ByteBufferKaitaiStream(fileName));
        }

        public TEutranCarrierInfo100c(KaitaiStream _io) {
            this(_io, null, null);
        }

        public TEutranCarrierInfo100c(KaitaiStream _io, HuaweiChrEventFile.TRadioLinkFailureReport _parent) {
            this(_io, _parent, null);
        }

        public TEutranCarrierInfo100c(KaitaiStream _io, HuaweiChrEventFile.TRadioLinkFailureReport _parent, HuaweiChrEventFile _root) {
            super(_io);
            this._parent = _parent;
            this._root = _root;
            _read();
        }
        private void _read() {
            this.arfcn = this._io.readU2be();
            this.ncellCount = this._io.readU1();
            this.ncellInfoList = new ArrayList<TEutranNcellInfoList>();
            for (int i = 0; i < ncellCount(); i++) {
                this.ncellInfoList.add(new TEutranNcellInfoList(this._io, this, _root));
            }
        }
        private int arfcn;
        private int ncellCount;
        private ArrayList<TEutranNcellInfoList> ncellInfoList;
        private HuaweiChrEventFile _root;
        private HuaweiChrEventFile.TRadioLinkFailureReport _parent;
        public int arfcn() { return arfcn; }
        public int ncellCount() { return ncellCount; }
        public ArrayList<TEutranNcellInfoList> ncellInfoList() { return ncellInfoList; }
        public HuaweiChrEventFile _root() { return _root; }
        public HuaweiChrEventFile.TRadioLinkFailureReport _parent() { return _parent; }
    }
    public static class TPeriodUeUlpdcpdelayMdt extends KaitaiStruct {
        public static TPeriodUeUlpdcpdelayMdt fromFile(String fileName) throws IOException {
            return new TPeriodUeUlpdcpdelayMdt(new ByteBufferKaitaiStream(fileName));
        }

        public TPeriodUeUlpdcpdelayMdt(KaitaiStream _io) {
            this(_io, null, null);
        }

        public TPeriodUeUlpdcpdelayMdt(KaitaiStream _io, HuaweiChrEventFile.TEventRecord _parent) {
            this(_io, _parent, null);
        }

        public TPeriodUeUlpdcpdelayMdt(KaitaiStream _io, HuaweiChrEventFile.TEventRecord _parent, HuaweiChrEventFile _root) {
            super(_io);
            this._parent = _parent;
            this._root = _root;
            _read();
        }
        private void _read() {
            this.qciCount = this._io.readU1();
            this.ulPdcpDelayResultList = new ArrayList<TUlPdcpDelayResult>();
            for (int i = 0; i < qciCount(); i++) {
                this.ulPdcpDelayResultList.add(new TUlPdcpDelayResult(this._io, this, _root));
            }
            this.locationInfoPresent = this._io.readU1();
            if (locationInfoPresent() == 1) {
                this.shapeType = this._io.readU1();
            }
            if ( ((locationInfoPresent() == 1) && (shapeType() == 0)) ) {
                this.undefinedInfo = new TUndefinedInfo(this._io, this, _root);
            }
            if ( ((locationInfoPresent() == 1) && (shapeType() == 1)) ) {
                this.ellipsoidPointInfo = new TEllipsoidPointInfo(this._io, this, _root);
            }
            if ( ((locationInfoPresent() == 1) && (shapeType() == 2)) ) {
                this.ellipsoidPointWithAltitudeInfo = new TEllipsoidPointWithAltitudeInfo(this._io, this, _root);
            }
            if ( ((locationInfoPresent() == 1) && (shapeType() == 3)) ) {
                this.ellipsoidPointWithUncertaintyCircleInfo = new TEllipsoidPointWithUncertaintyCircleInfo(this._io, this, _root);
            }
            if ( ((locationInfoPresent() == 1) && (shapeType() == 4)) ) {
                this.ellipsoidPointWithUncertaintyEllipseInfo = new TEllipsoidPointWithUncertaintyEllipseInfo(this._io, this, _root);
            }
            if ( ((locationInfoPresent() == 1) && (shapeType() == 5)) ) {
                this.ellipsoidPointWithAltitudAndUncertaintyEllipsoidInfo = new TEllipsoidPointWithAltitudAndUncertaintyEllipsoidInfo(this._io, this, _root);
            }
        }
        private int qciCount;
        private ArrayList<TUlPdcpDelayResult> ulPdcpDelayResultList;
        private int locationInfoPresent;
        private Integer shapeType;
        private TUndefinedInfo undefinedInfo;
        private TEllipsoidPointInfo ellipsoidPointInfo;
        private TEllipsoidPointWithAltitudeInfo ellipsoidPointWithAltitudeInfo;
        private TEllipsoidPointWithUncertaintyCircleInfo ellipsoidPointWithUncertaintyCircleInfo;
        private TEllipsoidPointWithUncertaintyEllipseInfo ellipsoidPointWithUncertaintyEllipseInfo;
        private TEllipsoidPointWithAltitudAndUncertaintyEllipsoidInfo ellipsoidPointWithAltitudAndUncertaintyEllipsoidInfo;
        private HuaweiChrEventFile _root;
        private HuaweiChrEventFile.TEventRecord _parent;
        public int qciCount() { return qciCount; }
        public ArrayList<TUlPdcpDelayResult> ulPdcpDelayResultList() { return ulPdcpDelayResultList; }
        public int locationInfoPresent() { return locationInfoPresent; }
        public Integer shapeType() { return shapeType; }
        public TUndefinedInfo undefinedInfo() { return undefinedInfo; }
        public TEllipsoidPointInfo ellipsoidPointInfo() { return ellipsoidPointInfo; }
        public TEllipsoidPointWithAltitudeInfo ellipsoidPointWithAltitudeInfo() { return ellipsoidPointWithAltitudeInfo; }
        public TEllipsoidPointWithUncertaintyCircleInfo ellipsoidPointWithUncertaintyCircleInfo() { return ellipsoidPointWithUncertaintyCircleInfo; }
        public TEllipsoidPointWithUncertaintyEllipseInfo ellipsoidPointWithUncertaintyEllipseInfo() { return ellipsoidPointWithUncertaintyEllipseInfo; }
        public TEllipsoidPointWithAltitudAndUncertaintyEllipsoidInfo ellipsoidPointWithAltitudAndUncertaintyEllipsoidInfo() { return ellipsoidPointWithAltitudAndUncertaintyEllipsoidInfo; }
        public HuaweiChrEventFile _root() { return _root; }
        public HuaweiChrEventFile.TEventRecord _parent() { return _parent; }
    }
    public static class TPlmnFormat1 extends KaitaiStruct {
        public static TPlmnFormat1 fromFile(String fileName) throws IOException {
            return new TPlmnFormat1(new ByteBufferKaitaiStream(fileName));
        }

        public TPlmnFormat1(KaitaiStream _io) {
            this(_io, null, null);
        }

        public TPlmnFormat1(KaitaiStream _io, KaitaiStruct _parent) {
            this(_io, _parent, null);
        }

        public TPlmnFormat1(KaitaiStream _io, KaitaiStruct _parent, HuaweiChrEventFile _root) {
            super(_io);
            this._parent = _parent;
            this._root = _root;
            _read();
        }
        private void _read() {
            this.plmnIdReserved = this._io.readU1();
            this.plmnId = this._io.readBytes(3);
        }
        private int plmnIdReserved;
        private byte[] plmnId;
        private HuaweiChrEventFile _root;
        private KaitaiStruct _parent;
        public int plmnIdReserved() { return plmnIdReserved; }
        public byte[] plmnId() { return plmnId; }
        public HuaweiChrEventFile _root() { return _root; }
        public KaitaiStruct _parent() { return _parent; }
    }
    public static class TUtranCarrierInfo extends KaitaiStruct {
        public static TUtranCarrierInfo fromFile(String fileName) throws IOException {
            return new TUtranCarrierInfo(new ByteBufferKaitaiStream(fileName));
        }

        public TUtranCarrierInfo(KaitaiStream _io) {
            this(_io, null, null);
        }

        public TUtranCarrierInfo(KaitaiStream _io, KaitaiStruct _parent) {
            this(_io, _parent, null);
        }

        public TUtranCarrierInfo(KaitaiStream _io, KaitaiStruct _parent, HuaweiChrEventFile _root) {
            super(_io);
            this._parent = _parent;
            this._root = _root;
            _read();
        }
        private void _read() {
            this.dlArfcn = this._io.readU2be();
            this.ncellCount = this._io.readU1();
            this.ncellInfoList = new ArrayList<TUtranNcellInfoList>();
            for (int i = 0; i < ncellCount(); i++) {
                this.ncellInfoList.add(new TUtranNcellInfoList(this._io, this, _root));
            }
        }
        private int dlArfcn;
        private int ncellCount;
        private ArrayList<TUtranNcellInfoList> ncellInfoList;
        private HuaweiChrEventFile _root;
        private KaitaiStruct _parent;
        public int dlArfcn() { return dlArfcn; }
        public int ncellCount() { return ncellCount; }
        public ArrayList<TUtranNcellInfoList> ncellInfoList() { return ncellInfoList; }
        public HuaweiChrEventFile _root() { return _root; }
        public KaitaiStruct _parent() { return _parent; }
    }
    public static class TUeEutranNcellInfo extends KaitaiStruct {
        public static TUeEutranNcellInfo fromFile(String fileName) throws IOException {
            return new TUeEutranNcellInfo(new ByteBufferKaitaiStream(fileName));
        }

        public TUeEutranNcellInfo(KaitaiStream _io) {
            this(_io, null, null);
        }

        public TUeEutranNcellInfo(KaitaiStream _io, HuaweiChrEventFile.TUeEventNcellInfo _parent) {
            this(_io, _parent, null);
        }

        public TUeEutranNcellInfo(KaitaiStream _io, HuaweiChrEventFile.TUeEventNcellInfo _parent, HuaweiChrEventFile _root) {
            super(_io);
            this._parent = _parent;
            this._root = _root;
            _read();
        }
        private void _read() {
            this.ncellCount = this._io.readU1();
            this.ncellList = new ArrayList<TEutranNcellInfoList>();
            for (int i = 0; i < ncellCount(); i++) {
                this.ncellList.add(new TEutranNcellInfoList(this._io, this, _root));
            }
        }
        private int ncellCount;
        private ArrayList<TEutranNcellInfoList> ncellList;
        private HuaweiChrEventFile _root;
        private HuaweiChrEventFile.TUeEventNcellInfo _parent;
        public int ncellCount() { return ncellCount; }
        public ArrayList<TEutranNcellInfoList> ncellList() { return ncellList; }
        public HuaweiChrEventFile _root() { return _root; }
        public HuaweiChrEventFile.TUeEventNcellInfo _parent() { return _parent; }
    }
    public static class TM1IntraFreqMdtCellInfo extends KaitaiStruct {
        public static TM1IntraFreqMdtCellInfo fromFile(String fileName) throws IOException {
            return new TM1IntraFreqMdtCellInfo(new ByteBufferKaitaiStream(fileName));
        }

        public TM1IntraFreqMdtCellInfo(KaitaiStream _io) {
            this(_io, null, null);
        }

        public TM1IntraFreqMdtCellInfo(KaitaiStream _io, HuaweiChrEventFile.TM1IntraFreqMdt _parent) {
            this(_io, _parent, null);
        }

        public TM1IntraFreqMdtCellInfo(KaitaiStream _io, HuaweiChrEventFile.TM1IntraFreqMdt _parent, HuaweiChrEventFile _root) {
            super(_io);
            this._parent = _parent;
            this._root = _root;
            _read();
        }
        private void _read() {
            this.pci = this._io.readU2be();
            this.rsrp = this._io.readU1();
            this.rsrq = this._io.readU1();
        }
        private int pci;
        private int rsrp;
        private int rsrq;
        private HuaweiChrEventFile _root;
        private HuaweiChrEventFile.TM1IntraFreqMdt _parent;
        public int pci() { return pci; }
        public int rsrp() { return rsrp; }
        public int rsrq() { return rsrq; }
        public HuaweiChrEventFile _root() { return _root; }
        public HuaweiChrEventFile.TM1IntraFreqMdt _parent() { return _parent; }
    }
    private TFileHeader fileHeader;
    private ArrayList<TEventRecord> eventRecords;
    private HuaweiChrEventFile _root;
    private KaitaiStruct _parent;
    public TFileHeader fileHeader() { return fileHeader; }
    public ArrayList<TEventRecord> eventRecords() { return eventRecords; }
    public HuaweiChrEventFile _root() { return _root; }
    public KaitaiStruct _parent() { return _parent; }
}
