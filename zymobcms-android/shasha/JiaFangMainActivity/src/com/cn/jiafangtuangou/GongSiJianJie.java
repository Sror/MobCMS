package com.cn.jiafangtuangou;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.TextView;

public class GongSiJianJie extends Activity {
	TextView  tv;
	Button fuwu;
@Override
protected void onCreate(Bundle savedInstanceState) {
	// TODO Auto-generated method stub
	super.onCreate(savedInstanceState);
	requestWindowFeature(Window.FEATURE_NO_TITLE);//ȥ��������
	setContentView(R.layout.gongsijianjie);
	 //�ѱ���activity��ӵ�exit_app����addActivity��������
    Exit_app.getInstance().addActivity(GongSiJianJie.this);
	tv=(TextView) findViewById(R.id.text);
	tv.setText("\t"+"\t"+"\t"+"�ҷ���ÿ���Ź�һ�Σ�Ϊ������" +"\n"
			 +"\t"+"��ѡ���������ļҷģ�������������"+"\n" 
			+ "\t"+"�����ۿ۵����ʷ��������������" +"\n"
			+"\t"+ "��,�ҷ���ÿ������Ƽ�һ��ʱ�мҷ�" +"\n"
			+"\t"+ "��Ʒ,�ҷ���ͬʱ�������ڰ������ּ�" +"\n"
			+ "\t"+"���������ʣ�����ļҷĲ�Ʒ");
	fuwu=(Button) findViewById(R.id.fuwu);
}
    Intent in;
   public void danjijianjie(View v){
	   switch (v.getId()) {
	case R.id.bt1:
		in=new Intent(GongSiJianJie.this, JiaFangMainActivity.class);
		startActivity(in);
//		finish();
		break;
	case R.id.bt3:
		in=new Intent(GongSiJianJie.this, ZaiXian.class);
		startActivity(in);
//		finish();
		break;
	case R.id.bt4:
		in=new Intent(GongSiJianJie.this, LianXiFangShi.class); 
		startActivity(in);
//		finish();
		break;
	case R.id.bt5:
		in=new Intent(GongSiJianJie.this, Gengduo.class);
		startActivity(in);
//		finish();
		break;
	}
   }
}
