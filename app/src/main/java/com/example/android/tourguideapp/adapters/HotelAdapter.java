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
import com.example.android.tourguideapp.model.Hotel;
import com.example.android.tourguideapp.views.PriceBar;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

import static com.example.android.tourguideapp.utils.TourGuideUtilities.addressToString;

/**
 * A custom class to produce lists of restaurants and bars.
 */

public class HotelAdapter extends ArrayAdapter<Hotel> {

    static class ViewHolder{
        // Get the restaurant info text views to set their text to the values from the current
        // restaurant in the list. Also get the restaurant image view to set the correct image
        // below in the getView method.
        @BindView(R.id.hotel_name) TextView nameView;
        @BindView(R.id.hotel_description) TextView descriptionView;
        @BindView(R.id.hotel_price)
        PriceBar priceBar;
        @BindView(R.id.hotel_rating)
        RatingBar ratingBar;
        @BindView(R.id.hotel_class)
        RatingBar classBar;
        @BindView(R.id.hotel_phone) TextView phoneView;
        @BindView(R.id.hotel_website) TextView websiteView;
        @BindView(R.id.hotel_address) TextView addressView;

        public ViewHolder(View view){
            ButterKnife.bind(this, view);
        }
    }

    /**
     * Instantiates a new {@link HotelAdapter}.
     *
     * @param context               the context
     * @param hotelList             the hotel list
     */
    public HotelAdapter(Context context, List<Hotel> hotelList) {
        super(context, 0, hotelList);

    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        final ViewHolder holder;

        View listItemView = convertView;

        if (listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.hotel_list_item, parent, false);
            holder = new ViewHolder(listItemView);
            listItemView.setTag(holder);
        }
        else{
            holder = (ViewHolder) listItemView.getTag();
        }

        final Hotel currentHotel = getItem(position);

        holder.nameView.setText(currentHotel.getName());
        holder.descriptionView.setText(currentHotel.getDescription());
        holder.phoneView.setText(currentHotel.getPhoneNumber());
        holder.addressView.setText(addressToString(currentHotel.getAddress()));
        holder.classBar.setRating(currentHotel.getHotelClass());
        holder.ratingBar.setStepSize(0.1F);
        holder.ratingBar.setRating(currentHotel.getRating());
        holder.priceBar.setStepSize(0.1F);
        holder.priceBar.setRating(currentHotel.getRating());

        holder.websiteView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(currentHotel.getWebsite()));
                getContext().startActivity(intent);
            }
        });

        return listItemView;
    }
}
