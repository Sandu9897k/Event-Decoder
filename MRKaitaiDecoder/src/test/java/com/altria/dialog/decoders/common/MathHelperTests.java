package com.altria.dialog.decoders.common;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.stream.Stream;

public class MathHelperTests {
    @ParameterizedTest
    @MethodSource("minGapValueParams")
    void minGapValue_ShouldReturnValueWithMinGapToTheReference(long[] values, long value, long minGapVal) {
        Long minVal =  ConversionHelper.minGapValue(Arrays.asList(minGapVal), value);
        Assertions.assertEquals(minGapVal, minVal);
    }

    private static Stream<Arguments> minGapValueParams() {
        return Stream.of(
            Arguments.of(new long[] { 20L, 40L, 90L }, 66L, 90L),
            Arguments.of(new long[] { 20L, 40L, 90L }, 0L, 20L),
            Arguments.of(new long[] { 20L, 40L, 90L }, 50L, 40L)
        );
    }

    @ParameterizedTest
    @MethodSource("convertDateTime2TimestampParams")
    void convertDateTime2Timestamp_ShouldConvertDateTime2milliseconds(int year, int month, int day, int hour, int minute, int second, int millis, long expectedTimestamp) {
        long timestamp = ConversionHelper.convertDateTime2Timestamp(year, month, day, hour, minute, second, millis);
        Assertions.assertEquals(expectedTimestamp, timestamp);
    }

    private static Stream<Arguments> convertDateTime2TimestampParams() {
        return Stream.of(
            Arguments.of(21, 2, 7, 21, 15, 0, 585, 1612732500585L),
            Arguments.of(21, 2, 7, 21, 15, 0, 215, 1612732500215L),
            Arguments.of(21, 2, 7, 21, 16, 0, 23, 1612732560023L)
        );
    }

    @ParameterizedTest
    @MethodSource("convertTimestampToDateTimeColomboParams")
    void convertTimestampToDateTimeColombo_shouldConvertMillisToColomboDateTime(long millis, LocalDateTime ldtExpected) {
        LocalDateTime ldt = ConversionHelper.convertTimestampToDateTimeColombo(millis);
        Assertions.assertEquals(ldtExpected, ldt);
    }

    private static Stream<Arguments> convertTimestampToDateTimeColomboParams() {
        return Stream.of(
            Arguments.of(1612732799503L, LocalDateTime.of(2021,2, 8, 2, 49, 59, 503*1000000))
        );
    }

    @ParameterizedTest
    @MethodSource("convertTimestampToDateTimeSydneyParams")
    void convertTimestampToDateTimeSydney_shouldConvertMillisToSydneyDateTime(long millis, LocalDateTime ldtExpected) {
        LocalDateTime ldt = ConversionHelper.convertTimestampToDateTimeSydney(millis);
        Assertions.assertEquals(ldtExpected, ldt);
    }

    private static Stream<Arguments> convertTimestampToDateTimeSydneyParams() {
        return Stream.of(
            Arguments.of(1612732799503L, LocalDateTime.of(2021,2, 8, 8, 19, 59, 503*1000000)),
            Arguments.of(1612732507260L, LocalDateTime.of(2021,2, 8, 8, 15, 07, 260*1000000)),
            Arguments.of(1612732793044L, LocalDateTime.of(2021,2, 8, 8, 19, 53, 44*1000000))
        );
    }
}
