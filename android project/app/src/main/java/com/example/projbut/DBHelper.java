package com.example.nidhi.projbut;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;




public class DBHelper extends SQLiteOpenHelper{


    public static final String DATABASE_NAME="reg.db";
    public static final String TABLE_NAME="Register_table";


    public static final String COL_11="Name";
    public static final String COL_22="RollNo";
    public static final String COL_33="Branch";
    public static final String COL_44="Year";
    public static final String COL_55="MobileNo";

    public DBHelper(Context context) {
        super(context, DATABASE_NAME, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table "+TABLE_NAME+"(Name Text,RollNo Text PRIMARY KEY,Branch Text,Year Text,MobileNo Text)");

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldversion, int newversion) {
        db.execSQL("DROP TABLE IF EXISTS "+TABLE_NAME);
        onCreate(db);

    }
    public boolean insertData1(String name, String rollno,String branch, String year, String phno)
    {
        SQLiteDatabase db=this.getWritableDatabase();
        ContentValues contentValues1=new ContentValues();

        contentValues1.put(COL_11,name);
        contentValues1.put(COL_22,rollno);
        contentValues1.put(COL_33,branch);
        contentValues1.put(COL_44,year);
        contentValues1.put(COL_55,phno);

        long result1=db.insert(TABLE_NAME,null,contentValues1);


        if(result1==-1)
        {
            return false;
        }
        else
        {
            return true;
        }

    }
       public Cursor getAllData1()
    {
        SQLiteDatabase db=this.getWritableDatabase();
        Cursor result=db.rawQuery("select * from "+TABLE_NAME,null);
        return result;

    }
}
