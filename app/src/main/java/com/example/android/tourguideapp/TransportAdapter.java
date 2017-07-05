package com.example.android.tourguideapp;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * A custom adapter for the list of transport icons for each city. My resources for this code are
 * found here:
 * <a href = "https://www.survivingwithandroid.com/2016/09/android-recyclerview-tutorial.html">
 *     RecyclerView Tutorial - Surviving with Android</a>
 */

public class TransportAdapter extends RecyclerView.Adapter<TransportAdapter.ViewHolder> {

    private List<Transport> transportList;

    public class ViewHolder extends RecyclerView.ViewHolder{
        // Get the image view that will hold the transport icon
        @BindView(R.id.transport_icon) ImageView transportIcon;

        public ViewHolder(View view){
            super(view);
            ButterKnife.bind(this, view);
        }
    }

    /**
     * Instantiates a new {@link TransportAdapter}.
     *
     * @param transportList     the transport list
     */
    TransportAdapter(List<Transport> transportList) {
        this.transportList = transportList;
    }

    @Override
    public void onBindViewHolder(ViewHolder viewHolder, int position){
        Transport transport = transportList.get(position);
        viewHolder.transportIcon.setImageResource(transport.getIconResourceID());
        viewHolder.transportIcon.setContentDescription(viewHolder.transportIcon.getContext().getString(R.string.transport_icon, transport.getName()));
    }

    @Override
    public int getItemCount(){
        return transportList.size();
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType){
        View view = LayoutInflater.from(parent.getContext()).inflate(
                R.layout.transport_list_item_icon, parent, false);
        return new ViewHolder(view);
    }
}
