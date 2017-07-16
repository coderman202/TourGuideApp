package com.example.android.tourguideapp;

import android.content.Context;

/**
 * A quick custom class which holds the context.
 */

public class ContextHolder {
    private static ContextHolder ourInstance;
    private Context context;

    public static ContextHolder getInstance() {
        return ourInstance;
    }

    public static void init(Context context) {
        ourInstance = new ContextHolder(context);
    }

    private ContextHolder(Context context) {
        this.context = context;
    }

    public Context getApplicationContext() {
        return context;
    }
}
