package com.example.android.tourguideapp;

import android.location.Address;

/**
 * A custom class to represent the airport(s) of a city/country
 */
public class Airport {

    // The name of the airport
    private String name;

    // The IATA code of the airport which is a 3 digit code, eg 'DUB' for Dublin Airport.
    private String iata;

    // An Address object to store the location of the airport
    private Address address;

    // This attribute will be derived from the Address.getCountry() method to ensure accuracy.
    private String country;

    // This attribute will be derived using the Address.getLocality() method.
    private String city;

    /**
     * Instantiates a new Airport object.
     * I use the Address object to generate the city and country attributes
     *
     * @param name    the name
     * @param iata    the iata
     * @param address the address
     */
    public Airport(String name, String iata, Address address) {
        this.name = name;
        this.iata = iata;
        this.address = address;
        this.city = address.getLocality();
        this.country = address.getCountryName();
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
     * Gets IATA code.
     *
     * @return the IATA code
     */
    public String getIata() {
        return iata;
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
     * Gets country.
     *
     * @return the country
     */
    public String getCountry() {
        return country;
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
     * Sets name.
     *
     * @param name the name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Sets iata.
     *
     * @param iata the iata
     */
    public void setIata(String iata) {
        this.iata = iata;
    }

    /**
     * Sets address.
     *
     * @param address the address
     */
    public void setAddress(Address address) {
        this.address = address;
        this.city = address.getLocality();
        this.country = address.getCountryName();
    }

    /**
     * Get string version of the address.
     *
     * @return the string
     */
    public String getAddressToString(){
        return this.address.toString();
    }
}
