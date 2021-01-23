package com.example.dairy;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class AdapterSchoose  extends RecyclerView.Adapter<AdapterSchoose.ViewHolder>{
    private int staticTag=0;
    private final LayoutInflater inflater;
    private final List<Section> classes;

    AdapterSchoose(Context context, List<Section> classes) {
        this.classes = classes;
        this.inflater = LayoutInflater.from(context);
    }

    public AdapterSchoose.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = inflater.inflate(R.layout.itemconectionforotherunits, parent, false);
        view.setTag(staticTag);
        staticTag++;

        return new AdapterSchoose.ViewHolder(view);
    }





    @Override
    public void onBindViewHolder(AdapterSchoose.ViewHolder holder, int position) {
        Section classroom = classes.get(position);
        holder.nameView.setText(classroom.getName());
        holder.describeView.setText(classroom.getClassTeacher().FullName+" / "+classroom.getList().length);

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
