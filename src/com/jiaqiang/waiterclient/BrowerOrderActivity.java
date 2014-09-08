package com.jiaqiang.waiterclient;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.TextView;

import com.example.waiterclient.R;
import com.jiaqiang.waiterclient.entity.Dishes;

public class BrowerOrderActivity extends Activity {

	private LayoutInflater inflater;
	private TextView tv_order_no;// 流水号
	private Button btn_back;
	private ImageButton btn_confirm;
	private ListView list;

	private List<Dishes> dishesList = new ArrayList<Dishes>();

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.brower_order);
		init();

	}

	private void init() {
		Intent intent = getIntent();
		list = (ListView) findViewById(R.id.list_brower_order);
		inflater = getLayoutInflater();
		tv_order_no = (TextView) findViewById(R.id.tv_brower_order_No);
		btn_back = (Button) findViewById(R.id.btn_brower_order_back);
		btn_confirm = (ImageButton) findViewById(R.id.btn_brower_order_confirm);
		btn_back.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				BrowerOrderActivity.this.finish();
			}
		});

		btn_confirm.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {

			}
		});
		tv_order_no.setText(getSerialNum());
	}

	/**
	 * 获取流水号
	 * 
	 * @return
	 */
	private String getSerialNum() {
		SimpleDateFormat formate = new SimpleDateFormat("yyyyMMddHHmmss");
		String str = formate.format(new Date());
		str += "0000";
		return str;
	}

	class BOListAdapater extends BaseAdapter {

		BOViewHolder viewHolder;

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
			if (convertView == null) {
				viewHolder = new BOViewHolder();
				convertView = inflater.inflate(R.layout.brower_order_list_item,
						null);
				viewHolder.btn_delete = (Button) convertView
						.findViewById(R.id.btn_brower_order_delete);
				viewHolder.btn_remark = (Button) convertView
						.findViewById(R.id.btn_brower_order_note);
				viewHolder.tv_category = (TextView) convertView
						.findViewById(R.id.tv_brower_order_category);
				viewHolder.tv_name = (TextView) convertView
						.findViewById(R.id.tv_brower_order_name);
				viewHolder.tv_no = (TextView) convertView
						.findViewById(R.id.tv_brower_order_no);
				viewHolder.tv_num = (TextView) convertView
						.findViewById(R.id.tv_brower_order_num);
				viewHolder.tv_price = (TextView) convertView
						.findViewById(R.id.tv_brower_order_prices);
				viewHolder.tv_unitPrice = (TextView) convertView
						.findViewById(R.id.tv_brower_order_unitPrice);
				convertView.setTag(viewHolder);
			} else {
				viewHolder = (BOViewHolder) convertView.getTag();
			}

			return convertView;
		}

	}

	class BOViewHolder {
		TextView tv_no;
		TextView tv_name;
		TextView tv_unitPrice;
		TextView tv_price;
		TextView tv_num;
		Button btn_remark;
		Button btn_delete;
		TextView tv_category;
	}
}
