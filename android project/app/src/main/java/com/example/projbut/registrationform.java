package com.example.nidhi.projbut;

import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.jar.Attributes;

public class registrationform extends AppCompatActivity
{
    private EditText nameEdittext;
    private EditText rollnoEdittext;
    private EditText branchEdittext;
    private EditText yearEdittext;
    private EditText phnoEdittext;

    Button submit_data;
    DBHelper mydb;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registrationform);

        mydb = new DBHelper(this);
        nameEdittext = (EditText) findViewById(R.id.editText);
        rollnoEdittext = (EditText) findViewById(R.id.editText2);
        branchEdittext = (EditText) findViewById(R.id.editText3);
        yearEdittext = (EditText) findViewById(R.id.editText4);
        phnoEdittext = (EditText) findViewById(R.id.editText5);
        submit_data = (Button) findViewById(R.id.submit);


        findViewById(R.id.submit).setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                boolean ok = mydb.insertData1(nameEdittext.getText().toString(), rollnoEdittext.getText().toString(), branchEdittext.getText().toString(), yearEdittext.getText().toString(), phnoEdittext.getText().toString());
                if (ok == true) {
                    Toast.makeText(registrationform.this, "Successfully registered", Toast.LENGTH_LONG).show();
                } else {
                    Toast.makeText(registrationform.this, "Register failed", Toast.LENGTH_LONG).show();
                }
            }
        });

//        findViewById(R.id.sw).setOnClickListener(new OnClickListener() {
//
//            @Override
//            public void onClick(View view) {
//                Cursor cursor = mydb.getAllData1();
//                if (cursor.getCount() == 0) {
//
//                    Toast.makeText(registrationform.this, "No user has registered", Toast.LENGTH_LONG).show();
//
//                }
//                StringBuffer buffer = new StringBuffer();
//                while (cursor.moveToNext()) {
//                    buffer.append("Name : " + cursor.getString(0) + "\n");
//                    buffer.append("Roll no : " + cursor.getString(1) + "\n");
//                    buffer.append("Branch : " + cursor.getString(2) + "\n");
//                    buffer.append("Year : " + cursor.getString(3) + "\n");
//                    buffer.append("Phone no.: : " + cursor.getString(4) + "\n\n");
//
//
//                }
//                showmessage("Registered Users", buffer.toString());
//            }
//
//        });
    }

//        public void showmessage(String title,String message)
//        {
//            AlertDialog.Builder builder = new AlertDialog.Builder(this);
//            builder.setCancelable(true);
//            builder.setTitle(title);
//            builder.setMessage(message);
//            builder.show();
//        }
public  void clickExit(View v) {
    // finish();
    AlertDialog.Builder builder = new AlertDialog.Builder(registrationform.this);
    builder.setMessage("Do you want to Log Out?");
    builder.setCancelable(true);
    builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
        @Override
        public void onClick(DialogInterface dialog, int id) {
            finish();
            Intent intent = new Intent(registrationform.this, MainActivity.class);
            startActivity(intent);
            Toast.makeText(registrationform.this, "Logged Out", Toast.LENGTH_LONG).show();
        }
    });

    builder.setNegativeButton("No", new DialogInterface.OnClickListener() {
        @Override
        public void onClick(DialogInterface dialog, int id) {
            dialog.cancel();
        }
    });
    AlertDialog alert = builder.create();
    alert.show();

}
}







