package com.legend.taipei.easy.parking;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;

public class MainActivity extends Activity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.activity_main, menu);
        return true;
    }
    
    /** Called when the user clicks the Find Nearest Parking Lot button */
    public void openFindParkingLot(View view) {
    	Intent intent = new Intent(this, DisplayNearestParkingLotActivity.class);
    	startActivity(intent);
    }
    
}
