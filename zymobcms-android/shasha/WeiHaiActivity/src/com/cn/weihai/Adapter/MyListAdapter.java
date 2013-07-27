package com.cn.weihai.Adapter;

import java.util.HashMap;
import java.util.List;

import com.cn.weihai.R;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class MyListAdapter extends BaseAdapter {

	private final int[] image={R.drawable.aa,R.drawable.ab,R.drawable.ac,
			                                R.drawable.ad,R.drawable.ae,R.drawable.af,
			                                R.drawable.ag,R.drawable.ah};
	  private  String[] text={"��������","�ڿ���־","���ֲʺ�","���۷���","С��ֽ��","���ɽ���"
			             ,"Ψ���ͻ�","��������"  };
		private  String[] text1={"������Դ�������,  ������ʵϸ��,","רҵ���ŶӴ���߶˲�Ʒ, �кõİ�","����ɫ��   ����ѡ��",
		                              "���Ի�װ��    ��������", "����ֽ��, Ʒ�ʸ�", "רҵ�������ֲ��ɽ���Ʒ, ��Ҫ����",
		                              "�ͻ���ѡ����ӡˢ��,  Ϊ������","������,  �����Ա�ǿ�Ҷ�"};
		private  String[] text2={"�����ͷ׶��,  ������ʵ�޻�","װ, ���кõĿ�ʼ","���ʴ����￪ʼ",
		                               "������ĺ�װ�� ", "��ʽ��, С�ɾ���", "���ɽ�, ͸�����ɽ�, �����벻�ɽ�","��Ʋ�ͬ�����ͻ�",
		                               "��ʧϸ��,  �����ǿ"};
	private static   Context  context;
	private static List<HashMap<String, String>>  list;
	public  MyListAdapter(Context context){
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

