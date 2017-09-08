package com.example.bahubali.tourguide;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

/**
 * Created by bahubali on 9/7/2017.
 */
/**
 * {@link CategoryAdapter} is a {@link FragmentPagerAdapter} that can provide the layout for
 * each list item based on a data source which is a list of {@link Location} objects.
 */

public class CategoryAdapter extends FragmentPagerAdapter {

    /** Context of the app */
    private Context mContext;



    /**
     * Create a new {@link CategoryAdapter} object.
     *
     * @param fm is the fragment manager that will keep each fragment's state in the adapter
     *           across swipes.
     */

    public CategoryAdapter(Context context,FragmentManager fm) {
        super(fm);
        mContext = context;
    }


    /**
     * Return the {@link Fragment} that should be displayed for the given page number.
     */
    @Override
    public Fragment getItem(int position) {
        if (position == 0){
            return new OsloFragment();
        }else if (position == 1){
            return new BergenFragment();
        }
        else if (position == 2){
            return new Lofoten_islandFragment();
        }
        else if (position == 3){
            return new StavangerFragment();
        }
        else if(position == 4){
            return new  TromsoFragment();
        }
        else {
            return new TrondheimFragment();
        }
    }

    @Override
    public int getCount() {
        return 6;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        if (position == 0){
            return mContext.getString(R.string.category_oslo);
        }
        else if(position == 1){
            return mContext.getString(R.string.category_bergen);
        }
        else if(position == 2){
            return mContext.getString(R.string.category_lofoten_island);
        }
        else if(position == 3){
            return mContext.getString(R.string.category_stavanger);
        }
        else if (position == 4){
            return mContext.getString(R.string.category_tromso);
        }
        else {
            return mContext.getString(R.string.category_trondheim);
        }
    }

}
