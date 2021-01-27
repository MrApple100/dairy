package com.example.dairy;


import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class AdapterSchoose  extends RecyclerView.Adapter<AdapterSchoose.ViewHolder>{
    private int staticTag=0;
    private final LayoutInflater inflater;
    private final List<Section> classes;
    private SavePaint savinglist;

    AdapterSchoose(Context context, List<Section> classes, ArrayList<Integer> savinglist) {
        this.savinglist= new SavePaint(savinglist);
        this.classes = classes;
        this.inflater = LayoutInflater.from(context);
    }

    public SavePaint getSavinglist() {
        return savinglist;
    }

    public void setSavinglist(SavePaint savinglist) {
        this.savinglist = savinglist;
    }

    public AdapterSchoose.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = inflater.inflate(R.layout.itemconectionforotherunitss, parent, false);
        view.setTag(staticTag);
        staticTag++;

        return new AdapterSchoose.ViewHolder(view);
    }





    @Override
    public void onBindViewHolder(AdapterSchoose.ViewHolder holder, int position) {
        Section classroom = classes.get(position);
        holder.nameView.setText(classroom.getName());
        holder.describeView.setText(classroom.getClassTeacher().FullName+" / "+classroom.getList().length);
        holder.checkBox.setTag(staticTag-1);
        Integer zero=new Integer(0);
        if(savinglist.getSavinglist().get(staticTag-1).equals(zero)){
            holder.checkBox.setChecked(false);
            holder.checkBox.setBackgroundColor(Color.parseColor("#F2F0F6"));
        }else{
            holder.checkBox.setChecked(true);
            holder.checkBox.setBackgroundColor(Color.parseColor("#FF03DAC5"));
        }

    }

    @Override
    public int getItemCount() {
        return classes.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        final TextView nameView, describeView;
        final CheckBox checkBox;
        ViewHolder(View view){
            super(view);
            nameView = (TextView) view.findViewById(R.id.name);
            describeView = (TextView) view.findViewById(R.id.describe);
            checkBox=(CheckBox) view.findViewById(R.id.checkbox);
        }
    }
}
