package se.ecutb.magnus.data;

public class YearSequencer {
    private static String currentYear;

    static String getCurrentYear(){
        return currentYear;
    }

    static void setCurrentYear(int year){
        currentYear = currentYear;
    }

    public static void reset(){
        currentYear = null;
    }

}
