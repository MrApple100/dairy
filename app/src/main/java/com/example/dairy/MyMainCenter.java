package com.example.dairy;

import android.content.Context;
import android.os.Bundle;
import android.text.Editable;
import android.text.NoCopySpan;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.GridLayout;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class MyMainCenter extends AppCompatActivity {
    MyConectionClassAndOtherUnits mccaou=new MyConectionClassAndOtherUnits();
    private static ArrayList<Class> classes=new ArrayList<Class>();
    private static ArrayList<Section> sections=new ArrayList<Section>();
    private static ArrayList<Elective> electives=new ArrayList<Elective>();
    String selectionElS=new String();
    String selectionUnit=new String();
    String selectionClass=new String();
    int tempint;
    int tempclassint;
    ArrayList<Class> tempclasses=new ArrayList<Class>();
    ArrayList<String> tempmatrix=new ArrayList<String>();
    Spinner SpinElS ;
    Spinner SpinUnits ;
    Spinner SpinClass ;
    int rang=0;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.maincenter);

        electives = mccaou.getElectives();

        sections = mccaou.getSections();

        classes = mccaou.getClasses();

        SpinElS = (Spinner) findViewById(R.id.SpinElS);
        SpinUnits = (Spinner) findViewById(R.id.SpinUnits);
        SpinClass = (Spinner) findViewById(R.id.SpinClass);

        Button accept=(Button) findViewById(R.id.accept);
        Button save =(Button) findViewById(R.id.save);
        // Создаем адаптер ArrayAdapter с помощью массива строк и стандартной разметки элемета spinner
        String[] ElS = {"Choose","Elective", "Section"};
        ArrayAdapter<String> adapterElS = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, ElS);
        // Определяем разметку для использования при выборе элемента
        adapterElS.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        // Применяем адаптер к элементу spinner
        SpinElS.setAdapter(adapterElS);

        for(int i=0;i<electives.size();i++) {
            electives.get(i).UpdateAllMarksOfLearners1();
            electives.get(i).UpdateAllMarksOfLearners2();

        }
        for(int i=0;i<sections.size();i++) {
            sections.get(i).UpdateAllMarksOfLearners1();
            sections.get(i).UpdateAllMarksOfLearners2();
        }
        AdapterView.OnItemSelectedListener itemSelectedListener = new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                // Получаем выбранный объект
                String item = (String) parent.getItemAtPosition(position);
                selectionElS = item;
                tempint = -1;
                tempclasses.clear();
                save.setVisibility(View.INVISIBLE);
                if(!(item.equals("Choose"))){
                    rang=1;

                }else{
                    LinearLayout table=(LinearLayout)findViewById(R.id.settable);
                    table.removeAllViews();
                    LinearLayout tableofnames=(LinearLayout)findViewById(R.id.settablenameoflearners);
                    tableofnames.removeAllViews();
                    rang=0;
                }
                secondchoose();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        };
        SpinElS.setOnItemSelectedListener(itemSelectedListener);

        AdapterView.OnItemSelectedListener itemSelectedListenerUnit = new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if(rang>=1) {
                    // Получаем выбранный объект
                    String item = (String) parent.getItemAtPosition(position);
                    selectionUnit = item;
                    tempclasses.clear();
                    save.setVisibility(View.INVISIBLE);
                    if (!(item.equals("Choose Unit"))) {
                        rang = 2;

                    } else {
                        LinearLayout table=(LinearLayout)findViewById(R.id.settable);
                        table.removeAllViews();
                        LinearLayout tableofnames=(LinearLayout)findViewById(R.id.settablenameoflearners);
                        tableofnames.removeAllViews();
                        rang = 1;
                    }

                }thirdchoose();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        };

            SpinUnits.setOnItemSelectedListener(itemSelectedListenerUnit);


        AdapterView.OnItemSelectedListener itemSelectedListenerClass = new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if(rang>=2) {
                    // Получаем выбранный объект
                    String item = (String) parent.getItemAtPosition(position);
                    selectionClass = item;
                    save.setVisibility(View.INVISIBLE);
                    if (!(item.equals("Choose Class"))) {
                        rang = 3;
                    } else {
                        LinearLayout table=(LinearLayout)findViewById(R.id.settable);
                        table.removeAllViews();
                        LinearLayout tableofnames=(LinearLayout)findViewById(R.id.settablenameoflearners);
                        tableofnames.removeAllViews();
                        rang = 2;
                    }
                }
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

        View.OnClickListener listener=new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switch (v.getId()){
                    case R.id.accept:
                        if(rang==3){
                            LinearLayout table=(LinearLayout)findViewById(R.id.settable);
                            table.removeAllViews();
                            LayoutInflater inflater = (LayoutInflater) getApplicationContext()
                                    .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                            LinearLayout LL = (LinearLayout) inflater.inflate(R.layout.tableofmarks,table, false);
                            LL.setTag("marks");
                            table.addView(LL);
                            setmarks(LL);
                            //
                            LinearLayout tableofnames=(LinearLayout)findViewById(R.id.settablenameoflearners);
                            tableofnames.removeAllViews();
                            LinearLayout LLnames = (LinearLayout) inflater.inflate(R.layout.tableoflearners,tableofnames, false);
                            LLnames.setTag("names");
                            tableofnames.addView(LLnames);
                            setlearners(LLnames);

                            //save.setVisibility(View.VISIBLE);
                        }
                        break;
                    case R.id.save:
                        if(rang==3){
                            System.out.println(tempclasses.get(tempclassint).getList()[0]);
                            System.out.println(electives.get(tempint).getMarks(tempclasses.get(tempclassint).getList()[0]).toString());
                            System.out.println(electives.get(tempint).getMarks(tempclasses.get(tempclassint).getList()[0])[0]);
                            System.out.println(electives.get(tempint).getMarks(tempclasses.get(tempclassint).getList()[0]).length);
                        }
                        break;
                }
            }
        };
        accept.setOnClickListener(listener);
        save.setOnClickListener(listener);







    }



    public void setmarks(View v){
        GridLayout grid=(GridLayout) findViewById(R.id.Grid);
        int y=tempclasses.get(tempclassint).Learners.length;
        int x=20;
        EditText matrixedittext[]=new EditText[x*y];
        for(int i=0;i<(y*x);i++){
            LayoutInflater inflater = (LayoutInflater) getApplicationContext()
                    .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            matrixedittext[i] = (EditText) inflater.inflate(R.layout.edittextcell, grid, false);
        }

        grid.setColumnCount(x);
        grid.setRowCount(y);
        grid.removeAllViews();
        grid.setBackgroundColor(getColor(R.color.orange));

        for(int i=0;i<(y*x);i++) {
            int tempi=i;
            matrixedittext[i].addTextChangedListener(new TextWatcher() {
                @Override
                public void beforeTextChanged(CharSequence s, int start, int count, int after) {

                }

                @Override
                public void onTextChanged(CharSequence s, int start, int before, int count) {

                }

                @Override
                public void afterTextChanged(Editable s) {
                    int indexofmark=tempi%x;
                    //индекс ученика
                    int tempLearner=tempi/x;
                    //заготовка массива под оценки
                    ArrayList<Mark> tempmarks=new ArrayList<Mark>();
                    //обновление инофрмации
                    //electives.get(tempint).UpdateAllMarksOfLearners2();
                    //electives.get(tempint).UpdateAllMarksOfLearners2(x);
                    //сбор старых оценок

                    if (selectionElS.equals("Elective")) {
                        for (int j = 0; j < electives.get(tempint).getMarks(tempclasses.get(tempclassint).getList()[tempLearner]).length; j++) {
                            tempmarks.add(electives.get(tempint).getMarks(tempclasses.get(tempclassint).getList()[tempLearner])[j]);
                        }
                    }else{
                        for (int j = 0; j < sections.get(tempint).getMarks(tempclasses.get(tempclassint).getList()[tempLearner]).length; j++) {
                            tempmarks.add(sections.get(tempint).getMarks(tempclasses.get(tempclassint).getList()[tempLearner])[j]);
                        }
                    }
                    while(tempmarks.size()<20){
                        tempmarks.add(new Mark("","",-1,tempclasses.get(tempclassint).getList()[tempLearner].getCardID()));
                    }
                    Mark mark;
                    if (selectionElS.equals("Elective")) {
                        mark = new Mark(s.toString(), electives.get(tempint).getAcademicSubject(), 20210201, tempclasses.get(tempclassint).getList()[tempLearner].getCardID());
                    }else{
                        mark = new Mark(s.toString(), sections.get(tempint).getName(), 20210201, tempclasses.get(tempclassint).getList()[tempLearner].getCardID());

                    }
                    if(!(s.toString().equals(""))) {
                        tempmarks.set(indexofmark,mark);
                    }else{
                        tempmarks.remove(indexofmark);
                    }
                    if (selectionElS.equals("Elective")) {
                        electives.get(tempint).setMarks(tempclasses.get(tempclassint).getList()[tempLearner], tempmarks);
                    }else{
                        sections.get(tempint).setMarks(tempclasses.get(tempclassint).getList()[tempLearner], tempmarks);

                    }
                }
            });
        }
        for(int i=0;i<(y*x);i++) {
            int tempi=i;
            int indexofmark=tempi%x;
            //индекс ученика
            int tempLearner=tempi/x;
            //заготовка массива под оценки
            ArrayList<Mark> tempmarks=new ArrayList<Mark>();
            //обновление инофрмации
            //electives.get(tempint).UpdateAllMarksOfLearners1();
            //electives.get(tempint).UpdateAllMarksOfLearners2();
            //сбор старых оценок
            if (selectionElS.equals("Elective")) {
                for (int j = 0; j < electives.get(tempint).getMarks(tempclasses.get(tempclassint).getList()[tempLearner]).length; j++) {
                    tempmarks.add(electives.get(tempint).getMarks(tempclasses.get(tempclassint).getList()[tempLearner])[j]);
                }
            }else{
                for (int j = 0; j < sections.get(tempint).getMarks(tempclasses.get(tempclassint).getList()[tempLearner]).length; j++) {
                    tempmarks.add(sections.get(tempint).getMarks(tempclasses.get(tempclassint).getList()[tempLearner])[j]);
                }
            }
            while(tempmarks.size()<20){
                tempmarks.add(new Mark("","",-1,tempclasses.get(tempclassint).getList()[tempLearner].getCardID()));
            }
            matrixedittext[i].setText(tempmarks.get(indexofmark).getMark());
            matrixedittext[i].setTag(i);
            grid.addView(matrixedittext[i]);
        }

    }
    public void setlearners(View v){
        GridLayout grid=(GridLayout) findViewById(R.id.Grid);
        int y=tempclasses.get(tempclassint).Learners.length;
        int x=1;
        TextView matrixedittext[]=new TextView[y];
        for(int i=0;i<(y*x);i++){
            LayoutInflater inflater = (LayoutInflater) getApplicationContext()
                    .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            matrixedittext[i] = (TextView) inflater.inflate(R.layout.nameoflearnerscell, grid, false);
            matrixedittext[i].setText(tempclasses.get(tempclassint).Learners[i].getFullName());
        }

        grid.setColumnCount(x);
        grid.setRowCount(y);
        grid.removeAllViews();
        grid.setBackgroundColor(getColor(R.color.orange));
        for(int i=0;i<(y*x);i++) {
            matrixedittext[i].setTag(i);
            grid.addView(matrixedittext[i]);

        }
    }
    public void secondchoose(){
        ArrayAdapter<String> adapterunit;
            if (selectionElS.equals("Elective")) {
                String[] strelectives = new String[electives.size()+1];
                strelectives[0]="Choose Unit";
                for (int i = 0; i < electives.size(); i++) {
                    strelectives[i+1] = electives.get(i).getAcademicSubject();
                }
                adapterunit = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, strelectives);
            } else {
                String[] strsections = new String[sections.size()+1];
                strsections[0]="Choose Unit";
                if(!(selectionElS.equals("Choose"))) {
                    for (int i = 0; i < sections.size(); i++) {
                        strsections[i + 1] = sections.get(i).getName();
                    }
                }
                adapterunit = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, strsections);
            }
        adapterunit.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        SpinUnits.setAdapter(adapterunit);


    }
    public void thirdchoose() {
        if(!(selectionElS.equals("Choose"))){
            if (selectionElS.equals("Elective")) {

                for (int i = 0; i < electives.size(); i++) {
                    if (selectionUnit.equals(electives.get(i).getAcademicSubject())) {
                        tempint = i;
                    }
                }
                for (int i = 0; i < classes.size(); i++) {
                    for (int j = 0; j < classes.get(i).getdefaultElective().length; j++) {
                        if (selectionUnit.equals(classes.get(i).getdefaultElective()[j].getAcademicSubject())) {
                            tempclasses.add(classes.get(i));
                        }
                    }
                }
            } else {
                for (int i = 0; i < sections.size(); i++) {
                    if (selectionUnit.equals(sections.get(i).getName())) {
                        tempint = i;
                    }
                }
                for (int i = 0; i < classes.size(); i++) {
                    for (int j = 0; j < classes.get(i).getdefaultSection().length; j++)
                        if (selectionUnit.equals(classes.get(i).getdefaultSection()[j].getName())) {
                            tempclasses.add(classes.get(i));
                        }
                }
            }
        }
        String[] strclasses = new String[tempclasses.size()+1];
            strclasses[0]="Choose Class";
        for (int i = 0; i < tempclasses.size(); i++) {
            strclasses[i+1] = tempclasses.get(i).getNumber();
        }

        ArrayAdapter<String> adapterClass = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, strclasses);
        // Определяем разметку для использования при выборе элемента
        adapterClass.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        // Применяем адаптер к элементу spinner
        SpinClass.setAdapter(adapterClass);
    }
}
