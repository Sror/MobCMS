package com.cn.jiafangtuangou;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.Button;
import android.widget.TextView;

public class Intent1 extends Activity {
	TextView  tv;
	Button fanhui;
	 Button zixun;
 @Override
protected void onCreate(Bundle savedInstanceState) {
	// TODO Auto-generated method stub
	 requestWindowFeature(Window.FEATURE_NO_TITLE);//ȥ��������
	super.onCreate(savedInstanceState);
     setContentView(R.layout.f2);
     //�ѱ���activity��ӵ�exit_app����addActivity��������
     Exit_app.getInstance().addActivity(Intent1.this);
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
     tv=(TextView) findViewById(R.id.text2);
     tv.setText("\t"+"��ɫ"+"\n"
    		        +"\t"+"��հ���Զ����" +"\n"
    		        +"\t"+"���Ʋ�Ⱦ" +"\n"
    		        +"\t"+"һ���޼ʵ���Ļ" +"\n"
    		        +"\t"+"�����������ɵķ���" +"\n");
fanhui=(Button) findViewById(R.id.fufan2);
fanhui.setOnClickListener(new OnClickListener() {

@Override
public void onClick(View v) {
	// TODO Auto-generated method stub
	Intent in=new Intent(Intent1.this, JiaFangMainActivity.class);
	startActivity(in);
}
});
 }
 public void danjijianjie(View v){
		Intent in;
		switch (v.getId()) {
		case R.id.bt2:
			in=new Intent(Intent1.this, GongSiJianJie.class);
			startActivity(in);
//			finish();
			break;
		case R.id.bt3:
			in=new Intent(Intent1.this, ZaiXian.class);
			startActivity(in);
//			finish();
			break;
		case R.id.bt4:
			in=new Intent(Intent1.this, LianXiFangShi.class);
			startActivity(in);
//			finish();
			break;
		case R.id.bt5:
			in=new Intent(Intent1.this, Gengduo.class);
			startActivity(in);
//			finish();
			break;
		}
		}
}

