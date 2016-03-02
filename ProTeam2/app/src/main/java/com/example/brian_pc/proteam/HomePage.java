package com.example.brian_pc.proteam;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;

public class HomePage extends AppCompatActivity {

    Button signIn, signUp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.home);
        signIn = (Button) findViewById(R.id.Login);
        signUp = (Button) findViewById(R.id.SignUp);
      View.OnClickListener handler = new View.OnClickListener() {
          @Override
          public void onClick(View v) {
              if(v == signIn) {
                  Intent startNewActivity = new Intent(HomePage.this, Login.class);
                   startActivity(startNewActivity);
                    Log.i("Content", "SignIn home");
              }
               else{
                  Intent startNewActivity = new Intent(HomePage.this, Register.class);
                  startActivity(startNewActivity);
                  Log.i("Content", "SignUp home");
              }
          }
      };
        signUp.setOnClickListener(handler);
        signIn.setOnClickListener(handler);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
