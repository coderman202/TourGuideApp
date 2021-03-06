package com.example.android.tourguideapp.adapters;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.RatingBar;
import android.widget.TextView;

import com.example.android.tourguideapp.R;
import com.example.android.tourguideapp.model.RestaurantBar;
import com.example.android.tourguideapp.views.PriceBar;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

import static com.example.android.tourguideapp.utils.TourGuideUtilities.addressToString;

/**
 * A custom class to produce lists of restaurants and bars.
 */

public class RestaurantBarAdapter extends ArrayAdapter<RestaurantBar> {

    static class ViewHolder {
        // Get the restaurant info text views to set their text to the values from the current
        // restaurant in the list. Also get the restaurant image view to set the correct image
        // below in the getView method.
        @BindView(R.id.restaurant_bar_name)
        TextView nameView;
        @BindView(R.id.restaurant_bar_description)
        TextView descriptionView;
        @BindView(R.id.restaurant_bar_price)
        PriceBar priceBar;
        @BindView(R.id.restaurant_bar_rating)
        RatingBar ratingBar;
        @BindView(R.id.restaurant_bar_phone)
        TextView phoneView;
        @BindView(R.id.restaurant_bar_website)
        TextView websiteView;
        @BindView(R.id.restaurant_bar_address)
        TextView addressView;

        public ViewHolder(View view) {
            ButterKnife.bind(this, view);
        }
    }

    /**
     * Instantiates a new {@link RestaurantBarAdapter}.
     *
     * @param context           the context
     * @param restaurantBarList the restaurant bar list
     */
    public RestaurantBarAdapter(Context context, List<RestaurantBar> restaurantBarList) {
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
        } else {
            holder = (ViewHolder) listItemView.getTag();
        }

        final RestaurantBar currentRestaurantBar = getItem(position);

        holder.nameView.setText(currentRestaurantBar.getName());
        holder.descriptionView.setText(currentRestaurantBar.getDescription());
        holder.phoneView.setText(currentRestaurantBar.getPhoneNumber());
        holder.addressView.setText(addressToString(currentRestaurantBar.getAddress()));
        holder.ratingBar.setStepSize(0.1F);
        holder.ratingBar.setRating(currentRestaurantBar.getRating());
        holder.priceBar.setStepSize(0.1F);
        holder.priceBar.setRating(currentRestaurantBar.getRating());

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
