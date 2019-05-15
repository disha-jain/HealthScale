package com.innamed.healthscale;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by diyarocker on 7/7/16.
 */
public class NutritionFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout resource that'll be returned
        View rootView = inflater.inflate(R.layout.fragment_nutrition, container, false);

        // Get the arguments that was supplied when
        // the fragment was instantiated in the
        // CustomPagerAdapter
  //      Bundle args = getArguments();
//        ((TextView) rootView.findViewById(R.id.text)).setText("Page " + args.getInt("page_position"));

        return rootView;
    }
}