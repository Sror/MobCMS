package com.cn.youer;

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
	tv.setText("\t"+"\t"+"\t"+"Ӥ����Ʒ���С�һ��Ϊ�˺��ӵ�" +"\n"
			 +"\t"+"����, һ��Ϊ�˺��ӵĿ���,һ��Ϊ��"+"\n" 
			+ "\t"+"���ӵĳɳ�������ּ, ���г��ϲ���" +"\n"
			+"\t"+ "���뷢չ,�õ��˹�������ǵ�����" +"\n"
			+"\t"+ "�����������һֱ����ܰ��רҵ��" +"\n"
			+"\t"+"���е�Ӥ������, ʵ������; ��ִ��" +"\n"
			+ "\t"+"�������������ľ���, ���ϴ����" +"\n"
			+ "\t"+	"��;ͬʱ����Ҳ��һ������ڹ�˾" +"\n"
			+ "\t"+"Ʒ�Ƶķ�չ��רע, �����й�����" +"\n"
			+ "\t"+"��ȫ���ͯ���֡������ĳɳ�!");
	fuwu=(Button) findViewById(R.id.fuwu);
}
    Intent in;
   public void danjijianjie(View v){
	   switch (v.getId()) {
	case R.id.bt1:
		in=new Intent(Introduce.this, YouErActivity.class);
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

