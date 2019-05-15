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
public class AnalytesFragment extends Fragment {

    private ImageButton bun_button;
    private ImageButton creatinine_button;
    private ImageButton glucose_button;
    private ImageButton t4_button;
    private ImageButton cholesterol_button;
    private ImageButton b12_button;
    private ImageButton crp_button;
    private static TextView bun_label;
    private static TextView creatinine_label;
    private static TextView glucose_label;
    private static TextView t4_label;
    private static TextView cholesterol_label;
    private static TextView b12_label;
    private static TextView crp_label;

    private static Typeface tf;
    private static Typeface tf_bold;
    public static String button = "";

    View rootView;

    public static String getAnalyte(){
        return button;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout resource that'll be returned
        rootView = inflater.inflate(R.layout.fragment_analytes, container, false);
        bun_button = (ImageButton) rootView.findViewById(R.id.bun_button);
        creatinine_button = (ImageButton) rootView.findViewById(R.id.creatinine_button);
        glucose_button = (ImageButton) rootView.findViewById(R.id.glucose_button);
        t4_button = (ImageButton) rootView.findViewById(R.id.t4_button);
        cholesterol_button = (ImageButton) rootView.findViewById(R.id.cholesterol_button);
        b12_button = (ImageButton) rootView.findViewById(R.id.b12_button);
        crp_button = (ImageButton) rootView.findViewById(R.id.crp_button);

        bun_label = (TextView) rootView.findViewById(R.id.bun_label);
        creatinine_label = (TextView) rootView.findViewById(R.id.creatinine_label);
        glucose_label = (TextView) rootView.findViewById(R.id.glucose_label);
        t4_label = (TextView) rootView.findViewById(R.id.t4_label);
        cholesterol_label = (TextView) rootView.findViewById(R.id.cholesterol_label);
        b12_label = (TextView) rootView.findViewById(R.id.b12_label);
        crp_label = (TextView) rootView.findViewById(R.id.crp_label);

        setFonts();
        setOnClicks();

        // Get the arguments that was supplied when
        // the fragment was instantiated in the
        // CustomPagerAdapter
  //      Bundle args = getArguments();
//        ((TextView) rootView.findViewById(R.id.text)).setText("Page " + args.getInt("page_position"));

        return rootView;
    }
    private static void setFonts(){
        // Loading Font Face
        tf = DashboardActivity.tf;
        tf_bold = DashboardActivity.tf_bold;
        // Applying font
        bun_label.setTypeface(tf_bold);
        creatinine_label.setTypeface(tf_bold);
        glucose_label.setTypeface(tf_bold);
        t4_label.setTypeface(tf_bold);
        cholesterol_label.setTypeface(tf_bold);
        b12_label.setTypeface(tf_bold);
        crp_label.setTypeface(tf_bold);

    }
    public void startAnalyte(View v){
        Intent i = new Intent(getActivity(), AnalyteActivity.class);
        startActivity(i);
    }

    private void setOnClicks(){
        bun_button.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                button = "bun";
                startAnalyte(v);
            }
        });
        creatinine_button.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                button = "creatinine";
                startAnalyte(v);
            }
        });
        glucose_button.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                button = "glucose";
                startAnalyte(v);
            }
        });
        t4_button.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                button = "t4";
                startAnalyte(v);
            }
        });
        cholesterol_button.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                button = "cholesterol";
                startAnalyte(v);
            }
        });
        b12_button.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                button = "b12";
                startAnalyte(v);
            }
        });
        crp_button.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                button = "crp";
                startAnalyte(v);
            }
        });
    }

}