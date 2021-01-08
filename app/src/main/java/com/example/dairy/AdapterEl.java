package com.example.dairy;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class AdapterEl  extends RecyclerView.Adapter<Adapter.ViewHolder>{
    private int staticTag=0;
    private String TagIdconst="El";
    private final LayoutInflater inflater;
    private final List<Elective> classes;

    AdapterEl(Context context, List<Elective> classes) {
        this.classes = classes;
        this.inflater = LayoutInflater.from(context);
    }
    @Override
    public Adapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = inflater.inflate(R.layout.itemelective, parent, false);
        view.setTag(staticTag);
        staticTag++;

        return new Adapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(Adapter.ViewHolder holder, int position) {
        Elective classroom = classes.get(position);
        holder.nameView.setText(classroom.getAcademicSubject());
        holder.describeView.setText(classroom.getClassTeacher().FullName+" / "+classroom.getList().length);
        holder.delete.setTag(staticTag-1);
    }

    @Override
    public int getItemCount() {
        return classes.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        final TextView nameView, describeView;
        Button delete;
        String Tagid;
        ViewHolder(View view){
            super(view);
            nameView = (TextView) view.findViewById(R.id.name);
            describeView = (TextView) view.findViewById(R.id.describe);
            delete =(Button) view.findViewById(R.id.delete);
            Tagid="El";

        }
    }
}
