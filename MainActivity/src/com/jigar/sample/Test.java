package com.jigar.sample;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

interface OnCustomEventListener {
	public void callback(String result, String result1); // method, which can
															// have parameters
}

public class Test extends Activity implements OnCustomEventListener {

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.news_articles);

		MyButton m = new MyButton(new OnCustomEventListener() {

			@Override
			public void callback(String result, String result1) {
				// TODO Auto-generated method stub
				Toast.makeText(getApplicationContext(), "result :" + result, Toast.LENGTH_SHORT).show();
				Toast.makeText(getApplicationContext(), "result :" + result, Toast.LENGTH_LONG).show();
			}

		});
		m.MyLogicToIntimateOthere();
	}

	@Override
	public void callback(String result, String result1) {
		Toast.makeText(getApplicationContext(), "result1 :" + result, Toast.LENGTH_SHORT).show();
		Toast.makeText(getApplicationContext(), "result :" + result, Toast.LENGTH_LONG).show();
	}
}

class MyButton {
	OnCustomEventListener obj1;

	MyButton(OnCustomEventListener obj1) {
		this.obj1 = obj1;
	}

	public void MyLogicToIntimateOthere() {
		obj1.callback("ok", "sucsss");
	}
}
