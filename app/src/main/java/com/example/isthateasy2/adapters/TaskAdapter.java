package com.example.isthateasy2.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.isthateasy2.R;
import com.example.isthateasy2.models.Contact;
import com.example.isthateasy2.models.Task;

import java.util.List;

public class TaskAdapter extends RecyclerView.Adapter<TaskViewHolder> {
    List<Task> tasks;
    TaskViewHolder taskViewHolder;
    Button attempt;
    public static View.OnClickListener selectingTaskListener;

    public void setListener(View.OnClickListener listener){
        selectingTaskListener = listener;
    }

    public TaskAdapter(List<Task> tasks) {
        this.tasks = tasks;
    }

    public TaskAdapter(List<Task> tasks, View.OnClickListener listener) {
        this.tasks = tasks;
        selectingTaskListener = listener;
    }

    @NonNull
    @Override
    public TaskViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.row_task,parent,false);

        view.setOnClickListener(selectingTaskListener);
        attempt = view.findViewById(R.id.class_Enter);
        attempt.setOnClickListener(selectingTaskListener);
        return new TaskViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull TaskViewHolder holder, int position) {
        final Task task=tasks.get(position);
        holder.bind(task);
        taskViewHolder=holder;
    }

    @Override
    public int getItemCount() {
        return tasks.size();
    }
}
