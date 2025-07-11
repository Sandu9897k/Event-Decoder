// This is a generated file! Please edit source .ksy file and use kaitai-struct-compiler to rebuild

package com.altria.dialog.parsers.kaitai.ericsson;

import io.kaitai.struct.ByteBufferKaitaiStream;
import io.kaitai.struct.KaitaiStruct;
import io.kaitai.struct.KaitaiStream;
import java.io.IOException;
import java.util.ArrayList;

public class Ericsson3112EventsFile extends KaitaiStruct {
    public static Ericsson3112EventsFile fromFile(String fileName) throws IOException {
        return new Ericsson3112EventsFile(new ByteBufferKaitaiStream(fileName));
    }

    public Ericsson3112EventsFile(KaitaiStream _io) {
        this(_io, null, null);
    }

    public Ericsson3112EventsFile(KaitaiStream _io, KaitaiStruct _parent) {
        this(_io, _parent, null);
    }

    public Ericsson3112EventsFile(KaitaiStream _io, KaitaiStruct _parent, Ericsson3112EventsFile _root) {
        super(_io);
        this._parent = _parent;
        this._root = _root == null ? this : _root;
        _read();
    }
    private void _read() {
        this.eventRecords = new ArrayList<TEvent3112Type>();
        {
            int i = 0;
            while (!this._io.isEof()) {
                this.eventRecords.add(new TEvent3112Type(this._io, this, _root));
                i++;
            }
        }
    }
    public static class TE3112MdtM1EllipsoidPointWithAlti extends KaitaiStruct {
        public static TE3112MdtM1EllipsoidPointWithAlti fromFile(String fileName) throws IOException {
            return new TE3112MdtM1EllipsoidPointWithAlti(new ByteBufferKaitaiStream(fileName));
        }

        public TE3112MdtM1EllipsoidPointWithAlti(KaitaiStream _io) {
            this(_io, null, null);
        }

        public TE3112MdtM1EllipsoidPointWithAlti(KaitaiStream _io, Ericsson3112EventsFile.TEvent3112Type _parent) {
            this(_io, _parent, null);
        }

        public TE3112MdtM1EllipsoidPointWithAlti(KaitaiStream _io, Ericsson3112EventsFile.TEvent3112Type _parent, Ericsson3112EventsFile _root) {
            super(_io);
            this._parent = _parent;
            this._root = _root;
            _read();
        }
        private void _read() {
            this.latitudeSign = this._io.readU1();
            this.degreesLatitude = this._io.readBitsIntBe(24);
            this.degreesLongitude = this._io.readBitsIntBe(24);
            this._io.alignToByte();
            this.altitudeDirection = this._io.readU1();
            this.altitude = this._io.readU2be();
            this.spare = this._io.readBytes(1);
        }
        private int latitudeSign;
        private long degreesLatitude;
        private long degreesLongitude;
        private int altitudeDirection;
        private int altitude;
        private byte[] spare;
        private Ericsson3112EventsFile _root;
        private Ericsson3112EventsFile.TEvent3112Type _parent;
        public int latitudeSign() { return latitudeSign; }
        public long degreesLatitude() { return degreesLatitude; }
        public long degreesLongitude() { return degreesLongitude; }
        public int altitudeDirection() { return altitudeDirection; }
        public int altitude() { return altitude; }
        public byte[] spare() { return spare; }
        public Ericsson3112EventsFile _root() { return _root; }
        public Ericsson3112EventsFile.TEvent3112Type _parent() { return _parent; }
    }
    public static class TE3112MdtM1EllipsoidPointWithUncerEllipse extends KaitaiStruct {
        public static TE3112MdtM1EllipsoidPointWithUncerEllipse fromFile(String fileName) throws IOException {
            return new TE3112MdtM1EllipsoidPointWithUncerEllipse(new ByteBufferKaitaiStream(fileName));
        }

        public TE3112MdtM1EllipsoidPointWithUncerEllipse(KaitaiStream _io) {
            this(_io, null, null);
        }

