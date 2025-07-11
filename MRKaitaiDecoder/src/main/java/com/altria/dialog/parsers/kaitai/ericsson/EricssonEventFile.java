// This is a generated file! Please edit source .ksy file and use kaitai-struct-compiler to rebuild

package com.altria.dialog.parsers.kaitai.ericsson;

import io.kaitai.struct.ByteBufferKaitaiStream;
import io.kaitai.struct.KaitaiStruct;
import io.kaitai.struct.KaitaiStream;

import java.io.IOException;
import java.nio.charset.Charset;
import java.util.ArrayList;

public class EricssonEventFile extends KaitaiStruct {
    public static EricssonEventFile fromFile(String fileName) throws IOException {
        return new EricssonEventFile(new ByteBufferKaitaiStream(fileName));
    }

    public EricssonEventFile(KaitaiStream _io) {
        this(_io, null, null);
    }

    public EricssonEventFile(KaitaiStream _io, KaitaiStruct _parent) {
        this(_io, _parent, null);
    }

    public EricssonEventFile(KaitaiStream _io, KaitaiStruct _parent, EricssonEventFile _root) {
        super(_io);
        this._parent = _parent;
        this._root = _root == null ? this : _root;
        _read();
    }

    private void _read() {
        this.eventRecords = new ArrayList<TEventRecord>();
        {
            int i = 0;
            while (!this._io.isEof()) {
                this.eventRecords.add(new TEventRecord(this._io, this, _root));
                i++;
            }
        }
    }

    public static class TEventRecord extends KaitaiStruct {
        public static TEventRecord fromFile(String fileName) throws IOException {
            return new TEventRecord(new ByteBufferKaitaiStream(fileName));
        }

        public TEventRecord(KaitaiStream _io) {
            this(_io, null, null);
        }

        public TEventRecord(KaitaiStream _io, EricssonEventFile _parent) {
            this(_io, _parent, null);
        }

        public TEventRecord(KaitaiStream _io, EricssonEventFile _parent, EricssonEventFile _root) {
            super(_io);
            this._parent = _parent;
            this._root = _root;
            _read();
        }

        private void _read() {
            this.eventHeader = new TEventHeader(this._io, this, _root);
            if (((eventHeader().eventType() == 4) && (eventHeader().eventId() == 3108))) {
                this.event3108Body = new TEvent3108Body(this._io, this, _root, (eventHeader().eventLength() - 7));
            }
            if (((eventHeader().eventType() == 4) && (eventHeader().eventId() == 3112))) {
                this.event3112Body = new TEvent3112Body(this._io, this, _root, (eventHeader().eventLength() - 7));
            }
            if (((eventHeader().eventType() == 4) && (eventHeader().eventId() == 3115))) {
                this.event3115Body = new TEvent3115Body(this._io, this, _root, (eventHeader().eventLength() - 7));
            }
            if (((eventHeader().eventType() == 4) && (eventHeader().eventId() == 3116))) {
                this.event3116Body = new TEvent3116Body(this._io, this, _root, (eventHeader().eventLength() - 7));
            }
            if (((eventHeader().eventType() == 4) && (eventHeader().eventId() == 3114))) {
                this.event3114Body = new TEvent3114Body(this._io, this, _root, (eventHeader().eventLength() - 7));
            }
            if (((eventHeader().eventType() == 4) && (eventHeader().eventId() == 3076))) {
                this.event3076Body = new TEvent3076Body(this._io, this, _root, (eventHeader().eventLength() - 7));
            }
            if (((eventHeader().eventType() == 4) && (eventHeader().eventId() == 3075))) {
                this.event3075Body = new TEvent3075Body(this._io, this, _root, (eventHeader().eventLength() - 7));
            }
            if (((eventHeader().eventType() == 4) && (eventHeader().eventId() == 3113))) {
                this.event3113Body = new TEvent3113Body(this._io, this, _root, (eventHeader().eventLength() - 7));
            }
            if (((eventHeader().eventType() == 4) && (eventHeader().eventId() == 3130))) {
                this.event3130Body = new TEvent3130Body(this._io, this, _root, (eventHeader().eventLength() - 7));
            }
            if (((eventHeader().eventType() == 4) && (eventHeader().eventId() == 3131))) {
                this.event3131Body = new TEvent3131Body(this._io, this, _root, (eventHeader().eventLength() - 7));
            }
            if (((eventHeader().eventType() == 4) && (eventHeader().eventId() == 3129))) {
                this.event3129Body = new TEvent3129Body(this._io, this, _root, (eventHeader().eventLength() - 7));
            }
            if (((eventHeader().eventType() == 4) && (eventHeader().eventId() == 4099))) {
                this.event4099Body = new TEvent4099Body(this._io, this, _root, (eventHeader().eventLength() - 7));
            }
            if (((eventHeader().eventType() == 4) && (eventHeader().eventId() == 4112))) {
                this.event4112Body = new TEvent4112Body(this._io, this, _root, (eventHeader().eventLength() - 7));
            }
            if (((eventHeader().eventType() == 4) && (eventHeader().eventId() == 4110))) {
                this.event4110Body = new TEvent4110Body(this._io, this, _root, (eventHeader().eventLength() - 7));
            }
            if (((eventHeader().eventType() == 4) && (eventHeader().eventId() == 4106))) {
                this.event4106Body = new TEvent4106Body(this._io, this, _root, (eventHeader().eventLength() - 7));
            }
            if (((eventHeader().eventType() == 4) && (eventHeader().eventId() == 4097))) {
                this.event4097Body = new TEvent4097Body(this._io, this, _root, (eventHeader().eventLength() - 7));
            }
            if (((eventHeader().eventType() == 4) && (eventHeader().eventId() == 4121))) {
                this.event4121Body = new TEvent4121Body(this._io, this, _root, (eventHeader().eventLength() - 7));
            }
            if (((eventHeader().eventType() == 4) && (eventHeader().eventId() == 4125))) {
                this.event4125Body = new TEvent4125Body(this._io, this, _root, (eventHeader().eventLength() - 7));
            }
            if (((eventHeader().eventType() == 4) && (eventHeader().eventId() == 26))) {
                this.event26Body = new TEvent26Body(this._io, this, _root, (eventHeader().eventLength() - 7));
            }
            if (((eventHeader().eventType() == 4) && (eventHeader().eventId() == 5269))) {
                this.event5269Body = new TEvent5269Body(this._io, this, _root, (eventHeader().eventLength() - 7));
            }
            if (((eventHeader().eventType() == 4) && (eventHeader().eventId() == 5267))) {
                this.event5267Body = new TEvent5267Body(this._io, this, _root, (eventHeader().eventLength() - 7));
            }
            if (((eventHeader().eventType() == 4) && (eventHeader().eventId() == 5153))) {
                this.event5153Body = new TEvent5153Body(this._io, this, _root, (eventHeader().eventLength() - 7));
            }
            if (((eventHeader().eventType() == 4) && (eventHeader().eventId() == 4104))) {
                this.event4104Body = new TEvent4104Body(this._io, this, _root, (eventHeader().eventLength() - 7));
            }if (((eventHeader().eventType() == 4) && (eventHeader().eventId() == 5))) {
                this.event5Body = new TEvent5Body(this._io, this, _root, (eventHeader().eventLength() - 7));
            }if (((eventHeader().eventType() == 4) && (eventHeader().eventId() == 8))) {
                this.event8Body = new TEvent8Body(this._io, this, _root, (eventHeader().eventLength() - 7));
            }if (((eventHeader().eventType() == 4) && (eventHeader().eventId() == 4114))) {
                this.event4114Body = new TEvent4114Body(this._io, this, _root, (eventHeader().eventLength() - 7));
            }
            if ((eventHeader().eventId() != 3108) && (eventHeader().eventId() != 3112) &&
                    (eventHeader().eventId() != 3115) && (eventHeader().eventId() != 3116) &&
                    (eventHeader().eventId() != 3114) && (eventHeader().eventId() != 3076) &&
                    (eventHeader().eventId() != 3075) && (eventHeader().eventId() != 3113) &&
                    (eventHeader().eventId() != 3130) && (eventHeader().eventId() != 3131) &&
                    (eventHeader().eventId() != 3129) && (eventHeader().eventId() != 4099) &&
                    (eventHeader().eventId() != 4112) && (eventHeader().eventId() != 4110) &&
                    (eventHeader().eventId() != 4106) && (eventHeader().eventId() != 4097) &&
                    (eventHeader().eventId() != 4121) && (eventHeader().eventId() != 4125) &&
                    (eventHeader().eventId() != 26) && (eventHeader().eventId() != 5269) &&
                    (eventHeader().eventId() != 5267) && (eventHeader().eventId() != 5153) &&
                    (eventHeader().eventId() != 4104) && (eventHeader().eventId() != 5) &&
                    (eventHeader().eventId() != 8)&& (eventHeader().eventId() != 4114)
            ) {
                this.eventUnsupported = new TEventUnsupportedBody(this._io, this, _root, (eventHeader().eventLength() - 7));
            }
        }

        private TEventHeader eventHeader;
        private TEvent3108Body event3108Body;
        private TEvent3112Body event3112Body;
        private TEvent3115Body event3115Body;
        private TEvent3116Body event3116Body;
        private TEvent3114Body event3114Body;
        private TEvent3076Body event3076Body;
        private TEvent3075Body event3075Body;
        private TEvent3113Body event3113Body;
        private TEvent3130Body event3130Body;
        private TEvent3131Body event3131Body;
        private TEvent3129Body event3129Body;
        private TEvent4099Body event4099Body;
        private TEvent4112Body event4112Body;
        private TEvent4110Body event4110Body;
        private TEvent4106Body event4106Body;
        private TEvent4097Body event4097Body;
        private TEvent4121Body event4121Body;
        private TEvent4125Body event4125Body;
        private TEvent26Body event26Body;
        private TEvent5269Body event5269Body;
        private TEvent5267Body event5267Body;
        private TEvent5153Body event5153Body;
        private TEvent4104Body event4104Body;
        private TEvent5Body event5Body;
        private TEvent8Body event8Body;
        private TEvent4114Body event4114Body;
        private TEventUnsupportedBody eventUnsupported;
        private EricssonEventFile _root;
        private EricssonEventFile _parent;

        public TEventHeader eventHeader() {
            return eventHeader;
        }
        public TEvent3108Body event3108Body() {
            return event3108Body;
        }
        public TEvent3112Body event3112Body() {
            return event3112Body;
        }
        public TEvent3115Body event3115Body() {
            return event3115Body;
        }
        public TEvent3116Body event3116Body() {
            return event3116Body;
        }
        public TEvent3114Body event3114Body() {
            return event3114Body;
        }
        public TEvent3076Body event3076Body() {
            return event3076Body;
        }
        public TEvent3075Body event3075Body() {
            return event3075Body;
        }
        public TEvent3113Body event3113Body() {
            return event3113Body;
        }
        public TEvent3130Body event3130Body() {
            return event3130Body;
        }
        public TEvent3131Body event3131Body() {
            return event3131Body;
        }
        public TEvent3129Body event3129Body() {
            return event3129Body;
        }
        public TEvent4099Body event4099Body() {
            return event4099Body;
        }
        public TEvent4112Body event4112Body() {
            return event4112Body;
        }
        public TEvent4110Body event4110Body() {
            return event4110Body;
        }
        public TEvent4106Body event4106Body() {
            return event4106Body;
        }
        public TEvent4097Body event4097Body() {
            return event4097Body;
        }
        public TEvent4121Body event4121Body() {
            return event4121Body;
        }
        public TEvent4125Body event4125Body() {
            return event4125Body;
        }
        public TEvent26Body event26Body() {
            return event26Body;
        }
        public TEvent5269Body event5269Body() {
            return event5269Body;
        }
        public TEvent5267Body event5267Body() {
            return event5267Body;
        }
        public TEvent4104Body event4104Body() {
            return event4104Body;
        }
        public TEvent5153Body event5153Body() {
            return event5153Body;
        }
        public TEvent5Body event5Body() {
            return event5Body;
        }
        public TEvent8Body event8Body() {
            return event8Body;
        }
        public TEvent4114Body event4114Body() {
            return event4114Body;
        }
        public TEventUnsupportedBody eventUnsupported() {
            return eventUnsupported;
        }
        public EricssonEventFile _root() {
            return _root;
        }
        public EricssonEventFile _parent() {
            return _parent;
        }
    }

    public static class TE3112MdtM1EllipsoidPointWithAlti extends KaitaiStruct {
        public static TE3112MdtM1EllipsoidPointWithAlti fromFile(String fileName) throws IOException {
            return new TE3112MdtM1EllipsoidPointWithAlti(new ByteBufferKaitaiStream(fileName));
        }

        public TE3112MdtM1EllipsoidPointWithAlti(KaitaiStream _io) {
            this(_io, null, null);
        }

        public TE3112MdtM1EllipsoidPointWithAlti(KaitaiStream _io, EricssonEventFile.TEvent3112Body _parent) {
            this(_io, _parent, null);
        }

        public TE3112MdtM1EllipsoidPointWithAlti(KaitaiStream _io, EricssonEventFile.TEvent3112Body _parent, EricssonEventFile _root) {
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
        private EricssonEventFile _root;
        private EricssonEventFile.TEvent3112Body _parent;

        public int latitudeSign() {
            return latitudeSign;
        }

        public long degreesLatitude() {
            return degreesLatitude;
        }

        public long degreesLongitude() {
            return degreesLongitude;
        }

        public int altitudeDirection() {
            return altitudeDirection;
        }

        public int altitude() {
            return altitude;
        }

        public byte[] spare() {
            return spare;
        }

        public EricssonEventFile _root() {
            return _root;
        }

        public EricssonEventFile.TEvent3112Body _parent() {
            return _parent;
        }
    }

    public static class TE3112MdtM1EllipsoidPointWithUncerEllipse extends KaitaiStruct {
        public static TE3112MdtM1EllipsoidPointWithUncerEllipse fromFile(String fileName) throws IOException {
            return new TE3112MdtM1EllipsoidPointWithUncerEllipse(new ByteBufferKaitaiStream(fileName));
        }

        public TE3112MdtM1EllipsoidPointWithUncerEllipse(KaitaiStream _io) {
            this(_io, null, null);
        }

        public TE3112MdtM1EllipsoidPointWithUncerEllipse(KaitaiStream _io, EricssonEventFile.TEvent3112Body _parent) {
            this(_io, _parent, null);
        }

        public TE3112MdtM1EllipsoidPointWithUncerEllipse(KaitaiStream _io, EricssonEventFile.TEvent3112Body _parent, EricssonEventFile _root) {
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
        private EricssonEventFile _root;
        private EricssonEventFile.TEvent3112Body _parent;

        public int latitudeSign() {
            return latitudeSign;
        }

        public long degreesLatitude() {
            return degreesLatitude;
        }

        public long degreesLongitude() {
            return degreesLongitude;
        }

        public int uncertaintySemiMajor() {
            return uncertaintySemiMajor;
        }

        public int uncertaintySemiMinor() {
            return uncertaintySemiMinor;
        }

        public int orientaionMajorAxis() {
            return orientaionMajorAxis;
        }

        public int confidence() {
            return confidence;
        }

        public byte[] spare() {
            return spare;
        }

        public EricssonEventFile _root() {
            return _root;
        }

        public EricssonEventFile.TEvent3112Body _parent() {
            return _parent;
        }
    }

    public static class TE3112MdtM1Polygon extends KaitaiStruct {
        public static TE3112MdtM1Polygon fromFile(String fileName) throws IOException {
            return new TE3112MdtM1Polygon(new ByteBufferKaitaiStream(fileName));
        }

        public TE3112MdtM1Polygon(KaitaiStream _io) {
            this(_io, null, null);
        }

        public TE3112MdtM1Polygon(KaitaiStream _io, EricssonEventFile.TEvent3112Body _parent) {
            this(_io, _parent, null);
        }

        public TE3112MdtM1Polygon(KaitaiStream _io, EricssonEventFile.TEvent3112Body _parent, EricssonEventFile _root) {
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
        private EricssonEventFile _root;
        private EricssonEventFile.TEvent3112Body _parent;

        public int latitudeSign() {
            return latitudeSign;
        }

        public long degreesLatitude() {
            return degreesLatitude;
        }

        public long degreesLongitude() {
            return degreesLongitude;
        }

        public byte[] spare() {
            return spare;
        }

        public EricssonEventFile _root() {
            return _root;
        }

        public EricssonEventFile.TEvent3112Body _parent() {
            return _parent;
        }
    }

    public static class TE3112MdtM1EllipsoidArc extends KaitaiStruct {
        public static TE3112MdtM1EllipsoidArc fromFile(String fileName) throws IOException {
            return new TE3112MdtM1EllipsoidArc(new ByteBufferKaitaiStream(fileName));
        }

        public TE3112MdtM1EllipsoidArc(KaitaiStream _io) {
            this(_io, null, null);
        }

        public TE3112MdtM1EllipsoidArc(KaitaiStream _io, EricssonEventFile.TEvent3112Body _parent) {
            this(_io, _parent, null);
        }

        public TE3112MdtM1EllipsoidArc(KaitaiStream _io, EricssonEventFile.TEvent3112Body _parent, EricssonEventFile _root) {
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
        private EricssonEventFile _root;
        private EricssonEventFile.TEvent3112Body _parent;

        public int latitudeSign() {
            return latitudeSign;
        }

        public long degreesLatitude() {
            return degreesLatitude;
        }

        public long degreesLongitude() {
            return degreesLongitude;
        }

        public int innerRadius() {
            return innerRadius;
        }

        public int uncertaintyRadius() {
            return uncertaintyRadius;
        }

        public int offsetAngle() {
            return offsetAngle;
        }

        public int includedAngle() {
            return includedAngle;
        }

        public int confidence() {
            return confidence;
        }

        public byte[] spare() {
            return spare;
        }

        public EricssonEventFile _root() {
            return _root;
        }

        public EricssonEventFile.TEvent3112Body _parent() {
            return _parent;
        }
    }

    public static class TEventHeader extends KaitaiStruct {
        public static TEventHeader fromFile(String fileName) throws IOException {
            return new TEventHeader(new ByteBufferKaitaiStream(fileName));
        }

        public TEventHeader(KaitaiStream _io) {
            this(_io, null, null);
        }

        public TEventHeader(KaitaiStream _io, EricssonEventFile.TEventRecord _parent) {
            this(_io, _parent, null);
        }

        public TEventHeader(KaitaiStream _io, EricssonEventFile.TEventRecord _parent, EricssonEventFile _root) {
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
        private EricssonEventFile _root;
        private EricssonEventFile.TEventRecord _parent;

        public int eventLength() {
            return eventLength;
        }

        public int eventType() {
            return eventType;
        }

        public long eventId() {
            return eventId;
        }

        public EricssonEventFile _root() {
            return _root;
        }

        public EricssonEventFile.TEventRecord _parent() {
            return _parent;
        }
    }

    public static class TE3112MdtM1HorizontalVelocity extends KaitaiStruct {
        public static TE3112MdtM1HorizontalVelocity fromFile(String fileName) throws IOException {
            return new TE3112MdtM1HorizontalVelocity(new ByteBufferKaitaiStream(fileName));
        }

        public TE3112MdtM1HorizontalVelocity(KaitaiStream _io) {
            this(_io, null, null);
        }

        public TE3112MdtM1HorizontalVelocity(KaitaiStream _io, EricssonEventFile.TEvent3112Body _parent) {
            this(_io, _parent, null);
        }

        public TE3112MdtM1HorizontalVelocity(KaitaiStream _io, EricssonEventFile.TEvent3112Body _parent, EricssonEventFile _root) {
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
        private EricssonEventFile _root;
        private EricssonEventFile.TEvent3112Body _parent;

        public int bearing() {
            return bearing;
        }

        public long horizontalSpeed() {
            return horizontalSpeed;
        }

        public byte[] spare() {
            return spare;
        }

        public EricssonEventFile _root() {
            return _root;
        }

        public EricssonEventFile.TEvent3112Body _parent() {
            return _parent;
        }
    }

    public static class TE3112MdtM1EllipsoidPoint extends KaitaiStruct {
        public static TE3112MdtM1EllipsoidPoint fromFile(String fileName) throws IOException {
            return new TE3112MdtM1EllipsoidPoint(new ByteBufferKaitaiStream(fileName));
        }

        public TE3112MdtM1EllipsoidPoint(KaitaiStream _io) {
            this(_io, null, null);
        }

        public TE3112MdtM1EllipsoidPoint(KaitaiStream _io, EricssonEventFile.TEvent3112Body _parent) {
            this(_io, _parent, null);
        }

        public TE3112MdtM1EllipsoidPoint(KaitaiStream _io, EricssonEventFile.TEvent3112Body _parent, EricssonEventFile _root) {
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
        private EricssonEventFile _root;
        private EricssonEventFile.TEvent3112Body _parent;

        public int latitudeSign() {
            return latitudeSign;
        }

        public long degreesLatitude() {
            return degreesLatitude;
        }

        public long degreesLongitude() {
            return degreesLongitude;
        }

        public byte[] spare() {
            return spare;
        }

        public EricssonEventFile _root() {
            return _root;
        }

        public EricssonEventFile.TEvent3112Body _parent() {
            return _parent;
        }
    }

    public static class TEventUnsupportedBody extends KaitaiStruct {

        public TEventUnsupportedBody(KaitaiStream _io, int bodyLength) {
            this(_io, null, null, bodyLength);
        }

        public TEventUnsupportedBody(KaitaiStream _io, EricssonEventFile.TEventRecord _parent, int bodyLength) {
            this(_io, _parent, null, bodyLength);
        }

        public TEventUnsupportedBody(KaitaiStream _io, EricssonEventFile.TEventRecord _parent, EricssonEventFile _root, int bodyLength) {
            super(_io);
            this._parent = _parent;
            this._root = _root;
            this.bodyLength = bodyLength;
            _read();
        }

        private void _read() {
            this.data = this._io.readBytes(bodyLength());
        }

        private byte[] data;
        private int bodyLength;
        private EricssonEventFile _root;
        private EricssonEventFile.TEventRecord _parent;

        public byte[] data() {
            return data;
        }

        public int bodyLength() {
            return bodyLength;
        }

        public EricssonEventFile _root() {
            return _root;
        }

        public EricssonEventFile.TEventRecord _parent() {
            return _parent;
        }
    }

    public static class TEvent3108Body extends KaitaiStruct {

        public TEvent3108Body(KaitaiStream _io, int bodyLength) {
            this(_io, null, null, bodyLength);
        }

        public TEvent3108Body(KaitaiStream _io, EricssonEventFile.TEventRecord _parent, int bodyLength) {
            this(_io, _parent, null, bodyLength);
        }

        public TEvent3108Body(KaitaiStream _io, EricssonEventFile.TEventRecord _parent, EricssonEventFile _root, int bodyLength) {
            super(_io);
            this._parent = _parent;
            this._root = _root;
            this.bodyLength = bodyLength;
            _read();
        }

        private void _read() {
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
            this.startTimestampHour = this._io.readU1();
            this.startTimestampMinute = this._io.readU1();
            this.startTimestampSecond = this._io.readU1();
            this.startTimestampMillisecond = this._io.readU2be();
            this.taInterval = this._io.readU2be();
            ta = new ArrayList<Integer>(((Number) (60)).intValue());
            for (int i = 0; i < 60; i++) {
                this.ta.add(this._io.readU2be());
            }
            spare = new ArrayList<Integer>(((Number) (7)).intValue());
            for (int i = 0; i < 7; i++) {
                this.spare.add(this._io.readU1());
            }
            this.undefinedData = this._io.readBytes((bodyLength() - 168));
        }

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
        private int startTimestampHour;
        private int startTimestampMinute;
        private int startTimestampSecond;
        private int startTimestampMillisecond;
        private int taInterval;
        private ArrayList<Integer> ta;
        private ArrayList<Integer> spare;
        private byte[] undefinedData;
        private int bodyLength;
        private EricssonEventFile _root;
        private EricssonEventFile.TEventRecord _parent;

        public int timestampHour() {
            return timestampHour;
        }

        public int timestampMinute() {
            return timestampMinute;
        }

        public int timestampSecond() {
            return timestampSecond;
        }

        public int timestampMillisecond() {
            return timestampMillisecond;
        }

        public long scannerId() {
            return scannerId;
        }

        public int rbsModuleId() {
            return rbsModuleId;
        }

        public long globalCellId() {
            return globalCellId;
        }

        public long enbs1apid() {
            return enbs1apid;
        }

        public long mmes1apid() {
            return mmes1apid;
        }

        public long gummei() {
            return gummei;
        }

        public long racUeRef() {
            return racUeRef;
        }

        public long traceRecordingSessionRef() {
            return traceRecordingSessionRef;
        }

        public int startTimestampHour() {
            return startTimestampHour;
        }

        public int startTimestampMinute() {
            return startTimestampMinute;
        }

        public int startTimestampSecond() {
            return startTimestampSecond;
        }

        public int startTimestampMillisecond() {
            return startTimestampMillisecond;
        }

        public int taInterval() {
            return taInterval;
        }

        public ArrayList<Integer> ta() {
            return ta;
        }

        public ArrayList<Integer> spare() {
            return spare;
        }

        /**
         * Usually 3108 event is 180 byes long (including header) but the given data structure is only 168, rest goes here
         */
        public byte[] undefinedData() {
            return undefinedData;
        }

        public int bodyLength() {
            return bodyLength;
        }

        public EricssonEventFile _root() {
            return _root;
        }

        public EricssonEventFile.TEventRecord _parent() {
            return _parent;
        }
    }

    public static class TEvent3112Body extends KaitaiStruct {

        public TEvent3112Body(KaitaiStream _io, int bodyLength) {
            this(_io, null, null, bodyLength);
        }

        public TEvent3112Body(KaitaiStream _io, EricssonEventFile.TEventRecord _parent, int bodyLength) {
            this(_io, _parent, null, bodyLength);
        }

        public TEvent3112Body(KaitaiStream _io, EricssonEventFile.TEventRecord _parent, EricssonEventFile _root, int bodyLength) {
            super(_io);
            this._parent = _parent;
            this._root = _root;
            this.bodyLength = bodyLength;
            _read();
        }

        private void _read() {
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
            this.mdtM1EllipsoidPoint = new TEllipsoidPoint(this._io, this, _root);
            this.mdtM1EllipsoidPointWithAlti = new TEllipsoidPointWithAlti(this._io, this, _root);
            this.mdtM1EllipsoidPointWithUncerCircle = new TEllipsoidPointWithUncerCircle(this._io, this, _root);
            this.mdtM1EllipsoidPointWithUncerEllipse = new TEllipsoidPointWithUncerEllipse(this._io, this, _root);
            this.mdtM1EllipsoidPointWithAltiAndUncerEllipsoid = new TEllipsoidPointWithAltiAndUncerEllipsoid(this._io, this, _root);
            this.mdtM1EllipsoidArc = new TEllipsoidArc(this._io, this, _root);
            this.mdtM1Polygon1 = new TPolygon(this._io, this, _root);
            this.mdtM1Polygon2 = new TPolygon(this._io, this, _root);
            this.mdtM1Polygon3 = new TPolygon(this._io, this, _root);
            this.mdtM1Polygon4 = new TPolygon(this._io, this, _root);
            this.mdtM1Polygon5 = new TPolygon(this._io, this, _root);
            this.mdtM1Polygon6 = new TPolygon(this._io, this, _root);
            this.mdtM1Polygon7 = new TPolygon(this._io, this, _root);
            this.mdtM1HorizontalVelocity = new THorizontalVelocity(this._io, this, _root);
            this.paramMdtM1GnssTodMsec = this._io.readU4be();
            this.mdtM1Frequency = this._io.readBitsIntBe(24);
            this.padding2 = this._io.readBitsIntBe(24);
            this._io.alignToByte();
            this.undefinedData = this._io.readBytes((bodyLength() - 274));
        }

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
        private TEllipsoidPoint mdtM1EllipsoidPoint;
        private TEllipsoidPointWithAlti mdtM1EllipsoidPointWithAlti;
        private TEllipsoidPointWithUncerCircle mdtM1EllipsoidPointWithUncerCircle;
        private TEllipsoidPointWithUncerEllipse mdtM1EllipsoidPointWithUncerEllipse;
        private TEllipsoidPointWithAltiAndUncerEllipsoid mdtM1EllipsoidPointWithAltiAndUncerEllipsoid;
        private TEllipsoidArc mdtM1EllipsoidArc;
        private TPolygon mdtM1Polygon1;
        private TPolygon mdtM1Polygon2;
        private TPolygon mdtM1Polygon3;
        private TPolygon mdtM1Polygon4;
        private TPolygon mdtM1Polygon5;
        private TPolygon mdtM1Polygon6;
        private TPolygon mdtM1Polygon7;
        private THorizontalVelocity mdtM1HorizontalVelocity;
        private long paramMdtM1GnssTodMsec;
        private long mdtM1Frequency;
        private long padding2;
        private byte[] undefinedData;
        private int bodyLength;
        private EricssonEventFile _root;
        private EricssonEventFile.TEventRecord _parent;

        public int timestampHour() {
            return timestampHour;
        }

        public int timestampMinute() {
            return timestampMinute;
        }

        public int timestampSecond() {
            return timestampSecond;
        }

        public int timestampMillisecond() {
            return timestampMillisecond;
        }

        public long scannerId() {
            return scannerId;
        }

        public int rbsModuleId() {
            return rbsModuleId;
        }

        public long globalCellId() {
            return globalCellId;
        }

        public long enbs1apid() {
            return enbs1apid;
        }

        public long mmes1apid() {
            return mmes1apid;
        }

        public long gummei() {
            return gummei;
        }

        public long racUeRef() {
            return racUeRef;
        }

        public long traceRecordingSessionRef() {
            return traceRecordingSessionRef;
        }

        public int affectedMeasType() {
            return affectedMeasType;
        }

        public int rsrpServing() {
            return rsrpServing;
        }

        public int rsrqServing() {
            return rsrqServing;
        }

        public int physicalCellId1() {
            return physicalCellId1;
        }

        public int rsrpResult1() {
            return rsrpResult1;
        }

        public int rsrqResult1() {
            return rsrqResult1;
        }

        public int physicalCellId2() {
            return physicalCellId2;
        }

        public int rsrpResult2() {
            return rsrpResult2;
        }

        public int rsrqResult2() {
            return rsrqResult2;
        }

        public int physicalCellId3() {
            return physicalCellId3;
        }

        public int rsrpResult3() {
            return rsrpResult3;
        }

        public int rsrqResult3() {
            return rsrqResult3;
        }

        public int physicalCellId4() {
            return physicalCellId4;
        }

        public int rsrpResult4() {
            return rsrpResult4;
        }

        public int rsrqResult4() {
            return rsrqResult4;
        }

        public int physicalCellId5() {
            return physicalCellId5;
        }

        public int rsrpResult5() {
            return rsrpResult5;
        }

        public int rsrqResult5() {
            return rsrqResult5;
        }

        public int physicalCellId6() {
            return physicalCellId6;
        }

        public int rsrpResult6() {
            return rsrpResult6;
        }

        public int rsrqResult6() {
            return rsrqResult6;
        }

        public int physicalCellId7() {
            return physicalCellId7;
        }

        public int rsrpResult7() {
            return rsrpResult7;
        }

        public int rsrqResult7() {
            return rsrqResult7;
        }

        public int physicalCellId8() {
            return physicalCellId8;
        }

        public int rsrpResult8() {
            return rsrpResult8;
        }

        public int rsrqResult8() {
            return rsrqResult8;
        }

        public int mdtM1LocationCoordinates() {
            return mdtM1LocationCoordinates;
        }

        public TEllipsoidPoint mdtM1EllipsoidPoint() {
            return mdtM1EllipsoidPoint;
        }

        public TEllipsoidPointWithAlti mdtM1EllipsoidPointWithAlti() {
            return mdtM1EllipsoidPointWithAlti;
        }

        public TEllipsoidPointWithUncerCircle mdtM1EllipsoidPointWithUncerCircle() {
            return mdtM1EllipsoidPointWithUncerCircle;
        }

        public TEllipsoidPointWithUncerEllipse mdtM1EllipsoidPointWithUncerEllipse() {
            return mdtM1EllipsoidPointWithUncerEllipse;
        }

        public TEllipsoidPointWithAltiAndUncerEllipsoid mdtM1EllipsoidPointWithAltiAndUncerEllipsoid() {
            return mdtM1EllipsoidPointWithAltiAndUncerEllipsoid;
        }

        public TEllipsoidArc mdtM1EllipsoidArc() {
            return mdtM1EllipsoidArc;
        }

        public TPolygon mdtM1Polygon1() {
            return mdtM1Polygon1;
        }

        public TPolygon mdtM1Polygon2() {
            return mdtM1Polygon2;
        }

        public TPolygon mdtM1Polygon3() {
            return mdtM1Polygon3;
        }

        public TPolygon mdtM1Polygon4() {
            return mdtM1Polygon4;
        }

        public TPolygon mdtM1Polygon5() {
            return mdtM1Polygon5;
        }

        public TPolygon mdtM1Polygon6() {
            return mdtM1Polygon6;
        }

        public TPolygon mdtM1Polygon7() {
            return mdtM1Polygon7;
        }

        public THorizontalVelocity mdtM1HorizontalVelocity() {
            return mdtM1HorizontalVelocity;
        }

        public long paramMdtM1GnssTodMsec() {
            return paramMdtM1GnssTodMsec;
        }

        public long mdtM1Frequency() {
            return mdtM1Frequency;
        }

        public long padding2() {
            return padding2;
        }

        /**
         * Usually 3112 event is 400 byes long (including the header) but the given data structure is only 274, rest goes here
         */
        public byte[] undefinedData() {
            return undefinedData;
        }

        public int bodyLength() {
            return bodyLength;
        }

        public EricssonEventFile _root() {
            return _root;
        }

        public EricssonEventFile.TEventRecord _parent() {
            return _parent;
        }
    }

    public static class TEvent3115Body extends KaitaiStruct {

        public TEvent3115Body(KaitaiStream _io, int bodyLength) {
            this(_io, null, null, bodyLength);
        }

        public TEvent3115Body(KaitaiStream _io, EricssonEventFile.TEventRecord _parent, int bodyLength) {
            this(_io, _parent, null, bodyLength);
        }

        public TEvent3115Body(KaitaiStream _io, EricssonEventFile.TEventRecord _parent, EricssonEventFile _root, int bodyLength) {
            super(_io);
            this._parent = _parent;
            this._root = _root;
            this.bodyLength = bodyLength;
            _read();
        }

        private void _read() {
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
            this.mdtM4ErabPdcpVolUl = new ArrayList<TE3115MdtM4ErabPdcpVolBlock>();
            for (int i = 0; i < 16; i++) {
                this.mdtM4ErabPdcpVolUl.add(new TE3115MdtM4ErabPdcpVolBlock(this._io, this, _root));
            }
            this.mdtM4ErabPdcpVolDl = new ArrayList<TE3115MdtM4ErabPdcpVolBlock>();
            for (int i = 0; i < 16; i++) {
                this.mdtM4ErabPdcpVolDl.add(new TE3115MdtM4ErabPdcpVolBlock(this._io, this, _root));
            }
            this.mdtM4M5ErabQci = new ArrayList<Integer>();
            for (int i = 0; i < 16; i++) {
                this.mdtM4M5ErabQci.add(this._io.readU2be());
            }
            this.spare = new ArrayList<Integer>();
            for (int i = 0; i < 9; i++) {
                this.spare.add(this._io.readU1());
            }
            this.undefinedData = this._io.readBytes(bodyLength() - 235);
        }

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
        private ArrayList<TE3115MdtM4ErabPdcpVolBlock> mdtM4ErabPdcpVolUl;
        private ArrayList<TE3115MdtM4ErabPdcpVolBlock> mdtM4ErabPdcpVolDl;
        private ArrayList<Integer> mdtM4M5ErabQci;
        private ArrayList<Integer> spare;
        private byte[] undefinedData;
        private int bodyLength;
        private EricssonEventFile _root;
        private EricssonEventFile.TEventRecord _parent;

        public int timestampHour() {
            return timestampHour;
        }

        public int timestampMinute() {
            return timestampMinute;
        }

        public int timestampSecond() {
            return timestampSecond;
        }

        public int timestampMillisecond() {
            return timestampMillisecond;
        }

        public long scannerId() {
            return scannerId;
        }

        public int rbsModuleId() {
            return rbsModuleId;
        }

        public long globalCellId() {
            return globalCellId;
        }

        public long enbs1apid() {
            return enbs1apid;
        }

        public long mmes1apid() {
            return mmes1apid;
        }

        public long gummei() {
            return gummei;
        }

        public long racUeRef() {
            return racUeRef;
        }

        public long traceRecordingSessionRef() {
            return traceRecordingSessionRef;
        }

