package com.example.isthateasy2;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.isthateasy2.adapters.ContactAdapter;
import com.example.isthateasy2.models.Contact;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link HomeFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class HomeFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";



    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    RecyclerView recyclerView;
    List<Contact> contactList;
    ContactAdapter contactAdapter;

    public HomeFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment HomeFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static HomeFragment newInstance(String param1, String param2) {
        HomeFragment fragment = new HomeFragment();
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
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_home, container, false);
        recyclerView=(RecyclerView) view.findViewById(R.id.recyclerView);
        loadContact();
        contactAdapter=new ContactAdapter(contactList);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(view.getContext()));
        recyclerView.setVerticalScrollBarEnabled(true);
        recyclerView.setAdapter(contactAdapter);
        return view;
    }
    public void loadContact(){
        contactList=new ArrayList<Contact>();
        contactList.add(new Contact("Kwizera","07888888",""));
        contactList.add(new Contact("Kwizera J","07888888",""));
        contactList.add(new Contact("Kwizera A","07888888",""));
        contactList.add(new Contact("Kwizera B","07888888",""));
        contactList.add(new Contact("Kwizera H","07888888",""));
        contactList.add(new Contact("Kwizera 4","07888888",""));
        contactList.add(new Contact("Kwizera 8","07888888",""));
        contactList.add(new Contact("Kwizera 6","07888888",""));
        contactList.add(new Contact("Kwizera B","07888888",""));
        contactList.add(new Contact("Kwizera V","07888888",""));
        contactList.add(new Contact("Kwizera C","07888888",""));
        contactList.add(new Contact("Kwizera M","07888888",""));
        contactList.add(new Contact("Kwizera X","07888888",""));
    }
}