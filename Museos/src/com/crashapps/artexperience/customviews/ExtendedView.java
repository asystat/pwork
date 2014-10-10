package com.crashapps.artexperience.customviews;

import android.content.Context;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.BounceInterpolator;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.OvershootInterpolator;
import android.widget.RelativeLayout;

import com.crashapps.artexperience.R;

public class ExtendedView extends RelativeLayout {

	public static final int SLIDE_FROM_RIGHT = 1;
	public static final int SLIDE_FROM_LEFT = 2;
	public static final int SLIDE_FROM_TOP = 3;
	public static final int SLIDE_FROM_BOTTOM = 4;

	private long startOffset;
	private int animationType = 1;
	boolean startAnimation = true;
	int margin = 20;

	public ExtendedView(Context context, AttributeSet attrs, int defStyle) {
		super(context, attrs, defStyle);
	}

	public ExtendedView(Context context, AttributeSet attrs) {
		super(context, attrs);
	}

	public ExtendedView(Context context) {
		super(context);
	}

	public void enableStartAnimation(boolean enable) {
		startAnimation = enable;
	}

	public void setStartAnimationOffset(long offset) {
		startOffset = offset;
	}

	public void setStartAnimationType(int at) {
		animationType = at;
	}

	
	@Override
	protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
		MarginLayoutParams margins = MarginLayoutParams.class
				.cast(getLayoutParams());
		int dpMargin = toPx(margin);
		margins.topMargin = (int) (dpMargin * 1.5);
		margins.leftMargin = dpMargin;
		margins.rightMargin = dpMargin;
		setLayoutParams(margins);
		super.onMeasure(widthMeasureSpec, heightMeasureSpec);
	}
	
	@Override
	protected void onLayout(boolean changed, int l, int t, int r, int b) {

		super.onLayout(true, l, t, r, b);

		if (startAnimation) {
			Animation anim = createAnimation();
			anim.setInterpolator(new OvershootInterpolator(.9f));
			anim.setStartOffset(startOffset);
			this.startAnimation(anim);
		}
	}

	private Animation createAnimation() {
		switch (animationType) {
		case SLIDE_FROM_RIGHT:
			return AnimationUtils.loadAnimation(getContext(), R.anim.slide_in);
		default:
			return AnimationUtils.loadAnimation(getContext(), R.anim.slide_in);
		}

	}

	/********* listeners ********/

	private OnClickListener listener = null;

	@Override
	public boolean dispatchTouchEvent(MotionEvent event) {
		if (event.getAction() == MotionEvent.ACTION_UP) {
			if (listener != null)
				listener.onClick(this);
		}
		return super.dispatchTouchEvent(event);
	}

	@Override
	public boolean dispatchKeyEvent(KeyEvent event) {
		if (event.getAction() == KeyEvent.ACTION_UP
				&& (event.getKeyCode() == KeyEvent.KEYCODE_DPAD_CENTER || event
						.getKeyCode() == KeyEvent.KEYCODE_ENTER)) {
			if (listener != null)
				listener.onClick(this);
		}
		return super.dispatchKeyEvent(event);
	}

	public void setOnClickListener(OnClickListener listener) {
		this.listener = listener;
	}

	private int toPx(int dp) {
		float density = getContext().getResources().getDisplayMetrics().density;
		return (int) (dp * density);
	}

}
