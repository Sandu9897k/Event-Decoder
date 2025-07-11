package com.altria.dialog.decoders.ericsson;

import com.altria.dialog.parsers.kaitai.ericsson.EricssonEventFile;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Set;

public class SessionMap {

    private HashMap<List<Long>, HashMap<Long, ArrayList<EricssonEventFile.TEventRecord>>> map = new HashMap<>();

    public boolean containsKey(List<Long> key) {
        return this.map.containsKey(key);
    }

    public ArrayList<EricssonEventFile.TEventRecord> get(List<Long> key, Long eventId) {
        if (this.map.containsKey(key) && this.map.get(key).containsKey(eventId)) {
            return this.map.get(key).get(eventId);
        }

        return null;
    }

    public void put(List<Long> key, Long eventId, EricssonEventFile.TEventRecord value) {
        HashMap<Long, ArrayList<EricssonEventFile.TEventRecord>> eventMap;
        if (this.map.containsKey(key)) {
            eventMap = this.map.get(key);
        } else {
            eventMap = new HashMap<>();
            this.map.put(key, eventMap);
        }

        ArrayList<EricssonEventFile.TEventRecord> timeList;

        if (eventMap.containsKey(eventId)) {
            timeList = eventMap.get(eventId);
        } else {
            timeList = new ArrayList<>();
            eventMap.put(eventId, timeList);
        }

        timeList.add(value);
    }

    public Set<List<Long>> keySet() {
        return this.map.keySet();
    }

    public boolean containsEventId(List<Long> key, Long eventId) {
        return this.map.containsKey(key) && this.map.get(key).containsKey(eventId);
    }
}
