package com.example.android.tourguideapp;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

import static com.example.android.tourguideapp.TourGuideUtilities.addressToString;
import static com.example.android.tourguideapp.TourGuideUtilities.getPriceIcons;
import static com.example.android.tourguideapp.TourGuideUtilities.getRatingStars;

/**
 * A custom class to produce lists of restaurants and bars.
 */

public class RestaurantBarAdapter extends ArrayAdapter<RestaurantBar> {

    static class ViewHolder{
        // Get the restaurant info text views to set their text to the values from the current
        // restaurant in the list. Also get the restaurant image view to set the correct image
        // below in the getView method.
        @BindView(R.id.restaurant_bar_name) TextView nameView;
        @BindView(R.id.restaurant_bar_description) TextView descriptionView;
        @BindView(R.id.restaurant_bar_price_layout) LinearLayout priceLayout;
        @BindView(R.id.restaurant_bar_rating_layout) LinearLayout ratingLayout;
        @BindView(R.id.restaurant_bar_image) ImageView imageView;
        @BindView(R.id.restaurant_bar_phone) TextView phoneView;
        @BindView(R.id.restaurant_bar_website) TextView websiteView;
        @BindView(R.id.restaurant_bar_neighbourhood) TextView neighbourhoodView;
        @BindView(R.id.restaurant_bar_address) TextView addressView;

        public ViewHolder(View view){
            ButterKnife.bind(this, view);
        }
    }

    /**
     * Instantiates a new {@link RestaurantBarAdapter}.
     *
     * @param context               the context
     * @param restaurantBarList     the restaurant bar list
     */
    RestaurantBarAdapter(Context context, List<RestaurantBar> restaurantBarList) {
        super(context, 0, restaurantBarList);

    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        final ViewHolder holder;

        View listItemView = convertView;

        if (listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.restaurant_bar_list_item, parent, false);
            holder = new ViewHolder(listItemView);
            listItemView.setTag(holder);
        }
        else{
            holder = (ViewHolder) listItemView.getTag();
        }

        final RestaurantBar currentRestaurantBar = getItem(position);

        holder.nameView.setText(currentRestaurantBar.getName());
        holder.descriptionView.setText(currentRestaurantBar.getDescription());
        holder.imageView.setImageResource(currentRestaurantBar.getImageResourceID());
        holder.imageView.setContentDescription(getContext().getString(R.string.city_images, currentRestaurantBar.getName()));
        holder.phoneView.setText(currentRestaurantBar.getPhoneNumber());
        holder.neighbourhoodView.setText(currentRestaurantBar.getNeighbourhood());
        holder.addressView.setText(addressToString(currentRestaurantBar.getAddress()));

        // Set the number of stars and price icons appropriate for each place
        Integer[] ratingStars = getRatingStars(currentRestaurantBar.getRating());
        Integer[] priceIcons = getPriceIcons(currentRestaurantBar.getPrice());

        for (Integer i:ratingStars) {
            ImageView ratingStar = new ImageView(getContext());
            ratingStar.setImageResource(i);
            holder.ratingLayout.addView(ratingStar);
        }

        for (Integer i:priceIcons) {
            ImageView priceIcon = new ImageView(getContext());
            priceIcon.setImageResource(i);
            holder.priceLayout.addView(priceIcon);
        }

        // Use the neighbourhood view which contains the map pin to toggle the visibility of the
        // address.
        holder.neighbourhoodView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(holder.addressView.getVisibility() == View.VISIBLE) {
                    holder.addressView.setVisibility(View.INVISIBLE);
                }
                else{
                    holder.addressView.setVisibility(View.VISIBLE);
                }
            }
        });

        holder.websiteView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(currentRestaurantBar.getWebsite()));
                getContext().startActivity(intent);
            }
        });

        return listItemView;
    }
}
