package com.example.dairy;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class AdapterS  extends RecyclerView.Adapter<AdapterS.ViewHolder>{
    private int staticTag=0;
    private String TagId="S";
    private final LayoutInflater inflater;
    private final List<Section> classes;

    AdapterS(Context context, List<Section> classes) {
        this.classes = classes;
        this.inflater = LayoutInflater.from(context);
    }
    @Override
    public AdapterS.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = inflater.inflate(R.layout.itemsection, parent, false);
        view.setTag(staticTag);
        staticTag++;
        return new AdapterS.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(AdapterS.ViewHolder holder, int position) {
        Section classroom = classes.get(position);
        holder.nameView.setText(classroom.getName());
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
        ViewHolder(View view){
            super(view);
            nameView = (TextView) view.findViewById(R.id.name);
            describeView = (TextView) view.findViewById(R.id.describe);
            delete =(Button) view.findViewById(R.id.delete);

        }
    }
}
