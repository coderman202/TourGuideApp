package com.example.android.tourguideapp;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.text.NumberFormat;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Custom Adapter for generating list of cities on the main activity
 */

public class CityAdapter extends ArrayAdapter<City> {

    static class ViewHolder{
        // Get the city info text views to set their text to the values from the current city in the
        // list. Also get the city image view to set the correct image below in the getView method.
        @BindView(R.id.population) TextView populationView;
        @BindView(R.id.country) TextView countryView;
        @BindView(R.id.language) TextView languageView;
        @BindView(R.id.city_image) ImageView cityImage;

        public ViewHolder(View view){
            ButterKnife.bind(this, view);
        }
    }

    /**
     * Instantiates a new {@link CityAdapter}.
     *
     * @param context       the context
     * @param cityList      the city list
     */
    CityAdapter(Context context, List<City> cityList) {
        super(context, 0, cityList);

    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        ViewHolder holder;

        View listItemView = convertView;

        // Choose alternative layouts for list item to position the image to the left or right in
        // the list item.
        if (listItemView == null && (position % 2) == 0) {
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.city_list_item_left, parent, false);
            holder = new ViewHolder(listItemView);
            listItemView.setTag(holder);
        }
        else if(listItemView == null && (position % 2) != 0){
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.city_list_item_right, parent, false);
            holder = new ViewHolder(listItemView);
            listItemView.setTag(holder);
        }
        else{
            holder = (ViewHolder) listItemView.getTag();
        }



        final City currentCity = getItem(position);

        holder.countryView.setText(currentCity.getCountry());
        holder.populationView.setText(NumberFormat.getIntegerInstance().format(currentCity.getPopulation()));
        holder.languageView.setText(currentCity.getLanguage());
        holder.cityImage.setImageResource(currentCity.getImageResourceID());

        return listItemView;
    }
}
