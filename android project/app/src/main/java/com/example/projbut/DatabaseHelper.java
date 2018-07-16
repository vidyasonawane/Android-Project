package com.example.nidhi.projbut;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

        import android.content.ContentValues;
        import android.content.Context;
        import android.database.sqlite.SQLiteDatabase;
        import android.database.sqlite.SQLiteOpenHelper;

import static android.R.attr.name;
import static android.R.attr.password;
import static android.icu.lang.UCharacter.GraphemeClusterBreak.T;


public class DatabaseHelper extends SQLiteOpenHelper {
    public static final String DATABASE_NAME="Club.db";
    public static final String TABLE_NAME="Club_table";

    public static final String COL_1="EmailID";
    public static final String COL_2="Password";




    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, 1);

    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table "+TABLE_NAME+"(EmailID Text PRIMARY KEY,Password Text)");

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldversion, int newversion) {
        db.execSQL("DROP TABLE IF EXISTS "+TABLE_NAME);

        onCreate(db);
    }
    public boolean insertData(String emailid,String password )
    {
        SQLiteDatabase db=this.getWritableDatabase();
        ContentValues contentValues=new ContentValues();

        contentValues.put(COL_1,emailid);
        contentValues.put(COL_2,password);
        long result=db.insert(TABLE_NAME,null,contentValues);

        if( result==-1)
        {
            return false;
        }
        else
        {
            return true;
        }

    }




    public Cursor getAllData()
    {
        SQLiteDatabase db=this.getWritableDatabase();
        Cursor result=db.rawQuery("select * from "+TABLE_NAME,null);//used explicitly for select statement
        return result;

    }

}
