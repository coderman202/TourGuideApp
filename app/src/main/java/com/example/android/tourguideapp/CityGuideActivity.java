package com.example.android.tourguideapp;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;

import com.example.android.tourguideapp.adapters.CityGuidePagerAdapter;
import com.example.android.tourguideapp.model.City;

public class CityGuideActivity extends AppCompatActivity {


    /**
     * The {@link ViewPager} that will host the section contents.
     */
    private ViewPager mViewPager;

    // The city that has been passed via the intent.
    private City chosenCity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_city_guide);
        ContextHolder.init(getApplicationContext());

        Bundle bundle = getIntent().getExtras();
        chosenCity = bundle.getParcelable("City");

        Log.d("City", chosenCity.getHotels().size() + "");
        Log.d("City", chosenCity.getHotels().get(0).getName() + "");

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        // Set up the ViewPager with the sections adapter. Pass through the chosen city to the
        // adapter to allow extraction of info for display later.
        mViewPager = (ViewPager) findViewById(R.id.container);
        mViewPager.setAdapter(new CityGuidePagerAdapter(getSupportFragmentManager(), chosenCity));

        TabLayout tabLayout = (TabLayout) findViewById(R.id.city_guide_tabs);
        tabLayout.setupWithViewPager(mViewPager);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_city_guide, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
