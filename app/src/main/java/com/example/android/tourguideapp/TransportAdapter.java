package com.example.android.tourguideapp;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * A custom adapter for the list of transport icons for each city
 */

public class TransportAdapter extends ArrayAdapter<Transport> {

    static class ViewHolder{
        // Get the image view that will hold the transport icon
        @BindView(R.id.transport_icon) ImageView transportIcon;

        public ViewHolder(View view){
            ButterKnife.bind(this, view);
        }
    }

    /**
     * Instantiates a new {@link TransportAdapter}.
     *
     * @param context           the context
     * @param transportList     the transport list
     */
    TransportAdapter(Context context, List<Transport> transportList) {
        super(context, 0, transportList);

    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        ViewHolder holder;

        View listItemView = convertView;

        if (listItemView == null ){
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.transport_list_item_icon, parent, false);
            holder = new ViewHolder(listItemView);
            listItemView.setTag(holder);
        }
        else{
            holder = (ViewHolder) listItemView.getTag();
        }

        final Transport transport = getItem(position);

        holder.transportIcon.setImageResource(transport.getIconResourceID());
        holder.transportIcon.setContentDescription(getContext().getString(R.string.transport_icon, transport.getName()));

        return listItemView;
    }

}
