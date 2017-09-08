package com.example.bahubali.tourguide;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;

/**
 * Created by bahubali on 9/7/2017.
 */

public class CustomRVItemTouchListener implements RecyclerView.OnItemTouchListener {

    //GestureDetector to intercept touch events
    private GestureDetector gestureDetector;
    private RecyclerViewItemClickListener clickListener;

    public CustomRVItemTouchListener(Context context,final RecyclerView recyclerView,final RecyclerViewItemClickListener clickListener){
        this.clickListener = clickListener;
        gestureDetector = new GestureDetector(context, new GestureDetector.SimpleOnGestureListener(){

            @Override
            public boolean onSingleTapUp(MotionEvent e) {
                return true;
            }

            @Override
            public void onLongPress(MotionEvent e) {
                //Find the long press view
                View child = recyclerView.findChildViewUnder(e.getX(),e.getY());
                if (child != null && gestureDetector.onTouchEvent(e)){
                    clickListener.onClick(child,recyclerView.getChildLayoutPosition(child));
                }
            }
        });
    }
    @Override
    public boolean onInterceptTouchEvent(RecyclerView recyclerView, MotionEvent e)
    {
        View child = recyclerView.findChildViewUnder(e.getX(), e.getY());
        if (child != null && clickListener != null && gestureDetector.onTouchEvent(e)) {
            clickListener.onClick(child, recyclerView.getChildLayoutPosition(child));
        }

        return false;
    }

    @Override
    public void onTouchEvent(RecyclerView rv, MotionEvent e) {

    }

    @Override
    public void onRequestDisallowInterceptTouchEvent(boolean disallowIntercept) {

    }
}
