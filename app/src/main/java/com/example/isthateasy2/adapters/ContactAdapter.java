package com.example.isthateasy2.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import com.example.isthateasy2.R;
import com.example.isthateasy2.models.Contact;

public class ContactAdapter  extends RecyclerView.Adapter<ContactViewHolder> {
    List<Contact> contacts;
    ContactViewHolder contactViewHolder;

    public ContactAdapter(List<Contact> contacts) {
        this.contacts = contacts;
    }

    @NonNull
    @Override
    public ContactViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.row_contact,parent,false);
        return new ContactViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ContactViewHolder holder, int position) {
        final Contact contact=contacts.get(position);
        holder.bind(contact);
        contactViewHolder=holder;
    }

    @Override
    public int getItemCount() {
        return contacts.size();
    }
}
