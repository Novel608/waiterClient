package com.jiaqiang.waiterclient;

import java.util.Timer;
import java.util.TimerTask;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.Gallery;
import android.widget.ImageView;

import com.example.waiterclient.R;

public class MainMenuActivity extends Activity implements OnClickListener {

	private Button btn_add_oreder;
	private Button btn_more;
	private Button btn_order;
	private Button btn_order_schedule;
	private Button btn_checkout;
	private Gallery mGallery;

	private Timer timer;
	private int index = 0;

	Handler mHandler = new Handler() {
		public void handleMessage(android.os.Message msg) {
			mGallery.setSelection(index);
		};
	};

	private int[] imageId = { R.drawable.gallery1, R.drawable.gallery2,
			R.drawable.gallery3, R.drawable.gallery4, R.drawable.gallery5,
			R.drawable.gallery6 };

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main_menu);
		init();
	}

	private void init() {
		btn_add_oreder = (Button) findViewById(R.id.main_menu_add_order);
		btn_checkout = (Button) findViewById(R.id.main_menu_checkout);
		btn_more = (Button) findViewById(R.id.main_menu_more);
		btn_order = (Button) findViewById(R.id.main_menu_order);
		btn_order_schedule = (Button) findViewById(R.id.main_menu_order_schedule);
		mGallery = (Gallery) findViewById(R.id.main_menu_gallery);
		btn_add_oreder.setOnClickListener(this);
		btn_checkout.setOnClickListener(this);
		btn_more.setOnClickListener(this);
		btn_order.setOnClickListener(this);
		btn_order_schedule.setOnClickListener(this);
		mGallery.setAdapter(new ImageAdapater());
		if (timer == null) {
			timer = new Timer();
		}

		TimerTask timerTask = new TimerTask() {

			@Override
			public void run() {
				mHandler.sendEmptyMessage(0);
				index++;
				if (index == imageId.length) {
					index = 0;
				}
			}
		};
		timer.schedule(timerTask, 0, 2000L);
	}

	@Override
	protected void onDestroy() {
		super.onDestroy();
		timer.cancel();
		timer = null;
		index = 0;
	}

	@Override
	public void onBackPressed() {
		showExitDialog();
	}

	private void showExitDialog() {
		AlertDialog.Builder dialog = new AlertDialog.Builder(
				MainMenuActivity.this);
		dialog.setTitle(getString(R.string.exit));
		dialog.setIcon(getResources().getDrawable(R.drawable.ic_launcher));
		dialog.setMessage(getString(R.string.exit_dialog_message));
		dialog.setPositiveButton(getString(R.string.confirm),
				new DialogInterface.OnClickListener() {

					@Override
					public void onClick(DialogInterface dialog, int which) {
						dialog.dismiss();
						MainMenuActivity.this.finish();
					}
				});
		dialog.setNegativeButton(getString(R.string.cancel),
				new DialogInterface.OnClickListener() {

					@Override
					public void onClick(DialogInterface dialog, int which) {
						dialog.dismiss();
					}
				});
		dialog.create();
		dialog.show();
	}

	@Override
	public void onClick(View v) {
		Intent intent = null;
		switch (v.getId()) {
		case R.id.main_menu_add_order:

			break;
		case R.id.main_menu_checkout:
			intent = new Intent(MainMenuActivity.this, CheckoutActivity.class);
			break;
		case R.id.main_menu_more:

			break;
		case R.id.main_menu_order:
			intent = new Intent(MainMenuActivity.this, OrderActivity.class);
			break;
		case R.id.main_menu_order_schedule:

			break;
		}
		if (intent != null)
			startActivity(intent);
	}

	class ImageAdapater extends BaseAdapter {

		@Override
		public int getCount() {
			return imageId.length;
		}

		@Override
		public Object getItem(int position) {
			return null;
		}

		@Override
		public long getItemId(int position) {
			return 0;
		}

		@Override
		public View getView(int position, View convertView, ViewGroup parent) {
			ImageView iv = new ImageView(MainMenuActivity.this);
			Bitmap bit = BitmapFactory.decodeResource(getResources(),
					imageId[position]);
			bit = Bitmap.createScaledBitmap(bit,
					mGallery.getLayoutParams().width,
					mGallery.getLayoutParams().height, true);
			iv.setBackgroundDrawable(new BitmapDrawable(bit));
			return iv;
		}

	}

}
