package com.example.bahubali.tourguide;

import android.view.View;

/**
 * Created by bahubali on 9/7/2017.
 */
/*
* Custom interface that needs to implemented by
 * Recycler View to implement list view on click
 * behavior
 */

public interface RecyclerViewItemClickListener {

    public void onClick(View view, int position);

    public void onLongClick(View view, int position);
}
