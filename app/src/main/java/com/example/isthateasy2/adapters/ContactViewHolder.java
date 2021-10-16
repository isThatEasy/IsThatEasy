package com.example.isthateasy2.adapters;

import android.content.Intent;
import android.net.Uri;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.isthateasy2.models.Contact;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.isthateasy2.R;

public class ContactViewHolder extends RecyclerView.ViewHolder {
    TextView name,phone;
    ImageView image;
    public ContactViewHolder(@NonNull View itemView) {
        super(itemView);
        name=(TextView)itemView.findViewById(R.id.name);
        phone=(TextView)itemView.findViewById(R.id.phone);
        image=(ImageView) itemView.findViewById(R.id.image);
    }
    public void bind(final Contact contact){
        name.setText(contact.getName());
        phone.setText(contact.getPhone());
        phone.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(Intent.ACTION_CALL);
                intent.setData(Uri.parse("tel:"+phone.getText()));
                itemView.getContext().startActivity(intent);
            }
        });
    }
}
