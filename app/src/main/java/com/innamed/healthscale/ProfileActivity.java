package com.innamed.healthscale;

import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.PopupWindow;
import android.widget.TextView;

public class ProfileActivity extends AppCompatActivity {

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
        setContentView(R.layout.activity_notes);

        txtToolbar = (TextView) findViewById(R.id.toolbar_label);
        profile_button = (ImageButton) findViewById(R.id.profile_button);
        home_button = (ImageButton) findViewById(R.id.home_button);

        setOnClicks();

        String green = "<font color='#578439'>Welcome</font>";
        String black = " back";
        String message = green+black;

        // Loading Font Face
        tf = Typeface.createFromAsset(getAssets(), "fonts/gothic_0.ttf");
        Typeface tf_bold = Typeface.createFromAsset(getAssets(),"fonts/century-gothic-bold-italic.ttf");
        // Applying font
        txtToolbar.setTypeface(tf_bold);

        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.N) {
            txtToolbar.setText(Html.fromHtml(message ,Html.FROM_HTML_MODE_LEGACY));
        } else {
            txtToolbar.setText(Html.fromHtml(message ));
        }

    }
    public void setOnClicks(){
        home_button.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                Intent i = new Intent(ProfileActivity.this, DashboardActivity.class);
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
                        Intent i = new Intent(ProfileActivity.this, ProfileActivity.class);
                        startActivity(i);
                        findViewById(R.id.popup_window).setVisibility(View.GONE);
                    }
                });
                settings_button.setOnClickListener(new View.OnClickListener(){
                    @Override
                    public void onClick(View v) {
                        Intent i = new Intent(ProfileActivity.this, SettingsActivity.class);
                        startActivity(i);
                        findViewById(R.id.popup_window).setVisibility(View.GONE);
                    }
                });
                logout_button.setOnClickListener(new View.OnClickListener(){
                    @Override
                    public void onClick(View v) {
                        LoginActivity.setLoggedIn(false);
                        Intent i = new Intent(ProfileActivity.this, LoginActivity.class);
                        startActivity(i);
                        findViewById(R.id.popup_window).setVisibility(View.GONE);
                    }
                });
            }
        });
    }

}
