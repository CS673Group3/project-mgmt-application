package com.example.brian_pc.proteam;

import android.content.Context;
import android.content.SharedPreferences;

/**
 * Created by bkabuye on 2/25/2016.
 */
public class userLocalStore {

    public static final String SP_NAME = "userDetails";
    SharedPreferences userLocalDatabase;
    Context content;

    public userLocalStore(Context context){
        userLocalDatabase = context.getSharedPreferences(SP_NAME, 0);
    }

    public void storeUserData(User user){
     SharedPreferences.Editor spEditor = userLocalDatabase.edit();
        spEditor.putString("Firstname",user.Firstname);
        spEditor.putString("Lastname",user.Lastname);
        spEditor.putString("username" ,user.username);
        spEditor.putString("password", user.passWord);
        spEditor.putString("Email", user.email);
        spEditor.commit();
    }

    public User getLoggedInUser(){
        String username = userLocalDatabase.getString("username", "");
        String password = userLocalDatabase.getString("password", "");
        User user = new User(username, password, content);
          return user;
    }

    public void setUserLoggedIn(boolean loggedIn){
        SharedPreferences.Editor spEditor = userLocalDatabase.edit();
        spEditor.putBoolean("loggedIn", loggedIn);
        spEditor.commit();
    }

    public boolean getUserLoggedIn(){
        if(userLocalDatabase.getBoolean("LoggedIn", false) == true){
            return true;
        }
         else{
             return false;
        }
    }

    public void clearUserData(){
        SharedPreferences.Editor spEditor = userLocalDatabase.edit();
        spEditor.clear();
        spEditor.commit();
    }
}
