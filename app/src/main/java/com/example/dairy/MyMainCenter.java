package com.example.dairy;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class MyMainCenter extends AppCompatActivity {
    MyConectionClassAndOtherUnits mccaou=new MyConectionClassAndOtherUnits();
    ArrayList<Class> classes=new ArrayList<Class>();
    ArrayList<Section> sections=new ArrayList<Section>();
    ArrayList<Elective> electives=new ArrayList<Elective>();
    String selectionElS=new String();
    String selectionUnit=new String();
    String selectionClass=new String();
    int tempint;
    int tempclassint;
    ArrayList<Class> tempclasses=new ArrayList<Class>();
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.maincenter);

        electives=mccaou.getElectives();

        sections=mccaou.getSections();

        classes=mccaou.getClasses();
        System.out.println(mccaou.getElectives());
        Spinner SpinElS = (Spinner) findViewById(R.id.SpinElS);
        Spinner SpinUnits = (Spinner) findViewById(R.id.SpinUnits);
        Spinner SpinClass = (Spinner) findViewById(R.id.SpinClass);
        // Создаем адаптер ArrayAdapter с помощью массива строк и стандартной разметки элемета spinner
        String[] ElS = { "Elective","Section"};
        ArrayAdapter<String> adapterElS = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, ElS);
        // Определяем разметку для использования при выборе элемента
        adapterElS.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        // Применяем адаптер к элементу spinner
        SpinElS.setAdapter(adapterElS);

        AdapterView.OnItemSelectedListener itemSelectedListener = new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                // Получаем выбранный объект
                String item = (String)parent.getItemAtPosition(position);
                selectionElS=item;
                tempint=-1;
                tempclasses.clear();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        };
        SpinElS.setOnItemSelectedListener(itemSelectedListener);
        ArrayAdapter<String> adapterunit;
        if(selectionElS.equals("Elective")) {
            String[] strelectives = new String[electives.size()];
            for (int i = 0; i < electives.size(); i++) {
                strelectives[i] = electives.get(i).getAcademicSubject();
            }
            adapterunit = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, strelectives);
        }else{
            String[] strsections = new String[sections.size()];
            for (int i = 0; i < sections.size(); i++) {
                strsections[i] = sections.get(i).getName();
            }
            adapterunit = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, strsections);
        }
        SpinUnits.setAdapter(adapterunit);

        AdapterView.OnItemSelectedListener itemSelectedListenerUnit = new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                // Получаем выбранный объект
                String item = (String)parent.getItemAtPosition(position);
                selectionUnit=item;
                tempclasses.clear();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        };
        SpinUnits.setOnItemSelectedListener(itemSelectedListenerUnit);

        if(selectionElS.equals("Elective")) {
            for(int i=0;i<electives.size();i++){
                if(selectionUnit.equals(electives.get(i).getAcademicSubject())){
                    tempint=i;
                }
            }
            for(int i=0;i<classes.size();i++){
                for(int j=0;i<classes.get(j).getdefaultElective().length;j++)
                if(selectionUnit.equals(classes.get(i).getdefaultElective()[j])){
                    tempclasses.add(classes.get(i));
                }
            }
        }else{
            for(int i=0;i<sections.size();i++){
                if(selectionUnit.equals(sections.get(i).getName())){
                    tempint=i;
                }
            }
            for(int i=0;i<classes.size();i++){
                for(int j=0;i<classes.get(j).getdefaultSection().length;j++)
                    if(selectionUnit.equals(classes.get(i).getdefaultSection()[j])){
                        tempclasses.add(classes.get(i));
                    }
            }
        }
        String[] strclasses=new String[tempclasses.size()];
        for (int i=0;i<tempclasses.size();i++){
            strclasses[i]=tempclasses.get(i).getNumber();
        }
        ArrayAdapter<String> adapterClass = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, strclasses);
        // Определяем разметку для использования при выборе элемента
        adapterClass.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        // Применяем адаптер к элементу spinner
        SpinClass.setAdapter(adapterClass);

        AdapterView.OnItemSelectedListener itemSelectedListenerClass = new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                // Получаем выбранный объект
                String item = (String)parent.getItemAtPosition(position);
                selectionClass=item;
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        };
        SpinClass.setOnItemSelectedListener(itemSelectedListenerClass);
        for(int i=0;i<tempclasses.size();i++){
            if(selectionClass.equals(tempclasses.get(i).getNumber())){
                tempclassint=i;
            }
        }

    }

}
