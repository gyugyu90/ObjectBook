package com.fourb.meeting;

import java.time.DayOfWeek;
import java.time.Duration;
import java.time.LocalDateTime;
import java.time.LocalTime;

public class RecurringScheduleTest {
    public static void main(String[] args) {
        RecurringSchedule schedule = new RecurringSchedule("meeting", DayOfWeek.WEDNESDAY, LocalTime.of(10, 30), Duration.ofMinutes(30));
        Event meeting = new Event("meeting", LocalDateTime.of(2019, 5, 9, 10, 30), Duration.ofMinutes(30));

        assert meeting.isSatisfied(schedule) == false;
        assert meeting.isSatisfied(schedule) == true;
    }
}
