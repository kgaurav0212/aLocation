package com.example.alocation;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
import org.apache.http.HttpEntity;
import org.apache.http.NameValuePair;
import org.apache.http.ParseException;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;
import org.json.JSONException;
import org.json.JSONObject;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.os.StrictMode;

@SuppressLint("Registered")
public class Connection extends Activity {
	static public String key = null;
	static public String BaseURL = "http://192.168.1.32:8090/alocation/";

	@SuppressLint("NewApi")
	public static JSONObject getObject(String URL, List<NameValuePair> nameValuePairs) {
		
		StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
		StrictMode.setThreadPolicy(policy);

		URL url;
		try {
			url = new URL(BaseURL + URL);
			HttpURLConnection urlConn = (HttpURLConnection) url.openConnection();
			urlConn.connect();
			if (HttpURLConnection.HTTP_OK != urlConn.getResponseCode()) {
				return null;

			}
		} catch (MalformedURLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		HttpClient httpclient = new DefaultHttpClient();
		HttpPost httppost = new HttpPost(BaseURL + URL);
		HttpEntity entity = null;
		String retSrc = null;
		JSONObject result = null;
		
		try {
			httppost.setEntity(new UrlEncodedFormEntity(nameValuePairs));
			entity = httpclient.execute(httppost).getEntity();
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClientProtocolException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		if (entity != null) {
			try {
				retSrc = EntityUtils.toString(entity);
				result = new JSONObject(retSrc);
				return result;
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (JSONException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return null;

	}

}
