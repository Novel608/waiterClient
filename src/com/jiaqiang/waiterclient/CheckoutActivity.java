package com.jiaqiang.waiterclient;

import com.example.waiterclient.R;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;

public class CheckoutActivity extends Activity {

	private ListView checkout_list;
	private TextView tv_checkout_date;
	private TextView tv_checkout_tableNum;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.checkout);
		init();
	}

	private void init() {
		tv_checkout_date = (TextView) findViewById(R.id.tv_checkout_date);
		tv_checkout_tableNum = (TextView) findViewById(R.id.tv_checkout_tableNum);
		checkout_list = (ListView) findViewById(R.id.list_checkout);
	}

	class CheckoutAdapater extends BaseAdapter {

		@Override
		public int getCount() {
			return 0;
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
			return null;
		}

	}
}
