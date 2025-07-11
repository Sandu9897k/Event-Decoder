package com.altria.dialog.decoders.huawei;

import java.util.HashMap;
import java.util.Set;

public class PowerMap<V> {

    //              <callId, <servCellId, <timestamp, PowerMapValue>>>
    private HashMap<Long, HashMap<Long, HashMap<Long, V>>> map = new HashMap<>();

    public V put(long callId, long servCellId, long timestamp, V value) {
        HashMap<Long, HashMap<Long, V>> callMap = map.get(callId);
        if (callMap == null) {
            callMap = new HashMap<>();
            this.map.put(callId, callMap);
        }

        HashMap<Long, V> servCellMap = callMap.get(servCellId);
        if (servCellMap == null) {
            servCellMap = new HashMap<>();
            callMap.put(servCellId, servCellMap);
        }

        return servCellMap.put(timestamp, value);
    }

    public Set<Long> callIdKeys() {
        return this.map.keySet();
    }

    public Set<Long> servCellIdKeys(Long callId) {
        return this.map.getOrDefault(callId, new HashMap<>()).keySet();
    }

    public Set<Long> timestampKeys(Long callId, Long servCellId) {
        return this.map.getOrDefault(callId, new HashMap<>())
                .getOrDefault(servCellId, new HashMap<>()).keySet();
    }

    public V get(Long callId, Long servCellId, Long timestamp) {
        return this.map.getOrDefault(callId, new HashMap<>())
                .getOrDefault(servCellId, new HashMap<>())
                .get(timestamp);
    }
}
