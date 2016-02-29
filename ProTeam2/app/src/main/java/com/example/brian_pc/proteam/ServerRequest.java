package com.example.brian_pc.proteam;

import android.app.ProgressDialog;
import android.content.ContentValues;
import android.content.Context;
import android.os.AsyncTask;
import android.util.Log;

import org.apache.http.params.HttpParams;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.sql.SQLException;
import java.sql.Statement;
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

      private String getEncodedData(Map<String, String> data) {
          StringBuilder sb = new StringBuilder();
          for (String key : data.keySet()) {
              String value = null;
              try {
                  value = URLEncoder.encode(data.get(key), "UTF-8");

              } catch (UnsupportedEncodingException e) {
                  e.getMessage();
              }
              if (sb.length() > 0) {
                  sb.append("&");
                  sb.append(key + "=" + value);
              }
          }
         return sb.toString();
      }

      @Override
      protected Void doInBackground(Void... params) {
          Map<String, String> dataToSend = new HashMap<>();
          dataToSend.put("Firstname", user.Firstname);
          dataToSend.put("Lastname", user.Lastname);
          dataToSend.put("username", user.username);
          dataToSend.put("password",user.passWord);
          String encodedStr = getEncodedData(dataToSend);
           try{
               URL url = new URL(SERVER_ADDRESS + "Register.aspx");
               HttpURLConnection con = (HttpURLConnection) url.openConnection();
               con.setRequestMethod("POST");
               con.setDoInput(true);
               OutputStreamWriter writer = new OutputStreamWriter(con.getOutputStream());
               writer.write(encodedStr);
               writer.flush();

               StringBuilder sb = new StringBuilder();
               BufferedReader reader = new BufferedReader(new InputStreamReader(con.getInputStream()));
               String line;
               while((line = reader.readLine())!= null){
                  sb.append(line + "\n");
               }

           }catch(Exception ex){
               Log.e("Error", ex.getMessage());
           }
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
