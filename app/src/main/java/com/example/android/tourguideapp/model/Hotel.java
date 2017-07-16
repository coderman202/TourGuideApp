package com.example.android.tourguideapp.model;

import android.content.Context;
import android.location.Address;
import android.os.Parcel;

import java.util.List;

/**
 * A custom class for hotels
 */

public class Hotel extends Hospitality {

    // The class constants representing the class of the hotel
    public static final int CLASS_FIVE_STAR = 5;
    public static final int CLASS_FOUR_STAR = 4;
    public static final int CLASS_THREE_STAR = 3;
    public static final int CLASS_TWO_STAR = 2;
    public static final int CLASS_ONE_STAR = 1;

    // An attribute to represent the class of the hotel, which by default will be two stars
    private int hotelClass = CLASS_TWO_STAR;

    // A list of the amenities that the hotel offers
    private List<Amenity> amenities;

    //region Constructors
    /**
     * Instantiates a new Hotel object without a rating, price  or amenities. A check to ensure a
     * valid hotel class is passed is in place too.
     *
     * @param context       the context
     * @param name          the name
     * @param address       the address
     * @param website       the website
     * @param description   the description
     * @param hotelClass    the hotel class
     */
    public Hotel(Context context, String name, Address address, String website, String description,
                 int hotelClass) {
        super(context, name, address, website, description);
        if(hotelClass < CLASS_ONE_STAR || hotelClass > CLASS_FIVE_STAR){
            throw new IllegalArgumentException("Error. You must pass a valid value for hotel class");
        }
        this.hotelClass = hotelClass;
    }

    /**
     * Instantiates a new Hotel with a rating and price, along with a check in the super
     * constructor to make sure the price and rating values passed to the constructor were valid.
     * A check to ensure a valid hotel class is
     * passed is in place too.
     *
     * @param context       the context
     * @param name          the name
     * @param address       the address
     * @param website       the website
     * @param description   the description
     * @param rating        the rating
     * @param price         the price
     * @param hotelClass    the hotel class
     * @param amenities     the amenities
     */
    public Hotel(Context context, String name, Address address, String website, String description,
                 float rating, float price, int hotelClass,
                 List<Amenity> amenities) {
        super(context, name, address, website, description, rating, price);
        if(hotelClass < CLASS_ONE_STAR || hotelClass > CLASS_FIVE_STAR){
            throw new IllegalArgumentException("Error. You must pass a valid value for hotel class");
        }
        this.hotelClass = hotelClass;
        this.amenities = amenities;
    }
    //endregion

    //region Getters & Setters & toStrings
    /**
     * Gets hotel class.
     *
     * @return the hotel class
     */
    public int getHotelClass() {
        return hotelClass;
    }

    /**
     * Sets hotel class and checks to make sure it is valid also.
     *
     * @param hotelClass the hotel class
     */
    public void setHotelClass(int hotelClass) {
        if(hotelClass < CLASS_ONE_STAR || hotelClass > CLASS_FIVE_STAR){
            throw new IllegalArgumentException("Error. You must pass a valid value for hotel class");
        }
        this.hotelClass = hotelClass;
    }

    /**
     * Get amenities list
     *
     * @return the list of hotel amenities
     */
    public List<Amenity> getAmenities() {
        return amenities;
    }

    /**
     * Sets amenities list.
     *
     * @param amenities the amenities
     */
    public void setAmenities(List<Amenity> amenities) {
        this.amenities = amenities;
    }

    @Override
    public String toString() {
        return "Hotel{" +
                "hotelClass=" + hotelClass +
                ", amenities=" + amenities +
                "} ";
    }
    //endregion

    //region Parcelable methods
    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        super.writeToParcel(dest, flags);
        dest.writeInt(this.hotelClass);
        dest.writeTypedList(this.amenities);
    }

    protected Hotel(Parcel in) {
        super(in);
        this.hotelClass = in.readInt();
        this.amenities = in.createTypedArrayList(Amenity.CREATOR);
    }

    public static final Creator<Hotel> CREATOR = new Creator<Hotel>() {
        @Override
        public Hotel createFromParcel(Parcel source) {
            return new Hotel(source);
        }

        @Override
        public Hotel[] newArray(int size) {
            return new Hotel[size];
        }
    };
    //endregion
}