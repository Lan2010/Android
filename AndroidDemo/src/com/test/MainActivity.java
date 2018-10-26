package com.test;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends Activity {
	private EditText tvUserName = null;
	private EditText tvPassWord = null;
	private Button btnLogin = null;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		tvUserName = (EditText) super.findViewById(R.id.username);
		tvPassWord = (EditText) super.findViewById(R.id.password);
		btnLogin = (Button) super.findViewById(R.id.login);
		btnLogin.setOnClickListener(new LoginOnClickListener());
	}
	
	private class LoginOnClickListener implements OnClickListener{

		@Override
		public void onClick(View v) {
			String username = tvUserName.getText().toString();
			String password = tvPassWord.getText().toString();
			String info = "用户名："+ username +"----密码："+password;
			Toast.makeText(getApplicationContext(), info, Toast.LENGTH_SHORT).show();
		}
		
	}
	
	public void sendMessage(View v) {
		//弹框
		Toast.makeText(this, getString(R.string.txt_click_send_btn), Toast.LENGTH_SHORT).show();
		//1. 定义要跳转页的意图
		Intent intent = new Intent(this,SendActivity.class);
		//2. 获取文本域对象
		EditText edit_message = (EditText) super.findViewById(R.id.edit_message);
		//3. 获取文本域输入的内容
		String message = edit_message.getText().toString();
		//4. 内容封装进intent，传递到下一个页面
		intent.putExtra("MessageKey", message);
		startActivity(intent);
	}
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}
	
	@Override
	public void onPause() {
		//部分可见
		super.onPause();
		System.out.println("-----onPause-----");
	}
	
	@Override
	public void onStop() {
		//完全不可见
		super.onStop();
		System.out.println("-----onStop-----");
	}
}
