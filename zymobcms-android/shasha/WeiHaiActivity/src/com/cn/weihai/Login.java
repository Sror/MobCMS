package com.cn.weihai;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Login extends Activity {
	Button bu4;
	Button bu5;
	Button bu6;
	Button bu7;
	Button bu8;
	Button bu;
	Button Denglu;
	EditText yonghu;
	EditText mima;
	SharedPreferences sp;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.login);
		 //�ѱ���activity��ӵ�exit_app����addActivity��������
        Exit_app.getInstance().addActivity(Login.this);
		bu4 = (Button) findViewById(R.id.bt1);
		bu5 = (Button) findViewById(R.id.bt2);
		bu6 = (Button) findViewById(R.id.bt3);
		bu7 = (Button) findViewById(R.id.bt4);
		bu8 = (Button) findViewById(R.id.bt5);
		bu = (Button) findViewById(R.id.gengduo);
		bu.setOnClickListener(new OnClickListener() {
           
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent in = new Intent(Login.this, More.class);
				startActivity(in);
			}
		});
		yonghu = (EditText) findViewById(R.id.yonghu);
		mima = (EditText) findViewById(R.id.mima);
		Denglu = (Button) findViewById(R.id.queding);
		  sp=this.getSharedPreferences("user", Context.MODE_PRIVATE);
		Denglu.setOnClickListener(new OnClickListener() {
			String name = sp.getString("name", "");
			String savedPwd = sp.getString("pass", "");
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				String a = yonghu.getText().toString().trim();
				String m = mima.getText().toString().trim();
				System.out.println(name);
				System.out.println(savedPwd);
				System.out.println(a);
				System.out.println(m);
				if (name .equals(a)  && savedPwd .equals(m)) {
					System.out.println("aaaaa");
					Intent intent = new Intent(Login.this, More.class);
					startActivity(intent);
				} else {
					Toast.makeText(getApplicationContext(), "���벻��ȷ", 0).show();
					return;

				}
			}
		});
	}

	public void danjigengduo(View v) {
		Intent in;
		switch (v.getId()) {
		case R.id.bt1:
			in = new Intent(Login.this, WeiHaiActivity.class);
			startActivity(in);
			break;
		case R.id.bt2:
			in = new Intent(Login.this, Introduce.class);
			startActivity(in);
			break;
		case R.id.bt3:
			in = new Intent(Login.this, Online.class); 
			startActivity(in);
			break;
		case R.id.bt4:
			in = new Intent(Login.this, Phone.class);
			startActivity(in);
			break;
		case R.id.bt5:
			in = new Intent(Login.this, More.class); 
			startActivity(in);
			break;
		}
	}
}




