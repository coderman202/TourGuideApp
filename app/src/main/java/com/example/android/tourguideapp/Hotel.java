package com.example.android.tourguideapp;

import android.location.Address;

import java.net.URL;

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

    // Some attributes with defaults to represent the amenities as booleans, depending whether or not the hotel
    // has them.
    private boolean pool = false;
    private boolean restaurant = true;
    private boolean breakfast = true;
    private boolean twentyFourHourReception = true;
    private boolean gym = false;
    private boolean spa = false;
    private boolean lounge = true;
    private boolean wifi = true;
    private boolean parking = true;
    private boolean valet = false;
    private boolean concierge = false;
    private boolean roomService = true;
    private boolean wheelchairAccess = true;

    // Now a boolean array to represent and store all the amenities with their default values
    private boolean[] amenities = new boolean[]
            {pool, restaurant, breakfast, twentyFourHourReception, gym, spa, lounge, wifi,
                    parking, valet, concierge, roomService, wheelchairAccess};

    /**
     * Instantiates a new Hotel object without a rating and price and leaving the amenities as
     * default for now. A check to ensure a valid hotel class is passed is in place too.
     *
     * @param address         the address
     * @param website         the website
     * @param description     the description
     * @param imageResourceID the image resource id
     */
    public Hotel(String name, Address address, URL website, String description, int imageResourceID,
                 int hotelClass) {
        super(name, address, website, description, imageResourceID);
        if(hotelClass < CLASS_ONE_STAR || hotelClass > CLASS_FIVE_STAR){
            throw new IllegalArgumentException("Error. You must pass a valid value for hotel class");
        }
        this.hotelClass = hotelClass;
    }

    /**
     * Instantiates a new Hotel with a rating and price, along with a check in the super
     * constructor to make sure the price and rating values passed to the constructor were valid
     * and setting the amenities as default for now. A check to ensure a valid hotel class is
     * passed is in place too.
     *
     * @param address         the address
     * @param website         the website
     * @param description     the description
     * @param imageResourceID the image resource id
     * @param rating          the rating
     * @param price           the price
     */
    public Hotel(String name, Address address, URL website, String description, int imageResourceID,
                 float rating, float price, int hotelClass) {
        super(name, address, website, description, imageResourceID, rating, price);
        if(hotelClass < CLASS_ONE_STAR || hotelClass > CLASS_FIVE_STAR){
            throw new IllegalArgumentException("Error. You must pass a valid value for hotel class");
        }
        this.hotelClass = hotelClass;
    }

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
     * Get amenities boolean array.
     *
     * @return the boolean array representing whether the hotel has all the amenities
     */
    public boolean[] getAmenities() {
        return amenities;
    }

    /**
     * Sets amenities one by one and also creates the amenities array.
     *
     * @param pool                    the pool
     * @param restaurant              the restaurant
     * @param breakfast               the breakfast
     * @param twentyFourHourReception the twenty four hour reception
     * @param gym                     the gym
     * @param spa                     the spa
     * @param lounge                  the lounge
     * @param wifi                    the wifi
     * @param parking                 the parking
     * @param valet                   the valet
     * @param concierge               the concierge
     * @param roomService             the room service
     * @param wheelchairAccess        the wheelchair access
     */
    public void setAmenities(boolean pool, boolean restaurant, boolean breakfast,
                             boolean twentyFourHourReception, boolean gym, boolean spa,
                             boolean lounge, boolean wifi, boolean parking, boolean valet,
                             boolean concierge, boolean roomService, boolean wheelchairAccess) {
        this.amenities = new boolean[]
                {pool, restaurant, breakfast, twentyFourHourReception, gym, spa, lounge, wifi,
                        parking, valet, concierge, roomService, wheelchairAccess};
        this.pool = pool;
        this.restaurant = restaurant;
        this.breakfast = breakfast;
        this.twentyFourHourReception = twentyFourHourReception;
        this.gym = gym;
        this.spa = spa;
        this.lounge = lounge;
        this.wifi = wifi;
        this.parking = parking;
        this.valet = valet;
        this.concierge = concierge;
        this.roomService = roomService;
        this.wheelchairAccess = wheelchairAccess;
    }

    /**
     * Sets amenities by taking in a boolean array ant sets each on individually.
     *
     * @param amenities the amenities
     */
    public void setAmenities(boolean[] amenities) {
        this.amenities = amenities;
        this.pool = amenities[0];
        this.restaurant = amenities[1];
        this.breakfast = amenities[2];
        this.twentyFourHourReception = amenities[3];
        this.gym = amenities[4];
        this.spa = amenities[5];
        this.lounge = amenities[6];
        this.wifi = amenities[7];
        this.parking = amenities[8];
        this.valet = amenities[9];
        this.concierge = amenities[10];
        this.roomService = amenities[11];
        this.wheelchairAccess = amenities[12];
    }

    // All the set methods below also set the array of amenities be recreating a new one including
    // the passed value while taking the current values of the other amenities.

    /**
     * Has pool boolean.
     *
     * @return the boolean
     */
    public boolean hasPool() {
        return pool;
    }

    /**
     * Sets pool.
     *
     * @param pool the pool
     */
    public void setPool(boolean pool) {
        this.pool = pool;
        this.amenities = new boolean[]
                {pool, restaurant, breakfast, twentyFourHourReception, gym, spa, lounge, wifi,
                        parking, valet, concierge, roomService, wheelchairAccess};
    }

    /**
     * Has restaurant boolean.
     *
     * @return the boolean
     */
    public boolean hasRestaurant() {
        return restaurant;
    }

    /**
     * Sets restaurant.
     *
     * @param restaurant the restaurant
     */
    public void setRestaurant(boolean restaurant) {
        this.restaurant = restaurant;
        this.amenities = new boolean[]
                {pool, restaurant, breakfast, twentyFourHourReception, gym, spa, lounge, wifi,
                        parking, valet, concierge, roomService, wheelchairAccess};
    }

    /**
     * Has breakfast boolean.
     *
     * @return the boolean
     */
    public boolean hasBreakfast() {
        return breakfast;
    }

    /**
     * Sets breakfast.
     *
     * @param breakfast the breakfast
     */
    public void setBreakfast(boolean breakfast) {
        this.breakfast = breakfast;
        this.amenities = new boolean[]
                {pool, restaurant, breakfast, twentyFourHourReception, gym, spa, lounge, wifi,
                        parking, valet, concierge, roomService, wheelchairAccess};
    }

    /**
     * Has twenty four hour reception boolean.
     *
     * @return the boolean
     */
    public boolean hasTwentyFourHourReception() {
        return twentyFourHourReception;
    }

    /**
     * Sets twenty four hour reception.
     *
     * @param twentyFourHourReception the twenty four hour reception
     */
    public void setTwentyFourHourReception(boolean twentyFourHourReception) {
        this.twentyFourHourReception = twentyFourHourReception;
        this.amenities = new boolean[]
                {pool, restaurant, breakfast, twentyFourHourReception, gym, spa, lounge, wifi,
                        parking, valet, concierge, roomService, wheelchairAccess};
    }

    /**
     * Has gym boolean.
     *
     * @return the boolean
     */
    public boolean hasGym() {
        return gym;
    }

    /**
     * Sets gym.
     *
     * @param gym the gym
     */
    public void setGym(boolean gym) {
        this.gym = gym;
        this.amenities = new boolean[]
                {pool, restaurant, breakfast, twentyFourHourReception, gym, spa, lounge, wifi,
                        parking, valet, concierge, roomService, wheelchairAccess};
    }

    /**
     * Has spa boolean.
     *
     * @return the boolean
     */
    public boolean hasSpa() {
        return spa;
    }

    /**
     * Sets spa.
     *
     * @param spa the spa
     */
    public void setSpa(boolean spa) {
        this.spa = spa;
        this.amenities = new boolean[]
                {pool, restaurant, breakfast, twentyFourHourReception, gym, spa, lounge, wifi,
                        parking, valet, concierge, roomService, wheelchairAccess};
    }

    /**
     * Has lounge boolean.
     *
     * @return the boolean
     */
    public boolean hasLounge() {
        return lounge;
    }

    /**
     * Sets lounge.
     *
     * @param lounge the lounge
     */
    public void setLounge(boolean lounge) {
        this.lounge = lounge;
        this.amenities = new boolean[]
                {pool, restaurant, breakfast, twentyFourHourReception, gym, spa, lounge, wifi,
                        parking, valet, concierge, roomService, wheelchairAccess};
    }

    /**
     * Has wifi boolean.
     *
     * @return the boolean
     */
    public boolean hasWifi() {
        return wifi;
    }

    /**
     * Sets wifi.
     *
     * @param wifi the wifi
     */
    public void setWifi(boolean wifi) {
        this.wifi = wifi;
        this.amenities = new boolean[]
                {pool, restaurant, breakfast, twentyFourHourReception, gym, spa, lounge, wifi,
                        parking, valet, concierge, roomService, wheelchairAccess};
    }

    /**
     * Has parking boolean.
     *
     * @return the boolean
     */
    public boolean hasParking() {
        return parking;
    }

    /**
     * Sets parking.
     *
     * @param parking the parking
     */
    public void setParking(boolean parking) {
        this.parking = parking;
        this.amenities = new boolean[]
                {pool, restaurant, breakfast, twentyFourHourReception, gym, spa, lounge, wifi,
                        parking, valet, concierge, roomService, wheelchairAccess};
    }

    /**
     * Has valet boolean.
     *
     * @return the boolean
     */
    public boolean hasValet() {
        return valet;
    }

    /**
     * Sets valet.
     *
     * @param valet the valet
     */
    public void setValet(boolean valet) {
        this.valet = valet;
        this.amenities = new boolean[]
                {pool, restaurant, breakfast, twentyFourHourReception, gym, spa, lounge, wifi,
                        parking, valet, concierge, roomService, wheelchairAccess};
    }

    /**
     * Has concierge boolean.
     *
     * @return the boolean
     */
    public boolean hasConcierge() {
        return concierge;
    }

    /**
     * Sets concierge.
     *
     * @param concierge the concierge
     */
    public void setConcierge(boolean concierge) {
        this.concierge = concierge;
        this.amenities = new boolean[]
                {pool, restaurant, breakfast, twentyFourHourReception, gym, spa, lounge, wifi,
                        parking, valet, concierge, roomService, wheelchairAccess};
    }

    /**
     * Has room service boolean.
     *
     * @return the boolean
     */
    public boolean hasRoomService() {
        return roomService;
    }

    /**
     * Sets room service.
     *
     * @param roomService the room service
     */
    public void setRoomService(boolean roomService) {
        this.roomService = roomService;
        this.amenities = new boolean[]
                {pool, restaurant, breakfast, twentyFourHourReception, gym, spa, lounge, wifi,
                        parking, valet, concierge, roomService, wheelchairAccess};
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
        this.amenities = new boolean[]
                {pool, restaurant, breakfast, twentyFourHourReception, gym, spa, lounge, wifi,
                        parking, valet, concierge, roomService, wheelchairAccess};
    }

    /**
     * Convert amenities for storage string to allow storage in DB.
     *
     * @return the string
     */
    public String convertAmenitiesForStorage(){
        String amenitiesString = "";
        for (int i = 0; i < this.amenities.length; i++) {
            if(i == (amenities.length - 1)){
                amenitiesString += String.valueOf(amenities[i]) + "";
            }
            else {
                amenitiesString += String.valueOf(amenities[i]) + ",";
            }
        }
        return amenitiesString;
    }

    /**
     * Re convert amenities from string storage.
     *
     * @param amenitiesString the amenities string
     */
    public void reConvertAmenitiesFromString(String amenitiesString){
        String[] amenitiesArray = amenitiesString.split(",");
        for (int i = 0; i < amenities.length; i++) {
            amenities[i] = Boolean.valueOf(amenitiesArray[i]);
        }
        setAmenities(amenities);
    }
}
