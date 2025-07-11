package com.altria.dialog.decoders.common;

import com.google.gson.ExclusionStrategy;
import com.google.gson.FieldAttributes;

public class KaitaiFieldExclusionStrategy implements ExclusionStrategy {

    @Override
    public boolean shouldSkipField(FieldAttributes f) {
        return f.getName().startsWith("_");
    }

    @Override
    public boolean shouldSkipClass(Class<?> aClass) {
        return false;
    }
}

