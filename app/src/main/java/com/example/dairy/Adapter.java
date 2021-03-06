package com.example.dairy;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class Adapter  extends RecyclerView.Adapter<Adapter.ViewHolder>{
    private int staticTag=0;
    private final LayoutInflater inflater;
    private final List<Class> classes;
    private boolean withDelete=true;

    Adapter(Context context, List<Class> classes) {
        this.classes = classes;
        this.inflater = LayoutInflater.from(context);
        this.withDelete=withDelete;
    }
    @Override
    public Adapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = inflater.inflate(R.layout.item, parent, false);
            view.setTag(staticTag);
            staticTag++;
            return new ViewHolder(view);

    }

    @Override
    public void onBindViewHolder(Adapter.ViewHolder holder, int position) {
        Class classroom = classes.get(position);
        holder.nameView.setText(classroom.getNumber());
        holder.describeView.setText(classroom.getClassTeacher().getFullName()+" / "+classroom.getList().length);
        holder.delete.setTag(staticTag-1);
    }

    @Override
    public int getItemCount() {
        return classes.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        final TextView nameView, describeView;
        Button delete;
        ViewHolder(View view){
            super(view);
            nameView = (TextView) view.findViewById(R.id.name);
            describeView = (TextView) view.findViewById(R.id.describe);
            delete =(Button) view.findViewById(R.id.delete);

        }
    }
}
