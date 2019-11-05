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

import com.parse.LogInCallback;
import com.parse.ParseException;
import com.parse.ParseUser;
import com.parse.SignUpCallback;

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

        if (usernameEditText.getText().toString().matches("") ||  passwordEditText.getText().toString().matches(""))
        {

            Toast.makeText(this, "A username and password are required", Toast.LENGTH_SHORT).show();


        }
        else{

            if(signUpModeActive) {

                ParseUser user = new ParseUser();
                user.setUsername(usernameEditText.getText().toString());
                user.setUsername(usernameEditText.getText().toString());


                user.signUpInBackground(new SignUpCallback() {
                    @Override
                    public void done(ParseException e) {
                        if (e == null) {

                            Log.i("Signup", "Successful");
                        } else {

                            Toast.makeText(MainActivity.this, e.getMessage(), Toast.LENGTH_SHORT).show();
                        }

                    }
                });

            }
            else{


                ParseUser.logInInBackground(usernameEditText.getText().toString(), passwordEditText.getText().toString(), new LogInCallback() {
                    @Override
                    public void done(ParseUser user, ParseException e) {

                        if(user !=null){

                            Log.i("signup", "Login successful");

                            Intent SignUp = new Intent(MainActivity.this, SignUp.class);//redirecting to the users profile

                           startActivity(SignUp);

                            finish();
                        }



                        else{
                            Toast.makeText(MainActivity.this, e.getMessage(), Toast.LENGTH_SHORT).show();
                        }

                    }
                });
            }

        }
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        changeSignupModeTextView = (TextView) findViewById(R.id.changeSignupModeTextView);
        changeSignupModeTextView.setOnClickListener(this);

    }
}


