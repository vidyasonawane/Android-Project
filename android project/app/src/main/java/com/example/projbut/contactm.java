package com.example.nidhi.projbut;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

public class contactm extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contactm);
        sendEmail();
    }
    protected void sendEmail() {
        Log.i("Send email", "");
        String[] TO = {"sharayu.shinde@cumminscollege.in"};
        String[] CC = {"vidya.sonawane@cumminscollege.in","nidhi.singh@cumminscollege.in"};
        Intent emailIntent = new Intent(Intent.ACTION_SEND);

        emailIntent.setData(Uri.parse("mailto:"));
        emailIntent.setType("text/plain");
        emailIntent.putExtra(Intent.EXTRA_EMAIL, TO);
        emailIntent.putExtra(Intent.EXTRA_CC, CC);
        emailIntent.putExtra(Intent.EXTRA_SUBJECT, "Query regarding Club");
        emailIntent.putExtra(Intent.EXTRA_TEXT, " ");

        try {
            startActivity(Intent.createChooser(emailIntent, "Send mail..."));
            finish();
            // Log.i("Finished sending email...", "");
        } catch (android.content.ActivityNotFoundException ex) {
            Toast.makeText(contactm.this, "There is no email client installed.", Toast.LENGTH_SHORT).show();
        }
    }

}

