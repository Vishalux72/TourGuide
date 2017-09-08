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

import static com.example.bahubali.tourguide.R.color.category_bergen;
import static com.example.bahubali.tourguide.R.id.placesList;

/**
 * A simple {@link Fragment} subclass.
 */
public class BergenFragment extends Fragment {


    public BergenFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.location_list,container,false);

        RecyclerView placeList = (RecyclerView) rootView.findViewById(placesList);

        //Create an array of location
        final ArrayList<Location> location = new ArrayList<>();
        location.add(0,new Location("Bryygen Wharf Bergen",R.drawable.bergen_bryggen_wharf));
        location.add(1,new Location("Fish Market Bergen",R.drawable.bergen_fish_market));
        location.add(2,new Location("Hardanger Fjord Bergen",R.drawable.bergen_hardanger));
        location.add(3,new Location("Mount Floyen Bergen",R.drawable.bergen_night_mount));
        location.add(4,new Location("Mount Ulriken Bergen",R.drawable.bergen_mount_ulriken));


        // Pass all restaurants data and context to adapter
        LocationAdapter adapter = new LocationAdapter(location, category_bergen,getContext());
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
        placeList.setLayoutManager(new LinearLayoutManager(getActivity()));
        placeList.setAdapter(adapter);
        placeList.addOnItemTouchListener(new CustomRVItemTouchListener(getContext(), placeList, new RecyclerViewItemClickListener() {
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
