package com.example.hassa.testapp2;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import Model.Quiz;

public class StudentActivity extends AppCompatActivity {
    List<Quiz> quizzes=new ArrayList();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student);
        Bundle data=getIntent().getExtras();
        easyQuiz();
        hardQuiz();
        if(data!=null){
            Quiz newQuiz=(Quiz)data.get("Quiz");
            quizzes.add(newQuiz);
        }
        Spinner quizzesSpinner=(Spinner) findViewById(R.id.quizzesSpinner);
        ArrayAdapter<String> spinnerAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, android.R.id.text1);
        spinnerAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        quizzesSpinner.setAdapter(spinnerAdapter);
        Iterator<Quiz> itr=quizzes.iterator();
        while(itr.hasNext()){
            Quiz qza=(Quiz)itr.next();
            String quiztitle=qza.getTitle();
            spinnerAdapter.add(quiztitle);
            spinnerAdapter.notifyDataSetChanged();
        }
    }

    public void hardQuiz(){
        Quiz myquiz=new Quiz("My Math Quiz","Hard Math Quiz",50);
        myquiz.addQuestionNumeric("Numeric","What is 2+2","4");
        myquiz.addQuestionNumeric("Numeric","What is 2+3","5");
        myquiz.addQuestionNumeric("Numeric","What is 2+4","6");
        myquiz.addQuestionNumeric("Numeric","What is 2+5","7");
        myquiz.addQuestionNumeric("Numeric","What is 2+6","8");
        myquiz.addQuestionNumeric("Numeric","What is 2+7","9");
        myquiz.addQuestionNumeric("Numeric","What is 2+8","10");
        myquiz.addQuestionNumeric("Numeric","What is 2+9","11");
        myquiz.addQuestionNumeric("Numeric","What is 2+10","12");
        myquiz.addQuestionNumeric("Numeric","What is 2+11","13");
        quizzes.add(myquiz);
    }
    public void easyQuiz(){
        Quiz myquiz=new Quiz("My Math Quiz Easy","Easy Math Quiz",50);
        myquiz.addQuestionNumeric("Numeric","What is 1+2","3");
        myquiz.addQuestionNumeric("Numeric","What is 1+3","4");
        myquiz.addQuestionNumeric("Numeric","What is 1+4","5");
        myquiz.addQuestionNumeric("Numeric","What is 1+5","6");
        myquiz.addQuestionNumeric("Numeric","What is 1+6","7");
        myquiz.addQuestionNumeric("Numeric","What is 1+7","8");
        myquiz.addQuestionNumeric("Numeric","What is 1+8","9");
        myquiz.addQuestionNumeric("Numeric","What is 1+9","10");
        myquiz.addQuestionNumeric("Numeric","What is 1+10","11");
        myquiz.addQuestionNumeric("Numeric","What is 1+11","12");
        quizzes.add(myquiz);
    }

    public void onAttempt(View view){
        Intent aq=new Intent(this,AttemptingQuiz.class);
        Iterator<Quiz> itr=quizzes.iterator();
        Spinner quizzesSpinner=(Spinner) findViewById(R.id.quizzesSpinner);
        String selectedQuiz=quizzesSpinner.getSelectedItem().toString();
        while(itr.hasNext()){
            Quiz qza=(Quiz)itr.next();
            String quiztitle=qza.getTitle();
            if(quiztitle.equals(selectedQuiz)){
                aq.putExtra("Quiz",qza);
            }
        }
        startActivity(aq);
    }


}
