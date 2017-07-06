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
     * A utility method for converting a Date object to a String object, in the format: dd/MM/yy HH:mm
     *
     * @param date the date
     * @return the string
     */
    public static String dateToString(Date date){
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yy HH:mm", Locale.ENGLISH);
        return simpleDateFormat.format(date);
    }

    /**
     * A utility method for converting a String object to a Date object, in the format: dd/MM/yy HH:mm
     *
     * @param string the string
     * @return the date
     */
    public static Date stringToDate(String string){
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yy HH:mm", Locale.ENGLISH);
        try{
            return simpleDateFormat.parse(string);
        }catch(ParseException e){
            throw new RuntimeException(e);
        }
    }

    public static Integer[] getRatingStars(float rating){
        Integer[] ratingStars = new Integer[(int)rating + 1];
        for (int i = 0; i < ratingStars.length; i++) {
            ratingStars[i] = R.drawable.star_full;
        }
        if(rating <= ((int) rating) + 0.35){
            ratingStars[ratingStars.length-1] = R.drawable.star_quarter;
        }
        else if(rating <= ((int) rating) + 0.65){
            ratingStars[ratingStars.length-1] = R.drawable.star_half;
        }
        else if(rating <= ((int) rating) + 0.85){
            ratingStars[ratingStars.length-1] = R.drawable.star_three_quarter;
        }
        else{
            ratingStars[ratingStars.length-1] = R.drawable.star_full;
        }
        return ratingStars;
    }

    public static Integer[] getPriceIcons(float price){
        Integer[] priceIcons = new Integer[Math.round(price)];
        for (int i = 0; i < priceIcons.length; i++) {
            priceIcons[i] = R.drawable.price;
        }
        return priceIcons;
    }

}
