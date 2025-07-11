package com.altria.dialog.decoders.ericsson;

import com.google.gson.ExclusionStrategy;
import com.google.gson.FieldAttributes;

public class EricssonFieldExclusionStrategy implements ExclusionStrategy {
    @Override
    public boolean shouldSkipField(FieldAttributes f) {
        String fieldName = f.getName();
        return fieldName.startsWith("_") || fieldName.equals("undefinedData");
    }

    @Override
    public boolean shouldSkipClass(Class<?> aClass) {
        return false;
    }
}
