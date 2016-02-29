package com.example.brian_pc.proteam;


import android.content.Intent;
import android.os.Bundle;

import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;

public class SignUpActivity extends AppCompatActivity {

    Button signUp;
    ImageButton cancel;
    EditText userName, passWord, firstname, lastname, email;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.signup);

        userName = (EditText) findViewById(R.id.username_input);
        passWord = (EditText) findViewById(R.id.password_input);
        firstname = (EditText) findViewById(R.id.firstname_Input);
        lastname = (EditText) findViewById(R.id.lastname_input);
        email = (EditText) findViewById(R.id.Email_input);
        signUp = (Button) findViewById(R.id.SignUpbtn);
        cancel = (ImageButton) findViewById(R.id.back_SignIn);

        View.OnClickListener handler = new View.OnClickListener(){
            @Override
            public void onClick(View v) {

                if(v == signUp){
                    String Firstname = userName.getText().toString();
                    String Lastname = lastname.getText().toString();
                    String Username = userName.getText().toString();
                    String Email = email.getText().toString();
                    String Pass = passWord.getText().toString();
                    User registeredData = new User(Firstname, Lastname, Username, Pass);
                }
                else if (v == cancel){

                }
                else{

                }
            }

        };
        signUp.setOnClickListener(handler);
        cancel.setOnClickListener(handler);
    }

}
