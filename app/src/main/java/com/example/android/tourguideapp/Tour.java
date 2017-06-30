package com.example.android.tourguideapp;

import android.location.Address;

import java.net.URL;

/**
 * A custom class to represent all the city tours.
 */

public class Tour {

    // The consumer rating constants
    public static final int FIVE_STARS = 55;
    public static final int FOUR_STARS = 54;
    public static final int THREE_STARS = 53;
    public static final int TWO_STARS = 52;
    public static final int ONE_STARS = 51;
    public static final int NO_STARS = 50;

    // The price constants representing the price levels of the tour
    public static final int HIGH = 45;
    public static final int MEDIUM_HIGH = 44;
    public static final int MEDIUM = 43;
    public static final int MEDIUM_CHEAP = 42;
    public static final int CHEAP = 41;
    public static final int BARGAIN = 40;
    public static final int FREE = 39;

    // The name of the Tour
    private String name;

    // A variable for the tour operator
    private String operator;

    // An attribute which is a resource id for an image to represent the tour
    private int imageResourceID;

    // An attribute for the rating
    private int rating;

    // An attribute for the price.
    private int price;

    // A short text description of the tour
    private String description;

    // A variable to represent the running times. ie the start time and end time.
    private String operatingTimes;

    // A start and end location for the tour
    private Address startLocation;
    private Address endLocation;

    // Attribute to tell user whether tour is wheelchair accessible
    private boolean wheelchairAccess;

    // The address of the website
    private URL website;

    // The phone number of the tour company
    private String phoneNumber;

    /**
     * Instantiates a new Tour.
     *
     * @param name             the name
     * @param operator         the operator
     * @param imageResourceID  the image resource id
     * @param description      the description
     * @param operatingTimes   the operating times
     * @param startLocation    the start location
     * @param endLocation      the end location
     * @param wheelchairAccess the wheelchair access
     * @param website          the website
     * @param phoneNumber      the phone number
     */
    public Tour(String name, String operator, int imageResourceID, String description,
                String operatingTimes, Address startLocation, Address endLocation,
                boolean wheelchairAccess, URL website, String phoneNumber) {
        this.name = name;
        this.operator = operator;
        this.imageResourceID = imageResourceID;
        this.description = description;
        this.operatingTimes = operatingTimes;
        this.startLocation = startLocation;
        this.endLocation = endLocation;
        this.wheelchairAccess = wheelchairAccess;
        this.website = website;
        this.phoneNumber = phoneNumber;
    }

    /**
     * Instantiates a new Tour. Checks that the price set is valid.
     *
     * @param name             the name
     * @param operator         the operator
     * @param imageResourceID  the image resource id
     * @param rating           the rating
     * @param price            the price
     * @param description      the description
     * @param operatingTimes   the operating times
     * @param startLocation    the start location
     * @param endLocation      the end location
     * @param wheelchairAccess the wheelchair access
     * @param website          the website
     * @param phoneNumber      the phone number
     */
    public Tour(String name, String operator, int imageResourceID, int rating, int price,
                String description, String operatingTimes, Address startLocation,
                Address endLocation, boolean wheelchairAccess, URL website, String phoneNumber) {
        if(price < FREE || price > HIGH){
            throw new IllegalArgumentException("Error. You must pass a valid price");
        }
        this.name = name;
        this.operator = operator;
        this.imageResourceID = imageResourceID;
        this.rating = rating;
        this.price = price;
        this.description = description;
        this.operatingTimes = operatingTimes;
        this.startLocation = startLocation;
        this.endLocation = endLocation;
        this.wheelchairAccess = wheelchairAccess;
        this.website = website;
        this.phoneNumber = phoneNumber;
    }

    /**
     * Gets name.
     *
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * Sets name.
     *
     * @param name the name
     */
    public void setName(String name) {
        this.name = name;
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
     * Sets operator.
     *
     * @param operator the operator
     */
    public void setOperator(String operator) {
        this.operator = operator;
    }

    /**
     * Gets image resource id.
     *
     * @return the image resource id
     */
    public int getImageResourceID() {
        return imageResourceID;
    }

    /**
     * Sets image resource id.
     *
     * @param imageResourceID the image resource id
     */
    public void setImageResourceID(int imageResourceID) {
        this.imageResourceID = imageResourceID;
    }

    /**
     * Gets rating.
     *
     * @return the rating
     */
    public int getRating() {
        return rating;
    }

    /**
     * Sets rating.
     *
     * @param rating the rating
     */
    public void setRating(int rating) {
        this.rating = rating;
    }

    /**
     * Gets price.
     *
     * @return the price
     */
    public int getPrice() {
        return price;
    }

    /**
     * Sets price. Checks it is valid.
     *
     * @param price the price
     */
    public void setPrice(int price) {
        if(price < FREE || price > HIGH){
            throw new IllegalArgumentException("Error. You must pass a valid price");
        }
        this.price = price;
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
     * Sets description.
     *
     * @param description the description
     */
    public void setDescription(String description) {
        this.description = description;
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
     * Sets operating times.
     *
     * @param operatingTimes the operating times
     */
    public void setOperatingTimes(String operatingTimes) {
        this.operatingTimes = operatingTimes;
    }

    /**
     * Gets start location.
     *
     * @return the start location
     */
    public Address getStartLocation() {
        return startLocation;
    }

    /**
     * Sets start location.
     *
     * @param startLocation the start location
     */
    public void setStartLocation(Address startLocation) {
        this.startLocation = startLocation;
    }

    /**
     * Gets end location.
     *
     * @return the end location
     */
    public Address getEndLocation() {
        return endLocation;
    }

    /**
     * Sets end location.
     *
     * @param endLocation the end location
     */
    public void setEndLocation(Address endLocation) {
        this.endLocation = endLocation;
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
     * Sets wheelchair access.
     *
     * @param wheelchairAccess the wheelchair access
     */
    public void setWheelchairAccess(boolean wheelchairAccess) {
        this.wheelchairAccess = wheelchairAccess;
    }

    /**
     * Gets website.
     *
     * @return the website
     */
    public URL getWebsite() {
        return website;
    }

    /**
     * Sets website.
     *
     * @param website the website
     */
    public void setWebsite(URL website) {
        this.website = website;
    }

    /**
     * Gets phone number.
     *
     * @return the phone number
     */
    public String getPhoneNumber() {
        return phoneNumber;
    }

    /**
     * Sets phone number.
     *
     * @param phoneNumber the phone number
     */
    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
}
