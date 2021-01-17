package com.example.dairy;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;


public class MyConectionClassAndOtherUnits extends AppCompatActivity {
    MyOtherUnitsSociety mous=new MyOtherUnitsSociety();
    MyClass mc=new MyClass();
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.creatconectionclassandotherunit);
        ArrayList<Elective> electives=new ArrayList<Elective>();
        electives=mous.getElectives();
        ArrayList<Section> sections=new ArrayList<Section>();
        sections=mous.getSections();
        ArrayList<Class> classes=new ArrayList<Class>();
        classes=mc.getClasses();
    }
}
