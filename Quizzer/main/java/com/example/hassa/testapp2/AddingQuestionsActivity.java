package com.example.hassa.testapp2;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import Model.Quiz;

public class AddingQuestionsActivity extends AppCompatActivity {
    Quiz qz=new Quiz();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_adding_questions);
        Bundle data=getIntent().getExtras();
        String qtitle=data.getString("qtitle");
        this.qz.setTitle(qtitle);
        String qdesc=data.getString("qdesc");
        this.qz.setDescription(qdesc);
        int qmarks=data.getInt("qmarks");
        this.qz.setTotalMarks(qmarks);
        EditText question=(EditText) findViewById(R.id.question);
        question.setEnabled(false);
        EditText expectedans=(EditText) findViewById(R.id.expectedans);
        expectedans.setEnabled(false);
        EditText option1=(EditText) findViewById(R.id.option1);
        option1.setEnabled(false);
        EditText option2=(EditText) findViewById(R.id.option2);
        option2.setEnabled(false);
        EditText option3=(EditText) findViewById(R.id.option3);
        option3.setEnabled(false);
        EditText option4=(EditText) findViewById(R.id.option4);
        option4.setEnabled(false);
    }

    public void onSelect(View view){
        Spinner typeSpinner=(Spinner) findViewById(R.id.qTypeSpinner);
        String qtype=typeSpinner.getSelectedItem().toString();
        if(qtype.equals("MCQ")){
            EditText question=(EditText) findViewById(R.id.question);
            question.setEnabled(true);
            EditText expectedans=(EditText) findViewById(R.id.expectedans);
            expectedans.setEnabled(true);
            EditText option1=(EditText) findViewById(R.id.option1);
            option1.setEnabled(true);
            EditText option2=(EditText) findViewById(R.id.option2);
            option2.setEnabled(true);
            EditText option3=(EditText) findViewById(R.id.option3);
            option3.setEnabled(true);
            EditText option4=(EditText) findViewById(R.id.option4);
            option4.setEnabled(true);
        }
        else if(qtype.equals("True/False")){
            EditText question=(EditText) findViewById(R.id.question);
            question.setEnabled(true);
            EditText expectedans=(EditText) findViewById(R.id.expectedans);
            expectedans.setEnabled(true);
            EditText option1=(EditText) findViewById(R.id.option1);
            option1.setEnabled(false);
            EditText option2=(EditText) findViewById(R.id.option2);
            option2.setEnabled(false);
            EditText option3=(EditText) findViewById(R.id.option3);
            option3.setEnabled(false);
            EditText option4=(EditText) findViewById(R.id.option4);
            option4.setEnabled(false);
        }
        else if(qtype.equals("Numeric")) {
            EditText question = (EditText) findViewById(R.id.question);
            question.setEnabled(true);
            EditText expectedans = (EditText) findViewById(R.id.expectedans);
            expectedans.setEnabled(true);
            EditText option1=(EditText) findViewById(R.id.option1);
            option1.setEnabled(false);
            EditText option2=(EditText) findViewById(R.id.option2);
            option2.setEnabled(false);
            EditText option3=(EditText) findViewById(R.id.option3);
            option3.setEnabled(false);
            EditText option4=(EditText) findViewById(R.id.option4);
            option4.setEnabled(false);
        }
    }

    public void onAdd(View view){
        Spinner typeSpinner=(Spinner) findViewById(R.id.qTypeSpinner);
        String qtype=typeSpinner.getSelectedItem().toString();
        if(qtype.equals("MCQ")){
            EditText question=(EditText) findViewById(R.id.question);
            EditText expectedans=(EditText) findViewById(R.id.expectedans);
            EditText option1=(EditText) findViewById(R.id.option1);
            EditText option2=(EditText) findViewById(R.id.option2);
            EditText option3=(EditText) findViewById(R.id.option3);
            EditText option4=(EditText) findViewById(R.id.option4);
            this.qz.addQuestionMCQ("MCQ", question.getText().toString(), expectedans.getText().toString(), option1.getText().toString(), option2.getText().toString(), option3.getText().toString(), option4.getText().toString());
            if(this.qz.getNumOfQuestions()>=10){
                Snackbar mySnackbar = Snackbar.make(view,R.string.quiz_created,Snackbar.LENGTH_SHORT);
                mySnackbar.show();
                Intent aqc=new Intent(this,AfterQuizCreation.class);
                aqc.putExtra("Quiz",this.qz);
                startActivity(aqc);
            }
            else{
                Toast.makeText(getApplicationContext(), R.string.question_added, Toast.LENGTH_SHORT).show();
                question.setEnabled(false);
                question.setText("Question");
                expectedans.setEnabled(false);
                expectedans.setText("Expected Answer");
                option1.setEnabled(false);
                option1.setText("Option 1");
                option2.setEnabled(false);
                option2.setText("Option 2");
                option3.setEnabled(false);
                option3.setText("Option 3");
                option4.setEnabled(false);
                option4.setText("Option 4");
            }
        }
        else if(qtype.equals("True/False")){
            EditText question=(EditText) findViewById(R.id.question);
            EditText expectedans=(EditText) findViewById(R.id.expectedans);
            this.qz.addQuestionTrueFalse("True/False", question.getText().toString(), expectedans.getText().toString());
            if(this.qz.getNumOfQuestions()>=10){
                Snackbar mySnackbar = Snackbar.make(view,R.string.quiz_created,Snackbar.LENGTH_SHORT);
                mySnackbar.show();
                Intent aqc=new Intent(this,AfterQuizCreation.class);
                aqc.putExtra("Quiz",this.qz);
                startActivity(aqc);
            }
            else{
                Toast.makeText(getApplicationContext(), R.string.question_added, Toast.LENGTH_SHORT).show();
                question.setEnabled(false);
                question.setText("Question");
                expectedans.setEnabled(false);
                expectedans.setText("Expected Answer");
                EditText option1=(EditText) findViewById(R.id.option1);
                option1.setEnabled(false);
                option1.setText("Option 1");
                EditText option2=(EditText) findViewById(R.id.option2);
                option2.setEnabled(false);
                option2.setText("Option 2");
                EditText option3=(EditText) findViewById(R.id.option3);
                option3.setEnabled(false);
                option3.setText("Option 3");
                EditText option4=(EditText) findViewById(R.id.option4);
                option4.setEnabled(false);
                option4.setText("Option 4");
            }
        }
        else if(qtype.equals("Numeric")) {
            EditText question = (EditText) findViewById(R.id.question);
            EditText expectedans = (EditText) findViewById(R.id.expectedans);
            this.qz.addQuestionNumeric("Numeric",question.getText().toString(),expectedans.getText().toString());
            if(this.qz.getNumOfQuestions()>=10){
                Snackbar mySnackbar = Snackbar.make(view,R.string.quiz_created,Snackbar.LENGTH_SHORT);
                mySnackbar.show();
                Intent aqc=new Intent(this,AfterQuizCreation.class);
                aqc.putExtra("Quiz",this.qz);
                startActivity(aqc);
            }
            else{
                Toast.makeText(getApplicationContext(), R.string.question_added, Toast.LENGTH_SHORT).show();
                question.setEnabled(false);
                question.setText("Question");
                expectedans.setEnabled(false);
                expectedans.setText("Expected Answer");
                EditText option1=(EditText) findViewById(R.id.option1);
                option1.setEnabled(false);
                option1.setText("Option 1");
                EditText option2=(EditText) findViewById(R.id.option2);
                option2.setEnabled(false);
                option2.setText("Option 2");
                EditText option3=(EditText) findViewById(R.id.option3);
                option3.setEnabled(false);
                option3.setText("Option 3");
                EditText option4=(EditText) findViewById(R.id.option4);
                option4.setEnabled(false);
                option4.setText("Option 4");
            }
        }
    }

    public void onQuestion(View view){
        EditText question=(EditText) findViewById(R.id.question);
        question.selectAll();
    }
    public void onExpectedAns(View view){
        EditText expectedans=(EditText) findViewById(R.id.expectedans);
        expectedans.selectAll();
    }
    public void onOption1(View view){
        EditText option1=(EditText) findViewById(R.id.option1);
        option1.selectAll();
    }
    public void onOption2(View view){
        EditText option2=(EditText) findViewById(R.id.option2);
        option2.selectAll();
    }
    public void onOption3(View view){
        EditText option3=(EditText) findViewById(R.id.option3);
        option3.selectAll();
    }
    public void onOption4(View view){
        EditText option4=(EditText) findViewById(R.id.option4);
        option4.selectAll();
    }

}
