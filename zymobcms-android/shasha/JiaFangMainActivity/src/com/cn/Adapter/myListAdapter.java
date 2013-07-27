package com.cn.Adapter;

import java.util.HashMap;
import java.util.List;

import com.cn.jiafangtuangou.R;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class myListAdapter extends BaseAdapter {
	private final int[] image={R.drawable.sc,R.drawable.sb,R.drawable.sn,
            R.drawable.sm,R.drawable.sx,R.drawable.sz,
            R.drawable.xzha};
	  private  String[] text={"��Ʒ","����/��о","����/�ڿ�","ë��/ԡ��","��Ь/����","��ͷ/��о","����/�ӻ�"};
		private  String[] text1={"�ʵظ߶�   �ָ�˿��","����ϸ������  ����͸��","����ɫ��  ����ѡ��",
		                              "��Ȼ����  ��������", "������ĥ  ���Ըߵ�Ʒ��", "���޲���  ���·���","ȫ��Ȼ��ά����  �����ǿ"};
		private  String[] text2={"�޼�ȩ��ϸ��ô�Ʒ","��ӫ�����׼�����Ȼ����","���ʴ����￪ʼ",
		                               "������ĺ�ë��", "���幤ѧ���", "������Դɫ��","������Դɫ��"};
	private static   Context  context;
	private static List<HashMap<String, String>>  list;
	public  myListAdapter(Context context){
//		this.list=list;
		this.context=context;
	}
	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return text.length;
	}

	@Override
	public Object getItem(int position) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public long getItemId(int position) {
		// TODO Auto-generated method stub
		return 0;
	}
    
	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		View view = View.inflate(context, R.layout.itemlist, null);
		ImageView iv = (ImageView) view.findViewById(R.id.ivlist);
		TextView tv = (TextView) view.findViewById(R.id.item1);
		TextView tv1= (TextView) view.findViewById(R.id.item2);
		TextView tv2 = (TextView) view.findViewById(R.id.item3);
		tv.setText(text[position]);
		tv1.setText(text1[position]);
		tv2.setText(text2[position]);
		iv.setImageResource(image[position]);	
		return view;
	
	}

}

