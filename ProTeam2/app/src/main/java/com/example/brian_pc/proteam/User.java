package com.example.brian_pc.proteam;

/**
 * Created by bkabuye on 2/25/2016.
 */
public class User {
     String name, username, pass, email;

    /**
     * method to create new user
     * @param FirstName
     * @param LastName
     * @param Username
     * @param password
     * @param Email
     */
    public User(String FirstName, String LastName, String Username, String password, String Email){
          this.username = Username;
          this. name = FirstName + " "+ LastName;
          this.pass = password;
          this.email = Email;
    }

    /**
     * method to cater to already existing user
     * @param Username
     * @param Password
     */
    public User(String Username, String Password){

        this.username = Username;
        this.pass = Password;
    }


}
