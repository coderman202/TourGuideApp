package com.example.android.tourguideapp;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * A placeholder fragment containing a simple view.
 */
public class RestaurantBarFragment extends Fragment {
    /**
     * The fragment argument representing the section number for this
     * fragment.
     */
    private static final String ARG_SECTION_NUMBER = "section_number";

    // This variable is the city that will be passed in to the fragment via the setCity() method by
    // which the info will be gleaned for display in the onCreateView() method.
    private City city;

    @BindView(R.id.restaurant_bar_list_view)
    ListView restaurantBarListView;

    public RestaurantBarFragment() {
    }

    public void setCity(City chosenCity){
        this.city = chosenCity;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.restaurant_bar_list, container, false);

        ButterKnife.bind(this, rootView);

        final List<RestaurantBar> restaurantBarList = city.getRestaurantBars();
        RestaurantBarAdapter restaurantBarAdapter = new RestaurantBarAdapter(getContext(), restaurantBarList);

        restaurantBarListView.setAdapter(restaurantBarAdapter);

        return rootView;
    }
}
