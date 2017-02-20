package com.example.studentdb;

import java.util.ArrayList;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteOpenHelper;
//41:58

public class studentDB extends SQLiteOpenHelper {



	public static String DB = "db_student";
	public static String STUDENT = "tbl_student";
	Context context;
	
	public studentDB(Context context) {
		super(context, DB, null, 1);
		//CREATE the database at the device
		
		
	}	
	
	
	
	@Override
	public void onCreate(SQLiteDatabase db) {
		// create table
		String sql = "CREATE TABLE "+STUDENT+"(id integer primary key autoincrement,idno varchar(10),name varchar(50),course varchar(10))";
		db.execSQL(sql);
		
	}
	
	public long addStudent(String idno, String name, String course)
	{
		long result = 0;
			ContentValues cv = new ContentValues();
				cv.put("idno",idno);
				cv.put("name",name);
				cv.put("course",course);
			SQLiteDatabase  db = this.getWritableDatabase();
				result = db.insert(STUDENT, null, cv);
				db.close();
				
		return result;
	}

	public ArrayList<String> getAllStudent()
	{
		ArrayList<String> list = new ArrayList<String>();
			SQLiteDatabase db = this.getReadableDatabase();
			Cursor c = db.query(STUDENT, null, null, null, null, null, "name");
			
			c.moveToFirst();
			while(!c.isAfterLast())
			{
				String idno = c.getString(c.getColumnIndex("idno"));
				String name = c.getString(c.getColumnIndex("name"));
				String course = c.getString(c.getColumnIndex("course"));
				
				String student = idno + " " + name + " " + course;
				list.add(student);
				
				c.moveToNext();
			}
			
			
		return list;
	}
	
	
	@Override
	public void onUpgrade(SQLiteDatabase arg0, int arg1, int arg2) {
		// TODO Auto-generated method stub

	}

}
