package com.example.villanueva_prelim;

import java.util.ArrayList;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

public class MyAdapter extends BaseAdapter {
	
	
	Context context;
	
	ArrayList<Student> list;
	LayoutInflater inflater;
	
	public MyAdapter(Context context, ArrayList<Student> list) {
		super();
		this.context = context;
		this.list = list;
		this.inflater = LayoutInflater.from(context);
	}

	

	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return list.size();
	}

	@Override
	public Object getItem(int arg0) {
		// TODO Auto-generated method stub
		return list.get(arg0);
	}

	@Override
	public long getItemId(int arg0) {
		// TODO Auto-generated method stub
		return arg0;
	}

	@Override
	public View getView(int arg0, View arg1, ViewGroup arg2) {
		// TODO Auto-generated method stub
		StudentHandler handler = null;
		
		if(arg1 == null)
		{
			arg1 = inflater.inflate(R.layout.information, null);
			handler = new StudentHandler();
			handler.name = (TextView)arg1.findViewById(R.id.name);
			handler.course = (TextView)arg1.findViewById(R.id.course);
			arg1.setTag(handler);
		}
		
		else handler = (StudentHandler)arg1.getTag();
		
		handler.name.setText(list.get(arg0).getStudentName());
		handler.course.setText(list.get(arg0).getCourse());
		
		
		return arg1;
	}
	
	
	static class StudentHandler
	{
		TextView name;
		TextView course;
	}

}