        public ArrayList<TE3115MdtM4ErabPdcpVolBlock> mdtM4ErabPdcpVolUl() {
            return mdtM4ErabPdcpVolUl;
        }

        public ArrayList<TE3115MdtM4ErabPdcpVolBlock> mdtM4ErabPdcpVolDl() {
            return mdtM4ErabPdcpVolDl;
        }

        public ArrayList<Integer> mdtM4M5ErabQci() {
            return mdtM4M5ErabQci;
        }

        public ArrayList<Integer> spare() {
            return spare;
        }

        public byte[] undefinedData() {
            return undefinedData;
        }

        public int bodyLength() {
            return bodyLength;
        }

        public EricssonEventFile _root() {
            return _root;
        }

        public EricssonEventFile.TEventRecord _parent() {
            return _parent;
        }
    }

    public static class TEvent3116Body extends KaitaiStruct {
        public TEvent3116Body(KaitaiStream _io, int bodyLength) {
            this(_io, null, null, bodyLength);
        }

        public TEvent3116Body(KaitaiStream _io, EricssonEventFile.TEventRecord _parent, int bodyLength) {
            this(_io, _parent, null, bodyLength);
        }

        public TEvent3116Body(KaitaiStream _io, EricssonEventFile.TEventRecord _parent, EricssonEventFile _root, int bodyLength) {
            super(_io);
            this._parent = _parent;
            this._root = _root;
            this.bodyLength = bodyLength;
            _read();
        }

        private void _read() {
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
            this.mdtM5UeThpTimeUl = this._io.readU4be();
            this.mdtM5UeThpVolUl = this._io.readBitsIntBe(40);
            this.mdtM5ErabThpTimeDl = new ArrayList<Long>();
            for (int i = 0; i < 16; i++) {
                this.mdtM5ErabThpTimeDl.add(this._io.readBitsIntBe(40));
            }
            this.mdtM5ErabThpVolDl = new ArrayList<Long>();
            for (int i = 0; i < 16; i++) {
                this.mdtM5ErabThpVolDl.add(this._io.readBitsIntBe(40));
            }
            this._io.alignToByte();
            this.erabQci = new ArrayList<Integer>();
            for (int i = 0; i < 16; i++) {
                this.erabQci.add(this._io.readU2be());
            }
            this.mdtM5UeThpTimeDl = this._io.readU4be();
            this.mdtM5UeThpVolDl = this._io.readBitsIntBe(40);
            this.mdtM5UeLastttiVolDl = this._io.readBitsIntBe(40);
            this._io.alignToByte();
            this.spare = new ArrayList<Integer>();
            for (int i = 0; i < 9; i++) {
                this.spare.add(this._io.readU1());
            }
            this.undefinedData = this._io.readBytes(bodyLength() - 258);
        }

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
        private long mdtM5UeThpTimeUl;
        private long mdtM5UeThpVolUl;
        private ArrayList<Long> mdtM5ErabThpTimeDl;
        private ArrayList<Long> mdtM5ErabThpVolDl;
        private ArrayList<Integer> erabQci;
        private long mdtM5UeThpTimeDl;
        private long mdtM5UeThpVolDl;
        private long mdtM5UeLastttiVolDl;
        private ArrayList<Integer> spare;
        private byte[] undefinedData;
        private int bodyLength;
        private EricssonEventFile _root;
        private EricssonEventFile.TEventRecord _parent;

        public int timestampHour() {
            return timestampHour;
        }

        public int timestampMinute() {
            return timestampMinute;
        }

        public int timestampSecond() {
            return timestampSecond;
        }

        public int timestampMillisecond() {
            return timestampMillisecond;
        }

        public long scannerId() {
            return scannerId;
        }

        public int rbsModuleId() {
            return rbsModuleId;
        }

        public long globalCellId() {
            return globalCellId;
        }

        public long enbs1apid() {
            return enbs1apid;
        }

        public long mmes1apid() {
            return mmes1apid;
        }

        public long gummei() {
            return gummei;
        }

        public long racUeRef() {
            return racUeRef;
        }

        public long traceRecordingSessionRef() {
            return traceRecordingSessionRef;
        }

        public long mdtM5UeThpTimeUl() {
            return mdtM5UeThpTimeUl;
        }

        public long mdtM5UeThpVolUl() {
            return mdtM5UeThpVolUl;
        }

        public ArrayList<Long> mdtM5ErabThpTimeDl() {
            return mdtM5ErabThpTimeDl;
        }

        public ArrayList<Long> mdtM5ErabThpVolDl() {
            return mdtM5ErabThpVolDl;
        }

        public ArrayList<Integer> erabQci() {
            return erabQci;
        }

        public long mdtM5UeThpTimeDl() {
            return mdtM5UeThpTimeDl;
        }

        public long mdtM5UeThpVolDl() {
            return mdtM5UeThpVolDl;
        }

        public long mdtM5UeLastttiVolDl() {
            return mdtM5UeLastttiVolDl;
        }

        public ArrayList<Integer> spare() {
            return spare;
        }

        public byte[] undefinedData() {
            return undefinedData;
        }

        public int bodyLength() {
            return bodyLength;
        }

        public EricssonEventFile _root() {
            return _root;
        }

        public EricssonEventFile.TEventRecord _parent() {
            return _parent;
        }
    }

    public static class TEvent3114Body extends KaitaiStruct {
        public TEvent3114Body(KaitaiStream _io, int bodyLength) {
            this(_io, null, null, bodyLength);
        }

        public TEvent3114Body(KaitaiStream _io, EricssonEventFile.TEventRecord _parent, int bodyLength) {
            this(_io, _parent, null, bodyLength);
        }

        public TEvent3114Body(KaitaiStream _io, EricssonEventFile.TEventRecord _parent, EricssonEventFile _root, int bodyLength) {
            super(_io);
            this._parent = _parent;
            this._root = _root;
            this.bodyLength = bodyLength;
            _read();
        }

        private void _read() {
            this.timestampHour = this._io.readU1();
            this.timestampMinute = this._io.readU1();
            this.timestampSecond = this._io.readU1();
            this.timestampMillisec = this._io.readU2be();
            this.scannerId = this._io.readBitsIntBe(24);
            this._io.alignToByte();
            this.rbsModuleId = this._io.readU1();
            this.globalCellId = this._io.readU4be();
            this.mdtM3NoiseinterfMeas0 = this._io.readBitsIntBe(24);
            this.mdtM3NoiseinterfMeas1 = this._io.readBitsIntBe(24);
            this.mdtM3NoiseinterfMeas2 = this._io.readBitsIntBe(24);
            this.mdtM3NoiseinterfMeas3 = this._io.readBitsIntBe(24);
            this.mdtM3NoiseinterfMeas4 = this._io.readBitsIntBe(24);
            this.mdtM3NoiseinterfMeas5 = this._io.readBitsIntBe(24);
            this.mdtM3NoiseinterfMeas6 = this._io.readBitsIntBe(24);
            this.mdtM3NoiseinterfMeas7 = this._io.readBitsIntBe(24);
            this.mdtM3NoiseinterfMeas8 = this._io.readBitsIntBe(24);
            this.mdtM3NoiseinterfMeas9 = this._io.readBitsIntBe(24);
            this.mdtM3NoiseinterfMeas10 = this._io.readBitsIntBe(24);
            this.mdtM3NoiseinterfMeas11 = this._io.readBitsIntBe(24);
            this.mdtM3NoiseinterfMeas12 = this._io.readBitsIntBe(24);
            this.mdtM3NoiseinterfMeas13 = this._io.readBitsIntBe(24);
            this.mdtM3NoiseinterfMeas14 = this._io.readBitsIntBe(24);
            this.mdtM3NoiseinterfMeas15 = this._io.readBitsIntBe(24);
        }

        private int timestampHour;
        private int timestampMinute;
        private int timestampSecond;
        private int timestampMillisec;
        private long scannerId;
        private int rbsModuleId;
        private long globalCellId;
        private long mdtM3NoiseinterfMeas0;
        private long mdtM3NoiseinterfMeas1;
        private long mdtM3NoiseinterfMeas2;
        private long mdtM3NoiseinterfMeas3;
        private long mdtM3NoiseinterfMeas4;
        private long mdtM3NoiseinterfMeas5;
        private long mdtM3NoiseinterfMeas6;
        private long mdtM3NoiseinterfMeas7;
        private long mdtM3NoiseinterfMeas8;
        private long mdtM3NoiseinterfMeas9;
        private long mdtM3NoiseinterfMeas10;
        private long mdtM3NoiseinterfMeas11;
        private long mdtM3NoiseinterfMeas12;
        private long mdtM3NoiseinterfMeas13;
        private long mdtM3NoiseinterfMeas14;
        private long mdtM3NoiseinterfMeas15;
        private int bodyLength;
        private EricssonEventFile _root;
        private EricssonEventFile.TEventRecord _parent;

        public int timestampHour() {
            return timestampHour;
        }

        public int timestampMinute() {
            return timestampMinute;
        }

        public int timestampSecond() {
            return timestampSecond;
        }

        public int timestampMillisec() {
            return timestampMillisec;
        }

        public long scannerId() {
            return scannerId;
        }

        public int rbsModuleId() {
            return rbsModuleId;
        }

        public long globalCellId() {
            return globalCellId;
        }

        public long mdtM3NoiseinterfMeas0() {
            return mdtM3NoiseinterfMeas0;
        }

        public long mdtM3NoiseinterfMeas1() {
            return mdtM3NoiseinterfMeas1;
        }

        public long mdtM3NoiseinterfMeas2() {
            return mdtM3NoiseinterfMeas2;
        }

        public long mdtM3NoiseinterfMeas3() {
            return mdtM3NoiseinterfMeas3;
        }

        public long mdtM3NoiseinterfMeas4() {
            return mdtM3NoiseinterfMeas4;
        }

        public long mdtM3NoiseinterfMeas5() {
            return mdtM3NoiseinterfMeas5;
        }

        public long mdtM3NoiseinterfMeas6() {
            return mdtM3NoiseinterfMeas6;
        }

        public long mdtM3NoiseinterfMeas7() {
            return mdtM3NoiseinterfMeas7;
        }

        public long mdtM3NoiseinterfMeas8() {
            return mdtM3NoiseinterfMeas8;
        }

        public long mdtM3NoiseinterfMeas9() {
            return mdtM3NoiseinterfMeas9;
        }

        public long mdtM3NoiseinterfMeas10() {
            return mdtM3NoiseinterfMeas10;
        }

        public long mdtM3NoiseinterfMeas11() {
            return mdtM3NoiseinterfMeas11;
        }

        public long mdtM3NoiseinterfMeas12() {
            return mdtM3NoiseinterfMeas12;
        }

        public long mdtM3NoiseinterfMeas13() {
            return mdtM3NoiseinterfMeas13;
        }

        public long mdtM3NoiseinterfMeas14() {
            return mdtM3NoiseinterfMeas14;
        }

        public long mdtM3NoiseinterfMeas15() {
            return mdtM3NoiseinterfMeas15;
        }

        public int bodyLength() {
            return bodyLength;
        }

        public EricssonEventFile _root() {
            return _root;
        }

        public EricssonEventFile.TEventRecord _parent() {
            return _parent;
        }
    }

    public static class TEvent3076Body extends KaitaiStruct {
        public TEvent3076Body(KaitaiStream _io, int bodyLength) {
            this(_io, null, null, bodyLength);
        }

        public TEvent3076Body(KaitaiStream _io, EricssonEventFile.TEventRecord _parent, int bodyLength) {
            this(_io, _parent, null, bodyLength);
        }

        public TEvent3076Body(KaitaiStream _io, EricssonEventFile.TEventRecord _parent, EricssonEventFile _root, int bodyLength) {
            super(_io);
            this._parent = _parent;
            this._root = _root;
            this.bodyLength = bodyLength;
            _read();
        }

        private void _read() {
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
            this.perUeThpPdcpvolTrunkDl = this._io.readBitsIntBe(40);
            this._io.alignToByte();
            this.perUeThpTimeDl = this._io.readU4be();
            this.perUeThpPdcpvolTrunkUl = this._io.readBitsIntBe(40);
            this._io.alignToByte();
            this.perUeThpTimeUl = this._io.readU4be();
            this.spare1 = new ArrayList<Integer>();
            for (int i = 0; i < 4; i++) {
                this.spare1.add(this._io.readU1());
            }
            this.spare2 = new ArrayList<Integer>();
            for (int i = 0; i < 4; i++) {
                this.spare2.add(this._io.readU1());
            }
            this.perSchedActivityUeUl = this._io.readU4be();
            this.perSchedActivityUeDl = this._io.readU4be();
            this.perUePdcpSrbAckvolDl = this._io.readBitsIntBe(40);
            this.perUePdcpSrbTransvolDl = this._io.readBitsIntBe(40);
            this.perUePdcpSrbRecvolUl = this._io.readBitsIntBe(40);
            this.perUeRlcAckDl = this._io.readBitsIntBe(40);
            this.perUeRlcNackDl = this._io.readBitsIntBe(40);
            this.perUeRlcAckUl = this._io.readBitsIntBe(40);
            this.perUeRlcNackUl = this._io.readBitsIntBe(40);
            this._io.alignToByte();
            this.perUeDlMacDelay = this._io.readU4be();
            this.perUeHarqDlAckQpsk = this._io.readBitsIntBe(40);
            this.perUeHarqDlNackQpsk = this._io.readBitsIntBe(40);
            this.perUeHarqUlSuccQpsk = this._io.readBitsIntBe(40);
            this.ueHarqUlFailQpsk = this._io.readBitsIntBe(40);
            this.ueHarqDlAck16qam = this._io.readBitsIntBe(40);
            this.ueHarqDlNack16qam = this._io.readBitsIntBe(40);
            this.ueHarqUlSucc16qam = this._io.readBitsIntBe(40);
            this.ueHarqUlFail16qam = this._io.readBitsIntBe(40);
            this.ueHarqDlAck64qam = this._io.readBitsIntBe(40);
            this.ueHarqDlNack64qam = this._io.readBitsIntBe(40);
            this._io.alignToByte();
            this.perUeMacDtxUlQpsk = this._io.readU4be();
            this.perUeMacDtxDlQpsk = this._io.readU4be();
            this.perUeMacDtxDl16qam = this._io.readU4be();
            this.perUeMacDtxUl16qam = this._io.readU4be();
            this.perUeMacDtxDl64qam = this._io.readU4be();
            this.radiothpVolDl = this._io.readBitsIntBe(40);
            this.radiothpResDl = this._io.readBitsIntBe(40);
            this.radiothpVolUl = this._io.readBitsIntBe(40);
            this.radiothpResUl = this._io.readBitsIntBe(40);
            this._io.alignToByte();
            this.spare3 = new ArrayList<Integer>();
            for (int i = 0; i < 5; i++) {
                this.spare3.add(this._io.readU1());
            }
            this.perUeThpDlDrb = this._io.readBitsIntBe(24);
            this.perUeThpUlDrb = this._io.readBitsIntBe(24);
            this.pdcpSduVoipUlpdbOk = this._io.readBitsIntBe(24);
            this._io.alignToByte();
            this.perUeRateShapeTimeUl = this._io.readU4be();
            this.perUeRlcPollRetxDl = this._io.readBitsIntBe(24);
            this.perUeRlcPollRetxUl = this._io.readBitsIntBe(24);
            this.ueHarqDlAck256qam = this._io.readBitsIntBe(40);
            this.ueHarqDlNack256qam = this._io.readBitsIntBe(40);
            this._io.alignToByte();
            this.perUeMacDtxDl256qam = this._io.readU4be();
            this.perUeThpMactimeDrbDl = this._io.readU4be();
            this.perUeThpMacvolDrbDl = this._io.readBitsIntBe(40);
            this.perUeThpMacDrbDl = this._io.readBitsIntBe(24);
            this.perUeThpMacvolUl = this._io.readBitsIntBe(40);
            this._io.alignToByte();
            this.perUeThpMactimeUl = this._io.readU4be();
            this.perUeThpMacUl = this._io.readBitsIntBe(24);
            this.ueHarqUlSucc64qam = this._io.readBitsIntBe(40);
            this.ueHarqUlFail64qam = this._io.readBitsIntBe(40);
            this._io.alignToByte();
            this.perUeMacDtxUl64qam = this._io.readU4be();
            this.plmnIndex = this._io.readU1();
            this.ueCategoryFlex = this._io.readU1();
            this.spidValue = this._io.readU2be();
            this.ueHarqDlAckBpsk = this._io.readBitsIntBe(40);
            this.ueHarqDlNackBpsk = this._io.readBitsIntBe(40);
            this.dlharqAnmodeUsedFormat30 = this._io.readBitsIntBe(40);
            this.dlharqAnmodeUsedFormat31 = this._io.readBitsIntBe(40);
            this.dlharqAnmodeUsedFormat32 = this._io.readBitsIntBe(40);
            this.dlharqAnmodeUsedFormat33 = this._io.readBitsIntBe(40);
            this.dlharqAnmodeUsedMux0 = this._io.readBitsIntBe(40);
            this.dlharqAnmodeUsedMux1 = this._io.readBitsIntBe(40);
            this.dlharqAnmodeUsedMux2 = this._io.readBitsIntBe(40);
            this.dlharqAnmodeUsedMux3 = this._io.readBitsIntBe(40);
            this.format3ResCollision = this._io.readBitsIntBe(40);
            this._io.alignToByte();
            this.uePowerClass = this._io.readU1();
            this.brCeLevel = this._io.readU1();
            this.ueVoipQualityUlOk = this._io.readBitsIntBe(24);
            this.ueVoipQualityUlNok = this._io.readBitsIntBe(24);
            this._io.alignToByte();
            this.subscriberGroupId = this._io.readU1();
            this.perSchedActivityUeUlShortsps = this._io.readU4be();
            this.perUeThpTimeUlInitial = this._io.readU4be();
            this.perUeThpPdcpvolTrunkUlInitial = this._io.readBitsIntBe(40);
            this._io.alignToByte();
            this.ueEndcStage = this._io.readU1();
            this.perUeMacDtxUl256qam = this._io.readU4be();
            this.ueHarqUlFail256qam = this._io.readBitsIntBe(40);
            this.ueHarqUlSucc256qam = this._io.readBitsIntBe(40);
            this._io.alignToByte();
            this.perUeMacDtxUlSkipulpreschd = this._io.readU4be();
            this.perUeMacDtxUlSkipultxsps = this._io.readU4be();
            this.perUeMacDtxUlSkipuldyn = this._io.readU4be();
            this.ueHarqIuaUlFailQpsk = this._io.readU4be();
            this.ueHarqIuaUlFail16qam = this._io.readU4be();
            this._io.alignToByte();
            this.spare4 = new ArrayList<Integer>();
            for (int i = 0; i < 8; i++) {
                this.spare4.add(this._io.readU1());
            }
            this.perUeMacUlUnresUePucchSrGrantSamp = this._io.readU4be();
            this.spare5 = new ArrayList<Integer>();
            for (int i = 0; i < 4; i++) {
                this.spare5.add(this._io.readU1());
            }
            this.spare6 = new ArrayList<Integer>();
            for (int i = 0; i < 4; i++) {
                this.spare6.add(this._io.readU1());
            }
            this.perUeMacVolUlResUe = this._io.readU8be();
            this.perUeMacTimeUlResUe = this._io.readU8be();
            this.perUeMacVolUlResUeLastTti = this._io.readU8be();
            this.perUeMacTimeUlResUeLastTtiSamp = this._io.readU4be();
            this.perUeMacVolUlResUeLate = this._io.readU8be();
            this.perUeMacTimeUlResUeLate = this._io.readU4be();
            this.perUlHeavyUeThpBeforeHo = this._io.readU4be();
            this.perUlHeavyUeThpAfterHo = this._io.readU4be();
            this.perUlHeavyUeRequiredTbsBeforeHo = this._io.readU4be();
            this.perUlHeavyUeRequiredTbsAfterHo = this._io.readU4be();
            this.perUeMacUlUnresUePreemptGrantSamp = this._io.readU4be();
            this.perUeMacUlUnresUeBsrGrantSamp = this._io.readU4be();
            this.spare8 = new ArrayList<Integer>();
            for (int i = 0; i < 9; i++) {
                this.spare8.add(this._io.readU1());
            }
            this.perUeMacDtxUlSkipulpreschdVolte = this._io.readBitsIntBe(40);
            this.perUeMacDtxUlSkipuldynVolte = this._io.readBitsIntBe(40);
            this._io.alignToByte();
            this.perUlHeavyUeRequiredTbsBeforeHoSele = this._io.readU4be();
            this.perUlHeavyUeRequiredTbsAfterHoSele = this._io.readU4be();
            this.perUlHeavyUePcellThpBeforeHoSele = this._io.readU4be();
            this.perUlHeavyUePcellThpAfterHoSele = this._io.readU4be();
            this.perUlScellActivityStateBeforeSele = this._io.readU4be();
            this.perUlScellActivityStateAfterSele = this._io.readU4be();
            this.perUlScellThpBeforeSele = this._io.readU4be();
            this.perUlScellThpAfterSele = this._io.readU4be();
            this.ueHarqUlTrans1 = this._io.readBitsIntBe(40);
            this.ueHarqUlTrans2 = this._io.readBitsIntBe(40);
            this.ueHarqUlTrans3 = this._io.readBitsIntBe(40);
            this.ueHarqUlTrans4 = this._io.readBitsIntBe(40);
            this.ueHarqUlTrans5 = this._io.readBitsIntBe(40);
            this.ueHarqUlTrans6 = this._io.readBitsIntBe(40);
            this.ueHarqUlTrans7 = this._io.readBitsIntBe(40);
            this.ueHarqUlAllDtx = this._io.readBitsIntBe(40);
            this.ueHarqDlTrans1 = this._io.readBitsIntBe(40);
            this.ueHarqDlTrans2 = this._io.readBitsIntBe(40);
            this.ueHarqDlTrans3 = this._io.readBitsIntBe(40);
            this.ueHarqDlTrans4 = this._io.readBitsIntBe(40);
            this.ueHarqDlTrans5 = this._io.readBitsIntBe(40);
            this.ueHarqDlTrans6 = this._io.readBitsIntBe(40);
            this.ueHarqDlTrans7 = this._io.readBitsIntBe(40);
            this.ueHarqDlAllDtx = this._io.readBitsIntBe(40);
            this._io.alignToByte();
            this.perUeMacVolUlUnresUePucchSrGrant = this._io.readU8be();
            this.perUeMacVolUlUnresUePreemptGrant = this._io.readU8be();
            this.perUeMacVolUlUnresUeBsrGrant = this._io.readU8be();
            this.perUeThpPdcptimeDrbDl = this._io.readU4be();
            this.perSchedActivityUeUlcomp = this._io.readU4be();
            this.undefinedData = this._io.readBytes((bodyLength() - 636));
        }

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
        private long perUeThpPdcpvolTrunkDl;
        private long perUeThpTimeDl;
        private long perUeThpPdcpvolTrunkUl;
        private long perUeThpTimeUl;
        private ArrayList<Integer> spare1;
        private ArrayList<Integer> spare2;
        private long perSchedActivityUeUl;
        private long perSchedActivityUeDl;
        private long perUePdcpSrbAckvolDl;
        private long perUePdcpSrbTransvolDl;
        private long perUePdcpSrbRecvolUl;
        private long perUeRlcAckDl;
        private long perUeRlcNackDl;
        private long perUeRlcAckUl;
        private long perUeRlcNackUl;
        private long perUeDlMacDelay;
        private long perUeHarqDlAckQpsk;
        private long perUeHarqDlNackQpsk;
        private long perUeHarqUlSuccQpsk;
        private long ueHarqUlFailQpsk;
        private long ueHarqDlAck16qam;
        private long ueHarqDlNack16qam;
        private long ueHarqUlSucc16qam;
        private long ueHarqUlFail16qam;
        private long ueHarqDlAck64qam;
        private long ueHarqDlNack64qam;
        private long perUeMacDtxUlQpsk;
        private long perUeMacDtxDlQpsk;
        private long perUeMacDtxDl16qam;
        private long perUeMacDtxUl16qam;
        private long perUeMacDtxDl64qam;
        private long radiothpVolDl;
        private long radiothpResDl;
        private long radiothpVolUl;
        private long radiothpResUl;
        private ArrayList<Integer> spare3;
        private long perUeThpDlDrb;
        private long perUeThpUlDrb;
        private long pdcpSduVoipUlpdbOk;
        private long perUeRateShapeTimeUl;
        private long perUeRlcPollRetxDl;
        private long perUeRlcPollRetxUl;
        private long ueHarqDlAck256qam;
        private long ueHarqDlNack256qam;
        private long perUeMacDtxDl256qam;
        private long perUeThpMactimeDrbDl;
        private long perUeThpMacvolDrbDl;
        private long perUeThpMacDrbDl;
        private long perUeThpMacvolUl;
        private long perUeThpMactimeUl;
        private long perUeThpMacUl;
        private long ueHarqUlSucc64qam;
        private long ueHarqUlFail64qam;
        private long perUeMacDtxUl64qam;
        private int plmnIndex;
        private int ueCategoryFlex;
        private int spidValue;
        private long ueHarqDlAckBpsk;
        private long ueHarqDlNackBpsk;
        private long dlharqAnmodeUsedFormat30;
        private long dlharqAnmodeUsedFormat31;
        private long dlharqAnmodeUsedFormat32;
        private long dlharqAnmodeUsedFormat33;
        private long dlharqAnmodeUsedMux0;
        private long dlharqAnmodeUsedMux1;
        private long dlharqAnmodeUsedMux2;
        private long dlharqAnmodeUsedMux3;
        private long format3ResCollision;
        private int uePowerClass;
        private int brCeLevel;
        private long ueVoipQualityUlOk;
        private long ueVoipQualityUlNok;
        private int subscriberGroupId;
        private long perSchedActivityUeUlShortsps;
        private long perUeThpTimeUlInitial;
        private long perUeThpPdcpvolTrunkUlInitial;
        private int ueEndcStage;
        private long perUeMacDtxUl256qam;
        private long ueHarqUlFail256qam;
        private long ueHarqUlSucc256qam;
        private long perUeMacDtxUlSkipulpreschd;
        private long perUeMacDtxUlSkipultxsps;
        private long perUeMacDtxUlSkipuldyn;
        private long ueHarqIuaUlFailQpsk;
        private long ueHarqIuaUlFail16qam;
        private ArrayList<Integer> spare4;
        private long perUeMacUlUnresUePucchSrGrantSamp;
        private ArrayList<Integer> spare5;
        private ArrayList<Integer> spare6;
        private long perUeMacVolUlResUe;
        private long perUeMacTimeUlResUe;
        private long perUeMacVolUlResUeLastTti;
        private long perUeMacTimeUlResUeLastTtiSamp;
        private long perUeMacVolUlResUeLate;
        private long perUeMacTimeUlResUeLate;
        private long perUlHeavyUeThpBeforeHo;
        private long perUlHeavyUeThpAfterHo;
        private long perUlHeavyUeRequiredTbsBeforeHo;
        private long perUlHeavyUeRequiredTbsAfterHo;
        private long perUeMacUlUnresUePreemptGrantSamp;
        private long perUeMacUlUnresUeBsrGrantSamp;
        private ArrayList<Integer> spare8;
        private long perUeMacDtxUlSkipulpreschdVolte;
        private long perUeMacDtxUlSkipuldynVolte;
        private long perUlHeavyUeRequiredTbsBeforeHoSele;
        private long perUlHeavyUeRequiredTbsAfterHoSele;
        private long perUlHeavyUePcellThpBeforeHoSele;
        private long perUlHeavyUePcellThpAfterHoSele;
        private long perUlScellActivityStateBeforeSele;
        private long perUlScellActivityStateAfterSele;
        private long perUlScellThpBeforeSele;
        private long perUlScellThpAfterSele;
        private long ueHarqUlTrans1;
        private long ueHarqUlTrans2;
        private long ueHarqUlTrans3;
        private long ueHarqUlTrans4;
        private long ueHarqUlTrans5;
        private long ueHarqUlTrans6;
        private long ueHarqUlTrans7;
        private long ueHarqUlAllDtx;
        private long ueHarqDlTrans1;
        private long ueHarqDlTrans2;
        private long ueHarqDlTrans3;
        private long ueHarqDlTrans4;
        private long ueHarqDlTrans5;
        private long ueHarqDlTrans6;
        private long ueHarqDlTrans7;
        private long ueHarqDlAllDtx;
        private long perUeMacVolUlUnresUePucchSrGrant;
        private long perUeMacVolUlUnresUePreemptGrant;
        private long perUeMacVolUlUnresUeBsrGrant;
        private long perUeThpPdcptimeDrbDl;
        private long perSchedActivityUeUlcomp;
        private byte[] undefinedData;
        private int bodyLength;
        private EricssonEventFile _root;
        private EricssonEventFile.TEventRecord _parent;

        public int timestampHour() {
            return timestampHour;
        }

        public int timestampMinute() {
            return timestampMinute;
        }

        public int timestampSecond() {
            return timestampSecond;
        }

        public int timestampMillisecond() {
            return timestampMillisecond;
        }

        public long scannerId() {
            return scannerId;
        }

        public int rbsModuleId() {
            return rbsModuleId;
        }

        public long globalCellId() {
            return globalCellId;
        }

        public long enbs1apid() {
            return enbs1apid;
        }

        public long mmes1apid() {
            return mmes1apid;
        }

        public long gummei() {
            return gummei;
        }

        public long racUeRef() {
            return racUeRef;
        }

        public long traceRecordingSessionRef() {
            return traceRecordingSessionRef;
        }

        public long perUeThpPdcpvolTrunkDl() {
            return perUeThpPdcpvolTrunkDl;
        }

        public long perUeThpTimeDl() {
            return perUeThpTimeDl;
        }

        public long perUeThpPdcpvolTrunkUl() {
            return perUeThpPdcpvolTrunkUl;
        }

        public long perUeThpTimeUl() {
            return perUeThpTimeUl;
        }

        public ArrayList<Integer> spare1() {
            return spare1;
        }

        public ArrayList<Integer> spare2() {
            return spare2;
        }

        public long perSchedActivityUeUl() {
            return perSchedActivityUeUl;
        }

        public long perSchedActivityUeDl() {
            return perSchedActivityUeDl;
        }

        public long perUePdcpSrbAckvolDl() {
            return perUePdcpSrbAckvolDl;
        }

        public long perUePdcpSrbTransvolDl() {
            return perUePdcpSrbTransvolDl;
        }

        public long perUePdcpSrbRecvolUl() {
            return perUePdcpSrbRecvolUl;
        }

        public long perUeRlcAckDl() {
            return perUeRlcAckDl;
        }

        public long perUeRlcNackDl() {
            return perUeRlcNackDl;
        }

        public long perUeRlcAckUl() {
            return perUeRlcAckUl;
        }

        public long perUeRlcNackUl() {
            return perUeRlcNackUl;
        }

        public long perUeDlMacDelay() {
            return perUeDlMacDelay;
        }

        public long perUeHarqDlAckQpsk() {
            return perUeHarqDlAckQpsk;
        }

        public long perUeHarqDlNackQpsk() {
            return perUeHarqDlNackQpsk;
        }

        public long perUeHarqUlSuccQpsk() {
            return perUeHarqUlSuccQpsk;
        }

        public long ueHarqUlFailQpsk() {
            return ueHarqUlFailQpsk;
        }

        public long ueHarqDlAck16qam() {
            return ueHarqDlAck16qam;
        }

        public long ueHarqDlNack16qam() {
            return ueHarqDlNack16qam;
        }

        public long ueHarqUlSucc16qam() {
            return ueHarqUlSucc16qam;
        }

        public long ueHarqUlFail16qam() {
            return ueHarqUlFail16qam;
        }

        public long ueHarqDlAck64qam() {
            return ueHarqDlAck64qam;
        }

        public long ueHarqDlNack64qam() {
            return ueHarqDlNack64qam;
        }

        public long perUeMacDtxUlQpsk() {
            return perUeMacDtxUlQpsk;
        }

        public long perUeMacDtxDlQpsk() {
            return perUeMacDtxDlQpsk;
        }

        public long perUeMacDtxDl16qam() {
            return perUeMacDtxDl16qam;
        }

        public long perUeMacDtxUl16qam() {
            return perUeMacDtxUl16qam;
        }

        public long perUeMacDtxDl64qam() {
            return perUeMacDtxDl64qam;
        }

        public long radiothpVolDl() {
            return radiothpVolDl;
        }

        public long radiothpResDl() {
            return radiothpResDl;
        }

        public long radiothpVolUl() {
            return radiothpVolUl;
        }

        public long radiothpResUl() {
            return radiothpResUl;
        }

        public ArrayList<Integer> spare3() {
            return spare3;
        }

        public long perUeThpDlDrb() {
            return perUeThpDlDrb;
        }

        public long perUeThpUlDrb() {
            return perUeThpUlDrb;
        }

        public long pdcpSduVoipUlpdbOk() {
            return pdcpSduVoipUlpdbOk;
        }

        public long perUeRateShapeTimeUl() {
            return perUeRateShapeTimeUl;
        }

        public long perUeRlcPollRetxDl() {
            return perUeRlcPollRetxDl;
        }

        public long perUeRlcPollRetxUl() {
            return perUeRlcPollRetxUl;
        }

        public long ueHarqDlAck256qam() {
            return ueHarqDlAck256qam;
        }

        public long ueHarqDlNack256qam() {
            return ueHarqDlNack256qam;
        }

        public long perUeMacDtxDl256qam() {
            return perUeMacDtxDl256qam;
        }

        public long perUeThpMactimeDrbDl() {
            return perUeThpMactimeDrbDl;
        }

        public long perUeThpMacvolDrbDl() {
            return perUeThpMacvolDrbDl;
        }

        public long perUeThpMacDrbDl() {
            return perUeThpMacDrbDl;
        }

        public long perUeThpMacvolUl() {
            return perUeThpMacvolUl;
        }

        public long perUeThpMactimeUl() {
            return perUeThpMactimeUl;
        }

        public long perUeThpMacUl() {
            return perUeThpMacUl;
        }

        public long ueHarqUlSucc64qam() {
            return ueHarqUlSucc64qam;
        }

        public long ueHarqUlFail64qam() {
            return ueHarqUlFail64qam;
        }

        public long perUeMacDtxUl64qam() {
            return perUeMacDtxUl64qam;
        }

        public int plmnIndex() {
            return plmnIndex;
        }

        public int ueCategoryFlex() {
            return ueCategoryFlex;
        }

        public int spidValue() {
            return spidValue;
        }

        public long ueHarqDlAckBpsk() {
            return ueHarqDlAckBpsk;
        }

        public long ueHarqDlNackBpsk() {
            return ueHarqDlNackBpsk;
        }

        public long dlharqAnmodeUsedFormat30() {
            return dlharqAnmodeUsedFormat30;
        }

        public long dlharqAnmodeUsedFormat31() {
            return dlharqAnmodeUsedFormat31;
        }

        public long dlharqAnmodeUsedFormat32() {
            return dlharqAnmodeUsedFormat32;
        }

        public long dlharqAnmodeUsedFormat33() {
            return dlharqAnmodeUsedFormat33;
        }

        public long dlharqAnmodeUsedMux0() {
            return dlharqAnmodeUsedMux0;
        }

        public long dlharqAnmodeUsedMux1() {
            return dlharqAnmodeUsedMux1;
        }

        public long dlharqAnmodeUsedMux2() {
            return dlharqAnmodeUsedMux2;
        }

        public long dlharqAnmodeUsedMux3() {
            return dlharqAnmodeUsedMux3;
        }

        public long format3ResCollision() {
            return format3ResCollision;
        }

        public int uePowerClass() {
            return uePowerClass;
        }

        public int brCeLevel() {
            return brCeLevel;
        }

        public long ueVoipQualityUlOk() {
            return ueVoipQualityUlOk;
        }

        public long ueVoipQualityUlNok() {
            return ueVoipQualityUlNok;
        }

        public int subscriberGroupId() {
            return subscriberGroupId;
        }

        public long perSchedActivityUeUlShortsps() {
            return perSchedActivityUeUlShortsps;
        }

        public long perUeThpTimeUlInitial() {
            return perUeThpTimeUlInitial;
        }

        public long perUeThpPdcpvolTrunkUlInitial() {
            return perUeThpPdcpvolTrunkUlInitial;
        }

        public int ueEndcStage() {
            return ueEndcStage;
        }

        public long perUeMacDtxUl256qam() {
            return perUeMacDtxUl256qam;
        }

        public long ueHarqUlFail256qam() {
            return ueHarqUlFail256qam;
        }

        public long ueHarqUlSucc256qam() {
            return ueHarqUlSucc256qam;
        }

        public long perUeMacDtxUlSkipulpreschd() {
            return perUeMacDtxUlSkipulpreschd;
        }

        public long perUeMacDtxUlSkipultxsps() {
            return perUeMacDtxUlSkipultxsps;
        }

