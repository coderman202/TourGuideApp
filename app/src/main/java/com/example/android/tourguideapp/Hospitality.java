package com.example.android.tourguideapp;

import android.content.Context;
import android.location.Address;
import android.os.Parcel;
import android.os.Parcelable;

import java.net.URL;

/**
 * The base class for which Attraction, Restaurant, Bar and Hotel will be an extension
 */
public class Hospitality implements Parcelable {


    // The consumer rating constants to track the min and max rating values
    public static final int RATING_MAX = 5;
    public static final int RATING_MIN = 0;


    // The price constants representing the price levels of the hospitality
    public static final int PRICE_HIGH = 5;
    public static final int PRICE_LOW = 0;


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
    private float rating;

    // This will be one of the price constants above
    private float price;

    // The context which will be needed to get the correct resource id of the hospitality image.
    private Context context;

    //region Constructor(s)
    /**
     * Instantiates a new Hospitality without a rating and price.
     *
     * @param context       the context
     * @param name          the name
     * @param address       the address
     * @param website       the website
     * @param description   the description
     * @param imageFileName the image file name
     */
    public Hospitality(Context context, String name, Address address, URL website,
                       String description, String imageFileName) {
        this.context = context;
        this.name = name;
        this.address = address;
        this.website = website;
        this.description = description;
        this.country = address.getCountryName();
        this.city = address.getLocality();
        this.neighbourhood = address.getSubLocality();
        this.phoneNumber = address.getPhone();
        this.imageResourceID = context.getResources().getIdentifier(imageFileName, "drawable", context.getPackageName());
    }

    /**
     * Instantiates a new Hospitality with a rating and price, along with a check to make sure the
     * price and rating values passed to the constructor were valid.
     *
     * @param context       the context
     * @param name          the name
     * @param address       the address
     * @param website       the website
     * @param description   the description
     * @param imageFileName the image file name
     * @param rating        the rating
     * @param price         the price
     */
    public Hospitality(Context context, String name, Address address, URL website, String description,
                       String imageFileName, float rating, float price) {
        if(rating < RATING_MIN || rating > RATING_MAX || price < PRICE_LOW || price > PRICE_HIGH){
            throw new IllegalArgumentException("Error. You must pass a valid rating and price");
        }
        this.context = context;
        this.name = name;
        this.address = address;
        this.website = website;
        this.description = description;
        this.country = address.getCountryName();
        this.city = address.getLocality();
        this.neighbourhood = address.getSubLocality();
        this.phoneNumber = address.getPhone();
        this.imageResourceID = context.getResources().getIdentifier(imageFileName, "drawable", context.getPackageName());
        this.rating = rating;
        this.price = price;
    }
    //endregion

    //region Getters & setters
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
     * Sets image resource id from the name of the image drawable.
     *
     * @param imageFileName the image file name
     */
    public void setImageResourceID(String imageFileName) {
        this.imageResourceID = context.getResources().getIdentifier(imageFileName, "drawable", context.getPackageName());
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
    public float getRating() {
        return rating;
    }

    /**
     * Sets rating.
     *
     * @param rating the rating
     */
    public void setRating(float rating) {
        if(rating < RATING_MIN || rating > RATING_MAX){
            throw new IllegalArgumentException("Error. You must pass a valid rating");
        }
        this.rating = rating;
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
     * Sets price.
     *
     * @param price the price
     */
    public void setPrice(float price) {
        if(price < PRICE_LOW || price > PRICE_HIGH){
            throw new IllegalArgumentException("Error. You must pass a valid price");
        }
        this.price = price;
    }
    //endregion

    @Override
    public String toString() {
        return "Hospitality{" +
                "name='" + name + '\'' +
                ", address=" + address +
                ", imageResourceID=" + imageResourceID +
                ", neighbourhood='" + neighbourhood + '\'' +
                ", website=" + website +
                ", description='" + description + '\'' +
                ", city='" + city + '\'' +
                ", country='" + country + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", rating=" + rating +
                ", price=" + price +
                ", context=" + context +
                '}';
    }

    //region Parcelable methods
    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.name);
        dest.writeParcelable(this.address, flags);
        dest.writeInt(this.imageResourceID);
        dest.writeString(this.neighbourhood);
        dest.writeSerializable(this.website);
        dest.writeString(this.description);
        dest.writeString(this.city);
        dest.writeString(this.country);
        dest.writeString(this.phoneNumber);
        dest.writeFloat(this.rating);
        dest.writeFloat(this.price);
    }

    protected Hospitality(Parcel in) {
        this.name = in.readString();
        this.address = in.readParcelable(Address.class.getClassLoader());
        this.imageResourceID = in.readInt();
        this.neighbourhood = in.readString();
        this.website = (URL) in.readSerializable();
        this.description = in.readString();
        this.city = in.readString();
        this.country = in.readString();
        this.phoneNumber = in.readString();
        this.rating = in.readFloat();
        this.price = in.readFloat();
        this.context = ContextHolder.getInstance().getApplicationContext();
    }

    public static final Creator<Hospitality> CREATOR = new Creator<Hospitality>() {
        @Override
        public Hospitality createFromParcel(Parcel source) {
            return new Hospitality(source);
        }

        @Override
        public Hospitality[] newArray(int size) {
            return new Hospitality[size];
        }
    };
    //endregion
}
