package com.example.android.tourguideapp;

import android.location.Address;

import java.net.URL;
import java.util.List;

/**
 * A custom class to represent restaurants and bars, inheriting from the Hospitality class.
 */

public class RestaurantBar extends Hospitality {

    // Constants to represent the number of Michelin Stars the establishment has won, if any.
    public static final int MICHELIN_STARS_ZERO = 20;
    public static final int MICHELIN_STARS_ONE = 21;
    public static final int MICHELIN_STARS_TWO = 22;
    public static final int MICHELIN_STARS_THREE = 23;

    // The opening hours of the establishment.
    private String openingHours;

    // The dining hours of the establishment, in case it is a restaurant bar or any place which is
    // open as a bar before or after the kitchen is closed.
    private String diningHours;

    // The Michelin Star variable, represented as an int, which must be equal to one of the above
    // constants. By default it will be set to zero stars as most establishments will not have any.
    private int michelinStars = MICHELIN_STARS_ZERO;

    // A String array to represent the cuisines such as: Indian, Chinese, Dessert, Drinks, etc..
    private List<String> cuisines;

    /**
     * Instantiates a new RestaurantBar without a rating and price or michelin stars.
     *
     * @param name            the name
     * @param address         the address
     * @param website         the website
     * @param description     the description
     * @param imageResourceID the image resource id
     * @param openingHours    the opening hours
     * @param diningHours     the dining hours
     * @param cuisines        the cuisines
     */
    public RestaurantBar(String name, Address address, URL website, String description, int imageResourceID,
                         String openingHours, String diningHours, List<String> cuisines) {
        super(name, address, website, description, imageResourceID);
        this.openingHours = openingHours;
        this.diningHours = diningHours;
        this.cuisines = cuisines;
    }

    /**
     * Instantiates a new RestaurantBar without a rating and price but with a michelin star and a
     * check to make to a value value is passed.
     *
     * @param name            the name
     * @param address         the address
     * @param website         the website
     * @param description     the description
     * @param imageResourceID the image resource id
     * @param openingHours    the opening hours
     * @param diningHours     the dining hours
     * @param michelinStars   the michelin stars
     * @param cuisines        the cuisines
     */
    public RestaurantBar(String name, Address address, URL website, String description, int imageResourceID,
                         String openingHours, String diningHours, int michelinStars,
                         List<String> cuisines) {
        super(name, address, website, description, imageResourceID);
        if(michelinStars < MICHELIN_STARS_ZERO || michelinStars > MICHELIN_STARS_THREE){
            throw new IllegalArgumentException("Error. You must pass a valid number of michelin stars");
        }
        this.openingHours = openingHours;
        this.diningHours = diningHours;
        this.michelinStars = michelinStars;
        this.cuisines = cuisines;
    }

    /**
     * Instantiates a new RestaurantBar with a rating and price, along with a check to make sure the
     * price and rating values passed to the constructor were valid. No Michelin Star rating is
     * passed and so the default value is used.
     *
     * @param name            the name
     * @param address         the address
     * @param website         the website
     * @param description     the description
     * @param imageResourceID the image resource id
     * @param rating          the rating
     * @param price           the price
     * @param openingHours    the opening hours
     * @param diningHours     the dining hours
     * @param cuisines        the cuisines
     */
    public RestaurantBar(String name, Address address, URL website, String description, int imageResourceID,
                         int rating, int price, String openingHours, String diningHours,
                         List<String> cuisines) {
        super(name, address, website, description, imageResourceID, rating, price);
        this.openingHours = openingHours;
        this.diningHours = diningHours;
        this.cuisines = cuisines;
    }

    /**
     * Instantiates a new RestaurantBar with a michelin star, along with a check to make sure the
     * values passed to the constructor were valid.
     *
     * @param name            the name
     * @param address         the address
     * @param website         the website
     * @param description     the description
     * @param imageResourceID the image resource id
     * @param rating          the rating
     * @param price           the price
     * @param openingHours    the opening hours
     * @param diningHours     the dining hours
     * @param michelinStars   the michelin stars
     * @param cuisines        the cuisines
     */
    public RestaurantBar(String name, Address address, URL website, String description, int imageResourceID,
                         int rating, int price, String openingHours, String diningHours,
                         int michelinStars, List<String> cuisines) {
        super(name, address, website, description, imageResourceID, rating, price);
        if(michelinStars < MICHELIN_STARS_ZERO || michelinStars > MICHELIN_STARS_THREE){
            throw new IllegalArgumentException("Error. You must pass a valid number of michelin stars");
        }
        this.openingHours = openingHours;
        this.diningHours = diningHours;
        this.michelinStars = michelinStars;
        this.cuisines = cuisines;
    }

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
        if(michelinStars < MICHELIN_STARS_ZERO || michelinStars > MICHELIN_STARS_THREE){
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
}
