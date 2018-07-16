package com.example.nidhi.projbut;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;

public class eventsd extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_eventsd);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        Button evbut = (Button)findViewById(R.id.button13);
        Button evbut2 = (Button)findViewById(R.id.button14);

        evbut.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view) {
                Intent int6=new Intent(eventsd.this,registrationform.class);
                startActivity(int6);
            }
        });
        evbut2.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view) {
                Intent int6=new Intent(eventsd.this,registrationform.class);
                startActivity(int6);
            }
        });

    }
}
