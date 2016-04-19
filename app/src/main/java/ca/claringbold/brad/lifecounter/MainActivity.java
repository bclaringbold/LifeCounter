package ca.claringbold.brad.lifecounter;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.Toast;
import android.preference.PreferenceActivity;
import android.preference.PreferenceManager;
import android.content.Intent;
import android.app.Activity;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.preference.PreferenceFragment;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.TextView;
import android.view.View.OnClickListener;

public class MainActivity extends AppCompatActivity implements OnClickListener{

    private static final int RESULT_SETTINGS = 1;

    Button buttonhealthplus_you, buttonhealthminus_you, buttoncmddamageplus_you, buttoncmddamageminus_you;
    Button buttonhealthplus_opponent, buttonhealthminus_opponent, buttoncmddamageplus_opponent, buttoncmddamageminus_opponent;

    Integer healthyou, cmddamageyou, healthopponent, cmddamageopponent;

    TextView health_you, cmddamage_you;
    TextView health_opponent, cmddamage_opponent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        buttonhealthplus_you = (Button) findViewById(R.id.buttonhealthplus_you);
        buttonhealthminus_you = (Button) findViewById(R.id.buttonhealthminus_you);
        buttoncmddamageplus_you = (Button) findViewById(R.id.buttoncmddamageplus_you);
        buttoncmddamageminus_you = (Button) findViewById(R.id.buttoncmddamageminus_you);
        health_you = (TextView) findViewById(R.id.health_you);
        cmddamage_you = (TextView) findViewById(R.id.cmddamage_you);

        buttonhealthplus_opponent = (Button) findViewById(R.id.buttonhealthplus_oppoenent);
        buttonhealthminus_opponent = (Button) findViewById(R.id.buttonhealthminus_oppoenent);
        buttoncmddamageplus_opponent = (Button) findViewById(R.id.buttoncmddamageplus_oppoenent);
        buttoncmddamageminus_opponent = (Button) findViewById(R.id.buttoncmddamageminus_oppoenent);
        health_opponent = (TextView) findViewById(R.id.health_opponent);
        cmddamage_opponent = (TextView) findViewById(R.id.cmddamage_opponent);

        buttonhealthplus_you.setOnClickListener(this);
        buttonhealthminus_you.setOnClickListener(this);
        buttoncmddamageplus_you.setOnClickListener(this);
        buttoncmddamageminus_you.setOnClickListener(this);

        buttonhealthplus_opponent.setOnClickListener(this);
        buttonhealthminus_opponent.setOnClickListener(this);
        buttoncmddamageplus_opponent.setOnClickListener(this);
        buttoncmddamageminus_opponent.setOnClickListener(this);


        healthyou = 20;
        healthopponent = 20;
        cmddamageyou = 0;
        cmddamageopponent = 0;
        health_you.setText(String.valueOf(healthyou));
        health_opponent.setText(String.valueOf(healthopponent));
        cmddamage_you.setText(String.valueOf(cmddamageyou));
        cmddamage_opponent.setText(String.valueOf(cmddamageopponent));

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });


        fab.setVisibility(View.GONE);

    }




    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.buttonhealthplus_you:
                healthyou++;
                break;
            case R.id.buttonhealthminus_you:
                healthyou--;
                break;
            case R.id.buttonhealthplus_oppoenent:
                healthopponent++;
                break;
            case R.id.buttonhealthminus_oppoenent:
                healthopponent--;
                break;

            case R.id.buttoncmddamageplus_you:
                cmddamageyou++;
                break;
            case R.id.buttoncmddamageminus_you:
                cmddamageyou--;
                break;
            case R.id.buttoncmddamageplus_oppoenent:
                cmddamageopponent++;
                break;
            case R.id.buttoncmddamageminus_oppoenent:
                cmddamageopponent--;
                break;
        }
        health_you.setText(String.valueOf(healthyou));
        health_opponent.setText(String.valueOf(healthopponent));
        cmddamage_you.setText(String.valueOf(cmddamageyou));
        cmddamage_opponent.setText(String.valueOf(cmddamageopponent));
    }





    public static class MainSettingsFragment extends PreferenceFragment  {

        public void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            addPreferencesFromResource(R.xml.preferences);

        }

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {

            case R.id.action_settings:

                Toast.makeText(this, "Settings selected", Toast.LENGTH_SHORT)
                        .show();


              getFragmentManager().beginTransaction()
                      .replace(android.R.id.content,
                               new MainSettingsFragment()).commit();
                break;
                default:
        break;
        }


        return true;
    }
}
