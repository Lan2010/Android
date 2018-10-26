package com.test;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.TextView;

public class SendActivity extends Activity {
	private WebView webView;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_send);
		//1.获取传递过来的Intent
		Intent intent = getIntent();
		//2. 取出数据
		String message =  intent.getStringExtra("MessageKey");
		//3.设置文本框内容
		TextView tv_info = (TextView) super.findViewById(R.id.tv_info);
		tv_info.setText(message);
		
		//WebView的使用
		webView = (WebView) super.findViewById(R.id.webView1);
		//1.设置浏览器的属性，支撑js脚本
		webView.getSettings().setJavaScriptEnabled(true);
		//2.当需要从一个网页跳转到另一个网页时，我们希望还在当前的app内显示，而不是系统的浏览器里。
		webView.setWebViewClient(new WebViewClient());
		//3.加载网页url
		webView.loadUrl("http://www.baidu.com");
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.send, menu);
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
}
