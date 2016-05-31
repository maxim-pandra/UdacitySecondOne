package ru.alfabank.udacity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;

public class MainActivity extends AppCompatActivity implements ForecastFragment.OnFragmentInteractionListener{


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction()
                    .add(R.id.container, ForecastFragment.newInstance("1","2"))
                    .commit();
        }
    }

    @Override
    public void onFragmentInteraction(Uri uri) {

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
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
            Intent launchSettings = new Intent(getApplicationContext(), SettingsActivity.class);
            startActivity(launchSettings);
            return true;
        }

        if (id == R.id.action_view_location) {
            openPreferedLocationOnMap();
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    private void openPreferedLocationOnMap() {
        String prefLocation = Utility.getPreferredLocation(this);
        Uri geoLocation = Uri.parse("geo:0,0?").buildUpon()
                .appendQueryParameter("q", prefLocation)
                .build();
        Intent showGeoIntent = new Intent(Intent.ACTION_VIEW, geoLocation);
        if (showGeoIntent.resolveActivity(getPackageManager()) != null) {
            startActivity(showGeoIntent);
        }
    }
}
