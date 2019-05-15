package com.innamed.healthscale;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.Html;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.PopupWindow;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

import com.jjoe64.graphview.GraphView;
import com.jjoe64.graphview.series.DataPoint;
import com.jjoe64.graphview.series.LineGraphSeries;

import java.util.HashMap;

public class AnalyteActivity extends AppCompatActivity {

    private ImageButton profile_button;
    private Button edit_button;
    private Button settings_button;
    private Button logout_button;
    private ImageButton home_button;
    private Typeface tf;
    TextView title;
    TextView txtToolBar;
    private String analyte;
    private TableLayout testResults;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_analyte);
        HashMap<String, String> analytes = new HashMap<>(7);
        analytes.put("bun", "BUN");
        analytes.put("creatinine", "Creatinine");
        analytes.put("glucose", "Glucose");
        analytes.put("t4", "T4");
        analytes.put("cholesterol", "Cholesterol");
        analytes.put("b12", "Vitamin B12");
        analytes.put("crp", "CRP");

        analyte = AnalytesFragment.getAnalyte();

        txtToolBar = (TextView) findViewById(R.id.toolbar_label);
        testResults = (TableLayout) findViewById(R.id.test_results);
        title = (TextView) findViewById(R.id.analyte_name);
        profile_button = (ImageButton) findViewById(R.id.profile_button);
        home_button = (ImageButton) findViewById(R.id.home_button);

        if(analytes.containsKey(analyte))
            title.setText(analytes.get(analyte));
        else
            title.setText("NULL");

        setOnClicks();

        String green = "<font color='#578439'>doing</font>";
        String black = "<font color='#A6A6A6'> How are you </font>";
        String message = black+green+"?";

        // Loading Font Face
        tf = Typeface.createFromAsset(getAssets(), "fonts/gothic_0.ttf");
        Typeface tf_bold = Typeface.createFromAsset(getAssets(),"fonts/century-gothic-bold-italic.ttf");
        // Applying font
        title.setTypeface(tf_bold);
        txtToolBar.setTypeface(tf_bold);

        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.N) {
            txtToolBar.setText(Html.fromHtml(message ,Html.FROM_HTML_MODE_LEGACY));
        } else {
            txtToolBar.setText(Html.fromHtml(message ));
        }
        buildGraph();
        displayData();
    }
    private void displayData(){
        int numRows = 2;
        for(int k = 0; k < numRows; k++){
            TableRow row = new TableRow(this);
            row.setGravity(Gravity.CENTER);
            TextView date = new TextView(this);
            TextView level = new TextView(this);
            ImageView so = new ImageView(this);

            so.setImageResource(R.drawable.checkmark_icon);

            date.setText(((k+1)*2)+"/"+ ((k+3)*2) +"/2016");
            date.setGravity(Gravity.CENTER);
            date.setTypeface(Typeface.SERIF,Typeface.NORMAL);
            date.setTextColor(Color.BLACK);
            date.setTextSize(20);
            level.setText("420");
            level.setGravity(Gravity.CENTER);
            level.setTypeface(Typeface.SERIF,Typeface.NORMAL);
            level.setTextSize(20);
            level.setTextColor(Color.BLACK);
            so.setPadding(10,5,0,10);
            so.setScaleType(ImageView.ScaleType.FIT_START);
            so.setMaxHeight(18);

            row.addView(date,0);
            row.addView(level, 1);
            row.addView(so,2);
            testResults.addView(row);
        }
    }
    private void buildGraph(){
        GraphView graph = (GraphView) findViewById(R.id.graph);
        LineGraphSeries<DataPoint> series = new LineGraphSeries<>(new DataPoint[] {
                new DataPoint(0, 1),
                new DataPoint(1, 5),
                new DataPoint(2, 3),
                new DataPoint(3, 2),
                new DataPoint(4, 6)
        });
        graph.addSeries(series);
    }

    public void setOnClicks(){
        home_button.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                Intent i = new Intent(AnalyteActivity.this, DashboardActivity.class);
                startActivity(i);
            }
        });
        profile_button.setOnClickListener(new View.OnClickListener(){
            public void onClick(View arg0) {
                edit_button = (Button) findViewById(R.id.edit);
                settings_button = (Button) findViewById(R.id.settings);
                logout_button = (Button) findViewById(R.id.logout);
                edit_button.setTypeface(tf);
                settings_button.setTypeface(tf);
                logout_button.setTypeface(tf);
                edit_button.setOnClickListener(new View.OnClickListener(){
                    @Override
                    public void onClick(View v) {
                        Intent i = new Intent(AnalyteActivity.this, ProfileActivity.class);
                        startActivity(i);
                        findViewById(R.id.popup_window).setVisibility(View.GONE);
                    }
                });
                settings_button.setOnClickListener(new View.OnClickListener(){
                    @Override
                    public void onClick(View v) {
                        Intent i = new Intent(AnalyteActivity.this, SettingsActivity.class);
                        startActivity(i);
                        findViewById(R.id.popup_window).setVisibility(View.GONE);
                    }
                });
                logout_button.setOnClickListener(new View.OnClickListener(){
                    @Override
                    public void onClick(View v) {
                        LoginActivity.setLoggedIn(false);
                        Intent i = new Intent(AnalyteActivity.this, LoginActivity.class);
                        startActivity(i);
                        findViewById(R.id.popup_window).setVisibility(View.GONE);
                    }
                });
            }
        });
    }


}
