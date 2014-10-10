package com.crashapps.artexperience.customviews;

import com.crashapps.artexperience.R;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class ButtonIconText extends ExtendedView{

	private ImageView icon;
	private TextView text;

	public ButtonIconText(Context context, AttributeSet attrs, int defStyle) {
		super(context, attrs, defStyle);
		init();
	}
	
	public ButtonIconText(Context context, AttributeSet attrs) {
		super(context, attrs);
		init();
	}
	
	public ButtonIconText(Context context) {
		super(context);
		init();
	}
	
	private void init(){
		inflate(getContext(), R.layout.button_icon_text, this);
        icon = (ImageView)findViewById(R.id.icon);
        text = (TextView)findViewById(R.id.text);
	}

	public void setIcon(int i){
		icon.setImageResource(i);
	}
	
	public void setText(String t){
		text.setText(t);
	}
	
}
