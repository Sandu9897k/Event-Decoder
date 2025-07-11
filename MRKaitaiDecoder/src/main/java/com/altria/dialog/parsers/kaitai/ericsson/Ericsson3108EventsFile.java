// This is a generated file! Please edit source .ksy file and use kaitai-struct-compiler to rebuild

package com.altria.dialog.parsers.kaitai.ericsson;

import io.kaitai.struct.ByteBufferKaitaiStream;
import io.kaitai.struct.KaitaiStruct;
import io.kaitai.struct.KaitaiStream;
import java.io.IOException;
import java.util.ArrayList;

public class Ericsson3108EventsFile extends KaitaiStruct {
    public static Ericsson3108EventsFile fromFile(String fileName) throws IOException {
        return new Ericsson3108EventsFile(new ByteBufferKaitaiStream(fileName));
    }

    public Ericsson3108EventsFile(KaitaiStream _io) {
        this(_io, null, null);
    }

    public Ericsson3108EventsFile(KaitaiStream _io, KaitaiStruct _parent) {
        this(_io, _parent, null);
    }

    public Ericsson3108EventsFile(KaitaiStream _io, KaitaiStruct _parent, Ericsson3108EventsFile _root) {
        super(_io);
        this._parent = _parent;
        this._root = _root == null ? this : _root;
        _read();
    }
    private void _read() {
        this.event = new ArrayList<TEventType>();
        {
            int i = 0;
            while (!this._io.isEof()) {
                this.event.add(new TEventType(this._io, this, _root));
                i++;
            }
        }
    }
    public static class TEventType extends KaitaiStruct {
        public static TEventType fromFile(String fileName) throws IOException {
            return new TEventType(new ByteBufferKaitaiStream(fileName));
        }

        public TEventType(KaitaiStream _io) {
            this(_io, null, null);
        }

        public TEventType(KaitaiStream _io, Ericsson3108EventsFile _parent) {
            this(_io, _parent, null);
        }

        public TEventType(KaitaiStream _io, Ericsson3108EventsFile _parent, Ericsson3108EventsFile _root) {
            super(_io);
            this._parent = _parent;
            this._root = _root;
            _read();
        }
        private void _read() {
            this.eventLength = this._io.readU2be();
            this.eventType = this._io.readU2be();
            this.eventId = this._io.readBitsIntBe(24);
            this._io.alignToByte();
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
            undefined = new ArrayList<Integer>(((Number) (5)).intValue());
            for (int i = 0; i < 5; i++) {
                this.undefined.add(this._io.readU1());
            }
        }
        private int eventLength;
        private int eventType;
        private long eventId;
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
        private ArrayList<Integer> undefined;
        private Ericsson3108EventsFile _root;
        private Ericsson3108EventsFile _parent;
        public int eventLength() { return eventLength; }
        public int eventType() { return eventType; }
        public long eventId() { return eventId; }
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
        public int startTimestampHour() { return startTimestampHour; }
        public int startTimestampMinute() { return startTimestampMinute; }
        public int startTimestampSecond() { return startTimestampSecond; }
        public int startTimestampMillisecond() { return startTimestampMillisecond; }
        public int taInterval() { return taInterval; }
        public ArrayList<Integer> ta() { return ta; }
        public ArrayList<Integer> spare() { return spare; }
        public ArrayList<Integer> undefined() { return undefined; }
        public Ericsson3108EventsFile _root() { return _root; }
        public Ericsson3108EventsFile _parent() { return _parent; }
    }
    private ArrayList<TEventType> event;
    private Ericsson3108EventsFile _root;
    private KaitaiStruct _parent;
    public ArrayList<TEventType> event() { return event; }
    public Ericsson3108EventsFile _root() { return _root; }
    public KaitaiStruct _parent() { return _parent; }
}
