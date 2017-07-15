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
import android.widget.TextView;

import com.example.android.tourguideapp.R;
import com.example.android.tourguideapp.model.Event;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * A custom class to produce lists of restaurants and bars.
 */

public class EventAdapter extends ArrayAdapter<Event> {

    static class ViewHolder{
        // Get the restaurant info text views to set their text to the values from the current
        // restaurant in the list. Also get the restaurant image view to set the correct image
        // below in the getView method.
        @BindView(R.id.event_name) TextView nameView;
        @BindView(R.id.event_description) TextView descriptionView;
        @BindView(R.id.event_start_end) TextView startEndView;
        @BindView(R.id.event_website) TextView websiteView;

        public ViewHolder(View view){
            ButterKnife.bind(this, view);
        }
    }

    /**
     * Instantiates a new {@link EventAdapter}.
     *
     * @param context          the context
     * @param eventList        the event list
     */
    public EventAdapter(Context context, List<Event> eventList) {
        super(context, 0, eventList);

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

        final Event currentEvent = getItem(position);

        holder.nameView.setText(currentEvent.getName());
        holder.descriptionView.setText(currentEvent.getDescription());
        holder.startEndView.setText(currentEvent.getStartEndString());


        holder.websiteView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(currentEvent.getWebsite()));
                getContext().startActivity(intent);
            }
        });

        return listItemView;
    }
}