        public TE3112MdtM1EllipsoidPointWithUncerEllipse(KaitaiStream _io, Ericsson3112EventsFile.TEvent3112Type _parent) {
            this(_io, _parent, null);
        }

        public TE3112MdtM1EllipsoidPointWithUncerEllipse(KaitaiStream _io, Ericsson3112EventsFile.TEvent3112Type _parent, Ericsson3112EventsFile _root) {
            super(_io);
            this._parent = _parent;
            this._root = _root;
            _read();
        }
        private void _read() {
            this.latitudeSign = this._io.readU1();
            this.degreesLatitude = this._io.readBitsIntBe(24);
            this.degreesLongitude = this._io.readBitsIntBe(24);
            this._io.alignToByte();
            this.uncertaintySemiMajor = this._io.readU1();
            this.uncertaintySemiMinor = this._io.readU1();
            this.orientaionMajorAxis = this._io.readU1();
            this.confidence = this._io.readU1();
            this.spare = this._io.readBytes(1);
        }
        private int latitudeSign;
        private long degreesLatitude;
        private long degreesLongitude;
        private int uncertaintySemiMajor;
        private int uncertaintySemiMinor;
        private int orientaionMajorAxis;
        private int confidence;
        private byte[] spare;
        private Ericsson3112EventsFile _root;
        private Ericsson3112EventsFile.TEvent3112Type _parent;
        public int latitudeSign() { return latitudeSign; }
        public long degreesLatitude() { return degreesLatitude; }
        public long degreesLongitude() { return degreesLongitude; }
        public int uncertaintySemiMajor() { return uncertaintySemiMajor; }
        public int uncertaintySemiMinor() { return uncertaintySemiMinor; }
        public int orientaionMajorAxis() { return orientaionMajorAxis; }
        public int confidence() { return confidence; }
        public byte[] spare() { return spare; }
        public Ericsson3112EventsFile _root() { return _root; }
        public Ericsson3112EventsFile.TEvent3112Type _parent() { return _parent; }
    }
    public static class TE3112MdtM1Polygon extends KaitaiStruct {
        public static TE3112MdtM1Polygon fromFile(String fileName) throws IOException {
            return new TE3112MdtM1Polygon(new ByteBufferKaitaiStream(fileName));
        }

        public TE3112MdtM1Polygon(KaitaiStream _io) {
            this(_io, null, null);
        }

        public TE3112MdtM1Polygon(KaitaiStream _io, Ericsson3112EventsFile.TEvent3112Type _parent) {
            this(_io, _parent, null);
        }

        public TE3112MdtM1Polygon(KaitaiStream _io, Ericsson3112EventsFile.TEvent3112Type _parent, Ericsson3112EventsFile _root) {
            super(_io);
            this._parent = _parent;
            this._root = _root;
            _read();
        }
        private void _read() {
            this.latitudeSign = this._io.readU1();
            this.degreesLatitude = this._io.readBitsIntBe(24);
            this.degreesLongitude = this._io.readBitsIntBe(24);
            this._io.alignToByte();
            this.spare = this._io.readBytes(10);
        }
        private int latitudeSign;
        private long degreesLatitude;
        private long degreesLongitude;
        private byte[] spare;
        private Ericsson3112EventsFile _root;
        private Ericsson3112EventsFile.TEvent3112Type _parent;
        public int latitudeSign() { return latitudeSign; }
        public long degreesLatitude() { return degreesLatitude; }
        public long degreesLongitude() { return degreesLongitude; }
        public byte[] spare() { return spare; }
        public Ericsson3112EventsFile _root() { return _root; }
        public Ericsson3112EventsFile.TEvent3112Type _parent() { return _parent; }
    }
    public static class TEvent3112Type extends KaitaiStruct {
        public static TEvent3112Type fromFile(String fileName) throws IOException {
            return new TEvent3112Type(new ByteBufferKaitaiStream(fileName));
        }

        public TEvent3112Type(KaitaiStream _io) {
            this(_io, null, null);
        }

        public TEvent3112Type(KaitaiStream _io, Ericsson3112EventsFile _parent) {
            this(_io, _parent, null);
        }

