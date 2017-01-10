package com.example.villanueva_prelim;

import java.util.ArrayList;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

public class MainActivity extends Activity implements OnClickListener {

	ListView lv;
	EditText studentName, course;
	Button btnAdd;
	ArrayList<Student> list = new ArrayList<Student>();
	MyAdapter adapter;
	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        this.lv = (ListView)this.findViewById(R.id.listView1);
        this.studentName = (EditText)this.findViewById(R.id.name);
        this.course = (EditText)this.findViewById(R.id.course);
        this.btnAdd = (Button)this.findViewById(R.id.add);
        
        this.btnAdd.setOnClickListener(this);
        
		adapter = new MyAdapter(this,list);
	    this.lv.setAdapter(adapter);
        
       // list.add(new Student(String, String));
        
        
        
    }

	@Override
	public void onClick(View arg0) {
		// TODO Auto-generated method stub
		
		String name = this.studentName.getText().toString();
		String course = this.course.getText().toString();
		
		if(!name.equals("") && !course.equals(""))
			
		list.add(new Student(name, course));

		
		
	}



  
    
}
