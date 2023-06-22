package com.example.myapplication;


import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class Show_Daily_Task extends AppCompatActivity {
    RecyclerView recyclerView;
    String id;
    DBHelper db;
    List<Task_Details> Tlist;
    List<Student_profile> stdlist;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_daily_task);
        Intent intent=getIntent();
        id=intent.getStringExtra("id");
        Log.d("ID",id);
        Tlist=new ArrayList<Task_Details>();
        stdlist=new ArrayList<Student_profile>();
        db=new DBHelper(Show_Daily_Task.this);
        displayData();
        recyclerView=(RecyclerView)findViewById(R.id.dailyTaskRecycleview);
        // Toast.makeText(this, "Here the list", Toast.LENGTH_SHORT).show();
        DailyTaskRecycleAdapter obj=new DailyTaskRecycleAdapter(Tlist,stdlist);
        recyclerView.setAdapter(obj);
        recyclerView.setLayoutManager(new LinearLayoutManager(Show_Daily_Task.this));

    }
    void displayData()
    {
        Cursor cursor=db.ReadAlldata_details(id);
        Cursor cursor2=db.ReadAlldata(id);
        if(cursor.getCount()==0 || cursor2.getCount()==0)
        {

            Toast.makeText(this, "No Data Found", Toast.LENGTH_SHORT).show();
        }
        else {

            while(cursor.moveToNext())
            {
                Tlist.add(new Task_Details(cursor.getString(0),cursor.getString(1),cursor.getString(2),cursor.getString(3),cursor.getString(4),cursor.getString(5)));
            }
            while(cursor2.moveToNext())
            {
                stdlist.add(new Student_profile(cursor2.getString(0),cursor2.getString(1),cursor2.getString(2),cursor2.getString(3)));
            }

        }
    }
}