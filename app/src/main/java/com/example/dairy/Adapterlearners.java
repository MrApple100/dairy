package com.example.dairy;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class Adapterlearners  extends RecyclerView.Adapter<Adapterlearners.ViewHolder>{
    private int staticTag=0;
    private final LayoutInflater inflater;
    private final List<Learner> learners;


    Adapterlearners(Context context, List<Learner> learners) {
        this.learners = learners;
        this.inflater = LayoutInflater.from(context);
    }
    @Override
    public Adapterlearners.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = inflater.inflate(R.layout.itemlearner, parent, false);
        view.setTag(staticTag);
        staticTag++;
        return new Adapterlearners.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(Adapterlearners.ViewHolder holder, int position) {
        Learner learner = learners.get(position);
        holder.nameView.setText(learner.getFullName());
        holder.describeView.setText(learner.getPhone()+" / "+learner.getCardID());
        holder.delete.setTag(staticTag-1);
    }

    @Override
    public int getItemCount() {
        return learners.size();
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
