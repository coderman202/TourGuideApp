package com.example.android.tourguideapp.model;

import android.content.Context;
import android.location.Address;
import android.os.Parcel;

import java.util.List;

/**
 * A custom class to represent restaurants and bars, inheriting from the Hospitality class.
 */

public class RestaurantBar extends Hospitality {

    // Constants to represent the number of the min and max number of Michelin Stars the
    // establishment has won, if any.
    public static final int MICHELIN_STARS_MIN = 0;
    public static final int MICHELIN_STARS_MAX = 3;

    // The opening hours of the establishment.
    private String openingHours;

    // The dining hours of the establishment, in case it is a restaurant bar or any place which is
    // open as a bar before or after the kitchen is closed.
    private String diningHours;

    // The Michelin Star variable, represented as an int, which must be equal to one of the above
    // constants. By default it will be set to zero stars as most establishments will not have any.
    private int michelinStars = MICHELIN_STARS_MIN;

    // A String array to represent the cuisines such as: Indian, Chinese, Dessert, Drinks, etc..
    private List<String> cuisines;

    private boolean wheelchairAccess;


    //region Constructor(s)
    /**
     * Instantiates a new RestaurantBar with a michelin star, along with a check to make sure the
     * values passed to the constructor were valid.
     *
     * @param context          the context
     * @param name             the name
     * @param address          the address
     * @param website          the website
     * @param description      the description
     * @param rating           the rating
     * @param price            the price
     * @param openingHours     the opening hours
     * @param diningHours      the dining hours
     * @param michelinStars    the michelin stars
     * @param cuisines         the cuisines
     * @param wheelchairAccess the wheelchair access
     */
    public RestaurantBar(Context context, String name, Address address, String website,
                         String description, float rating, float price,
                         String openingHours, String diningHours, int michelinStars,
                         List<String> cuisines, boolean wheelchairAccess) {
        super(context, name, address, website, description, rating, price);
        if(michelinStars < MICHELIN_STARS_MIN || michelinStars > MICHELIN_STARS_MAX){
            throw new IllegalArgumentException("Error. You must pass a valid number of michelin stars");
        }
        this.openingHours = openingHours;
        this.diningHours = diningHours;
        this.michelinStars = michelinStars;
        this.cuisines = cuisines;
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
     * Gets dining hours.
     *
     * @return the dining hours
     */
    public String getDiningHours() {
        return diningHours;
    }

    /**
     * Sets dining hours.
     *
     * @param diningHours the dining hours
     */
    public void setDiningHours(String diningHours) {
        this.diningHours = diningHours;
    }

    /**
     * Gets michelin stars.
     *
     * @return the michelin stars
     */
    public int getMichelinStars() {
        return michelinStars;
    }

    /**
     * Sets michelin stars.
     *
     * @param michelinStars the michelin stars
     */
    public void setMichelinStars(int michelinStars) {
        if(michelinStars < MICHELIN_STARS_MIN || michelinStars > MICHELIN_STARS_MAX){
            throw new IllegalArgumentException("Error. You must pass a valid number of michelin stars");
        }
        this.michelinStars = michelinStars;
    }

    /**
     * Get cuisines string [ ].
     *
     * @return the string [ ]
     */
    public List<String> getCuisines() {
        return cuisines;
    }

    /**
     * Sets cuisines.
     *
     * @param cuisines the cuisines
     */
    public void setCuisines(List<String> cuisines) {
        this.cuisines = cuisines;
    }

    /**
     * Add cuisine.
     *
     * @param cuisine the cuisine
     */
    public void addCuisine(String cuisine){
        this.cuisines.add(cuisine);
    }

    /**
     * Remove cuisine.
     *
     * @param cuisine the cuisine
     */
    public void removeCuisine(String cuisine){
        this.cuisines.remove(cuisine);
    }

    /**
     * Has wheelchair access or not?
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
        return "RestaurantBar{" +
                "openingHours='" + openingHours + '\'' +
                ", diningHours='" + diningHours + '\'' +
                ", michelinStars=" + michelinStars +
                ", cuisines=" + cuisines +
                ", wheelchairAccess=" + wheelchairAccess +
                "} ";
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
        dest.writeString(this.diningHours);
        dest.writeInt(this.michelinStars);
        dest.writeStringList(this.cuisines);
        dest.writeByte(this.wheelchairAccess ? (byte) 1 : (byte) 0);
    }

    protected RestaurantBar(Parcel in) {
        super(in);
        this.openingHours = in.readString();
        this.diningHours = in.readString();
        this.michelinStars = in.readInt();
        this.cuisines = in.createStringArrayList();
        this.wheelchairAccess = in.readByte() != 0;
    }

    public static final Creator<RestaurantBar> CREATOR = new Creator<RestaurantBar>() {
        @Override
        public RestaurantBar createFromParcel(Parcel source) {
            return new RestaurantBar(source);
        }

        @Override
        public RestaurantBar[] newArray(int size) {
            return new RestaurantBar[size];
        }
    };
    //endregion
}