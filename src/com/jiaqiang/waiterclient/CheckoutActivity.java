package com.jiaqiang.waiterclient;

import java.util.ArrayList;
import java.util.List;

import com.example.waiterclient.R;
import com.jiaqiang.waiterclient.entity.SerialNum;

import android.app.Activity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.RadioButton;
import android.widget.TextView;

public class CheckoutActivity extends Activity {

	private ListView checkout_list;
	private TextView tv_checkout_date;
	private TextView tv_checkout_tableNum;

	private LayoutInflater layoutInflater;

	List<SerialNum> serialNumList = new ArrayList<SerialNum>();

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.checkout);

		/*
		 * 测试静态页面所使用数据
		 */
		SerialNum serialNum = new SerialNum();
		serialNum.setSerialNum("20140909172300001234");
		serialNum.setState(false);
		serialNumList.add(serialNum);
		init();
	}

	private void init() {
		layoutInflater = getLayoutInflater();
		tv_checkout_date = (TextView) findViewById(R.id.tv_checkout_date);
		tv_checkout_tableNum = (TextView) findViewById(R.id.tv_checkout_tableNum);
		checkout_list = (ListView) findViewById(R.id.list_checkout);
		checkout_list.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> parent, View view,
					int position, long id) {

			}
		});
		checkout_list.setAdapter(new CheckoutAdapater());
	}

	class CheckoutAdapater extends BaseAdapter {
		COViewHolder viewholder;

		@Override
		public int getCount() {
			return serialNumList.size();
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

			if (convertView == null) {
				convertView = layoutInflater.inflate(R.layout.checkout_item,
						null);
				viewholder = new COViewHolder();
				viewholder.tv_serialNum = (TextView) convertView
						.findViewById(R.id.tv_checkout_item);
				viewholder.btn_state = (RadioButton) convertView
						.findViewById(R.id.rbtn_checkout_item);
				convertView.setTag(viewholder);
			} else {
				viewholder = (COViewHolder) convertView.getTag();
			}
			viewholder.tv_serialNum.setText(serialNumList.get(position)
					.getSerialNum());
			viewholder.btn_state.setChecked(serialNumList.get(position)
					.getState());
			return convertView;
		}

	}

	class COViewHolder {
		TextView tv_serialNum;
		RadioButton btn_state;
	}
}
