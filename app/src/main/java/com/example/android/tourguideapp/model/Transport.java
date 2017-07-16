package com.example.android.tourguideapp.model;

import android.content.Context;
import android.os.Parcel;
import android.os.Parcelable;

import com.example.android.tourguideapp.ContextHolder;

/**
 * A custom class for transport types
 */
public class Transport implements Parcelable {

    private String name;
    private int iconResourceID;
    private Context context;


    /**
     * Instantiates a new Transport object passing a context to allow for the icon resource id to
     * be found via the getIdentifier method.
     *
     * @param context      the context
     * @param name         the name
     * @param iconFileName the icon file name
     */
    public Transport(Context context, String name, String iconFileName) {
        this.name = name;
        this.context = context;
        this.iconResourceID = context.getResources().getIdentifier(iconFileName, "drawable", context.getPackageName());
    }

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
     * Gets icon resource id.
     *
     * @return the icon resource id
     */
    public int getIconResourceID() {
        return iconResourceID;
    }

    @Override
    public String toString() {
        return "Transport{" +
                "name='" + name + '\'' +
                ", iconResourceID=" + iconResourceID +
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
        dest.writeInt(this.iconResourceID);
    }

    protected Transport(Parcel in) {
        this.name = in.readString();
        this.iconResourceID = in.readInt();
        this.context = ContextHolder.getInstance().getApplicationContext();
    }

    public static final Parcelable.Creator<Transport> CREATOR = new Parcelable.Creator<Transport>() {
        @Override
        public Transport createFromParcel(Parcel source) {
            return new Transport(source);
        }

        @Override
        public Transport[] newArray(int size) {
            return new Transport[size];
        }
    };
    //endregion
}
