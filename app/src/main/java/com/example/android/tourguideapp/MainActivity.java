package com.example.android.tourguideapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.example.android.tourguideapp.adapters.CityAdapter;
import com.example.android.tourguideapp.dbhelper.TourGuideDBHelper;
import com.example.android.tourguideapp.model.City;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.city_list_view) ListView cityListView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ContextHolder.init(getApplicationContext());

        ButterKnife.bind(this);

        TourGuideDBHelper tourGuideDBHelper = new TourGuideDBHelper(this);
        final List<City> cityList = tourGuideDBHelper.getAllCities();

        CityAdapter cityAdapter = new CityAdapter(this, cityList);
        cityListView.setAdapter(cityAdapter);

        cityListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Bundle bundle = new Bundle();
                bundle.putParcelable("City", cityList.get(position));
                Intent intent = new Intent(MainActivity.this, CityGuideActivity.class);
                intent.putExtra("City", bundle);
                startActivity(intent);
            }
        });

    }
}
