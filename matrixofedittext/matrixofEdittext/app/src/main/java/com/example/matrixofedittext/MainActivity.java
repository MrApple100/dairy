package com.example.matrixofedittext;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ActionBar;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.widget.Button;
import android.widget.EditText;
import android.widget.GridLayout;
import android.widget.LinearLayout;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        GridLayout grid=(GridLayout) findViewById(R.id.Grid);
        int y=10;
        int x=10;
        Button matrixedittext[]=new Button[x*y];
        for(int i=0;i<(y*x);i++){
            //matrixedittext[i]=new EditText(this);
           // matrixedittext[i]=(EditText) inf(R.id.edittextbox);
            LayoutInflater inflater = (LayoutInflater) getApplicationContext()
                    .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            matrixedittext[i] = (Button) inflater.inflate(R.layout.cell, grid, false);
            //matrixedittext[i].setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT));
        }

        System.out.println(x+" "+y);
        grid.setColumnCount(x);
        grid.setRowCount(y);
        grid.removeAllViews();
        grid.setBackgroundColor(getColor(R.color.purple_200));
        for(int i=0;i<(y*x);i++) {
            grid.addView(matrixedittext[i]);
            matrixedittext[i].setId(i);
            //matrixedittext[i].setWidth(10);
            //matrixedittext[i].setHeight(15);
            //matrixedittext[i].setSingleLine(true);
            //matrixedittext[i].setBackgroundColor(getColor(R.color.purple_200));;
        }
    }
}