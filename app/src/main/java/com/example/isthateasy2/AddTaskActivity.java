package com.example.isthateasy2;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.example.isthateasy2.models.Question;
import com.example.isthateasy2.models.Task;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.navigation.NavigationBarView;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.ArrayList;

public class AddTaskActivity extends AppCompatActivity {
    FirebaseFirestore db = FirebaseFirestore.getInstance();
    BottomNavigationView bottomNavigationView;
    Button closePopupBtn, multipleChoice, dropDown, typingAnAnswer, typingAnswerCancelButton,addOption, btnAdd;
    FloatingActionButton addMenuItem;
    Task task;
    //just index, nothing more
    int optionIndex = 100000;
    PopupWindow popupWindow_choose_way_of_answering, popupWindowMUltipleChoose;
    View addTaskPopup, popupViewTypingAnswer, popupViewMultipleChoose, optionView;
    LinearLayout linearLayout;
    EditText optionEditText, titleEditText, descriptionEditText, topicEditText;
    Spinner levelSpinner, courseSpinner, classSpinner;
    LayoutInflater inflater;
    Question question;

    private static final String TAG = "FirebaseLog";
    String testingClassId = "Ysqx4oNwLoBypiBaKp1G";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_task);

        task = new Task();

        addMenuItem = findViewById(R.id.addMenuItem);
        addMenuItem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //reference from https://android--code.blogspot.com/2016/01/android-popup-window-example.html


                inflater = (LayoutInflater) AddTaskActivity.this.getSystemService(LAYOUT_INFLATER_SERVICE);
                addTaskPopup = inflater.inflate(R.layout.add_task_popup, null);
                popupWindow_choose_way_of_answering = new PopupWindow(addTaskPopup, WindowManager.LayoutParams.MATCH_PARENT, WindowManager.LayoutParams.MATCH_PARENT);

                popupWindow_choose_way_of_answering.showAsDropDown(addTaskPopup, 0, 0);
                popupWindow_choose_way_of_answering.setFocusable(true);
                closePopupBtn = (Button) addTaskPopup.findViewById(R.id.closePopupBtn);

                View.OnClickListener onClickListener_choosing_answering_way = new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        int id = view.getId();
                        switch (id) {
                            case R.id.drop_down: {
                                popupWindow_choose_way_of_answering.dismiss();
                                break;
                            }
                            case R.id.typing_an_answer:
                                {
                                popupWindow_choose_way_of_answering.dismiss();
                                //this will called when he click on typing an answer as way of answering


                                typingAnAnswerOption();


                                break;
                            }
                            case R.id.multiple_choice: {
                                popupWindow_choose_way_of_answering.dismiss();
                                //this will called when he click on Multiple choose as way of answering
                                multipleChoiceOption();

                                break;
                            }
                            default:
                                return;
                        }

                    }
                };

                dropDown = addTaskPopup.findViewById(R.id.drop_down);
                typingAnAnswer = addTaskPopup.findViewById(R.id.typing_an_answer);
                multipleChoice = addTaskPopup.findViewById(R.id.multiple_choice);

                dropDown.setOnClickListener(onClickListener_choosing_answering_way);
                typingAnAnswer.setOnClickListener(onClickListener_choosing_answering_way);
                multipleChoice.setOnClickListener(onClickListener_choosing_answering_way);

                closePopupBtn.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        popupWindow_choose_way_of_answering.dismiss();
                    }
                });

            }
        });

        bottomNavigationView = findViewById(R.id.bottomNavigationViewForAddTask);
        bottomNavigationView.setBackground(null);
        bottomNavigationView.setSelectedItemId(R.id.holderMenuItem);
        bottomNavigationView.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.settingMenuItem:
                        return true;
                    case R.id.FinishMenuItem: {
                        titleEditText = findViewById(R.id.titleEditText);
                        String title = titleEditText.getText().toString();

                        descriptionEditText = findViewById(R.id.descriptionEditText);
                        String description = descriptionEditText.getText().toString();

                        topicEditText = findViewById(R.id.topicEditText);
                        String topic = topicEditText.getText().toString();

                        levelSpinner = findViewById(R.id.levelsSpinnerAddTask);
                        String level = levelSpinner.getSelectedItem().toString();

                        courseSpinner = findViewById(R.id.coursesSpinnerAddTask);
                        String course = courseSpinner.getSelectedItem().toString();

                        classSpinner = findViewById(R.id.classSpinnerAddTask);
                        String className = classSpinner.getSelectedItem().toString();


                        task.setTitle(title);
                        task.setDescription(description);
                        task.setTopic(topic);
                        task.setLevel(level);
                        task.setCourse(course);
                        task.setClassName(className);

//                        saveTask();
                        db.collection("classes").document("p1").collection("math").document(testingClassId).collection("tasks").add(task)
                                .addOnSuccessListener(new OnSuccessListener<DocumentReference>() {
                                    @Override
                                    public void onSuccess(DocumentReference documentReference) {
                                        Log.d(TAG, "DocumentSnapshot written with ID: " + documentReference.getId());
                                        finish();
                                    }
                                })
                                .addOnFailureListener(new OnFailureListener() {
                                    @Override
                                    public void onFailure(@NonNull Exception e) {
                                        Log.w(TAG, "Error adding document", e);
                                    }
                                });


                        return true;
                    }
                    default:
                        return false;
                }
            }
        });
    }

