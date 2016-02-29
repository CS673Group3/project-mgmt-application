package com.example.brian_pc.proteam;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Created by bkabuye on 2/25/2016.
 */
public class User {
    String Firstname, Lastname, username, passWord, email;
    ConnectionClass connectToDatabase = null;
    Statement statement = null;

    /**
     * method to store data
     * @param FirstName
     * @param LastName
     * @param Username
     * @param password
     */
    public User(String FirstName, String LastName, String Username, String password, String Email){
          this.username = Username;
          this.Firstname = FirstName;
           this.Lastname = LastName;
          this.passWord = password;
          this.email  = Email;
    }

    /**
     * method to cater to already existing user
     * @param Username
     * @param Password
     */
    public User(String Username, String Password){

        this.username = Username;
        this.passWord = Password;

    }

     public boolean authenticate() {
         connectToDatabase = new ConnectionClass();
         String authenticate = "IF EXISTS (SELECT DISTINCT FirstName, LastName, Username, Password, Email FROM Users where Username='"+username +"' AND Password ='"+passWord+"')";
         try {
             statement = connectToDatabase.Conn().createStatement();
             ResultSet results = statement.executeQuery(authenticate);
             if (results.absolute(1)) {

                 results.close();
                 return true;

             }
             else {
                 results.close();
                 return false;
             }
         } catch (SQLException e) {
             e.printStackTrace();
         }

          return false;
     }
    public void addUser(User user){
        connectToDatabase = new ConnectionClass();
        String addUser = "IF NOT EXISTS(SELECT * FROM Users us WHERE us.Username ='"+username+"' AND us.FirstName ='"+Firstname+"') INSERT INTO Users( FirstName, LastName, Username, Password, Email) VALUES('"+Firstname+"', '"+Lastname+"', '"+username+"', '"+passWord+"', '"+email+"')";
        try {
            statement = connectToDatabase.Conn().createStatement();
            statement.executeUpdate(addUser);
            connectToDatabase.Conn().close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
