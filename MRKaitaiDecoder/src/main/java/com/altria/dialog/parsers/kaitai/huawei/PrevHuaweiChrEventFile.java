//// This is a generated file! Please edit source .ksy file and use kaitai-struct-compiler to rebuild
//
//package com.altria.dialog.parsers.kaitai.huawei;
//
//import io.kaitai.struct.ByteBufferKaitaiStream;
//import io.kaitai.struct.KaitaiStream;
//import io.kaitai.struct.KaitaiStruct;
//
//import java.io.IOException;
//import java.util.ArrayList;
//
//public class HuaweiChrEventFile extends KaitaiStruct {
//    public static HuaweiChrEventFile fromFile(String fileName) throws IOException {
//        return new HuaweiChrEventFile(new ByteBufferKaitaiStream(fileName));
//    }
//
//    public HuaweiChrEventFile(KaitaiStream _io) {
//        this(_io, null, null);
//    }
//
//    public HuaweiChrEventFile(KaitaiStream _io, KaitaiStruct _parent) {
//        this(_io, _parent, null);
//    }
//
//    public HuaweiChrEventFile(KaitaiStream _io, KaitaiStruct _parent, HuaweiChrEventFile _root) {
//        super(_io);
//        this._parent = _parent;
//        this._root = _root == null ? this : _root;
//        _read();
//    }
//    private void _read() {
//        this.fileHeader = new TFileHeader(this._io, this, _root);
//        this.eventRecords = new ArrayList<TEventRecord>();
//        {
//            int i = 0;
//            while (!this._io.isEof()) {
//                this.eventRecords.add(new TEventRecord(this._io, this, _root));
//                i++;
//            }
//        }
//    }
//    public static class TENcellInfo extends KaitaiStruct {
//        public static TENcellInfo fromFile(String fileName) throws IOException {
//            return new TENcellInfo(new ByteBufferKaitaiStream(fileName));
//        }
//
//        public TENcellInfo(KaitaiStream _io) {
//            this(_io, null, null);
//        }
//
//        public TENcellInfo(KaitaiStream _io, HuaweiChrEventFile.TPeriodIntraFrepMeasurement _parent) {
//            this(_io, _parent, null);
//        }
//
//        public TENcellInfo(KaitaiStream _io, HuaweiChrEventFile.TPeriodIntraFrepMeasurement _parent, HuaweiChrEventFile _root) {
//            super(_io);
//            this._parent = _parent;
//            this._root = _root;
//            _read();
//        }
//        private void _read() {
//            this.pci = this._io.readU2be();
//            this.rsrp = this._io.readU1();
//            this.rsrq = this._io.readU1();
//        }
//        private int pci;
//        private int rsrp;
//        private int rsrq;
//        private HuaweiChrEventFile _root;
//        private HuaweiChrEventFile.TPeriodIntraFrepMeasurement _parent;
//        public int pci() { return pci; }
//        public int rsrp() { return rsrp; }
//        public int rsrq() { return rsrq; }
//        public HuaweiChrEventFile _root() { return _root; }
//        public HuaweiChrEventFile.TPeriodIntraFrepMeasurement _parent() { return _parent; }
//    }
//    public static class TEventRecord extends KaitaiStruct {
//        public static TEventRecord fromFile(String fileName) throws IOException {
//            return new TEventRecord(new ByteBufferKaitaiStream(fileName));
//        }
//
//        public TEventRecord(KaitaiStream _io) {
//            this(_io, null, null);
//        }
//
//        public TEventRecord(KaitaiStream _io, HuaweiChrEventFile _parent) {
//            this(_io, _parent, null);
//        }
//
//        public TEventRecord(KaitaiStream _io, HuaweiChrEventFile _parent, HuaweiChrEventFile _root) {
//            super(_io);
//            this._parent = _parent;
//            this._root = _root;
//            _read();
//        }
//        private void _read() {
//            this.chrHeader = new TChrHeader(this._io, this, _root);
//            if (chrHeader().eventId() == 4097) {
//                this.publicInformation = new TPublicInformation(this._io, this, _root);
//            }
//            if (chrHeader().eventId() == 4610) {
//                this.periodIntraFrepMr = new TPeriodIntraFrepMeasurement(this._io, this, _root);
//            }
//            if (chrHeader().eventId() == 4625) {
//                this.periodUeTaMr = new TPeriodUeTaMr(this._io, this, _root);
//            }
//            if (chrHeader().eventId() == 4626) {
//                this.periodUeTaMdt = new TPeriodUeTaMdt(this._io, this, _root);
//            }
//            if (chrHeader().eventId() == 4866) {
//                this.periodIntraFrepMrMdt = new TPeriodIntraFrepMrMdt(this._io, this, _root);
//            }
//            if (chrHeader().eventId() == 4867) {
//                this.m1InterFreqMdt = new TM1InterFreqMdt(this._io, this, _root);
//            }
//            if ( ((chrHeader().eventId() != 4625) && (chrHeader().eventId() != 4097) && (chrHeader().eventId() != 4610) && (chrHeader().eventId() != 4626) && (chrHeader().eventId() != 4866) && (chrHeader().eventId() != 4867)) ) {
//                this.unsupported = this._io.readBytes((chrHeader().eventLength() - 21));
//            }
//
//            //Todo add new event type here
//        }
//        private TChrHeader chrHeader;
//        private TPublicInformation publicInformation;
//        private TPeriodIntraFrepMeasurement periodIntraFrepMr;
//        private TPeriodUeTaMr periodUeTaMr;
//        private TPeriodUeTaMdt periodUeTaMdt;
//        private TPeriodIntraFrepMrMdt periodIntraFrepMrMdt;
//        private TM1InterFreqMdt m1InterFreqMdt;
//        private byte[] unsupported;
//        private HuaweiChrEventFile _root;
//        private HuaweiChrEventFile _parent;
//        public TChrHeader chrHeader() { return chrHeader; }
//        public TPublicInformation publicInformation() { return publicInformation; }
//        public TPeriodIntraFrepMeasurement periodIntraFrepMr() { return periodIntraFrepMr; }
//        public TPeriodUeTaMr periodUeTaMr() { return periodUeTaMr; }
//        public TPeriodUeTaMdt periodUeTaMdt() { return periodUeTaMdt; }
//        public TPeriodIntraFrepMrMdt periodIntraFrepMrMdt() { return periodIntraFrepMrMdt; }
//        public TM1InterFreqMdt m1InterFreqMdt() {return m1InterFreqMdt; }
//        public byte[] unsupported() { return unsupported; }
//        public HuaweiChrEventFile _root() { return _root; }
//        public HuaweiChrEventFile _parent() { return _parent; }
//    }
//    public static class TPeriodIntraFrepMrMdt extends KaitaiStruct {
//        public static TPeriodIntraFrepMrMdt fromFile(String fileName) throws IOException {
//            return new TPeriodIntraFrepMrMdt(new ByteBufferKaitaiStream(fileName));
//        }
//
//        public TPeriodIntraFrepMrMdt(KaitaiStream _io) {
//            this(_io, null, null);
//        }
//
//        public TPeriodIntraFrepMrMdt(KaitaiStream _io, HuaweiChrEventFile.TEventRecord _parent) {
//            this(_io, _parent, null);
//        }
//
//        public TPeriodIntraFrepMrMdt(KaitaiStream _io, HuaweiChrEventFile.TEventRecord _parent, HuaweiChrEventFile _root) {
//            super(_io);
//            this._parent = _parent;
//            this._root = _root;
//            _read();
//        }
//        private void _read() {
//            this.measurementId = this._io.readU1();
//            this.servingCellRsrp = this._io.readU1();
//            this.servingCellRsrq = this._io.readU1();
//            this.nCellCount = this._io.readU1();
//            if (nCellCount() > 0) {
//                this.cellInfoList = new ArrayList<TIntraFreqMrCellInfo>();
//                for (int i = 0; i < nCellCount(); i++) {
//                    this.cellInfoList.add(new TIntraFreqMrCellInfo(this._io, this, _root));
//                }
//            }
//            this.locationInfoPresent = this._io.readU1();
//            if (locationInfoPresent() == 1) {
//                this.shapeType = this._io.readU1();
//            }
//            if ( ((locationInfoPresent() == 1) && (shapeType() == 0)) ) {
//                this.undefinedInfo = new TUndefinedInfo(this._io, this, _root);
//            }
//            if ( ((locationInfoPresent() == 1) && (shapeType() == 1)) ) {
//                this.ellipsoidPointInfo = new TEllipsoidPointInfo(this._io, this, _root);
//            }
//            if ( ((locationInfoPresent() == 1) && (shapeType() == 2)) ) {
//                this.ellipsoidPointWithAltitudeInfo = new TEllipsoidPointWithAltitudeInfo(this._io, this, _root);
//            }
//            if ( ((locationInfoPresent() == 1) && (shapeType() == 3)) ) {
//                this.ellipsoidPointWithUncertaintyCircleInfo = new TEllipsoidPointWithUncertaintyCircleInfo(this._io, this, _root);
//            }
//            if ( ((locationInfoPresent() == 1) && (shapeType() == 4)) ) {
//                this.ellipsoidPointWithUncertaintyEllipseInfo = new TEllipsoidPointWithUncertaintyEllipseInfo(this._io, this, _root);
//            }
//            if ( ((locationInfoPresent() == 1) && (shapeType() == 5)) ) {
//                this.ellipsoidPointWithAltitudAndUncertaintyEllipsoidInfo = new TEllipsoidPointWithAltitudAndUncertaintyEllipsoidInfo(this._io, this, _root);
//            }
//        }
//        private int measurementId;
//        private int servingCellRsrp;
//        private int servingCellRsrq;
//        private int nCellCount;
//        private ArrayList<TIntraFreqMrCellInfo> cellInfoList;
//        private int locationInfoPresent;
//        private Integer shapeType;
//        private TUndefinedInfo undefinedInfo;
//        private TEllipsoidPointInfo ellipsoidPointInfo;
//        private TEllipsoidPointWithAltitudeInfo ellipsoidPointWithAltitudeInfo;
//        private TEllipsoidPointWithUncertaintyCircleInfo ellipsoidPointWithUncertaintyCircleInfo;
//        private TEllipsoidPointWithUncertaintyEllipseInfo ellipsoidPointWithUncertaintyEllipseInfo;
//        private TEllipsoidPointWithAltitudAndUncertaintyEllipsoidInfo ellipsoidPointWithAltitudAndUncertaintyEllipsoidInfo;
//        private HuaweiChrEventFile _root;
//        private HuaweiChrEventFile.TEventRecord _parent;
//        public int measurementId() { return measurementId; }
//        public int servingCellRsrp() { return servingCellRsrp; }
//        public int servingCellRsrq() { return servingCellRsrq; }
//        public int nCellCount() { return nCellCount; }
//        public ArrayList<TIntraFreqMrCellInfo> cellInfoList() { return cellInfoList; }
//        public int locationInfoPresent() { return locationInfoPresent; }
//        public Integer shapeType() { return shapeType; }
//        public TUndefinedInfo undefinedInfo() { return undefinedInfo; }
//        public TEllipsoidPointInfo ellipsoidPointInfo() { return ellipsoidPointInfo; }
//        public TEllipsoidPointWithAltitudeInfo ellipsoidPointWithAltitudeInfo() { return ellipsoidPointWithAltitudeInfo; }
//        public TEllipsoidPointWithUncertaintyCircleInfo ellipsoidPointWithUncertaintyCircleInfo() { return ellipsoidPointWithUncertaintyCircleInfo; }
//        public TEllipsoidPointWithUncertaintyEllipseInfo ellipsoidPointWithUncertaintyEllipseInfo() { return ellipsoidPointWithUncertaintyEllipseInfo; }
//        public TEllipsoidPointWithAltitudAndUncertaintyEllipsoidInfo ellipsoidPointWithAltitudAndUncertaintyEllipsoidInfo() { return ellipsoidPointWithAltitudAndUncertaintyEllipsoidInfo; }
//        public HuaweiChrEventFile _root() { return _root; }
//        public HuaweiChrEventFile.TEventRecord _parent() { return _parent; }
//    }
//    public static class TPeriodUeTaMdt extends KaitaiStruct {
//        public static TPeriodUeTaMdt fromFile(String fileName) throws IOException {
//            return new TPeriodUeTaMdt(new ByteBufferKaitaiStream(fileName));
//        }
//
//        public TPeriodUeTaMdt(KaitaiStream _io) {
//            this(_io, null, null);
//        }
//
//        public TPeriodUeTaMdt(KaitaiStream _io, HuaweiChrEventFile.TEventRecord _parent) {
//            this(_io, _parent, null);
//        }
//
//        public TPeriodUeTaMdt(KaitaiStream _io, HuaweiChrEventFile.TEventRecord _parent, HuaweiChrEventFile _root) {
//            super(_io);
//            this._parent = _parent;
//            this._root = _root;
//            _read();
//        }
//        private void _read() {
//            this.ta = this._io.readU4be();
//        }
//        private long ta;
//        private HuaweiChrEventFile _root;
//        private HuaweiChrEventFile.TEventRecord _parent;
//        public long ta() { return ta; }
//        public HuaweiChrEventFile _root() { return _root; }
//        public HuaweiChrEventFile.TEventRecord _parent() { return _parent; }
//    }
//    public static class TEllipsoidPointWithAltitudAndUncertaintyEllipsoidInfo extends KaitaiStruct {
//        public static TEllipsoidPointWithAltitudAndUncertaintyEllipsoidInfo fromFile(String fileName) throws IOException {
//            return new TEllipsoidPointWithAltitudAndUncertaintyEllipsoidInfo(new ByteBufferKaitaiStream(fileName));
//        }
//
//        public TEllipsoidPointWithAltitudAndUncertaintyEllipsoidInfo(KaitaiStream _io) {
//            this(_io, null, null);
//        }
//
//        public TEllipsoidPointWithAltitudAndUncertaintyEllipsoidInfo(KaitaiStream _io, KaitaiStruct _parent) {
//            this(_io, _parent, null);
//        }
//
//        public TEllipsoidPointWithAltitudAndUncertaintyEllipsoidInfo(KaitaiStream _io, KaitaiStruct _parent, HuaweiChrEventFile _root) {
//            super(_io);
//            this._parent = _parent;
//            this._root = _root;
//            _read();
//        }
//        private void _read() {
//            this.latitudeSign = this._io.readU1();
//            this.degreesLatitude = this._io.readU4be();
//            this.degreesLongitude = this._io.readU4be();
//            this.altitudeDirection = this._io.readU1();
//            this.altitude = this._io.readU2be();
//            this.uncertaintySemiMajor = this._io.readU1();
//            this.uncertaintySemiMinor = this._io.readU1();
//            this.orientationMajorAxis = this._io.readU1();
//            this.uncertaintyAltitude = this._io.readU1();
//            this.confidence = this._io.readU1();
//        }
//        private int latitudeSign;
//        private long degreesLatitude;
//        private long degreesLongitude;
//        private int altitudeDirection;
//        private int altitude;
//        private int uncertaintySemiMajor;
//        private int uncertaintySemiMinor;
//        private int orientationMajorAxis;
//        private int uncertaintyAltitude;
//        private int confidence;
//        private HuaweiChrEventFile _root;
//        private KaitaiStruct _parent;
//        public int latitudeSign() { return latitudeSign; }
//        public long degreesLatitude() { return degreesLatitude; }
//        public long degreesLongitude() { return degreesLongitude; }
//        public int altitudeDirection() { return altitudeDirection; }
//        public int altitude() { return altitude; }
//        public int uncertaintySemiMajor() { return uncertaintySemiMajor; }
//        public int uncertaintySemiMinor() { return uncertaintySemiMinor; }
//        public int orientationMajorAxis() { return orientationMajorAxis; }
//        public int uncertaintyAltitude() { return uncertaintyAltitude; }
//        public int confidence() { return confidence; }
//        public HuaweiChrEventFile _root() { return _root; }
//        public KaitaiStruct _parent() { return _parent; }
//    }
//    public static class TEllipsoidPointWithAltitudeInfo extends KaitaiStruct {
//        public static TEllipsoidPointWithAltitudeInfo fromFile(String fileName) throws IOException {
//            return new TEllipsoidPointWithAltitudeInfo(new ByteBufferKaitaiStream(fileName));
//        }
//
//        public TEllipsoidPointWithAltitudeInfo(KaitaiStream _io) {
//            this(_io, null, null);
//        }
//
//        public TEllipsoidPointWithAltitudeInfo(KaitaiStream _io, KaitaiStruct _parent) {
//            this(_io, _parent, null);
//        }
//
//        public TEllipsoidPointWithAltitudeInfo(KaitaiStream _io, KaitaiStruct _parent, HuaweiChrEventFile _root) {
//            super(_io);
//            this._parent = _parent;
//            this._root = _root;
//            _read();
//        }
//        private void _read() {
//            this.latitudeSign = this._io.readU1();
//            this.degreesLatitude = this._io.readU4be();
//            this.degreesLongitude = this._io.readU4be();
//            this.altitudeDirection = this._io.readU1();
//            this.altitude = this._io.readU2be();
//        }
//        private int latitudeSign;
//        private long degreesLatitude;
//        private long degreesLongitude;
//        private int altitudeDirection;
//        private int altitude;
//        private HuaweiChrEventFile _root;
//        private KaitaiStruct _parent;
//        public int latitudeSign() { return latitudeSign; }
//        public long degreesLatitude() { return degreesLatitude; }
//        public long degreesLongitude() { return degreesLongitude; }
//        public int altitudeDirection() { return altitudeDirection; }
//        public int altitude() { return altitude; }
//        public HuaweiChrEventFile _root() { return _root; }
//        public KaitaiStruct _parent() { return _parent; }
//    }
//    public static class TPeriodIntraFrepMeasurement extends KaitaiStruct {
//        public static TPeriodIntraFrepMeasurement fromFile(String fileName) throws IOException {
//            return new TPeriodIntraFrepMeasurement(new ByteBufferKaitaiStream(fileName));
//        }
//
//        public TPeriodIntraFrepMeasurement(KaitaiStream _io) {
//            this(_io, null, null);
//        }
//
//        public TPeriodIntraFrepMeasurement(KaitaiStream _io, HuaweiChrEventFile.TEventRecord _parent) {
//            this(_io, _parent, null);
//        }
//
//        public TPeriodIntraFrepMeasurement(KaitaiStream _io, HuaweiChrEventFile.TEventRecord _parent, HuaweiChrEventFile _root) {
//            super(_io);
//            this._parent = _parent;
//            this._root = _root;
//            _read();
//        }
//        private void _read() {
//            this.measurementId = this._io.readU1();
//            this.rsrpRslt = this._io.readU1();
//            this.rsrqRslt = this._io.readU1();
//            this.nCellCount = this._io.readU1();
//            if (nCellCount() > 0) {
//                this.cellInfoList = new ArrayList<TENcellInfo>();
//                for (int i = 0; i < nCellCount(); i++) {
//                    this.cellInfoList.add(new TENcellInfo(this._io, this, _root));
//                }
//            }
//        }
//        private int measurementId;
//        private int rsrpRslt;
//        private int rsrqRslt;
//        private int nCellCount;
//        private ArrayList<TENcellInfo> cellInfoList;
//        private HuaweiChrEventFile _root;
//        private HuaweiChrEventFile.TEventRecord _parent;
//        public int measurementId() { return measurementId; }
//        public int rsrpRslt() { return rsrpRslt; }
//        public int rsrqRslt() { return rsrqRslt; }
//        public int nCellCount() { return nCellCount; }
//        public ArrayList<TENcellInfo> cellInfoList() { return cellInfoList; }
//        public HuaweiChrEventFile _root() { return _root; }
//        public HuaweiChrEventFile.TEventRecord _parent() { return _parent; }
//    }
//    public static class TEllipsoidPointWithUncertaintyCircleInfo extends KaitaiStruct {
//        public static TEllipsoidPointWithUncertaintyCircleInfo fromFile(String fileName) throws IOException {
//            return new TEllipsoidPointWithUncertaintyCircleInfo(new ByteBufferKaitaiStream(fileName));
//        }
//
//        public TEllipsoidPointWithUncertaintyCircleInfo(KaitaiStream _io) {
//            this(_io, null, null);
//        }
//
//        public TEllipsoidPointWithUncertaintyCircleInfo(KaitaiStream _io, KaitaiStruct _parent) {
//            this(_io, _parent, null);
//        }
//
//        public TEllipsoidPointWithUncertaintyCircleInfo(KaitaiStream _io, KaitaiStruct _parent, HuaweiChrEventFile _root) {
//            super(_io);
//            this._parent = _parent;
//            this._root = _root;
//            _read();
//        }
//        private void _read() {
//            this.latitudeSign = this._io.readU1();
//            this.degreesLatitude = this._io.readU4be();
//            this.degreesLongitude = this._io.readU4be();
//            this.uncertainty = this._io.readU1();
//        }
//        private int latitudeSign;
//        private long degreesLatitude;
//        private long degreesLongitude;
//        private int uncertainty;
//        private HuaweiChrEventFile _root;
//        private KaitaiStruct _parent;
//        public int latitudeSign() { return latitudeSign; }
//        public long degreesLatitude() { return degreesLatitude; }
//        public long degreesLongitude() { return degreesLongitude; }
//        public int uncertainty() { return uncertainty; }
//        public HuaweiChrEventFile _root() { return _root; }
//        public KaitaiStruct _parent() { return _parent; }
//    }
//    public static class TChrHeader extends KaitaiStruct {
//        public static TChrHeader fromFile(String fileName) throws IOException {
//            return new TChrHeader(new ByteBufferKaitaiStream(fileName));
//        }
//
//        public TChrHeader(KaitaiStream _io) {
//            this(_io, null, null);
//        }
//
//        public TChrHeader(KaitaiStream _io, HuaweiChrEventFile.TEventRecord _parent) {
//            this(_io, _parent, null);
//        }
//
//        public TChrHeader(KaitaiStream _io, HuaweiChrEventFile.TEventRecord _parent, HuaweiChrEventFile _root) {
//            super(_io);
//            this._parent = _parent;
//            this._root = _root;
//            _read();
//        }
//        private void _read() {
//            this.eventId = this._io.readU2be();
//            this.eventLength = this._io.readU4be();
//            this.eNodeBid = this._io.readU4be();
//            this.cellId = this._io.readU1();
//            this.callId = this._io.readU4be();
//            this.datetimeYear = this._io.readU1();
//            this.datetimeMonth = this._io.readU1();
//            this.datetimeDay = this._io.readU1();
//            this.datetimeHour = this._io.readU1();
//            this.datetimeMinute = this._io.readU1();
//            this.datetimeSecond = this._io.readU1();
//            this.datetimeMillisecond = this._io.readU2be();
//            this.extendHeadLen = this._io.readU1();
//            this.itemtypeAndReserved = this._io.readU1();
//            this.cRnti = this._io.readU2be();
//        }
//        private int eventId;
//        private long eventLength;
//        private long eNodeBid;
//        private int cellId;
//        private long callId;
//        private int datetimeYear;
//        private int datetimeMonth;
//        private int datetimeDay;
//        private int datetimeHour;
//        private int datetimeMinute;
//        private int datetimeSecond;
//        private int datetimeMillisecond;
//        private int extendHeadLen;
//        private int itemtypeAndReserved;
//        private int cRnti;
//        private HuaweiChrEventFile _root;
//        private HuaweiChrEventFile.TEventRecord _parent;
//        public int eventId() { return eventId; }
//        public long eventLength() { return eventLength; }
//        public long eNodeBid() { return eNodeBid; }
//        public int cellId() { return cellId; }
//        public long callId() { return callId; }
//        public int datetimeYear() { return datetimeYear; }
//        public int datetimeMonth() { return datetimeMonth; }
//        public int datetimeDay() { return datetimeDay; }
//        public int datetimeHour() { return datetimeHour; }
//        public int datetimeMinute() { return datetimeMinute; }
//        public int datetimeSecond() { return datetimeSecond; }
//        public int datetimeMillisecond() { return datetimeMillisecond; }
//        public int extendHeadLen() { return extendHeadLen; }
//        public int itemtypeAndReserved() { return itemtypeAndReserved; }
//        public int cRnti() { return cRnti; }
//        public HuaweiChrEventFile _root() { return _root; }
//        public HuaweiChrEventFile.TEventRecord _parent() { return _parent; }
//    }
//    public static class TUndefinedInfo extends KaitaiStruct {
//        public static TUndefinedInfo fromFile(String fileName) throws IOException {
//            return new TUndefinedInfo(new ByteBufferKaitaiStream(fileName));
//        }
//
//        public TUndefinedInfo(KaitaiStream _io) {
//            this(_io, null, null);
//        }
//
//        public TUndefinedInfo(KaitaiStream _io, KaitaiStruct _parent) {
//            this(_io, _parent, null);
//        }
//
//        public TUndefinedInfo(KaitaiStream _io, KaitaiStruct _parent, HuaweiChrEventFile _root) {
//            super(_io);
//            this._parent = _parent;
//            this._root = _root;
//            _read();
//        }
//        private void _read() {
//            this.latitudeSign = this._io.readU1();
//            this.degreesLatitude = this._io.readU4be();
//            this.degreesLongitude = this._io.readU4be();
//            this.altitudeSign = this._io.readU1();
//            this.degreesAltitude = this._io.readU2be();
//            this.uncertaintyCycle = this._io.readU1();
//        }
//        private int latitudeSign;
//        private long degreesLatitude;
//        private long degreesLongitude;
//        private int altitudeSign;
//        private int degreesAltitude;
//        private int uncertaintyCycle;
//        private HuaweiChrEventFile _root;
//        private KaitaiStruct _parent;
//        public int latitudeSign() { return latitudeSign; }
//        public long degreesLatitude() { return degreesLatitude; }
//        public long degreesLongitude() { return degreesLongitude; }
//        public int altitudeSign() { return altitudeSign; }
//        public int degreesAltitude() { return degreesAltitude; }
//        public int uncertaintyCycle() { return uncertaintyCycle; }
//        public HuaweiChrEventFile _root() { return _root; }
//        public KaitaiStruct _parent() { return _parent; }
//    }
//    public static class TFileHeader extends KaitaiStruct {
//        public static TFileHeader fromFile(String fileName) throws IOException {
//            return new TFileHeader(new ByteBufferKaitaiStream(fileName));
//        }
//
//        public TFileHeader(KaitaiStream _io) {
//            this(_io, null, null);
//        }
//
//        public TFileHeader(KaitaiStream _io, HuaweiChrEventFile _parent) {
//            this(_io, _parent, null);
//        }
//
//        public TFileHeader(KaitaiStream _io, HuaweiChrEventFile _parent, HuaweiChrEventFile _root) {
//            super(_io);
//            this._parent = _parent;
//            this._root = _root;
//            _read();
//        }
//        private void _read() {
//            this.mainVersion = this._io.readU1();
//            this.subVersion = this._io.readU1();
//            this.traceNo = this._io.readU4be();
//            this.reserved = this._io.readBytes(26);
//        }
//        private int mainVersion;
//        private int subVersion;
//        private long traceNo;
//        private byte[] reserved;
//        private HuaweiChrEventFile _root;
//        private HuaweiChrEventFile _parent;
//        public int mainVersion() { return mainVersion; }
//        public int subVersion() { return subVersion; }
//        public long traceNo() { return traceNo; }
//        public byte[] reserved() { return reserved; }
//        public HuaweiChrEventFile _root() { return _root; }
//        public HuaweiChrEventFile _parent() { return _parent; }
//    }
//    public static class TPeriodUeTaMr extends KaitaiStruct {
//        public static TPeriodUeTaMr fromFile(String fileName) throws IOException {
//            return new TPeriodUeTaMr(new ByteBufferKaitaiStream(fileName));
//        }
//
//        public TPeriodUeTaMr(KaitaiStream _io) {
//            this(_io, null, null);
//        }
//
//        public TPeriodUeTaMr(KaitaiStream _io, HuaweiChrEventFile.TEventRecord _parent) {
//            this(_io, _parent, null);
//        }
//
//        public TPeriodUeTaMr(KaitaiStream _io, HuaweiChrEventFile.TEventRecord _parent, HuaweiChrEventFile _root) {
//            super(_io);
//            this._parent = _parent;
//            this._root = _root;
//            _read();
//        }
//        private void _read() {
//            this.ta = this._io.readU4be();
//        }
//        private long ta;
//        private HuaweiChrEventFile _root;
//        private HuaweiChrEventFile.TEventRecord _parent;
//        public long ta() { return ta; }
//        public HuaweiChrEventFile _root() { return _root; }
//        public HuaweiChrEventFile.TEventRecord _parent() { return _parent; }
//    }
//    public static class TIntraFreqMrCellInfo extends KaitaiStruct {
//        public static TIntraFreqMrCellInfo fromFile(String fileName) throws IOException {
//            return new TIntraFreqMrCellInfo(new ByteBufferKaitaiStream(fileName));
//        }
//
//        public TIntraFreqMrCellInfo(KaitaiStream _io) {
//            this(_io, null, null);
//        }
//
//        public TIntraFreqMrCellInfo(KaitaiStream _io, HuaweiChrEventFile.TPeriodIntraFrepMrMdt _parent) {
//            this(_io, _parent, null);
//        }
//
//        public TIntraFreqMrCellInfo(KaitaiStream _io, HuaweiChrEventFile.TPeriodIntraFrepMrMdt _parent, HuaweiChrEventFile _root) {
//            super(_io);
//            this._parent = _parent;
//            this._root = _root;
//            _read();
//        }
//        private void _read() {
//            this.pci = this._io.readU2be();
//            this.rsrp = this._io.readU1();
//            this.rsrq = this._io.readU1();
//        }
//        private int pci;
//        private int rsrp;
//        private int rsrq;
//        private HuaweiChrEventFile _root;
//        private HuaweiChrEventFile.TPeriodIntraFrepMrMdt _parent;
//        public int pci() { return pci; }
//        public int rsrp() { return rsrp; }
//        public int rsrq() { return rsrq; }
//        public HuaweiChrEventFile _root() { return _root; }
//        public HuaweiChrEventFile.TPeriodIntraFrepMrMdt _parent() { return _parent; }
//    }
//
//    public static class TM1InterFreqMdt extends KaitaiStruct {
//        public static TM1InterFreqMdt fromFile(String fileName) throws IOException {
//            return new TM1InterFreqMdt(new ByteBufferKaitaiStream(fileName));
//        }
//
//        public TM1InterFreqMdt(KaitaiStream _io) {
//            this(_io, null, null);
//        }
//
//        public TM1InterFreqMdt(KaitaiStream _io, HuaweiChrEventFile.TEventRecord _parent) {
//            this(_io, _parent, null);
//        }
//
//        public TM1InterFreqMdt(KaitaiStream _io, HuaweiChrEventFile.TEventRecord _parent, HuaweiChrEventFile _root) {
//            super(_io);
//            this._parent = _parent;
//            this._root = _root;
//            _read();
//        }
//        public void _read() {
//            this.measurementId = this._io.readU1();
//            this.servingCellRsrp = this._io.readU1();
//            this.servingCellRsrq = this._io.readU1();
//            this.nCellCount = this._io.readU1();
//            if (nCellCount() > 0) {
//                this.cellInfoList = new ArrayList<TM1InterFreqMdtCellInfo>();
//                for (int i = 0; i < nCellCount(); i++) {
//                    this.cellInfoList.add(new TM1InterFreqMdtCellInfo(this._io, this, _root));
//                }
//            }
//            this.locationInfoPresent = this._io.readU1();
//            if (locationInfoPresent() == 1) {
//                this.shapeType = this._io.readU1();
//            }
//            if ( ((locationInfoPresent() == 1) && (shapeType() == 0)) ) {
//                this.undefinedInfo = new TUndefinedInfo(this._io, this, _root);
//            }
//            if ( ((locationInfoPresent() == 1) && (shapeType() == 1)) ) {
//                this.ellipsoidPointInfo = new TEllipsoidPointInfo(this._io, this, _root);
//            }
//            if ( ((locationInfoPresent() == 1) && (shapeType() == 2)) ) {
//                this.ellipsoidPointWithAltitudeInfo = new TEllipsoidPointWithAltitudeInfo(this._io, this, _root);
//            }
//            if ( ((locationInfoPresent() == 1) && (shapeType() == 3)) ) {
//                this.ellipsoidPointWithUncertaintyCircleInfo = new TEllipsoidPointWithUncertaintyCircleInfo(this._io, this, _root);
//            }
//            if ( ((locationInfoPresent() == 1) && (shapeType() == 4)) ) {
//                this.ellipsoidPointWithUncertaintyEllipseInfo = new TEllipsoidPointWithUncertaintyEllipseInfo(this._io, this, _root);
//            }
//            if ( ((locationInfoPresent() == 1) && (shapeType() == 5)) ) {
//                this.ellipsoidPointWithAltitudAndUncertaintyEllipsoidInfo = new TEllipsoidPointWithAltitudAndUncertaintyEllipsoidInfo(this._io, this, _root);
//            }
//        }
//
//        private int measurementId;
//        private int servingCellRsrp;
//        private int servingCellRsrq;
//        private int nCellCount;
//        private ArrayList<TM1InterFreqMdtCellInfo> cellInfoList;
//        private int locationInfoPresent;
//        private Integer shapeType;
//        private TUndefinedInfo undefinedInfo;
//        private TEllipsoidPointInfo ellipsoidPointInfo;
//        private TEllipsoidPointWithAltitudeInfo ellipsoidPointWithAltitudeInfo;
//        private TEllipsoidPointWithUncertaintyCircleInfo ellipsoidPointWithUncertaintyCircleInfo;
//        private TEllipsoidPointWithUncertaintyEllipseInfo ellipsoidPointWithUncertaintyEllipseInfo;
//        private TEllipsoidPointWithAltitudAndUncertaintyEllipsoidInfo ellipsoidPointWithAltitudAndUncertaintyEllipsoidInfo;
//        private HuaweiChrEventFile _root;
//        private HuaweiChrEventFile.TEventRecord _parent;
//        public int measurementId() { return measurementId; }
//        public int servingCellRsrp() { return servingCellRsrp; }
//        public int servingCellRsrq() { return servingCellRsrq; }
//        public int nCellCount() { return nCellCount; }
//        public ArrayList<TM1InterFreqMdtCellInfo> cellInfoList() { return cellInfoList; }
//        public int locationInfoPresent() { return locationInfoPresent; }
//        public Integer shapeType() { return shapeType; }
//        public TUndefinedInfo undefinedInfo() { return undefinedInfo; }
//        public TEllipsoidPointInfo ellipsoidPointInfo() { return ellipsoidPointInfo; }
//        public TEllipsoidPointWithAltitudeInfo ellipsoidPointWithAltitudeInfo() { return ellipsoidPointWithAltitudeInfo; }
//        public TEllipsoidPointWithUncertaintyCircleInfo ellipsoidPointWithUncertaintyCircleInfo() { return ellipsoidPointWithUncertaintyCircleInfo; }
//        public TEllipsoidPointWithUncertaintyEllipseInfo ellipsoidPointWithUncertaintyEllipseInfo() { return ellipsoidPointWithUncertaintyEllipseInfo; }
//        public TEllipsoidPointWithAltitudAndUncertaintyEllipsoidInfo ellipsoidPointWithAltitudAndUncertaintyEllipsoidInfo() { return ellipsoidPointWithAltitudAndUncertaintyEllipsoidInfo; }
//        public HuaweiChrEventFile _root() { return _root; }
//        public HuaweiChrEventFile.TEventRecord _parent() { return _parent; }
//    }
//    public static class TM1InterFreqMdtCellInfo extends KaitaiStruct {
//
//        public static TM1InterFreqMdtCellInfo fromFile(String fileName) throws IOException {
//            return new TM1InterFreqMdtCellInfo(new ByteBufferKaitaiStream(fileName));
//        }
//
//        public TM1InterFreqMdtCellInfo(KaitaiStream _io) {
//            this(_io, null, null);
//        }
//
//        public TM1InterFreqMdtCellInfo(KaitaiStream _io, HuaweiChrEventFile.TM1InterFreqMdt _parent) {
//            this(_io, _parent, null);
//        }
//
//        public TM1InterFreqMdtCellInfo(KaitaiStream _io, HuaweiChrEventFile.TM1InterFreqMdt _parent, HuaweiChrEventFile _root) {
//            super(_io);
//            this._parent = _parent;
//            this._root = _root;
//            _read();
//        }
//        public void _read() {
//            this.cellId = this._io.readU4be();
//            this.pci = this._io.readU2be();
//            this.carrierFrequency = this._io.readU4be();
//            this.rsrp = this._io.readU1();
//            this.rsrq = this._io.readU1();
//        }
//        private long cellId;
//        private int pci;
//        private long carrierFrequency;
//        private int rsrp;
//        private int rsrq;
//        private HuaweiChrEventFile _root;
//        private HuaweiChrEventFile.TM1InterFreqMdt _parent;
//        public long cellId() { return cellId; }
//        public int pci() { return pci; }
//        public long carrierFrequency() { return carrierFrequency; }
//        public int rsrp() { return rsrp; }
//        public int rsrq() { return rsrq; }
//        public HuaweiChrEventFile _root() { return _root; }
//        public HuaweiChrEventFile.TM1InterFreqMdt _parent() { return _parent; }
//    }
//
//    public static class TEllipsoidPointWithUncertaintyEllipseInfo extends KaitaiStruct {
//        public static TEllipsoidPointWithUncertaintyEllipseInfo fromFile(String fileName) throws IOException {
//            return new TEllipsoidPointWithUncertaintyEllipseInfo(new ByteBufferKaitaiStream(fileName));
//        }
//
//        public TEllipsoidPointWithUncertaintyEllipseInfo(KaitaiStream _io) {
//            this(_io, null, null);
//        }
//
//        public TEllipsoidPointWithUncertaintyEllipseInfo(KaitaiStream _io, KaitaiStruct _parent) {
//            this(_io, _parent, null);
//        }
//
//        public TEllipsoidPointWithUncertaintyEllipseInfo(KaitaiStream _io, KaitaiStruct _parent, HuaweiChrEventFile _root) {
//            super(_io);
//            this._parent = _parent;
//            this._root = _root;
//            _read();
//        }
//        private void _read() {
//            this.latitudeSign = this._io.readU1();
//            this.degreesLatitude = this._io.readU4be();
//            this.degreesLongitude = this._io.readU4be();
//            this.uncertaintySemiMajor = this._io.readU1();
//            this.uncertaintySemiMinor = this._io.readU1();
//            this.orientationMajorAxis = this._io.readU1();
//            this.confidence = this._io.readU1();
//        }
//        private int latitudeSign;
//        private long degreesLatitude;
//        private long degreesLongitude;
//        private int uncertaintySemiMajor;
//        private int uncertaintySemiMinor;
//        private int orientationMajorAxis;
//        private int confidence;
//        private HuaweiChrEventFile _root;
//        private KaitaiStruct _parent;
//        public int latitudeSign() { return latitudeSign; }
//        public long degreesLatitude() { return degreesLatitude; }
//        public long degreesLongitude() { return degreesLongitude; }
//        public int uncertaintySemiMajor() { return uncertaintySemiMajor; }
//        public int uncertaintySemiMinor() { return uncertaintySemiMinor; }
//        public int orientationMajorAxis() { return orientationMajorAxis; }
//        public int confidence() { return confidence; }
//        public HuaweiChrEventFile _root() { return _root; }
//        public KaitaiStruct _parent() { return _parent; }
//    }
//    public static class TEllipsoidPointInfo extends KaitaiStruct {
//        public static TEllipsoidPointInfo fromFile(String fileName) throws IOException {
//            return new TEllipsoidPointInfo(new ByteBufferKaitaiStream(fileName));
//        }
//
//        public TEllipsoidPointInfo(KaitaiStream _io) {
//            this(_io, null, null);
//        }
//
//        public TEllipsoidPointInfo(KaitaiStream _io, KaitaiStruct _parent) {
//            this(_io, _parent, null);
//        }
//
//        public TEllipsoidPointInfo(KaitaiStream _io, KaitaiStruct _parent, HuaweiChrEventFile _root) {
//            super(_io);
//            this._parent = _parent;
//            this._root = _root;
//            _read();
//        }
//        private void _read() {
//            this.latitudeSign = this._io.readU1();
//            this.degreesLatitude = this._io.readU4be();
//            this.degreesLongitude = this._io.readU4be();
//        }
//        private int latitudeSign;
//        private long degreesLatitude;
//        private long degreesLongitude;
//        private HuaweiChrEventFile _root;
//        private KaitaiStruct _parent;
//        public int latitudeSign() { return latitudeSign; }
//        public long degreesLatitude() { return degreesLatitude; }
//        public long degreesLongitude() { return degreesLongitude; }
//        public HuaweiChrEventFile _root() { return _root; }
//        public KaitaiStruct _parent() { return _parent; }
//    }
//    public static class TPublicInformation extends KaitaiStruct {
//        public static TPublicInformation fromFile(String fileName) throws IOException {
//            return new TPublicInformation(new ByteBufferKaitaiStream(fileName));
//        }
//
//        public TPublicInformation(KaitaiStream _io) {
//            this(_io, null, null);
//        }
//
//        public TPublicInformation(KaitaiStream _io, HuaweiChrEventFile.TEventRecord _parent) {
//            this(_io, _parent, null);
//        }
//
//        public TPublicInformation(KaitaiStream _io, HuaweiChrEventFile.TEventRecord _parent, HuaweiChrEventFile _root) {
//            super(_io);
//            this._parent = _parent;
//            this._root = _root;
//            _read();
//        }
//        private void _read() {
//            this.plmn = new TPlmnFormat1(this._io, this, _root);
//            this.mmeGroupId = this._io.readU2be();
//            this.mmeCode = this._io.readU1();
//            this.mtmsi = this._io.readU4be();
//            this.mmeUeS1apId = this._io.readU4be();
//            this.enodebUeSiapId = this._io.readU4be();
//        }
//        private TPlmnFormat1 plmn;
//        private int mmeGroupId;
//        private int mmeCode;
//        private long mtmsi;
//        private long mmeUeS1apId;
//        private long enodebUeSiapId;
//        private HuaweiChrEventFile _root;
//        private HuaweiChrEventFile.TEventRecord _parent;
//        public TPlmnFormat1 plmn() { return plmn; }
//        public int mmeGroupId() { return mmeGroupId; }
//        public int mmeCode() { return mmeCode; }
//        public long mtmsi() { return mtmsi; }
//        public long mmeUeS1apId() { return mmeUeS1apId; }
//        public long enodebUeSiapId() { return enodebUeSiapId; }
//        public HuaweiChrEventFile _root() { return _root; }
//        public HuaweiChrEventFile.TEventRecord _parent() { return _parent; }
//    }
//    public static class TPlmnFormat1 extends KaitaiStruct {
//        public static TPlmnFormat1 fromFile(String fileName) throws IOException {
//            return new TPlmnFormat1(new ByteBufferKaitaiStream(fileName));
//        }
//
//        public TPlmnFormat1(KaitaiStream _io) {
//            this(_io, null, null);
//        }
//
//        public TPlmnFormat1(KaitaiStream _io, HuaweiChrEventFile.TPublicInformation _parent) {
//            this(_io, _parent, null);
//        }
//
//        public TPlmnFormat1(KaitaiStream _io, HuaweiChrEventFile.TPublicInformation _parent, HuaweiChrEventFile _root) {
//            super(_io);
//            this._parent = _parent;
//            this._root = _root;
//            _read();
//        }
//        private void _read() {
//            this.plmnIdReserved = this._io.readU1();
//            this.plmnId = this._io.readBytes(3);
//        }
//        private int plmnIdReserved;
//        private byte[] plmnId;
//        private HuaweiChrEventFile _root;
//        private HuaweiChrEventFile.TPublicInformation _parent;
//        public int plmnIdReserved() { return plmnIdReserved; }
//        public byte[] plmnId() { return plmnId; }
//        public HuaweiChrEventFile _root() { return _root; }
//        public HuaweiChrEventFile.TPublicInformation _parent() { return _parent; }
//    }
//    private TFileHeader fileHeader;
//    private ArrayList<TEventRecord> eventRecords;
//    private HuaweiChrEventFile _root;
//    private KaitaiStruct _parent;
//    public TFileHeader fileHeader() { return fileHeader; }
//    public ArrayList<TEventRecord> eventRecords() { return eventRecords; }
//    public HuaweiChrEventFile _root() { return _root; }
//    public KaitaiStruct _parent() { return _parent; }
//}
//
