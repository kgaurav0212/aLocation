/*
 * Copyright (C) 2012 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.example.alocation;

import java.util.ArrayList;

import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.widget.Toast;

import com.google.android.gms.maps.CameraUpdate;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.LatLngBounds;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

/**
 * This shows how to create a simple activity with a map and a marker on the map.
 * <p>
 * Notice how we deal with the possibility that the Google Play services APK is not
 * installed/enabled/updated on a user's device.
 */
public class BasicMapDemoActivity extends FragmentActivity {
    /**
     * Note that this may be null if the Google Play services APK is not available.
     */
    private GoogleMap mMap;
    ArrayList<Marker> markers;

       
    LatLng pos1 =  new LatLng(0, 0);
    LatLng pos2 =  new LatLng(20, 30);
    
    ArrayList<LocData> locationList = CreateLocData.getLocationData();
    
    ArrayList<Integer> selectedIds = MainActivity.selectedIds;
    

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.basic_demo);
        setUpMapIfNeeded();
        
        showMarkers();
    }

    @Override
    protected void onResume() {
        super.onResume();
        setUpMapIfNeeded();
    }

    /**
     * Sets up the map if it is possible to do so (i.e., the Google Play services APK is correctly
     * installed) and the map has not already been instantiated.. This will ensure that we only ever
     * call {@link #setUpMap()} once when {@link #mMap} is not null.
     * <p>
     * If it isn't installed {@link SupportMapFragment} (and
     * {@link com.google.android.gms.maps.MapView MapView}) will show a prompt for the user to
     * install/update the Google Play services APK on their device.
     * <p>
     * A user can return to this FragmentActivity after following the prompt and correctly
     * installing/updating/enabling the Google Play services. Since the FragmentActivity may not
     * have been completely destroyed during this process (it is likely that it would only be
     * stopped or paused), {@link #onCreate(Bundle)} may not be called again so we should call this
     * method in {@link #onResume()} to guarantee that it will be called.
     */
    private void setUpMapIfNeeded() {
        // Do a null check to confirm that we have not already instantiated the map.
        if (mMap == null) {
            // Try to obtain the map from the SupportMapFragment.
            mMap = ((SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.map))
                    .getMap();
            // Check if we were successful in obtaining the map.
            if (mMap != null) {
                setUpMap();
            }
        }
    }

    
    private void setUpMap() {
    	mMap.setMyLocationEnabled(true);
//    	Toast toast = Toast.makeText( getApplicationContext(), locationList.get(0).getPosition().toString(), Toast.LENGTH_SHORT);
//    	toast.show();
    	        
    }
    
    private void showMarkers(){
    	
    	markers = new ArrayList<Marker>();
        
    	for(int i=0;i < selectedIds.size()  ;i++)
    	{
    		int index = selectedIds.get(i);
    		
    		String uri = "drawable/" + locationList.get(index).getName();
			int imageResource = getResources().getIdentifier(uri, null,
					getPackageName());
			Drawable image = getResources().getDrawable(imageResource);
			Bitmap bitmap = ((BitmapDrawable)image ).getBitmap();
			bitmap =Bitmap.createScaledBitmap(bitmap, 120, 120, false);
    		
			MarkerOptions markerOptions = new MarkerOptions()
				.position( locationList.get(index).getPosition() )
				.title( locationList.get(index).getName() )
				.icon( BitmapDescriptorFactory.fromBitmap(bitmap) ) ;
			
    		Marker marker = mMap.addMarker( markerOptions);
    		markers.add(marker);
    		
    	}
        
        
    	LatLngBounds.Builder builder = new LatLngBounds.Builder();
    	for (Marker marker : markers ) {
    	    builder.include(marker.getPosition());
    	}
    	LatLngBounds bounds = builder.build();
    	
    	CameraUpdate cu = CameraUpdateFactory.newLatLngBounds(bounds, 0);
    	
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(locationList.get(0).getPosition() , 5));
    	
//    	mMap.moveCamera(cu);
    	
    }
    

    
}