        public TEvent3112Type(KaitaiStream _io, Ericsson3112EventsFile _parent, Ericsson3112EventsFile _root) {
            super(_io);
            this._parent = _parent;
            this._root = _root;
            _read();
        }
        private void _read() {
            this.eventHeader = new TEventHeader(this._io, this, _root);
            this.timestampHour = this._io.readU1();
            this.timestampMinute = this._io.readU1();
            this.timestampSecond = this._io.readU1();
            this.timestampMillisecond = this._io.readU2be();
            this.scannerId = this._io.readBitsIntBe(24);
            this._io.alignToByte();
            this.rbsModuleId = this._io.readU1();
            this.globalCellId = this._io.readU4be();
            this.enbs1apid = this._io.readBitsIntBe(24);
            this._io.alignToByte();
            this.mmes1apid = this._io.readU4be();
            this.gummei = this._io.readBitsIntBe(56);
            this._io.alignToByte();
            this.racUeRef = this._io.readU4be();
            this.traceRecordingSessionRef = this._io.readBitsIntBe(24);
            this._io.alignToByte();
            this.affectedMeasType = this._io.readU1();
            this.rsrpServing = this._io.readU1();
            this.rsrqServing = this._io.readU1();
            this.physicalCellId1 = this._io.readU2be();
            this.rsrpResult1 = this._io.readU1();
            this.rsrqResult1 = this._io.readU1();
            this.physicalCellId2 = this._io.readU2be();
            this.rsrpResult2 = this._io.readU1();
            this.rsrqResult2 = this._io.readU1();
            this.physicalCellId3 = this._io.readU2be();
            this.rsrpResult3 = this._io.readU1();
            this.rsrqResult3 = this._io.readU1();
            this.physicalCellId4 = this._io.readU2be();
            this.rsrpResult4 = this._io.readU1();
            this.rsrqResult4 = this._io.readU1();
            this.physicalCellId5 = this._io.readU2be();
            this.rsrpResult5 = this._io.readU1();
            this.rsrqResult5 = this._io.readU1();
            this.physicalCellId6 = this._io.readU2be();
            this.rsrpResult6 = this._io.readU1();
            this.rsrqResult6 = this._io.readU1();
            this.physicalCellId7 = this._io.readU2be();
            this.rsrpResult7 = this._io.readU1();
            this.rsrqResult7 = this._io.readU1();
            this.physicalCellId8 = this._io.readU2be();
            this.rsrpResult8 = this._io.readU1();
            this.rsrqResult8 = this._io.readU1();
            this.mdtM1LocationCoordinates = this._io.readU1();
            this.mdtM1EllipsoidPoint = new TE3112MdtM1EllipsoidPoint(this._io, this, _root);
            this.mdtM1EllipsoidPointWithAlti = new TE3112MdtM1EllipsoidPointWithAlti(this._io, this, _root);
            this.mdtM1EllipsoidPointWithUncerCircle = new TE3112MdtM1EllipsoidPointWithUncerCircle(this._io, this, _root);
            this.mdtM1EllipsoidPointWithUncerEllipse = new TE3112MdtM1EllipsoidPointWithUncerEllipse(this._io, this, _root);
            this.mdtM1EllipsoidPointWithAltiAndUncerEllipsoid = new TE3112MdtM1EllipsoidPointWithAltiAndUncerEllipsoid(this._io, this, _root);
            this.mdtM1EllipsoidArc = new TE3112MdtM1EllipsoidArc(this._io, this, _root);
            this.mdtM1Polygon1 = new TE3112MdtM1Polygon(this._io, this, _root);
            this.mdtM1Polygon2 = new TE3112MdtM1Polygon(this._io, this, _root);
            this.mdtM1Polygon3 = new TE3112MdtM1Polygon(this._io, this, _root);
            this.mdtM1Polygon4 = new TE3112MdtM1Polygon(this._io, this, _root);
            this.mdtM1Polygon5 = new TE3112MdtM1Polygon(this._io, this, _root);
            this.mdtM1Polygon6 = new TE3112MdtM1Polygon(this._io, this, _root);
            this.mdtM1Polygon7 = new TE3112MdtM1Polygon(this._io, this, _root);
            this.mdtM1HorizontalVelocity = new TE3112MdtM1HorizontalVelocity(this._io, this, _root);
            this.paramMdtM1GnssTodMsec = this._io.readU4be();
            this.mdtM1Frequency = this._io.readBitsIntBe(24);
            this.padding2 = this._io.readBitsIntBe(24);
            this._io.alignToByte();
            this.tempRest = this._io.readBytes(((eventHeader().eventLength() - 7) - 274));
        }
        private TEventHeader eventHeader;
        private int timestampHour;
        private int timestampMinute;
        private int timestampSecond;
        private int timestampMillisecond;
        private long scannerId;
        private int rbsModuleId;
        private long globalCellId;
        private long enbs1apid;
        private long mmes1apid;
        private long gummei;
        private long racUeRef;
        private long traceRecordingSessionRef;
        private int affectedMeasType;
        private int rsrpServing;
        private int rsrqServing;
        private int physicalCellId1;
        private int rsrpResult1;
        private int rsrqResult1;
        private int physicalCellId2;
        private int rsrpResult2;
        private int rsrqResult2;
        private int physicalCellId3;
        private int rsrpResult3;
        private int rsrqResult3;
        private int physicalCellId4;
        private int rsrpResult4;
        private int rsrqResult4;
        private int physicalCellId5;
        private int rsrpResult5;
        private int rsrqResult5;
        private int physicalCellId6;
        private int rsrpResult6;
        private int rsrqResult6;
        private int physicalCellId7;
        private int rsrpResult7;
        private int rsrqResult7;
        private int physicalCellId8;
        private int rsrpResult8;
        private int rsrqResult8;
        private int mdtM1LocationCoordinates;
        private TE3112MdtM1EllipsoidPoint mdtM1EllipsoidPoint;
        private TE3112MdtM1EllipsoidPointWithAlti mdtM1EllipsoidPointWithAlti;
        private TE3112MdtM1EllipsoidPointWithUncerCircle mdtM1EllipsoidPointWithUncerCircle;
        private TE3112MdtM1EllipsoidPointWithUncerEllipse mdtM1EllipsoidPointWithUncerEllipse;
        private TE3112MdtM1EllipsoidPointWithAltiAndUncerEllipsoid mdtM1EllipsoidPointWithAltiAndUncerEllipsoid;
        private TE3112MdtM1EllipsoidArc mdtM1EllipsoidArc;
        private TE3112MdtM1Polygon mdtM1Polygon1;
        private TE3112MdtM1Polygon mdtM1Polygon2;
        private TE3112MdtM1Polygon mdtM1Polygon3;
        private TE3112MdtM1Polygon mdtM1Polygon4;
        private TE3112MdtM1Polygon mdtM1Polygon5;
        private TE3112MdtM1Polygon mdtM1Polygon6;
        private TE3112MdtM1Polygon mdtM1Polygon7;
        private TE3112MdtM1HorizontalVelocity mdtM1HorizontalVelocity;
        private long paramMdtM1GnssTodMsec;
        private long mdtM1Frequency;
        private long padding2;
        private byte[] tempRest;
        private Ericsson3112EventsFile _root;
        private Ericsson3112EventsFile _parent;
        public TEventHeader eventHeader() { return eventHeader; }
        public int timestampHour() { return timestampHour; }
        public int timestampMinute() { return timestampMinute; }
        public int timestampSecond() { return timestampSecond; }
        public int timestampMillisecond() { return timestampMillisecond; }
        public long scannerId() { return scannerId; }
        public int rbsModuleId() { return rbsModuleId; }
        public long globalCellId() { return globalCellId; }
        public long enbs1apid() { return enbs1apid; }
        public long mmes1apid() { return mmes1apid; }
        public long gummei() { return gummei; }
        public long racUeRef() { return racUeRef; }
        public long traceRecordingSessionRef() { return traceRecordingSessionRef; }
        public int affectedMeasType() { return affectedMeasType; }
        public int rsrpServing() { return rsrpServing; }
        public int rsrqServing() { return rsrqServing; }
        public int physicalCellId1() { return physicalCellId1; }
        public int rsrpResult1() { return rsrpResult1; }
        public int rsrqResult1() { return rsrqResult1; }
        public int physicalCellId2() { return physicalCellId2; }
        public int rsrpResult2() { return rsrpResult2; }
        public int rsrqResult2() { return rsrqResult2; }
        public int physicalCellId3() { return physicalCellId3; }
        public int rsrpResult3() { return rsrpResult3; }
        public int rsrqResult3() { return rsrqResult3; }
        public int physicalCellId4() { return physicalCellId4; }
        public int rsrpResult4() { return rsrpResult4; }
        public int rsrqResult4() { return rsrqResult4; }
        public int physicalCellId5() { return physicalCellId5; }
        public int rsrpResult5() { return rsrpResult5; }
        public int rsrqResult5() { return rsrqResult5; }
        public int physicalCellId6() { return physicalCellId6; }
        public int rsrpResult6() { return rsrpResult6; }
        public int rsrqResult6() { return rsrqResult6; }
        public int physicalCellId7() { return physicalCellId7; }
        public int rsrpResult7() { return rsrpResult7; }
        public int rsrqResult7() { return rsrqResult7; }
        public int physicalCellId8() { return physicalCellId8; }
        public int rsrpResult8() { return rsrpResult8; }
        public int rsrqResult8() { return rsrqResult8; }
        public int mdtM1LocationCoordinates() { return mdtM1LocationCoordinates; }
        public TE3112MdtM1EllipsoidPoint mdtM1EllipsoidPoint() { return mdtM1EllipsoidPoint; }
        public TE3112MdtM1EllipsoidPointWithAlti mdtM1EllipsoidPointWithAlti() { return mdtM1EllipsoidPointWithAlti; }
        public TE3112MdtM1EllipsoidPointWithUncerCircle mdtM1EllipsoidPointWithUncerCircle() { return mdtM1EllipsoidPointWithUncerCircle; }
        public TE3112MdtM1EllipsoidPointWithUncerEllipse mdtM1EllipsoidPointWithUncerEllipse() { return mdtM1EllipsoidPointWithUncerEllipse; }
        public TE3112MdtM1EllipsoidPointWithAltiAndUncerEllipsoid mdtM1EllipsoidPointWithAltiAndUncerEllipsoid() { return mdtM1EllipsoidPointWithAltiAndUncerEllipsoid; }
        public TE3112MdtM1EllipsoidArc mdtM1EllipsoidArc() { return mdtM1EllipsoidArc; }
        public TE3112MdtM1Polygon mdtM1Polygon1() { return mdtM1Polygon1; }
        public TE3112MdtM1Polygon mdtM1Polygon2() { return mdtM1Polygon2; }
        public TE3112MdtM1Polygon mdtM1Polygon3() { return mdtM1Polygon3; }
        public TE3112MdtM1Polygon mdtM1Polygon4() { return mdtM1Polygon4; }
        public TE3112MdtM1Polygon mdtM1Polygon5() { return mdtM1Polygon5; }
        public TE3112MdtM1Polygon mdtM1Polygon6() { return mdtM1Polygon6; }
        public TE3112MdtM1Polygon mdtM1Polygon7() { return mdtM1Polygon7; }
        public TE3112MdtM1HorizontalVelocity mdtM1HorizontalVelocity() { return mdtM1HorizontalVelocity; }
        public long paramMdtM1GnssTodMsec() { return paramMdtM1GnssTodMsec; }
        public long mdtM1Frequency() { return mdtM1Frequency; }
        public long padding2() { return padding2; }
        public byte[] tempRest() { return tempRest; }
        public Ericsson3112EventsFile _root() { return _root; }
        public Ericsson3112EventsFile _parent() { return _parent; }
    }
    public static class TE3112MdtM1EllipsoidArc extends KaitaiStruct {
        public static TE3112MdtM1EllipsoidArc fromFile(String fileName) throws IOException {
            return new TE3112MdtM1EllipsoidArc(new ByteBufferKaitaiStream(fileName));
        }