        public long perUeMacDtxUlSkipuldyn() {
            return perUeMacDtxUlSkipuldyn;
        }

        public long ueHarqIuaUlFailQpsk() {
            return ueHarqIuaUlFailQpsk;
        }

        public long ueHarqIuaUlFail16qam() {
            return ueHarqIuaUlFail16qam;
        }

        public ArrayList<Integer> spare4() {
            return spare4;
        }

        public long perUeMacUlUnresUePucchSrGrantSamp() {
            return perUeMacUlUnresUePucchSrGrantSamp;
        }

        public ArrayList<Integer> spare5() {
            return spare5;
        }

        public ArrayList<Integer> spare6() {
            return spare6;
        }

        public long perUeMacVolUlResUe() {
            return perUeMacVolUlResUe;
        }

        public long perUeMacTimeUlResUe() {
            return perUeMacTimeUlResUe;
        }

        public long perUeMacVolUlResUeLastTti() {
            return perUeMacVolUlResUeLastTti;
        }

        public long perUeMacTimeUlResUeLastTtiSamp() {
            return perUeMacTimeUlResUeLastTtiSamp;
        }

        public long perUeMacVolUlResUeLate() {
            return perUeMacVolUlResUeLate;
        }

        public long perUeMacTimeUlResUeLate() {
            return perUeMacTimeUlResUeLate;
        }

        public long perUlHeavyUeThpBeforeHo() {
            return perUlHeavyUeThpBeforeHo;
        }

        public long perUlHeavyUeThpAfterHo() {
            return perUlHeavyUeThpAfterHo;
        }

        public long perUlHeavyUeRequiredTbsBeforeHo() {
            return perUlHeavyUeRequiredTbsBeforeHo;
        }

        public long perUlHeavyUeRequiredTbsAfterHo() {
            return perUlHeavyUeRequiredTbsAfterHo;
        }

        public long perUeMacUlUnresUePreemptGrantSamp() {
            return perUeMacUlUnresUePreemptGrantSamp;
        }

        public long perUeMacUlUnresUeBsrGrantSamp() {
            return perUeMacUlUnresUeBsrGrantSamp;
        }

        public ArrayList<Integer> spare8() {
            return spare8;
        }

        public long perUeMacDtxUlSkipulpreschdVolte() {
            return perUeMacDtxUlSkipulpreschdVolte;
        }

        public long perUeMacDtxUlSkipuldynVolte() {
            return perUeMacDtxUlSkipuldynVolte;
        }

        public long perUlHeavyUeRequiredTbsBeforeHoSele() {
            return perUlHeavyUeRequiredTbsBeforeHoSele;
        }

        public long perUlHeavyUeRequiredTbsAfterHoSele() {
            return perUlHeavyUeRequiredTbsAfterHoSele;
        }

        public long perUlHeavyUePcellThpBeforeHoSele() {
            return perUlHeavyUePcellThpBeforeHoSele;
        }

        public long perUlHeavyUePcellThpAfterHoSele() {
            return perUlHeavyUePcellThpAfterHoSele;
        }

        public long perUlScellActivityStateBeforeSele() {
            return perUlScellActivityStateBeforeSele;
        }

        public long perUlScellActivityStateAfterSele() {
            return perUlScellActivityStateAfterSele;
        }

        public long perUlScellThpBeforeSele() {
            return perUlScellThpBeforeSele;
        }

        public long perUlScellThpAfterSele() {
            return perUlScellThpAfterSele;
        }

        public long ueHarqUlTrans1() {
            return ueHarqUlTrans1;
        }

        public long ueHarqUlTrans2() {
            return ueHarqUlTrans2;
        }

        public long ueHarqUlTrans3() {
            return ueHarqUlTrans3;
        }

        public long ueHarqUlTrans4() {
            return ueHarqUlTrans4;
        }

        public long ueHarqUlTrans5() {
            return ueHarqUlTrans5;
        }

        public long ueHarqUlTrans6() {
            return ueHarqUlTrans6;
        }

        public long ueHarqUlTrans7() {
            return ueHarqUlTrans7;
        }

        public long ueHarqUlAllDtx() {
            return ueHarqUlAllDtx;
        }

        public long ueHarqDlTrans1() {
            return ueHarqDlTrans1;
        }

        public long ueHarqDlTrans2() {
            return ueHarqDlTrans2;
        }

        public long ueHarqDlTrans3() {
            return ueHarqDlTrans3;
        }

        public long ueHarqDlTrans4() {
            return ueHarqDlTrans4;
        }

        public long ueHarqDlTrans5() {
            return ueHarqDlTrans5;
        }

        public long ueHarqDlTrans6() {
            return ueHarqDlTrans6;
        }

        public long ueHarqDlTrans7() {
            return ueHarqDlTrans7;
        }

        public long ueHarqDlAllDtx() {
            return ueHarqDlAllDtx;
        }

        public long perUeMacVolUlUnresUePucchSrGrant() {
            return perUeMacVolUlUnresUePucchSrGrant;
        }

        public long perUeMacVolUlUnresUePreemptGrant() {
            return perUeMacVolUlUnresUePreemptGrant;
        }

        public long perUeMacVolUlUnresUeBsrGrant() {
            return perUeMacVolUlUnresUeBsrGrant;
        }

        public long perUeThpPdcptimeDrbDl() {
            return perUeThpPdcptimeDrbDl;
        }

        public long perSchedActivityUeUlcomp() {
            return perSchedActivityUeUlcomp;
        }

        public byte[] undefinedData() {
            return undefinedData;
        }

        public int bodyLength() {
            return bodyLength;
        }

        public EricssonEventFile _root() {
            return _root;
        }

        public EricssonEventFile.TEventRecord _parent() {
            return _parent;
        }

    }

    public static class TEvent3075Body extends KaitaiStruct {
        public TEvent3075Body(KaitaiStream _io, int bodyLength) {
            this(_io, null, null, bodyLength);
        }

        public TEvent3075Body(KaitaiStream _io, EricssonEventFile.TEventRecord _parent, int bodyLength) {
            this(_io, _parent, null, bodyLength);
        }

        public TEvent3075Body(KaitaiStream _io, EricssonEventFile.TEventRecord _parent, EricssonEventFile _root, int bodyLength) {
            super(_io);
            this._parent = _parent;
            this._root = _root;
            this.bodyLength = bodyLength;
            _read();
        }

        private void _read() {
            this.timestampHour = this._io.readU1();
            this.timestampMinute = this._io.readU1();
            this.timestampSecond = this._io.readU1();
            this.timestampMillisec = this._io.readU2be();
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
            this.traceRecordingSessionReference = this._io.readBitsIntBe(24);

            this.rankTx0 = this._io.readBitsIntBe(24);
            this.rankTx1 = this._io.readBitsIntBe(24);
            this.rankTx2 = this._io.readBitsIntBe(24);
            this.rankTx3 = this._io.readBitsIntBe(24);
            this.rankTx4 = this._io.readBitsIntBe(24);
            this.rankTx5 = this._io.readBitsIntBe(24);
            this.rankTx6 = this._io.readBitsIntBe(24);
            this.rankTx7 = this._io.readBitsIntBe(24);

            this.cqiReported0 = this._io.readBitsIntBe(24);
            this.cqiReported1 = this._io.readBitsIntBe(24);
            this.cqiReported2 = this._io.readBitsIntBe(24);
            this.cqiReported3 = this._io.readBitsIntBe(24);
            this.cqiReported4 = this._io.readBitsIntBe(24);
            this.cqiReported5 = this._io.readBitsIntBe(24);
            this.cqiReported6 = this._io.readBitsIntBe(24);
            this.cqiReported7 = this._io.readBitsIntBe(24);
            this.cqiReported8 = this._io.readBitsIntBe(24);
            this.cqiReported9 = this._io.readBitsIntBe(24);
            this.cqiReported10 = this._io.readBitsIntBe(24);
            this.cqiReported11 = this._io.readBitsIntBe(24);
            this.cqiReported12 = this._io.readBitsIntBe(24);
            this.cqiReported13 = this._io.readBitsIntBe(24);
            this.cqiReported14 = this._io.readBitsIntBe(24);
            this.cqiReported15 = this._io.readBitsIntBe(24);

            this.rankReported0 = this._io.readBitsIntBe(24);
            this.rankReported1 = this._io.readBitsIntBe(24);

            this.tbspwrrestricted = this._io.readBitsIntBe(24);
            this.tbspwrunrestricted = this._io.readBitsIntBe(24);

            this.cqi2Reported0 = this._io.readBitsIntBe(24);
            this.cqi2Reported1 = this._io.readBitsIntBe(24);
            this.cqi2Reported2 = this._io.readBitsIntBe(24);
            this.cqi2Reported3 = this._io.readBitsIntBe(24);
            this.cqi2Reported4 = this._io.readBitsIntBe(24);
            this.cqi2Reported5 = this._io.readBitsIntBe(24);
            this.cqi2Reported6 = this._io.readBitsIntBe(24);
            this.cqi2Reported7 = this._io.readBitsIntBe(24);
            this.cqi2Reported8 = this._io.readBitsIntBe(24);
            this.cqi2Reported9 = this._io.readBitsIntBe(24);
            this.cqi2Reported10 = this._io.readBitsIntBe(24);
            this.cqi2Reported11 = this._io.readBitsIntBe(24);
            this.cqi2Reported12 = this._io.readBitsIntBe(24);
            this.cqi2Reported13 = this._io.readBitsIntBe(24);
            this.cqi2Reported14 = this._io.readBitsIntBe(24);
            this.cqi2Reported15 = this._io.readBitsIntBe(24);

            this.outLoopAdjDl0 = this._io.readBitsIntBe(24);
            this.outLoopAdjDl1 = this._io.readBitsIntBe(24);
            this.outLoopAdjDl2 = this._io.readBitsIntBe(24);
            this.outLoopAdjDl3 = this._io.readBitsIntBe(24);
            this.outLoopAdjDl4 = this._io.readBitsIntBe(24);
            this.outLoopAdjDl5 = this._io.readBitsIntBe(24);
            this.outLoopAdjDl6 = this._io.readBitsIntBe(24);
            this.outLoopAdjDl7 = this._io.readBitsIntBe(24);

            this.sinrMeasPusch0 = this._io.readBitsIntBe(24);
            this.sinrMeasPusch1 = this._io.readBitsIntBe(24);
            this.sinrMeasPusch2 = this._io.readBitsIntBe(24);
            this.sinrMeasPusch3 = this._io.readBitsIntBe(24);
            this.sinrMeasPusch4 = this._io.readBitsIntBe(24);
            this.sinrMeasPusch5 = this._io.readBitsIntBe(24);
            this.sinrMeasPusch6 = this._io.readBitsIntBe(24);
            this.sinrMeasPusch7 = this._io.readBitsIntBe(24);

            this.sinrMeasPucch0 = this._io.readBitsIntBe(24);
            this.sinrMeasPucch1 = this._io.readBitsIntBe(24);
            this.sinrMeasPucch2 = this._io.readBitsIntBe(24);
            this.sinrMeasPucch3 = this._io.readBitsIntBe(24);
            this.sinrMeasPucch4 = this._io.readBitsIntBe(24);
            this.sinrMeasPucch5 = this._io.readBitsIntBe(24);
            this.sinrMeasPucch6 = this._io.readBitsIntBe(24);
            this.sinrMeasPucch7 = this._io.readBitsIntBe(24);
            this._io.alignToByte();
            this.deltaSinrMeasPusch0 = this._io.readU4be();
            this.deltaSinrMeasPusch1 = this._io.readU4be();
            this.deltaSinrMeasPusch2 = this._io.readU4be();
            this.deltaSinrMeasPusch3 = this._io.readU4be();
            this.deltaSinrMeasPusch4 = this._io.readU4be();
            this.deltaSinrMeasPusch5 = this._io.readU4be();
            this.deltaSinrMeasPusch6 = this._io.readU4be();
            this.deltaSinrMeasPusch7 = this._io.readU4be();

            this.aoa = this._io.readU2be();
            this.powerHeadroom = this._io.readU1();

            this.rankTx8 = this._io.readBitsIntBe(24);
            this.rankTx9 = this._io.readBitsIntBe(24);
            this.rankTx10 = this._io.readBitsIntBe(24);
            this.rankTx11 = this._io.readBitsIntBe(24);
            this._io.alignToByte();

            this.powerHeadroomPrbUsed = this._io.readU2be();

            this.rankReported2 = this._io.readBitsIntBe(24);
            this.rankReported3 = this._io.readBitsIntBe(24);
            this._io.alignToByte();

            this.lastRiReported = this._io.readU1();
            this.lastCqi1Reported = this._io.readU1();
            this.lastCqi2Reported = this._io.readU1();

            this.lastPuschNumPrbReported = this._io.readU1();
            this.lastPuschSinrReported = this._io.readU2be();
            this.lastPuschPowerPerPrbReported = this._io.readU2be();

            this.sinrMeasPusch8 = this._io.readBitsIntBe(24);

            this.rankTx12 = this._io.readBitsIntBe(24);
            this.rankTx13 = this._io.readBitsIntBe(24);

            this.homCqiReported0 = this._io.readBitsIntBe(24);
            this.homCqiReported1 = this._io.readBitsIntBe(24);
            this.homCqiReported2 = this._io.readBitsIntBe(24);
            this.homCqiReported3 = this._io.readBitsIntBe(24);
            this.homCqiReported4 = this._io.readBitsIntBe(24);
            this.homCqiReported5 = this._io.readBitsIntBe(24);
            this.homCqiReported6 = this._io.readBitsIntBe(24);
            this.homCqiReported7 = this._io.readBitsIntBe(24);
            this.homCqiReported8 = this._io.readBitsIntBe(24);
            this.homCqiReported9 = this._io.readBitsIntBe(24);
            this.homCqiReported10 = this._io.readBitsIntBe(24);
            this.homCqiReported11 = this._io.readBitsIntBe(24);
            this.homCqiReported12 = this._io.readBitsIntBe(24);
            this.homCqiReported13 = this._io.readBitsIntBe(24);
            this.homCqiReported14 = this._io.readBitsIntBe(24);
            this.homCqiReported15 = this._io.readBitsIntBe(24);

            this.homCqi2Reported0 = this._io.readBitsIntBe(24);
            this.homCqi2Reported1 = this._io.readBitsIntBe(24);
            this.homCqi2Reported2 = this._io.readBitsIntBe(24);
            this.homCqi2Reported3 = this._io.readBitsIntBe(24);
            this.homCqi2Reported4 = this._io.readBitsIntBe(24);
            this.homCqi2Reported5 = this._io.readBitsIntBe(24);
            this.homCqi2Reported6 = this._io.readBitsIntBe(24);
            this.homCqi2Reported7 = this._io.readBitsIntBe(24);
            this.homCqi2Reported8 = this._io.readBitsIntBe(24);
            this.homCqi2Reported9 = this._io.readBitsIntBe(24);
            this.homCqi2Reported10 = this._io.readBitsIntBe(24);
            this.homCqi2Reported11 = this._io.readBitsIntBe(24);
            this.homCqi2Reported12 = this._io.readBitsIntBe(24);
            this.homCqi2Reported13 = this._io.readBitsIntBe(24);
            this.homCqi2Reported14 = this._io.readBitsIntBe(24);
            this.homCqi2Reported15 = this._io.readBitsIntBe(24);

            this.homRankReported0 = this._io.readBitsIntBe(24);
            this.homRankReported1 = this._io.readBitsIntBe(24);
            this.homRankReported2 = this._io.readBitsIntBe(24);
            this.homRankReported3 = this._io.readBitsIntBe(24);

            this.cqi3Reported0 = this._io.readBitsIntBe(24);
            this.cqi3Reported1 = this._io.readBitsIntBe(24);
            this.cqi3Reported2 = this._io.readBitsIntBe(24);
            this.cqi3Reported3 = this._io.readBitsIntBe(24);
            this.cqi3Reported4 = this._io.readBitsIntBe(24);
            this.cqi3Reported5 = this._io.readBitsIntBe(24);
            this.cqi3Reported6 = this._io.readBitsIntBe(24);
            this.cqi3Reported7 = this._io.readBitsIntBe(24);
            this.cqi3Reported8 = this._io.readBitsIntBe(24);
            this.cqi3Reported9 = this._io.readBitsIntBe(24);
            this.cqi3Reported10 = this._io.readBitsIntBe(24);
            this.cqi3Reported11 = this._io.readBitsIntBe(24);
            this.cqi3Reported12 = this._io.readBitsIntBe(24);
            this.cqi3Reported13 = this._io.readBitsIntBe(24);
            this.cqi3Reported14 = this._io.readBitsIntBe(24);
            this.cqi3Reported15 = this._io.readBitsIntBe(24);

            this.cqi4Reported0 = this._io.readBitsIntBe(24);
            this.cqi4Reported1 = this._io.readBitsIntBe(24);
            this.cqi4Reported2 = this._io.readBitsIntBe(24);
            this.cqi4Reported3 = this._io.readBitsIntBe(24);
            this.cqi4Reported4 = this._io.readBitsIntBe(24);
            this.cqi4Reported5 = this._io.readBitsIntBe(24);
            this.cqi4Reported6 = this._io.readBitsIntBe(24);
            this.cqi4Reported7 = this._io.readBitsIntBe(24);
            this.cqi4Reported8 = this._io.readBitsIntBe(24);
            this.cqi4Reported9 = this._io.readBitsIntBe(24);
            this.cqi4Reported10 = this._io.readBitsIntBe(24);
            this.cqi4Reported11 = this._io.readBitsIntBe(24);
            this.cqi4Reported12 = this._io.readBitsIntBe(24);
            this.cqi4Reported13 = this._io.readBitsIntBe(24);
            this.cqi4Reported14 = this._io.readBitsIntBe(24);
            this.cqi4Reported15 = this._io.readBitsIntBe(24);

            this.homCqi3Reported0 = this._io.readBitsIntBe(24);
            this.homCqi3Reported1 = this._io.readBitsIntBe(24);
            this.homCqi3Reported2 = this._io.readBitsIntBe(24);
            this.homCqi3Reported3 = this._io.readBitsIntBe(24);
            this.homCqi3Reported4 = this._io.readBitsIntBe(24);
            this.homCqi3Reported5 = this._io.readBitsIntBe(24);
            this.homCqi3Reported6 = this._io.readBitsIntBe(24);
            this.homCqi3Reported7 = this._io.readBitsIntBe(24);
            this.homCqi3Reported8 = this._io.readBitsIntBe(24);
            this.homCqi3Reported9 = this._io.readBitsIntBe(24);
            this.homCqi3Reported10 = this._io.readBitsIntBe(24);
            this.homCqi3Reported11 = this._io.readBitsIntBe(24);
            this.homCqi3Reported12 = this._io.readBitsIntBe(24);
            this.homCqi3Reported13 = this._io.readBitsIntBe(24);
            this.homCqi3Reported14 = this._io.readBitsIntBe(24);
            this.homCqi3Reported15 = this._io.readBitsIntBe(24);

            this.homCqi4Reported0 = this._io.readBitsIntBe(24);
            this.homCqi4Reported1 = this._io.readBitsIntBe(24);
            this.homCqi4Reported2 = this._io.readBitsIntBe(24);
            this.homCqi4Reported3 = this._io.readBitsIntBe(24);
            this.homCqi4Reported4 = this._io.readBitsIntBe(24);
            this.homCqi4Reported5 = this._io.readBitsIntBe(24);
            this.homCqi4Reported6 = this._io.readBitsIntBe(24);
            this.homCqi4Reported7 = this._io.readBitsIntBe(24);
            this.homCqi4Reported8 = this._io.readBitsIntBe(24);
            this.homCqi4Reported9 = this._io.readBitsIntBe(24);
            this.homCqi4Reported10 = this._io.readBitsIntBe(24);
            this.homCqi4Reported11 = this._io.readBitsIntBe(24);
            this.homCqi4Reported12 = this._io.readBitsIntBe(24);
            this.homCqi4Reported13 = this._io.readBitsIntBe(24);
            this.homCqi4Reported14 = this._io.readBitsIntBe(24);
            this.homCqi4Reported15 = this._io.readBitsIntBe(24);
            this._io.alignToByte();

            this.plmnIndex = this._io.readU1();
            this.ueCategoryFlex = this._io.readU1();
            this.spidValue = this._io.readU2be();
            this.brCeLevel = this._io.readU1();
            this.uePowerClass = this._io.readU1();
            this.subscriberGroupId = this._io.readU1();
            this.endcStage = this._io.readU1();

            this.cqiReportedBr0 = this._io.readBitsIntBe(24);
            this.cqiReportedBr1 = this._io.readBitsIntBe(24);
            this.cqiReportedBr2 = this._io.readBitsIntBe(24);
            this.cqiReportedBr3 = this._io.readBitsIntBe(24);
            this.cqiReportedBr4 = this._io.readBitsIntBe(24);
            this.cqiReportedBr5 = this._io.readBitsIntBe(24);
            this.cqiReportedBr6 = this._io.readBitsIntBe(24);
            this.cqiReportedBr7 = this._io.readBitsIntBe(24);
            this.cqiReportedBr8 = this._io.readBitsIntBe(24);
            this.cqiReportedBr9 = this._io.readBitsIntBe(24);
            this.cqiReportedBr10 = this._io.readBitsIntBe(24);
            this.cqiReportedBr11 = this._io.readBitsIntBe(24);
            this.cqiReportedBr12 = this._io.readBitsIntBe(24);
            this.cqiReportedBr13 = this._io.readBitsIntBe(24);
            this.cqiReportedBr14 = this._io.readBitsIntBe(24);
            this.cqiReportedBr15 = this._io.readBitsIntBe(24);

            this.mpdcchOutLoopAdjDlBr0 = this._io.readBitsIntBe(24);
            this.mpdcchOutLoopAdjDlBr1 = this._io.readBitsIntBe(24);
            this.mpdcchOutLoopAdjDlBr2 = this._io.readBitsIntBe(24);
            this.mpdcchOutLoopAdjDlBr3 = this._io.readBitsIntBe(24);
            this.mpdcchOutLoopAdjDlBr4 = this._io.readBitsIntBe(24);
            this.mpdcchOutLoopAdjDlBr5 = this._io.readBitsIntBe(24);
            this.mpdcchOutLoopAdjDlBr6 = this._io.readBitsIntBe(24);
            this.mpdcchOutLoopAdjDlBr7 = this._io.readBitsIntBe(24);
            this.mpdcchOutLoopAdjDlBr8 = this._io.readBitsIntBe(24);
            this.mpdcchOutLoopAdjDlBr9 = this._io.readBitsIntBe(24);
            this.mpdcchOutLoopAdjDlBr10 = this._io.readBitsIntBe(24);
            this.mpdcchOutLoopAdjDlBr11 = this._io.readBitsIntBe(24);

            this.pdschOutLoopAdjDlBr0 = this._io.readBitsIntBe(24);
            this.pdschOutLoopAdjDlBr1 = this._io.readBitsIntBe(24);
            this.pdschOutLoopAdjDlBr2 = this._io.readBitsIntBe(24);
            this.pdschOutLoopAdjDlBr3 = this._io.readBitsIntBe(24);
            this.pdschOutLoopAdjDlBr4 = this._io.readBitsIntBe(24);
            this.pdschOutLoopAdjDlBr5 = this._io.readBitsIntBe(24);
            this.pdschOutLoopAdjDlBr6 = this._io.readBitsIntBe(24);
            this.pdschOutLoopAdjDlBr7 = this._io.readBitsIntBe(24);
            this.pdschOutLoopAdjDlBr8 = this._io.readBitsIntBe(24);
            this.pdschOutLoopAdjDlBr9 = this._io.readBitsIntBe(24);
            this.pdschOutLoopAdjDlBr10 = this._io.readBitsIntBe(24);
            this.pdschOutLoopAdjDlBr11 = this._io.readBitsIntBe(24);

            this.puschOutLoopAdjDlBr0 = this._io.readBitsIntBe(24);
            this.puschOutLoopAdjDlBr1 = this._io.readBitsIntBe(24);
            this.puschOutLoopAdjDlBr2 = this._io.readBitsIntBe(24);
            this.puschOutLoopAdjDlBr3 = this._io.readBitsIntBe(24);
            this.puschOutLoopAdjDlBr4 = this._io.readBitsIntBe(24);
            this.puschOutLoopAdjDlBr5 = this._io.readBitsIntBe(24);
            this.puschOutLoopAdjDlBr6 = this._io.readBitsIntBe(24);
            this.puschOutLoopAdjDlBr7 = this._io.readBitsIntBe(24);
            this.puschOutLoopAdjDlBr8 = this._io.readBitsIntBe(24);
            this.puschOutLoopAdjDlBr9 = this._io.readBitsIntBe(24);
            this.puschOutLoopAdjDlBr10 = this._io.readBitsIntBe(24);
            this.puschOutLoopAdjDlBr11 = this._io.readBitsIntBe(24);

            this.rankTx14 = this._io.readBitsIntBe(24);
            this.rankTx15 = this._io.readBitsIntBe(24);
            this._io.alignToByte();

            this.spare1 = new ArrayList<Integer>();
            for (int i = 0; i < 9; i++) {
                this.spare1.add(this._io.readU1());
            }
            this.sinrMeasPdcch0 = this._io.readU4be();
            this.sinrMeasPdcch1 = this._io.readU4be();
            this.sinrMeasPdcch2 = this._io.readU4be();
            this.sinrMeasPdcch3 = this._io.readU4be();
            this.sinrMeasPdcch4 = this._io.readU4be();
            this.sinrMeasPdcch5 = this._io.readU4be();
            this.sinrMeasPdcch6 = this._io.readU4be();
            this.sinrMeasPdcch7 = this._io.readU4be();
            this.sinrMeasPdcch8 = this._io.readU4be();
            this.sinrMeasPdcch9 = this._io.readU4be();
            this.sinrMeasPdcch10 = this._io.readU4be();
            this.sinrMeasPdcch11 = this._io.readU4be();

            this.sinrMeasPuschExtend0 = this._io.readBitsIntBe(24);
            this.sinrMeasPuschExtend1 = this._io.readBitsIntBe(24);
            this.sinrMeasPuschExtend2 = this._io.readBitsIntBe(24);
            this.sinrMeasPuschExtend3 = this._io.readBitsIntBe(24);
            this.sinrMeasPuschExtend4 = this._io.readBitsIntBe(24);
            this.sinrMeasPuschExtend5 = this._io.readBitsIntBe(24);
            this.sinrMeasPuschExtend6 = this._io.readBitsIntBe(24);
            this.sinrMeasPuschExtend7 = this._io.readBitsIntBe(24);
            this.sinrMeasPuschExtend8 = this._io.readBitsIntBe(24);
            this.sinrMeasPuschExtend9 = this._io.readBitsIntBe(24);
            this.sinrMeasPuschExtend10 = this._io.readBitsIntBe(24);
            this.sinrMeasPuschExtend11 = this._io.readBitsIntBe(24);
            this.dtvmDtxInd = this._io.readBitsIntBe(24);
            this.utvmDtxInd = this._io.readBitsIntBe(24);
            this.undefinedData = this._io.readBytes((bodyLength() - 879));
        }

        private int timestampHour;
        private int timestampMinute;
        private int timestampSecond;
        private int timestampMillisec;
        private long scannerId;
        private int rbsModuleId;
        private long globalCellId;
        private long enbs1apid;
        private long mmes1apid;
        private long gummei;
        private long racUeRef;
        private long traceRecordingSessionReference;
        private long rankTx0;
        private long rankTx1;
        private long rankTx2;
        private long rankTx3;
        private long rankTx4;
        private long rankTx5;
        private long rankTx6;
        private long rankTx7;
        private long cqiReported0;
        private long cqiReported1;
        private long cqiReported2;
        private long cqiReported3;
        private long cqiReported4;
        private long cqiReported5;
        private long cqiReported6;
        private long cqiReported7;
        private long cqiReported8;
        private long cqiReported9;
        private long cqiReported10;
        private long cqiReported11;
        private long cqiReported12;
        private long cqiReported13;
        private long cqiReported14;
        private long cqiReported15;
        private long rankReported0;
        private long rankReported1;
        private long tbspwrrestricted;
        private long tbspwrunrestricted;
        private long cqi2Reported0;
        private long cqi2Reported1;
        private long cqi2Reported2;
        private long cqi2Reported3;
        private long cqi2Reported4;
        private long cqi2Reported5;
        private long cqi2Reported6;
        private long cqi2Reported7;
        private long cqi2Reported8;
        private long cqi2Reported9;
        private long cqi2Reported10;
        private long cqi2Reported11;
        private long cqi2Reported12;
        private long cqi2Reported13;
        private long cqi2Reported14;
        private long cqi2Reported15;
        private long outLoopAdjDl0;
        private long outLoopAdjDl1;
        private long outLoopAdjDl2;
        private long outLoopAdjDl3;
        private long outLoopAdjDl4;
        private long outLoopAdjDl5;
        private long outLoopAdjDl6;
        private long outLoopAdjDl7;
        private long sinrMeasPusch0;
        private long sinrMeasPusch1;
        private long sinrMeasPusch2;
        private long sinrMeasPusch3;
        private long sinrMeasPusch4;
        private long sinrMeasPusch5;
        private long sinrMeasPusch6;
        private long sinrMeasPusch7;
        private long sinrMeasPucch0;
        private long sinrMeasPucch1;
        private long sinrMeasPucch2;
        private long sinrMeasPucch3;
        private long sinrMeasPucch4;
        private long sinrMeasPucch5;
        private long sinrMeasPucch6;
        private long sinrMeasPucch7;
        private long deltaSinrMeasPusch0;
        private long deltaSinrMeasPusch1;
        private long deltaSinrMeasPusch2;
        private long deltaSinrMeasPusch3;
        private long deltaSinrMeasPusch4;
        private long deltaSinrMeasPusch5;
        private long deltaSinrMeasPusch6;
        private long deltaSinrMeasPusch7;
        private int aoa;
        private int powerHeadroom;
        private long rankTx8;
        private long rankTx9;
        private long rankTx10;
        private long rankTx11;
        private int powerHeadroomPrbUsed;
        private long rankReported2;
        private long rankReported3;
        private int lastRiReported;
        private int lastCqi1Reported;
        private int lastCqi2Reported;
        private int lastPuschNumPrbReported;
        private int lastPuschSinrReported;
        private int lastPuschPowerPerPrbReported;
        private long sinrMeasPusch8;
        private long rankTx12;
        private long rankTx13;
        private long homCqiReported0;
        private long homCqiReported1;
        private long homCqiReported2;
        private long homCqiReported3;
        private long homCqiReported4;
        private long homCqiReported5;
        private long homCqiReported6;
        private long homCqiReported7;
        private long homCqiReported8;
        private long homCqiReported9;
        private long homCqiReported10;
        private long homCqiReported11;
        private long homCqiReported12;
        private long homCqiReported13;
        private long homCqiReported14;
        private long homCqiReported15;
        private long homCqi2Reported0;
        private long homCqi2Reported1;
        private long homCqi2Reported2;
        private long homCqi2Reported3;
        private long homCqi2Reported4;
        private long homCqi2Reported5;
        private long homCqi2Reported6;
        private long homCqi2Reported7;
        private long homCqi2Reported8;
        private long homCqi2Reported9;
        private long homCqi2Reported10;
        private long homCqi2Reported11;
        private long homCqi2Reported12;
        private long homCqi2Reported13;
        private long homCqi2Reported14;
        private long homCqi2Reported15;
        private long homRankReported0;
        private long homRankReported1;
        private long homRankReported2;
        private long homRankReported3;
        private long cqi3Reported0;
        private long cqi3Reported1;
        private long cqi3Reported2;
        private long cqi3Reported3;
        private long cqi3Reported4;
        private long cqi3Reported5;
        private long cqi3Reported6;
        private long cqi3Reported7;
        private long cqi3Reported8;
        private long cqi3Reported9;
        private long cqi3Reported10;
        private long cqi3Reported11;
        private long cqi3Reported12;
        private long cqi3Reported13;
        private long cqi3Reported14;
        private long cqi3Reported15;
        private long cqi4Reported0;
        private long cqi4Reported1;
        private long cqi4Reported2;
        private long cqi4Reported3;
        private long cqi4Reported4;
        private long cqi4Reported5;
        private long cqi4Reported6;
        private long cqi4Reported7;
        private long cqi4Reported8;
        private long cqi4Reported9;
        private long cqi4Reported10;
        private long cqi4Reported11;
        private long cqi4Reported12;
        private long cqi4Reported13;
        private long cqi4Reported14;
        private long cqi4Reported15;
        private long homCqi3Reported0;
        private long homCqi3Reported1;
        private long homCqi3Reported2;
        private long homCqi3Reported3;
        private long homCqi3Reported4;
        private long homCqi3Reported5;
        private long homCqi3Reported6;
        private long homCqi3Reported7;
        private long homCqi3Reported8;
        private long homCqi3Reported9;
        private long homCqi3Reported10;
        private long homCqi3Reported11;
        private long homCqi3Reported12;
        private long homCqi3Reported13;
        private long homCqi3Reported14;
        private long homCqi3Reported15;
        private long homCqi4Reported0;
        private long homCqi4Reported1;
        private long homCqi4Reported2;
        private long homCqi4Reported3;
        private long homCqi4Reported4;
        private long homCqi4Reported5;
        private long homCqi4Reported6;
        private long homCqi4Reported7;
        private long homCqi4Reported8;
        private long homCqi4Reported9;
        private long homCqi4Reported10;
        private long homCqi4Reported11;
        private long homCqi4Reported12;
        private long homCqi4Reported13;
        private long homCqi4Reported14;
        private long homCqi4Reported15;
        private int plmnIndex;
        private int ueCategoryFlex;
        private int spidValue;
        private int brCeLevel;
        private int uePowerClass;
        private int subscriberGroupId;
        private int endcStage;
        private long cqiReportedBr0;
        private long cqiReportedBr1;
        private long cqiReportedBr2;
        private long cqiReportedBr3;
        private long cqiReportedBr4;
        private long cqiReportedBr5;
        private long cqiReportedBr6;
        private long cqiReportedBr7;
        private long cqiReportedBr8;
        private long cqiReportedBr9;
        private long cqiReportedBr10;
        private long cqiReportedBr11;
        private long cqiReportedBr12;
        private long cqiReportedBr13;
        private long cqiReportedBr14;
        private long cqiReportedBr15;
        private long mpdcchOutLoopAdjDlBr0;
        private long mpdcchOutLoopAdjDlBr1;
        private long mpdcchOutLoopAdjDlBr2;
        private long mpdcchOutLoopAdjDlBr3;
        private long mpdcchOutLoopAdjDlBr4;
        private long mpdcchOutLoopAdjDlBr5;
        private long mpdcchOutLoopAdjDlBr6;
        private long mpdcchOutLoopAdjDlBr7;
        private long mpdcchOutLoopAdjDlBr8;
        private long mpdcchOutLoopAdjDlBr9;
        private long mpdcchOutLoopAdjDlBr10;
        private long mpdcchOutLoopAdjDlBr11;
        private long pdschOutLoopAdjDlBr0;
        private long pdschOutLoopAdjDlBr1;
        private long pdschOutLoopAdjDlBr2;
        private long pdschOutLoopAdjDlBr3;
        private long pdschOutLoopAdjDlBr4;
        private long pdschOutLoopAdjDlBr5;
        private long pdschOutLoopAdjDlBr6;
        private long pdschOutLoopAdjDlBr7;
        private long pdschOutLoopAdjDlBr8;
        private long pdschOutLoopAdjDlBr9;
        private long pdschOutLoopAdjDlBr10;
        private long pdschOutLoopAdjDlBr11;
        private long puschOutLoopAdjDlBr0;
        private long puschOutLoopAdjDlBr1;
        private long puschOutLoopAdjDlBr2;
        private long puschOutLoopAdjDlBr3;
        private long puschOutLoopAdjDlBr4;
        private long puschOutLoopAdjDlBr5;
        private long puschOutLoopAdjDlBr6;
        private long puschOutLoopAdjDlBr7;
        private long puschOutLoopAdjDlBr8;
        private long puschOutLoopAdjDlBr9;
        private long puschOutLoopAdjDlBr10;
        private long puschOutLoopAdjDlBr11;
        private long rankTx14;
        private long rankTx15;
        private ArrayList<Integer> spare1;
        private long sinrMeasPdcch0;
        private long sinrMeasPdcch1;
        private long sinrMeasPdcch2;
        private long sinrMeasPdcch3;
        private long sinrMeasPdcch4;
        private long sinrMeasPdcch5;
        private long sinrMeasPdcch6;
        private long sinrMeasPdcch7;
        private long sinrMeasPdcch8;
        private long sinrMeasPdcch9;
        private long sinrMeasPdcch10;
        private long sinrMeasPdcch11;
        private long sinrMeasPuschExtend0;
        private long sinrMeasPuschExtend1;
        private long sinrMeasPuschExtend2;
        private long sinrMeasPuschExtend3;
        private long sinrMeasPuschExtend4;
        private long sinrMeasPuschExtend5;
        private long sinrMeasPuschExtend6;
        private long sinrMeasPuschExtend7;
        private long sinrMeasPuschExtend8;
        private long sinrMeasPuschExtend9;
        private long sinrMeasPuschExtend10;
        private long sinrMeasPuschExtend11;
        private long dtvmDtxInd;
        private long utvmDtxInd;
        private byte[] undefinedData;
        private int bodyLength;
        private EricssonEventFile _root;
        private EricssonEventFile.TEventRecord _parent;

