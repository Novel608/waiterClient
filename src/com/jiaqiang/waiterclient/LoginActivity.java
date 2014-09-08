package com.jiaqiang.waiterclient;

import java.io.IOException;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;
import org.json.JSONException;
import org.json.JSONObject;

import com.example.waiterclient.R;
import com.jiaqiang.waiterclient.entity.StrictModeUtil;

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
import android.widget.Toast;

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
		StrictModeUtil.getStrictModeUtil();
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
			rememberPassword.setChecked(true);
			password_edit.setText(preferences.getString("password", ""));
		}
	}

	private boolean loginSystem(String userName, String password) {
		HttpClient httpClient = new DefaultHttpClient();
		String urlStr = StrictModeUtil.IPADRESS
				+ "/GourmetOrderServer/loginServlet?name=" + userName + "&paw="
				+ password + "&category=user";
		HttpGet httpGet = new HttpGet(urlStr);
		try {
			HttpResponse httpResponse = httpClient.execute(httpGet);
			if (httpResponse.getStatusLine().getStatusCode() == 200) {
				HttpEntity httpEntity = httpResponse.getEntity();
				String entity = EntityUtils.toString(httpEntity);
				try {
					JSONObject jsonObject = new JSONObject(entity);
					String returnWord = jsonObject.getString("rt");
					if (returnWord.equals("200")) {
						return true;
					}
				} catch (JSONException e) {
					e.printStackTrace();
				}
			}
		} catch (ClientProtocolException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return false;
	}
	
	
	

	private void showToast(String text) {
		Toast.makeText(this, text, Toast.LENGTH_LONG).show();
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
				LoginActivity.this.finish();
			} else {
				if (loginSystem(login_name.getText().toString(), password_edit
						.getText().toString())) {
					showToast("登陆成功");
					Intent intent = new Intent(LoginActivity.this,
							MainMenuActivity.class);
					startActivity(intent);
					LoginActivity.this.finish();
				} else {
					showToast("用户名或密码输入错误！");
				}
			}
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
