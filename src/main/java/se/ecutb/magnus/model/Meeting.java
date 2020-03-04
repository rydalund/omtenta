package se.ecutb.magnus.model;

import java.io.Serializable;
import java.time.LocalTime;
import java.util.Objects;

public class Meeting implements Serializable {
    private String title;
    private LocalTime startTime;
    private LocalTime stopTime;
    private String description;

    public Meeting(String title, LocalTime startTime, LocalTime stopTime, String description) {
        this.title = title;
        this.startTime = startTime;
        this.stopTime = stopTime;
        this.description = description;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public LocalTime getStartTime() {
        return startTime;
    }

    public void setStartTime(LocalTime startTime) {
        this.startTime = startTime;
    }

    public LocalTime getStopTime() {
        return stopTime;
    }

    public void setStopTime(LocalTime stopTime) {
        this.stopTime = stopTime;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Meeting meeting = (Meeting) o;
        return Objects.equals(title, meeting.title) &&
                Objects.equals(startTime, meeting.startTime) &&
                Objects.equals(stopTime, meeting.stopTime) &&
                Objects.equals(description, meeting.description);
    }

    @Override
    public int hashCode() {
        return Objects.hash(title, startTime, stopTime, description);
    }

    @Override
    public String toString() {
        return "Meeting{" +
                "title='" + title + '\'' +
                ", startTime=" + startTime +
                ", stopTime=" + stopTime +
                ", description='" + description + '\'' +
                '}';
    }
}
