package com.example.user01.fuber;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class PostScreen extends AppCompatActivity {
    String s1;
    DatabaseHelper mDatabaseHelper;
    public static final String TAG = "PostScreen";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_post_screen);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        Button b1= findViewById(R.id.button_submit);
        final EditText e1=findViewById(R.id.editText);
        final EditText e2=findViewById(R.id.editText2);

        mDatabaseHelper = new DatabaseHelper(this);

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final String s1 = e1.getText().toString();
                final int no1 = Integer.valueOf(e2.getText().toString());

                if ((s1.length() != 0)&&(no1!=0)){
                    AddData(s1, no1);
                    Toast.makeText(getApplicationContext() , "Data added!", Toast.LENGTH_SHORT);
                    e1.setText("");
                } else {
                    Toast.makeText(getApplicationContext() , "You must put something in the text field!", Toast.LENGTH_SHORT);
                }
            }
        });
    }

    public void AddData(String newEntry,int newNum ) {
        boolean insertData = mDatabaseHelper.addData(newEntry,newNum);

        if (insertData) {
            Toast.makeText(this, "Data Successfully Inserted!", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(this, "Something went wrong!", Toast.LENGTH_SHORT).show();
        }
    }

}
