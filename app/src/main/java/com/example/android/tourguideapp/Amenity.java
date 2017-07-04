package com.example.android.tourguideapp;

import android.content.Context;
import android.os.Parcel;
import android.os.Parcelable;

/**
 * A custom class for Amenities
 */
public class Amenity implements Parcelable {

    private String name;
    private int iconResourceID;
    private Context context;


    //region Constructor(s)
    /**
     * Instantiates a new Transport object passing a context to allow for the icon resource id to
     * be found via the getIdentifier method.
     *
     * @param context      the context
     * @param name         the name
     * @param iconFileName the icon file name
     */
    public Amenity(Context context, String name, String iconFileName) {
        this.name = name;
        this.context = context;
        this.iconResourceID = context.getResources().getIdentifier(iconFileName, "drawable", context.getPackageName());
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
     * Gets icon resource id.
     *
     * @return the icon resource id
     */
    public int getIconResourceID() {
        return iconResourceID;
    }

    /**
     * Sets icon resource id.
     *
     * @param iconResourceID the icon resource id
     */
    public void setIconResourceID(int iconResourceID) {
        this.iconResourceID = iconResourceID;
    }

    /**
     * Sets icon resource id.
     *
     * @param iconFileName the icon file name
     */
    public void setIconResourceID(String iconFileName) {
        this.iconResourceID = context.getResources().getIdentifier(iconFileName, "drawable", context.getPackageName());
    }
    //endregion

    @Override
    public String toString() {
        return "Amenity{" +
                "name='" + name + '\'' +
                ", iconResourceID=" + iconResourceID +
                ", context=" + context +
                '}';
    }

    //region Parcelable code
    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.name);
        dest.writeInt(this.iconResourceID);
    }

    protected Amenity(Parcel in) {
        this.name = in.readString();
        this.iconResourceID = in.readInt();
        this.context = ContextHolder.getInstance().getApplicationContext();
    }

    public static final Parcelable.Creator<Amenity> CREATOR = new Parcelable.Creator<Amenity>() {
        @Override
        public Amenity createFromParcel(Parcel source) {
            return new Amenity(source);
        }

        @Override
        public Amenity[] newArray(int size) {
            return new Amenity[size];
        }
    };
    //endregion
}