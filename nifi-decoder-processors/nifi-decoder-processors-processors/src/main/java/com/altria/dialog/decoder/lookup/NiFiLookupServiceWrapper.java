//package com.altria.dialog.decoder.lookup;
//
//import com.altria.dialog.decoders.common.RecordLookupService;
//import org.apache.nifi.lookup.LookupFailureException;
//import org.apache.nifi.lookup.LookupService;
//import org.apache.nifi.serialization.record.Record;
//
//import java.util.Collections;
//import java.util.Map;
//import java.util.Optional;
//
//public class NiFiLookupServiceWrapper implements RecordLookupService {
//    private LookupService nifiLookupService;
//
//    public NiFiLookupServiceWrapper(LookupService lookupService) {
//        this.nifiLookupService = lookupService;
//    }
//
//    @Override
//    public Map<String, String> lookup(String keyValue) {
//        try {
//            final Optional<Record> record =  this.nifiLookupService.lookup(Collections.singletonMap("key", keyValue));
//            // Java genetics are all just Objects
//            if (record.isPresent()) {
//                return (Map)record.get().toMap();
//            } else {
//                return null;
//            }
//        } catch (LookupFailureException e) {
//            return null;
//        }
//    }
//}
