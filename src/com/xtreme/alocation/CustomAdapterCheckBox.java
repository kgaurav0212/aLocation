package com.xtreme.alocation;

import java.util.ArrayList;

import com.example.alocation.R;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;



public class CustomAdapterCheckBox extends BaseAdapter {


	private LayoutInflater mInflater;
	ArrayList<Integer> selectedIds = new ArrayList<Integer>();
	ArrayList<LocData> locationData;

	public CustomAdapterCheckBox(Context c, ArrayList<LocData> locationData1) {
		mInflater = (LayoutInflater)  c.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
		locationData = locationData1;
	}

	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return locationData.size();
	}

	@Override
	public Object getItem(int arg0) {
		// TODO Auto-generated method stub
		return locationData.get(arg0);
	}

	@Override
	public long getItemId(int arg0) {
		// TODO Auto-generated method stub
		return arg0;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		// TODO Auto-generated method stub
		if (convertView == null) {
			convertView = mInflater.inflate(R.layout.check_box_view, null);
		}

		CheckBox check1 = (CheckBox) convertView.findViewById(R.id.checkBox1);

		//check1.setText(locationData.get(position).getName());
		//check1.setId(locationData.get(position).getId());


		final int index = position;
		check1.setOnCheckedChangeListener(new OnCheckedChangeListener() {

			@Override
			public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
				if (isChecked) {
					selectedIds.add( index );
				}else{
					selectedIds.remove(  selectedIds.lastIndexOf( index ) );
				}

			}

		});

		return convertView;
	}

	public ArrayList<Integer> getSelectedIds(){
		return selectedIds;
	}


}