package com.example.isthateasy2.adapters;

import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.isthateasy2.R;
import com.example.isthateasy2.models.Task;
import com.example.isthateasy2.states.IdGenerator;

public class TaskViewHolder extends RecyclerView.ViewHolder {
    TextView course,level, teacherName, title, description,topic;
    Button attempt;

    public TaskViewHolder(@NonNull View itemView) {
        super(itemView);
        course=(TextView)itemView.findViewById(R.id.task_Course);
        level=(TextView)itemView.findViewById(R.id.class_teacher_name);
        teacherName=(TextView) itemView.findViewById(R.id.task_TeacherName);
        title=(TextView) itemView.findViewById(R.id.class_name);
        description=(TextView) itemView.findViewById(R.id.task_Description);
        topic = (TextView) itemView.findViewById(R.id.topicTextViewTaskRow);
        attempt = (Button) itemView.findViewById(R.id.class_Enter);

    }
    public void bind(final Task Task){
        //setting id
        int id = IdGenerator.getNewButtonId();
        itemView.setId(id);
        Task.setId(id);

        course.setText(Task.getCourse());
        level.setText(Task.getLevel());
        teacherName.setText(Task.getTeacherName());
        title.setText(Task.getTitle());
        description.setText(Task.getDescription());
        topic.setText(Task.getTopic());
        attempt.setTag(Task.getId());
    }
}
