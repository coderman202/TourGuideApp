package com.example.android.tourguideapp;

import android.location.Address;

import java.net.URL;
import java.util.Date;

/**
 * A custom class to represent events in the city
 */
public class Event {

    // The name of the event.
    private String name;

    // An attribute for the staring time and date of the event
    private Date startDateTime;

    // An attribute for the finishing time and date of the event.
    private Date endDateTime;

    // A variable for the location of the event.
    private Address address;

    // A short text description of the event.
    private String description;

    //A text for the theme, eg Food, Music, Arts & Crafts, etc...
    private String theme;

    // A resource id to an image to represent the event.
    private int imageResourceID;

    // The address of the website
    private URL website;

    // A boolean value to represent whether or not the event is wheelchair accessible.
    private boolean wheelchairAccess;

    /**
     * Instantiates a new Event with a check to ensure the dates are set correctly.
     *
     * @param name             the name
     * @param startDateTime    the start date time
     * @param endDateTime      the end date time
     * @param address          the address
     * @param description      the description
     * @param theme            the theme
     * @param imageResourceID  the image resource id
     * @param website          the website
     * @param wheelchairAccess the wheelchair access
     */
    public Event( String name, Date startDateTime, Date endDateTime, Address address,
                  String description, String theme, int imageResourceID, URL website,
                  boolean wheelchairAccess) {
        if(startDateTime.after(endDateTime)){
            throw new IllegalArgumentException("Error. Ensure the dates are correct. " +
                    "The start date cannot come after the end date");
        }
        this.name = name;
        this.startDateTime = startDateTime;
        this.endDateTime = endDateTime;
        this.address = address;
        this.description = description;
        this.theme = theme;
        this.imageResourceID = imageResourceID;
        this.website = website;
        this.wheelchairAccess = wheelchairAccess;
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
     * Gets start date time.
     *
     * @return the start date time
     */
    public Date getStartDateTime() {
        return startDateTime;
    }

    /**
     * Sets start date time with a check to ensure the dates are set correctly.
     *
     * @param startDateTime the start date time
     */
    public void setStartDateTime(Date startDateTime) {
        if(startDateTime.after(endDateTime)){
            throw new IllegalArgumentException("Error. Ensure the dates are correct. " +
                    "The start date cannot come after the end date");
        }
        this.startDateTime = startDateTime;
    }

    /**
     * Gets end date time.
     *
     * @return the end date time
     */
    public Date getEndDateTime() {
        return endDateTime;
    }

    /**
     * Sets end date time with a check to ensure the dates are set correctly.
     *
     * @param endDateTime the end date time
     */
    public void setEndDateTime(Date endDateTime) {
        if(startDateTime.after(endDateTime)){
            throw new IllegalArgumentException("Error. Ensure the dates are correct. " +
                    "The start date cannot come after the end date");
        }
        this.endDateTime = endDateTime;
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
     * Gets theme.
     *
     * @return the theme
     */
    public String getTheme() {
        return theme;
    }

    /**
     * Sets theme.
     *
     * @param theme the theme
     */
    public void setTheme(String theme) {
        this.theme = theme;
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

}
