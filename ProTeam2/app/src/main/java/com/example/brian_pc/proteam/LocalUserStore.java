package com.example.brian_pc.proteam;

import android.content.Context;
import android.content.SharedPreferences;

/**
 * Created by bkabuye on 2/25/2016.
 */
public class LocalUserStore {

    public static final String SP_NAME = "userDetails";
    SharedPreferences userLocalDatabase;
    public LocalUserStore(Context context){
        userLocalDatabase = context.getSharedPreferences(SP_NAME, 0);
    }

    public void storeUserData(User user){
     SharedPreferences.Editor spEditor = userLocalDatabase.edit();
        spEditor.putString("name",user.name);
        spEditor.putString("username" ,user.username);
        spEditor.putString("password", user.pass);
        spEditor.commit();
    }

    public User getLoggedInUser(){
        String username = userLocalDatabase.getString("username", "");
        String password = userLocalDatabase.getString("password", "");
        User user = new User(username, password);
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
