package com.cn.jiafangtuangou;

import java.util.ArrayList;
import java.util.List;

import android.app.Activity;
import android.app.Application;

public class Exit_app extends Application {
	 //��������������Ŵ򿪵�activity
		private  List<Activity>  shuzu=new ArrayList<Activity>();
		//����������exit_app����
		private static Exit_app instance=null;
		//˽�й���Ϊ�˱������ֱ��ʹ��new��ʵ��������
//		private Exit_app(){};
		
		//��������exit_app����--���л�
		public synchronized  static Exit_app  getInstance(){
			if(instance==null){
				instance=new Exit_app();
			}
			return instance;		
		}
		//��ÿ��activity�浽������
		public void addActivity(Activity activity){
			shuzu.add(activity);
		}
		
		  public void exit(){
			  //��������
			  for(Activity  activity:shuzu){
				  if(instance!=null){
					  activity.finish();
				  }
			  }
		  }
	}

