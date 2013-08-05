package com.cn.jiafangtuangou;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

import com.cn.Adapter.myListAdapter;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.os.Parcelable;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;

public class JiaFangMainActivity extends Activity {
    private int[] imageIds;
    Button  bu1;
    private List<ImageView> imageViews;
    private List<View> dots;
    private ViewPager viewPager;
    private ListView  listView;
    private ScheduledExecutorService  scheduledExecutorService;
    private int currentItem=0;//��ǰҳ��

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);//ȥ��������
		setContentView(R.layout.activity_main);
		 //�ѱ���activity���ӵ�exit_app����addActivity��������
        Exit_app.getInstance().addActivity(JiaFangMainActivity.this);
		//listview����������
		listView=(ListView) findViewById(R.id.lv);
		myListAdapter myListAdapter=new myListAdapter(this);
		listView.setAdapter( myListAdapter);
		listView.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> parent, View view,
					int position, long id) {
				Intent in;
				// TODO Auto-generated method stub
				switch (position) {
				case 0:
				 in=new Intent(JiaFangMainActivity.this, Intent0.class);
				startActivity(in);
//				finish();	
					break;
				case 1:
					in=new Intent(JiaFangMainActivity.this, Intent1.class); 
					startActivity(in);
//					finish();
					break;
				case 2:
					in=new Intent(JiaFangMainActivity.this, Intent2.class);
					startActivity(in);
//					finish();
					break;
				case 3:
					in=new Intent(JiaFangMainActivity.this, Intent3.class);
					startActivity(in);
//					finish();
					break;
				case 4:
					in=new Intent(JiaFangMainActivity.this, Intent4.class);
					startActivity(in);
//					finish();
					break;
				case 5:
					in=new Intent(JiaFangMainActivity.this, Intent5.class);
					startActivity(in);
//					finish();
					break;
				case 6:
					in=new Intent(JiaFangMainActivity.this, Intent6.class);
					startActivity(in);
//					finish();
					break;
				
				}
			}
		});
		
		bu1=(Button) findViewById(R.id.bt2);
		
		
		//ͼƬ��Դ
		imageIds=new int[]{R.drawable.n,R.drawable.shao,
				           R.drawable.bu,R.drawable.shuang,R.drawable.xuan};
		//������ͼƬ
		imageViews=new ArrayList<ImageView>();
		for (int i = 0; i < imageIds.length; i++) {
			ImageView  imageView=new ImageView(this);
			imageView.setImageResource(imageIds[i]);
			
			imageViews.add(imageView);
		}
		//ͼƬ����Ӧ��Բ��
		dots=new ArrayList<View>();
		dots.add(findViewById(R.id.v_dot0));
		dots.add(findViewById(R.id.v_dot1));
		dots.add(findViewById(R.id.v_dot2));
		dots.add(findViewById(R.id.v_dot3));
		dots.add(findViewById(R.id.v_dot4));
		viewPager=(ViewPager)findViewById(R.id.vp);
		//��viewpager��������
		viewPager.setAdapter(new MyViewPager());
		//ҳ��ı����
		viewPager.setOnPageChangeListener(new OnPageChangeListener() {
			private int oldPosition=0;
			@Override
			public void onPageSelected(int arg0) {
				// TODO Auto-generated method stub
				currentItem=arg0;
				//�ı�Բ��
				dots.get(oldPosition).setBackgroundResource(R.drawable.dot_normal);
				dots.get(arg0).setBackgroundResource(R.drawable.dot_focused);
				oldPosition=arg0;
			}
			
			@Override
			public void onPageScrolled(int arg0, float arg1, int arg2) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void onPageScrollStateChanged(int arg0) {
				// TODO Auto-generated method stub
				
			}
		});
		
	}
	public void danji(View v){
		Intent in;
		switch (v.getId()) {
		case R.id.bt2:
			in=new Intent(JiaFangMainActivity.this, GongSiJianJie.class);
			startActivity(in);
			finish();
			break;
		case R.id.bt3:
			in=new Intent(JiaFangMainActivity.this, ZaiXian.class);
			in.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP); 
			startActivity(in);
//			finish();
			break;
		case R.id.bt4:
			in=new Intent(JiaFangMainActivity.this, LianXiFangShi.class);
			in.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP); 
			startActivity(in);