        public TE3112MdtM1EllipsoidArc(KaitaiStream _io) {
            this(_io, null, null);
        }

        public TE3112MdtM1EllipsoidArc(KaitaiStream _io, Ericsson3112EventsFile.TEvent3112Type _parent) {
            this(_io, _parent, null);
        }

        public TE3112MdtM1EllipsoidArc(KaitaiStream _io, Ericsson3112EventsFile.TEvent3112Type _parent, Ericsson3112EventsFile _root) {
            super(_io);
            this._parent = _parent;
            this._root = _root;
            _read();
        }
        private void _read() {
            this.latitudeSign = this._io.readU1();
            this.degreesLatitude = this._io.readBitsIntBe(24);
            this.degreesLongitude = this._io.readBitsIntBe(24);
            this._io.alignToByte();
            this.innerRadius = this._io.readU2be();
            this.uncertaintyRadius = this._io.readU1();
            this.offsetAngle = this._io.readU1();
            this.includedAngle = this._io.readU1();
            this.confidence = this._io.readU1();
            this.spare = this._io.readBytes(1);
        }
        private int latitudeSign;
        private long degreesLatitude;
        private long degreesLongitude;
        private int innerRadius;
        private int uncertaintyRadius;
        private int offsetAngle;
        private int includedAngle;
        private int confidence;
        private byte[] spare;
        private Ericsson3112EventsFile _root;
        private Ericsson3112EventsFile.TEvent3112Type _parent;
        public int latitudeSign() { return latitudeSign; }
        public long degreesLatitude() { return degreesLatitude; }
        public long degreesLongitude() { return degreesLongitude; }
        public int innerRadius() { return innerRadius; }
        public int uncertaintyRadius() { return uncertaintyRadius; }
        public int offsetAngle() { return offsetAngle; }
        public int includedAngle() { return includedAngle; }
        public int confidence() { return confidence; }
        public byte[] spare() { return spare; }
        public Ericsson3112EventsFile _root() { return _root; }
        public Ericsson3112EventsFile.TEvent3112Type _parent() { return _parent; }
    }
    public static class TEventHeader extends KaitaiStruct {
        public static TEventHeader fromFile(String fileName) throws IOException {
            return new TEventHeader(new ByteBufferKaitaiStream(fileName));
        }

