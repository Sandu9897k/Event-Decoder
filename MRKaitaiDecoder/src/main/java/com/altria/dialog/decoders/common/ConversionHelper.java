package com.altria.dialog.decoders.common;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Collection;
import java.util.regex.Pattern;
import java.util.stream.LongStream;
import ch.hsr.geohash.GeoHash;

public class ConversionHelper {

    public static final int ONE_BYTE_INVALID_VALUE = (int)Math.pow(2, 1*8 - 1);             // 128
    public static final int TWO_BYTE_INVALID_VALUE = (int)Math.pow(2, 2*8 - 1);             // 32768
    public static final long THREE_BYTE_INVALID_VALUE = (long)Math.pow(2, 3*8 - 1);         // 8388608
    public static final long FOUR_BYTE_INVALID_VALUE = (long)Math.pow(2, 4*8 - 1);          // 2147483648
    public static final int PRECISION = 8;

    public static final long GAP_15MIN_IN_MILLISECONDS = 900_000;   // 15x60sx1000ms

    public static final Pattern FILENAME_TZ_PATTERN = Pattern.compile("\\+\\d\\d\\d\\d-");

    public static final int NONSECONDS_PER_MILLI = 1000_000;
    public static ZoneId ZONE_COLOMBO = ZoneId.of("Asia/Colombo");
    public static ZoneId ZONE_SYDNEY = ZoneId.of("Australia/Sydney");
    public static DateTimeFormatter HUAWEI_DATETIME_FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.SSS");

    public static Long minGapValue(Collection<Long> valuesToCheckForGaps, Long toCompareWith) {
        ArrayList<Long> values = new ArrayList<>(valuesToCheckForGaps);
        Long minValueIndex = LongStream.range(0, values.size())
                .reduce((i, j) -> Math.abs(values.get((int)i) - toCompareWith) > Math.abs(values.get((int)j) - toCompareWith) ? j : i )
                .getAsLong();

        return values.get(minValueIndex.intValue());
    }

    // if need more precision use double
    public static float convertLatitude(long scaleValue, int sign) {
        return (scaleValue * 90f / 8388607) * (sign == 0 ? 1 : -1);
    }

    public static float convertLongitude(long scaleValue) {
        return (scaleValue * 180f / 8388607);
    }

    public static long convertDateTime2Timestamp(int year, int month, int day, int hour, int minute, int second, int millis) {
        try {
            // Note: Now this is a hack, considering the performance against elegant solution, this is ok
            // At the end we don't live until year 2100, so who cares.
            int fourDigitYear = year > 99 ? year : 2000 + year;

            LocalDateTime dateTime = LocalDateTime.of(
                    fourDigitYear,
                    month,
                    day,
                    hour,
                    minute,
                    second
            );

            return dateTime.toEpochSecond(ZoneOffset.UTC) * 1000 + millis;

            //ZonedDateTime zonedDateTime = dateTime.atZone(ZoneOffset.UTC);
            //return zonedDateTime.toInstant().toEpochMilli() + millis;

        } catch (Exception e) {
            return -1;
        }
    }

    public static ZonedDateTime convertTimestampToDateTimeUtc(long millis) {
        ZonedDateTime zdt = ZonedDateTime.ofInstant(Instant.ofEpochMilli(millis),
                ZoneOffset.UTC);
        return zdt;
    }

    public static LocalDateTime convertTimestampToSystemTime(long millis) {
        LocalDateTime  ldt = LocalDateTime.ofInstant(Instant.ofEpochMilli(millis), ZoneId.systemDefault());
        return ldt;
    }

    public static LocalDateTime convertTimestampToDateTimeColombo(long millis) {
        LocalDateTime  ldt = LocalDateTime.ofInstant(Instant.ofEpochMilli(millis), ZONE_COLOMBO);
        return ldt;
    }

    public static LocalDateTime convertTimestampToDateTimeSydney(long millis) {
        LocalDateTime  ldt = LocalDateTime.ofInstant(Instant.ofEpochMilli(millis), ZONE_SYDNEY);
        return ldt;
    }

    public static LocalDateTime convertTimestampToDateTimeOfZone(long millis, ZoneId zoneId) {
        LocalDateTime  ldt = LocalDateTime.ofInstant(Instant.ofEpochMilli(millis), zoneId);
        return ldt;
    }

    public static Integer NullIf1ByteInvalid(int value) {
        return value == ConversionHelper.ONE_BYTE_INVALID_VALUE ? null : value;
    }

    public static Integer NullIf2ByteInvalid(int value) {
        return value == ConversionHelper.TWO_BYTE_INVALID_VALUE ? null : value;
    }

    public static Long NullIf4ByteInvalid(long value) {
        return value == ConversionHelper.FOUR_BYTE_INVALID_VALUE ? null : value;
    }

    public static Long NullIf3ByteInvalid(long value) {
        return value == ConversionHelper.THREE_BYTE_INVALID_VALUE ? null : value;
    }

    public static String generateGeoHash(float userLat, float userLon){
        GeoHash geoHash = GeoHash.withCharacterPrecision(userLat, userLon, PRECISION);
        return geoHash.toBase32();
    }
}
