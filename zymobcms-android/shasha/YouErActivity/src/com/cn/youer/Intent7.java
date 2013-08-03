package com.cn.youer;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

public class Intent7 extends Activity {
	TextView  tv;
	Button fanhui;
    Button zixun;
 @Override
protected void onCreate(Bundle savedInstanceState) {
	// TODO Auto-generated method stub
	super.onCreate(savedInstanceState);
	requestWindowFeature(Window.FEATURE_NO_TITLE);
	setContentView(R.layout.intent7);
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
    Exit_app.getInstance().addActivity(Intent7.this);
    tv.setText("\t"+"�������龫��, ����������̵�3"+"\n"
   		        +"\t"+"�׶�Ƥ������ϵͳ, �����������" +"\n"
   		        +"\t"+"��㻬������;" +"\n"
   		        +"\t"+"��Ȼֲ����, ��Ч����, ������ζ," +"\n"
   		        +"\t"+"ͬʱ�ñ���Զ���ö�, Ƥ�������ķ�" +"\n"
   		        +"\t"+"��;" +"\n"
   		        +"\t"+"ϸ���׻����ʾ��ϸ������������," +"\n"
   		        +"\t"+"��ζ����, ���Զ������������䷽"+"\n"
   		        +"\t"+"������Ч���⼡��ˮ��, ά�ֶ���"+"\n"
                +"\t"+"��Ȼ���ƽ��, �����������ˬ"+"\n"
                +"\t"+"������, ʹ�ñ��а���!");
    fanhui=(Button) findViewById(R.id.fufan1);
    fanhui.setOnClickListener(new OnClickListener() {
		
		@Override
		public void onClick(View v) {
			// TODO Auto-generated method stub
			Intent in=new Intent(Intent7.this, YouErActivity.class);
			startActivity(in);
		}
	});
}
public void danjijianjie(View v){
		Intent in;
		switch (v.getId()) {
		case R.id.bt2:
			in=new Intent(Intent7.this, Introduce.class);
			startActivity(in);
			break;
		case R.id.bt3:
			in=new Intent(Intent7.this, Online.class);
			startActivity(in);
			break;
		case R.id.bt4:
			in=new Intent(Intent7.this, Phone.class);
			startActivity(in);
			break;
		case R.id.bt5:
			in=new Intent(Intent7.this, More.class);
			startActivity(in);
			break;

		}
   }
}
