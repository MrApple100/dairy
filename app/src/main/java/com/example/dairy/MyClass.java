package com.example.dairy;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MyClass extends AppCompatActivity {
    private static ArrayList<Class> classes = new ArrayList<Class>();

    public  ArrayList<Class> getClasses() {
        return classes;
    }

    public void setClasses(ArrayList<Class> classes) {
        MyClass.classes = classes;
    }

    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.creatclass);
        //School school1=new School("Bratsk","Lyceum");
        //Learner learner1=new Learner("Запорожских",123456);
        //Teacher teacher1=new Teacher("Купидоновна",123456,"Mathperson","high");
        //Class classroom1=new Class("11A",teacher1);
        //classroom1.addLearners(learner1);
        //school1.addClasses(classroom1);
        //school1.UpdateLearners();

        //Elective elective1=new Elective("math");
        //school1.addElective(elective1);
        //classroom1.addElective(elective1);

        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.list);
        Button button=(Button) findViewById(R.id.button);
        Button ClasstoUnits=(Button) findViewById(R.id.ClasstoUnits);
        EditText NameClass=(EditText) findViewById(R.id.NameClass);
        EditText teacher=(EditText) findViewById(R.id.Teacher);
        View.OnClickListener listener=new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switch (v.getId()) {
                    case R.id.button:
                        int check=0;
                        Class classroom2 = new Class(NameClass.getText().toString(),new Teacher(teacher.getText().toString(),123456,"Math","high"));
                        for(int i=0;i<classes.size();i++){
                            if((classes.get(i).getNumber().toString()).equals(NameClass.getText().toString())){
                                classes.get(i).setClassTeacher(new Teacher(teacher.getText().toString(),123456,"Math","high"));
                                check=1;
                            }
                        }
                        if(check==0){
                            classes.add(classroom2);
                        }
                        Adapter adapter = new Adapter(MyClass.this, classes);
                        recyclerView.setAdapter(adapter);
                        NameClass.setText("");
                        teacher.setText("");
                    break;
                    case R.id.ClasstoUnits:
                        Intent intent=new Intent(MyClass.this,MyOtherUnitsSociety.class);
                        startActivity(intent);
                        break;

                }
            }
        };
        button.setOnClickListener(listener);
        ClasstoUnits.setOnClickListener(listener);

    }
    public void OnClickList(View v) {
        EditText NameClass=(EditText) findViewById(R.id.NameClass);
        EditText Teacher=(EditText) findViewById(R.id.Teacher);
        Class tempclass=classes.get((int)v.getTag());
        NameClass.setText(tempclass.getNumber());
        Teacher.setText(tempclass.getClassTeacher().getFullName());
    }
    public void DELETE(View v){
        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.list);
        classes.remove((int)v.getTag());
        EditText NameClass=(EditText) findViewById(R.id.NameClass);
        Adapter adapter = new Adapter(MyClass.this, classes);
        recyclerView.setAdapter(adapter);
    }

}

