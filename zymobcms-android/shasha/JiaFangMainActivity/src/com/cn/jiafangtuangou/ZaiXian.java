package com.cn.jiafangtuangou;

import android.app.Activity;
import android.os.Bundle;
import android.view.Window;
import android.webkit.WebView;

public class ZaiXian extends Activity {
	 @Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);//ȥ��������
		setContentView(R.layout.zaixianneirong);
		 //�ѱ���activity��ӵ�exit_app����addActivity��������
	    Exit_app.getInstance().addActivity(ZaiXian.this);
		WebView web = (WebView) findViewById(R.id.web);
		web.loadUrl("http://www.dapu.com/");
	}
	}