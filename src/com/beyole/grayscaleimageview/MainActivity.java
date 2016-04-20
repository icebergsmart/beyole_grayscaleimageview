package com.beyole.grayscaleimageview;

import android.app.Activity;
import android.os.Bundle;

import com.beyole.view.GrayScaleImageView;

public class MainActivity extends Activity {

	private GrayScaleImageView imageView;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		//imageView = (GrayScaleImageView) findViewById(R.id.img1);
		//imageView.setImageUrl("https://ss0.bdstatic.com/94oJfD_bAAcT8t7mm9GUKT-xh_/timg?image&quality=100&size=b4000_4000&sec=1461129468&di=07dab3112befff0b84bd7c5933ff5523&src=http://img5.duitang.com/uploads/item/201411/08/20141108162654_xthYT.jpeg");
	}

}
