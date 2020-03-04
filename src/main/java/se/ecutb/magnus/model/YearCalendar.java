package se.ecutb.magnus.model;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Objects;

import static java.time.temporal.ChronoUnit.DAYS;

public class YearCalendar implements Serializable {
    int userId;
    LocalDate[] days;
    private int year;

    public YearCalendar(int userId, LocalDate[] days, int year) {
        this.userId = userId;
        this.year = year;
        this.days = generateCalendarDays(year);
    }

    public YearCalendar(int year) {
    }

    public LocalDate[] getDays() {
        return days;
    }

    public void setDays(LocalDate[] days) {
        this.days = days;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public LocalDate[] generateCalendarDays (int year){
        LocalDate [] days = new LocalDate[0];
        LocalDate calendarFirstDay = LocalDate.of(year, 01,1);
        LocalDate calendarLastDay = LocalDate.of((year+1), 12, 31);
        int daysBetween = (int) DAYS.between(calendarFirstDay, calendarLastDay);
        for (int i = 0; i <= daysBetween; i++){
            days [i] = calendarFirstDay.plusDays(i);
        }
        return days;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        YearCalendar that = (YearCalendar) o;
        return year == that.year &&
                Arrays.equals(days, that.days);
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(year);
        result = 31 * result + Arrays.hashCode(days);
        return result;
    }

    @Override
    public String toString() {
        return "YearCalendar{" +
                "days=" + Arrays.toString(days) +
                ", year=" + year +
                '}';
    }
}