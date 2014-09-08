package com.jiaqiang.waiterclient;

import android.app.Activity;
import android.content.Intent;
import android.database.DataSetObserver;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.BaseExpandableListAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ExpandableListAdapter;
import android.widget.ExpandableListView;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;

import com.example.waiterclient.R;

public class OrderActivity extends Activity {

	private Spinner spnr_tableNum;//桌号所对应的spinner
	private Spinner spnr_dishesclass;//菜类所对应到额spinner
	private ExpandableListView dishes_list;//可扩展Listview
	private ImageView dishes_iv;
	private TextView tv_dishes_name;
	private TextView tv_dishes_price;
	private Button btn_order;

	private LayoutInflater layoutInflate;

	private String[] groupStringArray;
	private String[][] childStringArray = new String[6][];
	private int[] childStringArrayId = { R.array.dishes_main_classes,
			R.array.dishes_cold_classes, R.array.dishes_soup_classes,
			R.array.dishes_hot_classes, R.array.dishes_classes,
			R.array.dishes_drink_classes };

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.order_menu);
		init();
	}

	private void init() {
		/*
		 * 获取相应的字符串数据的值
		 */
		groupStringArray = getResources().getStringArray(
				R.array.dishes_classes_array);
		for (int i = 0; i < groupStringArray.length; i++) {
			childStringArray[i] = getResources().getStringArray(
					childStringArrayId[i]);
		}
		layoutInflate = getLayoutInflater();
		spnr_dishesclass = (Spinner) findViewById(R.id.order_spinner_dishclasses);
		spnr_tableNum = (Spinner) findViewById(R.id.order_spinner_table_num);
		tv_dishes_name = (TextView) findViewById(R.id.order_dishes_name);
		tv_dishes_price = (TextView) findViewById(R.id.order_dishes_price);
		dishes_iv = (ImageView) findViewById(R.id.order_dishes_iv);
		dishes_list = (ExpandableListView) findViewById(R.id.order_dishes_List);
		dishes_list.setGroupIndicator(null);
		dishes_list.setAdapter(new MyExplandListAdapater());

		btn_order = (Button) findViewById(R.id.order_menu_order);
		/*
		 * 点击点菜按钮的时候跳转到订单界面
		 */
		btn_order.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				Intent intent = new Intent(OrderActivity.this,
						BrowerOrderActivity.class);
				startActivity(intent);
			}
		});

		spinneritemSelected();

	}

	/**
	 * 点击spinner的时候相应的ItemSelectedListener
	 */
	private void spinneritemSelected() {
		/*
		 * 菜类所对应的itemselectedlistener
		 */
		spnr_dishesclass
				.setOnItemSelectedListener(new OnItemSelectedListener() {

					@Override
					public void onItemSelected(AdapterView<?> parent,
							View view, int position, long id) {

					}

					@Override
					public void onNothingSelected(AdapterView<?> parent) {

					}
				});
		/*
		 * 点击桌号的时候，相应的点击事件
		 */
		spnr_tableNum.setOnItemSelectedListener(new OnItemSelectedListener() {

			@Override
			public void onItemSelected(AdapterView<?> parent, View view,
					int position, long id) {

			}

			@Override
			public void onNothingSelected(AdapterView<?> parent) {

			}
		});

	}

	/**
	 * 可扩展适配器
	 * 
	 * @author Novel
	 * 
	 */
	class MyExplandListAdapater extends BaseExpandableListAdapter {

		@Override
		public int getGroupCount() {
			return groupStringArray.length;
		}

		@Override
		public int getChildrenCount(int groupPosition) {
			return childStringArray[groupPosition].length;
		}

		@Override
		public View getGroupView(int groupPosition, boolean isExpanded,
				View convertView, ViewGroup parent) {
			TextView tv = new TextView(OrderActivity.this);
			tv.setText(groupStringArray[groupPosition]);
			return tv;
		}

		@Override
		public View getChildView(int groupPosition, int childPosition,
				boolean isLastChild, View convertView, ViewGroup parent) {
			convertView = layoutInflate.inflate(
					R.layout.order_dishes_list_item, null);
			TextView tv = (TextView) convertView
					.findViewById(R.id.dishes_list_tv);
			CheckBox cb = (CheckBox) convertView
					.findViewById(R.id.dishes_list_checkbox);
			tv.setText(childStringArray[groupPosition][childPosition]);
			return convertView;
		}

		@Override
		public Object getGroup(int groupPosition) {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public Object getChild(int groupPosition, int childPosition) {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public long getGroupId(int groupPosition) {
			// TODO Auto-generated method stub
			return 0;
		}

		@Override
		public long getChildId(int groupPosition, int childPosition) {
			// TODO Auto-generated method stub
			return 0;
		}

		@Override
		public boolean hasStableIds() {
			// TODO Auto-generated method stub
			return false;
		}

		@Override
		public boolean isChildSelectable(int groupPosition, int childPosition) {
			// TODO Auto-generated method stub
			return false;
		}

	}

	class ViewHolder {
		TextView tv;
		CheckBox cb;
	}
}
