package com.innamed.healthscale;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.Typeface;
import android.graphics.drawable.GradientDrawable;
import android.media.Image;
import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.Html;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class TestLogActivity extends AppCompatActivity {

    private ImageButton profile_button;
    private Button edit_button;
    private Button settings_button;
    private Button logout_button;
    private ImageButton home_button;
    private Typeface tf;
    TextView txtToolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test_log);

        txtToolbar = (TextView) findViewById(R.id.toolbar_label);
        profile_button = (ImageButton) findViewById(R.id.profile_button);
        home_button = (ImageButton) findViewById(R.id.home_button);

        setOnClicks();

        // Loading Font Face
        tf = Typeface.createFromAsset(getAssets(), "fonts/gothic_0.ttf");
        Typeface tf_bold = Typeface.createFromAsset(getAssets(),"fonts/century-gothic-bold-italic.ttf");
        // Applying font
        txtToolbar.setTypeface(tf_bold);

        String green = "<font color='#578439'>your hands</font>";
        String black = "<font color='#000000'>Your health in </font>";
        String message = black+green;

        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.N) {
            txtToolbar.setText(Html.fromHtml(message ,Html.FROM_HTML_MODE_LEGACY));
        } else {
            txtToolbar.setText(Html.fromHtml(message ));
        }
        displayTests();
    }
    private void displayTests(){
        LinearLayout display = (LinearLayout)findViewById(R.id.past_tests);
        int numTests = 7;
        for(int k = 0; k < numTests; k++){
            LinearLayout row = new LinearLayout(this);
            row.setOrientation(LinearLayout.HORIZONTAL);
            row.setGravity(Gravity.CENTER);
            LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT,LinearLayout.LayoutParams.WRAP_CONTENT);
            row.setLayoutParams(params);
            row.setGravity(Gravity.CENTER);
            TextView date = new TextView(this);
            ImageView status = new ImageView(this);
            date.setText("7/6/2016");
            date.setTextColor(Color.BLACK);
            date.setTextSize(20);
            date.setTypeface(tf);
            date.setPadding(0,0,35,0);
            status.setImageResource(R.drawable.checkmark_icon);
            row.addView(date);
            row.addView(status);
            display.addView(row);
        }

    }
    public void setOnClicks(){
        home_button.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                Intent i = new Intent(TestLogActivity.this, DashboardActivity.class);
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
                        Intent i = new Intent(TestLogActivity.this, ProfileActivity.class);
                        startActivity(i);
                        findViewById(R.id.popup_window).setVisibility(View.GONE);
                    }
                });
                settings_button.setOnClickListener(new View.OnClickListener(){
                    @Override
                    public void onClick(View v) {
                        Intent i = new Intent(TestLogActivity.this, SettingsActivity.class);
                        startActivity(i);
                        findViewById(R.id.popup_window).setVisibility(View.GONE);
                    }
                });
                logout_button.setOnClickListener(new View.OnClickListener(){
                    @Override
                    public void onClick(View v) {
                        LoginActivity.setLoggedIn(false);
                        Intent i = new Intent(TestLogActivity.this, LoginActivity.class);
                        startActivity(i);
                        findViewById(R.id.popup_window).setVisibility(View.GONE);
                    }
                });
            }
        });
    }
}
