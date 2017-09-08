package com.example.bahubali.tourguide;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by bahubali on 9/7/2017.
 */

public class LocationHolder extends RecyclerView.ViewHolder {
    private ImageView mLocationImage;
    private TextView mLocationName;


    public LocationHolder(View itemView) {
        super(itemView);
        mLocationImage = (ImageView) itemView.findViewById(R.id.image);
        mLocationName = (TextView) itemView.findViewById(R.id.location);
    }
    public void bindLocation(Location place){
        mLocationImage.setImageResource(place.getImageResourceId());
        mLocationName.setText(place.getTourLocation());
    }
}
