package com.example.nidhi.projbut;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class technical extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_technical);
        Button codeclubbut1=(Button)findViewById(R.id.code_club);
        Button pyladiesbut2=(Button)findViewById(R.id.pyladies);


        codeclubbut1.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view) {
                Intent int4=new Intent(technical.this,CodeClub.class);
                startActivity(int4);
            }
        });



        pyladiesbut2.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view) {
                Intent int5=new Intent(technical.this,MozillaClub.class);
                startActivity(int5);
            }
        });





    }
}
