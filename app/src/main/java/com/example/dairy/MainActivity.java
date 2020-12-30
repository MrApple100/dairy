package com.example.dairy;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        School school1=new School("Bratsk","Lyceum");
        Learner learner1=new Learner("Запорожских",123456);
        Teacher teacher1=new Teacher("Купидоновна",123456,"Mathperson","high");
        Class classroom1=new Class("1",teacher1);
        classroom1.addLearners(learner1);
        System.out.println(classroom1.getList()[0]);
        school1.addClasses(classroom1);
        school1.UpdateLearners();
        System.out.println(school1.getListLearners().length);
        Elective elective1=new Elective("math");
        school1.addElective(elective1);
        classroom1.addElective(elective1);
        System.out.println(school1.getListLearners()[0].getElective().length);
        System.out.println(school1.getListLearners()[0].getSection().length);

        System.out.println(school1.getElectronicJournal(learner1)[0][0]);
    }
}