package com.example.android.tourguideapp;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.Log;
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

import static com.example.android.tourguideapp.TourGuideUtilities.getPriceIcons;
import static com.example.android.tourguideapp.TourGuideUtilities.getRatingStars;

/**
 * A custom class to produce lists of restaurants and bars.
 */

public class RestaurantBarAdapter extends ArrayAdapter<RestaurantBar> {

    static class ViewHolder{
        // Get the restauraqnt info text views to set their text to the values from the current
        // restaurant in the list. Also get the restaurant image view to set the correct image
        // below in the getView method.
        @BindView(R.id.restaurant_bar_name) TextView nameView;
        @BindView(R.id.restaurant_bar_description) TextView descriptionView;
        @BindView(R.id.restaurant_bar_price_layout) LinearLayout priceLayout;
        @BindView(R.id.restaurant_bar_rating_layout) LinearLayout ratingLayout;
        @BindView(R.id.restaurant_bar_image) ImageView imageView;

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

        ViewHolder holder;

        View listItemView = convertView;

        // Choose alternative layouts for list item to position the image to the left or right in
        // the list item.
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

        Integer[] ratingStars = getRatingStars(currentRestaurantBar.getRating());
        Integer[] priceIcons = getPriceIcons(currentRestaurantBar.getPrice());

        for (Integer i:ratingStars) {
            ImageView ratingStar = new ImageView(getContext());
            ratingStar.setImageResource(i);
            holder.ratingLayout.addView(ratingStar);
        }
        Log.d("" + currentRestaurantBar.getRating(), "" + ratingStars[1]);

        for (Integer i:priceIcons) {
            ImageView priceIcon = new ImageView(getContext());
            priceIcon.setImageResource(i);
            holder.priceLayout.addView(priceIcon);
        }

        return listItemView;
    }
}
