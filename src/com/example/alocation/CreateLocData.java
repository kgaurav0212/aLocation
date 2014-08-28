package com.example.alocation;

import java.util.ArrayList;
import java.util.List;

import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class CreateLocData {

	static ArrayList<LocData> arr1;

	public static void generateData() {

		arr1 = new ArrayList<LocData>();
		
		List<NameValuePair> nameValuePairs = new ArrayList<NameValuePair>(1);
		nameValuePairs.add(new BasicNameValuePair("key", Connection.key));
		
		String URL = "index.php";
		
		JSONObject result = Connection.getObject(URL, nameValuePairs);
		
		if (result == null) {
			return;
		}

		JSONArray location;
		
		try {
			location = result.getJSONArray("location");
			for (int i = 0; i < location.length(); i++) {
				JSONObject loadData = location.getJSONObject(i);
				LocData locData = new LocData();
				locData.setId(loadData.getInt("id"));
				locData.setName(loadData.getString("name"));
				locData.setLatLng( loadData.getDouble("lat"), loadData.getDouble("lng"));
				arr1.add(locData);
			}
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static ArrayList<LocData> getLocationData() {
		return arr1;
	}

}
