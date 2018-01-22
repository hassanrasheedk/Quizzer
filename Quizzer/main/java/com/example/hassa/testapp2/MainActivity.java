package com.example.hassa.testapp2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button loginButton=(Button) findViewById(R.id.loginButton);
        TextView errorText=(TextView) findViewById(R.id.errorText);
        errorText.setVisibility(View.INVISIBLE);
    }

    public void onClickLogin(View view){
        EditText userText=(EditText) findViewById(R.id.username);
        String username=userText.getText().toString();
        EditText passText=(EditText) findViewById(R.id.password);
        String password=passText.getText().toString();
        if(username.toLowerCase().equals("instructor")&&password.toLowerCase().equals("instructor")){
            TextView errorText=(TextView) findViewById(R.id.errorText);
            errorText.setVisibility(View.INVISIBLE);
            Intent cqa=new Intent(this,CreatingQuizActivity.class);
            startActivity(cqa);
        }
        else if(username.toLowerCase().equals("student")&&password.toLowerCase().equals("student")){
            TextView errorText=(TextView) findViewById(R.id.errorText);
            errorText.setVisibility(View.INVISIBLE);
            Intent sa=new Intent(this,StudentActivity.class);
            startActivity(sa);
        }
        else{
            TextView errorText=(TextView) findViewById(R.id.errorText);
            errorText.setVisibility(View.VISIBLE);
        }
    }


}
