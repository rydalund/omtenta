package se.ecutb.magnus.model;

import java.io.Serializable;
import java.time.Year;
import java.util.Arrays;
import java.util.Objects;

public class CalendarUser implements Serializable {
    private int userId;
    private String name;
    private String email;
    private YearCalendar [] yearCalendars;

    public CalendarUser(int userId, String name, String email, YearCalendar[] yearCalendars) {
        this.userId = userId;
        this.name = name;
        this.email = email;
        this.yearCalendars = yearCalendars;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public YearCalendar[] getYearCalendars() {
        return yearCalendars;
    }

    public void setYearCalendars(YearCalendar[] yearCalendars) {
        this.yearCalendars = yearCalendars;
    }

    public YearCalendar createCalendar(int year){
        YearCalendar foo =null;
        foo.generateCalendarDays(year);
        return foo;
    }

/*public boolean searhCalendar(YearCalendar [] yearCalendars){
    }*/

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CalendarUser that = (CalendarUser) o;
        return userId == that.userId &&
                Objects.equals(name, that.name) &&
                Objects.equals(email, that.email) &&
                Arrays.equals(yearCalendars, that.yearCalendars);
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(userId, name, email);
        result = 31 * result + Arrays.hashCode(yearCalendars);
        return result;
    }

    @Override
    public String toString() {
        return "CalendarUser{" +
                "userId=" + userId +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", yearCalendars=" + Arrays.toString(yearCalendars) +
                '}';
    }
}