//    private void saveTask() {
//        //perform firebase saving
//    }

    private void typingAnAnswerOption() {
        popupViewTypingAnswer = inflater.inflate(R.layout.typing_an_answer_popup, null);
        PopupWindow popupWindowTypingAnswer = new PopupWindow(popupViewTypingAnswer, WindowManager.LayoutParams.MATCH_PARENT, WindowManager.LayoutParams.MATCH_PARENT);

        popupWindowTypingAnswer.showAsDropDown(popupViewTypingAnswer, 0, 0);
        popupWindowTypingAnswer.setFocusable(true);
        typingAnswerCancelButton = (Button) popupViewTypingAnswer.findViewById(R.id.typing_an_answer_cancel_btn);

        typingAnswerCancelButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                popupWindowTypingAnswer.dismiss();
            }
        });
    }

    private void multipleChoiceOption(){
        question = new Question();
        question.setWayOfAnswering("multipleChoice");


        popupViewMultipleChoose = inflater.inflate(R.layout.add_multiple_choose_popup, null);
        popupWindowMUltipleChoose = new PopupWindow(popupViewMultipleChoose, WindowManager.LayoutParams.MATCH_PARENT, WindowManager.LayoutParams.MATCH_PARENT);

        popupWindowMUltipleChoose.showAsDropDown(popupViewMultipleChoose, 0, 0);
        popupWindowMUltipleChoose.setFocusable(true);
        typingAnswerCancelButton = (Button) popupViewMultipleChoose.findViewById(R.id.multiple_choose_cancel_btn);

        typingAnswerCancelButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                popupWindowMUltipleChoose.dismiss();
            }
        });

        linearLayout = popupViewMultipleChoose.findViewById(R.id.linear_Layout_in_multiple_choose);
        addOption = popupViewMultipleChoose.findViewById(R.id.multiple_choose_add_option);
        //when you click on add option button it will create new view and add it to linearLayout

        addOption.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                optionView = inflater.inflate(R.layout.new_option_layout_m_c, null);
                optionView.setId(optionIndex++);
                linearLayout.addView(optionView);

                // this btn is delete button
                Button btn = optionView.findViewById(R.id.delete_option);
                btn.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        linearLayout.removeView(optionView);
                    }
                });
                btnAdd = popupViewMultipleChoose.findViewById(R.id.multiple_choose_add_btn);
                btnAdd.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        // getting value user types
                        for (int i = (optionIndex - 1); i >= 100000; --i) {
                            optionEditText = linearLayout.findViewById(i).findViewById(R.id.each_option_edit_text);
                            question.addOption(optionEditText.getText().toString());
                        }
                        EditText questionField = popupViewMultipleChoose.findViewById(R.id.question_field_in_multiple_choose),
                                marksField = popupViewMultipleChoose.findViewById(R.id.marksFiled_in_multiple_choose);

                        question.setQuestion(questionField.getText().toString());

                        try {
                            question.setMarks(Integer.parseInt(marksField.getText().toString()));
                        } catch (Exception ex) {
                            question.setMarks(1);
                        }


                        //end of getting value


                        LinearLayout questionLayout = findViewById(R.id.created_question_linear_layout);

                        View createdQuestionLayout = inflater.inflate(R.layout.created_question_layout, null);
//                                                        this will call layout that will display created questions
//                                                        passing parameters into view
                        TextView questionArea = createdQuestionLayout.findViewById(R.id.question_area);
                        questionArea.setText(question.getQuestion());
                        TextView marksArea = createdQuestionLayout.findViewById(R.id.marks_area);
                        marksArea.setText(String.valueOf(question.getMarks()));

                        // add question to others
                        task.addQuestion(question);
                        questionLayout.addView(createdQuestionLayout);
                        popupWindowMUltipleChoose.dismiss();
                        optionIndex = 0;
                    }
                });
            }
        });
    }
}