package com.example.bahubali.tourguide;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

/**
 * Created by bahubali on 9/4/2017.
 */

public class LocationAdapter extends RecyclerView.Adapter<LocationHolder> {

    /**resource id for the background color**/
    private int mColorResourceId;
    private Context mContext;
    private ArrayList<Location> mLocationList = new ArrayList<>();

    public LocationAdapter(ArrayList<Location> mLocationList, int colorResourceId, Context context){

        this.mLocationList = mLocationList;
        this.mColorResourceId = colorResourceId;
        this.mContext = context;
    }

    @Override
    public LocationHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item, parent, false);
        return new LocationHolder(view);
    }

    @Override
    public void onBindViewHolder(LocationHolder holder, int position) {
        Location place = mLocationList.get(position);
        holder.bindLocation(place);

    }


    @Override
    public int getItemCount() {
        return mLocationList.size();
    }

    // Added below methods to prevent recycler view from duplcating items
    @Override
    public long getItemId(int position) {
        return super.getItemId(position);
    }

    @Override
    public int getItemViewType(int position) {
        return super.getItemViewType(position);
    }
}
