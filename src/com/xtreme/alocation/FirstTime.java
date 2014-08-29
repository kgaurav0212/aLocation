package com.xtreme.alocation;

import java.util.ArrayList;
import java.util.List;

import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;
import org.json.JSONObject;

import android.app.Activity;
import android.content.Intent;
import android.location.Location;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.alocation.R;
import com.google.android.gms.location.LocationClient;

public class FirstTime extends Activity implements OnClickListener {

	LocationClient mLocationClient;
	Location mCurrentLocation;	
	

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView( R.layout.first_time );
		
		Button b1 = (Button) findViewById(R.id.buttonFirstTime);
		b1.setOnClickListener(this);
	
	}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		sendLocation();
		
	}

	private void sendLocation(){
		
		EditText e1 = (EditText) findViewById(R.id.editTextFirstTime);
		String name = e1.getText().toString();
		
		GPSTracker gps = new GPSTracker( this );
		
		if( gps.canGetLocation() )
		{
			double lat = gps.getLatitude();
			double lng = gps.getLongitude();
			
			List<NameValuePair> nameValuePairs = new ArrayList<NameValuePair>(3);
			
			nameValuePairs.add(new BasicNameValuePair("name", name));
			nameValuePairs.add(new BasicNameValuePair("lat", Double.toString(lat) ) );
			nameValuePairs.add(new BasicNameValuePair("lng", Double.toString(lng)) );
			
			String URL = "insert.php";
			
			Connection.getObject(URL, nameValuePairs);
			
			Intent i = new Intent (FirstTime.this, MainActivity.class);
			startActivity(i);
			
//			finish();
			
		}
	}
	
	

}
