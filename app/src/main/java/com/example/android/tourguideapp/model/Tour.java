package com.example.android.tourguideapp.model;

import android.content.Context;
import android.location.Address;
import android.os.Parcel;
import android.os.Parcelable;

import com.example.android.tourguideapp.ContextHolder;

/**
 * A custom class to represent all the city tours.
 */

public class Tour implements Parcelable {

    //region Attribute variable and constant declarations
    // The consumer rating constants
    public static final int RATING_MAX = 5;
    public static final int RATING_MIN = 0;

    // The price constants representing the price levels of the tour
    public static final int PRICE_HIGH = 5;
    public static final int PRICE_FREE = 0;

    // The name of the Tour
    private String name;

    // A variable for the tour operator
    private String operator;

    // An attribute for the rating
    private float rating;

    // An attribute for the price.
    private float price;

    // A short text description of the tour
    private String description;

    // A variable to represent the running times. ie the start time and end time.
    private String operatingTimes;

    // A start and end location for the tour
    private Address address;

    // Attribute to tell user whether tour is wheelchair accessible
    private boolean wheelchairAccess;

    // The address of the website
    private String website;

    // The phone number of the tour company
    private String phoneNumber;

    // The context which will be needed to get the correct resource id of the tour image.
    private Context context;
    //endregion

    //region Constructor(s)

    /**
     * Instantiates a new Tour. Checks that the price set is valid.
     *
     * @param context          the context
     * @param name             the name
     * @param operator         the operator
     * @param rating           the rating
     * @param price            the price
     * @param description      the description
     * @param operatingTimes   the operating times
     * @param address          the start location
     * @param wheelchairAccess the wheelchair access
     * @param website          the website
     * @param phoneNumber      the phone number
     */
    public Tour(Context context, String name, String operator, float rating, float price,
                String description, String operatingTimes, Address address,
                boolean wheelchairAccess, String website, String phoneNumber) {
        if (price < PRICE_FREE || price > PRICE_HIGH) {
            throw new IllegalArgumentException("Error. You must pass a valid price");
        }
        if (rating < RATING_MIN || rating > RATING_MAX) {
            throw new IllegalArgumentException("Error. You must pass a valid rating");
        }
        this.context = context;
        this.name = name;
        this.operator = operator;
        this.rating = rating;
        this.price = price;
        this.description = description;
        this.operatingTimes = operatingTimes;
        this.address = address;
        this.wheelchairAccess = wheelchairAccess;
        this.website = website;
        this.phoneNumber = phoneNumber;
    }
    //endregion

    //region Getters & setters & toStrings

    /**
     * Gets name.
     *
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * Gets operator.
     *
     * @return the operator
     */
    public String getOperator() {
        return operator;
    }

    /**
     * Gets rating.
     *
     * @return the rating
     */
    public float getRating() {
        return rating;
    }

    /**
     * Gets price.
     *
     * @return the price
     */
    public float getPrice() {
        return price;
    }

    /**
     * Gets description.
     *
     * @return the description
     */
    public String getDescription() {
        return description;
    }

    /**
     * Gets operating times.
     *
     * @return the operating times
     */
    public String getOperatingTimes() {
        return operatingTimes;
    }

    /**
     * Gets start location.
     *
     * @return the start location
     */
    public Address getAddress() {
        return address;
    }

    /**
     * Is wheelchair access boolean.
     *
     * @return the boolean
     */
    public boolean hasWheelchairAccess() {
        return wheelchairAccess;
    }

    /**
     * Gets website.
     *
     * @return the website
     */
    public String getWebsite() {
        return website;
    }

    /**
     * Gets phone number.
     *
     * @return the phone number
     */
    public String getPhoneNumber() {
        return phoneNumber;
    }

    @Override
    public String toString() {
        return "Tour{" +
                "name='" + name + '\'' +
                ", operator='" + operator + '\'' +
                ", rating=" + rating +
                ", price=" + price +
                ", description='" + description + '\'' +
                ", operatingTimes='" + operatingTimes + '\'' +
                ", address=" + address +
                ", wheelchairAccess=" + wheelchairAccess +
                ", website='" + website + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", context=" + context +
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
        dest.writeString(this.name);
        dest.writeString(this.operator);
        dest.writeFloat(this.rating);
        dest.writeFloat(this.price);
        dest.writeString(this.description);
        dest.writeString(this.operatingTimes);
        dest.writeParcelable(this.address, flags);
        dest.writeByte(this.wheelchairAccess ? (byte) 1 : (byte) 0);
        dest.writeSerializable(this.website);
        dest.writeString(this.phoneNumber);
    }

    protected Tour(Parcel in) {
        this.name = in.readString();
        this.operator = in.readString();
        this.rating = in.readFloat();
        this.price = in.readFloat();
        this.description = in.readString();
        this.operatingTimes = in.readString();
        this.address = in.readParcelable(Address.class.getClassLoader());
        this.wheelchairAccess = in.readByte() != 0;
        this.website = in.readString();
        this.phoneNumber = in.readString();
        this.context = ContextHolder.getInstance().getApplicationContext();
    }

    public static final Parcelable.Creator<Tour> CREATOR = new Parcelable.Creator<Tour>() {
        @Override
        public Tour createFromParcel(Parcel source) {
            return new Tour(source);
        }

        @Override
        public Tour[] newArray(int size) {
            return new Tour[size];
        }
    };
    //endregion
}