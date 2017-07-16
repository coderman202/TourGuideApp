package com.example.android.tourguideapp.model;

import android.content.Context;
import android.location.Address;
import android.os.Parcel;
import android.os.Parcelable;

/**
 * A custom class to represent attractions and sights in the city which is a child class of
 * Hospitality.
 */

public class Attraction extends Hospitality implements Parcelable {

    // An attribute to represent the opening hours for the attraction.
    private String openingHours;

    // A boolean attribute to represent whether the attraction has wheelchair accessibility.
    // Setting the default to true.
    private boolean wheelchairAccess = true;

    //region Constructor(s)

    /**
     * Instantiates a new Attraction with a rating and price, along with a check to make sure the
     * price and rating values passed to the constructor were valid.
     * In this instance there is a check in the superclass constructor for the rating and a
     * further check in this child class to make sure the price meets the requirements
     *
     * @param context          the context
     * @param name             the name
     * @param address          the address
     * @param website          the website
     * @param description      the description
     * @param rating           the rating
     * @param price            the price
     * @param openingHours     the opening hours
     * @param wheelchairAccess the wheelchair access
     */
    public Attraction(Context context, String name, Address address, String website, String description,
                      float rating, float price, String openingHours, boolean wheelchairAccess) {
        super(context, name, address, website, description, rating, price);
        this.openingHours = openingHours;
        this.wheelchairAccess = wheelchairAccess;
    }
    //endregion

    //region Getters & setters & toStrings

    /**
     * Gets opening hours.
     *
     * @return the opening hours
     */
    public String getOpeningHours() {
        return openingHours;
    }

    /**
     * Sets opening hours.
     *
     * @param openingHours the opening hours
     */
    public void setOpeningHours(String openingHours) {
        this.openingHours = openingHours;
    }

    /**
     * Has wheelchair access boolean.
     *
     * @return the boolean
     */
    public boolean hasWheelchairAccess() {
        return wheelchairAccess;
    }

    /**
     * Sets wheelchair access.
     *
     * @param wheelchairAccess the wheelchair access
     */
    public void setWheelchairAccess(boolean wheelchairAccess) {
        this.wheelchairAccess = wheelchairAccess;
    }

    @Override
    public String toString() {
        return "Attraction{" +
                "openingHours='" + openingHours + '\'' +
                ", wheelchairAccess=" + wheelchairAccess +
                '}';
    }
    //endregion

    //region Parcelable code
    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        super.writeToParcel(dest, flags);
        dest.writeString(this.openingHours);
        dest.writeByte(this.wheelchairAccess ? (byte) 1 : (byte) 0);
    }

    protected Attraction(Parcel in) {
        super(in);
        this.openingHours = in.readString();
        this.wheelchairAccess = in.readByte() != 0;
    }

    public static final Creator<Attraction> CREATOR = new Creator<Attraction>() {
        @Override
        public Attraction createFromParcel(Parcel source) {
            return new Attraction(source);
        }

        @Override
        public Attraction[] newArray(int size) {
            return new Attraction[size];
        }
    };
    //endregion
}
