package com.altria.dialog.decoders.common;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Objects;

public class EventTime {
    private final int hour;
    private final int minute;
    private final int second;
    private final int millisecond;

    public EventTime(int hour, int minute, int second, int millisecond) {
        this.hour = hour;
        this.minute = minute;
        this.second = second;
        this.millisecond = millisecond;
    }

    public int getHour() {
        return hour;
    }

    public int getMinute() {
        return minute;
    }

    public int getSecond() {
        return second;
    }

    public int getMillisecond() {
        return millisecond;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        EventTime eventTime = (EventTime) o;
        return hour == eventTime.hour && minute == eventTime.minute && second == eventTime.second && millisecond == eventTime.millisecond;
    }

    @Override
    public int hashCode() {
        return Objects.hash(hour, minute, second, millisecond);
    }
}