        public int timestampHour() {
            return timestampHour;
        }

        public int timestampMinute() {
            return timestampMinute;
        }

        public int timestampSecond() {
            return timestampSecond;
        }

        public int timestampMillisec() {
            return timestampMillisec;
        }

        public long scannerId() {
            return scannerId;
        }

        public int rbsModuleId() {
            return rbsModuleId;
        }

        public long globalCellId() {
            return globalCellId;
        }

        public long enbs1apid() {
            return enbs1apid;
        }

        public long mmes1apid() {
            return mmes1apid;
        }

        public long gummei() {
            return gummei;
        }

        public long racUeRef() {
            return racUeRef;
        }

        public long traceRecordingSessionReference() {
            return traceRecordingSessionReference;
        }

        public long rankTx0() {
            return rankTx0;
        }

        public long rankTx1() {
            return rankTx1;
        }

        public long rankTx2() {
            return rankTx2;
        }

        public long rankTx3() {
            return rankTx3;
        }

        public long rankTx4() {
            return rankTx4;
        }

        public long rankTx5() {
            return rankTx5;
        }

        public long rankTx6() {
            return rankTx6;
        }

        public long rankTx7() {
            return rankTx7;
        }

        public long cqiReported0() {
            return cqiReported0;
        }

        public long cqiReported1() {
            return cqiReported1;
        }

        public long cqiReported2() {
            return cqiReported2;
        }

        public long cqiReported3() {
            return cqiReported3;
        }

        public long cqiReported4() {
            return cqiReported4;
        }

        public long cqiReported5() {
            return cqiReported5;
        }

        public long cqiReported6() {
            return cqiReported6;
        }

        public long cqiReported7() {
            return cqiReported7;
        }

        public long cqiReported8() {
            return cqiReported8;
        }

        public long cqiReported9() {
            return cqiReported9;
        }

        public long cqiReported10() {
            return cqiReported10;
        }

        public long cqiReported11() {
            return cqiReported11;
        }

        public long cqiReported12() {
            return cqiReported12;
        }

        public long cqiReported13() {
            return cqiReported13;
        }

        public long cqiReported14() {
            return cqiReported14;
        }

        public long cqiReported15() {
            return cqiReported15;
        }

        public long rankReported0() {
            return rankReported0;
        }

        public long rankReported1() {
            return rankReported1;
        }

        public long tbspwrrestricted() {
            return tbspwrrestricted;
        }

        public long tbspwrunrestricted() {
            return tbspwrunrestricted;
        }

        public long cqi2Reported0() {
            return cqi2Reported0;
        }

        public long cqi2Reported1() {
            return cqi2Reported1;
        }

        public long cqi2Reported2() {
            return cqi2Reported2;
        }

        public long cqi2Reported3() {
            return cqi2Reported3;
        }

        public long cqi2Reported4() {
            return cqi2Reported4;
        }

        public long cqi2Reported5() {
            return cqi2Reported5;
        }

        public long cqi2Reported6() {
            return cqi2Reported6;
        }

        public long cqi2Reported7() {
            return cqi2Reported7;
        }

        public long cqi2Reported8() {
            return cqi2Reported8;
        }

        public long cqi2Reported9() {
            return cqi2Reported9;
        }

        public long cqi2Reported10() {
            return cqi2Reported10;
        }

        public long cqi2Reported11() {
            return cqi2Reported11;
        }

        public long cqi2Reported12() {
            return cqi2Reported12;
        }

        public long cqi2Reported13() {
            return cqi2Reported13;
        }

        public long cqi2Reported14() {
            return cqi2Reported14;
        }

        public long cqi2Reported15() {
            return cqi2Reported15;
        }

        public long outLoopAdjDl0() {
            return outLoopAdjDl0;
        }

        public long outLoopAdjDl1() {
            return outLoopAdjDl1;
        }

        public long outLoopAdjDl2() {
            return outLoopAdjDl2;
        }

        public long outLoopAdjDl3() {
            return outLoopAdjDl3;
        }

        public long outLoopAdjDl4() {
            return outLoopAdjDl4;
        }

        public long outLoopAdjDl5() {
            return outLoopAdjDl5;
        }

        public long outLoopAdjDl6() {
            return outLoopAdjDl6;
        }

        public long outLoopAdjDl7() {
            return outLoopAdjDl7;
        }

        public long sinrMeasPusch0() {
            return sinrMeasPusch0;
        }

        public long sinrMeasPusch1() {
            return sinrMeasPusch1;
        }

        public long sinrMeasPusch2() {
            return sinrMeasPusch2;
        }

        public long sinrMeasPusch3() {
            return sinrMeasPusch3;
        }

        public long sinrMeasPusch4() {
            return sinrMeasPusch4;
        }

        public long sinrMeasPusch5() {
            return sinrMeasPusch5;
        }

        public long sinrMeasPusch6() {
            return sinrMeasPusch6;
        }

        public long sinrMeasPusch7() {
            return sinrMeasPusch7;
        }

        public long sinrMeasPucch0() {
            return sinrMeasPucch0;
        }

        public long sinrMeasPucch1() {
            return sinrMeasPucch1;
        }

        public long sinrMeasPucch2() {
            return sinrMeasPucch2;
        }

        public long sinrMeasPucch3() {
            return sinrMeasPucch3;
        }

        public long sinrMeasPucch4() {
            return sinrMeasPucch4;
        }

        public long sinrMeasPucch5() {
            return sinrMeasPucch5;
        }

        public long sinrMeasPucch6() {
            return sinrMeasPucch6;
        }

        public long sinrMeasPucch7() {
            return sinrMeasPucch7;
        }

        public long deltaSinrMeasPusch0() {
            return deltaSinrMeasPusch0;
        }

        public long deltaSinrMeasPusch1() {
            return deltaSinrMeasPusch1;
        }

        public long deltaSinrMeasPusch2() {
            return deltaSinrMeasPusch2;
        }

        public long deltaSinrMeasPusch3() {
            return deltaSinrMeasPusch3;
        }

        public long deltaSinrMeasPusch4() {
            return deltaSinrMeasPusch4;
        }

        public long deltaSinrMeasPusch5() {
            return deltaSinrMeasPusch5;
        }

        public long deltaSinrMeasPusch6() {
            return deltaSinrMeasPusch6;
        }

        public long deltaSinrMeasPusch7() {
            return deltaSinrMeasPusch7;
        }

        public int aoa() {
            return aoa;
        }

        public int powerHeadroom() {
            return powerHeadroom;
        }

        public long rankTx8() {
            return rankTx8;
        }

        public long rankTx9() {
            return rankTx9;
        }

        public long rankTx10() {
            return rankTx10;
        }

        public long rankTx11() {
            return rankTx11;
        }

        public int powerHeadroomPrbUsed() {
            return powerHeadroomPrbUsed;
        }

        public long rankReported2() {
            return rankReported2;
        }

        public long rankReported3() {
            return rankReported3;
        }

        public int lastRiReported() {
            return lastRiReported;
        }

        public int lastCqi1Reported() {
            return lastCqi1Reported;
        }

        public int lastCqi2Reported() {
            return lastCqi2Reported;
        }

        public int lastPuschNumPrbReported() {
            return lastPuschNumPrbReported;
        }

        public int lastPuschSinrReported() {
            return lastPuschSinrReported;
        }

        public int lastPuschPowerPerPrbReported() {
            return lastPuschPowerPerPrbReported;
        }

        public long sinrMeasPusch8() {
            return sinrMeasPusch8;
        }

        public long rankTx12() {
            return rankTx12;
        }

        public long rankTx13() {
            return rankTx13;
        }

        public long homCqiReported0() {
            return homCqiReported0;
        }

        public long homCqiReported1() {
            return homCqiReported1;
        }

        public long homCqiReported2() {
            return homCqiReported2;
        }

        public long homCqiReported3() {
            return homCqiReported3;
        }

        public long homCqiReported4() {
            return homCqiReported4;
        }

        public long homCqiReported5() {
            return homCqiReported5;
        }

        public long homCqiReported6() {
            return homCqiReported6;
        }

        public long homCqiReported7() {
            return homCqiReported7;
        }

        public long homCqiReported8() {
            return homCqiReported8;
        }

        public long homCqiReported9() {
            return homCqiReported9;
        }

        public long homCqiReported10() {
            return homCqiReported10;
        }

        public long homCqiReported11() {
            return homCqiReported11;
        }

        public long homCqiReported12() {
            return homCqiReported12;
        }

        public long homCqiReported13() {
            return homCqiReported13;
        }

        public long homCqiReported14() {
            return homCqiReported14;
        }

        public long homCqiReported15() {
            return homCqiReported15;
        }

        public long homCqi2Reported0() {
            return homCqi2Reported0;
        }

        public long homCqi2Reported1() {
            return homCqi2Reported1;
        }

        public long homCqi2Reported2() {
            return homCqi2Reported2;
        }

        public long homCqi2Reported3() {
            return homCqi2Reported3;
        }

        public long homCqi2Reported4() {
            return homCqi2Reported4;
        }

        public long homCqi2Reported5() {
            return homCqi2Reported5;
        }

        public long homCqi2Reported6() {
            return homCqi2Reported6;
        }

        public long homCqi2Reported7() {
            return homCqi2Reported7;
        }

        public long homCqi2Reported8() {
            return homCqi2Reported8;
        }

        public long homCqi2Reported9() {
            return homCqi2Reported9;
        }

        public long homCqi2Reported10() {
            return homCqi2Reported10;
        }

        public long homCqi2Reported11() {
            return homCqi2Reported11;
        }

        public long homCqi2Reported12() {
            return homCqi2Reported12;
        }

        public long homCqi2Reported13() {
            return homCqi2Reported13;
        }

        public long homCqi2Reported14() {
            return homCqi2Reported14;
        }

        public long homCqi2Reported15() {
            return homCqi2Reported15;
        }

        public long homRankReported0() {
            return homRankReported0;
        }

        public long homRankReported1() {
            return homRankReported1;
        }

        public long homRankReported2() {
            return homRankReported2;
        }

        public long homRankReported3() {
            return homRankReported3;
        }

        public long cqi3Reported0() {
            return cqi3Reported0;
        }

        public long cqi3Reported1() {
            return cqi3Reported1;
        }

        public long cqi3Reported2() {
            return cqi3Reported2;
        }

        public long cqi3Reported3() {
            return cqi3Reported3;
        }

        public long cqi3Reported4() {
            return cqi3Reported4;
        }

        public long cqi3Reported5() {
            return cqi3Reported5;
        }

        public long cqi3Reported6() {
            return cqi3Reported6;
        }

        public long cqi3Reported7() {
            return cqi3Reported7;
        }

        public long cqi3Reported8() {
            return cqi3Reported8;
        }

        public long cqi3Reported9() {
            return cqi3Reported9;
        }

        public long cqi3Reported10() {
            return cqi3Reported10;
        }

        public long cqi3Reported11() {
            return cqi3Reported11;
        }

        public long cqi3Reported12() {
            return cqi3Reported12;
        }

        public long cqi3Reported13() {
            return cqi3Reported13;
        }

        public long cqi3Reported14() {
            return cqi3Reported14;
        }

        public long cqi3Reported15() {
            return cqi3Reported15;
        }

        public long cqi4Reported0() {
            return cqi4Reported0;
        }

        public long cqi4Reported1() {
            return cqi4Reported1;
        }

        public long cqi4Reported2() {
            return cqi4Reported2;
        }

        public long cqi4Reported3() {
            return cqi4Reported3;
        }

        public long cqi4Reported4() {
            return cqi4Reported4;
        }

        public long cqi4Reported5() {
            return cqi4Reported5;
        }

        public long cqi4Reported6() {
            return cqi4Reported6;
        }

        public long cqi4Reported7() {
            return cqi4Reported7;
        }

        public long cqi4Reported8() {
            return cqi4Reported8;
        }

        public long cqi4Reported9() {
            return cqi4Reported9;
        }

        public long cqi4Reported10() {
            return cqi4Reported10;
        }

        public long cqi4Reported11() {
            return cqi4Reported11;
        }

        public long cqi4Reported12() {
            return cqi4Reported12;
        }

        public long cqi4Reported13() {
            return cqi4Reported13;
        }

        public long cqi4Reported14() {
            return cqi4Reported14;
        }

        public long cqi4Reported15() {
            return cqi4Reported15;
        }

        public long homCqi3Reported0() {
            return homCqi3Reported0;
        }

        public long homCqi3Reported1() {
            return homCqi3Reported1;
        }

        public long homCqi3Reported2() {
            return homCqi3Reported2;
        }

        public long homCqi3Reported3() {
            return homCqi3Reported3;
        }

        public long homCqi3Reported4() {
            return homCqi3Reported4;
        }

        public long homCqi3Reported5() {
            return homCqi3Reported5;
        }

        public long homCqi3Reported6() {
            return homCqi3Reported6;
        }

        public long homCqi3Reported7() {
            return homCqi3Reported7;
        }

        public long homCqi3Reported8() {
            return homCqi3Reported8;
        }

        public long homCqi3Reported9() {
            return homCqi3Reported9;
        }

        public long homCqi3Reported10() {
            return homCqi3Reported10;
        }

        public long homCqi3Reported11() {
            return homCqi3Reported11;
        }

        public long homCqi3Reported12() {
            return homCqi3Reported12;
        }

        public long homCqi3Reported13() {
            return homCqi3Reported13;
        }

        public long homCqi3Reported14() {
            return homCqi3Reported14;
        }

        public long homCqi3Reported15() {
            return homCqi3Reported15;
        }

        public long homCqi4Reported0() {
            return homCqi4Reported0;
        }

        public long homCqi4Reported1() {
            return homCqi4Reported1;
        }

        public long homCqi4Reported2() {
            return homCqi4Reported2;
        }

        public long homCqi4Reported3() {
            return homCqi4Reported3;
        }

        public long homCqi4Reported4() {
            return homCqi4Reported4;
        }

        public long homCqi4Reported5() {
            return homCqi4Reported5;
        }

        public long homCqi4Reported6() {
            return homCqi4Reported6;
        }

        public long homCqi4Reported7() {
            return homCqi4Reported7;
        }

        public long homCqi4Reported8() {
            return homCqi4Reported8;
        }

        public long homCqi4Reported9() {
            return homCqi4Reported9;
        }

        public long homCqi4Reported10() {
            return homCqi4Reported10;
        }

        public long homCqi4Reported11() {
            return homCqi4Reported11;
        }

        public long homCqi4Reported12() {
            return homCqi4Reported12;
        }

        public long homCqi4Reported13() {
            return homCqi4Reported13;
        }

        public long homCqi4Reported14() {
            return homCqi4Reported14;
        }

        public long homCqi4Reported15() {
            return homCqi4Reported15;
        }

        public int plmnIndex() {
            return plmnIndex;
        }

        public int ueCategoryFlex() {
            return ueCategoryFlex;
        }

        public int spidValue() {
            return spidValue;
        }

        public int brCeLevel() {
            return brCeLevel;
        }

        public int uePowerClass() {
            return uePowerClass;
        }

        public int subscriberGroupId() {
            return subscriberGroupId;
        }

        public int endcStage() {
            return endcStage;
        }

        public long cqiReportedBr0() {
            return cqiReportedBr0;
        }

        public long cqiReportedBr1() {
            return cqiReportedBr1;
        }

        public long cqiReportedBr2() {
            return cqiReportedBr2;
        }

        public long cqiReportedBr3() {
            return cqiReportedBr3;
        }

        public long cqiReportedBr4() {
            return cqiReportedBr4;
        }

        public long cqiReportedBr5() {
            return cqiReportedBr5;
        }

        public long cqiReportedBr6() {
            return cqiReportedBr6;
        }

        public long cqiReportedBr7() {
            return cqiReportedBr7;
        }

        public long cqiReportedBr8() {
            return cqiReportedBr8;
        }

        public long cqiReportedBr9() {
            return cqiReportedBr9;
        }

        public long cqiReportedBr10() {
            return cqiReportedBr10;
        }

        public long cqiReportedBr11() {
            return cqiReportedBr11;
        }

        public long cqiReportedBr12() {
            return cqiReportedBr12;
        }

        public long cqiReportedBr13() {
            return cqiReportedBr13;
        }

        public long cqiReportedBr14() {
            return cqiReportedBr14;
        }

        public long cqiReportedBr15() {
            return cqiReportedBr15;
        }

        public long mpdcchOutLoopAdjDlBr0() {
            return mpdcchOutLoopAdjDlBr0;
        }

        public long mpdcchOutLoopAdjDlBr1() {
            return mpdcchOutLoopAdjDlBr1;
        }

        public long mpdcchOutLoopAdjDlBr2() {
            return mpdcchOutLoopAdjDlBr2;
        }

        public long mpdcchOutLoopAdjDlBr3() {
            return mpdcchOutLoopAdjDlBr3;
        }

        public long mpdcchOutLoopAdjDlBr4() {
            return mpdcchOutLoopAdjDlBr4;
        }

        public long mpdcchOutLoopAdjDlBr5() {
            return mpdcchOutLoopAdjDlBr5;
        }

        public long mpdcchOutLoopAdjDlBr6() {
            return mpdcchOutLoopAdjDlBr6;
        }

        public long mpdcchOutLoopAdjDlBr7() {
            return mpdcchOutLoopAdjDlBr7;
        }

        public long mpdcchOutLoopAdjDlBr8() {
            return mpdcchOutLoopAdjDlBr8;
        }

        public long mpdcchOutLoopAdjDlBr9() {
            return mpdcchOutLoopAdjDlBr9;
        }

        public long mpdcchOutLoopAdjDlBr10() {
            return mpdcchOutLoopAdjDlBr10;
        }

        public long mpdcchOutLoopAdjDlBr11() {
            return mpdcchOutLoopAdjDlBr11;
        }

        public long pdschOutLoopAdjDlBr0() {
            return pdschOutLoopAdjDlBr0;
        }

        public long pdschOutLoopAdjDlBr1() {
            return pdschOutLoopAdjDlBr1;
        }

        public long pdschOutLoopAdjDlBr2() {
            return pdschOutLoopAdjDlBr2;
        }

        public long pdschOutLoopAdjDlBr3() {
            return pdschOutLoopAdjDlBr3;
        }

        public long pdschOutLoopAdjDlBr4() {
            return pdschOutLoopAdjDlBr4;
        }

        public long pdschOutLoopAdjDlBr5() {
            return pdschOutLoopAdjDlBr5;
        }

        public long pdschOutLoopAdjDlBr6() {
            return pdschOutLoopAdjDlBr6;
        }

        public long pdschOutLoopAdjDlBr7() {
            return pdschOutLoopAdjDlBr7;
        }

        public long pdschOutLoopAdjDlBr8() {
            return pdschOutLoopAdjDlBr8;
        }

        public long pdschOutLoopAdjDlBr9() {
            return pdschOutLoopAdjDlBr9;
        }

        public long pdschOutLoopAdjDlBr10() {
            return pdschOutLoopAdjDlBr10;
        }

        public long pdschOutLoopAdjDlBr11() {
            return pdschOutLoopAdjDlBr11;
        }

        public long puschOutLoopAdjDlBr0() {
            return puschOutLoopAdjDlBr0;
        }

        public long puschOutLoopAdjDlBr1() {
            return puschOutLoopAdjDlBr1;
        }

        public long puschOutLoopAdjDlBr2() {
            return puschOutLoopAdjDlBr2;
        }

        public long puschOutLoopAdjDlBr3() {
            return puschOutLoopAdjDlBr3;
        }

        public long puschOutLoopAdjDlBr4() {
            return puschOutLoopAdjDlBr4;
        }

        public long puschOutLoopAdjDlBr5() {
            return puschOutLoopAdjDlBr5;
        }

        public long puschOutLoopAdjDlBr6() {
            return puschOutLoopAdjDlBr6;
        }

        public long puschOutLoopAdjDlBr7() {
            return puschOutLoopAdjDlBr7;
        }

        public long puschOutLoopAdjDlBr8() {
            return puschOutLoopAdjDlBr8;
        }

        public long puschOutLoopAdjDlBr9() {
            return puschOutLoopAdjDlBr9;
        }

        public long puschOutLoopAdjDlBr10() {
            return puschOutLoopAdjDlBr10;
        }

        public long puschOutLoopAdjDlBr11() {
            return puschOutLoopAdjDlBr11;
        }

        public long rankTx14() {
            return rankTx14;
        }

        public long rankTx15() {
            return rankTx15;
        }

        public ArrayList<Integer> spare1() {
            return spare1;
        }

        public long sinrMeasPdcch0() {
            return sinrMeasPdcch0;
        }

        public long sinrMeasPdcch1() {
            return sinrMeasPdcch1;
        }

        public long sinrMeasPdcch2() {
            return sinrMeasPdcch2;
        }

        public long sinrMeasPdcch3() {
            return sinrMeasPdcch3;
        }

        public long sinrMeasPdcch4() {
            return sinrMeasPdcch4;
        }

        public long sinrMeasPdcch5() {
            return sinrMeasPdcch5;
        }

        public long sinrMeasPdcch6() {
            return sinrMeasPdcch6;
        }

        public long sinrMeasPdcch7() {
            return sinrMeasPdcch7;
        }

        public long sinrMeasPdcch8() {
            return sinrMeasPdcch8;
        }

        public long sinrMeasPdcch9() {
            return sinrMeasPdcch9;
        }

        public long sinrMeasPdcch10() {
            return sinrMeasPdcch10;
        }

        public long sinrMeasPdcch11() {
            return sinrMeasPdcch11;
        }

        public long sinrMeasPuschExtend0() {
            return sinrMeasPuschExtend0;
        }

        public long sinrMeasPuschExtend1() {
            return sinrMeasPuschExtend1;
        }

        public long sinrMeasPuschExtend2() {
            return sinrMeasPuschExtend2;
        }

        public long sinrMeasPuschExtend3() {
            return sinrMeasPuschExtend3;
        }

        public long sinrMeasPuschExtend4() {
            return sinrMeasPuschExtend4;
        }

        public long sinrMeasPuschExtend5() {
            return sinrMeasPuschExtend5;
        }

        public long sinrMeasPuschExtend6() {
            return sinrMeasPuschExtend6;
        }

        public long sinrMeasPuschExtend7() {
            return sinrMeasPuschExtend7;
        }

        public long sinrMeasPuschExtend8() {
            return sinrMeasPuschExtend8;
        }

        public long sinrMeasPuschExtend9() {
            return sinrMeasPuschExtend9;
        }

        public long sinrMeasPuschExtend10() {
            return sinrMeasPuschExtend10;
        }

        public long sinrMeasPuschExtend11() {
            return sinrMeasPuschExtend11;
        }

        public long dtvmDtxInd() {
            return dtvmDtxInd;
        }

        public long utvmDtxInd() {
            return utvmDtxInd;
        }

        public byte[] undefinedData() {
            return undefinedData;
        }

        public int bodyLength() {
            return bodyLength;
        }

        public EricssonEventFile _root() {
            return _root;
        }

        public EricssonEventFile.TEventRecord _parent() {
            return _parent;
        }

    }

    public static class TEvent3113Body extends KaitaiStruct {
        public TEvent3113Body(KaitaiStream _io, int bodyLength) {
            this(_io, null, null, bodyLength);
        }

        public TEvent3113Body(KaitaiStream _io, EricssonEventFile.TEventRecord _parent, int bodyLength) {
            this(_io, _parent, null, bodyLength);
        }

        public TEvent3113Body(KaitaiStream _io, EricssonEventFile.TEventRecord _parent, EricssonEventFile _root, int bodyLength) {
            super(_io);
            this._parent = _parent;
            this._root = _root;
            this.bodyLength = bodyLength;
            _read();
        }

        private void _read() {
            this.timestampHour = this._io.readU1();
            this.timestampMinute = this._io.readU1();
            this.timestampSecond = this._io.readU1();
            this.timestampMillisec = this._io.readU2be();
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
            this.traceRecordingSessionReference = this._io.readBitsIntBe(24);
            this._io.alignToByte();
            this.mdtM2UePowerHeadroom0 = this._io.readU1();
            this.mdtM2UePowerHeadroom1 = this._io.readU1();
            this.mdtM2UePowerHeadroom2 = this._io.readU1();
            this.mdtM2UePowerHeadroom3 = this._io.readU1();
            this.mdtM2UePowerHeadroom4 = this._io.readU1();
            this.mdtM2UePowerHeadroom5 = this._io.readU1();
            this.mdtM2UePowerHeadroom6 = this._io.readU1();
            this.mdtM2UePowerHeadroom7 = this._io.readU1();
            this.mdtM2UePowerHeadroom8 = this._io.readU1();
            this.mdtM2UePowerHeadroom9 = this._io.readU1();
            this.mdtM2UePowerHeadroom10 = this._io.readU1();
            this.mdtM2UePowerHeadroom11 = this._io.readU1();
            this.mdtM2UePowerHeadroom12 = this._io.readU1();
            this.mdtM2UePowerHeadroom13 = this._io.readU1();
            this.mdtM2UePowerHeadroom14 = this._io.readU1();
            this.mdtM2UePowerHeadroom15 = this._io.readU1();
            this.spare = new ArrayList<Integer>();
            for (int i = 0; i < 9; i++) {
                this.spare.add(this._io.readU1());
            }
            this.undefinedData = this._io.readBytes((bodyLength() - 59));
        }

        private int timestampHour;
        private int timestampMinute;
        private int timestampSecond;
        private int timestampMillisec;
        private long scannerId;
        private int rbsModuleId;
        private long globalCellId;
        private long enbs1apid;
        private long mmes1apid;
        private long gummei;
        private long racUeRef;
        private long traceRecordingSessionReference;
        private int mdtM2UePowerHeadroom0;
        private int mdtM2UePowerHeadroom1;
        private int mdtM2UePowerHeadroom2;
        private int mdtM2UePowerHeadroom3;
        private int mdtM2UePowerHeadroom4;
        private int mdtM2UePowerHeadroom5;
        private int mdtM2UePowerHeadroom6;
        private int mdtM2UePowerHeadroom7;
        private int mdtM2UePowerHeadroom8;
        private int mdtM2UePowerHeadroom9;
        private int mdtM2UePowerHeadroom10;
        private int mdtM2UePowerHeadroom11;
        private int mdtM2UePowerHeadroom12;
        private int mdtM2UePowerHeadroom13;
        private int mdtM2UePowerHeadroom14;
        private int mdtM2UePowerHeadroom15;
        private ArrayList<Integer> spare;
        private byte[] undefinedData;
        private int bodyLength;
        private EricssonEventFile _root;
        private EricssonEventFile.TEventRecord _parent;

        public int timestampHour() {
            return timestampHour;
        }

        public int timestampMinute() {
            return timestampMinute;
        }

        public int timestampSecond() {
            return timestampSecond;
        }

        public int timestampMillisec() {
            return timestampMillisec;
        }

        public long scannerId() {
            return scannerId;
        }

        public int rbsModuleId() {
            return rbsModuleId;
        }

        public long globalCellId() {
            return globalCellId;
        }

        public long enbs1apid() {
            return enbs1apid;
        }

        public long mmes1apid() {
            return mmes1apid;
        }

        public long gummei() {
            return gummei;
        }

        public long racUeRef() {
            return racUeRef;
        }

        public long traceRecordingSessionReference() {
            return traceRecordingSessionReference;
        }

        public int mdtM2UePowerHeadroom0() {
            return mdtM2UePowerHeadroom0;
        }

        public int mdtM2UePowerHeadroom1() {
            return mdtM2UePowerHeadroom1;
        }

        public int mdtM2UePowerHeadroom2() {
            return mdtM2UePowerHeadroom2;
        }

        public int mdtM2UePowerHeadroom3() {
            return mdtM2UePowerHeadroom3;
        }

        public int mdtM2UePowerHeadroom4() {
            return mdtM2UePowerHeadroom4;
        }

        public int mdtM2UePowerHeadroom5() {
            return mdtM2UePowerHeadroom5;
        }

        public int mdtM2UePowerHeadroom6() {
            return mdtM2UePowerHeadroom6;
        }

        public int mdtM2UePowerHeadroom7() {
            return mdtM2UePowerHeadroom7;
        }

        public int mdtM2UePowerHeadroom8() {
            return mdtM2UePowerHeadroom8;
        }

        public int mdtM2UePowerHeadroom9() {
            return mdtM2UePowerHeadroom9;
        }

        public int mdtM2UePowerHeadroom10() {
            return mdtM2UePowerHeadroom10;
        }

        public int mdtM2UePowerHeadroom11() {
            return mdtM2UePowerHeadroom11;
        }

        public int mdtM2UePowerHeadroom12() {
            return mdtM2UePowerHeadroom12;
        }

        public int mdtM2UePowerHeadroom13() {
            return mdtM2UePowerHeadroom13;
        }

        public int mdtM2UePowerHeadroom14() {
            return mdtM2UePowerHeadroom14;
        }

        public int mdtM2UePowerHeadroom15() {
            return mdtM2UePowerHeadroom15;
        }

        public ArrayList<Integer> spare() {
            return spare;
        }

        public byte[] undefinedData() {
            return undefinedData;
        }

        public int bodyLength() {
            return bodyLength;
        }

        public EricssonEventFile _root() {
            return _root;
        }

        public EricssonEventFile.TEventRecord _parent() {
            return _parent;
        }

    }

    public static class TEvent3131Body extends KaitaiStruct {
        public TEvent3131Body(KaitaiStream _io, int bodyLength) {
            this(_io, null, null, bodyLength);
        }

        public TEvent3131Body(KaitaiStream _io, EricssonEventFile.TEventRecord _parent, int bodyLength) {
            this(_io, _parent, null, bodyLength);
        }

        public TEvent3131Body(KaitaiStream _io, EricssonEventFile.TEventRecord _parent, EricssonEventFile _root, int bodyLength) {
            super(_io);
            this._parent = _parent;
            this._root = _root;
            this.bodyLength = bodyLength;
            _read();
        }

        private void _read() {
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
            this.traceRecordingSessionReference = this._io.readBitsIntBe(24);
            this.mdtM7ErabPacketLostUl = new ArrayList<Long>();
            for (int i = 0; i < 16; i++) {
                this.mdtM7ErabPacketLostUl.add(this._io.readBitsIntBe(40));
            }
            this.mdtM7ErabPacketRecUl = new ArrayList<Long>();
            for (int i = 0; i < 16; i++) {
                this.mdtM7ErabPacketRecUl.add(this._io.readBitsIntBe(40));
            }
            this.mdtM7ErabPacketLostPelrUuDl = new ArrayList<Long>();
            for (int i = 0; i < 16; i++) {
                this.mdtM7ErabPacketLostPelrUuDl.add(this._io.readBitsIntBe(40));
            }
            this.mdtM7ErabPacketTrDl = new ArrayList<Long>();
            for (int i = 0; i < 16; i++) {
                this.mdtM7ErabPacketTrDl.add(this._io.readBitsIntBe(40));
            }
            this._io.alignToByte();
            this.mdtM7ErabQci = new ArrayList<Integer>();
            for (int i = 0; i < 16; i++) {
                this.mdtM7ErabQci.add(this._io.readU2be());
            }
            this.undefinedData = this._io.readBytes((bodyLength() - 386));
        }

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
        private long traceRecordingSessionReference;
        private ArrayList<Long> mdtM7ErabPacketLostUl;
        private ArrayList<Long> mdtM7ErabPacketRecUl;
        private ArrayList<Long> mdtM7ErabPacketLostPelrUuDl;
        private ArrayList<Long> mdtM7ErabPacketTrDl;
        private ArrayList<Integer> mdtM7ErabQci;
        private byte[] undefinedData;
        private int bodyLength;
        private EricssonEventFile _root;
        private EricssonEventFile.TEventRecord _parent;

        public int timestampHour() {
            return timestampHour;
        }

        public int timestampMinute() {
            return timestampMinute;
        }

        public int timestampSecond() {
            return timestampSecond;
        }

        public int timestampMillisecond() {
            return timestampMillisecond;
        }

        public long scannerId() {
            return scannerId;
        }

        public int rbsModuleId() {
            return rbsModuleId;
        }

        public long globalCellId() {
            return globalCellId;
        }

        public long enbs1apid() {
            return enbs1apid;
        }

        public long mmes1apid() {
            return mmes1apid;
        }

        public long gummei() {
            return gummei;
        }

        public long racUeRef() {
            return racUeRef;
        }

        public long traceRecordingSessionReference() {
            return traceRecordingSessionReference;
        }

        public ArrayList<Long> mdtM7ErabPacketLostUl() {
            return mdtM7ErabPacketLostUl;
        }

        public ArrayList<Long> mdtM7ErabPacketRecUl() {
            return mdtM7ErabPacketRecUl;
        }

        public ArrayList<Long> mdtM7ErabPacketLostPelrUuDl() {
            return mdtM7ErabPacketLostPelrUuDl;
        }

        public ArrayList<Long> mdtM7ErabPacketTrDl() {
            return mdtM7ErabPacketTrDl;
        }

        public ArrayList<Integer> mdtM7ErabQci() {
            return mdtM7ErabQci;
        }

        public byte[] undefinedData() {
            return undefinedData;
        }

        public int bodyLength() {
            return bodyLength;
        }

        public EricssonEventFile _root() {
            return _root;
        }

        public EricssonEventFile.TEventRecord _parent() {
            return _parent;
        }
    }

    public static class TEvent3130Body extends KaitaiStruct {
        public TEvent3130Body(KaitaiStream _io, int bodyLength) {
            this(_io, null, null, bodyLength);
        }

        public TEvent3130Body(KaitaiStream _io, EricssonEventFile.TEventRecord _parent, int bodyLength) {
            this(_io, _parent, null, bodyLength);
        }

        public TEvent3130Body(KaitaiStream _io, EricssonEventFile.TEventRecord _parent, EricssonEventFile _root, int bodyLength) {
            super(_io);
            this._parent = _parent;
            this._root = _root;
            this.bodyLength = bodyLength;
            _read();
        }

        private void _read() {
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
            this.traceRecordingSessionReference = this._io.readBitsIntBe(24);
            this._io.alignToByte();
            this.mdtM6ErabLatTimeDl = new ArrayList<Long>();
            for (int i = 0; i < 16; i++) {
                this.mdtM6ErabLatTimeDl.add(this._io.readU4be());
            }
            this.mdtM6ErabLatSamplDl = new ArrayList<Long>();
            for (int i = 0; i < 16; i++) {
                this.mdtM6ErabLatSamplDl.add(this._io.readU4be());
            }
            this.mdtM6ErabQciDl = new ArrayList<Integer>();
            for (int i = 0; i < 16; i++) {
                this.mdtM6ErabQciDl.add(this._io.readU2be());
            }
            this.mdtM6ErabDelayTimeDl = new ArrayList<Long>();
            for (int i = 0; i < 16; i++) {
                this.mdtM6ErabDelayTimeDl.add(this._io.readU4be());
            }
            this.mdtM6ErabDelaySamplDl = new ArrayList<Long>();
            for (int i = 0; i < 16; i++) {
                this.mdtM6ErabDelaySamplDl.add(this._io.readU4be());
            }
            this.undefinedData = this._io.readBytes((bodyLength() - 322));
        }

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
        private long traceRecordingSessionReference;
        private ArrayList<Long> mdtM6ErabLatTimeDl;
        private ArrayList<Long> mdtM6ErabLatSamplDl;
        private ArrayList<Integer> mdtM6ErabQciDl;
        private ArrayList<Long> mdtM6ErabDelayTimeDl;
        private ArrayList<Long> mdtM6ErabDelaySamplDl;
        private byte[] undefinedData;
        private int bodyLength;
        private EricssonEventFile _root;
        private EricssonEventFile.TEventRecord _parent;

        public int timestampHour() {
            return timestampHour;
        }

        public int timestampMinute() {
            return timestampMinute;
        }

        public int timestampSecond() {
            return timestampSecond;
        }

        public int timestampMillisecond() {
            return timestampMillisecond;
        }

        public long scannerId() {
            return scannerId;
        }

        public int rbsModuleId() {
            return rbsModuleId;
        }

        public long globalCellId() {
            return globalCellId;
        }

        public long enbs1apid() {
            return enbs1apid;
        }

        public long mmes1apid() {
            return mmes1apid;
        }

        public long gummei() {
            return gummei;
        }

        public long racUeRef() {
            return racUeRef;
        }

