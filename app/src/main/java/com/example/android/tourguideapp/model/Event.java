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
     * @param website          the website
     * @param wheelchairAccess the wheelchair access
     */
    public Event(Context context, String name, Date startDateTime, Date endDateTime, Address address,
                 String description, String theme, String website,
                 boolean wheelchairAccess) {
        if (startDateTime.after(endDateTime)) {
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
     * Gets start date time.
     *
     * @return the start date time
     */
    public Date getStartDateTime() {
        return startDateTime;
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
     * Gets address.
     *
     * @return the address
     */
    public Address getAddress() {
        return address;
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
     * Gets website.
     *
     * @return the website
     */
    public String getWebsite() {
        return website;
    }

    public String getStartEndString() {
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