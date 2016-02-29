package com.example.brian_pc.proteam;

import android.app.AlertDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.Button;
import android.widget.TextView;

public class SignInActivity extends AppCompatActivity{

    EditText userName, passWord;
    Button signIn;
    TextView forGot;
    com.example.brian_pc.proteam.userLocalStore userLocalStore;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.signin);
        userName = (EditText) findViewById(R.id.username_input);
        passWord = (EditText) findViewById(R.id.password_input);
        signIn = (Button) findViewById(R.id.Submit);
        forGot = (TextView) findViewById(R.id.forgotPassword);
        View.OnClickListener handler = new View.OnClickListener(){

            @Override
            public void onClick(View v) {

                if(v == signIn){
                    String username = userName.getText().toString();
                    String password = passWord.getText().toString();
                    User user = new User(username, password);
                    if(user.authenticate()==  true){
                       UserLogIn(user);
                    }

                }
                 else if (v == forGot){
                    //Intent passwordForgot = new Intent();
                }
                  else{
                    AlertDialog.Builder dialogBuilder = new AlertDialog.Builder(SignInActivity.this);
                    dialogBuilder.setMessage("Incorrect User details");
                    dialogBuilder.setPositiveButton("OK", null);
                    dialogBuilder.show();
                }
            }

        };
        signIn.setOnClickListener(handler);
        forGot.setOnClickListener(handler);
   }
     private void UserLogIn(User returneduser){
       userLocalStore.storeUserData(returneduser);
         userLocalStore.setUserLoggedIn(true);
         startActivity(new Intent(this, MainActivity.class));
   }
}
