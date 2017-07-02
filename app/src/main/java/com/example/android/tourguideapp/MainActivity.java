package com.example.android.tourguideapp;

import android.content.res.TypedArray;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import java.util.Arrays;
import java.util.List;

import butterknife.BindArray;

public class MainActivity extends AppCompatActivity {

    @BindArray(R.array.city_list) TypedArray cityListArray;
    @BindArray(R.array.city1_restaurants_list) TypedArray city1RestaurantListArray;
    @BindArray(R.array.city1_hotels_list) TypedArray city1HotelListArray;

    List<List<String>> cityStringsList;

    List<City> cityList;
    List<RestaurantBar> city1RestaurantBarList;
    List<Hotel> city1HotelList;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        for(int i = 0; i < cityListArray.length(); i++){
            cityStringsList.add(Arrays.asList(getResources().getStringArray(cityListArray.getResourceId(i, 0))));
        }
        

    }
}
