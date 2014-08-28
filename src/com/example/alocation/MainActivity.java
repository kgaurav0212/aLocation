package com.example.alocation;

import java.util.ArrayList;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.ListView;
import android.widget.Toast;

public class MainActivity extends Activity implements OnClickListener {

	private static final String COORD1 = null;

	ListView myList;
	private CustomAdapterCheckBox mAdapter;
	private ArrayList<LocData> locationData;

	public static ArrayList<Integer> selectedIds;

	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		myList = null;
		myList = (ListView) findViewById(R.id.list_checkBox);

		CreateLocData.generateData(); // to create arraylist of locations
		locationData = CreateLocData.getLocationData(); // to extract data from
														// class to arraylist

		mAdapter = new CustomAdapterCheckBox(MainActivity.this, locationData);
		myList.setAdapter(mAdapter);

		Button b1 = (Button) findViewById(R.id.button1);
		b1.setOnClickListener(this);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}

	@Override
	public void onClick(View arg0) {
		// TODO Auto-generated method stub

		Intent i = new Intent(this, BasicMapDemoActivity.class);

		// if( true )
		// {
		// CharSequence text="lokesh";
		// Toast toast = Toast.makeText( getApplicationContext(), text,
		// Toast.LENGTH_SHORT);
		// toast.show();
		//
		// i.putExtra(COORD1,text );
		// }

		selectedIds = mAdapter.getSelectedIds();
		Toast toast = Toast.makeText(getApplicationContext(),
				selectedIds.toString(), Toast.LENGTH_SHORT);
		toast.show();

		System.out.println("success!!!");

		startActivity(i);

	}

}
