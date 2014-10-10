package com.crashapps.artexperience.customviews;

import android.content.Context;
import android.util.AttributeSet;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.DecelerateInterpolator;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.crashapps.artexperience.R;

public class TextBoxWithTitle extends ExtendedView{

	ImageView title_icon;
	TextView title, content;
	
	public TextBoxWithTitle(Context context, AttributeSet attrs,
			int defStyleAttr) {
		super(context, attrs, defStyleAttr);
		init();
	}
	
	public TextBoxWithTitle(Context context, AttributeSet attrs) {
		super(context, attrs);
		init();
	}
	
	public TextBoxWithTitle(Context context) {
		super(context);
		init();
	}
	
	private void init(){
		inflate(getContext(), R.layout.text_box_with_title, this);
        title_icon = (ImageView)findViewById(R.id.title_icon);
        title = (TextView)findViewById(R.id.title);
        content = (TextView)findViewById(R.id.content);
	}
	
	public void configure(String s_title, String s_content, int icon_res){
		title_icon.setImageResource(icon_res);
		title.setText(title.toString());
		content.setText(content.toString());
	}
	
	public void setTitle(String t){
		title.setText(t.toString());
	}
	
	public void setContent(String c){
		content.setText(c.toString());
	}
	
	public void setIcon(int i){
		title_icon.setImageResource(i);
	}

}