//			finish();
			break;
		case R.id.bt5:
			in=new Intent(JiaFangMainActivity.this, Gengduo.class);
			startActivity(in);
			finish();
			break;

		}
	}
    class MyViewPager extends PagerAdapter{

		@Override
		public int getCount() {
			// TODO Auto-generated method stub
			return imageIds.length;
		}
		//ʵ����item  
				@Override
		public Object instantiateItem(View arg0, int arg1) {
					//��ÿ��ͼƬ���뵽ViewPager��
			((ViewPager)arg0).addView(imageViews.get(arg1));
			return imageViews.get(arg1);
		}

				@Override
		public void destroyItem(View arg0, int arg1, Object arg2) {
				//��ÿ��ͼƬ��ViewPager���ͷŵ�
			((ViewPager)arg0).removeView((View)arg2);
		}
		@Override
		public boolean isViewFromObject(View arg0, Object arg1) {
			// TODO Auto-generated method stub
			//view ��object�ǲ���һ������
			return arg0==arg1;
		}
		@Override
		public void finishUpdate(View arg0) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void restoreState(Parcelable arg0, ClassLoader arg1) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public Parcelable saveState() {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public void startUpdate(View arg0) {
			// TODO Auto-generated method stub
			
		}
    }
	@Override
	protected void onStart() {
		// TODO Auto-generated method stub
		scheduledExecutorService=Executors.newSingleThreadScheduledExecutor();
		        //ͨ����ʱ�� ����� ÿ2�����л�һ��ͼƬ
				//����ָ����ʱ���ִ����ָ��������
				//scheduleAtFixedRate(command, initialDelay, period, unit)
				//command ��Ҫִ�е�����
				//initialDelay ��һ������ʱ �ӳ�����ʱ�� 
				//period  ÿ������ʱ����������������
				//unit ʱ�䵥λ
		scheduledExecutorService.scheduleAtFixedRate(new ViewPagerTask(), 1, 2, TimeUnit.SECONDS);
		super.onStart();
	}
	@Override
	protected void onStop() {
		// TODO Auto-generated method stub
		 //ֹͣͼƬ
		scheduledExecutorService.shutdown();
		super.onStop();	 
	}
	//�������ͼƬ�л�������
	private class ViewPagerTask implements Runnable{

		@Override
		public void run() {
			// TODO Auto-generated method stub
			currentItem=(currentItem+1)%imageViews.size();
			handler.obtainMessage().sendToTarget();
		}		
	}
   private Handler handler=new Handler(){
	   public void handleMessage(Message msg) {
		  //�趨viewpager��ǰҳ��
		   viewPager.setCurrentItem(currentItem);
	   }
   };

   @Override  
   public boolean onKeyDown(int keyCode, KeyEvent event)  
   {  
       if (keyCode == KeyEvent.KEYCODE_BACK )  
       {  
           // �����˳��Ի���  
           AlertDialog isExit = new AlertDialog.Builder(this).create();  
           // ���öԻ������  
           isExit.setTitle("ϵͳ��ʾ");  
           // ���öԻ�����Ϣ  
           isExit.setMessage("ȷ��Ҫ�˳���");  
           // ����ѡ��ť��ע�����  
           isExit.setButton("ȷ��", listener);  
           isExit.setButton2("ȡ��", listener);  
           // ��ʾ�Ի���  
           isExit.show();  
 
       }  
         
       return false;  
         
   }  
   /**�����Ի��������button����¼�*/  
   DialogInterface.OnClickListener listener = new DialogInterface.OnClickListener()  
   {  
       public void onClick(DialogInterface dialog, int which)  
       {  
           switch (which)  
           {  
           case AlertDialog.BUTTON_POSITIVE:// "ȷ��"��ť�˳�����  
        		Exit_app.getInstance().exit(); 
               break;  
           case AlertDialog.BUTTON_NEGATIVE:// "ȡ��"�ڶ�����ťȡ���Ի���  
               break;             
           }  
       }  
   };    
}