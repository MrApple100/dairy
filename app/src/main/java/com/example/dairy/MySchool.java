package com.example.dairy;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class MySchool extends AppCompatActivity {
    static School school1;

    public static School getSchool1() {
        return school1;
    }

    public static void setSchool1(School school1) {
        MySchool.school1 = school1;
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.creatschool);
        Button next=(Button) findViewById(R.id.SchooltoClass);
        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switch (v.getId()){
                    case R.id.SchooltoClass:
                        school1=new School(((EditText) findViewById(R.id.Schooladdress)).getText().toString(),
                                                    ((EditText) findViewById(R.id.NameSchool)).getText().toString());
                        Intent intent=new Intent(MySchool.this,MyClass.class);
                        startActivity(intent);
                        break;

                }
            }
        });
    }
}
