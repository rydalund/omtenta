package se.ecutb.magnus.data;

public class MeetingSequencer {

    private static String meetingTitle;

    static String getCurrentMeetingTitle(){
        return meetingTitle;
    }

    static void setCurrentMeetingTitle(String meetingTitle){
        meetingTitle = meetingTitle;
    }

    public static void reset(){
        meetingTitle = null;
    }
}
