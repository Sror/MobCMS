package com.cn.weihai;

import android.app.Activity;
import android.os.Bundle;
import android.view.Window;
import android.webkit.WebView;

public class ViewPager2 extends Activity {
  @Override
protected void onCreate(Bundle savedInstanceState) {
	// TODO Auto-generated method stub
	super.onCreate(savedInstanceState);
	requestWindowFeature(Window.FEATURE_NO_TITLE);
	setContentView(R.layout.viewpager2);
	 //�ѱ���activity��ӵ�exit_app����addActivity��������
	Exit_app.getInstance().addActivity(ViewPager2.this);
	WebView  web=(WebView) findViewById(R.id.web);
	web.loadUrl("http://www.xyprint.net/show.asp?classid=229");
}
}
