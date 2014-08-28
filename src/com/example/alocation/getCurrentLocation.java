package com.example.alocation;

import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.GooglePlayServicesClient;
import com.google.android.gms.location.LocationClient;

import android.app.Activity;
import android.content.Context;
import android.location.Location;
import android.os.Bundle;

public class GetCurrentLocation extends Activity implements GooglePlayServicesClient.ConnectionCallbacks,
GooglePlayServicesClient.OnConnectionFailedListener{

	 LocationClient mLocationClient;
	 Location mCurrentLocation;
	
	 private Context c;
	 public GetCurrentLocation(Context c){
		 this.c=c;
		 
		 getLocation(c);
	 }
	
	
	
	@Override
	public void onConnectionFailed(ConnectionResult result) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onConnected(Bundle connectionHint) {
		// TODO Auto-generated method stub
		
			mLocationClient = new LocationClient(this , null, null );
		
		mCurrentLocation = mLocationClient.getLastLocation(); 
		
		
		
	}

	@Override
	public void onDisconnected() {
		// TODO Auto-generated method stub
		
	}
	
	public Location getLocation(Context c){
		
		return mCurrentLocation;
	}
	
	

	
	
	
	
}
