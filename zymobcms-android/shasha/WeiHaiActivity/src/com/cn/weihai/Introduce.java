package com.cn.weihai;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.TextView;

public class Introduce extends Activity {
	TextView  tv;
	Button fuwu;
 @Override
protected void onCreate(Bundle savedInstanceState) {
	// TODO Auto-generated method stub
	super.onCreate(savedInstanceState);
	requestWindowFeature(Window.FEATURE_NO_TITLE);
	setContentView(R.layout.introduce);
	//�ѱ���activity��ӵ�exit_app����addActivity��������
    Exit_app.getInstance().addActivity(Introduce.this);
	tv=(TextView) findViewById(R.id.text);
	tv.setText("\t"+"\t"+"\t"+"��˾���������ӡ����ɫ��װ��" +"\n"
			 +"\t"+"������ӡˢΪ���Ĳ�ӡ��ҵ,  ��Ҫ��"+"\n" 
			+ "\t"+"�¸ߵ���ɫ��װ����ҵ���ᡢ������" +"\n"
			+"\t"+ "�鿯��ҵ�񡣹�˾�ԡ��������ޡ���" +"\n"
			+"\t"+ "����Զ���ľ�Ӫ����, ����Ϊ�ͻ��ṩ" +"\n"
			+"\t"+"��Ʒ��̬��, ���ʸ�Ч��Ϊ�ͻ�����, " +"\n"
			+ "\t"+"�ܵ��˿ͻ���һ���Ͽɺ͹㷺����," +"\n"
			+ "\t"+	" ��������γ���һ�������ȶ��Ŀͻ�" +"\n"
			+ "\t"+"Ⱥ��, ����ͻ���300��ҡ�" );
	fuwu=(Button) findViewById(R.id.fuwu);
}
    Intent in;
   public void danjijianjie(View v){
	   switch (v.getId()) {
	case R.id.bt1:
		in=new Intent(Introduce.this, WeiHaiActivity.class);
		startActivity(in);
		break;
	case R.id.bt3:
		in=new Intent(Introduce.this,Online.class);
		startActivity(in);
		break;
	case R.id.bt4:
		in=new Intent(Introduce.this, Phone.class); 
		startActivity(in);
		break;
	case R.id.bt5:
		in=new Intent(Introduce.this, More.class);
		startActivity(in);
		break;
	}
   }
}