        public long traceRecordingSessionReference() {
            return traceRecordingSessionReference;
        }

        public ArrayList<Long> mdtM6ErabLatTimeDl() {
            return mdtM6ErabLatTimeDl;
        }

        public ArrayList<Long> mdtM6ErabLatSamplDl() {
            return mdtM6ErabLatSamplDl;
        }

        public ArrayList<Integer> mdtM6ErabQciDl() {
            return mdtM6ErabQciDl;
        }

        public ArrayList<Long> mdtM6ErabDelayTimeDl() {
            return mdtM6ErabDelayTimeDl;
        }

        public ArrayList<Long> mdtM6ErabDelaySamplDl() {
            return mdtM6ErabDelaySamplDl;
        }

        public byte[] undefinedData() {
            return undefinedData;
        }

        public int bodyLength() {
            return bodyLength;
        }

        public EricssonEventFile _root() {
            return _root;
        }

        public EricssonEventFile.TEventRecord _parent() {
            return _parent;
        }
    }

    public static class TEvent3129Body extends KaitaiStruct {
        public TEvent3129Body(KaitaiStream _io, int bodyLength) {
            this(_io, null, null, bodyLength);
        }

        public TEvent3129Body(KaitaiStream _io, EricssonEventFile.TEventRecord _parent, int bodyLength) {
            this(_io, _parent, null, bodyLength);
        }

        public TEvent3129Body(KaitaiStream _io, EricssonEventFile.TEventRecord _parent, EricssonEventFile _root, int bodyLength) {
            super(_io);
            this._parent = _parent;
            this._root = _root;
            this.bodyLength = bodyLength;
            _read();
        }

        private void _read() {
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
            this.traceRecordingSessionReference = this._io.readBitsIntBe(24);
            this._io.alignToByte();
            this.erabExcDelayUl = new ArrayList<Integer>();
            for (int i = 0; i < 6; i++) {
                this.erabExcDelayUl.add(this._io.readU1());
            }
            this.erabQciUl = new ArrayList<Integer>();
            for (int i = 0; i < 6; i++) {
                this.erabQciUl.add(this._io.readU1());
            }
            this.mdtM6LocationCoordinates = this._io.readU1();
            this.mdtM6EllipsoidPoint = new TEllipsoidPoint(this._io, this, _root);
            this.mdtM6EllipsoidPointWithAlti = new TEllipsoidPointWithAlti(this._io, this, _root);
            this.mdtM6EllipsoidPointWithUncerCircle = new TEllipsoidPointWithUncerCircle(this._io, this, _root);
            this.mdtM6EllipsoidPointWithUncerEllipse = new TEllipsoidPointWithUncerEllipse(this._io, this, _root);
            this.mdtM6EllipsoidPointWithAltiAndUncerEllipsoid = new TEllipsoidPointWithAltiAndUncerEllipsoid(this._io, this, _root);
            this.mdtM6EllipsoidArc = new TEllipsoidArc(this._io, this, _root);
            this.mdtM6Polygon1 = new TPolygon(this._io, this, _root);
            this.mdtM6Polygon2 = new TPolygon(this._io, this, _root);
            this.mdtM6Polygon3 = new TPolygon(this._io, this, _root);
            this.mdtM6Polygon4 = new TPolygon(this._io, this, _root);
            this.mdtM6Polygon5 = new TPolygon(this._io, this, _root);
            this.mdtM6Polygon6 = new TPolygon(this._io, this, _root);
            this.mdtM6Polygon7 = new TPolygon(this._io, this, _root);
            this.mdtM6HorizontalVelocity = new THorizontalVelocity(this._io, this, _root);
            this.mdtM6GnssTodMsec = this._io.readU4be();
            this.undefinedData = this._io.readBytes((bodyLength() - 245));
        }

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
        private long traceRecordingSessionReference;
        private ArrayList<Integer> erabExcDelayUl;
        private ArrayList<Integer> erabQciUl;
        private int mdtM6LocationCoordinates;
        private TEllipsoidPoint mdtM6EllipsoidPoint;
        private TEllipsoidPointWithAlti mdtM6EllipsoidPointWithAlti;
        private TEllipsoidPointWithUncerCircle mdtM6EllipsoidPointWithUncerCircle;
        private TEllipsoidPointWithUncerEllipse mdtM6EllipsoidPointWithUncerEllipse;
        private TEllipsoidPointWithAltiAndUncerEllipsoid mdtM6EllipsoidPointWithAltiAndUncerEllipsoid;
        private TEllipsoidArc mdtM6EllipsoidArc;
        private TPolygon mdtM6Polygon1;
        private TPolygon mdtM6Polygon2;
        private TPolygon mdtM6Polygon3;
        private TPolygon mdtM6Polygon4;
        private TPolygon mdtM6Polygon5;
        private TPolygon mdtM6Polygon6;
        private TPolygon mdtM6Polygon7;
        private THorizontalVelocity mdtM6HorizontalVelocity;
        private long mdtM6GnssTodMsec;
        private byte[] undefinedData;
        private int bodyLength;
        private EricssonEventFile _root;
        private EricssonEventFile.TEventRecord _parent;

        public int timestampHour() {
            return timestampHour;
        }

        public int timestampMinute() {
            return timestampMinute;
        }

        public int timestampSecond() {
            return timestampSecond;
        }

        public int timestampMillisecond() {
            return timestampMillisecond;
        }

        public long scannerId() {
            return scannerId;
        }

        public int rbsModuleId() {
            return rbsModuleId;
        }

        public long globalCellId() {
            return globalCellId;
        }

        public long enbs1apid() {
            return enbs1apid;
        }

        public long mmes1apid() {
            return mmes1apid;
        }

        public long gummei() {
            return gummei;
        }

        public long racUeRef() {
            return racUeRef;
        }

        public long traceRecordingSessionReference() {
            return traceRecordingSessionReference;
        }

        public ArrayList<Integer> erabExcDelayUl() {
            return erabExcDelayUl;
        }

        public ArrayList<Integer> erabQciUl() {
            return erabQciUl;
        }

        public int mdtM6LocationCoordinates() {
            return mdtM6LocationCoordinates;
        }

        public TEllipsoidPoint mdtM6EllipsoidPoint() {
            return mdtM6EllipsoidPoint;
        }

        public TEllipsoidPointWithAlti mdtM6EllipsoidPointWithAlti() {
            return mdtM6EllipsoidPointWithAlti;
        }

        public TEllipsoidPointWithUncerCircle mdtM6EllipsoidPointWithUncerCircle() {
            return mdtM6EllipsoidPointWithUncerCircle;
        }

        public TEllipsoidPointWithUncerEllipse mdtM6EllipsoidPointWithUncerEllipse() {
            return mdtM6EllipsoidPointWithUncerEllipse;
        }

        public TEllipsoidPointWithAltiAndUncerEllipsoid mdtM6EllipsoidPointWithAltiAndUncerEllipsoid() {
            return mdtM6EllipsoidPointWithAltiAndUncerEllipsoid;
        }

        public TEllipsoidArc mdtM6EllipsoidArc() {
            return mdtM6EllipsoidArc;
        }

        public TPolygon mdtM6Polygon1() {
            return mdtM6Polygon1;
        }

        public TPolygon mdtM6Polygon2() {
            return mdtM6Polygon2;
        }

        public TPolygon mdtM6Polygon3() {
            return mdtM6Polygon3;
        }

        public TPolygon mdtM6Polygon4() {
            return mdtM6Polygon4;
        }

        public TPolygon mdtM6Polygon5() {
            return mdtM6Polygon5;
        }

        public TPolygon mdtM6Polygon6() {
            return mdtM6Polygon6;
        }

        public TPolygon mdtM6Polygon7() {
            return mdtM6Polygon7;
        }

        public THorizontalVelocity mdtM6HorizontalVelocity() {
            return mdtM6HorizontalVelocity;
        }

        public long mdtM6GnssTodMsec() {
            return mdtM6GnssTodMsec;
        }

        public byte[] undefinedData() {
            return undefinedData;
        }

        public int bodyLength() {
            return bodyLength;
        }

        public EricssonEventFile _root() {
            return _root;
        }

        public EricssonEventFile.TEventRecord _parent() {
            return _parent;
        }
    }

    public static class TEvent4099Body extends KaitaiStruct {
        public TEvent4099Body(KaitaiStream _io, int bodyLength) {
            this(_io, null, null, bodyLength);
        }

        public TEvent4099Body(KaitaiStream _io, EricssonEventFile.TEventRecord _parent, int bodyLength) {
            this(_io, _parent, null, bodyLength);
        }

        public TEvent4099Body(KaitaiStream _io, EricssonEventFile.TEventRecord _parent, EricssonEventFile _root, int bodyLength) {
            super(_io);
            this._parent = _parent;
            this._root = _root;
            this.bodyLength = bodyLength;
            _read();
        }

        private void _read() {
            this.timestampHour = this._io.readU1();
            this.timestampMinute = this._io.readU1();
            this.timestampSecond = this._io.readU1();
            this.timestampMillisec = this._io.readU2be();
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
            this.traceRecordingSessionReference = this._io.readBitsIntBe(24);
            this._io.alignToByte();
            this.erabSetupResult = new ArrayList<Integer>();
            for (int i = 0; i < 16; i++) {
                this.erabSetupResult.add(this._io.readU1());
            }
            this.erabSetupReqQci = new ArrayList<Integer>();
            for (int i = 0; i < 16; i++) {
                this.erabSetupReqQci.add(this._io.readU2be());
            }
            this.erabSetupReqArp = new ArrayList<Integer>();
            for (int i = 0; i < 16; i++) {
                this.erabSetupReqArp.add(this._io.readU1());
            }
            this.erabSetupReqPci = new ArrayList<Integer>();
            for (int i = 0; i < 16; i++) {
                this.erabSetupReqPci.add(this._io.readU1());
            }
            this.erabSetupReqPvi = new ArrayList<Integer>();
            for (int i = 0; i < 16; i++) {
                this.erabSetupReqPvi.add(this._io.readU1());
            }
            this.erabSetupAttAccType = new ArrayList<Integer>();
            for (int i = 0; i < 16; i++) {
                this.erabSetupAttAccType.add(this._io.readU1());
            }
            this.erabSetupSuccAccType = new ArrayList<Integer>();
            for (int i = 0; i < 16; i++) {
                this.erabSetupSuccAccType.add(this._io.readU1());
            }
            this.erabSetupFailure3gppCauseGroup = new ArrayList<Integer>();
            for (int i = 0; i < 16; i++) {
                this.erabSetupFailure3gppCauseGroup.add(this._io.readU1());
            }
            this.erabSetupFailure3gppCause = new ArrayList<Integer>();
            for (int i = 0; i < 16; i++) {
                this.erabSetupFailure3gppCause.add(this._io.readU1());
            }
            this.accumulatedUlRequestedGbr = this._io.readU4be();
            this.accumulatedDlRequestedGbr = this._io.readU4be();
            this.accumulatedUlAdmittedGbr = this._io.readU4be();
            this.accumulatedDlAdmittedGbr = this._io.readU4be();
            this.timestampStartHour = this._io.readU1();
            this.timestampStartMinute = this._io.readU1();
            this.timestampStartSecond = this._io.readU1();
            this.timestampStartMillisec = this._io.readU2be();
            this.timestampStopHour = this._io.readU1();
            this.timestampStopMinute = this._io.readU1();
            this.timestampStopSecond = this._io.readU1();
            this.timestampStopMillisec = this._io.readU2be();
            this.erabAdmCtrlBlockingArp = new ArrayList<Integer>();
            for (int i = 0; i < 16; i++) {
                this.erabAdmCtrlBlockingArp.add(this._io.readU1());
            }
            this.erabAdmCtrlRejectingMsrPreemptionAttempted = new ArrayList<Integer>();
            for (int i = 0; i < 16; i++) {
                this.erabAdmCtrlRejectingMsrPreemptionAttempted.add(this._io.readU1());
            }
            this.erabSetupResultSuccReqGbr = new ArrayList<Integer>();
            for (int i = 0; i < 16; i++) {
                this.erabSetupResultSuccReqGbr.add(this._io.readU1());
            }
            this.tac = this._io.readU4be();
            this.svn = this._io.readU1();
            this.maskedsrn = this._io.readU1();
            this.plmnIndex = this._io.readU1();
            this.ueCategoryFlex = this._io.readU1();
            this.spidValue = this._io.readU2be();
            this.uePowerClass = this._io.readU1();
            this.brCeLevel = this._io.readU1();
            this.subscriberGroupId = this._io.readU1();
            this.erabSetupResultGbr = new ArrayList<Integer>();
            for (int i = 0; i < 16; i++) {
                this.erabSetupResultGbr.add(this._io.readU1());
            }
            this.erabSetupResFailResult = new ArrayList<Integer>();
            for (int i = 0; i < 16; i++) {
                this.erabSetupResFailResult.add(this._io.readU1());
            }
            this.erabSetupResFailResultGbr = new ArrayList<Integer>();
            for (int i = 0; i < 16; i++) {
                this.erabSetupResFailResultGbr.add(this._io.readU1());
            }
            this.ueEndcStage = this._io.readU1();
            this.spare = new ArrayList<Integer>();
            for (int i = 0; i < 9; i++) {
                this.spare.add(this._io.readU1());
            }
            this.undefinedData = this._io.readBytes((bodyLength() - 339));

        }

        private int timestampHour;
        private int timestampMinute;
        private int timestampSecond;
        private int timestampMillisec;
        private long scannerId;
        private int rbsModuleId;
        private long globalCellId;
        private long enbs1apid;
        private long mmes1apid;
        private long gummei;
        private long racUeRef;
        private long traceRecordingSessionReference;
        private ArrayList<Integer> erabSetupResult;
        private ArrayList<Integer> erabSetupReqQci;
        private ArrayList<Integer> erabSetupReqArp;
        private ArrayList<Integer> erabSetupReqPci;
        private ArrayList<Integer> erabSetupReqPvi;
        private ArrayList<Integer> erabSetupAttAccType;
        private ArrayList<Integer> erabSetupSuccAccType;
        private ArrayList<Integer> erabSetupFailure3gppCauseGroup;
        private ArrayList<Integer> erabSetupFailure3gppCause;
        private long accumulatedUlRequestedGbr;
        private long accumulatedDlRequestedGbr;
        private long accumulatedUlAdmittedGbr;
        private long accumulatedDlAdmittedGbr;
        private int timestampStartHour;
        private int timestampStartMinute;
        private int timestampStartSecond;
        private int timestampStartMillisec;
        private int timestampStopHour;
        private int timestampStopMinute;
        private int timestampStopSecond;
        private int timestampStopMillisec;
        private ArrayList<Integer> erabAdmCtrlBlockingArp;
        private ArrayList<Integer> erabAdmCtrlRejectingMsrPreemptionAttempted;
        private ArrayList<Integer> erabSetupResultSuccReqGbr;
        private long tac;
        private int svn;
        private int maskedsrn;
        private int plmnIndex;
        private int ueCategoryFlex;
        private int spidValue;
        private int uePowerClass;
        private int brCeLevel;
        private int subscriberGroupId;
        private ArrayList<Integer> erabSetupResultGbr;
        private ArrayList<Integer> erabSetupResFailResult;
        private ArrayList<Integer> erabSetupResFailResultGbr;
        private int ueEndcStage;
        private ArrayList<Integer> spare;
        private byte[] undefinedData;
        private int bodyLength;
        private EricssonEventFile _root;
        private EricssonEventFile.TEventRecord _parent;

        public int timestampHour() {
            return timestampHour;
        }

        public int timestampMinute() {
            return timestampMinute;
        }

        public int timestampSecond() {
            return timestampSecond;
        }

        public int timestampMillisec() {
            return timestampMillisec;
        }

        public long scannerId() {
            return scannerId;
        }

        public int rbsModuleId() {
            return rbsModuleId;
        }

        public long globalCellId() {
            return globalCellId;
        }

        public long enbs1apid() {
            return enbs1apid;
        }

        public long mmes1apid() {
            return mmes1apid;
        }

        public long gummei() {
            return gummei;
        }

        public long racUeRef() {
            return racUeRef;
        }

        public long traceRecordingSessionReference() {
            return traceRecordingSessionReference;
        }

        public ArrayList<Integer> erabSetupResult() {
            return erabSetupResult;
        }

        public ArrayList<Integer> erabSetupReqQci() {
            return erabSetupReqQci;
        }

        public ArrayList<Integer> erabSetupReqArp() {
            return erabSetupReqArp;
        }

        public ArrayList<Integer> erabSetupReqPci() {
            return erabSetupReqPci;
        }

        public ArrayList<Integer> erabSetupReqPvi() {
            return erabSetupReqPvi;
        }

        public ArrayList<Integer> erabSetupAttAccType() {
            return erabSetupAttAccType;
        }

        public ArrayList<Integer> erabSetupSuccAccType() {
            return erabSetupSuccAccType;
        }

        public ArrayList<Integer> erabSetupFailure3gppCauseGroup() {
            return erabSetupFailure3gppCauseGroup;
        }

        public ArrayList<Integer> erabSetupFailure3gppCause() {
            return erabSetupFailure3gppCause;
        }

        public long accumulatedUlRequestedGbr() {
            return accumulatedUlRequestedGbr;
        }

        public long accumulatedDlRequestedGbr() {
            return accumulatedDlRequestedGbr;
        }

        public long accumulatedUlAdmittedGbr() {
            return accumulatedUlAdmittedGbr;
        }

        public long accumulatedDlAdmittedGbr() {
            return accumulatedDlAdmittedGbr;
        }

        public int timestampStartHour() {
            return timestampStartHour;
        }

        public int timestampStartMinute() {
            return timestampStartMinute;
        }

        public int timestampStartSecond() {
            return timestampStartSecond;
        }

        public int timestampStartMillisec() {
            return timestampStartMillisec;
        }

        public int timestampStopHour() {
            return timestampStopHour;
        }

        public int timestampStopMinute() {
            return timestampStopMinute;
        }

        public int timestampStopSecond() {
            return timestampStopSecond;
        }

        public int timestampStopMillisec() {
            return timestampStopMillisec;
        }

        public ArrayList<Integer> erabAdmCtrlBlockingArp() {
            return erabAdmCtrlBlockingArp;
        }

        public ArrayList<Integer> erabAdmCtrlRejectingMsrPreemptionAttempted() {
            return erabAdmCtrlRejectingMsrPreemptionAttempted;
        }

        public ArrayList<Integer> erabSetupResultSuccReqGbr() {
            return erabSetupResultSuccReqGbr;
        }

        public long tac() {
            return tac;
        }

        public int svn() {
            return svn;
        }

        public int maskedsrn() {
            return maskedsrn;
        }

        public int plmnIndex() {
            return plmnIndex;
        }

        public int ueCategoryFlex() {
            return ueCategoryFlex;
        }

        public int spidValue() {
            return spidValue;
        }

        public int uePowerClass() {
            return uePowerClass;
        }

        public int brCeLevel() {
            return brCeLevel;
        }

        public int subscriberGroupId() {
            return subscriberGroupId;
        }

        public ArrayList<Integer> erabSetupResultGbr() {
            return erabSetupResultGbr;
        }

        public ArrayList<Integer> erabSetupResFailResult() {
            return erabSetupResFailResult;
        }

        public ArrayList<Integer> erabSetupResFailResultGbr() {
            return erabSetupResFailResultGbr;
        }

        public int ueEndcStage() {
            return ueEndcStage;
        }

        public ArrayList<Integer> spare() {
            return spare;
        }

        public byte[] undefinedData() {
            return undefinedData;
        }

        public int bodyLength() {
            return bodyLength;
        }

        public EricssonEventFile _root() {
            return _root;
        }

        public EricssonEventFile.TEventRecord _parent() {
            return _parent;
        }
    }

    public static class TEvent4112Body extends KaitaiStruct {
        public TEvent4112Body(KaitaiStream _io, int bodyLength) {
            this(_io, null, null, bodyLength);
        }

        public TEvent4112Body(KaitaiStream _io, EricssonEventFile.TEventRecord _parent, int bodyLength) {
            this(_io, _parent, null, bodyLength);
        }

        public TEvent4112Body(KaitaiStream _io, EricssonEventFile.TEventRecord _parent, EricssonEventFile _root, int bodyLength) {
            super(_io);
            this._parent = _parent;
            this._root = _root;
            this.bodyLength = bodyLength;
            _read();
        }

        private void _read() {
            this.timestampHour = this._io.readU1();
            this.timestampMinute = this._io.readU1();
            this.timestampSecond = this._io.readU1();
            this.timestampMillisec = this._io.readU2be();
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
            this.traceRecordingSessionReference = this._io.readBitsIntBe(24);
            this._io.alignToByte();
            this.hoSourceOrTargetType = this._io.readU1();
            this.hoTargetSelectionType = this._io.readU1();
            this.neighborCgi = this._io.readBitsIntBe(64);
            this._io.alignToByte();
            this.hoPacketForward = this._io.readU1();
            this.procHoExecOutResult = this._io.readU1();
            this.hoType = this._io.readU1();
            this.drxConfigIndex = this._io.readU1();
            this.hoOutExecErabReqBitmap = this._io.readU2be();
            this.hoOutExecErabFailBitmap = this._io.readU2be();
            this.procHoExecOutAttemptCause = this._io.readU1();
            this.erabHoExecOutQci = new ArrayList<Integer>();
            for (int i = 0; i < 16; i++) {
                this.erabHoExecOutQci.add(this._io.readU2be());
            }
            this.timestampStartHour = this._io.readU1();
            this.timestampStartMinute = this._io.readU1();
            this.timestampStartSecond = this._io.readU1();
            this.timestampStartMillisec = this._io.readU2be();
            this.timestampStopHour = this._io.readU1();
            this.timestampStopMinute = this._io.readU1();
            this.timestampStopSecond = this._io.readU1();
            this.timestampStopMillisec = this._io.readU2be();
            this.ta = this._io.readU2be();
            this.triggerQuantity = this._io.readU1();
            this.tac = this._io.readU4be();
            this.svn = this._io.readU1();
            this.maskedsrn = this._io.readU1();
            this.hoAfterResync = this._io.readU1();
            this.hoStickyEarfcn = this._io.readU1();
            this.hoOutExecErabReqBitmap2 = this._io.readBitsIntBe(24);
            this.hoOutExecErabFailBitmap2 = this._io.readBitsIntBe(24);
            this._io.alignToByte();
            this.uePowerClass = this._io.readU1();
            this.subscriberGroupId = this._io.readU1();
            this.ueCategoryFlex = this._io.readU1();
            this.brCeLevel = this._io.readU1();
            this.plmnIndex = this._io.readU1();
            this.spidValue = this._io.readU2be();
            this.ueEndcStage = this._io.readU1();
            this.erabHoExecOutServiceType = new ArrayList<Integer>();
            for (int i = 0; i < 16; i++) {
                this.erabHoExecOutServiceType.add(this._io.readU1());
            }
            this.spare = new ArrayList<Integer>();
            for (int i = 0; i < 9; i++) {
                this.spare.add(this._io.readU1());
            }
            this.undefinedData = this._io.readBytes((bodyLength() - 145));
        }

        private int timestampHour;
        private int timestampMinute;
        private int timestampSecond;
        private int timestampMillisec;
        private long scannerId;
        private int rbsModuleId;
        private long globalCellId;
        private long enbs1apid;
        private long mmes1apid;
        private long gummei;
        private long racUeRef;
        private long traceRecordingSessionReference;
        private int hoSourceOrTargetType;
        private int hoTargetSelectionType;
        private long neighborCgi;
        private int hoPacketForward;
        private int procHoExecOutResult;
        private int hoType;
        private int drxConfigIndex;
        private int hoOutExecErabReqBitmap;
        private int hoOutExecErabFailBitmap;
        private int procHoExecOutAttemptCause;
        private ArrayList<Integer> erabHoExecOutQci;
        private int timestampStartHour;
        private int timestampStartMinute;
        private int timestampStartSecond;
        private int timestampStartMillisec;
        private int timestampStopHour;
        private int timestampStopMinute;
        private int timestampStopSecond;
        private int timestampStopMillisec;
        private int ta;
        private int triggerQuantity;
        private long tac;
        private int svn;
        private int maskedsrn;
        private int hoAfterResync;
        private int hoStickyEarfcn;
        private long hoOutExecErabReqBitmap2;
        private long hoOutExecErabFailBitmap2;
        private int uePowerClass;
        private int subscriberGroupId;
        private int ueCategoryFlex;
        private int brCeLevel;
        private int plmnIndex;
        private int spidValue;
        private int ueEndcStage;
        private ArrayList<Integer> erabHoExecOutServiceType;
        private ArrayList<Integer> spare;
        private byte[] undefinedData;
        private int bodyLength;
        private EricssonEventFile _root;
        private EricssonEventFile.TEventRecord _parent;

        public int timestampHour() {
            return timestampHour;
        }

        public int timestampMinute() {
            return timestampMinute;
        }

        public int timestampSecond() {
            return timestampSecond;
        }

        public int timestampMillisec() {
            return timestampMillisec;
        }

        public long scannerId() {
            return scannerId;
        }

        public int rbsModuleId() {
            return rbsModuleId;
        }

        public long globalCellId() {
            return globalCellId;
        }

        public long enbs1apid() {
            return enbs1apid;
        }

        public long mmes1apid() {
            return mmes1apid;
        }

        public long gummei() {
            return gummei;
        }

        public long racUeRef() {
            return racUeRef;
        }

        public long traceRecordingSessionReference() {
            return traceRecordingSessionReference;
        }

        public int hoSourceOrTargetType() {
            return hoSourceOrTargetType;
        }

        public int hoTargetSelectionType() {
            return hoTargetSelectionType;
        }

        public long neighborCgi() {
            return neighborCgi;
        }

        public int hoPacketForward() {
            return hoPacketForward;
        }

        public int procHoExecOutResult() {
            return procHoExecOutResult;
        }

        public int hoType() {
            return hoType;
        }

        public int drxConfigIndex() {
            return drxConfigIndex;
        }

        public int hoOutExecErabReqBitmap() {
            return hoOutExecErabReqBitmap;
        }

        public int hoOutExecErabFailBitmap() {
            return hoOutExecErabFailBitmap;
        }

        public int procHoExecOutAttemptCause() {
            return procHoExecOutAttemptCause;
        }

        public ArrayList<Integer> erabHoExecOutQci() {
            return erabHoExecOutQci;
        }

        public int timestampStartHour() {
            return timestampStartHour;
        }

        public int timestampStartMinute() {
            return timestampStartMinute;
        }

        public int timestampStartSecond() {
            return timestampStartSecond;
        }

        public int timestampStartMillisec() {
            return timestampStartMillisec;
        }

        public int timestampStopHour() {
            return timestampStopHour;
        }

        public int timestampStopMinute() {
            return timestampStopMinute;
        }

        public int timestampStopSecond() {
            return timestampStopSecond;
        }

        public int timestampStopMillisec() {
            return timestampStopMillisec;
        }

        public int ta() {
            return ta;
        }

        public int triggerQuantity() {
            return triggerQuantity;
        }

        public long tac() {
            return tac;
        }

        public int svn() {
            return svn;
        }

        public int maskedsrn() {
            return maskedsrn;
        }

        public int hoAfterResync() {
            return hoAfterResync;
        }

        public int hoStickyEarfcn() {
            return hoStickyEarfcn;
        }

        public long hoOutExecErabReqBitmap2() {
            return hoOutExecErabReqBitmap2;
        }

        public long hoOutExecErabFailBitmap2() {
            return hoOutExecErabFailBitmap2;
        }

        public int uePowerClass() {
            return uePowerClass;
        }

        public int subscriberGroupId() {
            return subscriberGroupId;
        }

        public int ueCategoryFlex() {
            return ueCategoryFlex;
        }

        public int brCeLevel() {
            return brCeLevel;
        }

        public int plmnIndex() {
            return plmnIndex;
        }

        public int spidValue() {
            return spidValue;
        }

        public int ueEndcStage() {
            return ueEndcStage;
        }

        public ArrayList<Integer> erabHoExecOutServiceType() {
            return erabHoExecOutServiceType;
        }

        public ArrayList<Integer> spare() {
            return spare;
        }

        public byte[] undefinedData() {
            return undefinedData;
        }

        public int bodyLength() {
            return bodyLength;
        }

        public EricssonEventFile _root() {
            return _root;
        }

        public EricssonEventFile.TEventRecord _parent() {
            return _parent;
        }
    }

    public static class TEvent4110Body extends KaitaiStruct {
        public TEvent4110Body(KaitaiStream _io, int bodyLength) {
            this(_io, null, null, bodyLength);
        }

        public TEvent4110Body(KaitaiStream _io, EricssonEventFile.TEventRecord _parent, int bodyLength) {
            this(_io, _parent, null, bodyLength);
        }

        public TEvent4110Body(KaitaiStream _io, EricssonEventFile.TEventRecord _parent, EricssonEventFile _root, int bodyLength) {
            super(_io);
            this._parent = _parent;
            this._root = _root;
            this.bodyLength = bodyLength;
            _read();
        }

        private void _read() {
            this.timestampHour = this._io.readU1();
            this.timestampMinute = this._io.readU1();
            this.timestampSecond = this._io.readU1();
            this.timestampMillisec = this._io.readU2be();
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
            this.traceRecordingSessionReference = this._io.readBitsIntBe(24);
            this._io.alignToByte();
            this.hoSourceOrTargetType = this._io.readU1();
            this.hoTargetSelectionType = this._io.readU1();
            this.neighborCgi = this._io.readBitsIntBe(64);
            this._io.alignToByte();
            this.procHoPrepOutAttemptCause = this._io.readU1();
            this.procHoPrepOutResult = this._io.readU1();
            this.hoType = this._io.readU1();
            this.hoOutPrepErabReqBitmap = this._io.readU2be();
            this.hoOutPrepErabFailBitmap = this._io.readU2be();
            this.param3gppCauseGroup = this._io.readU1();
            this.param3gppCause = this._io.readU1();
            this.hoPrepQci = new ArrayList<Integer>();
            for (int i = 0; i < 16; i++) {
                this.hoPrepQci.add(this._io.readU2be());
            }
            this.timestampStartHour = this._io.readU1();
            this.timestampStartMinute = this._io.readU1();
            this.timestampStartSecond = this._io.readU1();
            this.timestampStartMillisec = this._io.readU2be();
            this.timestampStopHour = this._io.readU1();
            this.timestampStopMinute = this._io.readU1();
            this.timestampStopSecond = this._io.readU1();
            this.timestampStopMillisec = this._io.readU2be();
            this.tac = this._io.readU4be();
            this.svn = this._io.readU1();
            this.maskedsrn = this._io.readU1();
            this.ulEvaluation = this._io.readU1();
            this.sinrMaxRsrpSource = this._io.readU2be();
            this.noiseInterferenceSource = this._io.readU2be();
            this.sinrMaxRsrpTarget = this._io.readU2be();
            this.noiseInterferenceTarget = this._io.readU2be();
            this.ultrigRejectCause = this._io.readU1();
            this.hoOutPrepErabReqBitmap2 = this._io.readBitsIntBe(24);
            this.hoOutPrepErabFailBitmap2 = this._io.readBitsIntBe(24);
            this._io.alignToByte();
            this.uePowerClass = this._io.readU1();
            this.subscriberGroupId = this._io.readU1();
            this.ueCategoryFlex = this._io.readU1();
            this.brCeLevel = this._io.readU1();
            this.plmnIndex = this._io.readU1();
            this.spidValue = this._io.readU2be();
            this.ueEndcStage = this._io.readU1();
            this.spare = new ArrayList<Integer>();
            for (int i = 0; i < 9; i++) {
                this.spare.add(this._io.readU1());
            }
            this.undefinedData = this._io.readBytes((bodyLength() - 134));
        }

        private int timestampHour;
        private int timestampMinute;
        private int timestampSecond;
        private int timestampMillisec;
        private long scannerId;
        private int rbsModuleId;
        private long globalCellId;
        private long enbs1apid;
        private long mmes1apid;
        private long gummei;
        private long racUeRef;
        private long traceRecordingSessionReference;
        private int hoSourceOrTargetType;
        private int hoTargetSelectionType;
        private long neighborCgi;
        private int procHoPrepOutAttemptCause;
        private int procHoPrepOutResult;
        private int hoType;
        private int hoOutPrepErabReqBitmap;
        private int hoOutPrepErabFailBitmap;
        private int param3gppCauseGroup;
        private int param3gppCause;
        private ArrayList<Integer> hoPrepQci;
        private int timestampStartHour;
        private int timestampStartMinute;
        private int timestampStartSecond;
        private int timestampStartMillisec;
        private int timestampStopHour;
        private int timestampStopMinute;
        private int timestampStopSecond;
        private int timestampStopMillisec;
        private long tac;
        private int svn;
        private int maskedsrn;
        private int ulEvaluation;
        private int sinrMaxRsrpSource;
        private int noiseInterferenceSource;
        private int sinrMaxRsrpTarget;
        private int noiseInterferenceTarget;
        private int ultrigRejectCause;
        private long hoOutPrepErabReqBitmap2;
        private long hoOutPrepErabFailBitmap2;
        private int uePowerClass;
        private int subscriberGroupId;
        private int ueCategoryFlex;
        private int brCeLevel;
        private int plmnIndex;
        private int spidValue;
        private int ueEndcStage;
        private ArrayList<Integer> spare;
        private byte[] undefinedData;
        private int bodyLength;
        private EricssonEventFile _root;
        private EricssonEventFile.TEventRecord _parent;

        public int timestampHour() {
            return timestampHour;
        }

        public int timestampMinute() {
            return timestampMinute;
        }

        public int timestampSecond() {
            return timestampSecond;
        }

        public int timestampMillisec() {
            return timestampMillisec;
        }

        public long scannerId() {
            return scannerId;
        }

        public int rbsModuleId() {
            return rbsModuleId;
        }

        public long globalCellId() {
            return globalCellId;
        }

        public long enbs1apid() {
            return enbs1apid;
        }

        public long mmes1apid() {
            return mmes1apid;
        }

        public long gummei() {
            return gummei;
        }

        public long racUeRef() {
            return racUeRef;
        }

        public long traceRecordingSessionReference() {
            return traceRecordingSessionReference;
        }

        public int hoSourceOrTargetType() {
            return hoSourceOrTargetType;
        }

        public int hoTargetSelectionType() {
            return hoTargetSelectionType;
        }

        public long neighborCgi() {
            return neighborCgi;
        }

        public int procHoPrepOutAttemptCause() {
            return procHoPrepOutAttemptCause;
        }

        public int procHoPrepOutResult() {
            return procHoPrepOutResult;
        }

        public int hoType() {
            return hoType;
        }

        public int hoOutPrepErabReqBitmap() {
            return hoOutPrepErabReqBitmap;
        }

        public int hoOutPrepErabFailBitmap() {
            return hoOutPrepErabFailBitmap;
        }

        public int param3gppCauseGroup() {
            return param3gppCauseGroup;
        }

        public int param3gppCause() {
            return param3gppCause;
        }

        public ArrayList<Integer> hoPrepQci() {
            return hoPrepQci;
        }

        public int timestampStartHour() {
            return timestampStartHour;
        }

        public int timestampStartMinute() {
            return timestampStartMinute;
        }

        public int timestampStartSecond() {
            return timestampStartSecond;
        }

        public int timestampStartMillisec() {
            return timestampStartMillisec;
        }

        public int timestampStopHour() {
            return timestampStopHour;
        }

        public int timestampStopMinute() {
            return timestampStopMinute;
        }

        public int timestampStopSecond() {
            return timestampStopSecond;
        }

        public int timestampStopMillisec() {
            return timestampStopMillisec;
        }

        public long tac() {
            return tac;
        }

        public int svn() {
            return svn;
        }

        public int maskedsrn() {
            return maskedsrn;
        }

        public int ulEvaluation() {
            return ulEvaluation;
        }

        public int sinrMaxRsrpSource() {
            return sinrMaxRsrpSource;
        }

        public int noiseInterferenceSource() {
            return noiseInterferenceSource;
        }

        public int sinrMaxRsrpTarget() {
            return sinrMaxRsrpTarget;
        }

        public int noiseInterferenceTarget() {
            return noiseInterferenceTarget;
        }

        public int ultrigRejectCause() {
            return ultrigRejectCause;
        }

        public long hoOutPrepErabReqBitmap2() {
            return hoOutPrepErabReqBitmap2;
        }

        public long hoOutPrepErabFailBitmap2() {
            return hoOutPrepErabFailBitmap2;
        }

        public int uePowerClass() {
            return uePowerClass;
        }

        public int subscriberGroupId() {
            return subscriberGroupId;
        }

        public int ueCategoryFlex() {
            return ueCategoryFlex;
        }

        public int brCeLevel() {
            return brCeLevel;
        }

        public int plmnIndex() {
            return plmnIndex;
        }

