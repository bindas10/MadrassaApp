package com.example.myapplication;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;

public class DBHelper extends SQLiteOpenHelper {
    private static final String DB_Name="Portal";
    private static final String User_table="Records";
    private static final String COLUMN_ID="id";
    private static final String COLUMN_NAME="name";
    private static final String COLUMN_CLASS="class";
    private static final String COLUMN_AGE="age";


    private static final String table="Daily_tasks";
    private static final String COLUMN_IDD="id";
    private static final String COLUMN_DATE="date";
    private static final String COLUMN_NAME_surah="surah_name";
    private static final String COLUMN_RANGE="range";
    private static final String COLUMN_LAST_PARA="last_para";
    private static final String COLUMN_MANZIL="manzil";
    public DBHelper(@Nullable Context context) {
        super(context, DB_Name, null, 1);


    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        String sql = "CREATE TABLE " + User_table + "("
                + COLUMN_ID + " TEXT PRIMARY KEY ,"
                + COLUMN_NAME + " TEXT,"
                + COLUMN_CLASS + " TEXT,"
                + COLUMN_AGE + " TEXT"
                + ")";
        db.execSQL(sql);
        Log.d("DB","The table is Created");
        String sqlq = "CREATE TABLE IF NOT EXISTS " + table + "("
                + COLUMN_DATE + " TEXT  ,"
                + COLUMN_IDD + " TEXT  ,"
                + COLUMN_NAME_surah + " TEXT,"
                + COLUMN_RANGE + " TEXT,"
                + COLUMN_LAST_PARA + " TEXT,"
                + COLUMN_MANZIL + " TEXT"
                + ")";
        db.execSQL(sqlq);
        Log.d("DB","The table is Created");
    }


    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS "+User_table);
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS "+table);
        onCreate(sqLiteDatabase);
    }

    public void insertStudent(Student_profile student) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(COLUMN_ID, student.getId());
        values.put(COLUMN_NAME, student.getName());
        values.put(COLUMN_CLASS, student.getStudent_class());
        values.put(COLUMN_AGE, student.getAge());

        db.insert(User_table, null, values);
        db.close();
    }

    Cursor ReadAlldata()
    {
        String query="SELECT * FROM " +User_table;
        SQLiteDatabase sqDB=this.getReadableDatabase();
        Cursor cursor=null;
        if(sqDB!=null)
        {
            cursor= sqDB.rawQuery(query,null);
        }
        return cursor;
    }
    Cursor ReadAlldata(String id)
    {
        String query="SELECT * FROM " +User_table+ "  WHERE "+COLUMN_ID+"="+id ;
        SQLiteDatabase sqDB=this.getReadableDatabase();
        Cursor cursor=null;
        if(sqDB!=null)
        {
            cursor= sqDB.rawQuery(query,null);
        }
        return cursor;
    }

    public void insertTask_details(Task_Details task) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(COLUMN_DATE, task.getDate());
        values.put(COLUMN_IDD, task.getId());
        values.put(COLUMN_NAME_surah, task.getName());
        values.put(COLUMN_RANGE, task.getRange());
        values.put(COLUMN_LAST_PARA, task.getLast_para());
        values.put(COLUMN_MANZIL, task.getManzil());


        db.insert(table, null, values);
        db.close();

    }
    Cursor ReadAlldata_details(String id)
    {
        String query="SELECT * FROM " +table+" WHERE "+COLUMN_IDD+"="+id ;
        SQLiteDatabase sqDB=this.getReadableDatabase();
        Cursor cursor=null;
        if(sqDB!=null)
        {
            cursor= sqDB.rawQuery(query,null);
        }
        return cursor;
    }
    Cursor ReadAlldata_details()
    {
        String query="SELECT * FROM " +table ;
        SQLiteDatabase sqDB=this.getReadableDatabase();
        Cursor cursor=null;
        if(sqDB!=null)
        {
            cursor= sqDB.rawQuery(query,null);
        }
        return cursor;
    }


}
