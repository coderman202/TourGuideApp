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

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Custom Adapter for generating list of cities on the main activity
 */

public class CityAdapter extends ArrayAdapter<City> {

    private static class ViewHolder{
        // Get the city info text views to set their text to the values from the current city in the
        // list. Also get the city image view to set the correct image below in the getView method.
        @BindView(R.id.population) private TextView populationView;
        @BindView(R.id.country) private TextView countryView;
        @BindView(R.id.language) private TextView languageView;
        @BindView(R.id.city_image) private ImageView cityImage;

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
        if (listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.city_list_item, parent, false);
            holder = new ViewHolder(listItemView);
            listItemView.setTag(holder);
        }
        else{
            holder = (ViewHolder) listItemView.getTag();
        }



        final City currentCity = getItem(position);

        holder.countryView.setText(currentCity.getCountry());
        holder.populationView.setText(currentCity.getPopulation());
        holder.languageView.setText(currentCity.getLanguage());
        holder.cityImage.setImageResource(currentCity.getImageResourceID());

        return listItemView;
    }
}
