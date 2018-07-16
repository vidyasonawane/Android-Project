package com.example.nidhi.projbut;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class cultural extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cultural);
        Button abc=(Button)findViewById(R.id.button2);
        abc.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view) {
                Intent int1=new Intent(cultural.this,danceclub.class);
                startActivity(int1);
            }
        });

    }
}
