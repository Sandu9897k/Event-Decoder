package com.altria.dialog.decoders.common;

import java.util.HashMap;
import java.util.Map;

public interface RecordLookupService {
    Map<String, String> lookup(String key);
}
