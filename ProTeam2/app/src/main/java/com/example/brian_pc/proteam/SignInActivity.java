package com.example.brian_pc.proteam;

import android.app.Activity;
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
    LocalUserStore userLocalStore;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.signin);
        userName = (EditText) findViewById(R.id.username_input);
        passWord = (EditText) findViewById(R.id.password_input);
        signIn = (Button) findViewById(R.id.Submit);
        forGot = (TextView) findViewById(R.id.forgotPassword);
        userLocalStore = new LocalUserStore(this);
        View.OnClickListener handler = new View.OnClickListener(){

            protected void onStart(){
              if(authenticate() == true){
                  displayUserDetail();  // user goes to another page
              }
                else{
                  startActivity(new Intent(SignInActivity.this, SignInActivity.class));
              }

          }
            private void displayUserDetail(){
                User user = userLocalStore.getLoggedInUser();

                    userName.setText(user.username + " "+ user.name);

            }

            private boolean authenticate(){
                return userLocalStore.getUserLoggedIn();
            }

            @Override
            public void onClick(View v) {

                if(v == signIn){
                    User user = new User(null, null);
                    userLocalStore.storeUserData(user);
                    userLocalStore.setUserLoggedIn(true);
                }
                 else if (v == forGot){
                    //Intent passwordForgot = new Intent();
                }
                  else{
                    Intent validate = new Intent(SignInActivity.this, MainActivity.class);
                         userLocalStore.clearUserData();
                         userLocalStore.setUserLoggedIn(false);
                         startActivity(validate);

                }
            }

        };
        signIn.setOnClickListener(handler);
        forGot.setOnClickListener(handler);
   }

}
