package com.example.android.tourguideapp;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

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
                hotelFragment.setArguments(bundle);
                return hotelFragment;
            case 3:
                AttractionFragment attractionFragment = new AttractionFragment();
                attractionFragment.setArguments(bundle);
                return attractionFragment;
            case 4:
                TourFragment tourFragment = new TourFragment();
                tourFragment.setArguments(bundle);
                return tourFragment;
            case 5:
                EventFragment eventFragment = new EventFragment();
                eventFragment.setArguments(bundle);
                return eventFragment;
        }
        return null;

    }

    @Override
    public int getCount() {
        // Show 3 total pages.
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