        public int spidValue() {
            return spidValue;
        }

        public int ueEndcStage() {
            return ueEndcStage;
        }

        public ArrayList<Integer> spare() {
            return spare;
        }

        public byte[] undefinedData() {
            return undefinedData;
        }

        public int bodyLength() {
            return bodyLength;
        }

        public EricssonEventFile _root() {
            return _root;
        }

        public EricssonEventFile.TEventRecord _parent() {
            return _parent;
        }
    }

    public static class TEvent4106Body extends KaitaiStruct {
        public TEvent4106Body(KaitaiStream _io, int bodyLength) {
            this(_io, null, null, bodyLength);
        }

        public TEvent4106Body(KaitaiStream _io, EricssonEventFile.TEventRecord _parent, int bodyLength) {
            this(_io, _parent, null, bodyLength);
        }

        public TEvent4106Body(KaitaiStream _io, EricssonEventFile.TEventRecord _parent, EricssonEventFile _root, int bodyLength) {
            super(_io);
            this._parent = _parent;
            this._root = _root;
            this.bodyLength = bodyLength;
            _read();
        }

        private void _read() {
            this.timestampHour = this._io.readU1();
            this.timestampMinute = this._io.readU1();
            this.timestampSecond = this._io.readU1();
            this.timestampMillisec = this._io.readU2be();
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
            this.traceRecordingSessionReference = this._io.readBitsIntBe(24);
            this._io.alignToByte();
            this.erabSetupResult = new ArrayList<Integer>();
            for (int i = 0; i < 16; i++) {
                this.erabSetupResult.add(this._io.readU1());
            }
            this.erabSetupReqQci = new ArrayList<Integer>();
            for (int i = 0; i < 16; i++) {
                this.erabSetupReqQci.add(this._io.readU2be());
            }
            this.erabSetupReqArp = new ArrayList<Integer>();
            for (int i = 0; i < 16; i++) {
                this.erabSetupReqArp.add(this._io.readU1());
            }
            this.erabSetupReqPci = new ArrayList<Integer>();
            for (int i = 0; i < 16; i++) {
                this.erabSetupReqPci.add(this._io.readU1());
            }
            this.erabSetupReqPvi = new ArrayList<Integer>();
            for (int i = 0; i < 16; i++) {
                this.erabSetupReqPvi.add(this._io.readU1());
            }
            this.erabSetupAttAccType = new ArrayList<Integer>();
            for (int i = 0; i < 16; i++) {
                this.erabSetupAttAccType.add(this._io.readU1());
            }
            this.erabSetupSuccAccType = new ArrayList<Integer>();
            for (int i = 0; i < 16; i++) {
                this.erabSetupSuccAccType.add(this._io.readU1());
            }
            this.erabSetupFailure3gppCauseGroup = new ArrayList<Integer>();
            for (int i = 0; i < 16; i++) {
                this.erabSetupFailure3gppCauseGroup.add(this._io.readU1());
            }
            this.erabSetupFailure3gppCause = new ArrayList<Integer>();
            for (int i = 0; i < 16; i++) {
                this.erabSetupFailure3gppCause.add(this._io.readU1());
            }
            this.accumulatedUlRequestedGbr = this._io.readU4be();
            this.accumulatedDlRequestedGbr = this._io.readU4be();
            this.accumulatedUlAdmittedGbr = this._io.readU4be();
            this.accumulatedDlAdmittedGbr = this._io.readU4be();
            this.initialCtxtResult = this._io.readU1();
            this.servingPlmnId = this._io.readBitsIntBe(32);
            this._io.alignToByte();
            this.param3gppCauseGroup = this._io.readU1();
            this.param3gppCause = this._io.readU1();
            this.timestampStartHour = this._io.readU1();
            this.timestampStartMinute = this._io.readU1();
            this.timestampStartSecond = this._io.readU1();
            this.timestampStartMillisec = this._io.readU2be();
            this.timestampStopHour = this._io.readU1();
            this.timestampStopMinute = this._io.readU1();
            this.timestampStopSecond = this._io.readU1();
            this.timestampStopMillisec = this._io.readU2be();
            this.ta = this._io.readU2be();
            this.erabAdmCtrlBlockingArp = new ArrayList<Integer>();
            for (int i = 0; i < 16; i++) {
                this.erabAdmCtrlBlockingArp.add(this._io.readU1());
            }
            this.erabAdmCtrlRejectingMsrPreemptionAttempted = new ArrayList<Integer>();
            for (int i = 0; i < 16; i++) {
                this.erabAdmCtrlRejectingMsrPreemptionAttempted.add(this._io.readU1());
            }
            this.ueHighestRecArp = this._io.readU1();
            this.ueAdmCtrlBlockingArp = this._io.readU1();
            this.erabSetupAttemptGbr = new ArrayList<Integer>();
            for (int i = 0; i < 16; i++) {
                this.erabSetupAttemptGbr.add(this._io.readU1());
            }
            this.erabSetupResultSuccReqGbr = new ArrayList<Integer>();
            for (int i = 0; i < 16; i++) {
                this.erabSetupResultSuccReqGbr.add(this._io.readU1());
            }
            this.tac = this._io.readU4be();
            this.svn = this._io.readU1();
            this.maskedsrn = this._io.readU1();
            this.plmnIndex = this._io.readU1();
            this.ueCategoryFlex = this._io.readU1();
            this.spidValue = this._io.readU2be();
            this.bandwidthReducedAccessCeMode = this._io.readU1();
            this.uePowerClass = this._io.readU1();
            this.brCeLevel = this._io.readU1();
            this.subscriberGroupId = this._io.readU1();
            this.erabSetupResultGbr = new ArrayList<Integer>();
            for (int i = 0; i < 16; i++) {
                this.erabSetupResultGbr.add(this._io.readU1());
            }
            this.erabSetupResFailResult = new ArrayList<Integer>();
            for (int i = 0; i < 16; i++) {
                this.erabSetupResFailResult.add(this._io.readU1());
            }
            this.erabSetupResFailResultGbr = new ArrayList<Integer>();
            for (int i = 0; i < 16; i++) {
                this.erabSetupResFailResultGbr.add(this._io.readU1());
            }
            this.ueEndcStage = this._io.readU1();
            this.spare = new ArrayList<Integer>();
            for (int i = 0; i < 9; i++) {
                this.spare.add(this._io.readU1());
            }
            this.undefinedData = this._io.readBytes((bodyLength() - 367));
        }

        private int timestampHour;
        private int timestampMinute;
        private int timestampSecond;
        private int timestampMillisec;
        private long scannerId;
        private int rbsModuleId;
        private long globalCellId;
        private long enbs1apid;
        private long mmes1apid;
        private long gummei;
        private long racUeRef;
        private long traceRecordingSessionReference;
        private ArrayList<Integer> erabSetupResult;
        private ArrayList<Integer> erabSetupReqQci;
        private ArrayList<Integer> erabSetupReqArp;
        private ArrayList<Integer> erabSetupReqPci;
        private ArrayList<Integer> erabSetupReqPvi;
        private ArrayList<Integer> erabSetupAttAccType;
        private ArrayList<Integer> erabSetupSuccAccType;
        private ArrayList<Integer> erabSetupFailure3gppCauseGroup;
        private ArrayList<Integer> erabSetupFailure3gppCause;
        private long accumulatedUlRequestedGbr;
        private long accumulatedDlRequestedGbr;
        private long accumulatedUlAdmittedGbr;
        private long accumulatedDlAdmittedGbr;
        private int initialCtxtResult;
        private long servingPlmnId;
        private int param3gppCauseGroup;
        private long param3gppCause;
        private int timestampStartHour;
        private int timestampStartMinute;
        private int timestampStartSecond;
        private int timestampStartMillisec;
        private int timestampStopHour;
        private int timestampStopMinute;
        private int timestampStopSecond;
        private int timestampStopMillisec;
        private int ta;
        private ArrayList<Integer> erabAdmCtrlBlockingArp;
        private ArrayList<Integer> erabAdmCtrlRejectingMsrPreemptionAttempted;
        private int ueHighestRecArp;
        private int ueAdmCtrlBlockingArp;
        private ArrayList<Integer> erabSetupAttemptGbr;
        private ArrayList<Integer> erabSetupResultSuccReqGbr;
        private long tac;
        private int svn;
        private int maskedsrn;
        private int plmnIndex;
        private int ueCategoryFlex;
        private int spidValue;
        private int bandwidthReducedAccessCeMode;
        private int uePowerClass;
        private int brCeLevel;
        private int subscriberGroupId;
        private ArrayList<Integer> erabSetupResultGbr;
        private ArrayList<Integer> erabSetupResFailResult;
        private ArrayList<Integer> erabSetupResFailResultGbr;
        private int ueEndcStage;
        private ArrayList<Integer> spare;
        private byte[] undefinedData;
        private int bodyLength;
        private EricssonEventFile _root;
        private EricssonEventFile.TEventRecord _parent;

        public int timestampHour() {
            return timestampHour;
        }

        public int timestampMinute() {
            return timestampMinute;
        }

        public int timestampSecond() {
            return timestampSecond;
        }

        public int timestampMillisec() {
            return timestampMillisec;
        }

        public long scannerId() {
            return scannerId;
        }

        public int rbsModuleId() {
            return rbsModuleId;
        }

        public long globalCellId() {
            return globalCellId;
        }

        public long enbs1apid() {
            return enbs1apid;
        }

        public long mmes1apid() {
            return mmes1apid;
        }

        public long gummei() {
            return gummei;
        }

        public long racUeRef() {
            return racUeRef;
        }

        public long traceRecordingSessionReference() {
            return traceRecordingSessionReference;
        }

        public ArrayList<Integer> erabSetupResult() {
            return erabSetupResult;
        }

        public ArrayList<Integer> erabSetupReqQci() {
            return erabSetupReqQci;
        }

        public ArrayList<Integer> erabSetupReqArp() {
            return erabSetupReqArp;
        }

        public ArrayList<Integer> erabSetupReqPci() {
            return erabSetupReqPci;
        }

        public ArrayList<Integer> erabSetupReqPvi() {
            return erabSetupReqPvi;
        }

        public ArrayList<Integer> erabSetupAttAccType() {
            return erabSetupAttAccType;
        }

        public ArrayList<Integer> erabSetupSuccAccType() {
            return erabSetupSuccAccType;
        }

        public ArrayList<Integer> erabSetupFailure3gppCauseGroup() {
            return erabSetupFailure3gppCauseGroup;
        }

        public ArrayList<Integer> erabSetupFailure3gppCause() {
            return erabSetupFailure3gppCause;
        }

        public long accumulatedUlRequestedGbr() {
            return accumulatedUlRequestedGbr;
        }

        public long accumulatedDlRequestedGbr() {
            return accumulatedDlRequestedGbr;
        }

        public long accumulatedUlAdmittedGbr() {
            return accumulatedUlAdmittedGbr;
        }

        public long accumulatedDlAdmittedGbr() {
            return accumulatedDlAdmittedGbr;
        }

        public int initialCtxtResult() {
            return initialCtxtResult;
        }

        public long servingPlmnId() {
            return servingPlmnId;
        }

        public int param3gppCauseGroup() {
            return param3gppCauseGroup;
        }

        public long param3gppCause() {
            return param3gppCause;
        }

        public int timestampStartHour() {
            return timestampStartHour;
        }

        public int timestampStartMinute() {
            return timestampStartMinute;
        }

        public int timestampStartSecond() {
            return timestampStartSecond;
        }

        public int timestampStartMillisec() {
            return timestampStartMillisec;
        }

        public int timestampStopHour() {
            return timestampStopHour;
        }

        public int timestampStopMinute() {
            return timestampStopMinute;
        }

        public int timestampStopSecond() {
            return timestampStopSecond;
        }

        public int timestampStopMillisec() {
            return timestampStopMillisec;
        }

        public int ta() {
            return ta;
        }

        public ArrayList<Integer> erabAdmCtrlBlockingArp() {
            return erabAdmCtrlBlockingArp;
        }

        public ArrayList<Integer> erabAdmCtrlRejectingMsrPreemptionAttempted() {
            return erabAdmCtrlRejectingMsrPreemptionAttempted;
        }

        public int ueHighestRecArp() {
            return ueHighestRecArp;
        }

        public int ueAdmCtrlBlockingArp() {
            return ueAdmCtrlBlockingArp;
        }

        public ArrayList<Integer> erabSetupAttemptGbr() {
            return erabSetupAttemptGbr;
        }

        public ArrayList<Integer> erabSetupResultSuccReqGbr() {
            return erabSetupResultSuccReqGbr;
        }

        public long tac() {
            return tac;
        }

        public int svn() {
            return svn;
        }

        public int maskedsrn() {
            return maskedsrn;
        }

        public int plmnIndex() {
            return plmnIndex;
        }

        public int ueCategoryFlex() {
            return ueCategoryFlex;
        }

        public int spidValue() {
            return spidValue;
        }

        public int bandwidthReducedAccessCeMode() {
            return bandwidthReducedAccessCeMode;
        }

        public int uePowerClass() {
            return uePowerClass;
        }

        public int brCeLevel() {
            return brCeLevel;
        }

        public int subscriberGroupId() {
            return subscriberGroupId;
        }

        public ArrayList<Integer> erabSetupResultGbr() {
            return erabSetupResultGbr;
        }

        public ArrayList<Integer> erabSetupResFailResult() {
            return erabSetupResFailResult;
        }

        public ArrayList<Integer> erabSetupResFailResultGbr() {
            return erabSetupResFailResultGbr;
        }

        public int ueEndcStage() {
            return ueEndcStage;
        }

        public ArrayList<Integer> spare() {
            return spare;
        }

        public byte[] undefinedData() {
            return undefinedData;
        }

        public int bodyLength() {
            return bodyLength;
        }

        public EricssonEventFile _root() {
            return _root;
        }

        public EricssonEventFile.TEventRecord _parent() {
            return _parent;
        }
    }

    public static class TEvent4097Body extends KaitaiStruct {
        public TEvent4097Body(KaitaiStream _io, int bodyLength) {
            this(_io, null, null, bodyLength);
        }

        public TEvent4097Body(KaitaiStream _io, EricssonEventFile.TEventRecord _parent, int bodyLength) {
            this(_io, _parent, null, bodyLength);
        }

        public TEvent4097Body(KaitaiStream _io, EricssonEventFile.TEventRecord _parent, EricssonEventFile _root, int bodyLength) {
            super(_io);
            this._parent = _parent;
            this._root = _root;
            this.bodyLength = bodyLength;
            _read();
        }

        private void _read() {
            this.timestampHour = this._io.readU1();
            this.timestampMinute = this._io.readU1();
            this.timestampSecond = this._io.readU1();
            this.timestampMillisec = this._io.readU2be();
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
            this.traceRecordingSessionReference = this._io.readBitsIntBe(24);
            this._io.alignToByte();
            this.initialUeIdentityType = this._io.readU1();
            this.initialUeIdentity = this._io.readBitsIntBe(48);
            this._io.alignToByte();
            this.rrcEstabCause = this._io.readU1();
            this.rrcResult = this._io.readU1();
            this.timestampStartHour = this._io.readU1();
            this.timestampStartMinute = this._io.readU1();
            this.timestampStartSecond = this._io.readU1();
            this.timestampStartMillisec = this._io.readU2be();
            this.timestampStopHour = this._io.readU1();
            this.timestampStopMinute = this._io.readU1();
            this.timestampStopSecond = this._io.readU1();
            this.timestampStopMillisec = this._io.readU2be();
            this.gummeiType = this._io.readU1();
            this.admCtrlRejectingMsrPreemptionAttempted = this._io.readU1();
            this.admCtrlBlockingArp = this._io.readU1();
            this.msrUlPrbUtilCellState = this._io.readU1();
            this.msrUlPrbUtilBbmState = this._io.readU1();
            this.msrDlPrbUtilCellState = this._io.readU1();
            this.msrDlPrbUtilBbmState = this._io.readU1();
            this.msrUlSeUtilCellState = this._io.readU1();
            this.msrUlSeUtilBbmState = this._io.readU1();
            this.msrDlSeUtilCellState = this._io.readU1();
            this.msrDlSeUtilBbmState = this._io.readU1();
            this.msrCceUtilCellState = this._io.readU1();
            this.msrUlBbCapUtilBbmState = this._io.readU1();
            this.msrDlBbCapUtilBbmState = this._io.readU1();
            this.bandwidthReducedAccessCeMode = this._io.readU1();
            this.rrcEstablCauseNb = this._io.readU1();
            this.brCeLevel = this._io.readU1();
            this.spare = new ArrayList<Integer>();
            for (int i = 0; i < 9; i++) {
                this.spare.add(this._io.readU1());
            }
            this.msrDlPrbPttReservationCellState = this._io.readU1();
            this.msrDlSePttReservationCellState = this._io.readU1();
            this.msrCcePttReservationCellState = this._io.readU1();
            this.msrDlPrbPttReservationBbmState = this._io.readU1();
            this.msrDlSePttReservationBbmState = this._io.readU1();
            this.msrDlBbCapPttReservationBbmState = this._io.readU1();
            this.duacPagingPool = this._io.readU1();
            this.reattemptIndicator = this._io.readU1();
            this.undefinedData = this._io.readBytes((bodyLength() - 87));
        }

        private int timestampHour;
        private int timestampMinute;
        private int timestampSecond;
        private int timestampMillisec;
        private long scannerId;
        private int rbsModuleId;
        private long globalCellId;
        private long enbs1apid;
        private long mmes1apid;
        private long gummei;
        private long racUeRef;
        private long traceRecordingSessionReference;
        private int initialUeIdentityType;
        private long initialUeIdentity;
        private int rrcEstabCause;
        private int rrcResult;
        private int timestampStartHour;
        private int timestampStartMinute;
        private int timestampStartSecond;
        private int timestampStartMillisec;
        private int timestampStopHour;
        private int timestampStopMinute;
        private int timestampStopSecond;
        private int timestampStopMillisec;
        private int gummeiType;
        private int admCtrlRejectingMsrPreemptionAttempted;
        private int admCtrlBlockingArp;
        private int msrUlPrbUtilCellState;
        private int msrUlPrbUtilBbmState;
        private int msrDlPrbUtilCellState;
        private int msrDlPrbUtilBbmState;
        private int msrUlSeUtilCellState;
        private int msrUlSeUtilBbmState;
        private int msrDlSeUtilCellState;
        private int msrDlSeUtilBbmState;
        private int msrCceUtilCellState;
        private int msrUlBbCapUtilBbmState;
        private int msrDlBbCapUtilBbmState;
        private int bandwidthReducedAccessCeMode;
        private int rrcEstablCauseNb;
        private int brCeLevel;
        private ArrayList<Integer> spare;
        private int msrDlPrbPttReservationCellState;
        private int msrDlSePttReservationCellState;
        private int msrCcePttReservationCellState;
        private int msrDlPrbPttReservationBbmState;
        private int msrDlSePttReservationBbmState;
        private int msrDlBbCapPttReservationBbmState;
        private int duacPagingPool;
        private int reattemptIndicator;
        private byte[] undefinedData;
        private int bodyLength;
        private EricssonEventFile _root;
        private EricssonEventFile.TEventRecord _parent;

        public int timestampHour() {
            return timestampHour;
        }

        public int timestampMinute() {
            return timestampMinute;
        }

        public int timestampSecond() {
            return timestampSecond;
        }

        public int timestampMillisec() {
            return timestampMillisec;
        }

        public long scannerId() {
            return scannerId;
        }

        public int rbsModuleId() {
            return rbsModuleId;
        }

        public long globalCellId() {
            return globalCellId;
        }

        public long enbs1apid() {
            return enbs1apid;
        }

        public long mmes1apid() {
            return mmes1apid;
        }

        public long gummei() {
            return gummei;
        }

        public long racUeRef() {
            return racUeRef;
        }

        public long traceRecordingSessionReference() {
            return traceRecordingSessionReference;
        }

        public int initialUeIdentityType() {
            return initialUeIdentityType;
        }

        public long initialUeIdentity() {
            return initialUeIdentity;
        }

        public int rrcEstabCause() {
            return rrcEstabCause;
        }

        public int rrcResult() {
            return rrcResult;
        }

        public int timestampStartHour() {
            return timestampStartHour;
        }

        public int timestampStartMinute() {
            return timestampStartMinute;
        }

        public int timestampStartSecond() {
            return timestampStartSecond;
        }

        public int timestampStartMillisec() {
            return timestampStartMillisec;
        }

        public int timestampStopHour() {
            return timestampStopHour;
        }

        public int timestampStopMinute() {
            return timestampStopMinute;
        }

        public int timestampStopSecond() {
            return timestampStopSecond;
        }

        public int timestampStopMillisec() {
            return timestampStopMillisec;
        }

        public int gummeiType() {
            return gummeiType;
        }

        public int admCtrlRejectingMsrPreemptionAttempted() {
            return admCtrlRejectingMsrPreemptionAttempted;
        }

        public int admCtrlBlockingArp() {
            return admCtrlBlockingArp;
        }

        public int msrUlPrbUtilCellState() {
            return msrUlPrbUtilCellState;
        }

        public int msrUlPrbUtilBbmState() {
            return msrUlPrbUtilBbmState;
        }

        public int msrDlPrbUtilCellState() {
            return msrDlPrbUtilCellState;
        }

        public int msrDlPrbUtilBbmState() {
            return msrDlPrbUtilBbmState;
        }

        public int msrUlSeUtilCellState() {
            return msrUlSeUtilCellState;
        }

        public int msrUlSeUtilBbmState() {
            return msrUlSeUtilBbmState;
        }

        public int msrDlSeUtilCellState() {
            return msrDlSeUtilCellState;
        }

        public int msrDlSeUtilBbmState() {
            return msrDlSeUtilBbmState;
        }

        public int msrCceUtilCellState() {
            return msrCceUtilCellState;
        }

        public int msrUlBbCapUtilBbmState() {
            return msrUlBbCapUtilBbmState;
        }

        public int msrDlBbCapUtilBbmState() {
            return msrDlBbCapUtilBbmState;
        }

        public int bandwidthReducedAccessCeMode() {
            return bandwidthReducedAccessCeMode;
        }

        public int rrcEstablCauseNb() {
            return rrcEstablCauseNb;
        }

        public int brCeLevel() {
            return brCeLevel;
        }

        public ArrayList<Integer> spare() {
            return spare;
        }

        public int msrDlPrbPttReservationCellState() {
            return msrDlPrbPttReservationCellState;
        }

        public int msrDlSePttReservationCellState() {
            return msrDlSePttReservationCellState;
        }

        public int msrCcePttReservationCellState() {
            return msrCcePttReservationCellState;
        }

        public int msrDlPrbPttReservationBbmState() {
            return msrDlPrbPttReservationBbmState;
        }

        public int msrDlSePttReservationBbmState() {
            return msrDlSePttReservationBbmState;
        }

        public int msrDlBbCapPttReservationBbmState() {
            return msrDlBbCapPttReservationBbmState;
        }

        public int duacPagingPool() {
            return duacPagingPool;
        }

        public int reattemptIndicator() {
            return reattemptIndicator;
        }

        public byte[] undefinedData() {
            return undefinedData;
        }

        public int bodyLength() {
            return bodyLength;
        }

        public EricssonEventFile _root() {
            return _root;
        }

        public EricssonEventFile.TEventRecord _parent() {
            return _parent;
        }
    }

    public static class TEvent4121Body extends KaitaiStruct {
        public TEvent4121Body(KaitaiStream _io, int bodyLength) {
            this(_io, null, null, bodyLength);
        }

        public TEvent4121Body(KaitaiStream _io, EricssonEventFile.TEventRecord _parent, int bodyLength) {
            this(_io, _parent, null, bodyLength);
        }

        public TEvent4121Body(KaitaiStream _io, EricssonEventFile.TEventRecord _parent, EricssonEventFile _root, int bodyLength) {
            super(_io);
            this._parent = _parent;
            this._root = _root;
            this.bodyLength = bodyLength;
            _read();
        }

        private void _read() {
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
            this.traceRecordingSessionReference = this._io.readBitsIntBe(24);
            this._io.alignToByte();
            this.timestampStartHour = this._io.readU1();
            this.timestampStartMinute = this._io.readU1();
            this.timestampStartSecond = this._io.readU1();
            this.timestampStartMillisecond = this._io.readU2be();
            this.timestampStopHour = this._io.readU1();
            this.timestampStopMinute = this._io.readU1();
            this.timestampStopSecond = this._io.readU1();
            this.timestampStopMillisecond = this._io.readU2be();
            this.reestabCause = this._io.readU1();
            this.reestabResult = this._io.readU1();
            this.reestabMultiTargetType = this._io.readU1();
            this.hoSourceOrTargetType = this._io.readU1();
            this.hoType = this._io.readU1();
            this.ttiBundlingMode = this._io.readU1();
            this.admCtrlRejectingMsrPreemptionAttempted = this._io.readU1();
            this.ta = this._io.readU2be();
            this.erabReestReqQci = new ArrayList<Integer>();
            for (int i = 0; i < 16; i++) {
                this.erabReestReqQci.add(this._io.readU2be());
            }
            this.erabReestResult = new ArrayList<Integer>();
            for (int i = 0; i < 16; i++) {
                this.erabReestResult.add(this._io.readU1());
            }
            this.tac = this._io.readU4be();
            this.svn = this._io.readU1();
            this.maskedsrn = this._io.readU1();
            this.msrUlPrbUtilCellState = this._io.readU1();
            this.msrUlPrbUtilBbmState = this._io.readU1();
            this.msrDlPrbUtilCellState = this._io.readU1();
            this.msrDlPrbUtilBbmState = this._io.readU1();
            this.msrUlSeUtilCellState = this._io.readU1();
            this.msrUlSeUtilBbmState = this._io.readU1();
            this.msrDlSeUtilCellState = this._io.readU1();
            this.msrDlSeUtilBbmState = this._io.readU1();
            this.msrCceUtilCellState = this._io.readU1();
            this.msrUlBbCapUtilBbmState = this._io.readU1();
            this.msrDlBbCapUtilBbmState = this._io.readU1();
            this.asn1Extension = this._io.readU1();
            this.reestabCauseNb = this._io.readU1();
            this.uePowerClass = this._io.readU1();
            this.subscriberGroupId = this._io.readU1();
            this.pdcpTypeInSource = this._io.readU1();
            this.ueEndcStage = this._io.readU1();
            this.spare = new ArrayList<Integer>();
            for (int i = 0; i < 9; i++) {
                this.spare.add(this._io.readU1());
            }
            this.reestabSourceEnbCandidateOtherVendor = this._io.readU1();
            this.reestabSourceEnbCandidateEricsson = this._io.readU1();
            this.reestabSourceEnbOtherVendor = this._io.readU1();
            this.msrDlPrbPttReservationCellState = this._io.readU1();
            this.msrDlSePttReservationCellState = this._io.readU1();
            this.msrCcePttReservationCellState = this._io.readU1();
            this.msrDlPrbPttReservationBbmState = this._io.readU1();
            this.msrDlSePttReservationBbmState = this._io.readU1();
            this.msrDlBbCapPttReservationBbmState = this._io.readU1();
            this.paUser = this._io.readU1();
            this.erabReestReqArp = new ArrayList<Integer>();
            for (int i = 0; i < 16; i++) {
                this.erabReestReqArp.add(this._io.readU1());
            }
            this.undefinedData = this._io.readBytes((bodyLength() - 159));
        }

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
        private long traceRecordingSessionReference;
        private int timestampStartHour;
        private int timestampStartMinute;
        private int timestampStartSecond;
        private int timestampStartMillisecond;
        private int timestampStopHour;
        private int timestampStopMinute;
        private int timestampStopSecond;
        private int timestampStopMillisecond;
        private int reestabCause;
        private int reestabResult;
        private int reestabMultiTargetType;
        private int hoSourceOrTargetType;
        private int hoType;
        private int ttiBundlingMode;
        private int admCtrlRejectingMsrPreemptionAttempted;
        private int ta;
        private ArrayList<Integer> erabReestReqQci;
        private ArrayList<Integer> erabReestResult;
        private long tac;
        private int svn;
        private int maskedsrn;
        private int msrUlPrbUtilCellState;
        private int msrUlPrbUtilBbmState;
        private int msrDlPrbUtilCellState;
        private int msrDlPrbUtilBbmState;
        private int msrUlSeUtilCellState;
        private int msrUlSeUtilBbmState;
        private int msrDlSeUtilCellState;
        private int msrDlSeUtilBbmState;
        private int msrCceUtilCellState;
        private int msrUlBbCapUtilBbmState;
        private int msrDlBbCapUtilBbmState;
        private int asn1Extension;
        private int reestabCauseNb;
        private int uePowerClass;
        private int subscriberGroupId;
        private int pdcpTypeInSource;
        private int ueEndcStage;
        private ArrayList<Integer> spare;
        private int reestabSourceEnbCandidateOtherVendor;
        private int reestabSourceEnbCandidateEricsson;
        private int reestabSourceEnbOtherVendor;
        private int msrDlPrbPttReservationCellState;
        private int msrDlSePttReservationCellState;
        private int msrCcePttReservationCellState;
        private int msrDlPrbPttReservationBbmState;
        private int msrDlSePttReservationBbmState;
        private int msrDlBbCapPttReservationBbmState;
        private int paUser;
        private ArrayList<Integer> erabReestReqArp;
        private byte[] undefinedData;
        private int bodyLength;
        private EricssonEventFile _root;
        private EricssonEventFile.TEventRecord _parent;

        public int timestampHour() {
            return timestampHour;
        }

        public int timestampMinute() {
            return timestampMinute;
        }

        public int timestampSecond() {
            return timestampSecond;
        }

        public int timestampMillisecond() {
            return timestampMillisecond;
        }

        public long scannerId() {
            return scannerId;
        }

        public int rbsModuleId() {
            return rbsModuleId;
        }

        public long globalCellId() {
            return globalCellId;
        }

        public long enbs1apid() {
            return enbs1apid;
        }

        public long mmes1apid() {
            return mmes1apid;
        }

        public long gummei() {
            return gummei;
        }

        public long racUeRef() {
            return racUeRef;
        }

        public long traceRecordingSessionReference() {
            return traceRecordingSessionReference;
        }

        public int timestampStartHour() {
            return timestampStartHour;
        }

        public int timestampStartMinute() {
            return timestampStartMinute;
        }

        public int timestampStartSecond() {
            return timestampStartSecond;
        }

        public int timestampStartMillisecond() {
            return timestampStartMillisecond;
        }

        public int timestampStopHour() {
            return timestampStopHour;
        }

        public int timestampStopMinute() {
            return timestampStopMinute;
        }

        public int timestampStopSecond() {
            return timestampStopSecond;
        }

        public int timestampStopMillisecond() {
            return timestampStopMillisecond;
        }

        public int reestabCause() {
            return reestabCause;
        }

        public int reestabResult() {
            return reestabResult;
        }

        public int reestabMultiTargetType() {
            return reestabMultiTargetType;
        }

        public int hoSourceOrTargetType() {
            return hoSourceOrTargetType;
        }

        public int hoType() {
            return hoType;
        }

        public int ttiBundlingMode() {
            return ttiBundlingMode;
        }

        public int admCtrlRejectingMsrPreemptionAttempted() {
            return admCtrlRejectingMsrPreemptionAttempted;
        }

        public int ta() {
            return ta;
        }

        public ArrayList<Integer> erabReestReqQci() {
            return erabReestReqQci;
        }

        public ArrayList<Integer> erabReestResult() {
            return erabReestResult;
        }

        public long tac() {
            return tac;
        }

        public int svn() {
            return svn;
        }

        public int maskedsrn() {
            return maskedsrn;
        }

        public int msrUlPrbUtilCellState() {
            return msrUlPrbUtilCellState;
        }

        public int msrUlPrbUtilBbmState() {
            return msrUlPrbUtilBbmState;
        }

        public int msrDlPrbUtilCellState() {
            return msrDlPrbUtilCellState;
        }

        public int msrDlPrbUtilBbmState() {
            return msrDlPrbUtilBbmState;
        }

        public int msrUlSeUtilCellState() {
            return msrUlSeUtilCellState;
        }

        public int msrUlSeUtilBbmState() {
            return msrUlSeUtilBbmState;
        }

        public int msrDlSeUtilCellState() {
            return msrDlSeUtilCellState;
        }

        public int msrDlSeUtilBbmState() {
            return msrDlSeUtilBbmState;
        }

        public int msrCceUtilCellState() {
            return msrCceUtilCellState;
        }

        public int msrUlBbCapUtilBbmState() {
            return msrUlBbCapUtilBbmState;
        }

        public int msrDlBbCapUtilBbmState() {
            return msrDlBbCapUtilBbmState;
        }

        public int asn1Extension() {
            return asn1Extension;
        }

        public int reestabCauseNb() {
            return reestabCauseNb;
        }

        public int uePowerClass() {
            return uePowerClass;
        }

        public int subscriberGroupId() {
            return subscriberGroupId;
        }

        public int pdcpTypeInSource() {
            return pdcpTypeInSource;
        }

        public int ueEndcStage() {
            return ueEndcStage;
        }

        public ArrayList<Integer> spare() {
            return spare;
        }

        public int reestabSourceEnbCandidateOtherVendor() {
            return reestabSourceEnbCandidateOtherVendor;
        }

        public int reestabSourceEnbCandidateEricsson() {
            return reestabSourceEnbCandidateEricsson;
        }

        public int reestabSourceEnbOtherVendor() {
            return reestabSourceEnbOtherVendor;
        }

        public int msrDlPrbPttReservationCellState() {
            return msrDlPrbPttReservationCellState;
        }

        public int msrDlSePttReservationCellState() {
            return msrDlSePttReservationCellState;
        }

        public int msrCcePttReservationCellState() {
            return msrCcePttReservationCellState;
        }

        public int msrDlPrbPttReservationBbmState() {
            return msrDlPrbPttReservationBbmState;
        }

        public int msrDlSePttReservationBbmState() {
            return msrDlSePttReservationBbmState;
        }

        public int msrDlBbCapPttReservationBbmState() {
            return msrDlBbCapPttReservationBbmState;
        }

        public int paUser() {
            return paUser;
        }

        public ArrayList<Integer> erabReestReqArp() {
            return erabReestReqArp;
        }

        public byte[] undefinedData() {
            return undefinedData;
        }

        public int bodyLength() {
            return bodyLength;
        }

        public EricssonEventFile _root() {
            return _root;
        }

        public EricssonEventFile.TEventRecord _parent() {
            return _parent;
        }
    }

    public static class TEvent4125Body extends KaitaiStruct {
        public TEvent4125Body(KaitaiStream _io, int bodyLength) {
            this(_io, null, null, bodyLength);
        }

        public TEvent4125Body(KaitaiStream _io, EricssonEventFile.TEventRecord _parent, int bodyLength) {
            this(_io, _parent, null, bodyLength);
        }

        public TEvent4125Body(KaitaiStream _io, EricssonEventFile.TEventRecord _parent, EricssonEventFile _root, int bodyLength) {
            super(_io);
            this._parent = _parent;
            this._root = _root;
            this.bodyLength = bodyLength;
            _read();
        }

