package com.cn.weihai;


import java.util.ArrayList;
import java.util.HashMap;

import com.cn.weihai.Adapter.MessageAdapter;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.Button;
import android.widget.ListView;

public class Message extends Activity {
	Button bu4;
	Button bu5;
	Button bu6;
	Button bu7;
	Button bu8;
	Button  bu;
	ArrayList< HashMap<String, String>> mylist;
	ListView list_lianxi;
	@Override	
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.message);
		 //�ѱ���activity��ӵ�exit_app����addActivity��������
        Exit_app.getInstance().addActivity(Message.this);
        list_lianxi=(ListView) findViewById(R.id.messagelist);
    	mylist=new ArrayList<HashMap<String,String>>();
    	MessageAdapter adapter=new  MessageAdapter(mylist,this);
    	
    	HashMap<String, String> hashmap01 = new HashMap<String, String>();
    	hashmap01.put("list_text", "�ͻ������ƣ�����ӡˢ��");
    	HashMap<String, String> hashmap02 = new HashMap<String, String>();
    	hashmap02.put("list_text", "�ͻ������ޣ� 3��");
    	HashMap<String, String> hashmap03 = new HashMap<String, String>();
    	hashmap03.put("list_text", "�ͻ��˰汾��WHTGW1.0.");
    	HashMap<String, String> hashmap04 = new HashMap<String, String>();
    	hashmap04.put("list_text", "�����ߣ���������ٯ��Ϣ������" +"\n"
    			+"�޹�˾");
    	mylist.add(hashmap01);
    	mylist.add(hashmap02);
    	mylist.add(hashmap03);
    	mylist.add(hashmap04);
    	list_lianxi.setAdapter(adapter);
		 bu4=(Button) findViewById(R.id.bt1);
		  bu5=(Button) findViewById(R.id.bt2);
		  bu6=(Button) findViewById(R.id.bt3);
		  bu7=(Button) findViewById(R.id.bt4);
		  bu8=(Button) findViewById(R.id.bt5);
		  bu=(Button) findViewById(R.id.gengduo);
		  bu.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
			Intent in=new Intent(Message.this, More.class);
			in.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP); 
			startActivity(in);
			}
		});
	}
	   public void danjigengduo(View v){
		   Intent in;
		   switch (v.getId()) {
		   case R.id.bt1:
				in=new Intent(Message.this,WeiHaiActivity.class ); 
				startActivity(in);
				break;
			case R.id.bt2:
				in=new Intent(Message.this,Introduce.class );
				startActivity(in);
				break;
			case R.id.bt3:
				in=new Intent(Message.this,Online.class );
				startActivity(in);
				break;
			case R.id.bt4:
				in=new Intent(Message.this,Phone.class ); 
				startActivity(in);
				break;
			case R.id.bt5:
				in=new Intent(Message.this,More.class );
				startActivity(in);
				break;
		}
	   }
}


