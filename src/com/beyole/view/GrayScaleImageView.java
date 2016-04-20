package com.beyole.view;

import android.content.Context;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;

public class GrayScaleImageView extends ImageView {

	// 图片地址
	private String url;
	// 是否依附在window上
	private boolean isAttachWindow = false;

	public GrayScaleImageView(Context context) {
		super(context);
	}

	public GrayScaleImageView(Context context, AttributeSet attrs) {
		super(context, attrs);
	}

	public GrayScaleImageView(Context context, AttributeSet attrs, int defStyle) {
		super(context, attrs, defStyle);
	}

	@Override
	public boolean onTouchEvent(MotionEvent event) {
		Drawable drawable = getDrawable();
		switch (event.getAction()) {
		case MotionEvent.ACTION_DOWN:
			if (drawable != null) {
				// drawable.mutate使得此drawable共享状态，改变时全部改变
				drawable.mutate().setColorFilter(Color.GRAY, PorterDuff.Mode.MULTIPLY);
			}
			break;
		case MotionEvent.ACTION_MOVE:
			break;
		case MotionEvent.ACTION_CANCEL:
		case MotionEvent.ACTION_UP:
			if (drawable != null) {
				drawable.mutate().clearColorFilter();
			}
			break;
		}
		return true;
		// return super.onTouchEvent(event);
	}

	@Override
	protected void onAttachedToWindow() {
		isAttachWindow = true;
		if (!TextUtils.isEmpty(url)) {
			if (isAttachWindow) {
				Picasso.with(getContext()).load(url).placeholder(new ColorDrawable(Color.parseColor("#f5f5f5"))).into(this);
			}
		}
		super.onAttachedToWindow();
	}

	@Override
	protected void onDetachedFromWindow() {
		Picasso.with(getContext()).cancelRequest(this);
		isAttachWindow = false;
		setImageBitmap(null);
		super.onDetachedFromWindow();
	}

	public void setImageUrl(String url) {
		if (!TextUtils.isEmpty(url)) {
			this.url = url;
		}
	}
}
