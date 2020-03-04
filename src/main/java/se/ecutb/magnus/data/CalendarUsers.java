package se.ecutb.magnus.data;

import se.ecutb.magnus.model.CalendarUser;

import java.util.Arrays;

public class CalendarUsers {

    private static CalendarUser [] calendarUsers;

    CalendarUsers(){
        calendarUsers = new CalendarUser[0];
    }

    public CalendarUsers(CalendarUser[] calendarUsers){
        CalendarUsers.calendarUsers = calendarUsers;
    }

    public int size(){
        return calendarUsers.length;
    }

    public CalendarUser[] findAll(){
        return calendarUsers;
    }

    public CalendarUser findById(int userId){
        for(CalendarUser c : calendarUsers){
            if(c.getUserId() == userId){
                return c;
            }
        }
        return null;
    }

}