        public TEventHeader(KaitaiStream _io) {
            this(_io, null, null);
        }

        public TEventHeader(KaitaiStream _io, Ericsson3112EventsFile.TEvent3112Type _parent) {
            this(_io, _parent, null);
        }

        public TEventHeader(KaitaiStream _io, Ericsson3112EventsFile.TEvent3112Type _parent, Ericsson3112EventsFile _root) {
            super(_io);
            this._parent = _parent;
            this._root = _root;
            _read();
        }
        private void _read() {
            this.eventLength = this._io.readU2be();
            this.eventType = this._io.readU2be();
            this.eventId = this._io.readBitsIntBe(24);
        }
        private int eventLength;
        private int eventType;
        private long eventId;
        private Ericsson3112EventsFile _root;
        private Ericsson3112EventsFile.TEvent3112Type _parent;
        public int eventLength() { return eventLength; }
        public int eventType() { return eventType; }
        public long eventId() { return eventId; }
        public Ericsson3112EventsFile _root() { return _root; }
        public Ericsson3112EventsFile.TEvent3112Type _parent() { return _parent; }
    }
    public static class TE3112MdtM1HorizontalVelocity extends KaitaiStruct {
        public static TE3112MdtM1HorizontalVelocity fromFile(String fileName) throws IOException {
            return new TE3112MdtM1HorizontalVelocity(new ByteBufferKaitaiStream(fileName));
        }

