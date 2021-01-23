package com.example.dairy;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class AdapterElchoose  extends RecyclerView.Adapter<AdapterElchoose.ViewHolder>{
    private int staticTag=0;
    private final LayoutInflater inflater;
    private final List<Elective> classes;


    AdapterElchoose(Context context, List<Elective> classes) {
        this.classes = classes;
        this.inflater = LayoutInflater.from(context);
    }

    public AdapterElchoose.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = inflater.inflate(R.layout.itemconectionforotherunits, parent, false);
        view.setTag(staticTag);
        staticTag++;
        return new AdapterElchoose.ViewHolder(view);
    }


    @Override
    public void onBindViewHolder(AdapterElchoose.ViewHolder holder, int position) {
        Elective classroom = classes.get(position);
        holder.nameView.setText(classroom.getAcademicSubject());
        holder.describeView.setText(classroom.getClassTeacher().FullName+" / "+classroom.getList().length+" / "+staticTag);
        holder.checkBox.setTag(staticTag-1);

    }

    @Override
    public int getItemCount() {
        return classes.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        final TextView nameView, describeView;
        CheckBox checkBox;
        ViewHolder(View view){
            super(view);
            nameView = (TextView) view.findViewById(R.id.name);
            describeView = (TextView) view.findViewById(R.id.describe);
            checkBox=(CheckBox) view.findViewById(R.id.checkbox);
        }
    }
}
