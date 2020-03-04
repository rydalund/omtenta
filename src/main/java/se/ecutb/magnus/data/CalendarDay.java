package se.ecutb.magnus.data;

import se.ecutb.magnus.model.Meeting;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Arrays;

public class CalendarDay implements Serializable {
    private static LocalDate date;
    private static Meeting[] meetings;

    CalendarDay(){
        meetings = new Meeting[0];
    }

    public CalendarDay(Meeting[] meetings){
        CalendarDay.meetings = meetings;
    }

    public Meeting createNewMeeting(String title, LocalTime startTime, LocalTime stopTime, String description){
        if(startTime == null || stopTime == null){
            //Ändra
            throw new IllegalArgumentException("Start Time " + startTime + " or Stop Time " + stopTime + " was not correctly set");
        }
        Meeting newMeeting = new Meeting(title, startTime, stopTime, description);
        int foo = meetings.length;
        meetings = Arrays.copyOf(meetings, meetings.length + 1);
        meetings[foo] = newMeeting;
        return newMeeting;
    }

    private Meeting [] deleteMeeting (LocalTime startTime) {
        int foo = -1;

        for(int i=0; i<meetings.length; i++){
            if(meetings[i].getStartTime() == startTime){
                foo = i;
                break;
            }else{
                System.out.println("No meeting with Start Time " + startTime + " exists in Calendar");
            }
        }
        Meeting[] firstPartOfArray = Arrays.copyOfRange(meetings, 0, foo);
        Meeting[] lastPartOfArray = Arrays.copyOfRange(meetings, foo + 1, meetings.length);
        Meeting[] meetings = Arrays.copyOf(firstPartOfArray, firstPartOfArray.length + lastPartOfArray.length);
        System.arraycopy(lastPartOfArray, 0, meetings, firstPartOfArray.length, lastPartOfArray.length);
        return meetings;
    }

    public static LocalDate getDate() {
        return date;
    }

    public static void setDate(LocalDate date) {
        CalendarDay.date = date;
    }

    public static Meeting[] getMeetings() {
        return meetings;
    }

    public static void setMeetings(Meeting[] meetings) {
        CalendarDay.meetings = meetings;
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
