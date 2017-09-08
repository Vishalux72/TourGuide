package com.example.bahubali.tourguide;


import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

import static com.example.bahubali.tourguide.R.color.category_trondheim;

/**
 * A simple {@link Fragment} subclass.
 */
public class TrondheimFragment extends Fragment {


    public TrondheimFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.location_list,container,false);
        RecyclerView placesList = (RecyclerView) rootView.findViewById(R.id.placesList);


        //Create an array of location
        final ArrayList<Location> location = new ArrayList<>();
        location.add(new Location("Blakklandet old town Trondheim",R.drawable.trondheim_blakklandet_old_town));
        location.add(new Location("Nidaros Church Trondheim",R.drawable.trondheim_nidaros_church));
        location.add(new Location("Old town bridge Trondheim",R.drawable.trondheim_bridge));
        location.add(new Location("Pirbadet Trondheim",R.drawable.trondheim_pirbadet));
        location.add(new Location("Rockheim Trondheim",R.drawable.trondheim_rockheim));

        // Create an {@link Location}, whose data source is a list of {@link Location}s. The
        // adapter knows how to create list items for each item in the list.

        LocationAdapter adapter = new LocationAdapter(location, category_trondheim,getContext());
        /**
         * Sets layout manager for recycler view
         *
         * Sets adapter for recycler view which is bound to a custom view holder
         *
         * Sets up a custom on touch listener to detect clicks on recycler view since this
         * is the only way to handle clicks in recycler view
         */
        placesList.setLayoutManager(new LinearLayoutManager(getActivity()));
        placesList.setAdapter(adapter);
        placesList.addOnItemTouchListener(new CustomRVItemTouchListener(getContext(), placesList, new RecyclerViewItemClickListener() {
            @Override
            public void onClick(View view, int position) {
                //Opens up clicked location in google maps
                Location chosenPlace = location.get(position);
                String address = chosenPlace.getTourLocation() + "," ;
                Uri mapUri = Uri.parse("geo:0,0?q=" + Uri.encode(address));
                Intent mapIntent = new Intent(Intent.ACTION_VIEW,mapUri);
                mapIntent.setPackage("com.android.apps.maps");
                mapIntent.setClassName("com.google.android.apps.maps", "com.google.android.maps.MapsActivity");
                startActivity(mapIntent);
            }

            @Override
            public void onLongClick(View view, int position) {

            }
        }));


        return rootView;

    }

}
