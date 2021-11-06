package com.example.isthateasy2.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.isthateasy2.R;
import com.example.isthateasy2.models.Classes;

import java.util.List;

public class SubClassAdapter extends RecyclerView.Adapter<SubClassViewHolder> {
    List<Classes> classes;
    SubClassViewHolder subClassViewHolder;

    public SubClassAdapter(List<Classes> classes) {
        this.classes = classes;
    }

    @NonNull
    @Override
    public SubClassViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.row_classes,parent,false);
        return new SubClassViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull SubClassViewHolder holder, int position) {
        final Classes classes = this.classes.get(position);
        holder.bind(classes);
        subClassViewHolder=holder;
    }

    @Override
    public int getItemCount() {
        return classes.size();
    }
}
