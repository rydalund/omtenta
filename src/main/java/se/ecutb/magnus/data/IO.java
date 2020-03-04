package se.ecutb.magnus.data;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

public class IO {
    private static final String MEETING_SEQUENCER_KEY = "currentMeeting";
    private static final String YEAR_KEY = "currentYear";

    public static void saveProperties(File file){
        Properties properties = new Properties();
        properties.setProperty(MEETING_SEQUENCER_KEY, String.valueOf(MeetingSequencer.getCurrentMeetingTitle()));
        properties.setProperty(YEAR_KEY, String.valueOf(YearSequencer.getCurrentYear()));
        try(FileOutputStream out = new FileOutputStream(file)){
            if(!file.exists()){
                file.createNewFile();
            }
            properties.store(out, "Current sequencer values");
        }catch (IOException ex){
            ex.printStackTrace();
        }
    }

    public static void restoreProperties(File file){
        Properties properties = new Properties();
        try(FileInputStream in = new FileInputStream(file)){
            properties.load(in);
        }catch (IOException ex){
            ex.printStackTrace();
        }
        String currentMeetingId = properties.getProperty(MEETING_SEQUENCER_KEY);
        String currentYear = properties.getProperty(YEAR_KEY );
        MeetingSequencer.setCurrentMeetingTitle(currentMeetingId);
    }
}
