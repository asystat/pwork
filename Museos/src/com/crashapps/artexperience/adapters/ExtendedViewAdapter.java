package com.crashapps.artexperience.adapters;

import java.util.Vector;

import android.app.Activity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import com.crashapps.artexperience.customviews.ExtendedView;

public class ExtendedViewAdapter extends BaseAdapter {

	Vector<ExtendedView> views;
	private Activity mContext;
	
	public ExtendedViewAdapter(Activity a) {
		mContext=a;
		views=new Vector<ExtendedView>();	
	}

	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return views.size();
	}

	@Override
	public Object getItem(int position) {
		// TODO Auto-generated method stub
		return views.get(position);
	}

	@Override
	public long getItemId(int position) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		// TODO Auto-generated method stub
		return views.get(position);
	}

	public void addView(ExtendedView v){
		views.add(v);
		updateGui();
	}
	
	public void removeView(ExtendedView v){
		views.remove(v);
		updateGui();
	}
	
	public void removeView(int pos){
		views.remove(pos);
		updateGui();
	}
	
	private void updateGui(){
		mContext.runOnUiThread(new Runnable() {
			
			@Override
			public void run() {
				ExtendedViewAdapter.this.notifyDataSetChanged();
			}
		});
	}
	
}
