package ro.pub.acs.mobiway.gui.statistics;

import android.support.v4.app.NavUtils;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import com.google.android.gms.analytics.GoogleAnalytics;

import org.acra.ACRA;

import ro.pub.acs.mobiway.R;

public class StatisticsActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        //ACRA log
        ACRA.getErrorReporter().putCustomData("StatisticsActivity.onCreate()", "method has been invoked");

        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_statistics);

        getFragmentManager().beginTransaction()
                .replace(android.R.id.content, new StatisticsFragment())
                .commit();

        getSupportActionBar().setTitle(getResources().getString(R.string.action_statistics));
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        //ACRA log
        ACRA.getErrorReporter().putCustomData("StatisticsActivity.onCreateOptionsMenu()", "method has been invoked");

        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_statistics, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        //ACRA log
        ACRA.getErrorReporter().putCustomData("StatisticsActivity.onOptionsItemSelected()", "method has been invoked");

        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        switch (id) {
            case android.R.id.home: {
                NavUtils.navigateUpFromSameTask(this);
                return true;
            }
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onStart() {

        //ACRA log
        ACRA.getErrorReporter().putCustomData("StatisticsActivity.onStart()", "method has been invoked");

        super.onStart();
        GoogleAnalytics.getInstance(this).reportActivityStart(this);
    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    @Override
    protected void onStop() {

        //ACRA log
        ACRA.getErrorReporter().putCustomData("StatisticsActivity.onStop()", "method has been invoked");

        GoogleAnalytics.getInstance(this).reportActivityStop(this);
        super.onStop();
    }
}