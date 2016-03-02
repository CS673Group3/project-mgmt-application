package com.example.brian_pc.proteam;

import android.content.Context;
import android.util.Log;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

/**
 * Created by bkabuye on 2/25/2016.
 */
public class User {
    String Firstname, Lastname, username, passWord, email;
    Context context;


    /**
     * method to store data
     *
     * @param FirstName
     * @param LastName
     * @param Username
     * @param password
     */
    public User(String FirstName, String LastName, String Username, String password, String Email) {
        this.username = Username;
        this.Firstname = FirstName;
        this.Lastname = LastName;
        this.passWord = password;
        this.email = Email;
    }

    /**
     * method to cater to already existing user
     *
     * @param Username
     * @param Password
     */
    public User(String Username, String Password, Context context) {

        this.username = Username;
        this.passWord = Password;
        this.context = context;
    }

    public boolean authenticate() {

// Instantiate the RequestQueue.
        RequestQueue queue = Volley.newRequestQueue(context.getApplicationContext());
        String url = "http://168.122.15.84:8000/api-token-auth/";

// Request a string response from the provided URL.
        StringRequest stringRequest = new StringRequest(Request.Method.GET, url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        // Display the first 500 characters of the response string.
                       // view.setText("Response is: "+ response.substring(0,500));
                        Log.d("", response.substring(0,500));
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.d("That didn't work!",error.getMessage());
            }
        });
// Add the request to the RequestQueue.
        queue.add(stringRequest);
        return true;
    }
}
