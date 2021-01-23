package com.example.dairy;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;

import androidx.annotation.IdRes;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;


public class MyConectionClassAndOtherUnits extends AppCompatActivity {
    MyOtherUnitsSociety mous=new MyOtherUnitsSociety();
    MyClass mc=new MyClass();
    int temptag =-1;
    Class tempclass;
    ArrayList<Class> classes=new ArrayList<Class>();
    ArrayList<Section> sections=new ArrayList<Section>();
    ArrayList<Elective> electives=new ArrayList<Elective>();

    ArrayList<Section> tempsections=new ArrayList<Section>();
    ArrayList<Elective> tempelectives=new ArrayList<Elective>();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.creatconectionclassandotherunit);

        electives=mous.getElectives();

        sections=mous.getSections();

        classes=mc.getClasses();
        Button accept=(Button) findViewById(R.id.accept);

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
                            tempclass.setdefaultElective(tempelectives);
                            System.out.println(tempelectives);
                            tempclass.setdefaultSection(tempsections);
                            classes.set(temptag, tempclass);
                            mc.setClasses(classes);

                        }
                            break;

                }
            }
        };
        accept.setOnClickListener(listener);

    }
    public void OnClickList(View v) {
        tempelectives.clear();
        tempsections.clear();
        temptag=(int)v.getTag();
        tempclass=classes.get(temptag);
        RecyclerView rwlistel=(RecyclerView) findViewById(R.id.listEl);
        System.out.println(tempclass.getdefaultElective().length);
        RecyclerView recyclerViewEl = (RecyclerView) findViewById(R.id.listEl);
        RecyclerView recyclerViewS = (RecyclerView) findViewById(R.id.listS);
        ArrayList<Elective> templistEl=new ArrayList<Elective>();
        ArrayList<Section> templistS=new ArrayList<Section>();
        for(Elective elective: electives){
                templistEl.add(elective);
        }
        AdapterElchoose adapter = new AdapterElchoose(MyConectionClassAndOtherUnits.this, templistEl);
        recyclerViewEl.setAdapter(adapter);

        for(int i=0;i<electives.size();i++){
            int ok=0;
            for(Elective defaultelective: tempclass.getdefaultElective()){
                if(electives.get(i)==defaultelective){
                    ok=1;
                    ConstraintLayout Cl=(ConstraintLayout) rwlistel.getChildAt(i);
                    CheckBox checkBox=(CheckBox) Cl.findViewWithTag(Cl.getTag());
                    System.out.println(checkBox);
                    checkBox.isChecked();
                }
            }
        }
        for(Section section: sections){
            int ok=0;
            for(Section defaultsection: tempclass.getdefaultSection()){
                if(section==defaultsection){
                    ok=1;
                }
            }
            if(ok==1){
                templistS.add(section);
                AdapterSchoose adapters = new AdapterSchoose(MyConectionClassAndOtherUnits.this, templistS);
                recyclerViewS.setAdapter(adapter);
            }else{
                templistS.add(section);
                AdapterSchoose adapters = new AdapterSchoose(MyConectionClassAndOtherUnits.this, templistS);
                recyclerViewS.setAdapter(adapter);
            }
        }

    }
    public void Paint(View view){
        CheckBox checkBox=(CheckBox) view;
        System.out.println(((ConstraintLayout)view.getParent()).getTag());
        tempclass=classes.get(temptag);
        if(checkBox.isChecked()){
            checkBox.setBackgroundColor(getColor(R.color.teal_200));
            tempelectives.add(electives.get((int)checkBox.getTag()));

        }
        else{
            checkBox.setBackgroundColor(getColor(R.color.defaultwhite));
            tempelectives.remove(electives.get((int)checkBox.getTag()));
        }
    }
    /*public void PaintS(View view){
        CheckBox checkBox=(CheckBox) findViewById(view.getId());
        System.out.println(view.getId());
        ConstraintLayout head=(ConstraintLayout) checkBox.getParent();
        Class tempclass=classes.get(temptag);
        if(checkBox.isChecked()){
            head.setBackgroundColor(getColor(R.color.teal_200));
            tempsections.add(sections.get((int)head.getTag()));

        }
        else{
            head.setBackgroundColor(getColor(R.color.defaultwhite));
        }
    }*/

}
