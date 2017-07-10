package com.example.android.tourguideapp;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.view.ContextThemeWrapper;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextClock;
import android.widget.TextView;

import java.text.NumberFormat;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * A placeholder fragment containing a simple view.
 */
public class CityInfoFragment extends Fragment {
    /**
     * Saving the city on screen rotation
     */
    private static final String SAVED_CITY = "Saved City Object";

    // This variable is the city that will be passed in to the fragment via the setCity() method by
    // which the info will be gleaned for display in the onCreateView() method.
    private City city;

    public CityInfoFragment() {
    }

    public void setCity(City chosenCity){
        this.city = chosenCity;
    }

    @BindView(R.id.city_guide_image) ImageView cityImage;
    @BindView(R.id.transport_icons_recycler_view) RecyclerView transportIconsList;
    @BindView(R.id.city_time) TextClock cityTime;
    @BindView(R.id.city_airport_list) LinearLayout cityAirportsList;
    @BindView(R.id.city_guide_population) TextView cityPopulation;
    @BindView(R.id.city_guide_language) TextView cityLanguage;
    @BindView(R.id.city_guide_country) TextView cityCountry;
    @BindView(R.id.city_description_header) TextView cityDescriptionHeader;
    @BindView(R.id.city_history_header) TextView cityHistoryHeader;
    @BindView(R.id.city_description) ExpandableTextView cityDescription;
    @BindView(R.id.city_history) ExpandableTextView cityHistory;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_city_guide, container, false);

        if(savedInstanceState != null){
            city = savedInstanceState.getParcelable(SAVED_CITY);
        }

        ButterKnife.bind(this, rootView);

        cityImage.setImageResource(city.getImageResourceID());

        List<Transport> transportList = city.getTransport();
        TransportAdapter transportAdapter = new TransportAdapter(transportList);

        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false);
        transportIconsList.setLayoutManager(layoutManager);
        transportIconsList.setAdapter(transportAdapter);

        cityTime.setTimeZone(city.getTimeZone());
        cityPopulation.setText(NumberFormat.getIntegerInstance().format(city.getPopulation()));
        cityLanguage.setText(city.getLanguage());
        cityCountry.setText(city.getCountry());

        ContextThemeWrapper airportItemStyle = new ContextThemeWrapper(getActivity(), R.style.CityAirportTextStyle);

        List<Airport> airportList = city.getAirports();
        for (Airport airport:airportList) {
            TextView airportView = new TextView(airportItemStyle);
            airportView.setText(airport.getName());
            airportView.setCompoundDrawablesWithIntrinsicBounds(R.drawable.airport, 0, 0, 0);
            cityAirportsList.addView(airportView);
        }

        cityDescriptionHeader.setText(getString(R.string.description_header, city.getName()));
        cityHistoryHeader.setText(getString(R.string.history_header, city.getName()));
        cityDescription.setText(city.getDescription());
        cityHistory.setText(city.getHistory());

        Log.d(city.getDescription().length() + "", city.getDescription());

        return rootView;
    }

    @Override
    public void onSaveInstanceState(Bundle saveState){
        super.onSaveInstanceState(saveState);
        saveState.putParcelable(SAVED_CITY, city);
    }
}
