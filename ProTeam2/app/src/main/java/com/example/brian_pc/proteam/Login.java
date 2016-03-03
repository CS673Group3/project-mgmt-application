package com.example.brian_pc.proteam;

import android.app.AlertDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.LoginFilter;
import android.view.View;
import android.widget.EditText;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;
public class Login extends AppCompatActivity{

    EditText userName, passWord;
    Button signIn;
    ImageButton backbutton;
    TextView forGot;
    com.example.brian_pc.proteam.userLocalStore userLocalStore;
    String url ="http://www.google.com";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.signin);
        userName = (EditText) findViewById(R.id.username_input);
        passWord = (EditText) findViewById(R.id.password_input);
        signIn = (Button) findViewById(R.id.Submit);
        forGot = (TextView) findViewById(R.id.forgotPassword);
        backbutton = (ImageButton) findViewById(R.id.back_SignIn);

        View.OnClickListener handler = new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                if(v == signIn){
                    v.setEnabled(false);
                    userName.setEnabled(false);
                    passWord.setEnabled(false);
                    String username = userName.getText().toString();
                    String password = passWord.getText().toString();

                    if(username.length()==0){
                        userName.requestFocus();
                        userName.setError("FIELD CANNOT BE EMPTY, PLEASE ENTER USERNAME");
                    }
                    else if(!username.matches("[a-zA-Z]+"))
                    {
                        userName.requestFocus();
                        userName.setError("ENTER ONLY ALPHABETICAL CHARACTER");
                    }
                    else if(password.length()== 0)
                    {
                        passWord.requestFocus();
                        passWord.setError("FIELD CANNOT BE EMPTY, PLEASE ENTER CORRECT PASSWORD");
                    }
                    else
                    {
                        User user = new User(username, password, Login.this);
                        if(user.authenticate()== true){
                            Toast.makeText(Login.this, "Validation Successful", Toast.LENGTH_LONG).show();
                            UserLogIn(user);
                        }
                    }
                }
                 else if (v == forGot){
                         goback();
                }
                  else if(v == backbutton){
                          goback();
                }
                  else{
                    AlertDialog.Builder dialogBuilder = new AlertDialog.Builder(Login.this);
                    dialogBuilder.setMessage("Incorrect User details");
                    dialogBuilder.setPositiveButton("OK", null);
                    dialogBuilder.show();
                }
            }

        };
        signIn.setOnClickListener(handler);
        forGot.setOnClickListener(handler);
        backbutton.setOnClickListener(handler);
   }

    private void goback() {

        startActivity(new Intent(this, HomePage.class));
    }

    private void UserLogIn(User returneduser){
        userLocalStore.storeUserData(returneduser);
         userLocalStore.setUserLoggedIn(true);
         startActivity(new Intent(this, HomePage.class));
   }

    @Override
    protected void onStop() {
        super.onStop();
    }
}
