package com.example.android.tourguideapp;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

/**
 * A utility class .
 */
public final class TourGuideUtilities {

    private TourGuideUtilities(){

    }

    /**
     * A utility method for converting a Date object to a String object, in the format: dd/MM/yy
     *
     * @param date the date
     * @return the string
     */
    public static String dateToString(Date date){
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yy", Locale.ENGLISH);
        return simpleDateFormat.format(date);
    }

    /**
     * A utility method for converting a String object to a Date object, in the format: dd/MM/yy
     *
     * @param string the string
     * @return the date
     */
    public static Date stringToDate(String string){
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yy", Locale.ENGLISH);
        try{
            return simpleDateFormat.parse(string);
        }catch(ParseException e){
            throw new RuntimeException(e);
        }
    }

}
