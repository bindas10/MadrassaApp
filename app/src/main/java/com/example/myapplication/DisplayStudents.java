package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.database.Cursor;
import android.os.Bundle;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class DisplayStudents extends AppCompatActivity {
    DBHelper db;
    Student_profile std_profile;
    RecyclerView recyclerView;

    List<Student_profile> stdlist;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_students);
        stdlist=new ArrayList<Student_profile>();
        db=new DBHelper(DisplayStudents.this);
        displayData();
        recyclerView=(RecyclerView)findViewById(R.id.student_list);
        // Toast.makeText(this, "Here the list", Toast.LENGTH_SHORT).show();
        myRecyclerViewAdapter obj=new myRecyclerViewAdapter(stdlist,this);
        recyclerView.setAdapter(obj);
        recyclerView.setLayoutManager(new LinearLayoutManager(DisplayStudents.this));

    }
    void displayData()
    {
        Cursor cursor=db.ReadAlldata();
        if(cursor.getCount()==0)
        {
            Toast.makeText(this, "No Data Found", Toast.LENGTH_SHORT).show();
        }
        else {

            while(cursor.moveToNext())
            {
                stdlist.add(new Student_profile(cursor.getString(0),cursor.getString(1),null,cursor.getString(3)));
            }
        }
    }
}