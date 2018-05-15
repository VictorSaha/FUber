package com.example.user01.fuber;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class DisplayActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display);

        TextView tv = (TextView) findViewById(R.id.disp);

        Intent intent = getIntent();
        String str = intent.getStringExtra("data");
        tv.setText(str);

    }
}
