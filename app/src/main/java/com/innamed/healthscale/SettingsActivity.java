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
import android.widget.CompoundButton;
import android.widget.ImageButton;
import android.widget.PopupWindow;
import android.widget.Switch;
import android.widget.TextView;

public class SettingsActivity extends AppCompatActivity {

    private ImageButton profile_button;
    private TextView thirdParty;
    private TextView backups;
    private TextView changePassword;
    private Switch thirdPartySwitch;
    private Switch backupsSwitch;
    private Switch changePasswordSwitch;
    private Button edit_button;
    private Button settings_button;
    private Button logout_button;
    private Typeface tf;
    private ImageButton home_button;
    TextView txtToolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);

        txtToolbar = (TextView) findViewById(R.id.toolbar_label);
        profile_button = (ImageButton) findViewById(R.id.profile_button);
        thirdParty = (TextView) findViewById(R.id.third_party);
        backups = (TextView) findViewById(R.id.backup);
        changePassword = (TextView) findViewById(R.id.changePassword);
        thirdPartySwitch = (Switch) findViewById(R.id.third_party_switch);
        backupsSwitch = (Switch) findViewById(R.id.backup_switch);
        changePasswordSwitch = (Switch) findViewById(R.id.changePassword_switch);
        profile_button = (ImageButton) findViewById(R.id.profile_button);
        home_button = (ImageButton) findViewById(R.id.home_button);

        String green = "<font color='#578439'>help</font>";
        String black = "We're here to ";
        String message = black + green;

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

        setFonts();
        setOnClicks();

    }
    private void setFonts(){
        // Font path
        String fontPath = "fonts/gothic_0.ttf";
        // Loading Font Face
        Typeface tf = Typeface.createFromAsset(getAssets(), fontPath);
        // Applying font
        txtToolbar.setTypeface(tf);
        thirdParty.setTypeface(tf);
        backups.setTypeface(tf);
        changePassword.setTypeface(tf);

    }
    public void setOnClicks(){
        home_button.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                Intent i = new Intent(SettingsActivity.this, DashboardActivity.class);
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
                        Intent i = new Intent(SettingsActivity.this, ProfileActivity.class);
                        startActivity(i);
                        findViewById(R.id.popup_window).setVisibility(View.GONE);
                    }
                });
                settings_button.setOnClickListener(new View.OnClickListener(){
                    @Override
                    public void onClick(View v) {
                        Intent i = new Intent(SettingsActivity.this, SettingsActivity.class);
                        startActivity(i);
                        findViewById(R.id.popup_window).setVisibility(View.GONE);
                    }
                });
                logout_button.setOnClickListener(new View.OnClickListener(){
                    @Override
                    public void onClick(View v) {
                        LoginActivity.setLoggedIn(false);
                        Intent i = new Intent(SettingsActivity.this, LoginActivity.class);
                        startActivity(i);
                        findViewById(R.id.popup_window).setVisibility(View.GONE);
                    }
                });
            }
        });
        thirdPartySwitch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                // do something, the isChecked will be
                // true if the switch is in the On position
            }
        });
        backupsSwitch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                // do something, the isChecked will be
                // true if the switch is in the On position
            }
        });
        changePasswordSwitch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                // do something, the isChecked will be
                // true if the switch is in the On position
            }
        });
    }
}
