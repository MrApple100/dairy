package com.example.dairy;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class AdapterwithoutDelete  extends RecyclerView.Adapter<AdapterwithoutDelete.ViewHolder>{
    private int staticTag=0;
    private final LayoutInflater inflater;
    private final List<Class> classes;

    AdapterwithoutDelete(Context context, List<Class> classes) {
        this.classes = classes;
        this.inflater = LayoutInflater.from(context);

    }
    @Override
    public AdapterwithoutDelete.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = inflater.inflate(R.layout.itemclasses, parent, false);
        view.setTag(staticTag);
        staticTag++;
        return new AdapterwithoutDelete.ViewHolder(view);

    }

    @Override
    public void onBindViewHolder(AdapterwithoutDelete.ViewHolder holder, int position) {
        Class classroom = classes.get(position);
        holder.nameView.setText(classroom.getNumber());
        holder.describeView.setText(classroom.getClassTeacher().getFullName()+" / "+classroom.getList().length);

    }

    @Override
    public int getItemCount() {
        return classes.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        final TextView nameView, describeView;
        ViewHolder(View view){
            super(view);
            nameView = (TextView) view.findViewById(R.id.name);
            describeView = (TextView) view.findViewById(R.id.describe);


        }
    }
}
