package com.example.android.tourguideapp.adapters;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.example.android.tourguideapp.AttractionFragment;
import com.example.android.tourguideapp.model.City;
import com.example.android.tourguideapp.CityInfoFragment;
import com.example.android.tourguideapp.EventFragment;
import com.example.android.tourguideapp.HotelFragment;
import com.example.android.tourguideapp.RestaurantBarFragment;
import com.example.android.tourguideapp.TourFragment;

/**
 * A {@link FragmentPagerAdapter} that returns a fragment corresponding to
 * one of the sections/tabs/pages.
 */
public class CityGuidePagerAdapter extends FragmentPagerAdapter {

    private City chosenCity;

    public CityGuidePagerAdapter(FragmentManager fm, City chosenCity) {
        super(fm);
        this.chosenCity = chosenCity;
    }

    @Override
    public Fragment getItem(int position) {

        Bundle bundle = new Bundle();
        bundle.putParcelable("City", chosenCity);

        switch (position){
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
                return "City Info";
            case 1:
                return "Restaurant & Bars";
            case 2:
                return "Hotels";
            case 3:
                return "Attractions";
            case 4:
                return "Tours";
            case 5:
                return "Events";
        }
        return null;
    }
}
