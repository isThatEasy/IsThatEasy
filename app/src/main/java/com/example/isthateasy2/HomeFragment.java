package com.example.isthateasy2;

import android.os.Build;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.isthateasy2.adapters.ContactAdapter;
import com.example.isthateasy2.adapters.TaskAdapter;
import com.example.isthateasy2.models.Contact;
import com.example.isthateasy2.models.Question;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
    FirebaseFirestore db = FirebaseFirestore.getInstance();
    String testingClassId = "Ysqx4oNwLoBypiBaKp1G";



    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    private static final String TAG = "HomePage";

    RecyclerView recyclerView;
    List<com.example.isthateasy2.models.Task> taskList;
    TaskAdapter taskAdapter;

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
        taskList = new ArrayList<>();

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_home, container, false);
        recyclerView=(RecyclerView) view.findViewById(R.id.recyclerView);
        loadTasks();
//        contactAdapter=new ContactAdapter(contactList);
        taskAdapter = new TaskAdapter(taskList);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(view.getContext()));
        recyclerView.setVerticalScrollBarEnabled(true);

        return view;
    }
    public void loadTasks(){

        db.collection("tasks").document("P1").collection("Math")
                .get()
                .addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                    @RequiresApi(api = Build.VERSION_CODES.N)
                    @Override
                    public void onComplete(@NonNull Task<QuerySnapshot> task) {
                        if (task.isSuccessful()) {
                            for (QueryDocumentSnapshot document : task.getResult()) {
                                com.example.isthateasy2.models.Task task1 = convertHashMapToTask(document.getData());
//                                        document.toObject(com.example.isthateasy2.models.Task.class);
                                taskList.add(task1);

                            }
                            recyclerView.setAdapter(taskAdapter);
                        } else {
                            Log.d(TAG, "Error getting documents: ", task.getException());
                        }
                    }
                });

//        taskList=new ArrayList<Task>();
//        taskList.add(new Task( "title1", "level1", "course1", "topic1", "teacherName1", "description1"));
//        taskList.add(new Task( "title2", "level2", "course2", "topic2", "teacherName2", "description2"));
//        taskList.add(new Task( "title3", "level3", "course3", "topic3", "teacherName3", "description3"));
//        taskList.add(new Task( "title4", "level4", "course4", "topic4", "teacherName4", "description4"));
    }
    @RequiresApi(api = Build.VERSION_CODES.N)
    public com.example.isthateasy2.models.Task convertHashMapToTask(Map<String, Object> map){

        com.example.isthateasy2.models.Task task = new com.example.isthateasy2.models.Task();
        task.setClassName((String)map.get("className"));
        task.setCourse((String)map.get("course"));
        task.setLevel((String)map.get("level"));
        task.setTopic((String)map.get("topic"));
        task.setDescription((String)map.get("description"));
        task.setTitle((String)map.get("title"));
        task.setTeacherName((String)map.get("teacherName"));

        ArrayList<Map<String, Object>> qtns=(ArrayList<Map<String, Object>>) map.get("questions");
        qtns.forEach(qtn ->{
            Question question = new Question();
            question.setOptions((ArrayList<String>) qtn.get("options"));
            question.setQuestion((String)qtn.get("question"));
            question.setWayOfAnswering((String) qtn.get("wayOfAnswering"));
            question.setMarks((String) qtn.get("marks"));
            question.setAnswer((String) qtn.get("answer"));

            task.addQuestion(question);
        });

        return task;

    }
}
