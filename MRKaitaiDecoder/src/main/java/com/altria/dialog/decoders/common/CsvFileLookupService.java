package com.altria.dialog.decoders.common;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;

import java.io.*;
import java.util.*;

public class CsvFileLookupService implements RecordLookupService {

    private String filepath;
    private String keyField;
    private Map<String, CSVRecord> recordMap = new HashMap<>();
    private HashSet<String> duplicates = new HashSet<>();

    public CsvFileLookupService(String filepath, String keyField) {

        this.filepath = filepath;
        this.keyField = keyField;
        this.load();
    }

    public boolean load() {
        boolean success = false;
        HashMap<String, CSVRecord> tempMap = new HashMap<>();
        int counter = 0;
        try (BufferedReader reader = new BufferedReader(new FileReader(this.filepath))){
            CSVParser parser = CSVParser.parse(reader,  CSVFormat.RFC4180.withFirstRecordAsHeader());
            for (CSVRecord record: parser) {
                String keyValue = record.get(this.keyField);
                if (tempMap.containsKey(keyValue)) {
                    duplicates.add(keyValue);
                } else {
                    tempMap.put(keyValue, record);
                }
                counter++;
            }
            success = true;
        } catch (IOException e) {
            System.err.println("ERROR:" + e.getMessage());
        } finally {
            System.out.println("Total/Map: " + counter + "/" + tempMap.size());
            System.out.println(String.format("Duplicates(%d): %s", duplicates.size(), duplicates));
        }
        this.recordMap = Collections.unmodifiableMap(tempMap);
        return success;
    }

    @Override
    public Map<String, String> lookup(String key) {
        CSVRecord record = this.recordMap.get(key);
        if (record == null) return null;

        return record.toMap();
    }
}
