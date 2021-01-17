package com.example.dairy;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MyConectionClassandLearners extends AppCompatActivity {
    private ArrayList<Class> classes = new ArrayList<Class>();
    private int temptag=-1;

    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.creatlearner);
        MyClass classinthere=new MyClass();
        classes=classinthere.getClasses();
        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.listclasses2);
        AdapterwithoutDelete adapterclasses = new AdapterwithoutDelete(MyConectionClassandLearners.this, classes);
        recyclerView.setAdapter(adapterclasses);
        RecyclerView recyclerViewlearners = (RecyclerView) findViewById(R.id.listlearners);
        Button button=(Button) findViewById(R.id.button);
        Button add=(Button) findViewById(R.id.addlearner);

        EditText NameLearner=(EditText) findViewById(R.id.NameLearner);
        EditText Telphone=(EditText) findViewById(R.id.Telphone);
        View.OnClickListener listener=new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switch (v.getId()){
                    case R.id.addlearner:
                        ArrayList<Learner> templistlearners=new ArrayList<Learner>();
                        if(temptag>=0 && Telphone.getText().toString().length()>0 && NameLearner.getText().toString().length()>1){
                            int check=0;
                            Class tempclass=classes.get(temptag);
                            for(Learner learner: tempclass.getList()){
                                templistlearners.add(learner);
                            }
                            Learner learner = new Learner(NameLearner.getText().toString(), Long.parseLong(Telphone.getText().toString()));
                            for(int i=0;i<templistlearners.size();i++){
                                if((templistlearners.get(i).getFullName().toString()).equals(NameLearner.getText().toString())){
                                    templistlearners.get(i).setPhone( Long.parseLong(Telphone.getText().toString()));
                                    check=1;
                                }
                            }
                            if(check==0){
                                templistlearners.add(learner);
                            }
                            tempclass.setLearners(templistlearners);
                            Adapterlearners adapter = new Adapterlearners(MyConectionClassandLearners.this, templistlearners);
                            recyclerViewlearners.setAdapter(adapter);
                            NameLearner.setText("");
                            Telphone.setText("");
                        }
                        break;
                }
            }
        };
        add.setOnClickListener(listener);

    }
    public void OnClickList(View v) {
        temptag=(int)v.getTag();
        Class tempclass=classes.get(temptag);
        RecyclerView recyclerViewlearners = (RecyclerView) findViewById(R.id.listlearners);
        ArrayList<Learner> templistlearners=new ArrayList<Learner>();
        for(Learner learner: tempclass.getList()){
            templistlearners.add(learner);
        }
        Adapterlearners adapter = new Adapterlearners(MyConectionClassandLearners.this, templistlearners);
        recyclerViewlearners.setAdapter(adapter);
    }
    public void OnClickListLearner(View v) {
        EditText NameLearner=(EditText) findViewById(R.id.NameLearner);
        EditText Telphone=(EditText) findViewById(R.id.Telphone);
        Class tempclass=classes.get(temptag);
        ArrayList<Learner> templistlearners=new ArrayList<Learner>();
        for(Learner learner: tempclass.getList()){
            templistlearners.add(learner);
        }
        Learner templearner=templistlearners.get((int)v.getTag());

        NameLearner.setText(templearner.getFullName());
        Telphone.setText(templearner.getPhone()+"");
    }
    public void DELETElearner(View v){
        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.listlearners);
        ArrayList<Learner> templistlearners=new ArrayList<Learner>();
        Class tempclass=classes.get(temptag);
        for(Learner learner: tempclass.getList()){
            templistlearners.add(learner);
        }
        templistlearners.remove((int)v.getTag());
        tempclass.setLearners(templistlearners);
        Adapterlearners adapter = new Adapterlearners(MyConectionClassandLearners.this, templistlearners);
        recyclerView.setAdapter(adapter);
    }

}


