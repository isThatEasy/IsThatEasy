package com.example.isthateasy2.adapters;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.isthateasy2.R;
import com.example.isthateasy2.models.Classes;

public class SubClassViewHolder extends RecyclerView.ViewHolder {
    TextView teacherName, schoolName, notification;
    ImageView image;
    public SubClassViewHolder(@NonNull View itemView) {
        super(itemView);
        teacherName=(TextView)itemView.findViewById(R.id.class_teacher_name);
        schoolName=(TextView)itemView.findViewById(R.id.school_name);
        notification=(TextView)itemView.findViewById(R.id.classes_notifications);
//        image=(ImageView) itemView.findViewById(R.id.image);
    }
    public void bind(final Classes classes){
        teacherName.setText(classes.getTeacherName());
        schoolName.setText(classes.getSchoolName());
        notification.setText(classes.getNotification());
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
