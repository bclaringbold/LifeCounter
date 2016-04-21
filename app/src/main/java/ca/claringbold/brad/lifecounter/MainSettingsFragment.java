package ca.claringbold.brad.lifecounter;


import android.content.Context;
import android.os.Bundle;
import android.preference.Preference;
import android.preference.PreferenceFragment;
import android.widget.Toast;

public class MainSettingsFragment extends PreferenceFragment {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // load the preferences from an XML resource
        addPreferencesFromResource(R.xml.preferences);

        // listener for clearing cache preference
        /*
        findPreference("call_method").setOnPreferenceClickListener(new Preference.OnPreferenceClickListener() {
            @Override
            public boolean onPreferenceClick(Preference preference) {

                // show toast
                Context c = getActivity();
                Toast toast = Toast.makeText(c, R.string.call_method_clicked, Toast.LENGTH_LONG);
                toast.show();

                return true;
            }
        });*/
    }

}
