package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class AddStudent_form extends AppCompatActivity {


    String id,name,std_class,age;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_student_form);


        ((Button)findViewById(R.id.submit)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                id=((EditText)findViewById(R.id.student_id)).getText().toString();
                name=((EditText)findViewById(R.id.student_name)).getText().toString();
                std_class=((EditText)findViewById(R.id.student_class)).getText().toString();
                age=((EditText)findViewById(R.id.student_age)).getText().toString();

                if(id.isEmpty()||name.isEmpty()||std_class.isEmpty()||age.isEmpty())
                {
                    Toast.makeText(AddStudent_form.this, "Fields is empty !", Toast.LENGTH_SHORT).show();
                }
                else {

                    DBHelper db=new DBHelper(AddStudent_form.this);
                    db.insertStudent(new Student_profile(id,name,std_class,age));
                    Toast.makeText(AddStudent_form.this, "Submit Successfully :)", Toast.LENGTH_SHORT).show();
                    ((EditText)findViewById(R.id.student_id)).setText("");
                    ((EditText)findViewById(R.id.student_name)).setText("");
                    ((EditText)findViewById(R.id.student_class)).setText("");
                    ((EditText)findViewById(R.id.student_age)).setText("");
                }
            }
        });
    }
}