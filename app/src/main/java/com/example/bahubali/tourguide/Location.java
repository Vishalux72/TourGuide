package com.example.bahubali.tourguide;

import android.content.res.Resources;

/**
 * Created by bahubali on 9/4/2017.
 */

public class Location {
    private String mTourLocation;
    private int mImageResourceId;

    public Location(Resources resources, int oslo_arkensus_fort, String tourLocation){
        mTourLocation = tourLocation;

    }
    public Location(String tourLocation, int imageResourceId){
        mTourLocation = tourLocation;
        mImageResourceId = imageResourceId;
    }
    public String getTourLocation(){
        return mTourLocation;
    }
    public  int getImageResourceId(){
        return mImageResourceId;
    }

}
