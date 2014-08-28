package com.example.alocation;

import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.GooglePlayServicesClient;
import com.google.android.gms.location.LocationClient;

import android.app.Activity;
import android.location.Location;
import android.os.Bundle;
import android.widget.Toast;

public class FirstTime extends Activity implements
GooglePlayServicesClient.ConnectionCallbacks,
GooglePlayServicesClient.OnConnectionFailedListener{

	LocationClient mLocationClient;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView( R.layout.first_time );
		
		 mLocationClient = new LocationClient(this, this, this);
		
		
		Location mCurrentLocation;
		
//		GetCurrentLocation get1 = new GetCurrentLocation();
//		
//		Location loc1 =  null;
//		
////		loc1 = get1.getLocation( this );
////	
//		System.out.println(loc1.getLatitude());
//		
//		Toast toast = Toast.makeText(getApplicationContext(),Double.toString( loc1.getLatitude() ), Toast.LENGTH_SHORT );
//		toast.show();
//		
		
		
		
		
	}

	@Override
	public void onConnectionFailed(ConnectionResult result) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onConnected(Bundle connectionHint) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onDisconnected() {
		// TODO Auto-generated method stub
		
	}

	
	

}
