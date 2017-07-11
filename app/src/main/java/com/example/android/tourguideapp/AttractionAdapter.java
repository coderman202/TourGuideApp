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

import static com.example.android.tourguideapp.TourGuideUtilities.getPriceIcons;
import static com.example.android.tourguideapp.TourGuideUtilities.getRatingStars;

/**
 * A custom class to produce lists of restaurants and bars.
 */

public class AttractionAdapter extends ArrayAdapter<Attraction> {

    static class ViewHolder{
        // Get the restaurant info text views to set their text to the values from the current
        // restaurant in the list. Also get the restaurant image view to set the correct image
        // below in the getView method.
        @BindView(R.id.attraction_name) TextView nameView;
        @BindView(R.id.attraction_description) TextView descriptionView;
        @BindView(R.id.attraction_price_layout) LinearLayout priceLayout;
        @BindView(R.id.attraction_rating_layout) LinearLayout ratingLayout;
        @BindView(R.id.attraction_image) ImageView imageView;
        @BindView(R.id.attraction_opening_hours) TextView openingHoursView;
        @BindView(R.id.attraction_website) TextView websiteView;

        public ViewHolder(View view){
            ButterKnife.bind(this, view);
        }
    }

    /**
     * Instantiates a new {@link AttractionAdapter}.
     *
     * @param context               the context
     * @param attractionList        the attraction list
     */
    AttractionAdapter(Context context, List<Attraction> attractionList) {
        super(context, 0, attractionList);

    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        final ViewHolder holder;

        View listItemView = convertView;

        if (listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.attraction_list_item, parent, false);
            holder = new ViewHolder(listItemView);
            listItemView.setTag(holder);
        }
        else{
            holder = (ViewHolder) listItemView.getTag();
        }

        final Attraction currentAttraction = getItem(position);

        holder.nameView.setText(currentAttraction.getName());
        holder.descriptionView.setText(currentAttraction.getDescription());
        holder.imageView.setImageResource(currentAttraction.getImageResourceID());
        holder.imageView.setContentDescription(getContext().getString(R.string.city_images, currentAttraction.getName()));
        holder.openingHoursView.setText(currentAttraction.getOpeningHours());

        // Set the number of stars and price icons appropriate for each place.
        Integer[] ratingStars = getRatingStars(currentAttraction.getRating());
        Integer[] priceIcons = getPriceIcons(currentAttraction.getPrice());

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

        holder.websiteView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(currentAttraction.getWebsite()));
                getContext().startActivity(intent);
            }
        });

        return listItemView;
    }
}