        public TE3112MdtM1HorizontalVelocity(KaitaiStream _io) {
            this(_io, null, null);
        }

        public TE3112MdtM1HorizontalVelocity(KaitaiStream _io, Ericsson3112EventsFile.TEvent3112Type _parent) {
            this(_io, _parent, null);
        }

        public TE3112MdtM1HorizontalVelocity(KaitaiStream _io, Ericsson3112EventsFile.TEvent3112Type _parent, Ericsson3112EventsFile _root) {
            super(_io);
            this._parent = _parent;
            this._root = _root;
            _read();
        }
        private void _read() {
            this.bearing = this._io.readU1();
            this.horizontalSpeed = this._io.readBitsIntBe(24);
            this._io.alignToByte();
            this.spare = this._io.readBytes(1);
        }
        private int bearing;
        private long horizontalSpeed;
        private byte[] spare;
        private Ericsson3112EventsFile _root;
        private Ericsson3112EventsFile.TEvent3112Type _parent;
        public int bearing() { return bearing; }
        public long horizontalSpeed() { return horizontalSpeed; }
        public byte[] spare() { return spare; }
        public Ericsson3112EventsFile _root() { return _root; }
        public Ericsson3112EventsFile.TEvent3112Type _parent() { return _parent; }
    }
    public static class TE3112MdtM1EllipsoidPoint extends KaitaiStruct {
        public static TE3112MdtM1EllipsoidPoint fromFile(String fileName) throws IOException {
            return new TE3112MdtM1EllipsoidPoint(new ByteBufferKaitaiStream(fileName));
        }

