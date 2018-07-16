package com.example.nidhi.projbut;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class second extends AppCompatActivity //for adding action bar "clubhub" to our activity
{

    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        Button technicalbut1=(Button)findViewById(R.id.button4);
        Button culturalbut2=(Button)findViewById(R.id.button5);


        technicalbut1.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view) {
                Intent int1=new Intent(second.this,technical.class);
                startActivity(int1);
            }
        });



        culturalbut2.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view) {
                Intent int2=new Intent(second.this,cultural.class);
                startActivity(int2);
            }
        });




    }
}
