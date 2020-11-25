package com.sda_assignment02_2020_agnieszkawoszczyna;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private String email;
    private String subject;
    private String content;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (resultCode == 100) {
            TextView blankLabel = (TextView) findViewById(R.id.blankLabel);
            String text = String.format("To: %s\nSubject: %s\nContent: %s",
                    email = data.getStringExtra("email"),
                    subject = data.getStringExtra("subject"),
                    content = data.getStringExtra("content"));

            blankLabel.setText(text);
        }
    }

    public void onOpenCameraClick(View view) {
        Log.d("MainActivity", "Button clicked");
        //method  called when  the 1st textview is clicked
        Intent takePictureIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        startActivityForResult(takePictureIntent, 1);
        // camera application started
    }

    public void onViewPictureClick(View view) {
        //method  called when  the 2nd textview is pressed
        Intent mediaSearchIntent = new Intent(Intent.ACTION_GET_CONTENT);
        mediaSearchIntent.setType("image/*");
        startActivityForResult(Intent.createChooser(mediaSearchIntent, "Select picture:"), 1);
        // image view application started
    }
//called when the user taps 3 rd textView
    public void onCallClick(View view) {

        Intent intent = new Intent(this, EmailActivity.class);
 // emailActivity started
        startActivityForResult(intent, 1);

    }
    //called when the user tapped the  button
    public void onSendClick(View view) {
        Intent emailIntent = new Intent(Intent.ACTION_SENDTO, Uri.fromParts(
                "mailto", email, null));
        emailIntent.putExtra(Intent.EXTRA_SUBJECT, subject);
        emailIntent.putExtra(Intent.EXTRA_TEXT, content);
        startActivity(Intent.createChooser(emailIntent, "Send e-mail:"));
        // email client application started with 3 parameters passed ( email, subect and text)
    }
}
