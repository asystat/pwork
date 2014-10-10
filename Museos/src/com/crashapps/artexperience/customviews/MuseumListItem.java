package com.crashapps.artexperience.customviews;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ImageView;
import android.widget.TextView;

import com.crashapps.artexperience.R;
import com.crashapps.artexperience.model.MuseumItem;

public class MuseumListItem extends ExtendedView{

	ImageView title_icon;
	TextView title, content;
	MuseumItem model;
	
	public MuseumListItem(Context context, AttributeSet attrs,
			int defStyleAttr) {
		super(context, attrs, defStyleAttr);
		init();
	}
	
	public MuseumListItem(Context context, AttributeSet attrs) {
		super(context, attrs);
		init();
	}
	
	public MuseumListItem(Context context) {
		super(context);
		init();
	}
	
	private void init(){
		inflate(getContext(), R.layout.item_museum, this);
	}
	
	public void setModel(MuseumItem i){
		model=i;	
		//update data
	}
	
	
}
