package com.example.hassa.testapp2;

import android.content.Intent;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Iterator;
import java.util.List;

import Model.Question;
import Model.Quiz;

public class AttemptingQuiz extends AppCompatActivity {
    Quiz qz=new Quiz();
    List<Question> questions;
    Iterator itr;
    int i;
    int tmarks, omarks;
    int qmark;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_attempting_quiz);
        Bundle data=getIntent().getExtras();
        i=0;
        this.qz=(Quiz)data.get("Quiz");
        this.tmarks=this.qz.getMarks();
        qmark=tmarks/10;
        this.questions=qz.getQuestions();
        this.itr=questions.iterator();
        RadioGroup mcqgroup=(RadioGroup) findViewById(R.id.MCQGroup);
        mcqgroup.setVisibility(View.INVISIBLE);
        mcqgroup.setEnabled(false);
        RadioGroup truefalsegroup=(RadioGroup) findViewById(R.id.TrueFalseGroup);
        truefalsegroup.setVisibility(View.INVISIBLE);
        truefalsegroup.setEnabled(false);
        EditText answerfield=(EditText) findViewById(R.id.answerField);
        answerfield.setVisibility(View.INVISIBLE);
        answerfield.setEnabled(false);
        Question ques=(Question)itr.next();
        if(ques.gettype().equals("MCQ")){
            TextView questiontext=(TextView) findViewById(R.id.questionText);
            questiontext.setText(ques.gettext());
            RadioButton option1=(RadioButton) findViewById(R.id.Option1Button);
            option1.setText(ques.mcqarray[0]);
            RadioButton option2=(RadioButton) findViewById(R.id.Option2Button);
            option2.setText(ques.mcqarray[1]);
            RadioButton option3=(RadioButton) findViewById(R.id.Option3Button);
            option3.setText(ques.mcqarray[2]);
            RadioButton option4=(RadioButton) findViewById(R.id.Option4Button);
            option4.setText(ques.mcqarray[3]);
            mcqgroup.setVisibility(View.VISIBLE);
            mcqgroup.setEnabled(true);
            mcqgroup.check(option1.getId());
            if(ques.type.equals("MCQ")){

            }
        }
        else if(ques.gettype().equals("True/False")){
            TextView questiontext=(TextView) findViewById(R.id.questionText);
            questiontext.setText(ques.gettext());
            RadioButton truebutton=(RadioButton) findViewById(R.id.TrueButton);
            truefalsegroup.setVisibility(View.VISIBLE);
            truefalsegroup.setEnabled(true);
            truefalsegroup.check(truebutton.getId());
        }
        else if(ques.gettype().equals("Numeric")){
            TextView questiontext=(TextView) findViewById(R.id.questionText);
            questiontext.setText(ques.gettext());
            answerfield.setVisibility(View.VISIBLE);
            answerfield.setEnabled(true);
        }
    }

    public void onConfirm(View view){
        RadioGroup mcqgroup=(RadioGroup) findViewById(R.id.MCQGroup);
        RadioGroup truefalsegroup=(RadioGroup) findViewById(R.id.TrueFalseGroup);
        EditText answerfield=(EditText) findViewById(R.id.answerField);
        RadioButton option1=(RadioButton) findViewById(R.id.Option1Button);
        RadioButton option2=(RadioButton) findViewById(R.id.Option2Button);
        RadioButton option3=(RadioButton) findViewById(R.id.Option3Button);
        RadioButton option4=(RadioButton) findViewById(R.id.Option4Button);
        RadioButton truebutton=(RadioButton) findViewById(R.id.TrueButton);
        RadioButton falsebutton=(RadioButton) findViewById(R.id.FalseButton);
        String selectedRadio;
        Question quesa=(Question) questions.get(i);
        if(quesa.gettype().equals("MCQ")){
            int id=mcqgroup.getCheckedRadioButtonId();
            View radioButton=mcqgroup.findViewById(id);
            int idx=mcqgroup.indexOfChild(radioButton);
            RadioButton r = (RadioButton) mcqgroup.getChildAt(idx);
            selectedRadio = r.getText().toString();
            if(quesa.getexpectedans().toLowerCase().equals(selectedRadio.toLowerCase())){
                omarks=omarks+qmark;
            }
        }
        else if(quesa.gettype().equals("True/False")){
            int id=truefalsegroup.getCheckedRadioButtonId();
            View radioButton=truefalsegroup.findViewById(id);
            int idx=truefalsegroup.indexOfChild(radioButton);
            RadioButton r = (RadioButton) truefalsegroup.getChildAt(idx);
            selectedRadio = r.getText().toString();
            if(quesa.getexpectedans().toLowerCase().equals(selectedRadio.toLowerCase())){
                omarks=omarks+qmark;
            }
        }
        else if(quesa.gettype().equals("Numeric")){
            if(quesa.getexpectedans().toLowerCase().equals(answerfield.getText().toString().toLowerCase())){
                omarks=omarks+qmark;
            }
        }
        if(itr.hasNext()){
            Question ques=(Question)itr.next();
            i++;
            if(ques.gettype().equals("MCQ")){
                TextView questiontext=(TextView) findViewById(R.id.questionText);
                questiontext.setText(ques.gettext());
                option1.setText(ques.mcqarray[0]);
                option2.setText(ques.mcqarray[1]);
                option3.setText(ques.mcqarray[2]);
                option4.setText(ques.mcqarray[3]);
                mcqgroup.setVisibility(View.VISIBLE);
                mcqgroup.setEnabled(true);
                answerfield.setVisibility(View.INVISIBLE);
                answerfield.setEnabled(false);
                truefalsegroup.setVisibility(View.INVISIBLE);
                truefalsegroup.setEnabled(false);
                mcqgroup.check(option1.getId());
            }
            else if(ques.gettype().equals("True/False")){
                TextView questiontext=(TextView) findViewById(R.id.questionText);
                questiontext.setText(ques.gettext());
                truefalsegroup.setVisibility(View.VISIBLE);
                truefalsegroup.setEnabled(true);
                mcqgroup.setVisibility(View.INVISIBLE);
                mcqgroup.setEnabled(false);
                answerfield.setVisibility(View.INVISIBLE);
                answerfield.setEnabled(false);
                truefalsegroup.check(truebutton.getId());
            }
            else if(ques.gettype().equals("Numeric")){
                TextView questiontext=(TextView) findViewById(R.id.questionText);
                questiontext.setText(ques.gettext());
                answerfield.setVisibility(View.VISIBLE);
                answerfield.setEnabled(true);
                truefalsegroup.setVisibility(View.INVISIBLE);
                truefalsegroup.setEnabled(false);
                mcqgroup.setVisibility(View.INVISIBLE);
                mcqgroup.setEnabled(false);
            }
        }
        else {
            Toast.makeText(this,omarks+" out of "+tmarks,Toast.LENGTH_LONG);
            String omarkss=String.valueOf(omarks);
            String tmarkss=String.valueOf(tmarks);
            Intent qf=new Intent(this,QuizFinished.class);
            qf.putExtra("omarks",omarkss);
            qf.putExtra("tmarks",tmarkss);
            startActivity(qf);
        }
    }

}