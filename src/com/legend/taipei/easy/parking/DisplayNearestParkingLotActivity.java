package com.legend.taipei.easy.parking;

import java.util.ArrayList;
import java.util.HashMap;

import android.app.ListActivity;
import android.os.Bundle;
import android.support.v4.app.NavUtils;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.SimpleAdapter;
import android.widget.TextView;

public class DisplayNearestParkingLotActivity extends ListActivity {

    private TextView txtMessage;
    ArrayList<HashMap<String,String>> parkList = new ArrayList<HashMap<String,String>>();
	
	@Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_nearest_parking_lot);
        getActionBar().setDisplayHomeAsUpEnabled(true);
        
        setupViewComponent();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.activity_display_nearest_parking_lot, menu);
        return true;
    }

    
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                NavUtils.navigateUpFromSameTask(this);
                return true;
        }
        return super.onOptionsItemSelected(item);
    }
    
    private void setupViewComponent() {
    	txtMessage = (TextView)findViewById(R.id.txtMessage);
    	txtMessage.setText("Found current GPS location, choose nearest parking lot from below:");
    	
    	//Test data, this version is only for testing ListView using SimpleAdapter
    	String [] parkName = new String []{
    			"Test Parking Lot", "Test Parking Lot2"};
    	String [] parkAddress = new String []{
    			"Address 1", "Address 2"};
    	String [] parkTotal = new String []{
    			"122", "322"};
    	String [] parkAvail = new String []{
    			"12", "302"};
    	for(int i = 0; i < 2; i++) {
    		HashMap<String,String> parkItem = new HashMap<String,String>();
    		parkItem.put("parkName", parkName[i]);
    		parkItem.put("parkAddress", parkAddress[i]);
    		parkItem.put("parkTotal", parkTotal[i]);
    		parkItem.put("parkAvail", parkAvail[i]);
    		parkList.add(parkItem);
    	}
    	
    	
    	//Add items into SimpleAdapter for ListView
    	SimpleAdapter adapter = new SimpleAdapter(this, parkList,
    			R.layout.parking_lot_list,
    			new String[] { "parkName", "parkAddress", "parkTotal",
    			"parkAvail"},
    			new int[] { R.id.txtParkName, R.id.txtParkAddress,
    			R.id.txtParkTotalSlot, R.id.txtParkAvailSlot});
    	setListAdapter(adapter);
    	
    }

}
