package com.example.brian_pc.proteam;

import android.os.StrictMode;
import android.util.Log;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Created by bkabuye on 2/29/2016.
 */
public class ConnectionClass {

    String ip ="cs673.database.windows.net";
    String driver = "net.sourceforge.jtds.jdbc.Driver";
    String db ="ProjectAndroid";
    String username ="Tester@c673";
    String password = "Stakes21";

  /*  String ip= "BKABUYEL4/SQLEXPRESS";
    String driver = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
    String db = "AndroidProject";
    String username = "3AMLabs/bkabuye";
    String password = "Stakes21";*/

    @SuppressWarnings("NewApi")
    public Connection Conn(){
        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);
        Connection conn = null;
        String ConURL = null;
        try{
            Class.forName(driver);
            ConURL = "jdbc:sqlserver://"+ip+";"+"databaseName="+db+";user="+username+";password="+password+";";
            conn = DriverManager.getConnection(ConURL);


        }catch(SQLException se){
            Log.e("ERROR", se.getMessage());
        }
        catch(ClassNotFoundException e){
            Log.e("ERROR", e.getMessage());
        }catch(Exception ex){
             Log.e("ERROR", ex.getMessage());
        }
         return conn;
    }



}
