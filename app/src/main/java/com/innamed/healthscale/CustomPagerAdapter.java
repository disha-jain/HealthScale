package com.innamed.healthscale;

import android.content.Context;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.content.Context;
import android.os.Bundle;
/**
 * Created by diyarocker on 7/7/16.
 */
public class CustomPagerAdapter extends FragmentStatePagerAdapter {

    protected Context mContext;

    public CustomPagerAdapter(FragmentManager fm, Context context) {
        super(fm);
        mContext = context;
    }

    @Override
    // This method returns the fragment associated with
    // the specified position.
    //
    // It is called when the Adapter needs a fragment
    // and it does not exists.
    public Fragment getItem(int position) {

        // Create fragment object
        Fragment fragment = new DashboardFragment();

/*        // Attach some data to it that we'll
        // use to populate our fragment layouts
        Bundle args = new Bundle();
        args.putInt("page_position", position + 1);

        // Set the arguments on the fragment
        // that will be fetched in DemoFragment@onCreateView
        fragment.setArguments(args);*/

        switch (position) {
            case 0:
                return new DashboardFragment();
            case 1:
                return new AnalytesFragment();
            case 2:
                return new NutritionFragment();
        }
        return fragment;
    }

    @Override
    public int getCount() {
        return 3;
    }

}