package com.example.alocation;

import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.GooglePlayServicesClient;
import com.google.android.gms.location.LocationClient;

import android.app.Activity;
import android.content.Context;
import android.location.Location;
import android.os.Bundle;

public class getCurrentLocation extends Activity implements GooglePlayServicesClient.ConnectionCallbacks,
GooglePlayServicesClient.OnConnectionFailedListener{

	static LocationClient mLocationClient;
	static Location mCurrentLocation;
	
	public static Location getLocation(Context c){
		mLocationClient = new LocationClient(c, null, null );
		
		mCurrentLocation = mLocationClient.getLastLocation();
		return mCurrentLocation;
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
