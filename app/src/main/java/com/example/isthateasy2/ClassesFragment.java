package com.example.isthateasy2;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.isthateasy2.adapters.SubClassAdapter;
import com.example.isthateasy2.models.Classes;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link ClassesFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class ClassesFragment extends Fragment {
    RecyclerView recyclerView;
    List<Classes> taskList;
    SubClassAdapter subClassAdapter;

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public ClassesFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment ClassesFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static ClassesFragment newInstance(String param1, String param2) {
        ClassesFragment fragment = new ClassesFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_classes, container, false);
        recyclerView=(RecyclerView) view.findViewById(R.id.recyclerView_classes);
        loadSubClasses();
//        contactAdapter=new ContactAdapter(contactList);
        subClassAdapter = new SubClassAdapter(taskList);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(view.getContext()));
        recyclerView.setVerticalScrollBarEnabled(true);
        recyclerView.setAdapter(subClassAdapter);
        return view;
    }
    public void loadSubClasses(){
        taskList=new ArrayList<Classes>();
        taskList.add(new Classes( "TeacherName", "School name ", "notfications"));
        taskList.add(new Classes( "TeacherName2", "School name2 ", "notfications2"));

    }
}