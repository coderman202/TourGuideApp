package com.example.android.tourguideapp;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.example.android.tourguideapp.adapters.EventAdapter;
import com.example.android.tourguideapp.model.City;
import com.example.android.tourguideapp.model.Event;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * A placeholder fragment containing a simple view.
 */
public class EventFragment extends Fragment {
    /**
     * Saving the city on screen rotation
     */
    private static final String SAVED_CITY = "Saved City Object";

    // This variable is the city that will be passed in to the fragment via the setCity() method by
    // which the info will be gleaned for display in the onCreateView() method.
    private City city;

    @BindView(R.id.event_list_view)
    ListView eventListView;

    public EventFragment() {
    }

    public void setCity(City chosenCity) {
        this.city = chosenCity;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.event_list, container, false);

        if (savedInstanceState != null) {
            city = savedInstanceState.getParcelable(SAVED_CITY);
        }

        ButterKnife.bind(this, rootView);

        final List<Event> eventList = city.getEvents();
        EventAdapter eventAdapter = new EventAdapter(getContext(), eventList);

        eventListView.setAdapter(eventAdapter);
        return rootView;
    }

    @Override
    public void onSaveInstanceState(Bundle saveState) {
        super.onSaveInstanceState(saveState);
        saveState.putParcelable(SAVED_CITY, city);
    }
}
