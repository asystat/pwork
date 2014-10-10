package com.crashapps.artexperience.adapters;

import Utils.TypeFaceProvider;
import android.app.Activity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.crashapps.artexperience.R;

public class DrawerAdapter extends BaseAdapter {

	private Activity mContext;

	TextView item_name;
	ImageView item_icon;

	public DrawerAdapter(Activity a) {
		mContext = a;
	}

	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return 4;
	}

	@Override
	public Object getItem(int position) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public long getItemId(int position) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		// TODO Auto-generated method stub
		if (convertView == null) {
			convertView = mContext.getLayoutInflater().inflate(
					R.layout.item_drawer, null);
			TypeFaceProvider.overrideFonts(mContext, convertView);
		}

		item_name = (TextView) convertView.findViewById(R.id.item_name);
		item_icon = (ImageView) convertView.findViewById(R.id.item_icon);

		configureLayout(position);

		return convertView;
	}

	private void configureLayout(int position) {
		switch (position) {
		case 0:
			item_name.setText(R.string.title_section1);
			item_icon.setImageResource(R.drawable.camera);
			break;
		case 1:
			item_name.setText(R.string.title_section2);
			item_icon.setImageResource(R.drawable.search);
			break;
		case 2:
			item_name.setText(R.string.title_section3);
			item_icon.setImageResource(R.drawable.small);
			break;
		case 3:
			item_name.setText(R.string.title_section4);
			item_icon.setImageResource(R.drawable.ip_museum);
			break;
		}
	}

}
