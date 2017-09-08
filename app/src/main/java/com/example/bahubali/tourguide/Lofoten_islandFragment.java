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

/**
 * A simple {@link Fragment} subclass.
 */
public class Lofoten_islandFragment extends Fragment {


    public Lofoten_islandFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.location_list,container,false);

        //Create an array of location
        final ArrayList<Location> location = new ArrayList<>();
        location.add(new Location("Haukland Beach Lofoten island",R.drawable.lofoten_haukland));
        location.add(new Location("Lofoten Lofoten island",R.drawable.lofoten_lofoten));
        location.add(new Location("Magic Ice Lofoten island",R.drawable.lofoten_magic_ice));
        location.add(new Location("Moskenesoya Lofoten island",R.drawable.lofoten_moskensoya));
        location.add(new Location("Vaeroy Lofoten island",R.drawable.lofoten_vaeroy));

        LocationAdapter adapter = new LocationAdapter(location, R.color.category_Lofo,getContext());
        RecyclerView placesList = (RecyclerView) rootView.findViewById(R.id.placesList);

        /**
         * Sets layout manager for recycler view
         *
         * Sets adapter for recycler view which is bound to a custom view holder
         *
         * Sets up a custom on touch listener to detect clicks on recycler view since this
         * is the only way to handle clicks in recycler view
         */
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
