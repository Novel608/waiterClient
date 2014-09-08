package com.jiaqiang.waiterclient;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.waiterclient.R;

public class ModifyPasswordActivity extends Activity {
	private TextView nameText;
	private EditText oldEdit;
	private EditText newEdit;
	private EditText newEdit2;
	private Button confirmBtn;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.modify_password);
		init();
	}

	private void init() {
		nameText = (TextView) findViewById(R.id.login_name_tv);
		oldEdit = (EditText) findViewById(R.id.modify_old_password);
		newEdit = (EditText) findViewById(R.id.modify_new_password);
		newEdit2 = (EditText) findViewById(R.id.modify_new_password2);
		confirmBtn = (Button) findViewById(R.id.modify_save);
		Intent intent = getIntent();
		nameText.setText(intent.getStringExtra("loginName"));
		confirmBtn.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {

			}
		});
	}
}
