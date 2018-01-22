package com.example.hassa.testapp2;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;

import Model.Quiz;

public class AfterQuizCreation extends AppCompatActivity {
    Quiz qz=new Quiz();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_after_quiz_creation);
        Bundle data=getIntent().getExtras();
        this.qz=(Quiz) data.get("Quiz");
    }

    public void onAddQuiz(View view){
        Intent cqa=new Intent(this,CreatingQuizActivity.class);
        startActivity(cqa);
    }

    public void onTakeQuiz(View view){
        Intent sa=new Intent(this,StudentActivity.class);
        sa.putExtra("Quiz",this.qz);
        startActivity(sa);
        return;
    }
}
