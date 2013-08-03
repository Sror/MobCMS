package com.cn.weihai;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

public class Intent5 extends Activity {
	TextView  tv;
	Button fanhui;
    Button zixun;
 @Override
protected void onCreate(Bundle savedInstanceState) {
	// TODO Auto-generated method stub
	super.onCreate(savedInstanceState);
	requestWindowFeature(Window.FEATURE_NO_TITLE);
	setContentView(R.layout.intent5);
	tv=(TextView) findViewById(R.id.text1);
    zixun=(Button) findViewById(R.id.fufanzixun);
    zixun.setOnClickListener(new OnClickListener() {
		
		@Override
		public void onClick(View v) {
			// TODO Auto-generated method stub
			Uri  uri=Uri.parse("smsto:18912294545");
			Intent  intent=new Intent(Intent.ACTION_SENDTO,uri);
			intent.putExtra("sms_body", "THE.SMS  text");
			startActivity(intent);
		}
	});
    //�ѱ���activity��ӵ�exit_app����addActivity��������
    Exit_app.getInstance().addActivity(Intent5.this);
    tv.setText("\t"+"\t"+"\t"+"���ɽ�����ͬ��ͳ�ı������,"+"\n"
   		        +"\t"+" ���в���ˢ�������ý���������պˮ��" +"\n"
   		        +"\t"+"����Ⱦ����ʡ����ʱ����ŵ�, Ӧ��" +"\n"
   		        +"\t"+"��Χ��, �����ݡ����಻�ɽ�����" +"\n"
   		        +"\t"+"����Ӧ����һ��ֽ�ű���������ʤ��" +"\n"
   		        +"\t"+"�Ĳ�����, ��������˵, ���ɽ�������" +"\n"
   		        +"\t"+"һ�����ܵı���, ���ɽ�����ͨ���ڱ�" +"\n"
   		        +"\t"+"����������ӡˢ�ӹ�, �๤��һ�����," +"\n"
   		        +"\t"+" ��ͼ��ӡˢ��ģ�С��ŷϡ����ź͸�" +"\n"
   		        +"\t"+"���");
    fanhui=(Button) findViewById(R.id.fufan1);
    fanhui.setOnClickListener(new OnClickListener() {
		
		@Override
		public void onClick(View v) {
			// TODO Auto-generated method stub
			Intent in=new Intent(Intent5.this, WeiHaiActivity.class);
			startActivity(in);
		}
	});
}
public void danjijianjie(View v){
		Intent in;
		switch (v.getId()) {
		case R.id.bt2:
			in=new Intent(Intent5.this, Introduce.class);
			startActivity(in);
			break;
		case R.id.bt3:
			in=new Intent(Intent5.this, Online.class);
			startActivity(in);
			break;
		case R.id.bt4:
			in=new Intent(Intent5.this, Phone.class);
			startActivity(in);
			break;
		case R.id.bt5:
			in=new Intent(Intent5.this, More.class);
			startActivity(in);
			break;

		}
   }
}
