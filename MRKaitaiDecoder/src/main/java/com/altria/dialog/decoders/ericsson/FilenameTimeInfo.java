package com.altria.dialog.decoders.ericsson;

import com.altria.dialog.decoders.common.ConversionHelper;

import java.util.regex.Matcher;

public class FilenameTimeInfo {
    private final String fileName;
    private final String year;
    private final String month;
    private final String date;
    private final String startTime;
    private final String endTime;
    private final String startYmd;
    private final String endYmd;
    private final int hourInc;
    private final int minuteInc;

    public String getFileName() {
        return fileName;
    }

    public String getYear() {
        return year;
    }

    public String getMonth() {
        return month;
    }

    public String getDate() {
        return date;
    }

    public String getStartTime() {
        return startTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public String getStartYmd() {
        return startYmd;
    }

    public String getEndYmd() {
        return endYmd;
    }

    public int getHourInc() {
        return hourInc;
    }

    public int getMinuteInc() {
        return minuteInc;
    }

    private FilenameTimeInfo(String fileName,
                             String year,
                             String month,
                             String date,
                             String startTime,
                             String endTime,
                             String startYmd,
                             String endYmd,
                             int hourInc,
                             int minuteInc) {
        this.fileName = fileName;
        this.year = year;
        this.month = month;
        this.date = date;
        this.startTime = startTime;
        this.endTime = endTime;
        this.startYmd = startYmd;
        this.endYmd = endYmd;
        this.hourInc = hourInc;
        this.minuteInc = minuteInc;
    }

    public static FilenameTimeInfo build(String fileName) {
        String year = fileName.substring(1,5);
        String month = fileName.substring(5,7);
        String date = fileName.substring(7,9);
        String startTime = String.format("%s:%s", fileName.substring(10,12), fileName.substring(12,14));
        String endTime = String.format("%s:%s", fileName.substring(20,22), fileName.substring(22,24));
        String startYmd = String.format("%s-%s-%s %s:00.000", year, month, date, startTime);
        String endYmd = String.format("%s-%s-%s %s:00.000", year, month, date, endTime);

        int hourInc = 0;
        int minuteInc = 0;

        Matcher matcher = ConversionHelper.FILENAME_TZ_PATTERN.matcher(fileName);
        if (matcher.find()) {
            String group1 = matcher.group();
            String hourMinuteInc = group1.substring(1, group1.length()-1);
            hourInc = Integer.parseInt(hourMinuteInc.substring(0,2));
            minuteInc = Integer.parseInt(hourMinuteInc.substring(2));
        }

        return new FilenameTimeInfo(fileName, year, month, date, startTime, endTime, startYmd, endYmd, hourInc, minuteInc);
    }
}
