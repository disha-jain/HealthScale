package com.innamed.healthscale;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.Html;
import android.view.Gravity;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

public class NewsActivity extends AppCompatActivity {

    private ImageButton profile_button;
    private Button edit_button;
    private Button settings_button;
    private Button logout_button;
    private ImageButton home_button;
    private TextView txtToolbar;
    private Typeface tf;
    private boolean loggedIn;
    private int newsIndex = -2;
    private int numArticles = 9;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_news);
        loggedIn = LoginActivity.getLoggedIn();

        profile_button = (ImageButton) findViewById(R.id.profile_button);
        home_button = (ImageButton) findViewById(R.id.home_button);
        txtToolbar = (TextView) findViewById(R.id.toolbar_label);

        if(!loggedIn){
            home_button.setVisibility(View.GONE);
        }

        setOnClicks();

        // Loading Font Face
        tf = Typeface.createFromAsset(getAssets(), "fonts/gothic_0.ttf");
        Typeface tf_bold = Typeface.createFromAsset(getAssets(),"fonts/century-gothic-bold-italic.ttf");
        // Applying font
        txtToolbar.setTypeface(tf_bold);

        String green = "<font color='#578439'>latest info</font>";
        String black = "Keep up with the ";
        String message = black + green;

        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.N) {
            txtToolbar.setText(Html.fromHtml(message ,Html.FROM_HTML_MODE_LEGACY));
        } else {
            txtToolbar.setText(Html.fromHtml(message ));
        }
        displayNews();
    }

    public int getNewsIndex(){
        return newsIndex;
    }

    private void displayNews(){
        LinearLayout display = (LinearLayout)findViewById(R.id.display);
  /*      int numTests = 7;
        for(int k = 0; k < numTests; k++){
            LinearLayout row = new LinearLayout(this);
            row.setOrientation(LinearLayout.HORIZONTAL);
            row.setGravity(Gravity.CENTER);
            LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT,LinearLayout.LayoutParams.WRAP_CONTENT);
            row.setLayoutParams(params);
            row.setGravity(Gravity.CENTER);
            LinearLayout.LayoutParams margins = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT);
            margins.setMargins(10,20,10,20);
            TextView news = new TextView(this);
            news.setLayoutParams(margins);
            news.setText("News Article: dfghjdfghj fghjk 3e4rtgvbehjkcsh kagrvfbdf sijghb sotigj srgjn alrgsrhuljn  ff.");
            news.setTextColor(Color.BLACK);
            news.setTextSize(20);
            news.setTypeface(tf);

            news.setPadding(0,0,35,0);
            row.addView(news);
            display.addView(row);
        }
*/
        int startingNumber = getStartingNumber(numArticles);
        String articleTitle;
        for(int k = 0;k < numArticles; k++){
            articleTitle = "Temp Article " + k;
            NewsButton button = new NewsButton(this, articleTitle, k);
        }
    }

    public void setOnClicks(){
        home_button.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                Intent i = new Intent(NewsActivity.this, DashboardActivity.class);
                startActivity(i);
            }
        });
        if(!loggedIn) {
            profile_button.setOnClickListener(new View.OnClickListener() {
                public void onClick(View v) {
                    Intent i = new Intent(NewsActivity.this, LoginActivity.class);
                    startActivity(i);
                }
            });
            findViewById(R.id.popup_window).setVisibility(View.GONE);

        }
        else {
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
                            Intent i = new Intent(NewsActivity.this, ProfileActivity.class);
                            startActivity(i);
                            findViewById(R.id.popup_window).setVisibility(View.GONE);
                        }
                    });
                    settings_button.setOnClickListener(new View.OnClickListener(){
                        @Override
                        public void onClick(View v) {
                            Intent i = new Intent(NewsActivity.this, SettingsActivity.class);
                            startActivity(i);
                            findViewById(R.id.popup_window).setVisibility(View.GONE);
                        }
                    });
                    logout_button.setOnClickListener(new View.OnClickListener(){
                        @Override
                        public void onClick(View v) {
                            LoginActivity.setLoggedIn(false);
                            Intent i = new Intent(NewsActivity.this, LoginActivity.class);
                            startActivity(i);
                            findViewById(R.id.popup_window).setVisibility(View.GONE);
                        }
                    });

                }
            });
        }
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_news, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
    private int getStartingNumber(int n){
        if(n%2 == 1){
            if(n%3 > 2){
                return 1;
            }
        }
        return 2;
   }
}
