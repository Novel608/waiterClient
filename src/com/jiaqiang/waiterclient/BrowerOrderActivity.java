package com.jiaqiang.waiterclient;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.EditText;
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
	String serialNum;
	private List<Dishes> dishesList = new ArrayList<Dishes>();

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.brower_order);
		Dishes dishe = new Dishes();
		dishe.setDishesClass("主食");
		dishe.setDishesName("米饭");
		dishe.setDishesUnit("份");
		dishe.setDishesUnitPrice(12);
		dishe.setDishesNum(1);
		dishesList.add(dishe);
		init();

	}

	private void init() {
		Intent intent = getIntent();
		list = (ListView) findViewById(R.id.list_brower_order);
		list.setAdapter(new BOListAdapater(BrowerOrderActivity.this));
		inflater = getLayoutInflater();
		tv_order_no = (TextView) findViewById(R.id.tv_brower_order_No);
		serialNum = getSerialNum();
		tv_order_no.setText(serialNum);
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
				confirmDialog();
			}

		});

	}

	private void confirmDialog() {
		AlertDialog.Builder dialog = new AlertDialog.Builder(
				BrowerOrderActivity.this);
		dialog.setTitle(getResources().getString(R.string.confirm_order_title));
		dialog.setMessage("账号：" + "123\n" + "流水号：" + serialNum);
		dialog.setPositiveButton(getResources().getString(R.string.confirm),
				new DialogInterface.OnClickListener() {

					@Override
					public void onClick(DialogInterface dialog, int which) {

					}
				});
		dialog.setNegativeButton(getResources().getString(R.string.cancel),
				new DialogInterface.OnClickListener() {

					@Override
					public void onClick(DialogInterface dialog, int which) {

					}
				});
		dialog.create();
		dialog.show();
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

	class BOListAdapater extends BaseAdapter implements OnClickListener {

		int position;
		BOViewHolder viewHolder;
		Context context;

		public BOListAdapater(Context context) {
			this.context = context;
		}

		@Override
		public int getCount() {
			return dishesList.size();
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
			this.position = position;
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
				viewHolder.btn_addNum = (Button) convertView
						.findViewById(R.id.btn_brower_order_addNum);
				viewHolder.btn_subNum = (Button) convertView
						.findViewById(R.id.btn_brower_order_subNum);
				convertView.setTag(viewHolder);
			} else {
				viewHolder = (BOViewHolder) convertView.getTag();
			}
			viewHolder.tv_no.setText((position + 1) + "  ");
			viewHolder.tv_category.setText(dishesList.get(position)
					.getDishesClass());
			viewHolder.tv_unitPrice.setText(dishesList.get(position)
					.getDishesUnitPrice() + "");
			viewHolder.tv_num.setText(dishesList.get(position).getDishesNum()
					+ "");
			viewHolder.tv_price.setText((dishesList.get(position)
					.getDishesNum() * dishesList.get(position)
					.getDishesUnitPrice())
					+ "");
			String name = dishesList.get(position).getDishesName();
			if (name.length() < 8) {
				for (int i = name.length(); i < 8; i++) {
					name += " ";
				}
			} else {
				name = name.substring(0, 6) + "……";
			}
			viewHolder.tv_name.setText(name);
			viewHolder.btn_delete.setOnClickListener(this);
			viewHolder.btn_remark.setOnClickListener(this);
			viewHolder.btn_addNum.setOnClickListener(this);
			viewHolder.btn_subNum.setOnClickListener(this);
			return convertView;
		}

		private void remarkDialog() {
			AlertDialog.Builder dialog = new Builder(context);
			dialog.setTitle(getResources().getString(R.string.dishes_remark));
			EditText edit = new EditText(context);
			dialog.setView(edit);
			dialog.setPositiveButton(
					getResources().getString(R.string.confirm),
					new DialogInterface.OnClickListener() {

						@Override
						public void onClick(DialogInterface dialog, int which) {

						}
					});
			dialog.setNegativeButton(getResources().getString(R.string.cancel),
					new DialogInterface.OnClickListener() {

						@Override
						public void onClick(DialogInterface dialog, int which) {

						}
					});
			dialog.create();
			dialog.show();
		}

		private void deleteDialog() {
			AlertDialog.Builder dialog = new Builder(context);
			dialog.setTitle(getResources().getString(R.string.dishes_delete));
			dialog.setMessage(getResources().getString(
					R.string.brower_order_delete_message)
					+ dishesList.get(position).getDishesName() + "?");
			dialog.setPositiveButton(
					getResources().getString(R.string.confirm),
					new DialogInterface.OnClickListener() {

						@Override
						public void onClick(DialogInterface dialog, int which) {
							dishesList.remove(position);
							notifyDataSetChanged();
						}
					});
			dialog.setNegativeButton(getResources().getString(R.string.cancel),
					new DialogInterface.OnClickListener() {

						@Override
						public void onClick(DialogInterface dialog, int which) {

						}
					});
			dialog.create();
			dialog.show();
		}

		@Override
		public void onClick(View v) {
			int num = dishesList.get(position).getDishesNum();
			switch (v.getId()) {
			case R.id.btn_brower_order_delete:
				deleteDialog();
				break;
			case R.id.btn_brower_order_note:
				remarkDialog();
				break;
			case R.id.btn_brower_order_addNum:
				num += 1;
				dishesList.get(position).setDishesNum(num);
				notifyDataSetChanged();
				break;
			case R.id.btn_brower_order_subNum:
				if (num > 1) {
					num -= 1;
					dishesList.get(position).setDishesNum(num);
					notifyDataSetChanged();
				} else {
					deleteDialog();
				}
				break;
			}
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
		Button btn_addNum;
		Button btn_subNum;
		TextView tv_category;
	}
}
