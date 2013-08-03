package com.cn.youer;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;

import com.cn.youer.Adapter.MyPhoneList;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.view.View;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;

public class Phone extends Activity {
	ArrayList< HashMap<String, String>> mylist;
	ListView list_lianxi;
@Override
protected void onCreate(Bundle savedInstanceState) {
	// TODO Auto-generated method stub
	super.onCreate(savedInstanceState);
	requestWindowFeature(Window.FEATURE_NO_TITLE);
	setContentView(R.layout.phone);
	 //�ѱ���activity��ӵ�exit_app����addActivity��������
    Exit_app.getInstance().addActivity(Phone.this);
	list_lianxi=(ListView) findViewById(R.id.lianxilist);
	mylist=new ArrayList<HashMap<String,String>>();
	MyPhoneList adapter=new  MyPhoneList(mylist,this);
	
	HashMap<String, String> hashmap01 = new HashMap<String, String>();
	hashmap01.put("list_text", "���䣺2319835549@qq.cm");
	HashMap<String, String> hashmap02 = new HashMap<String, String>();
	hashmap02.put("list_text", "��ϵ�ˣ�����");
	HashMap<String, String> hashmap03 = new HashMap<String, String>();
	hashmap03.put("list_text", "��ϵ�绰��13016589648");
	HashMap<String, String> hashmap04 = new HashMap<String, String>();
	hashmap04.put("list_text", "ͨѶ��ַ������ʡ�����н�����·81-1");
	mylist.add(hashmap01);
	mylist.add(hashmap02);
	mylist.add(hashmap03);
	mylist.add(hashmap04);
	list_lianxi.setAdapter(adapter);
	
	list_lianxi.setOnItemClickListener(new OnItemClickListener() {

		@Override
		public void onItemClick(AdapterView<?> parent, View view,
				int position, long id) {
			// TODO Auto-generated method stub
			switch (position) {
			case 0:
				Uri uri = Uri.parse("mailto:2319835549@qq.com");
				Intent in = new Intent(Intent.ACTION_SENDTO,uri);
				in.putExtra(Intent.EXTRA_SUBJECT, "�ʼ�����");
				in.putExtra(Intent.EXTRA_STREAM,Uri.parse("file:///"+Environment.getExternalStorageDirectory()+ File.separator + "����Ŀ¼"));
				Phone.this.startActivity(in);				

				break;
							
			case 2:
				Uri uri_phone = Uri.parse("tel:13016589648");
				Intent intent_phone = new Intent(Intent.ACTION_DIAL, uri_phone);
				startActivity(intent_phone);
				break;
						
			case 3:					
				Intent intent = new Intent("android.intent.action.VIEW",
						android.net.Uri.parse("androidamap://showTraffic?sourceApplication=softname&poiid=BGVIS1&lat=33.61741447695432&lon=119.00129119999997 &level=10&dev=0"));
				intent.setPackage("com.autonavi.minimap");
				startActivity(intent);

				break;
			}
		}
	});
}
  Intent in;
  public void danjilianxi(View v){
	   switch (v.getId()) {
	case R.id.bt1:
		in=new Intent(Phone.this, YouErActivity.class);
		startActivity(in);
		break;
	case R.id.bt2:
		in=new Intent(Phone.this, Introduce.class);
		startActivity(in);
		break;
	case R.id.bt3:
		in=new Intent(Phone.this, Online.class);
		startActivity(in);
		break;
	case R.id.bt5:
		in=new Intent(Phone.this, More.class);
		startActivity(in);
		break;
	   }
	}
}

