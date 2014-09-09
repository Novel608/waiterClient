package com.jiaqiang.waiterclient;

import com.example.waiterclient.R;

import android.os.Bundle;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;

public class LoginActivity extends Activity implements OnClickListener {

	private EditText login_name;
	private EditText password_edit;
	private Button loginBtn;
	private CheckBox rememberPassword;

	private boolean isFirstLogin = true;
	private String name;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_login);
		init();
	}

	/**
	 * 
	 */
	private void init() {

		login_name = (EditText) findViewById(R.id.login_name);
		password_edit = (EditText) findViewById(R.id.login_password);
		rememberPassword = (CheckBox) findViewById(R.id.login_check);
		loginBtn = (Button) findViewById(R.id.btn_login);
		loginBtn.setOnClickListener(this);
		SharedPreferences preferences = getSharedPreferences("login",
				Context.MODE_PRIVATE);
		if (preferences != null) {
			name = preferences.getString("loginName", "");
			login_name.setText(name);
			if (name != null || !name.equals(""))
				isFirstLogin = false;
			password_edit.setText(preferences.getString("password", ""));
		}

	}

	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.btn_login:
			saveLoginMessage();
			if (isFirstLogin) {
				Intent intent = new Intent(LoginActivity.this,
						ModifyPasswordActivity.class);
				intent.putExtra("loginName", name);
				startActivity(intent);
			} else {
				Intent intent = new Intent(LoginActivity.this,
						MainMenuActivity.class);
				startActivity(intent);
			}
			LoginActivity.this.finish();
			break;

		default:
			break;
		}
	}

	/**
	 * 保存用户名和密码
	 */
	private void saveLoginMessage() {
		SharedPreferences preference = getSharedPreferences("login",
				Context.MODE_PRIVATE);
		Editor editor = preference.edit();
		editor.putString("loginName", login_name.getText().toString());
		if (rememberPassword.isChecked())
			editor.putString("password", password_edit.getText().toString());
		else
			editor.putString("password", "");
		editor.commit();
	}

}