        private void _read() {
            this.timestampHour = this._io.readU1();
            this.timestampMinute = this._io.readU1();
            this.timestampSecond = this._io.readU1();
            this.timestampMillisec = this._io.readU2be();
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
            this.traceRecordingSessionReference = this._io.readBitsIntBe(24);
            this._io.alignToByte();
            this.triggeringNode = this._io.readU1();
            this.s1ReleaseCause = this._io.readU1();
            this.param3gppCauseGroup = this._io.readU1();
            this.param3gppCause = this._io.readU1();
            this.internalReleaseCause = this._io.readU1();
            this.erabDataLost = new ArrayList<Integer>();
            for (int i = 0; i < 16; i++) {
                this.erabDataLost.add(this._io.readU1());
            }
            this.erabReleaseSucc = new ArrayList<Integer>();
            for (int i = 0; i < 16; i++) {
                this.erabReleaseSucc.add(this._io.readU1());
            }
            this.erabReleaseReqQci = new ArrayList<Integer>();
            for (int i = 0; i < 16; i++) {
                this.erabReleaseReqQci.add(this._io.readU2be());
            }
            this.hoOutPrepErabFail = new ArrayList<Integer>();
            for (int i = 0; i < 16; i++) {
                this.hoOutPrepErabFail.add(this._io.readU1());
            }
            this.hoOutPrepErabFailAndDataLost = new ArrayList<Integer>();
            for (int i = 0; i < 16; i++) {
                this.hoOutPrepErabFailAndDataLost.add(this._io.readU1());
            }
            this.hoOutExecErabFailAndDataLost = new ArrayList<Integer>();
            for (int i = 0; i < 16; i++) {
                this.hoOutExecErabFailAndDataLost.add(this._io.readU1());
            }
            this.erabSetupReqArp = new ArrayList<Integer>();
            for (int i = 0; i < 16; i++) {
                this.erabSetupReqArp.add(this._io.readU1());
            }
            this.erabSetupReqPci = new ArrayList<Integer>();
            for (int i = 0; i < 16; i++) {
                this.erabSetupReqPci.add(this._io.readU1());
            }
            this.erabSetupReqPvi = new ArrayList<Integer>();
            for (int i = 0; i < 16; i++) {
                this.erabSetupReqPvi.add(this._io.readU1());
            }
            this.timestampStartHour = this._io.readU1();
            this.timestampStartMinute = this._io.readU1();
            this.timestampStartSecond = this._io.readU1();
            this.timestampStartMillisec = this._io.readU2be();
            this.timestampStopHour = this._io.readU1();
            this.timestampStopMinute = this._io.readU1();
            this.timestampStopSecond = this._io.readU1();
            this.timestampStopMillisec = this._io.readU2be();
            this.ttiBundlingMode = this._io.readU1();
            this.ta = this._io.readU2be();
            this.partialNodeRestartErabDataLost = new ArrayList<Integer>();
            for (int i = 0; i < 16; i++) {
                this.partialNodeRestartErabDataLost.add(this._io.readU1());
            }
            this.erabReleaseSuccGbr = new ArrayList<Integer>();
            for (int i = 0; i < 16; i++) {
                this.erabReleaseSuccGbr.add(this._io.readU1());
            }
            this.hoOutPrepErabFailGbr = new ArrayList<Integer>();
            for (int i = 0; i < 16; i++) {
                this.hoOutPrepErabFailGbr.add(this._io.readU1());
            }
            this.hoOutPrepErabFailAndDataLostGbr = new ArrayList<Integer>();
            for (int i = 0; i < 16; i++) {
                this.hoOutPrepErabFailAndDataLostGbr.add(this._io.readU1());
            }
            this.erabInactiveGap = new ArrayList<Integer>();
            for (int i = 0; i < 16; i++) {
                this.erabInactiveGap.add(this._io.readU1());
            }
            this.tac = this._io.readU4be();
            this.svn = this._io.readU1();
            this.maskedsrn = this._io.readU1();
            this.plmnIndex = this._io.readU1();
            this.ueCategoryFlex = this._io.readU1();
            this.spidValue = this._io.readU2be();
            this.uePowerClass = this._io.readU1();
            this.brCeLevel = this._io.readU1();
            this.subscriberGroupId = this._io.readU1();
            this.uePreemptionCause = this._io.readU1();
            this.ueEndcStage = this._io.readU1();
            this.oldCombinedCovState = this._io.readU1();
            this.currentCombinedCovState = this._io.readU1();
            this.spare = new ArrayList<Integer>();
            for (int i = 0; i < 9; i++) {
                this.spare.add(this._io.readU1());
            }
            this.undefinedData = this._io.readBytes((bodyLength() - 318));
        }

        private int timestampHour;
        private int timestampMinute;
        private int timestampSecond;
        private int timestampMillisec;
        private long scannerId;
        private int rbsModuleId;
        private long globalCellId;
        private long enbs1apid;
        private long mmes1apid;
        private long gummei;
        private long racUeRef;
        private long traceRecordingSessionReference;
        private int triggeringNode;
        private int s1ReleaseCause;
        private int param3gppCauseGroup;
        private int param3gppCause;
        private int internalReleaseCause;
        private ArrayList<Integer> erabDataLost;
        private ArrayList<Integer> erabReleaseSucc;
        private ArrayList<Integer> erabReleaseReqQci;
        private ArrayList<Integer> hoOutPrepErabFail;
        private ArrayList<Integer> hoOutPrepErabFailAndDataLost;
        private ArrayList<Integer> hoOutExecErabFailAndDataLost;
        private ArrayList<Integer> erabSetupReqArp;
        private ArrayList<Integer> erabSetupReqPci;
        private ArrayList<Integer> erabSetupReqPvi;
        private int timestampStartHour;
        private int timestampStartMinute;
        private int timestampStartSecond;
        private int timestampStartMillisec;
        private int timestampStopHour;
        private int timestampStopMinute;
        private int timestampStopSecond;
        private int timestampStopMillisec;
        private int ttiBundlingMode;
        private int ta;
        private ArrayList<Integer> partialNodeRestartErabDataLost;
        private ArrayList<Integer> erabReleaseSuccGbr;
        private ArrayList<Integer> hoOutPrepErabFailGbr;
        private ArrayList<Integer> hoOutPrepErabFailAndDataLostGbr;
        private ArrayList<Integer> erabInactiveGap;
        private long tac;
        private int svn;
        private int maskedsrn;
        private int plmnIndex;
        private int ueCategoryFlex;
        private int spidValue;
        private int uePowerClass;
        private int brCeLevel;
        private int subscriberGroupId;
        private int uePreemptionCause;
        private int ueEndcStage;
        private int oldCombinedCovState;
        private int currentCombinedCovState;
        private ArrayList<Integer> spare;
        private byte[] undefinedData;
        private int bodyLength;
        private EricssonEventFile _root;
        private EricssonEventFile.TEventRecord _parent;

        public int timestampHour() {
            return timestampHour;
        }

        public int timestampMinute() {
            return timestampMinute;
        }

        public int timestampSecond() {
            return timestampSecond;
        }

        public int timestampMillisec() {
            return timestampMillisec;
        }

        public long scannerId() {
            return scannerId;
        }

        public int rbsModuleId() {
            return rbsModuleId;
        }

        public long globalCellId() {
            return globalCellId;
        }

        public long enbs1apid() {
            return enbs1apid;
        }

        public long mmes1apid() {
            return mmes1apid;
        }

        public long gummei() {
            return gummei;
        }

        public long racUeRef() {
            return racUeRef;
        }

        public long traceRecordingSessionReference() {
            return traceRecordingSessionReference;
        }

        public int triggeringNode() {
            return triggeringNode;
        }

        public int s1ReleaseCause() {
            return s1ReleaseCause;
        }

        public int param3gppCauseGroup() {
            return param3gppCauseGroup;
        }

        public int param3gppCause() {
            return param3gppCause;
        }

        public int internalReleaseCause() {
            return internalReleaseCause;
        }

        public ArrayList<Integer> erabDataLost() {
            return erabDataLost;
        }

        public ArrayList<Integer> erabReleaseSucc() {
            return erabReleaseSucc;
        }

        public ArrayList<Integer> erabReleaseReqQci() {
            return erabReleaseReqQci;
        }

        public ArrayList<Integer> hoOutPrepErabFail() {
            return hoOutPrepErabFail;
        }

        public ArrayList<Integer> hoOutPrepErabFailAndDataLost() {
            return hoOutPrepErabFailAndDataLost;
        }

        public ArrayList<Integer> hoOutExecErabFailAndDataLost() {
            return hoOutExecErabFailAndDataLost;
        }

        public ArrayList<Integer> erabSetupReqArp() {
            return erabSetupReqArp;
        }

        public ArrayList<Integer> erabSetupReqPci() {
            return erabSetupReqPci;
        }

        public ArrayList<Integer> erabSetupReqPvi() {
            return erabSetupReqPvi;
        }

        public int timestampStartHour() {
            return timestampStartHour;
        }

        public int timestampStartMinute() {
            return timestampStartMinute;
        }

        public int timestampStartSecond() {
            return timestampStartSecond;
        }

        public int timestampStartMillisec() {
            return timestampStartMillisec;
        }

        public int timestampStopHour() {
            return timestampStopHour;
        }

        public int timestampStopMinute() {
            return timestampStopMinute;
        }

        public int timestampStopSecond() {
            return timestampStopSecond;
        }

        public int timestampStopMillisec() {
            return timestampStopMillisec;
        }

        public int ttiBundlingMode() {
            return ttiBundlingMode;
        }

        public int ta() {
            return ta;
        }

        public ArrayList<Integer> partialNodeRestartErabDataLost() {
            return partialNodeRestartErabDataLost;
        }

        public ArrayList<Integer> erabReleaseSuccGbr() {
            return erabReleaseSuccGbr;
        }

        public ArrayList<Integer> hoOutPrepErabFailGbr() {
            return hoOutPrepErabFailGbr;
        }

        public ArrayList<Integer> hoOutPrepErabFailAndDataLostGbr() {
            return hoOutPrepErabFailAndDataLostGbr;
        }

        public ArrayList<Integer> erabInactiveGap() {
            return erabInactiveGap;
        }

        public long tac() {
            return tac;
        }

        public int svn() {
            return svn;
        }

        public int maskedsrn() {
            return maskedsrn;
        }

        public int plmnIndex() {
            return plmnIndex;
        }

        public int ueCategoryFlex() {
            return ueCategoryFlex;
        }

        public int spidValue() {
            return spidValue;
        }

        public int uePowerClass() {
            return uePowerClass;
        }

        public int brCeLevel() {
            return brCeLevel;
        }

        public int subscriberGroupId() {
            return subscriberGroupId;
        }

        public int uePreemptionCause() {
            return uePreemptionCause;
        }

        public int ueEndcStage() {
            return ueEndcStage;
        }

        public int oldCombinedCovState() {
            return oldCombinedCovState;
        }

        public int currentCombinedCovState() {
            return currentCombinedCovState;
        }

        public ArrayList<Integer> spare() {
            return spare;
        }

        public byte[] undefinedData() {
            return undefinedData;
        }

        public int bodyLength() {
            return bodyLength;
        }

        public EricssonEventFile _root() {
            return _root;
        }

        public EricssonEventFile.TEventRecord _parent() {
            return _parent;
        }
    }

    public static class TEvent26Body extends KaitaiStruct {
        public TEvent26Body(KaitaiStream _io, int bodyLength) {
            this(_io, null, null, bodyLength);
        }

        public TEvent26Body(KaitaiStream _io, EricssonEventFile.TEventRecord _parent, int bodyLength) {
            this(_io, _parent, null, bodyLength);
        }

        public TEvent26Body(KaitaiStream _io, EricssonEventFile.TEventRecord _parent, EricssonEventFile _root, int bodyLength) {
            super(_io);
            this._parent = _parent;
            this._root = _root;
            this.bodyLength = bodyLength;
            _read();
        }

        private void _read() {
            this.timestampHour = this._io.readU1();
            this.timestampMinute = this._io.readU1();
            this.timestampSecond = this._io.readU1();
            this.timestampMillisec = this._io.readU2be();
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
            this.traceRecordingSessionReference = this._io.readBitsIntBe(24);
            this._io.alignToByte();
            this.messageDirection = this._io.readU1();
            this.l3messageLength = this._io.readU2be();
            this.l3messageContents = this._io.readBytes(l3messageLength());
            this.crnti = this._io.readBitsIntBe(40);
            this.undefinedData = this._io.readBytes((bodyLength() - 42 - l3messageLength()));
        }

        private int timestampHour;
        private int timestampMinute;
        private int timestampSecond;
        private int timestampMillisec;
        private long scannerId;
        private int rbsModuleId;
        private long globalCellId;
        private long enbs1apid;
        private long mmes1apid;
        private long gummei;
        private long racUeRef;
        private long traceRecordingSessionReference;
        private int messageDirection;
        private int l3messageLength;
        private byte[] l3messageContents;
        private long crnti;
        private byte[] undefinedData;
        private int bodyLength;
        private EricssonEventFile _root;
        private EricssonEventFile.TEventRecord _parent;

        public int timestampHour() {
            return timestampHour;
        }

        public int timestampMinute() {
            return timestampMinute;
        }

        public int timestampSecond() {
            return timestampSecond;
        }

        public int timestampMillisec() {
            return timestampMillisec;
        }

        public long scannerId() {
            return scannerId;
        }

        public int rbsModuleId() {
            return rbsModuleId;
        }

        public long globalCellId() {
            return globalCellId;
        }

        public long enbs1apid() {
            return enbs1apid;
        }

        public long mmes1apid() {
            return mmes1apid;
        }

        public long gummei() {
            return gummei;
        }

        public long racUeRef() {
            return racUeRef;
        }

        public long traceRecordingSessionReference() {
            return traceRecordingSessionReference;
        }

        public int messageDirection() {
            return messageDirection;
        }

        public int l3messageLength() {
            return l3messageLength;
        }

        public byte[] l3messageContents() {
            return l3messageContents;
        }

        public long crnti() {
            return crnti;
        }

        public byte[] undefinedData() {
            return undefinedData;
        }

        public int bodyLength() {
            return bodyLength;
        }

        public EricssonEventFile _root() {
            return _root;
        }

        public EricssonEventFile.TEventRecord _parent() {
            return _parent;
        }
    }

    public static class TEvent5269Body extends KaitaiStruct {
        public TEvent5269Body(KaitaiStream _io, int bodyLength) {
            this(_io, null, null, bodyLength);
        }

        public TEvent5269Body(KaitaiStream _io, EricssonEventFile.TEventRecord _parent, int bodyLength) {
            this(_io, _parent, null, bodyLength);
        }

        public TEvent5269Body(KaitaiStream _io, EricssonEventFile.TEventRecord _parent, EricssonEventFile _root, int bodyLength) {
            super(_io);
            this._parent = _parent;
            this._root = _root;
            this.bodyLength = bodyLength;
            _read();
        }

        private void _read() {
            this.timestampHour = this._io.readU1();
            this.timestampMinute = this._io.readU1();
            this.timestampSecond = this._io.readU1();
            this.timestampMillisec = this._io.readU2be();
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
            this.traceRecordingSessionReference = this._io.readBitsIntBe(24);
            this._io.alignToByte();
            this.measurementId = this._io.readU1();
            this.reportConfigType = this._io.readU1();
            this.rsrpserving = this._io.readU1();
            this.rsrqserving = this._io.readU1();
            this.freq = this._io.readBitsIntBe(24);
            this._io.alignToByte();
            this.physicalCellid1 = this._io.readU2be();
            this.rssiresult1 = this._io.readU1();
            this.physicalCellid2 = this._io.readU2be();
            this.rssiresult2 = this._io.readU1();
            this.physicalCellid3 = this._io.readU2be();
            this.rssiresult3 = this._io.readU1();
            this.physicalCellid4 = this._io.readU2be();
            this.rssiresult4 = this._io.readU1();
            this.physicalCellid5 = this._io.readU2be();
            this.rssiresult5 = this._io.readU1();
            this.physicalCellid6 = this._io.readU2be();
            this.rssiresult6 = this._io.readU1();
            this.physicalCellid7 = this._io.readU2be();
            this.rssiresult7 = this._io.readU1();
            this.physicalCellid8 = this._io.readU2be();
            this.rssiresult8 = this._io.readU1();
            this.spare = new ArrayList<Integer>();
            for (int i = 0; i < 9; i++) {
                this.spare.add(this._io.readU1());
            }
            this.physicalCellid12 = this._io.readU2be();
            this.physicalCellid22 = this._io.readU2be();
            this.physicalCellid32 = this._io.readU2be();
            this.physicalCellid42 = this._io.readU2be();
            this.physicalCellid52 = this._io.readU2be();
            this.physicalCellid62 = this._io.readU2be();
            this.physicalCellid72 = this._io.readU2be();
            this.physicalCellid82 = this._io.readU2be();
            this.neighborFreq1 = this._io.readBitsIntBe(24);
            this.neighborFreq2 = this._io.readBitsIntBe(24);
            this.neighborFreq3 = this._io.readBitsIntBe(24);
            this.neighborFreq4 = this._io.readBitsIntBe(24);
            this.neighborFreq5 = this._io.readBitsIntBe(24);
            this.neighborFreq6 = this._io.readBitsIntBe(24);
            this.neighborFreq7 = this._io.readBitsIntBe(24);
            this.neighborFreq8 = this._io.readBitsIntBe(24);
            this.undefinedData = this._io.readBytes((bodyLength() - 114));
        }

        private int timestampHour;
        private int timestampMinute;
        private int timestampSecond;
        private int timestampMillisec;
        private long scannerId;
        private int rbsModuleId;
        private long globalCellId;
        private long enbs1apid;
        private long mmes1apid;
        private long gummei;
        private long racUeRef;
        private long traceRecordingSessionReference;
        private int measurementId;
        private int reportConfigType;
        private int rsrpserving;
        private int rsrqserving;
        private long freq;
        private int physicalCellid1;
        private int rssiresult1;
        private int physicalCellid2;
        private int rssiresult2;
        private int physicalCellid3;
        private int rssiresult3;
        private int physicalCellid4;
        private int rssiresult4;
        private int physicalCellid5;
        private int rssiresult5;
        private int physicalCellid6;
        private int rssiresult6;
        private int physicalCellid7;
        private int rssiresult7;
        private int physicalCellid8;
        private int rssiresult8;
        private ArrayList<Integer> spare;
        private int physicalCellid12;
        private int physicalCellid22;
        private int physicalCellid32;
        private int physicalCellid42;
        private int physicalCellid52;
        private int physicalCellid62;
        private int physicalCellid72;
        private int physicalCellid82;
        private long neighborFreq1;
        private long neighborFreq2;
        private long neighborFreq3;
        private long neighborFreq4;
        private long neighborFreq5;
        private long neighborFreq6;
        private long neighborFreq7;
        private long neighborFreq8;
        private byte[] undefinedData;
        private int bodyLength;
        private EricssonEventFile _root;
        private EricssonEventFile.TEventRecord _parent;

        public int timestampHour() {
            return timestampHour;
        }

        public int timestampMinute() {
            return timestampMinute;
        }

        public int timestampSecond() {
            return timestampSecond;
        }

        public int timestampMillisec() {
            return timestampMillisec;
        }

        public long scannerId() {
            return scannerId;
        }

        public int rbsModuleId() {
            return rbsModuleId;
        }

        public long globalCellId() {
            return globalCellId;
        }

        public long enbs1apid() {
            return enbs1apid;
        }

        public long mmes1apid() {
            return mmes1apid;
        }

        public long gummei() {
            return gummei;
        }

        public long racUeRef() {
            return racUeRef;
        }

        public long traceRecordingSessionReference() {
            return traceRecordingSessionReference;
        }

        public int measurementId() {
            return measurementId;
        }

        public int reportConfigType() {
            return reportConfigType;
        }

        public int rsrpserving() {
            return rsrpserving;
        }

        public int rsrqserving() {
            return rsrqserving;
        }

        public long freq() {
            return freq;
        }

        public int physicalCellid1() {
            return physicalCellid1;
        }

        public int rssiresult1() {
            return rssiresult1;
        }

        public int physicalCellid2() {
            return physicalCellid2;
        }

        public int rssiresult2() {
            return rssiresult2;
        }

        public int physicalCellid3() {
            return physicalCellid3;
        }

        public int rssiresult3() {
            return rssiresult3;
        }

        public int physicalCellid4() {
            return physicalCellid4;
        }

        public int rssiresult4() {
            return rssiresult4;
        }

        public int physicalCellid5() {
            return physicalCellid5;
        }

        public int rssiresult5() {
            return rssiresult5;
        }

        public int physicalCellid6() {
            return physicalCellid6;
        }

        public int rssiresult6() {
            return rssiresult6;
        }

        public int physicalCellid7() {
            return physicalCellid7;
        }

        public int rssiresult7() {
            return rssiresult7;
        }

        public int physicalCellid8() {
            return physicalCellid8;
        }

        public int rssiresult8() {
            return rssiresult8;
        }

        public ArrayList<Integer> spare() {
            return spare;
        }

        public int physicalCellid12() {
            return physicalCellid12;
        }

        public int physicalCellid22() {
            return physicalCellid22;
        }

        public int physicalCellid32() {
            return physicalCellid32;
        }

        public int physicalCellid42() {
            return physicalCellid42;
        }

        public int physicalCellid52() {
            return physicalCellid52;
        }

        public int physicalCellid62() {
            return physicalCellid62;
        }

        public int physicalCellid72() {
            return physicalCellid72;
        }

        public int physicalCellid82() {
            return physicalCellid82;
        }

        public long neighborFreq1() {
            return neighborFreq1;
        }

        public long neighborFreq2() {
            return neighborFreq2;
        }

        public long neighborFreq3() {
            return neighborFreq3;
        }

        public long neighborFreq4() {
            return neighborFreq4;
        }

        public long neighborFreq5() {
            return neighborFreq5;
        }

        public long neighborFreq6() {
            return neighborFreq6;
        }

        public long neighborFreq7() {
            return neighborFreq7;
        }

        public long neighborFreq8() {
            return neighborFreq8;
        }

        public byte[] undefinedData() {
            return undefinedData;
        }

        public int bodyLength() {
            return bodyLength;
        }

        public EricssonEventFile _root() {
            return _root;
        }

        public EricssonEventFile.TEventRecord _parent() {
            return _parent;
        }
    }

    public static class TEvent5267Body extends KaitaiStruct {
        public TEvent5267Body(KaitaiStream _io, int bodyLength) {
            this(_io, null, null, bodyLength);
        }

        public TEvent5267Body(KaitaiStream _io, EricssonEventFile.TEventRecord _parent, int bodyLength) {
            this(_io, _parent, null, bodyLength);
        }

        public TEvent5267Body(KaitaiStream _io, EricssonEventFile.TEventRecord _parent, EricssonEventFile _root, int bodyLength) {
            super(_io);
            this._parent = _parent;
            this._root = _root;
            this.bodyLength = bodyLength;
            _read();
        }

        private void _read() {
            this.timestampHour = this._io.readU1();
            this.timestampMinute = this._io.readU1();
            this.timestampSecond = this._io.readU1();
            this.timestampMillisec = this._io.readU2be();
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
            this.traceRecordingSessionReference = this._io.readBitsIntBe(24);
            this._io.alignToByte();
            this.measurementId = this._io.readU1();
            this.reportConfigType = this._io.readU1();
            this.rsrpserving = this._io.readU1();
            this.rsrqserving = this._io.readU1();
            this.freq = this._io.readBitsIntBe(24);
            this._io.alignToByte();
            this.physicalCellid1 = this._io.readU2be();
            this.rsrpresult1 = this._io.readU1();
            this.rsrqresult1 = this._io.readU1();
            this.physicalCellid2 = this._io.readU2be();
            this.rsrpresult2 = this._io.readU1();
            this.rsrqresult2 = this._io.readU1();
            this.physicalCellid3 = this._io.readU2be();
            this.rsrpresult3 = this._io.readU1();
            this.rsrqresult3 = this._io.readU1();
            this.physicalCellid4 = this._io.readU2be();
            this.rsrpresult4 = this._io.readU1();
            this.rsrqresult4 = this._io.readU1();
            this.physicalCellid5 = this._io.readU2be();
            this.rsrpresult5 = this._io.readU1();
            this.rsrqresult5 = this._io.readU1();
            this.physicalCellid6 = this._io.readU2be();
            this.rsrpresult6 = this._io.readU1();
            this.rsrqresult6 = this._io.readU1();
            this.physicalCellid7 = this._io.readU2be();
            this.rsrpresult7 = this._io.readU1();
            this.rsrqresult7 = this._io.readU1();
            this.physicalCellid8 = this._io.readU2be();
            this.rsrpresult8 = this._io.readU1();
            this.rsrqresult8 = this._io.readU1();
            this.spare = new ArrayList<Integer>();
            for (int i = 0; i < 9; i++) {
                this.spare.add(this._io.readU1());
            }
            this.undefinedData = this._io.readBytes((bodyLength() - 82));
        }

        private int timestampHour;
        private int timestampMinute;
        private int timestampSecond;
        private int timestampMillisec;
        private long scannerId;
        private int rbsModuleId;
        private long globalCellId;
        private long enbs1apid;
        private long mmes1apid;
        private long gummei;
        private long racUeRef;
        private long traceRecordingSessionReference;
        private int measurementId;
        private int reportConfigType;
        private int rsrpserving;
        private int rsrqserving;
        private long freq;
        private int physicalCellid1;
        private int rsrpresult1;
        private int rsrqresult1;
        private int physicalCellid2;
        private int rsrpresult2;
        private int rsrqresult2;
        private int physicalCellid3;
        private int rsrpresult3;
        private int rsrqresult3;
        private int physicalCellid4;
        private int rsrpresult4;
        private int rsrqresult4;
        private int physicalCellid5;
        private int rsrpresult5;
        private int rsrqresult5;
        private int physicalCellid6;
        private int rsrpresult6;
        private int rsrqresult6;
        private int physicalCellid7;
        private int rsrpresult7;
        private int rsrqresult7;
        private int physicalCellid8;
        private int rsrpresult8;
        private int rsrqresult8;
        private ArrayList<Integer> spare;
        private byte[] undefinedData;
        private int bodyLength;
        private EricssonEventFile _root;
        private EricssonEventFile.TEventRecord _parent;

        public int timestampHour() {
            return timestampHour;
        }

        public int timestampMinute() {
            return timestampMinute;
        }

        public int timestampSecond() {
            return timestampSecond;
        }

        public int timestampMillisec() {
            return timestampMillisec;
        }

        public long scannerId() {
            return scannerId;
        }

        public int rbsModuleId() {
            return rbsModuleId;
        }

        public long globalCellId() {
            return globalCellId;
        }

        public long enbs1apid() {
            return enbs1apid;
        }

        public long mmes1apid() {
            return mmes1apid;
        }

        public long gummei() {
            return gummei;
        }

        public long racUeRef() {
            return racUeRef;
        }

        public long traceRecordingSessionReference() {
            return traceRecordingSessionReference;
        }

        public int measurementId() {
            return measurementId;
        }

        public int reportConfigType() {
            return reportConfigType;
        }

        public int rsrpserving() {
            return rsrpserving;
        }

        public int rsrqserving() {
            return rsrqserving;
        }

        public long freq() {
            return freq;
        }

        public int physicalCellid1() {
            return physicalCellid1;
        }

        public int rsrpresult1() {
            return rsrpresult1;
        }

        public int rsrqresult1() {
            return rsrqresult1;
        }

        public int physicalCellid2() {
            return physicalCellid2;
        }

        public int rsrpresult2() {
            return rsrpresult2;
        }

        public int rsrqresult2() {
            return rsrqresult2;
        }

        public int physicalCellid3() {
            return physicalCellid3;
        }

        public int rsrpresult3() {
            return rsrpresult3;
        }

        public int rsrqresult3() {
            return rsrqresult3;
        }

        public int physicalCellid4() {
            return physicalCellid4;
        }

        public int rsrpresult4() {
            return rsrpresult4;
        }

        public int rsrqresult4() {
            return rsrqresult4;
        }

        public int physicalCellid5() {
            return physicalCellid5;
        }

        public int rsrpresult5() {
            return rsrpresult5;
        }

        public int rsrqresult5() {
            return rsrqresult5;
        }

        public int physicalCellid6() {
            return physicalCellid6;
        }

        public int rsrpresult6() {
            return rsrpresult6;
        }

        public int rsrqresult6() {
            return rsrqresult6;
        }

        public int physicalCellid7() {
            return physicalCellid7;
        }

        public int rsrpresult7() {
            return rsrpresult7;
        }

        public int rsrqresult7() {
            return rsrqresult7;
        }

        public int physicalCellid8() {
            return physicalCellid8;
        }

        public int rsrpresult8() {
            return rsrpresult8;
        }

        public int rsrqresult8() {
            return rsrqresult8;
        }

        public ArrayList<Integer> spare() {
            return spare;
        }

        public byte[] undefinedData() {
            return undefinedData;
        }

        public int bodyLength() {
            return bodyLength;
        }

        public EricssonEventFile _root() {
            return _root;
        }

        public EricssonEventFile.TEventRecord _parent() {
            return _parent;
        }
    }

    public static class TEvent5153Body extends KaitaiStruct {
        public TEvent5153Body(KaitaiStream _io, int bodyLength) {
            this(_io, null, null, bodyLength);
        }

        public TEvent5153Body(KaitaiStream _io, EricssonEventFile.TEventRecord _parent, int bodyLength) {
            this(_io, _parent, null, bodyLength);
        }

        public TEvent5153Body(KaitaiStream _io, EricssonEventFile.TEventRecord _parent, EricssonEventFile _root, int bodyLength) {
            super(_io);
            this._parent = _parent;
            this._root = _root;
            this.bodyLength = bodyLength;
            _read();
        }

        private void _read() {
            this.timestampHour = this._io.readU1();
            this.timestampMinute = this._io.readU1();
            this.timestampSecond = this._io.readU1();
            this.timestampMillisec = this._io.readU2be();
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
            this.traceRecordingSessionReference = this._io.readBitsIntBe(24);
            this._io.alignToByte();
            this.measurementId = this._io.readU1();
            this.reportConfigType = this._io.readU1();
            this.rsrpserving = this._io.readU1();
            this.rsrqserving = this._io.readU1();
            this.physicalCellid1 = this._io.readU2be();
            this.rsrpresult1 = this._io.readU1();
            this.rsrqresult1 = this._io.readU1();
            this.physicalCellid2 = this._io.readU2be();
            this.rsrpresult2 = this._io.readU1();
            this.rsrqresult2 = this._io.readU1();
            this.physicalCellid3 = this._io.readU2be();
            this.rsrpresult3 = this._io.readU1();
            this.rsrqresult3 = this._io.readU1();
            this.physicalCellid4 = this._io.readU2be();
            this.rsrpresult4 = this._io.readU1();
            this.rsrqresult4 = this._io.readU1();
            this.physicalCellid5 = this._io.readU2be();
            this.rsrpresult5 = this._io.readU1();
            this.rsrqresult5 = this._io.readU1();
            this.physicalCellid6 = this._io.readU2be();
            this.rsrpresult6 = this._io.readU1();
            this.rsrqresult6 = this._io.readU1();
            this.physicalCellid7 = this._io.readU2be();
            this.rsrpresult7 = this._io.readU1();
            this.rsrqresult7 = this._io.readU1();
            this.physicalCellid8 = this._io.readU2be();
            this.rsrpresult8 = this._io.readU1();
            this.rsrqresult8 = this._io.readU1();
            this.spare = new ArrayList<Integer>();
            for (int i = 0; i < 9; i++) {
                this.spare.add(this._io.readU1());
            }
            this.undefinedData = this._io.readBytes((bodyLength() - 79));
        }

        private int timestampHour;
        private int timestampMinute;
        private int timestampSecond;
        private int timestampMillisec;
        private long scannerId;
        private int rbsModuleId;
        private long globalCellId;
        private long enbs1apid;
        private long mmes1apid;
        private long gummei;
        private long racUeRef;
        private long traceRecordingSessionReference;
        private int measurementId;
        private int reportConfigType;
        private int rsrpserving;
        private int rsrqserving;
        private int physicalCellid1;
        private int rsrpresult1;
        private int rsrqresult1;
        private int physicalCellid2;
        private int rsrpresult2;
        private int rsrqresult2;
        private int physicalCellid3;
        private int rsrpresult3;
        private int rsrqresult3;
        private int physicalCellid4;
        private int rsrpresult4;
        private int rsrqresult4;
        private int physicalCellid5;
        private int rsrpresult5;
        private int rsrqresult5;
        private int physicalCellid6;
        private int rsrpresult6;
        private int rsrqresult6;
        private int physicalCellid7;
        private int rsrpresult7;
        private int rsrqresult7;
        private int physicalCellid8;
        private int rsrpresult8;
        private int rsrqresult8;
        private ArrayList<Integer> spare;
        private byte[] undefinedData;
        private int bodyLength;
        private EricssonEventFile _root;
        private EricssonEventFile.TEventRecord _parent;

        public int timestampHour() {
            return timestampHour;
        }

        public int timestampMinute() {
            return timestampMinute;
        }

        public int timestampSecond() {
            return timestampSecond;
        }

        public int timestampMillisec() {
            return timestampMillisec;
        }

        public long scannerId() {
            return scannerId;
        }

        public int rbsModuleId() {
            return rbsModuleId;
        }

        public long globalCellId() {
            return globalCellId;
        }

        public long enbs1apid() {
            return enbs1apid;
        }

        public long mmes1apid() {
            return mmes1apid;
        }

        public long gummei() {
            return gummei;
        }

        public long racUeRef() {
            return racUeRef;
        }

        public long traceRecordingSessionReference() {
            return traceRecordingSessionReference;
        }

        public int measurementId() {
            return measurementId;
        }

        public int reportConfigType() {
            return reportConfigType;
        }

        public int rsrpserving() {
            return rsrpserving;
        }

        public int rsrqserving() {
            return rsrqserving;
        }

        public int physicalCellid1() {
            return physicalCellid1;
        }

        public int rsrpresult1() {
            return rsrpresult1;
        }

        public int rsrqresult1() {
            return rsrqresult1;
        }

        public int physicalCellid2() {
            return physicalCellid2;
        }

        public int rsrpresult2() {
            return rsrpresult2;
        }

        public int rsrqresult2() {
            return rsrqresult2;
        }

        public int physicalCellid3() {
            return physicalCellid3;
        }

        public int rsrpresult3() {
            return rsrpresult3;
        }

        public int rsrqresult3() {
            return rsrqresult3;
        }

        public int physicalCellid4() {
            return physicalCellid4;
        }

        public int rsrpresult4() {
            return rsrpresult4;
        }

        public int rsrqresult4() {
            return rsrqresult4;
        }

        public int physicalCellid5() {
            return physicalCellid5;
        }

        public int rsrpresult5() {
            return rsrpresult5;
        }

        public int rsrqresult5() {
            return rsrqresult5;
        }

        public int physicalCellid6() {
            return physicalCellid6;
        }

        public int rsrpresult6() {
            return rsrpresult6;
        }

        public int rsrqresult6() {
            return rsrqresult6;
        }

        public int physicalCellid7() {
            return physicalCellid7;
        }

        public int rsrpresult7() {
            return rsrpresult7;
        }

        public int rsrqresult7() {
            return rsrqresult7;
        }

        public int physicalCellid8() {
            return physicalCellid8;
        }

        public int rsrpresult8() {
            return rsrpresult8;
        }

        public int rsrqresult8() {
            return rsrqresult8;
        }

        public ArrayList<Integer> spare() {
            return spare;
        }

        public byte[] undefinedData() {
            return undefinedData;
        }

        public int bodyLength() {
            return bodyLength;
        }

        public EricssonEventFile _root() {
            return _root;
        }

        public EricssonEventFile.TEventRecord _parent() {
            return _parent;
        }
    }

    public static class TEvent4104Body extends KaitaiStruct {
        public TEvent4104Body(KaitaiStream _io, int bodyLength) {
            this(_io, null, null, bodyLength);
        }

        public TEvent4104Body(KaitaiStream _io, EricssonEventFile.TEventRecord _parent, int bodyLength) {
            this(_io, _parent, null, bodyLength);
        }

        public TEvent4104Body(KaitaiStream _io, EricssonEventFile.TEventRecord _parent, EricssonEventFile _root, int bodyLength) {
            super(_io);
            this._parent = _parent;
            this._root = _root;
            this.bodyLength = bodyLength;
            _read();
        }

        private void _read() {
            this.timestampHour = this._io.readU1();
            this.timestampMinute = this._io.readU1();
            this.timestampSecond = this._io.readU1();
            this.timestampMillisec = this._io.readU2be();
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
            this.traceRecordingSessionReference = this._io.readBitsIntBe(24);
            this._io.alignToByte();
            this.hoSourceOrTargetType = this._io.readU1();
            this.hoTargetSelectionType = this._io.readU1();
            this.neighborCgi = this._io.readBitsIntBe(64);
            this._io.alignToByte();
            this.procHoExecOutResult = this._io.readU1();
            this.drxConfigIndex = this._io.readU1();
            this.hoOutExecErabReqBitmap = this._io.readU2be();
            this.hoOutExecErabFailBitmap = this._io.readU2be();
            this.procHoExecOutAttemptCause = this._io.readU1();
            this.erabHoExecOutQci = new ArrayList<Integer>();
            for (int i = 0; i < 16; i++) {
                this.erabHoExecOutQci.add(this._io.readU2be());
            }
            this.timestampStartHour = this._io.readU1();
            this.timestampStartMinute = this._io.readU1();
            this.timestampStartSecond = this._io.readU1();
            this.timestampStartMillisec = this._io.readU2be();
            this.timestampStopHour = this._io.readU1();
            this.timestampStopMinute = this._io.readU1();
            this.timestampStopSecond = this._io.readU1();
            this.timestampStopMillisec = this._io.readU2be();
            this.ta = this._io.readU2be();
            this.neighborPci = this._io.readU2be();
            this.triggerQuantity = this._io.readU1();
            this.tac = this._io.readU4be();
            this.svn = this._io.readU1();
            this.maskedsrn = this._io.readU1();
            this.srvccType = this._io.readU1();
            this.cgiMeasMethodType = this._io.readU1();
            this.startCgiMeasQci1 = this._io.readU1();
            this.hoAfterResync = this._io.readU1();
            this.hoOutExecErabReqBitmap2 = this._io.readBitsIntBe(24);
            this.hoOutExecErabFailBitmap2 = this._io.readBitsIntBe(24);
            this._io.alignToByte();
            this.uePowerClass = this._io.readU1();
            this.plmnIndex = this._io.readU1();
            this.ueCategoryFlex = this._io.readU1();
            this.spidValue = this._io.readU2be();
            this.brCeLevel = this._io.readU1();
            this.subscriberGroupId = this._io.readU1();
            this.ueEndcStage = this._io.readU1();
            this.erabHoExecOutServiceType = new ArrayList<Integer>();
            for (int i = 0; i < 16; i++) {
                this.erabHoExecOutServiceType.add(this._io.readU1());
            }
            this.spare = new ArrayList<Integer>();
            for (int i = 0; i < 9; i++) {
                this.spare.add(this._io.readU1());
            }
            this.neighborNcgi = this._io.readBitsIntBe(72);
            this._io.alignToByte();
            this.hoPacketForward = this._io.readU1();
            this.undefinedData = this._io.readBytes((bodyLength() - 157));
        }

