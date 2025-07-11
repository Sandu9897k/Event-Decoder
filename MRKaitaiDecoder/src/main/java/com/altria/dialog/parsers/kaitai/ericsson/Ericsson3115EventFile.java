// This is a generated file! Please edit source .ksy file and use kaitai-struct-compiler to rebuild
package com.altria.dialog.parsers.kaitai.ericsson;

import io.kaitai.struct.ByteBufferKaitaiStream;
import io.kaitai.struct.KaitaiStruct;
import io.kaitai.struct.KaitaiStream;
import java.io.IOException;
import java.util.ArrayList;

public class Ericsson3115EventFile extends KaitaiStruct {
    public static Ericsson3115EventFile fromFile(String fileName) throws IOException {
        return new Ericsson3115EventFile(new ByteBufferKaitaiStream(fileName));
    }

    public Ericsson3115EventFile(KaitaiStream _io) {
        this(_io, null, null);
    }

    public Ericsson3115EventFile(KaitaiStream _io, KaitaiStruct _parent) {
        this(_io, _parent, null);
    }

    public Ericsson3115EventFile(KaitaiStream _io, KaitaiStruct _parent, Ericsson3115EventFile _root) {
        super(_io);
        this._parent = _parent;
        this._root = _root == null ? this : _root;
        _read();
    }
    private void _read() {
        this.eventRecords = new ArrayList<TEvent3115Type>();
        {
            int i = 0;
            while (!this._io.isEof()) {
                this.eventRecords.add(new TEvent3115Type(this._io, this, _root));
                i++;
            }
        }
    }
    public static class TEvent3115Type extends KaitaiStruct {
        public static TEvent3115Type fromFile(String fileName) throws IOException {
            return new TEvent3115Type(new ByteBufferKaitaiStream(fileName));
        }

        public TEvent3115Type(KaitaiStream _io) {
            this(_io, null, null);
        }

        public TEvent3115Type(KaitaiStream _io, Ericsson3115EventFile _parent) {
            this(_io, _parent, null);
        }

        public TEvent3115Type(KaitaiStream _io, Ericsson3115EventFile _parent, Ericsson3115EventFile _root) {
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
            this.mdtM4ErabPdcpVolUl = new ArrayList<Long>();
            for (int i = 0; i < 16; i++) {
                this.mdtM4ErabPdcpVolUl.add(this._io.readBitsIntBe(40));
            }
            this.mdtM4ErabPdcpVolDl = new ArrayList<Long>();
            for (int i = 0; i < 16; i++) {
                this.mdtM4ErabPdcpVolDl.add(this._io.readBitsIntBe(40));
            }
            this._io.alignToByte();
            this.mdtM4M5ErabQci = new ArrayList<Integer>();
            for (int i = 0; i < 16; i++) {
                this.mdtM4M5ErabQci.add(this._io.readU2be());
            }
            this.spare = new ArrayList<Integer>();
            for (int i = 0; i < 9; i++) {
                this.spare.add(this._io.readU1());
            }
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
        private ArrayList<Long> mdtM4ErabPdcpVolUl;
        private ArrayList<Long> mdtM4ErabPdcpVolDl;
        private ArrayList<Integer> mdtM4M5ErabQci;
        private ArrayList<Integer> spare;
        private Ericsson3115EventFile _root;
        private Ericsson3115EventFile _parent;
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
        public ArrayList<Long> mdtM4ErabPdcpVolUl() { return mdtM4ErabPdcpVolUl; }
        public ArrayList<Long> mdtM4ErabPdcpVolDl() { return mdtM4ErabPdcpVolDl; }
        public ArrayList<Integer> mdtM4M5ErabQci() { return mdtM4M5ErabQci; }
        public ArrayList<Integer> spare() { return spare; }
        public Ericsson3115EventFile _root() { return _root; }
        public Ericsson3115EventFile _parent() { return _parent; }
    }
    public static class TEventHeader extends KaitaiStruct {
        public static TEventHeader fromFile(String fileName) throws IOException {
            return new TEventHeader(new ByteBufferKaitaiStream(fileName));
        }

        public TEventHeader(KaitaiStream _io) {
            this(_io, null, null);
        }

        public TEventHeader(KaitaiStream _io, Ericsson3115EventFile.TEvent3115Type _parent) {
            this(_io, _parent, null);
        }

        public TEventHeader(KaitaiStream _io, Ericsson3115EventFile.TEvent3115Type _parent, Ericsson3115EventFile _root) {
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
        private Ericsson3115EventFile _root;
        private Ericsson3115EventFile.TEvent3115Type _parent;
        public int eventLength() { return eventLength; }
        public int eventType() { return eventType; }
        public long eventId() { return eventId; }
        public Ericsson3115EventFile _root() { return _root; }
        public Ericsson3115EventFile.TEvent3115Type _parent() { return _parent; }
    }
    private ArrayList<TEvent3115Type> eventRecords;
    private Ericsson3115EventFile _root;
    private KaitaiStruct _parent;
    public ArrayList<TEvent3115Type> eventRecords() { return eventRecords; }
    public Ericsson3115EventFile _root() { return _root; }
    public KaitaiStruct _parent() { return _parent; }
}
