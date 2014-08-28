package com.example.alocation;

import android.app.Activity;
import android.location.Location;
import android.os.Bundle;
import android.widget.Toast;

public class FirstTime extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		
		setContentView( R.layout.first_time );
		
		Location loc1 = getCurrentLocation.getLocation( this );
		
		Toast toast = Toast.makeText(getApplicationContext(),
				loc1.toString(), Toast.LENGTH_SHORT );
		toast.show();
		
		
		
		
		
	}

	
	

}
