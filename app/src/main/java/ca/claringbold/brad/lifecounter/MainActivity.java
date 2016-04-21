package ca.claringbold.brad.lifecounter;

import android.support.v7.app.ActionBarActivity;
import android.preference.PreferenceManager;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.TextView;
import android.view.View.OnClickListener;


public class MainActivity extends ActionBarActivity implements OnClickListener{

    Button buttonhealthplus_you, buttonhealthminus_you, buttoncmddamageplus_you, buttoncmddamageminus_you;
    Button buttonhealthplus_opponent, buttonhealthminus_opponent, buttoncmddamageplus_opponent, buttoncmddamageminus_opponent;

    Integer healthyou, cmddamageyou, healthopponent, cmddamageopponent;

    TextView label_you, label_opponent;
    TextView health_you, cmddamage_you;
    TextView health_opponent, cmddamage_opponent;
    TextView commanderdamage_label, commanderdamage_label2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // get shared preferences
        final SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(this);

        buttonhealthplus_you = (Button) findViewById(R.id.buttonhealthplus_you);        buttonhealthminus_you = (Button) findViewById(R.id.buttonhealthminus_you);
        buttoncmddamageplus_you = (Button) findViewById(R.id.buttoncmddamageplus_you);        buttoncmddamageminus_you = (Button) findViewById(R.id.buttoncmddamageminus_you);
        health_you = (TextView) findViewById(R.id.health_you);        cmddamage_you = (TextView) findViewById(R.id.cmddamage_you);
        label_you = (TextView) findViewById(R.id.label_you); label_opponent= (TextView) findViewById(R.id.label_opponent);

        buttonhealthplus_opponent = (Button) findViewById(R.id.buttonhealthplus_oppoenent);        buttonhealthminus_opponent = (Button) findViewById(R.id.buttonhealthminus_oppoenent);
        buttoncmddamageplus_opponent = (Button) findViewById(R.id.buttoncmddamageplus_oppoenent);        buttoncmddamageminus_opponent = (Button) findViewById(R.id.buttoncmddamageminus_oppoenent);
        health_opponent = (TextView) findViewById(R.id.health_opponent);        cmddamage_opponent = (TextView) findViewById(R.id.cmddamage_opponent);

        commanderdamage_label = (TextView) findViewById(R.id.commanderdamage_label);
        commanderdamage_label2 = (TextView) findViewById(R.id.commanderdamage_label2);

        buttonhealthplus_you.setOnClickListener(this);        buttonhealthminus_you.setOnClickListener(this);
        buttoncmddamageplus_you.setOnClickListener(this);        buttoncmddamageminus_you.setOnClickListener(this);

        buttonhealthplus_opponent.setOnClickListener(this);        buttonhealthminus_opponent.setOnClickListener(this);
        buttoncmddamageplus_opponent.setOnClickListener(this);        buttoncmddamageminus_opponent.setOnClickListener(this);

        cmddamageyou = 0;        cmddamageopponent = 0;

        String healthyouTemp = preferences.getString("startingplayerhealth", "DEFAULT");
        healthyou = Integer.parseInt(healthyouTemp);

        String healthopTemp = preferences.getString("startingopponenthealth", "DEFAULT");
        healthopponent = Integer.parseInt(healthopTemp);

        label_you.setText(String.valueOf(preferences.getString("playername", "DEFAULT"))+"'s Health");
        label_opponent.setText(String.valueOf(preferences.getString("opponentname", "DEFAULT"))+"'s Health");

        health_you.setText(String.valueOf(healthyou));        health_opponent.setText(String.valueOf(healthopponent));
        cmddamage_you.setText(String.valueOf(cmddamageyou));        cmddamage_opponent.setText(String.valueOf(cmddamageopponent));


         if(preferences.getBoolean("cmddamageenabled", false)) {
             buttoncmddamageplus_you.setVisibility(View.VISIBLE);
             buttoncmddamageminus_you.setVisibility(View.VISIBLE);
             buttoncmddamageplus_opponent.setVisibility(View.VISIBLE);
             buttoncmddamageminus_opponent.setVisibility(View.VISIBLE);
             cmddamage_you.setVisibility(View.VISIBLE);
             cmddamage_opponent.setVisibility(View.VISIBLE);
             commanderdamage_label.setVisibility(View.VISIBLE);
             commanderdamage_label2.setVisibility(View.VISIBLE);
        } else {
             buttoncmddamageplus_you.setVisibility(View.INVISIBLE);
             buttoncmddamageminus_you.setVisibility(View.INVISIBLE);
             buttoncmddamageplus_opponent.setVisibility(View.INVISIBLE);
             buttoncmddamageminus_opponent.setVisibility(View.INVISIBLE);
             cmddamage_you.setVisibility(View.INVISIBLE);
             cmddamage_opponent.setVisibility(View.INVISIBLE);
             commanderdamage_label.setVisibility(View.INVISIBLE);
             commanderdamage_label2.setVisibility(View.INVISIBLE);
        }
    }

    //Checks to see what button is pressed and changes the value
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
        //updates the value on the screen
        health_you.setText(String.valueOf(healthyou));        health_opponent.setText(String.valueOf(healthopponent));
        cmddamage_you.setText(String.valueOf(cmddamageyou));        cmddamage_opponent.setText(String.valueOf(cmddamageopponent));
    }

    // app is already running and gets a new intent (for example you changed preferences and want to return to MainActivity)
    @Override
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);

        // get shared preferences
        final SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(this);

        if(preferences.getBoolean("cmddamageenabled", false)) {
            buttoncmddamageplus_you.setVisibility(View.VISIBLE);
            buttoncmddamageminus_you.setVisibility(View.VISIBLE);
            buttoncmddamageplus_opponent.setVisibility(View.VISIBLE);
            buttoncmddamageminus_opponent.setVisibility(View.VISIBLE);
            cmddamage_you.setVisibility(View.VISIBLE);
            cmddamage_opponent.setVisibility(View.VISIBLE);
            commanderdamage_label.setVisibility(View.VISIBLE);
            commanderdamage_label2.setVisibility(View.VISIBLE);
        } else {
            buttoncmddamageplus_you.setVisibility(View.INVISIBLE);
            buttoncmddamageminus_you.setVisibility(View.INVISIBLE);
            buttoncmddamageplus_opponent.setVisibility(View.INVISIBLE);
            buttoncmddamageminus_opponent.setVisibility(View.INVISIBLE);
            cmddamage_you.setVisibility(View.INVISIBLE);
            cmddamage_opponent.setVisibility(View.INVISIBLE);
            commanderdamage_label.setVisibility(View.INVISIBLE);
            commanderdamage_label2.setVisibility(View.INVISIBLE);
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            Intent settings = new Intent(this, MainSettingsActivity.class);
            startActivity(settings);
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

}
