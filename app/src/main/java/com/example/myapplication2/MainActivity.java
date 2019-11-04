package com.example.myapplication2;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.graphics.Paint;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Locale;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    Boolean signUpModeActive = true;
    TextView changeSignupModeTextView;

    @Override
    public void onClick(View view) {
        if (view.getId() == R.id.changeSignupModeTextView){

            Button signupButton =(Button) findViewById(R.id.signupButton);



                if(signUpModeActive){

                    signUpModeActive = false;
                    signupButton.setText("Login");
                    changeSignupModeTextView.setText("Or, Signup");

                }

                else{

                    signUpModeActive = true;
                    signupButton.setText("Signup");
                    changeSignupModeTextView.setText("Or, Login");

                }
            }

        }


    public void signUp(View view){

        EditText usernameEditText = (EditText) findViewById(R.id.usernameEditText);
        EditText passwordEditText = (EditText) findViewById(R.id.passwordEditText);

        if (usernameEditText.getText().toString().matches("") ||  passwordEditText.getText().toString().matches(""));{

            Toast.makeText(this, "A username and password are required", Toast.LENGTH_SHORT).show();


        }
        //else{


       // }
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        changeSignupModeTextView = (TextView) findViewById(R.id.changeSignupModeTextView);
        changeSignupModeTextView.setOnClickListener(this);

    }
}


