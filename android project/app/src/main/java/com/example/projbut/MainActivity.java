package com.example.nidhi.projbut;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;



public class MainActivity extends Activity
{
    private EditText emailEditText;
    private EditText passEditText;
    Button add_data,check_data;
    DatabaseHelper mydb;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {

        super.onCreate(savedInstanceState);//dvm notified to run our code along with code in activity class.
        setContentView(R.layout.activity_main);

        mydb=new DatabaseHelper(this);
        emailEditText = (EditText) findViewById(R.id.editText_email);
        passEditText = (EditText) findViewById(R.id.editText_password);
        add_data=(Button)findViewById(R.id.sign_up) ;
        check_data=(Button)findViewById(R.id.log_in) ;


        findViewById(R.id.sign_up).setOnClickListener(new OnClickListener() {

            @Override
          public void onClick(View arg0) {

                final String email = emailEditText.getText().toString();
                if (!isValidEmail(email))
                {
                    emailEditText.setError("Invalid Email");
                }

                final String pass = passEditText.getText().toString();
                if (!isValidPassword(pass)) {
                    passEditText.setError("Invalid Password");
                }
                if((isValidEmail(email)==true) && (isValidPassword(pass)==true))
                {
                    boolean isinserted=mydb.insertData(emailEditText.getText().toString(),passEditText.getText().toString());
                    if(isinserted==true)
                    {
                        Toast.makeText(MainActivity.this,"Successfully!!\nSigned Up",Toast.LENGTH_LONG).show();
                    }
                    else
                    {
                        Toast.makeText(MainActivity.this,"Your account already exist!",Toast.LENGTH_LONG).show();

                    }
                }


          }
        });

        findViewById(R.id.log_in).setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View arg0) {

                final String email = emailEditText.getText().toString();
                if (!isValidEmail(email))
                {
                    emailEditText.setError("Invalid Email");
                }

                final String pass = passEditText.getText().toString();
                if (!isValidPassword(pass)) {
                    passEditText.setError("Invalid Password");
                }
                if((isValidEmail(email)==true) && (isValidPassword(pass)==true))
                {
                 //   AddData();
//
                    Cursor result=mydb.getAllData();
                    if (result.getCount()==0)
                    {
                        //   Toast.makeText(MainActivity.this,"Sign Up First",Toast.LENGTH_LONG).show();
                        ShowMessage("ERROR","Nothing Found");
                        return;

                    }
                    else
                    {
                        int flag=0;
                        StringBuffer buffer=new StringBuffer();
                        while (result.moveToNext())
                        {
                            // buffer.append("Id :"+result.getString(0)+"\n");
                            // buffer.append("Password "+result.getString(1)+"\n\n");
                            if(result.getString(0).equals(emailEditText.getText().toString()) && result.getString(1).equals(passEditText.getText().toString()))

                            {
                                simple();
                                flag=1;
                                break;

                            }
                            else
                            {
                                flag=0;
                            }

                        }
                        if(flag==1) {
                            Toast.makeText(MainActivity.this, "Login Successfull", Toast.LENGTH_LONG).show();
                        }
                        else
                        {
                            Toast.makeText(MainActivity.this, "Sign Up first", Toast.LENGTH_LONG).show();
                        }
                        //ShowMessage("Data",buffer.toString());
                        // Toast.makeText(MainActivity.this,"Show Message",Toast.LENGTH_LONG).show();

                    }
                }


            }
        });


    }



    // validating email id
    private boolean isValidEmail(String email) {
        String EMAIL_PATTERN = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
                + "cumminscollege.in";

        Pattern pattern = Pattern.compile(EMAIL_PATTERN);
        Matcher matcher = pattern.matcher(email);
        return matcher.matches();
    }

    // validating password with retype password
    private boolean isValidPassword(String pass)
    {
        if (pass != null && pass.length() > 6)
        {

            return true;

        }
        // simple();

        return false;
    }

    public void login(View view)
    {

        Intent intent=new Intent(this,second.class);
        startActivity(intent);

//        Toast myToast=Toast.makeText(this,"Login Successfull! ", Toast.LENGTH_SHORT);
//        myToast.show();
    }
    public void simple()
    {
        login(null);
    }

public void ShowMessage(String title, String Message)
{

    AlertDialog.Builder builder=new AlertDialog.Builder(this);
   builder.setCancelable(true);
    builder.setTitle(title);
    builder.setMessage(Message);
    builder.show();
}

}