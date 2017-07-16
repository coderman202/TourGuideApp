package com.example.android.tourguideapp.model;

import android.location.Address;
import android.os.Parcel;
import android.os.Parcelable;

/**
 * A custom class to represent the airport(s) of a city/country
 */
public class Airport implements Parcelable {

    // The name of the airport
    private String name;

    // The IATA code of the airport which is a 3 digit code, eg 'DUB' for Dublin Airport.
    private String iata;

    // This attribute will be derived from the Address.getCountry() method to ensure accuracy.
    private String country;

    // This attribute will be derived using the Address.getLocality() method.
    private String city;

    //region Constructor(s)

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
        this.city = address.getLocality();
        this.country = address.getCountryName();
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

    @Override
    public String toString() {
        return "Airport{" +
                "name='" + name + '\'' +
                ", iata='" + iata + '\'' +
                ", country='" + country + '\'' +
                ", city='" + city + '\'' +
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
        dest.writeString(this.iata);
        dest.writeString(this.country);
        dest.writeString(this.city);
    }

    protected Airport(Parcel in) {
        this.name = in.readString();
        this.iata = in.readString();
        this.country = in.readString();
        this.city = in.readString();
    }

    public static final Parcelable.Creator<Airport> CREATOR = new Parcelable.Creator<Airport>() {
        @Override
        public Airport createFromParcel(Parcel source) {
            return new Airport(source);
        }

        @Override
        public Airport[] newArray(int size) {
            return new Airport[size];
        }
    };
    //endregion
}
