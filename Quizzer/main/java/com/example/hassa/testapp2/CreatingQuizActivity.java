package com.example.hassa.testapp2;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.constraint.ConstraintLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.EditText;

import Model.Quiz;

public class CreatingQuizActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_creating_quiz);
    }

    public void onCreateQuiz(View view){
        Intent aqa=new Intent(this,AddingQuestionsActivity.class);
        EditText titleText=(EditText) findViewById(R.id.titleText);
        String qtitle=titleText.getText().toString();
        EditText descText=(EditText) findViewById(R.id.descText);
        String qdesc=descText.getText().toString();
        EditText marksText=(EditText) findViewById(R.id.tmarksText);
        String maxmarks=marksText.getText().toString();
        int qmarks=Integer.parseInt(maxmarks);
        aqa.putExtra("qtitle",qtitle);
        aqa.putExtra("qdesc",qdesc);
        aqa.putExtra("qmarks",qmarks);
        startActivity(aqa);
    }

    public void onClickTitle(View view){
        EditText title=(EditText) findViewById(R.id.titleText);
        title.selectAll();
    }
    public void onClickDesc(View view){
        EditText desc=(EditText) findViewById(R.id.descText);
        desc.selectAll();
    }
    public void onClickNOQ(View view){
        EditText noq=(EditText) findViewById(R.id.noqText);
        noq.selectAll();
    }
    public void onClickTMarks(View view){
        EditText tmarks=(EditText) findViewById(R.id.tmarksText);
        tmarks.selectAll();
    }

    public void onLogOut(View view){
        Intent cqa =new Intent (this,MainActivity.class);
        startActivity(cqa);
    }

}
