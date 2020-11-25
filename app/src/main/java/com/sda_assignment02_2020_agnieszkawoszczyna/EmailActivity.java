package com.sda_assignment02_2020_agnieszkawoszczyna;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

public class EmailActivity extends AppCompatActivity {

    private static final String TAG = "MyActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_email);
    }

    //method stared after clicking SAVE button
    public void onSaveClick(View view) {
        Log.i (TAG, "The user cliked Save Button");




// taking references for textboxes
        EditText emailTextBox = (EditText)findViewById(R.id.emailTextBox);
        EditText subjectTextBox = (EditText)findViewById(R.id.subjectTextBox);
        EditText contentTextBox = (EditText)findViewById(R.id.contentTextBox);
        //creation of an empty intent
        Intent intent = new Intent();
//passing parameters to an empty intent
        intent.putExtra("email", emailTextBox.getText().toString());
        intent.putExtra("subject", subjectTextBox.getText().toString());
        intent.putExtra("content", contentTextBox.getText().toString());
        //passing id (100) to MainActivity in order to let the program to recognize that it is the passed email parameters
        setResult(100, intent);
        finish();
        //close
    }
}
