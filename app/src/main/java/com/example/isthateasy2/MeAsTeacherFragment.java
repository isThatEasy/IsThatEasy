package com.example.isthateasy2;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.PopupWindow;

import com.example.isthateasy2.adapters.TaskAdapter;
import com.example.isthateasy2.models.Task;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link MeAsTeacherFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class MeAsTeacherFragment extends Fragment {
    RecyclerView recyclerView;
    List<Task> taskList;
    TaskAdapter taskAdapter;
    Button showPopupBtn, closePopupBtn, showPopupBtnLevel,closePopupBtnLevel;
    PopupWindow popupWindow;
    LinearLayout linearLayout1;

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public MeAsTeacherFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment MeAsTeacherFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static MeAsTeacherFragment newInstance(String param1, String param2) {
        MeAsTeacherFragment fragment = new MeAsTeacherFragment();
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
        View view = inflater.inflate(R.layout.fragment_me_as_teacher, container, false);

        LinearLayoutManager layoutManager = new LinearLayoutManager(view.getContext(), LinearLayoutManager.HORIZONTAL, false);
        recyclerView= view.findViewById(R.id.teacherRecyclerView);

        loadTasks();
//        contactAdapter=new ContactAdapter(contactList);
        taskAdapter = new TaskAdapter(taskList);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setVerticalScrollBarEnabled(true);
        recyclerView.setAdapter(taskAdapter);
        View addLevelPopupView = LayoutInflater.from(getActivity()).inflate(R.layout.add_new_level, null);
        final PopupWindow popupWindowLevel = new PopupWindow(addLevelPopupView, WindowManager.LayoutParams.MATCH_PARENT, WindowManager.LayoutParams.MATCH_PARENT);

        showPopupBtnLevel = view.findViewById(R.id.add_level);
        showPopupBtnLevel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                popupWindowLevel.showAsDropDown(addLevelPopupView, 0, 0);
                closePopupBtnLevel = addLevelPopupView.findViewById(R.id.closePopupBtnLevel);

                closePopupBtnLevel.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        popupWindowLevel.dismiss();
                    }
                });

            }
        });





        View popupView = LayoutInflater.from(getActivity()).inflate(R.layout.add_task_popup, null);
        final PopupWindow popupWindow = new PopupWindow(popupView, WindowManager.LayoutParams.MATCH_PARENT, WindowManager.LayoutParams.MATCH_PARENT);

        showPopupBtn = view.findViewById(R.id.add_task);
        showPopupBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                popupWindow.showAsDropDown(popupView, 0, 0);
                closePopupBtn = (Button) popupView.findViewById(R.id.closePopupBtn);

                closePopupBtn.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        popupWindow.dismiss();
                    }
                });

            }
        });


        return view;
    }
    public void loadTasks(){
        taskList=new ArrayList<Task>();
        taskList.add(new Task( "title1", "level1", "course1", "topic1", "teacherName1", "description1"));
        taskList.add(new Task( "title2", "level2", "course2", "topic2", "teacherName2", "description2"));
        taskList.add(new Task( "title3", "level3", "course3", "topic3", "teacherName3", "description3"));
        taskList.add(new Task( "title4", "level4", "course4", "topic4", "teacherName4", "description4"));
    }
}