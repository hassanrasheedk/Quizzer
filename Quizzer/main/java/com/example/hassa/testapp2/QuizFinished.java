package com.example.hassa.testapp2;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class QuizFinished extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz_finished);
        Bundle data=getIntent().getExtras();
        String omarks=data.getString("omarks");
        String tmarks=data.getString("tmarks");
        TextView finaltext=(TextView)findViewById(R.id.FinalText);
        finaltext.setText("You have obtained "+omarks+" out of "+tmarks+"!");
    }

    public void onClose(View view){
        this.finishAffinity();
    }

}
