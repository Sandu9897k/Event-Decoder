package com.altria.dialog.decoders.common;

import java.util.HashMap;
import java.util.Map;

public class CollectionHelper {
    public static <K,V> Map<K, V> updateMap(Map<K, V> parent, Map<K,V> child) {
        for (K key: child.keySet()) {
            parent.put(key, child.get(key));
        }

        return parent;
    }
}
