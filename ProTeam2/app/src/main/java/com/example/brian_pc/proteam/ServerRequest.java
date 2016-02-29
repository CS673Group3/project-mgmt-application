package com.example.brian_pc.proteam;

import android.app.ProgressDialog;
import android.content.ContentValues;
import android.content.Context;
import android.os.AsyncTask;

import org.apache.http.params.HttpParams;

import java.io.BufferedReader;
import java.net.URL;
import java.util.ArrayList;
import java.lang.*;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by bkabuye on 2/29/2016.
 */
public class ServerRequest {

    ProgressDialog progressDialog;
    public static final int CONNECTION_TIMEOUT = 1000*15;
    public static final String SERVER_ADDRESS = "cs673.database.windows.net";
    public ServerRequest(Context context){
        progressDialog = new ProgressDialog(context);
        progressDialog.setCancelable(false);
        progressDialog.setTitle("Processing");
        progressDialog.setMessage("Please wait...");
    }

    public void storeUserDataInBackground(User user, GetUserCallBack callback){
        progressDialog.show();
        new StoreUserDataAysncTask(user, callback).execute();

    }

    public void fetchUserDataInBackground(User user, GetUserCallBack callBack){
     progressDialog.show();
    }
  public class StoreUserDataAysncTask extends AsyncTask<Void, Void, Void> {
        User user;
        GetUserCallBack userCallBack;

      public StoreUserDataAysncTask(User user, GetUserCallBack callBack){
          this.user = user;
          this.userCallBack = callBack;
      }
      @Override
      protected Void doInBackground(Void... params) {
          Map<String, String> dataToSend = new HashMap<>();
          dataToSend.put("name", user.name);
          dataToSend.put("username", user.username);
          dataToSend.put("password",user.pass);


          return null;
      }
       @Override
      protected void onPostExecute(Void avoid){
           progressDialog.dismiss();
           userCallBack.Done(null);
           super.onPostExecute(avoid);
       }

  }
}
