package com.example.isthateasy2;

import android.content.Intent;
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
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.isthateasy2.adapters.TaskAdapter;
import com.example.isthateasy2.models.Course;
import com.example.isthateasy2.models.Question;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.ArrayList;
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
    Spinner levelSelector, courseSelector;
    String selectedLevel="P1", selectedCourse="Math";
    ProgressBar progressBar;
    LinearLayout loadingPart;



    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    private static final String TAG = "HomePage";

    RecyclerView recyclerView;
    List<com.example.isthateasy2.models.Task> taskList;
    TaskAdapter taskAdapter;

    View.OnClickListener selectingTaskListener;

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

        loadingPart = view.findViewById(R.id.loadingPartInHome);

        levelSelector = view.findViewById(R.id.levelsSpinnerHome);
        courseSelector = view.findViewById(R.id.coursesSpinnerHome);


        levelSelector.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {

                loadingPart.addView(new ProgressBar(getContext()));
                selectedLevel = adapterView.getItemAtPosition(i).toString();

                loadTasks();
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
        courseSelector.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                selectedCourse = adapterView.getItemAtPosition(i).toString();

                loadingPart.addView(new ProgressBar(getContext()));
                loadTasks();

            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });









        recyclerView=(RecyclerView) view.findViewById(R.id.recyclerView);
        loadTasks();
//        contactAdapter=new ContactAdapter(contactList);

        // set listener to the view and button when clicked
        selectingTaskListener = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int id;
                if(view instanceof Button){
                    id = (int)view.getTag();
                }
                else {
                    id = view.getId();
                }
//            String item = mList.get(itemPosition);

                    com.example.isthateasy2.models.Task task = elementPicker(id,taskList);

                if(task != null){
                    Intent intent = new Intent(getContext(), QuizActivity.class);
                    intent.putExtra("task",task);
                    startActivity(intent);
                }
                else {
                    Toast.makeText(getContext(), "something bad happen, try again later", Toast.LENGTH_LONG).show();
                }



            }
        };


        taskAdapter = new TaskAdapter(taskList, selectingTaskListener);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(view.getContext()));
        recyclerView.setVerticalScrollBarEnabled(true);

        return view;
    }





    public com.example.isthateasy2.models.Task elementPicker(int id, List<com.example.isthateasy2.models.Task> list){
        com.example.isthateasy2.models.Task task = null;
        for(int i = 0; i< list.size(); i++){
            if(list.get(i).getId() == id){
                task = list.get(i);
                break;
            }
        }
        return task;
    }


    public void loadTasks(){

        db.collection("tasks").document(selectedLevel).collection(selectedCourse)
                .get()
                .addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                    @RequiresApi(api = Build.VERSION_CODES.N)
                    @Override
                    public void onComplete(@NonNull Task<QuerySnapshot> task) {
                        if (task.isSuccessful()) {
                            taskList.clear();
                            for (QueryDocumentSnapshot document : task.getResult()) {
                                com.example.isthateasy2.models.Task task1 = convertHashMapToTask(document.getData());
//                                        document.toObject(com.example.isthateasy2.models.Task.class);
                                taskList.add(task1);

                            }
                            recyclerView.setAdapter(taskAdapter);
                            loadingPart.removeAllViews();
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
        task.setCourse(new Course((Map<String, Object>) map.get("course")));
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
