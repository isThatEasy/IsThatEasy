package com.example.isthateasy2;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.example.isthateasy2.models.Answer;
import com.example.isthateasy2.models.C;
import com.example.isthateasy2.models.Level;
import com.example.isthateasy2.models.Question;
import com.example.isthateasy2.models.SelectionQuestion;
import com.example.isthateasy2.models.Task;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.navigation.NavigationBarView;
import com.google.android.material.textfield.TextInputEditText;
import com.google.firebase.Timestamp;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;

public class AddTaskActivity extends AppCompatActivity {
    FirebaseFirestore db = FirebaseFirestore.getInstance();
    BottomNavigationView bottomNavigationView;
    Button closePopupBtn, multipleChoice, dropDown, typingAnAnswer, typingAnswerCancelButton,addOption, btnAdd;
    FloatingActionButton addMenuItem;
    Task task;
    //just index, nothing more
    int optionIndex = 0;
    PopupWindow popupWindow_choose_way_of_answering, popupWindowMUltipleChoose;
    View addTaskPopup, popupViewTypingAnswer, popupViewMultipleChoose, optionView;
    LinearLayout linearLayout;
    EditText optionEditText, titleEditText, descriptionEditText, topicEditText;
    Spinner levelSpinner, courseSpinner, classSpinner;
    LayoutInflater inflater;
    Question question;
    ProgressDialog progress;
    CheckBox isItCorrectCheckBox;

    private static final String TAG = "AddTASKActivity";
    String testingClassId = "Ysqx4oNwLoBypiBaKp1G";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_task);

        task = new Task();
        progress = new ProgressDialog(AddTaskActivity.this);

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

                        progress.setTitle("Loading");
                        progress.setMessage("Wait while loading...");
                        progress.setCanceledOnTouchOutside(false); // disable dismiss by tapping outside of the dialog
                        progress.show();

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
                        task.setChapterName(topic);
//                        task._setLevelName(level);
                        task.setLevel(new Level(level));
                        task.setCourseName(course);
                        task.setClassName(className);
                        task.setCreatedAt(Timestamp.now());
                        task.setUpdatedAt(Timestamp.now());

//                        saveTask();
                        db.collection("tasks").document(task._getLevelName()).collection(task.getCourseName()).add(task)
                                .addOnSuccessListener(new OnSuccessListener<DocumentReference>() {
                                    @Override
                                    public void onSuccess(DocumentReference documentReference) {
                                        Log.d(TAG, "DocumentSnapshot written with ID: " + documentReference.getId());
                                        progress.dismiss();
                                        finish();
                                    }
                                })
                                .addOnFailureListener(new OnFailureListener() {
                                    @Override
                                    public void onFailure(@NonNull Exception e) {
                                        Log.w(TAG, "Error adding document", e);
                                        progress.dismiss();
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
        question = new SelectionQuestion();
        question.setWayOfAnswering(C.SELECTION_WAY_OF_ANSWERING);


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
                        Answer answer;
                        for (int i = (optionIndex - 1); i >= 0; --i) {
                            optionEditText = linearLayout.findViewById(i).findViewById(R.id.each_option_edit_text);
                            isItCorrectCheckBox = linearLayout.findViewById(i).findViewById(R.id.checkBoxIsTrue);
                            answer = new Answer();
                            answer.setAnswer(optionEditText.getText().toString());
                            Log.d(TAG, "onClick: answer created" + answer.getAnswer());
                            if(isItCorrectCheckBox.isChecked()){
                                answer.setIsItCorrect(true);
                            }
                            else {
                                answer.setIsItCorrect(false);
                            }
                            ((SelectionQuestion)question).addPossibleAnswer(answer);
                            question.setCreatedAt(Timestamp.now());
                            question.setUpdatedAt(Timestamp.now());
                        }
                        EditText marksField = popupViewMultipleChoose.findViewById(R.id.marksFiled_in_multiple_choose);
                        TextInputEditText questionField = popupViewMultipleChoose.findViewById(R.id.question_field_in_multiple_choose);


                        question.setQuestion(questionField.getText().toString());

                        try {
                            question.setMarks(marksField.getText().toString());
                        } catch (Exception ex) {
                            question.setMarks("1");
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