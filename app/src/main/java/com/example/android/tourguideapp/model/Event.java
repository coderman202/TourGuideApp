package com.example.android.tourguideapp.model;

import android.content.Context;
import android.location.Address;
import android.os.Parcel;
import android.os.Parcelable;

import com.example.android.tourguideapp.ContextHolder;
import com.example.android.tourguideapp.utils.TourGuideUtilities;

import java.util.Date;

/**
 * A custom class to represent events in the city
 */
public class Event implements Parcelable {

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
    private String website;

    // A boolean value to represent whether or not the event is wheelchair accessible.
    private boolean wheelchairAccess;

    // The context which will be needed to get the correct resource id of the event image.
    private Context context;

    //region Constructor(s)
    /**
     * Instantiates a new Event with a check to ensure the dates are set correctly.
     *
     * @param context          the context
     * @param name             the name
     * @param startDateTime    the start date time
     * @param endDateTime      the end date time
     * @param address          the address
     * @param description      the description
     * @param theme            the theme
     * @param imageFileName    the image file name
     * @param website          the website
     * @param wheelchairAccess the wheelchair access
     */
    public Event(Context context, String name, Date startDateTime, Date endDateTime, Address address,
                 String description, String theme, String imageFileName, String website,
                 boolean wheelchairAccess) {
        if(startDateTime.after(endDateTime)){
            throw new IllegalArgumentException("Error. Ensure the dates are correct. " +
                    "The start date cannot come after the end date");
        }
        this.context = context;
        this.name = name;
        this.startDateTime = startDateTime;
        this.endDateTime = endDateTime;
        this.address = address;
        this.description = description;
        this.theme = theme;
        this.imageResourceID = context.getResources().getIdentifier(imageFileName, "drawable", context.getPackageName());
        this.website = website;
        this.wheelchairAccess = wheelchairAccess;
    }
    //endregion

    //region Getters & Setters & toStrings
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
     * Sets image resource id from the string file name.
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
    public String getWebsite() {
        return website;
    }

    /**
     * Sets website.
     *
     * @param website the website
     */
    public void setWebsite(String website) {
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

    public String getStartEndString(){
        return TourGuideUtilities.dateToString(this.getStartDateTime()) + " - " +
                TourGuideUtilities.dateToString(this.getEndDateTime());

    }

    @Override
    public String toString() {
        return "Event{" +
                "name='" + name + '\'' +
                ", startDateTime=" + startDateTime +
                ", endDateTime=" + endDateTime +
                ", address=" + address +
                ", description='" + description + '\'' +
                ", theme='" + theme + '\'' +
                ", imageResourceID=" + imageResourceID +
                ", website=" + website +
                ", wheelchairAccess=" + wheelchairAccess +
                ", context=" + context +
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
        dest.writeLong(this.startDateTime != null ? this.startDateTime.getTime() : -1);
        dest.writeLong(this.endDateTime != null ? this.endDateTime.getTime() : -1);
        dest.writeParcelable(this.address, flags);
        dest.writeString(this.description);
        dest.writeString(this.theme);
        dest.writeInt(this.imageResourceID);
        dest.writeSerializable(this.website);
        dest.writeByte(this.wheelchairAccess ? (byte) 1 : (byte) 0);
    }

    protected Event(Parcel in) {
        this.name = in.readString();
        long tmpStartDateTime = in.readLong();
        this.startDateTime = tmpStartDateTime == -1 ? null : new Date(tmpStartDateTime);
        long tmpEndDateTime = in.readLong();
        this.endDateTime = tmpEndDateTime == -1 ? null : new Date(tmpEndDateTime);
        this.address = in.readParcelable(Address.class.getClassLoader());
        this.description = in.readString();
        this.theme = in.readString();
        this.imageResourceID = in.readInt();
        this.website = in.readString();
        this.wheelchairAccess = in.readByte() != 0;
        this.context = ContextHolder.getInstance().getApplicationContext();
    }

    public static final Parcelable.Creator<Event> CREATOR = new Parcelable.Creator<Event>() {
        @Override
        public Event createFromParcel(Parcel source) {
            return new Event(source);
        }

        @Override
        public Event[] newArray(int size) {
            return new Event[size];
        }
    };
    //endregion
}