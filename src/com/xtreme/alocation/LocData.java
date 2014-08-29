package com.xtreme.alocation;

import com.google.android.gms.maps.model.LatLng;

public class LocData {

		double lat;
		double lng;
		int id;
		String name;
		
		public void setLatLng(double lat, double lng) {
			this.lat = lat;
			this.lng = lng;
		}
		
		public double getLat() {
			return lat;
		}
		
		public double getLng() {
			return lng;
		}
		
		public int getId() {
			return id;
		}
		public void setId(int id) {
			this.id = id;
		}
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		
		
		public LatLng getPosition(){
			return new LatLng(lat, lng);
		}
		
		
}
