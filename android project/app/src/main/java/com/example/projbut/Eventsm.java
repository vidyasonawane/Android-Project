package com.example.nidhi.projbut;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;

public class Eventsm extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_eventsm);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        Button aa=(Button)findViewById(R.id.button);
        Button bb=(Button)findViewById(R.id.button1);
        aa.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view) {
                Intent int6=new Intent(Eventsm.this,registrationform.class);
                startActivity(int6);
            }
        });
        bb.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view) {
                Intent int6=new Intent(Eventsm.this,registrationform.class);
                startActivity(int6);
            }
        });

        findViewById(R.id.video1).setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                simpl();
            }


            public void virtual(View v)
            {

                Intent intt=new Intent(Eventsm.this,VirtualReality.class);
                startActivity(intt);

//        Toast myToast=Toast.makeText(this,"Login Successfull! ", Toast.LENGTH_SHORT);
//        myToast.show();
            }
    public void simpl()
    {
        virtual(null);
    }
        });


        findViewById(R.id.video2).setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                simpl1();
            }


            public void cyber(View v)
            {

                Intent intt=new Intent(Eventsm.this,CyberSecurity.class);
                startActivity(intt);

//        Toast myToast=Toast.makeText(this,"Login Successfull! ", Toast.LENGTH_SHORT);
//        myToast.show();
            }
            public void simpl1()
            {
                cyber(null);
            }
        });

    }

}
