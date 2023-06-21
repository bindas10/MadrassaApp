package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class DailyTaskForm extends AppCompatActivity {

    String id,name,range,last_para,manzil;
    DBHelper db;
    Calendar calender;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_daily_task_form);
        db = new DBHelper(DailyTaskForm.this);
        ((Button)findViewById(R.id.dailyTaskbutton)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                id=((EditText)findViewById(R.id.studentID_dailytask)).getText().toString();
                name=((EditText)findViewById(R.id.surahname)).getText().toString();
                range=((EditText)findViewById(R.id.surah_range)).getText().toString();
                last_para=((EditText)findViewById(R.id.last_para)).getText().toString();
                manzil=((EditText)findViewById(R.id.manzil)).getText().toString();


                if(id.isEmpty()||name.isEmpty()||range.isEmpty()||last_para.isEmpty()||manzil.isEmpty())
                {
                    Toast.makeText(DailyTaskForm.this, "Fields Are Empty !", Toast.LENGTH_SHORT).show();
                }
                else {

                    calender=Calendar.getInstance();
                    SimpleDateFormat sdf=new SimpleDateFormat("MM/dd/YYY");
                    String date=sdf.format(calender.getTime());

                    db.insertTask_details(new Task_Details(date,id, name, range, last_para, manzil));
                    Toast.makeText(DailyTaskForm.this, "Add Successfully !", Toast.LENGTH_SHORT).show();
                    ((EditText)findViewById(R.id.studentID_dailytask)).setText("");
                    ((EditText)findViewById(R.id.surahname)).setText("");
                    ((EditText)findViewById(R.id.surah_range)).setText("");
                    ((EditText)findViewById(R.id.last_para)).setText("");
                    ((EditText)findViewById(R.id.manzil)).setText("");

                }
            }
        });
    }
}