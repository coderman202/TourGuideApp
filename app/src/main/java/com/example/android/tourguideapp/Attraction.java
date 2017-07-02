package com.example.android.tourguideapp;

import android.content.Context;
import android.location.Address;

import java.net.URL;

/**
 * A custom class to represent attractions and sights in the city which is a child class of
 * Hospitality.
 */

public class Attraction extends Hospitality{

    // Adding an extra price constant to take into account that an attraction could be free.
    // The remaining price constants are contained withing the superclass.
    public static final int PRICE_FREE = 0;

    // An attribute to represent the opening hours for the attraction.
    private String openingHours;

    // A boolean attribute to represent whether the attraction has wheelchair accessibility.
    // Setting the default to true.
    private boolean wheelchairAccess = true;

    // A variable to represent the price which will override the price variable in the superclass
    // because I need to take into account the attraction being free.
    private float price;


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
     * @param imageFileName    the image file name
     * @param rating           the rating
     * @param price            the price
     * @param openingHours     the opening hours
     * @param wheelchairAccess the wheelchair access
     */
    public Attraction(Context context, String name, Address address, URL website, String description, String imageFileName,
                      float rating, float price, String openingHours, boolean wheelchairAccess) {
        super(context, name, address, website, description, imageFileName, rating, price);
        this.openingHours = openingHours;
        this.wheelchairAccess = wheelchairAccess;
        if(price < PRICE_FREE){
            throw new IllegalArgumentException("Error. You must pass a valid price");
        }
        this.price = price;
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

    /**
     * Set price. Ensure it is a valid price.
     */
    public void setPrice(float price){
        if(price < PRICE_FREE || price > PRICE_HIGH) {
            throw new IllegalArgumentException("Error. You must pass a valid price");
        }
        this.price = price;
    }

    @Override
    public float getPrice() {
        return price;
    }
}
