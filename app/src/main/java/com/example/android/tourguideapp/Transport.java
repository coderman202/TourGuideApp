package com.example.android.tourguideapp;

import android.content.Context;

/**
 * A custom class for transport types
 */
public class Transport {

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

    @Override
    public String toString() {
        return "Transport{" +
                "name='" + name + '\'' +
                ", iconResourceID=" + iconResourceID +
                ", context=" + context +
                '}';
    }
}
