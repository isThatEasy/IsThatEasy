package com.example.isthateasy2.adapters;

import android.content.Intent;
import android.net.Uri;
import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.isthateasy2.R;
import com.example.isthateasy2.models.Task;

public class TaskViewHolder extends RecyclerView.ViewHolder {
    TextView course,level, teacherName, title, description;

    public TaskViewHolder(@NonNull View itemView) {
        super(itemView);
        course=(TextView)itemView.findViewById(R.id.task_Course);
        level=(TextView)itemView.findViewById(R.id.task_Level);
        teacherName=(TextView) itemView.findViewById(R.id.task_TeacherName);
        title=(TextView) itemView.findViewById(R.id.task_Title);
        description=(TextView) itemView.findViewById(R.id.task_Description);

    }
    public void bind(final Task Task){
        course.setText(Task.getCourse());
        level.setText(Task.getLevel());
        teacherName.setText(Task.getTeacherName());
        title.setText(Task.getTitle());
        description.setText(Task.getDescription());;
//        phone.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent intent=new Intent(Intent.ACTION_CALL);
//                intent.setData(Uri.parse("tel:"+phone.getText()));
//                itemView.getContext().startActivity(intent);
//            }
//        });
    }
}