        public TE3112MdtM1EllipsoidPoint(KaitaiStream _io) {
            this(_io, null, null);
        }

        public TE3112MdtM1EllipsoidPoint(KaitaiStream _io, Ericsson3112EventsFile.TEvent3112Type _parent) {
            this(_io, _parent, null);
        }

        public TE3112MdtM1EllipsoidPoint(KaitaiStream _io, Ericsson3112EventsFile.TEvent3112Type _parent, Ericsson3112EventsFile _root) {
            super(_io);
            this._parent = _parent;
            this._root = _root;
            _read();
        }
        private void _read() {
            this.latitudeSign = this._io.readU1();
            this.degreesLatitude = this._io.readBitsIntBe(24);
            this.degreesLongitude = this._io.readBitsIntBe(24);
            this._io.alignToByte();
            this.spare = this._io.readBytes(1);
        }
        private int latitudeSign;
        private long degreesLatitude;
        private long degreesLongitude;
        private byte[] spare;
        private Ericsson3112EventsFile _root;
        private Ericsson3112EventsFile.TEvent3112Type _parent;
        public int latitudeSign() { return latitudeSign; }
        public long degreesLatitude() { return degreesLatitude; }
        public long degreesLongitude() { return degreesLongitude; }
        public byte[] spare() { return spare; }
        public Ericsson3112EventsFile _root() { return _root; }
        public Ericsson3112EventsFile.TEvent3112Type _parent() { return _parent; }
    }
    public static class TE3112MdtM1EllipsoidPointWithUncerCircle extends KaitaiStruct {
        public static TE3112MdtM1EllipsoidPointWithUncerCircle fromFile(String fileName) throws IOException {
            return new TE3112MdtM1EllipsoidPointWithUncerCircle(new ByteBufferKaitaiStream(fileName));
        }

        public TE3112MdtM1EllipsoidPointWithUncerCircle(KaitaiStream _io) {
            this(_io, null, null);
        }

        public TE3112MdtM1EllipsoidPointWithUncerCircle(KaitaiStream _io, Ericsson3112EventsFile.TEvent3112Type _parent) {
            this(_io, _parent, null);
        }

