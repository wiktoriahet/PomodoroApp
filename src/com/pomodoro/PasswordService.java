package com.pomodoro;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class PasswordService {

    //checks if password is correct with the password saved in database
    public boolean isPasswordCorrect(String password, String name){

        try {
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/pomodorodb", "toriahem", "Gk6tnmcj!");
            Statement statement = connection.createStatement();
            ResultSet resultSetPassword = statement.executeQuery("select * from user");

            while (resultSetPassword.next()) {
                if (resultSetPassword.getString("UserName").equalsIgnoreCase(name)) {
                    return resultSetPassword.getString("password").equals(password);
                }
            }

        } catch (
                Exception e) {
            e.printStackTrace();
        }

        return false;

    }

}
