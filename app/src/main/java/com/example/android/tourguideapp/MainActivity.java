package com.example.android.tourguideapp;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.city_list_view) ListView cityListView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ButterKnife.bind(this);

        TourGuideDBHelper tourGuideDBHelper = new TourGuideDBHelper(this);
        List<City> cityList = tourGuideDBHelper.getAllCities();

        CityAdapter cityAdapter = new CityAdapter(this, cityList);
        cityListView.setAdapter(cityAdapter);

    }
}
