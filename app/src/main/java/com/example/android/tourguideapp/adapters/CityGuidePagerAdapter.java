package com.example.android.tourguideapp.adapters;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.example.android.tourguideapp.AttractionFragment;
import com.example.android.tourguideapp.CityInfoFragment;
import com.example.android.tourguideapp.EventFragment;
import com.example.android.tourguideapp.HotelFragment;
import com.example.android.tourguideapp.R;
import com.example.android.tourguideapp.RestaurantBarFragment;
import com.example.android.tourguideapp.TourFragment;
import com.example.android.tourguideapp.model.City;

/**
 * A {@link FragmentPagerAdapter} that returns a fragment corresponding to
 * one of the sections/tabs/pages.
 */
public class CityGuidePagerAdapter extends FragmentPagerAdapter {

    private City chosenCity;
    private Context context;

    public CityGuidePagerAdapter(FragmentManager fm, City chosenCity, Context context) {
        super(fm);
        this.chosenCity = chosenCity;
        this.context = context;
    }

    @Override
    public Fragment getItem(int position) {

        switch (position) {
            case 0:
                CityInfoFragment cityInfoFragment = new CityInfoFragment();
                cityInfoFragment.setCity(chosenCity);
                return cityInfoFragment;
            case 1:
                RestaurantBarFragment restaurantBarFragment = new RestaurantBarFragment();
                restaurantBarFragment.setCity(chosenCity);
                return restaurantBarFragment;
            case 2:
                HotelFragment hotelFragment = new HotelFragment();
                hotelFragment.setCity(chosenCity);
                return hotelFragment;
            case 3:
                AttractionFragment attractionFragment = new AttractionFragment();
                attractionFragment.setCity(chosenCity);
                return attractionFragment;
            case 4:
                TourFragment tourFragment = new TourFragment();
                tourFragment.setCity(chosenCity);
                return tourFragment;
            case 5:
                EventFragment eventFragment = new EventFragment();
                eventFragment.setCity(chosenCity);
                return eventFragment;
        }
        return null;
    }

    @Override
    public int getCount() {
        // Show 6 total pages.
        return 6;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        switch (position) {
            case 0:
                return context.getString(R.string.title_city_info);
            case 1:
                return context.getString(R.string.title_restaurant_bar);
            case 2:
                return context.getString(R.string.title_hotel);
            case 3:
                return context.getString(R.string.title_attraction);
            case 4:
                return context.getString(R.string.title_tour);
            case 5:
                return context.getString(R.string.title_event);
        }
        return null;
    }
}
