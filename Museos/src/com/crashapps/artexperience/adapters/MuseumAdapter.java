package com.crashapps.artexperience.adapters;

import Utils.TypeFaceProvider;
import android.app.Activity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import com.crashapps.artexperience.R;
import com.crashapps.artexperience.model.MuseumItem;

public class MuseumAdapter extends BaseAdapter {

	private Activity mContext;

	private static MuseumItem item;
	static {
		item = new MuseumItem();
		item.description = "descripcion es esta";

	}

	public MuseumAdapter(Activity a) {
		mContext = a;
	}

	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return 10;
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
		if(convertView==null){
			convertView=mContext.getLayoutInflater().inflate(R.layout.item_museum, null);
			TypeFaceProvider.overrideFonts(mContext, convertView);
		}
		return convertView;
	}

}
