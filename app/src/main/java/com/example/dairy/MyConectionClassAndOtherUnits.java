package com.example.dairy;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.LinearLayout;

import androidx.annotation.IdRes;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;


public class MyConectionClassAndOtherUnits extends AppCompatActivity {
    MySchool myschool=new MySchool();
    School school;
    MyOtherUnitsSociety mous=new MyOtherUnitsSociety();
    MyClass mc=new MyClass();
    int temptag =-1;
    Class tempclass;
    private static ArrayList<Class> classes=new ArrayList<Class>();
    private static ArrayList<Section> sections=new ArrayList<Section>();
    private static ArrayList<Elective> electives=new ArrayList<Elective>();

    ArrayList<Section> tempsections=new ArrayList<Section>();
    ArrayList<Elective> tempelectives=new ArrayList<Elective>();
    ArrayList<Integer> savinglistEl=new ArrayList<Integer>();
    ArrayList<Integer> savinglistS=new ArrayList<Integer>();

    public ArrayList<Class> getClasses() {
        return classes;
    }

    public void setClasses(ArrayList<Class> classes) {
        this.classes = classes;
    }

    public ArrayList<Section> getSections() {
        return sections;
    }

    public void setSections(ArrayList<Section> sections) {
        this.sections = sections;
    }

    public ArrayList<Elective> getElectives() {
        return electives;
    }

    public void setElectives(ArrayList<Elective> electives) {
        this.electives = electives;
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.creatconectionclassandotherunit);
        school=myschool.getSchool1();

        electives=mous.getElectives();

        sections=mous.getSections();

        classes=mc.getClasses();
        System.out.println(classes);
        Button accept=(Button) findViewById(R.id.accept);
        Button Next=(Button) findViewById(R.id.Next);

        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.listclasses);
        AdapterwithoutDelete adapterclasses = new AdapterwithoutDelete(MyConectionClassAndOtherUnits.this, classes);
        recyclerView.setAdapter(adapterclasses);
        View.OnClickListener listener=new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switch (v.getId()){
                    case R.id.accept:
                        if(temptag!=-1) {
                            tempclass = classes.get(temptag);
                            for(Elective elective:tempelectives){
                                elective.setLearners(tempclass.getList());
                            }
                            tempclass.setdefaultElective(tempelectives);
                            SavePaint savePaintEl=new SavePaint(savinglistEl);
                            SavePaint savePaintS=new SavePaint(savinglistS);
                            tempclass.setSavinglist(savePaintEl,0);
                            tempclass.setSavinglist(savePaintS,1);
                            for(Section section:tempsections){
                                section.setLearners(tempclass.getList());
                            }
                            tempclass.setdefaultSection(tempsections);
                            classes.set(temptag, tempclass);
                            mc.setClasses(classes);

                        }
                            break;
                    case R.id.Next:
                        for(Class classroom: classes){
                            school.addClasses(classroom);
                        }
                        for(Elective elective: electives){
                            school.addElective(elective);
                        }
                        for(Section section:sections){
                            school.addSection(section);
                        }
                        school.UpdateLearners();
                        myschool.setSchool1(school);
                        Intent intent=new Intent(MyConectionClassAndOtherUnits.this,MyMainCenter.class);
                        startActivity(intent);

                        break;

                }
            }
        };
        accept.setOnClickListener(listener);
        Next.setOnClickListener(listener);

    }
    public void OnClickList(View v) {
        tempelectives.clear();
        tempsections.clear();
        savinglistEl.clear();
        savinglistS.clear();
        temptag=(int)v.getTag();
        tempclass=classes.get(temptag);

        System.out.println(tempclass.getdefaultElective().length);
        RecyclerView recyclerViewEl = (RecyclerView) findViewById(R.id.listEl);
        RecyclerView recyclerViewS = (RecyclerView) findViewById(R.id.listS);
        ArrayList<Elective> templistEl=new ArrayList<Elective>();
        ArrayList<Section> templistS=new ArrayList<Section>();


        for(Elective elective: electives){
                templistEl.add(elective);
        }
        for(int i=0;i<electives.size();i++){
            int ok=0;
            for(Elective defaultelective: tempclass.getdefaultElective()){
                if(electives.get(i).getAcademicSubject().equals(defaultelective.getAcademicSubject())){
                    ok=1;
                }
            }
            if(ok==1){
                savinglistEl.add(1);
            }else{
                savinglistEl.add(0);
            }
        }
        AdapterElchoose adapterEl = new AdapterElchoose(MyConectionClassAndOtherUnits.this, templistEl,savinglistEl);
        recyclerViewEl.setAdapter(adapterEl);
        for(Section section: sections){
            templistS.add(section);
        }
        for(int i=0;i<sections.size();i++){
            int ok=0;
            for(Section defaultsection: tempclass.getdefaultSection()){
                if(sections.get(i).getName().equals(defaultsection.getName())){
                    ok=1;
                }
            }
            if(ok==1){
                savinglistS.add(1);
            }else{
                savinglistS.add(0);
            }
        }
        AdapterSchoose adapterS = new AdapterSchoose(MyConectionClassAndOtherUnits.this, templistS,savinglistS);
        recyclerViewS.setAdapter(adapterS);



    }
    public void PaintS(View view){
        CheckBox checkBox=(CheckBox) view;
        tempclass=classes.get(temptag);

        if(checkBox.isChecked()){
            checkBox.setBackgroundColor(getColor(R.color.teal_200));
            System.out.println((int)view.getTag());
            tempsections.add(sections.get((int)checkBox.getTag()));
            savinglistS.set((int)checkBox.getTag(),1);
        }
        else{
            checkBox.setBackgroundColor(getColor(R.color.defaultwhite));
            tempsections.remove(sections.get((int)checkBox.getTag()));
            savinglistS.set((int)checkBox.getTag(),0);

        }
    }
    public void PaintEl(View view){
        CheckBox checkBox=(CheckBox) view;
        tempclass=classes.get(temptag);


        if(checkBox.isChecked()){
            checkBox.setBackgroundColor(getColor(R.color.teal_200));
            tempelectives.add(electives.get((int)checkBox.getTag()));
            savinglistEl.set((int)checkBox.getTag(),1);
        }
        else{
            checkBox.setBackgroundColor(getColor(R.color.defaultwhite));
            tempelectives.remove(electives.get((int)checkBox.getTag()));
            savinglistEl.set((int)checkBox.getTag(),0);

        }

    }


}
