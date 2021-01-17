package com.example.dairy;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MyOtherUnitsSociety extends AppCompatActivity {

    private static ArrayList<Elective> electives = new ArrayList<Elective>();
    private static ArrayList<Section> sections = new ArrayList<Section>();

    public ArrayList<Elective> getElectives() {
        return electives;
    }

    public void setElectives(ArrayList<Elective> electives) {
        MyOtherUnitsSociety.electives = electives;
    }

    public ArrayList<Section> getSections() {
        return sections;
    }

    public void setSections(ArrayList<Section> sections) {
        MyOtherUnitsSociety.sections = sections;
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.creatotherunitssociety);
        RecyclerView recyclerViewEl = (RecyclerView) findViewById(R.id.listEl);
        RecyclerView recyclerViewS = (RecyclerView) findViewById(R.id.listS);
        Button button = (Button) findViewById(R.id.buttonUnitSociety);
        Button next =(Button) findViewById(R.id.Next);
        EditText NameClass = (EditText) findViewById(R.id.NameUnitSociety);
        EditText teacher = (EditText) findViewById(R.id.Teacher);
        RadioButton RadEl = (RadioButton) findViewById(R.id.RadEl);
        RadioButton RadS = (RadioButton) findViewById(R.id.RadS);
        View.OnClickListener listener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switch (v.getId()) {
                    case R.id.buttonUnitSociety:
                        int check = 0;
                        if (RadEl.isChecked()) {
                            Elective elective = new Elective(NameClass.getText().toString()+"");
                            elective.setClassTeacher(new Teacher(teacher.getText().toString()+"", 123456, NameClass.getText().toString()+"", "high"));
                            for (int i = 0; i < electives.size(); i++) {
                                if ((electives.get(i).getAcademicSubject().toString()).equals(NameClass.getText().toString())) {
                                    electives.get(i).setClassTeacher(new Teacher(teacher.getText().toString()+"", 123456, NameClass.getText().toString()+"", "high"));
                                    check = 1;
                                }
                            }
                            if (check == 0) {
                                electives.add(elective);
                            }

                            AdapterEl adapter = new AdapterEl(MyOtherUnitsSociety.this, electives);
                            recyclerViewEl.setAdapter(adapter);
                        }
                        if (RadS.isChecked()) {
                            Section section = new Section(NameClass.getText().toString()+"");
                            section.setClassTeacher(new Teacher(teacher.getText().toString()+"", 123456, NameClass.getText().toString()+"", "high"));
                            for (int i = 0; i < sections.size(); i++) {
                                if ((sections.get(i).getName().toString()).equals(NameClass.getText().toString())) {
                                    sections.get(i).setClassTeacher(new Teacher(teacher.getText().toString()+"", 123456, NameClass.getText().toString()+"", "high"));
                                    check = 1;
                                }
                            }
                            if (check == 0) {
                                sections.add(section);
                            }

                            AdapterS adapter = new AdapterS(MyOtherUnitsSociety.this, sections);
                            recyclerViewS.setAdapter(adapter);
                        }
                        NameClass.setText("");
                        teacher.setText("");
                        break;
                    case R.id.Next:
                        Intent intent=new Intent(MyOtherUnitsSociety.this,MyConectionClassandLearners.class);
                        startActivity(intent);
                        break;

                }
            }
        };
        button.setOnClickListener(listener);
        next.setOnClickListener(listener);
    }
    public void OnClickListEl(View v) {
        EditText NameClass=(EditText) findViewById(R.id.NameUnitSociety);
        EditText Teacher=(EditText) findViewById(R.id.Teacher);
        RadioButton RadEl = (RadioButton) findViewById(R.id.RadEl);
        RadioButton RadS = (RadioButton) findViewById(R.id.RadS);

            Elective tempelective=electives.get((int)v.getTag());
            NameClass.setText(tempelective.getAcademicSubject()+"");
            Teacher.setText(tempelective.getClassTeacher().getFullName());
            RadEl.toggle();


    }
    public void OnClickListS(View v) {
        EditText NameClass=(EditText) findViewById(R.id.NameUnitSociety);
        EditText Teacher=(EditText) findViewById(R.id.Teacher);
        RadioButton RadEl = (RadioButton) findViewById(R.id.RadEl);
        RadioButton RadS = (RadioButton) findViewById(R.id.RadS);

        Section tempsection=sections.get((int)v.getTag());
        NameClass.setText(tempsection.getName());
        Teacher.setText(tempsection.getClassTeacher().getFullName());
        RadS.toggle();

    }
    public void DELETEEl(View v){
        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.listEl);
        electives.remove((int)v.getTag());
        EditText NameClass=(EditText) findViewById(R.id.NameUnitSociety);
        AdapterEl adapter = new AdapterEl(MyOtherUnitsSociety.this, electives);
        recyclerView.setAdapter(adapter);
    }
    public void DELETES(View v){
        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.listS);
        sections.remove((int)v.getTag());
        EditText NameClass=(EditText) findViewById(R.id.NameUnitSociety);
        AdapterS adapter = new AdapterS(MyOtherUnitsSociety.this, sections);
        recyclerView.setAdapter(adapter);
    }
}