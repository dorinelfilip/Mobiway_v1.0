package ro.pub.acs.trafficcollector.gui.statistics;

import android.os.Bundle;
import android.preference.EditTextPreference;
import android.preference.PreferenceFragment;
import android.util.Log;

import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import java.util.List;

import ro.pub.acs.trafficcollector.R;
import ro.pub.acs.trafficcollector.rest.RestClient;
import ro.pub.acs.trafficcollector.rest.model.Place;

public class StatisticsFragment extends PreferenceFragment {

    public StatisticsFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        addPreferencesFromResource(R.xml.fragment_statistics);

        final EditTextPreference etpMaxSpeed = (EditTextPreference) findPreference(getResources().getString(R.string.key_max_speed_preference));
        final EditTextPreference etpMinSpeed = (EditTextPreference) findPreference(getResources().getString(R.string.key_min_speed_preference));

        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    RestClient restClient = new RestClient();
                    final List<Double> speeds = restClient.getApiService().getSpeedStatistics();

                    if(speeds != null && speeds.size() == 2){
                        getActivity().runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                etpMaxSpeed.setSummary(speeds.get(0) + " km/h");
                                etpMinSpeed.setSummary(speeds.get(1) + " km/h");
                            }
                        });
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
        thread.start();

    }

}