        private int timestampHour;
        private int timestampMinute;
        private int timestampSecond;
        private int timestampMillisec;
        private long scannerId;
        private int rbsModuleId;
        private long globalCellId;
        private long enbs1apid;
        private long mmes1apid;
        private long gummei;
        private long racUeRef;
        private long traceRecordingSessionReference;
        private int hoSourceOrTargetType;
        private int hoTargetSelectionType;
        private long neighborCgi;
        private int procHoExecOutResult;
        private int drxConfigIndex;
        private int hoOutExecErabReqBitmap;
        private int hoOutExecErabFailBitmap;
        private int procHoExecOutAttemptCause;
        private ArrayList<Integer> erabHoExecOutQci;
        private int timestampStartHour;
        private int timestampStartMinute;
        private int timestampStartSecond;
        private int timestampStartMillisec;
        private int timestampStopHour;
        private int timestampStopMinute;
        private int timestampStopSecond;
        private int timestampStopMillisec;
        private int ta;
        private int neighborPci;
        private int triggerQuantity;
        private long tac;
        private int svn;
        private int maskedsrn;
        private int srvccType;
        private int cgiMeasMethodType;
        private int startCgiMeasQci1;
        private int hoAfterResync;
        private long hoOutExecErabReqBitmap2;
        private long hoOutExecErabFailBitmap2;
        private int uePowerClass;
        private int plmnIndex;
        private int ueCategoryFlex;
        private int spidValue;
        private int brCeLevel;
        private int subscriberGroupId;
        private int ueEndcStage;
        private ArrayList<Integer> erabHoExecOutServiceType;
        private ArrayList<Integer> spare;
        private long neighborNcgi;
        private int hoPacketForward;
        private byte[] undefinedData;
        private int bodyLength;
        private EricssonEventFile _root;
        private EricssonEventFile.TEventRecord _parent;

        public int timestampHour() {
            return timestampHour;
        }

        public int timestampMinute() {
            return timestampMinute;
        }

        public int timestampSecond() {
            return timestampSecond;
        }

        public int timestampMillisec() {
            return timestampMillisec;
        }

        public long scannerId() {
            return scannerId;
        }

        public int rbsModuleId() {
            return rbsModuleId;
        }

        public long globalCellId() {
            return globalCellId;
        }

        public long enbs1apid() {
            return enbs1apid;
        }

        public long mmes1apid() {
            return mmes1apid;
        }

        public long gummei() {
            return gummei;
        }

        public long racUeRef() {
            return racUeRef;
        }

        public long traceRecordingSessionReference() {
            return traceRecordingSessionReference;
        }

        public int hoSourceOrTargetType() {
            return hoSourceOrTargetType;
        }

        public int hoTargetSelectionType() {
            return hoTargetSelectionType;
        }

        public long neighborCgi() {
            return neighborCgi;
        }

        public int procHoExecOutResult() {
            return procHoExecOutResult;
        }

        public int drxConfigIndex() {
            return drxConfigIndex;
        }

        public int hoOutExecErabReqBitmap() {
            return hoOutExecErabReqBitmap;
        }

        public int hoOutExecErabFailBitmap() {
            return hoOutExecErabFailBitmap;
        }

        public int procHoExecOutAttemptCause() {
            return procHoExecOutAttemptCause;
        }

        public ArrayList<Integer> erabHoExecOutQci() {
            return erabHoExecOutQci;
        }

        public int timestampStartHour() {
            return timestampStartHour;
        }

        public int timestampStartMinute() {
            return timestampStartMinute;
        }

        public int timestampStartSecond() {
            return timestampStartSecond;
        }

        public int timestampStartMillisec() {
            return timestampStartMillisec;
        }

        public int timestampStopHour() {
            return timestampStopHour;
        }

        public int timestampStopMinute() {
            return timestampStopMinute;
        }

        public int timestampStopSecond() {
            return timestampStopSecond;
        }

        public int timestampStopMillisec() {
            return timestampStopMillisec;
        }

        public int ta() {
            return ta;
        }

        public int neighborPci() {
            return neighborPci;
        }

        public int triggerQuantity() {
            return triggerQuantity;
        }

        public long tac() {
            return tac;
        }

        public int svn() {
            return svn;
        }

        public int maskedsrn() {
            return maskedsrn;
        }

        public int srvccType() {
            return srvccType;
        }

        public int cgiMeasMethodType() {
            return cgiMeasMethodType;
        }

        public int startCgiMeasQci1() {
            return startCgiMeasQci1;
        }

        public int hoAfterResync() {
            return hoAfterResync;
        }

        public long hoOutExecErabReqBitmap2() {
            return hoOutExecErabReqBitmap2;
        }

        public long hoOutExecErabFailBitmap2() {
            return hoOutExecErabFailBitmap2;
        }

        public int uePowerClass() {
            return uePowerClass;
        }

        public int plmnIndex() {
            return plmnIndex;
        }

        public int ueCategoryFlex() {
            return ueCategoryFlex;
        }

        public int spidValue() {
            return spidValue;
        }

        public int brCeLevel() {
            return brCeLevel;
        }

        public int subscriberGroupId() {
            return subscriberGroupId;
        }

        public int ueEndcStage() {
            return ueEndcStage;
        }

        public ArrayList<Integer> erabHoExecOutServiceType() {
            return erabHoExecOutServiceType;
        }

        public ArrayList<Integer> spare() {
            return spare;
        }

        public long neighborNcgi() {
            return neighborNcgi;
        }

        public int hoPacketForward() {
            return hoPacketForward;
        }

        public byte[] undefinedData() {
            return undefinedData;
        }

        public int bodyLength() {
            return bodyLength;
        }

        public EricssonEventFile _root() {
            return _root;
        }

        public EricssonEventFile.TEventRecord _parent() {
            return _parent;
        }
    }

    public static class TEvent5Body extends KaitaiStruct {
        public TEvent5Body(KaitaiStream _io, int bodyLength) {
            this(_io, null, null, bodyLength);
        }

        public TEvent5Body(KaitaiStream _io, EricssonEventFile.TEventRecord _parent, int bodyLength) {
            this(_io, _parent, null, bodyLength);
        }

        public TEvent5Body(KaitaiStream _io, EricssonEventFile.TEventRecord _parent, EricssonEventFile _root, int bodyLength) {
            super(_io);
            this._parent = _parent;
            this._root = _root;
            this.bodyLength = bodyLength;
            _read();
        }

        private void _read() {
            this.timestampHour = this._io.readU1();
            this.timestampMinute = this._io.readU1();
            this.timestampSecond = this._io.readU1();
            this.timestampMillisec = this._io.readU2be();
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
            this.traceRecordingSessionReference = this._io.readBitsIntBe(24);
            this._io.alignToByte();
            this.messageDirection = this._io.readU1();
            this.l3messageLength = this._io.readU2be();
            this.l3messageContents = this._io.readBytes(l3messageLength());
            this.crnti = this._io.readBitsIntBe(40);
            this._io.alignToByte();
            this.immciValidity = this._io.readU1();
            this.undefinedData = this._io.readBytes((bodyLength() - 43 - l3messageLength()));
        }

        private int timestampHour;
        private int timestampMinute;
        private int timestampSecond;
        private int timestampMillisec;
        private long scannerId;
        private int rbsModuleId;
        private long globalCellId;
        private long enbs1apid;
        private long mmes1apid;
        private long gummei;
        private long racUeRef;
        private long traceRecordingSessionReference;
        private int messageDirection;
        private int l3messageLength;
        private byte[] l3messageContents;
        private long crnti;
        private int immciValidity;
        private byte[] undefinedData;
        private int bodyLength;
        private EricssonEventFile _root;
        private EricssonEventFile.TEventRecord _parent;

        public int timestampHour() {
            return timestampHour;
        }

        public int timestampMinute() {
            return timestampMinute;
        }

        public int timestampSecond() {
            return timestampSecond;
        }

        public int timestampMillisec() {
            return timestampMillisec;
        }

        public long scannerId() {
            return scannerId;
        }

        public int rbsModuleId() {
            return rbsModuleId;
        }

        public long globalCellId() {
            return globalCellId;
        }

        public long enbs1apid() {
            return enbs1apid;
        }

        public long mmes1apid() {
            return mmes1apid;
        }

        public long gummei() {
            return gummei;
        }

        public long racUeRef() {
            return racUeRef;
        }

        public long traceRecordingSessionReference() {
            return traceRecordingSessionReference;
        }

        public int messageDirection() {
            return messageDirection;
        }

        public int l3messageLength() {
            return l3messageLength;
        }

        public byte[] l3messageContents() {
            return l3messageContents;
        }

        public long crnti() {
            return crnti;
        }

        public int immciValidity() {
            return immciValidity;
        }

        public byte[] undefinedData() {
            return undefinedData;
        }

        public int bodyLength() {
            return bodyLength;
        }

        public EricssonEventFile _root() {
            return _root;
        }

        public EricssonEventFile.TEventRecord _parent() {
            return _parent;
        }
    }

    public static class TEvent8Body extends KaitaiStruct {
        public TEvent8Body(KaitaiStream _io, int bodyLength) {
            this(_io, null, null, bodyLength);
        }

        public TEvent8Body(KaitaiStream _io, EricssonEventFile.TEventRecord _parent, int bodyLength) {
            this(_io, _parent, null, bodyLength);
        }

        public TEvent8Body(KaitaiStream _io, EricssonEventFile.TEventRecord _parent, EricssonEventFile _root, int bodyLength) {
            super(_io);
            this._parent = _parent;
            this._root = _root;
            this.bodyLength = bodyLength;
            _read();
        }

        private void _read() {
            this.timestampHour = this._io.readU1();
            this.timestampMinute = this._io.readU1();
            this.timestampSecond = this._io.readU1();
            this.timestampMillisec = this._io.readU2be();
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
            this.traceRecordingSessionReference = this._io.readBitsIntBe(24);
            this._io.alignToByte();
            this.messageDirection = this._io.readU1();
            this.l3messageLength = this._io.readU2be();
            this.l3messageContents = this._io.readBytes(l3messageLength());
            this.crnti = this._io.readBitsIntBe(40);
            this._io.alignToByte();
            this.spare = new ArrayList<Integer>();
            for (int i = 0; i < 9; i++) {
                this.spare.add(this._io.readU1());
            }
            this.undefinedData = this._io.readBytes((bodyLength() - 51 - l3messageLength()));
        }

        private int timestampHour;
        private int timestampMinute;
        private int timestampSecond;
        private int timestampMillisec;
        private long scannerId;
        private int rbsModuleId;
        private long globalCellId;
        private long enbs1apid;
        private long mmes1apid;
        private long gummei;
        private long racUeRef;
        private long traceRecordingSessionReference;
        private int messageDirection;
        private int l3messageLength;
        private byte[] l3messageContents;
        private long crnti;
        private ArrayList<Integer> spare;
        private byte[] undefinedData;
        private int bodyLength;
        private EricssonEventFile _root;
        private EricssonEventFile.TEventRecord _parent;

        public int timestampHour() {
            return timestampHour;
        }

        public int timestampMinute() {
            return timestampMinute;
        }

        public int timestampSecond() {
            return timestampSecond;
        }

        public int timestampMillisec() {
            return timestampMillisec;
        }

        public long scannerId() {
            return scannerId;
        }

        public int rbsModuleId() {
            return rbsModuleId;
        }

        public long globalCellId() {
            return globalCellId;
        }

        public long enbs1apid() {
            return enbs1apid;
        }

        public long mmes1apid() {
            return mmes1apid;
        }

        public long gummei() {
            return gummei;
        }

        public long racUeRef() {
            return racUeRef;
        }

        public long traceRecordingSessionReference() {
            return traceRecordingSessionReference;
        }

        public int messageDirection() {
            return messageDirection;
        }

        public int l3messageLength() {
            return l3messageLength;
        }

        public byte[] l3messageContents() {
            return l3messageContents;
        }

        public long crnti() {
            return crnti;
        }

        public ArrayList<Integer> spare() {
            return spare;
        }

        public byte[] undefinedData() {
            return undefinedData;
        }

        public int bodyLength() {
            return bodyLength;
        }

        public EricssonEventFile _root() {
            return _root;
        }

        public EricssonEventFile.TEventRecord _parent() {
            return _parent;
        }
    }

    public static class TEvent4114Body extends KaitaiStruct {
        public TEvent4114Body(KaitaiStream _io, int bodyLength) {
            this(_io, null, null, bodyLength);
        }

        public TEvent4114Body(KaitaiStream _io, EricssonEventFile.TEventRecord _parent, int bodyLength) {
            this(_io, _parent, null, bodyLength);
        }

        public TEvent4114Body(KaitaiStream _io, EricssonEventFile.TEventRecord _parent, EricssonEventFile _root, int bodyLength) {
            super(_io);
            this._parent = _parent;
            this._root = _root;
            this.bodyLength = bodyLength;
            _read();
        }

        private void _read() {
            this.timestampHour = this._io.readU1();
            this.timestampMinute = this._io.readU1();
            this.timestampSecond = this._io.readU1();
            this.timestampMillisec = this._io.readU2be();
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
            this.traceRecordingSessionReference = this._io.readBitsIntBe(24);
            this._io.alignToByte();
            this.triggeringNode = this._io.readU1();
            this.s1ReleaseCause = this._io.readU1();
            this.internalReleaseCause = this._io.readU1();
            this.erabReleaseResult = this._io.readU1();
            this.erabDataLost = new ArrayList<Integer>();
            for (int i = 0; i < 16; i++) {
                this.erabDataLost.add(this._io.readU1());
            }
            this.erabReleaseReqQci = new ArrayList<Integer>();
            for (int i = 0; i < 16; i++) {
                this.erabReleaseReqQci.add(this._io.readU2be());
            }
            this.erabReleaseReqBitmap = this._io.readU2be();
            this.erabReleaseReq = this._io.readU1();
            this.erabReleaseReq3gppCauseGroup = new ArrayList<Integer>();
            for (int i = 0; i < 16; i++) {
                this.erabReleaseReq3gppCauseGroup.add(this._io.readU1());
            }
            this.erabReleaseReq3gppCause = new ArrayList<Integer>();
            for (int i = 0; i < 16; i++) {
                this.erabReleaseReq3gppCause.add(this._io.readU1());
            }
            this.erabReleaseSucc = new ArrayList<Integer>();
            for (int i = 0; i < 16; i++) {
                this.erabReleaseSucc.add(this._io.readU1());
            }
            this.erabReleaseFailure3gppCauseGroup = new ArrayList<Integer>();
            for (int i = 0; i < 16; i++) {
                this.erabReleaseFailure3gppCauseGroup.add(this._io.readU1());
            }
            this.erabReleaseFailure3gppCause = new ArrayList<Integer>();
            for (int i = 0; i < 16; i++) {
                this.erabReleaseFailure3gppCause.add(this._io.readU1());
            }
            this.erabSetupReqArp = new ArrayList<Integer>();
            for (int i = 0; i < 16; i++) {
                this.erabSetupReqArp.add(this._io.readU1());
            }
            this.erabSetupReqPci = new ArrayList<Integer>();
            for (int i = 0; i < 16; i++) {
                this.erabSetupReqPci.add(this._io.readU1());
            }
            this.erabSetupReqPvi = new ArrayList<Integer>();
            for (int i = 0; i < 16; i++) {
                this.erabSetupReqPvi.add(this._io.readU1());
            }
            this.timestampStartHour = this._io.readU1();
            this.timestampStartMinute = this._io.readU1();
            this.timestampStartSecond = this._io.readU1();
            this.timestampStartMillisec = this._io.readU2be();
            this.timestampStopHour = this._io.readU1();
            this.timestampStopMinute = this._io.readU1();
            this.timestampStopSecond = this._io.readU1();
            this.timestampStopMillisec = this._io.readU2be();
            this.erabReleaseSuccGbr = new ArrayList<Integer>();
            for (int i = 0; i < 16; i++) {
                this.erabReleaseSuccGbr.add(this._io.readU1());
            }
            this.erabInactiveGap = new ArrayList<Integer>();
            for (int i = 0; i < 16; i++) {
                this.erabInactiveGap.add(this._io.readU1());
            }
            this.tac = this._io.readU4be();
            this.svn = this._io.readU1();
            this.maskedsrn = this._io.readU1();
            this.erabReleaseReqBitmap2 = this._io.readBitsIntBe(24);
            this._io.alignToByte();
            this.plmnIndex = this._io.readU1();
            this.ueCategoryFlex = this._io.readU1();
            this.spidValue = this._io.readU2be();
            this.uePowerClass = this._io.readU1();
            this.brCeLevel = this._io.readU1();
            this.subscriberGroupId = this._io.readU1();
            this.ueEndcStage = this._io.readU1();
            this.spare = new ArrayList<Integer>();
            for (int i = 0; i < 9; i++) {
                this.spare.add(this._io.readU1());
            }
            this.undefinedData = this._io.readBytes((bodyLength() - 285));
        }

        private int timestampHour;
        private int timestampMinute;
        private int timestampSecond;
        private int timestampMillisec;
        private long scannerId;
        private int rbsModuleId;
        private long globalCellId;
        private long enbs1apid;
        private long mmes1apid;
        private long gummei;
        private long racUeRef;
        private long traceRecordingSessionReference;
        private int triggeringNode;
        private int s1ReleaseCause;
        private int internalReleaseCause;
        private int erabReleaseResult;
        private ArrayList<Integer> erabDataLost;
        private ArrayList<Integer> erabReleaseReqQci;
        private int erabReleaseReqBitmap;
        private int erabReleaseReq;
        private ArrayList<Integer> erabReleaseReq3gppCauseGroup;
        private ArrayList<Integer> erabReleaseReq3gppCause;
        private ArrayList<Integer> erabReleaseSucc;
        private ArrayList<Integer> erabReleaseFailure3gppCauseGroup;
        private ArrayList<Integer> erabReleaseFailure3gppCause;
        private ArrayList<Integer> erabSetupReqArp;
        private ArrayList<Integer> erabSetupReqPci;
        private ArrayList<Integer> erabSetupReqPvi;
        private int timestampStartHour;
        private int timestampStartMinute;
        private int timestampStartSecond;
        private int timestampStartMillisec;
        private int timestampStopHour;
        private int timestampStopMinute;
        private int timestampStopSecond;
        private int timestampStopMillisec;
        private ArrayList<Integer> erabReleaseSuccGbr;
        private ArrayList<Integer> erabInactiveGap;
        private long tac;
        private int svn;
        private int maskedsrn;
        private long erabReleaseReqBitmap2;
        private int plmnIndex;
        private int ueCategoryFlex;
        private int spidValue;
        private int uePowerClass;
        private int brCeLevel;
        private int subscriberGroupId;
        private int ueEndcStage;
        private ArrayList<Integer> spare;
        private byte[] undefinedData;
        private int bodyLength;
        private EricssonEventFile _root;
        private EricssonEventFile.TEventRecord _parent;

        public int timestampHour() {
            return timestampHour;
        }

        public int timestampMinute() {
            return timestampMinute;
        }

        public int timestampSecond() {
            return timestampSecond;
        }

        public int timestampMillisec() {
            return timestampMillisec;
        }

        public long scannerId() {
            return scannerId;
        }

        public int rbsModuleId() {
            return rbsModuleId;
        }

        public long globalCellId() {
            return globalCellId;
        }

        public long enbs1apid() {
            return enbs1apid;
        }

        public long mmes1apid() {
            return mmes1apid;
        }

        public long gummei() {
            return gummei;
        }

        public long racUeRef() {
            return racUeRef;
        }

        public long traceRecordingSessionReference() {
            return traceRecordingSessionReference;
        }

        public int triggeringNode() {
            return triggeringNode;
        }

        public int s1ReleaseCause() {
            return s1ReleaseCause;
        }

        public int internalReleaseCause() {
            return internalReleaseCause;
        }

        public int erabReleaseResult() {
            return erabReleaseResult;
        }

        public ArrayList<Integer> erabDataLost() {
            return erabDataLost;
        }

        public ArrayList<Integer> erabReleaseReqQci() {
            return erabReleaseReqQci;
        }

        public int erabReleaseReqBitmap() {
            return erabReleaseReqBitmap;
        }

        public int erabReleaseReq() {
            return erabReleaseReq;
        }

        public ArrayList<Integer> erabReleaseReq3gppCauseGroup() {
            return erabReleaseReq3gppCauseGroup;
        }

        public ArrayList<Integer> erabReleaseReq3gppCause() {
            return erabReleaseReq3gppCause;
        }

        public ArrayList<Integer> erabReleaseSucc() {
            return erabReleaseSucc;
        }

        public ArrayList<Integer> erabReleaseFailure3gppCauseGroup() {
            return erabReleaseFailure3gppCauseGroup;
        }

        public ArrayList<Integer> erabReleaseFailure3gppCause() {
            return erabReleaseFailure3gppCause;
        }

        public ArrayList<Integer> erabSetupReqArp() {
            return erabSetupReqArp;
        }

        public ArrayList<Integer> erabSetupReqPci() {
            return erabSetupReqPci;
        }

        public ArrayList<Integer> erabSetupReqPvi() {
            return erabSetupReqPvi;
        }

        public int timestampStartHour() {
            return timestampStartHour;
        }

        public int timestampStartMinute() {
            return timestampStartMinute;
        }

        public int timestampStartSecond() {
            return timestampStartSecond;
        }

        public int timestampStartMillisec() {
            return timestampStartMillisec;
        }

        public int timestampStopHour() {
            return timestampStopHour;
        }

        public int timestampStopMinute() {
            return timestampStopMinute;
        }

        public int timestampStopSecond() {
            return timestampStopSecond;
        }

        public int timestampStopMillisec() {
            return timestampStopMillisec;
        }

        public ArrayList<Integer> erabReleaseSuccGbr() {
            return erabReleaseSuccGbr;
        }

        public ArrayList<Integer> erabInactiveGap() {
            return erabInactiveGap;
        }

        public long tac() {
            return tac;
        }

        public int svn() {
            return svn;
        }

        public int maskedsrn() {
            return maskedsrn;
        }

        public long erabReleaseReqBitmap2() {
            return erabReleaseReqBitmap2;
        }

        public int plmnIndex() {
            return plmnIndex;
        }

        public int ueCategoryFlex() {
            return ueCategoryFlex;
        }

        public int spidValue() {
            return spidValue;
        }

        public int uePowerClass() {
            return uePowerClass;
        }

        public int brCeLevel() {
            return brCeLevel;
        }

        public int subscriberGroupId() {
            return subscriberGroupId;
        }

        public int ueEndcStage() {
            return ueEndcStage;
        }

        public ArrayList<Integer> spare() {
            return spare;
        }

        public byte[] undefinedData() {
            return undefinedData;
        }

        public int bodyLength() {
            return bodyLength;
        }

        public EricssonEventFile _root() {
            return _root;
        }

        public EricssonEventFile.TEventRecord _parent() {
            return _parent;
        }
    }

    public static class THorizontalVelocity extends KaitaiStruct {
        public THorizontalVelocity(KaitaiStream _io) {
            this(_io, null, null);
        }

        public THorizontalVelocity(KaitaiStream _io, KaitaiStruct _parent) {
            this(_io, _parent, null);
        }

        public THorizontalVelocity(KaitaiStream _io, KaitaiStruct _parent, KaitaiStruct _root) {
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
        private KaitaiStruct _root;
        private KaitaiStruct _parent;

        public int bearing() {
            return bearing;
        }

        public long horizontalSpeed() {
            return horizontalSpeed;
        }

        public byte[] spare() {
            return spare;
        }

        public KaitaiStruct _root() {
            return _root;
        }

        public KaitaiStruct _parent() {
            return _parent;
        }
    }

    public static class TEllipsoidPointWithAltiAndUncerEllipsoid extends KaitaiStruct {
        public TEllipsoidPointWithAltiAndUncerEllipsoid(KaitaiStream _io) {
            this(_io, null, null);
        }

        public TEllipsoidPointWithAltiAndUncerEllipsoid(KaitaiStream _io, KaitaiStruct _parent) {
            this(_io, _parent, null);
        }

        public TEllipsoidPointWithAltiAndUncerEllipsoid(KaitaiStream _io, KaitaiStruct _parent, KaitaiStruct _root) {
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
        private KaitaiStruct _root;
        private KaitaiStruct _parent;

        public int latitudeSign() {
            return latitudeSign;
        }

        public long degreesLatitude() {
            return degreesLatitude;
        }

        public long degreesLongitude() {
            return degreesLongitude;
        }

        public int altitudeDirection() {
            return altitudeDirection;
        }

        public int altitude() {
            return altitude;
        }

        public int uncertaintySemiMajor() {
            return uncertaintySemiMajor;
        }

        public int uncertaintySemiMinor() {
            return uncertaintySemiMinor;
        }

        public int orientaionMajorAxis() {
            return orientaionMajorAxis;
        }

        public int uncertaintyAltitude() {
            return uncertaintyAltitude;
        }

        public int confidence() {
            return confidence;
        }

        public byte[] spare() {
            return spare;
        }

        public KaitaiStruct _root() {
            return _root;
        }

        public KaitaiStruct _parent() {
            return _parent;
        }
    }

    public static class TEllipsoidPointWithUncerCircle extends KaitaiStruct {

        public TEllipsoidPointWithUncerCircle(KaitaiStream _io) {
            this(_io, null, null);
        }

        public TEllipsoidPointWithUncerCircle(KaitaiStream _io, KaitaiStruct _parent) {
            this(_io, _parent, null);
        }

        public TEllipsoidPointWithUncerCircle(KaitaiStream _io, KaitaiStruct _parent, KaitaiStruct _root) {
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
        private KaitaiStruct _root;
        private KaitaiStruct _parent;

        public int latitudeSign() {
            return latitudeSign;
        }

        public long degreesLatitude() {
            return degreesLatitude;
        }

        public long degreesLongitude() {
            return degreesLongitude;
        }

        public int uncertainty() {
            return uncertainty;
        }

        public KaitaiStruct _root() {
            return _root;
        }

        public KaitaiStruct _parent() {
            return _parent;
        }
    }

    public static class TEllipsoidPointWithAlti extends KaitaiStruct {

        public TEllipsoidPointWithAlti(KaitaiStream _io) {
            this(_io, null, null);
        }

        public TEllipsoidPointWithAlti(KaitaiStream _io, KaitaiStruct _parent) {
            this(_io, _parent, null);
        }

        public TEllipsoidPointWithAlti(KaitaiStream _io, KaitaiStruct _parent, KaitaiStruct _root) {
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
        private KaitaiStruct _root;
        private KaitaiStruct _parent;

        public int latitudeSign() {
            return latitudeSign;
        }

        public long degreesLatitude() {
            return degreesLatitude;
        }

        public long degreesLongitude() {
            return degreesLongitude;
        }

        public int altitudeDirection() {
            return altitudeDirection;
        }

        public int altitude() {
            return altitude;
        }

        public byte[] spare() {
            return spare;
        }

        public KaitaiStruct _root() {
            return _root;
        }

        public KaitaiStruct _parent() {
            return _parent;
        }
    }

    public static class TPolygon extends KaitaiStruct {

        public TPolygon(KaitaiStream _io) {
            this(_io, null, null);
        }

        public TPolygon(KaitaiStream _io, KaitaiStruct _parent) {
            this(_io, _parent, null);
        }

        public TPolygon(KaitaiStream _io, KaitaiStruct _parent, KaitaiStruct _root) {
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
        private KaitaiStruct _root;
        private KaitaiStruct _parent;

        public int latitudeSign() {
            return latitudeSign;
        }

        public long degreesLatitude() {
            return degreesLatitude;
        }

        public long degreesLongitude() {
            return degreesLongitude;
        }

        public byte[] spare() {
            return spare;
        }

        public KaitaiStruct _root() {
            return _root;
        }

        public KaitaiStruct _parent() {
            return _parent;
        }
    }

    public static class TEllipsoidPoint extends KaitaiStruct {

        public TEllipsoidPoint(KaitaiStream _io) {
            this(_io, null, null);
        }

        public TEllipsoidPoint(KaitaiStream _io, KaitaiStruct _parent) {
            this(_io, _parent, null);
        }

        public TEllipsoidPoint(KaitaiStream _io, KaitaiStruct _parent, KaitaiStruct _root) {
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
        private KaitaiStruct _root;
        private KaitaiStruct _parent;

        public int latitudeSign() {
            return latitudeSign;
        }

        public long degreesLatitude() {
            return degreesLatitude;
        }

        public long degreesLongitude() {
            return degreesLongitude;
        }

        public byte[] spare() {
            return spare;
        }

        public KaitaiStruct _root() {
            return _root;
        }

        public KaitaiStruct _parent() {
            return _parent;
        }
    }

    public static class TEllipsoidArc extends KaitaiStruct {
        public static TEllipsoidArc fromFile(String fileName) throws IOException {
            return new TEllipsoidArc(new ByteBufferKaitaiStream(fileName));
        }

        public TEllipsoidArc(KaitaiStream _io) {
            this(_io, null, null);
        }

        public TEllipsoidArc(KaitaiStream _io, KaitaiStruct _parent) {
            this(_io, _parent, null);
        }

        public TEllipsoidArc(KaitaiStream _io, KaitaiStruct _parent, KaitaiStruct _root) {
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
        private KaitaiStruct _root;
        private KaitaiStruct _parent;

        public int latitudeSign() {
            return latitudeSign;
        }

        public long degreesLatitude() {
            return degreesLatitude;
        }

        public long degreesLongitude() {
            return degreesLongitude;
        }

        public int innerRadius() {
            return innerRadius;
        }

        public int uncertaintyRadius() {
            return uncertaintyRadius;
        }

        public int offsetAngle() {
            return offsetAngle;
        }

        public int includedAngle() {
            return includedAngle;
        }

        public int confidence() {
            return confidence;
        }

        public byte[] spare() {
            return spare;
        }

        public KaitaiStruct _root() {
            return _root;
        }

        public KaitaiStruct _parent() {
            return _parent;
        }
    }

    public static class TEllipsoidPointWithUncerEllipse extends KaitaiStruct {
        public TEllipsoidPointWithUncerEllipse(KaitaiStream _io) {
            this(_io, null, null);
        }

        public TEllipsoidPointWithUncerEllipse(KaitaiStream _io, KaitaiStruct _parent) {
            this(_io, _parent, null);
        }

        public TEllipsoidPointWithUncerEllipse(KaitaiStream _io, KaitaiStruct _parent, KaitaiStruct _root) {
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
        private KaitaiStruct _root;
        private KaitaiStruct _parent;

        public int latitudeSign() {
            return latitudeSign;
        }

        public long degreesLatitude() {
            return degreesLatitude;
        }

        public long degreesLongitude() {
            return degreesLongitude;
        }

        public int uncertaintySemiMajor() {
            return uncertaintySemiMajor;
        }

        public int uncertaintySemiMinor() {
            return uncertaintySemiMinor;
        }

        public int orientaionMajorAxis() {
            return orientaionMajorAxis;
        }

        public int confidence() {
            return confidence;
        }

        public byte[] spare() {
            return spare;
        }

        public KaitaiStruct _root() {
            return _root;
        }

        public KaitaiStruct _parent() {
            return _parent;
        }
    }

    public static class TE3115MdtM4ErabPdcpVolBlock extends KaitaiStruct {
        public static TE3115MdtM4ErabPdcpVolBlock fromFile(String fileName) throws IOException {
            return new TE3115MdtM4ErabPdcpVolBlock(new ByteBufferKaitaiStream(fileName));
        }

        public TE3115MdtM4ErabPdcpVolBlock(KaitaiStream _io) {
            this(_io, null, null);
        }

        public TE3115MdtM4ErabPdcpVolBlock(KaitaiStream _io, EricssonEventFile.TEvent3115Body _parent) {
            this(_io, _parent, null);
        }

        public TE3115MdtM4ErabPdcpVolBlock(KaitaiStream _io, EricssonEventFile.TEvent3115Body _parent, EricssonEventFile _root) {
            super(_io);
            this._parent = _parent;
            this._root = _root;
            _read();
        }

        private void _read() {
            this.mdtM4ErabPdcpVol = this._io.readBitsIntBe(40);
        }

        private long mdtM4ErabPdcpVol;
        private EricssonEventFile _root;
        private EricssonEventFile.TEvent3115Body _parent;

        public long mdtM4ErabPdcpVol() {
            return mdtM4ErabPdcpVol;
        }

        public EricssonEventFile _root() {
            return _root;
        }

        public EricssonEventFile.TEvent3115Body _parent() {
            return _parent;
        }
    }

    public static class TE3112MdtM1EllipsoidPointWithUncerCircle extends KaitaiStruct {
        public static TE3112MdtM1EllipsoidPointWithUncerCircle fromFile(String fileName) throws IOException {
            return new TE3112MdtM1EllipsoidPointWithUncerCircle(new ByteBufferKaitaiStream(fileName));
        }

        public TE3112MdtM1EllipsoidPointWithUncerCircle(KaitaiStream _io) {
            this(_io, null, null);
        }

        public TE3112MdtM1EllipsoidPointWithUncerCircle(KaitaiStream _io, EricssonEventFile.TEvent3112Body _parent) {
            this(_io, _parent, null);
        }

        public TE3112MdtM1EllipsoidPointWithUncerCircle(KaitaiStream _io, EricssonEventFile.TEvent3112Body _parent, EricssonEventFile _root) {
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
        private EricssonEventFile _root;
        private EricssonEventFile.TEvent3112Body _parent;

        public int latitudeSign() {
            return latitudeSign;
        }

        public long degreesLatitude() {
            return degreesLatitude;
        }

        public long degreesLongitude() {
            return degreesLongitude;
        }

        public int uncertainty() {
            return uncertainty;
        }

        public EricssonEventFile _root() {
            return _root;
        }

        public EricssonEventFile.TEvent3112Body _parent() {
            return _parent;
        }
    }

    public static class TE3112MdtM1EllipsoidPointWithAltiAndUncerEllipsoid extends KaitaiStruct {
        public static TE3112MdtM1EllipsoidPointWithAltiAndUncerEllipsoid fromFile(String fileName) throws IOException {
            return new TE3112MdtM1EllipsoidPointWithAltiAndUncerEllipsoid(new ByteBufferKaitaiStream(fileName));
        }

        public TE3112MdtM1EllipsoidPointWithAltiAndUncerEllipsoid(KaitaiStream _io) {
            this(_io, null, null);
        }

        public TE3112MdtM1EllipsoidPointWithAltiAndUncerEllipsoid(KaitaiStream _io, EricssonEventFile.TEvent3112Body _parent) {
            this(_io, _parent, null);
        }

        public TE3112MdtM1EllipsoidPointWithAltiAndUncerEllipsoid(KaitaiStream _io, EricssonEventFile.TEvent3112Body _parent, EricssonEventFile _root) {
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
        private EricssonEventFile _root;
        private EricssonEventFile.TEvent3112Body _parent;

        public int latitudeSign() {
            return latitudeSign;
        }

        public long degreesLatitude() {
            return degreesLatitude;
        }

        public long degreesLongitude() {
            return degreesLongitude;
        }

        public int altitudeDirection() {
            return altitudeDirection;
        }

        public int altitude() {
            return altitude;
        }

        public int uncertaintySemiMajor() {
            return uncertaintySemiMajor;
        }

        public int uncertaintySemiMinor() {
            return uncertaintySemiMinor;
        }

        public int orientaionMajorAxis() {
            return orientaionMajorAxis;
        }

        public int uncertaintyAltitude() {
            return uncertaintyAltitude;
        }

        public int confidence() {
            return confidence;
        }

        public byte[] spare() {
            return spare;
        }

        public EricssonEventFile _root() {
            return _root;
        }

        public EricssonEventFile.TEvent3112Body _parent() {
            return _parent;
        }
    }

    private ArrayList<TEventRecord> eventRecords;
    private EricssonEventFile _root;
    private KaitaiStruct _parent;

    public ArrayList<TEventRecord> eventRecords() {
        return eventRecords;
    }

    public EricssonEventFile _root() {
        return _root;
    }

    public KaitaiStruct _parent() {
        return _parent;
    }
}
