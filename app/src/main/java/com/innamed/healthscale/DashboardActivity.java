package com.innamed.healthscale;

import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.text.Html;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

public class DashboardActivity extends AppCompatActivity {

    private ImageButton profile_button;
    public Button edit_button;
    public Button settings_button;
    public Button logout_button;
    public ImageButton home_button;
    public static Typeface tf;
    public static Typeface tf_bold;
    private TextView txtToolbar;

    CustomPagerAdapter mCustomPagerAdapter;
    ViewPager mViewPager;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);

        // == Setting up the ViewPager ==

        mCustomPagerAdapter = new CustomPagerAdapter(getSupportFragmentManager(), this);

        mViewPager = (ViewPager) findViewById(R.id.pager);
        mViewPager.setAdapter(mCustomPagerAdapter);


        txtToolbar = (TextView) findViewById(R.id.toolbar_label);
        profile_button = (ImageButton) findViewById(R.id.profile_button);
        home_button = (ImageButton) findViewById(R.id.home_button);

        String green = "<font color='#578439'> dashboard</font>";
        String black = "Welcome to your";
        String message = black + green;


        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.N) {
            txtToolbar.setText(Html.fromHtml(message ,Html.FROM_HTML_MODE_LEGACY));
        } else {
            txtToolbar.setText(Html.fromHtml(message ));
        }

        setFonts();
        setOnClicks();

    }
    private void setFonts(){
        // Font path
        String fontPath = "fonts/gothic_0.ttf";
        String fontPath2 = "fonts/century-gothic-bold-italic.ttf";
        // Loading Font Face
        tf = Typeface.createFromAsset(getAssets(), fontPath);
        tf_bold = Typeface.createFromAsset(getAssets(),fontPath2);
        // Applying font
        txtToolbar.setTypeface(tf_bold);

    }
    private void setOnClicks(){
        home_button.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                Intent i = new Intent(DashboardActivity.this, DashboardActivity.class);
                startActivity(i);
            }
        });
        profile_button.setOnClickListener(new View.OnClickListener(){
            public void onClick(View arg0) {
                findViewById(R.id.popup_window).setVisibility(View.VISIBLE);
                edit_button = (Button) findViewById(R.id.edit);
                settings_button = (Button) findViewById(R.id.settings);
                logout_button = (Button) findViewById(R.id.logout);
                edit_button.setTypeface(tf);
                settings_button.setTypeface(tf);
                logout_button.setTypeface(tf);

                edit_button.setOnClickListener(new View.OnClickListener(){
                    @Override
                    public void onClick(View v) {
                        Intent i = new Intent(DashboardActivity.this, ProfileActivity.class);
                        startActivity(i);
                        findViewById(R.id.popup_window).setVisibility(View.GONE);
                    }
                });
                settings_button.setOnClickListener(new View.OnClickListener(){
                    @Override
                    public void onClick(View v) {
                        Intent i = new Intent(DashboardActivity.this, SettingsActivity.class);
                        startActivity(i);
                        findViewById(R.id.popup_window).setVisibility(View.GONE);
                    }
                });
                logout_button.setOnClickListener(new View.OnClickListener(){
                    @Override
                    public void onClick(View v) {
                        LoginActivity.setLoggedIn(false);
                        Intent i = new Intent(DashboardActivity.this, LoginActivity.class);
                        startActivity(i);
                        findViewById(R.id.popup_window).setVisibility(View.GONE);
                    }
                });
            }
        });
    }
}