        public TE3112MdtM1EllipsoidPointWithUncerCircle(KaitaiStream _io, Ericsson3112EventsFile.TEvent3112Type _parent, Ericsson3112EventsFile _root) {
            super(_io);
            this._parent = _parent;
            this._root = _root;
            _read();
        }
        private void _read() {
            this.latitudeSign = this._io.readU1();
            this.degreesLatitude = this._io.readBitsIntBe(24);
            this.degreesLongitude = this._io.readBitsIntBe(24);
            this._io.alignToByte();
            this.uncertainty = this._io.readU2be();
        }
        private int latitudeSign;
        private long degreesLatitude;
        private long degreesLongitude;
        private int uncertainty;
        private Ericsson3112EventsFile _root;
        private Ericsson3112EventsFile.TEvent3112Type _parent;
        public int latitudeSign() { return latitudeSign; }
        public long degreesLatitude() { return degreesLatitude; }
        public long degreesLongitude() { return degreesLongitude; }
        public int uncertainty() { return uncertainty; }
        public Ericsson3112EventsFile _root() { return _root; }
        public Ericsson3112EventsFile.TEvent3112Type _parent() { return _parent; }
    }
    public static class TE3112MdtM1EllipsoidPointWithAltiAndUncerEllipsoid extends KaitaiStruct {
        public static TE3112MdtM1EllipsoidPointWithAltiAndUncerEllipsoid fromFile(String fileName) throws IOException {
            return new TE3112MdtM1EllipsoidPointWithAltiAndUncerEllipsoid(new ByteBufferKaitaiStream(fileName));
        }

        public TE3112MdtM1EllipsoidPointWithAltiAndUncerEllipsoid(KaitaiStream _io) {
            this(_io, null, null);
        }

        public TE3112MdtM1EllipsoidPointWithAltiAndUncerEllipsoid(KaitaiStream _io, Ericsson3112EventsFile.TEvent3112Type _parent) {
            this(_io, _parent, null);
        }

        public TE3112MdtM1EllipsoidPointWithAltiAndUncerEllipsoid(KaitaiStream _io, Ericsson3112EventsFile.TEvent3112Type _parent, Ericsson3112EventsFile _root) {
            super(_io);
            this._parent = _parent;
            this._root = _root;
            _read();
        }
        private void _read() {
            this.latitudeSign = this._io.readU1();
            this.degreesLatitude = this._io.readBitsIntBe(24);
            this.degreesLongitude = this._io.readBitsIntBe(24);
            this._io.alignToByte();
            this.altitudeDirection = this._io.readU1();
            this.altitude = this._io.readU2be();
            this.uncertaintySemiMajor = this._io.readU1();
            this.uncertaintySemiMinor = this._io.readU1();
            this.orientaionMajorAxis = this._io.readU1();
            this.uncertaintyAltitude = this._io.readU1();
            this.confidence = this._io.readU1();
            this.spare = this._io.readBytes(1);
        }
        private int latitudeSign;
        private long degreesLatitude;
        private long degreesLongitude;
        private int altitudeDirection;
        private int altitude;
        private int uncertaintySemiMajor;
        private int uncertaintySemiMinor;
        private int orientaionMajorAxis;
        private int uncertaintyAltitude;
        private int confidence;
        private byte[] spare;
        private Ericsson3112EventsFile _root;
        private Ericsson3112EventsFile.TEvent3112Type _parent;
        public int latitudeSign() { return latitudeSign; }
        public long degreesLatitude() { return degreesLatitude; }
        public long degreesLongitude() { return degreesLongitude; }
        public int altitudeDirection() { return altitudeDirection; }
        public int altitude() { return altitude; }
        public int uncertaintySemiMajor() { return uncertaintySemiMajor; }
        public int uncertaintySemiMinor() { return uncertaintySemiMinor; }
        public int orientaionMajorAxis() { return orientaionMajorAxis; }
        public int uncertaintyAltitude() { return uncertaintyAltitude; }
        public int confidence() { return confidence; }
        public byte[] spare() { return spare; }
        public Ericsson3112EventsFile _root() { return _root; }
        public Ericsson3112EventsFile.TEvent3112Type _parent() { return _parent; }
    }
    private ArrayList<TEvent3112Type> eventRecords;
    private Ericsson3112EventsFile _root;
    private KaitaiStruct _parent;
    public ArrayList<TEvent3112Type> eventRecords() { return eventRecords; }
    public Ericsson3112EventsFile _root() { return _root; }
    public KaitaiStruct _parent() { return _parent; }
}
