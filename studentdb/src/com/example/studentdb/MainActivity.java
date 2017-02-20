package com.example.studentdb;

import java.util.ArrayList;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.Toast;

public class MainActivity extends Activity implements OnItemSelectedListener {

	EditText txtIdno, txtName;
	Spinner cboCourse;
	ListView lv;
	ArrayList<String> list = new ArrayList<String>();
	ArrayAdapter<String> adapter;
	private String selectedcourse;
	studentDB db;
	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        db = new studentDB(this);
        
        
        this.txtIdno = (EditText)this.findViewById(R.id.idno);
        this.txtName = (EditText)this.findViewById(R.id.name);
        this.cboCourse = (Spinner)this.findViewById(R.id.course);
        this.lv = (ListView)this.findViewById(R.id.listView1);
        
        
        
        this.adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1);
        //adapter
        this.lv.setAdapter(adapter);
        this.cboCourse.setOnItemSelectedListener(this);
        
        if(db.getAllStudent()!=null)
        {
        	list = db.getAllStudent();
        }
        
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        
        
        return true;
    }


	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// TODO Auto-generated method stub
		String idno = this.txtIdno.getText().toString();
		String name = this.txtName.getText().toString();
		
		//database
		if(!idno.equals("") && (!name.equals("")))
		{
			long result = db.addStudent(idno, name, selectedcourse);
			String message = (result>0)?"New Student Added":"Adding Error";
			Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
		
			String student = idno + " " + name + " " + this.selectedcourse;
			adapter.add(student);
			adapter.notifyDataSetChanged();
		}
		
		
		return super.onOptionsItemSelected(item);
	}


	@Override
	public void onItemSelected(AdapterView<?> arg0, View arg1, int arg2,
			long arg3) {
		// TODO Auto-generated method stub
		 selectedcourse = this.cboCourse.getItemAtPosition(arg2).toString();
		
	}


	@Override
	public void onNothingSelected(AdapterView<?> arg0) {
		// TODO Auto-generated method stub
		
	}
    
    
    
}
