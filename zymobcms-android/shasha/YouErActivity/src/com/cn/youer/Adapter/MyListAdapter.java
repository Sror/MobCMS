package com.cn.youer.Adapter;

import java.util.HashMap;
import java.util.List;
import com.cn.youer.R;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class MyListAdapter extends BaseAdapter {

	private final int[] image={R.drawable.aa,R.drawable.ab,R.drawable.ac,
			                                R.drawable.ad,R.drawable.ae,R.drawable.af,
			                                R.drawable.ag,R.drawable.ah,R.drawable.ai,
			                                R.drawable.aj};
	  private  String[] text={"�׶��·�","�׶���","�׶���","�׶��Ƕ�","�׶��;�","�׶��̷�"
			             ,"�׶����¶","�׶�ˬ����","�׶����׽���","�׶���ƿ"  };
		private  String[] text1={"�ʵظ߶�   �ָ�˿��","��ĥ�⻬, �ָм���","����, ��ˮ��ǿ",
		                              "͸����ˮ, ԽϸԽ��", "���¹轺, �⻬��覴�", "����, ����, ����, ����",
		                              "������Ƶ��䷽�� ��ȫ��ʪ����","��������ͨ��һϵ���ϸ�Ĳ���",
		                              "������ȫ, ����, �ָк�","�޶�, ��ζ, ����˫��A"};
		private  String[] text2={"�޼�ȩ��ϸ��÷���","���ỷ����Σ��, �����ӵĶ�....","�۸��Ż�, �ָк�, ��������....",
		                               "ȫ��λ�ǻ�������С���� ", "���幤ѧ���, �ʵ�����, ��....", "������һ�ݾ��µİ�","һ��ͿĨ, �ͻ�����ڻ�",
		                               "�Ⱦ���....","���������ϻ�����, �Ͳ��ᱻ....","����˳��, �ڸм��ѣ�"};
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

