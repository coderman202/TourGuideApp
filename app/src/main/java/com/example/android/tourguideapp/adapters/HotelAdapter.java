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
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.android.tourguideapp.R;
import com.example.android.tourguideapp.model.Hotel;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

import static com.example.android.tourguideapp.utils.TourGuideUtilities.addressToString;
import static com.example.android.tourguideapp.utils.TourGuideUtilities.getClassStars;
import static com.example.android.tourguideapp.utils.TourGuideUtilities.getPriceIcons;
import static com.example.android.tourguideapp.utils.TourGuideUtilities.getRatingStars;

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
        @BindView(R.id.hotel_price_layout) LinearLayout priceLayout;
        @BindView(R.id.hotel_rating_layout) LinearLayout ratingLayout;
        @BindView(R.id.hotel_class) LinearLayout classLayout;
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

        // Set the number of stars and price icons appropriate for each place and the number of
        // stars for the hotel class.
        Integer[] ratingStars = getRatingStars(currentHotel.getRating());
        Integer[] priceIcons = getPriceIcons(currentHotel.getPrice());
        Integer[] classStars = getClassStars(currentHotel.getHotelClass());

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

        for (Integer i:classStars) {
            ImageView classStar = new ImageView(getContext());
            classStar.setImageResource(i);
            holder.classLayout.addView(classStar);
        }

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
