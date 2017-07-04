package com.example.android.tourguideapp;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * A placeholder fragment containing a simple view.
 */
public class CityInfoFragment extends Fragment {
    /**
     * The fragment argument representing the section number for this
     * fragment.
     */
    private static final String ARG_SECTION_NUMBER = "section_number";

    // This variable is the city that will be passed in to the fragment via the setCity() method by
    // which the info will be gleaned for display in the onCreateView() method.
    private City city;

    public CityInfoFragment() {
    }

    public void setCity(City chosenCity){
        this.city = chosenCity;
    }

    @BindView(R.id.city_guide_image) ImageView cityImage;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_city_guide, container, false);

        ButterKnife.bind(this, rootView);

        int resid = city.getImageResourceID();
        Log.d("" + resid, "it");

        cityImage.setImageResource(city.getImageResourceID());

        return rootView;
    }
}
