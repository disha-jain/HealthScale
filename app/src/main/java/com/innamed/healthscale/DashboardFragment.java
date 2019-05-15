package com.innamed.healthscale;

import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;

/**
 * Created by diyarocker on 7/7/16.
 */
public class DashboardFragment extends Fragment {
    private ImageButton news_button;
    private ImageButton notes_button;
    private ImageButton test_log_button;
    private static TextView notes_label;
    private static TextView news_label;
    private static TextView test_log_label;
    private static Typeface tf;
    private static Typeface tf_bold;

    View rootView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout resource that'll be returned
        rootView = inflater.inflate(R.layout.fragment_dashboard, container, false);

        // Get the arguments that was supplied when
        // the fragment was instantiated in the
        // CustomPagerAdapter
  //      Bundle args = getArguments();
//        ((TextView) rootView.findViewById(R.id.text)).setText("Page " + args.getInt("page_position"));
        news_button = (ImageButton) rootView.findViewById(R.id.news_button);
        notes_button = (ImageButton) rootView.findViewById(R.id.notes_button);
        test_log_button = (ImageButton) rootView.findViewById(R.id.test_log_button);
        notes_label = (TextView) rootView.findViewById(R.id.notes_label);
        news_label = (TextView) rootView.findViewById(R.id.news_label);
        test_log_label = (TextView) rootView.findViewById(R.id.test_log_label);

        news_label.setText("News");
        notes_label.setText("Notes");
        test_log_label.setText("Test Log");
        setFonts();
        setOnClicks();

        return rootView;
    }
    private static void setFonts(){
        // Loading Font Face
        tf = DashboardActivity.tf;
        tf_bold = DashboardActivity.tf_bold;
        // Applying font
        notes_label.setTypeface(tf_bold);
        news_label.setTypeface(tf_bold);
        test_log_label.setTypeface(tf_bold);

    }
    private void setOnClicks(){
        news_button.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                Intent i = new Intent(getActivity(), NewsActivity.class);
                startActivity(i);            }
        });
        notes_button.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                Intent i = new Intent(getActivity(), NotesActivity.class);
                startActivity(i);
            }
        });
        test_log_button.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                Intent i = new Intent(getActivity(), TestLogActivity.class);
                startActivity(i);
            }
        });

    }
}