package com.example.android.tourguideapp;

import android.location.Address;

import java.net.URL;

/**
 * The base class for which Attraction, Restaurant, Bar and Hotel will be an extension
 */
public class Hospitality {


    // The consumer rating constants
    public static final int FIVE_STARS = 55;
    public static final int FOUR_STARS = 54;
    public static final int THREE_STARS = 53;
    public static final int TWO_STARS = 52;
    public static final int ONE_STARS = 51;
    public static final int NO_STARS = 50;


    // The price constants representing the price levels of the hospitality
    public static final int HIGH = 45;
    public static final int MEDIUM_HIGH = 44;
    public static final int MEDIUM = 43;
    public static final int MEDIUM_CHEAP = 42;
    public static final int CHEAP = 41;
    public static final int BARGAIN = 40;


    //The name of the place
    private String name;

    // The address of the place, which will be used to get the country, location and neighbourhood.
    private Address address;

    // A resource id for an image which will be used to represent this hospitality object.
    private int imageResourceID;

    // The neighbourhood which will be derived from the address using the getSubLocality() method.
    private String neighbourhood;

    // The address of the website
    private URL website;

    // A short textual description of the hospitality.
    private String description;

    // The city which will be derived from the address.getLocality() method.
    private String city;

    // The country derived via the address.getCountryName() method.
    private String country;

    // The phone number of the hospitality that can be derived from the address object too using the
    // getPhone() method.
    private String phoneNumber;

    // This will be one of the rating constants above
    private int rating;

    // This will be one of the price constants above
    private int price;


    /**
     * Instantiates a new Hospitality without a rating and price.
     *
     * @param name            the name
     * @param address         the address
     * @param website         the website
     * @param description     the description
     * @param imageResourceID the image resource id
     */
    public Hospitality(String name, Address address, URL website, String description,
                       int imageResourceID) {
        this.name = name;
        this.address = address;
        this.website = website;
        this.description = description;
        this.country = address.getCountryName();
        this.city = address.getLocality();
        this.neighbourhood = address.getSubLocality();
        this.phoneNumber = address.getPhone();
        this.imageResourceID = imageResourceID;
    }

    /**
     * Instantiates a new Hospitality without a price. Includes a check to ensure the rating value
     * passed is valid.
     *
     * @param name            the name
     * @param address         the address
     * @param website         the website
     * @param description     the description
     * @param imageResourceID the image resource id
     * @param rating          the rating
     */
    public Hospitality(String name, Address address, URL website, String description,
                       int imageResourceID, int rating) {
        if(rating < NO_STARS || rating > FIVE_STARS){
            throw new IllegalArgumentException("Error. You must pass a valid rating");
        }
        this.name = name;
        this.address = address;
        this.website = website;
        this.description = description;
        this.country = address.getCountryName();
        this.city = address.getLocality();
        this.neighbourhood = address.getSubLocality();
        this.phoneNumber = address.getPhone();
        this.imageResourceID = imageResourceID;
        this.rating = rating;
    }

    /**
     * Instantiates a new Hospitality with a rating and price, along with a check to make sure the
     * price and rating values passed to the constructor were valid.
     *
     * @param name            the name
     * @param address         the address
     * @param website         the website
     * @param description     the description
     * @param imageResourceID the image resource id
     * @param rating          the rating
     * @param price           the price
     */
    public Hospitality(String name, Address address, URL website, String description,
                       int imageResourceID, int rating, int price) {
        if(rating < NO_STARS || rating > FIVE_STARS || price < BARGAIN || price > HIGH){
            throw new IllegalArgumentException("Error. You must pass a valid rating and price");
        }
        this.name = name;
        this.address = address;
        this.website = website;
        this.description = description;
        this.country = address.getCountryName();
        this.city = address.getLocality();
        this.neighbourhood = address.getSubLocality();
        this.phoneNumber = address.getPhone();
        this.imageResourceID = imageResourceID;
        this.rating = rating;
        this.price = price;
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
     * Gets address.
     *
     * @return the address
     */
    public Address getAddress() {
        return address;
    }

    /**
     * Sets address.
     *
     * @param address the address
     */
    public void setAddress(Address address) {
        this.address = address;
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
     * Gets neighbourhood.
     *
     * @return the neighbourhood
     */
    public String getNeighbourhood() {
        return neighbourhood;
    }

    /**
     * Gets city.
     *
     * @return the city
     */
    public String getCity() {
        return city;
    }

    /**
     * Gets country.
     *
     * @return the country
     */
    public String getCountry() {
        return country;
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
        if(rating < NO_STARS || rating > FIVE_STARS){
            throw new IllegalArgumentException("Error. You must pass a valid rating");
        }
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
     * Sets price.
     *
     * @param price the price
     */
    public void setPrice(int price) {
        if(price < BARGAIN || price > HIGH){
            throw new IllegalArgumentException("Error. You must pass a valid price");
        }
        this.price = price;
    }
}
