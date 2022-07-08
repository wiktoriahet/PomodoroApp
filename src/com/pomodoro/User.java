package com.pomodoro;

import java.sql.*;
import java.util.Date;
import java.text.SimpleDateFormat;
import java.util.Scanner;
import java.util.UUID;

public class User{

    WritingService writingService = new WritingService();
    PasswordService passwordService = new PasswordService();

    //wybiera uzytkownika z istniejacych, jesli nie istnieje to daje mozliwosc utworzenia nowego
    public void chooseUser(){
        String userChosen;
        String password;
        Boolean isPassCorrect;

        UserMenu userMenu = new UserMenu();

        printUsers();//lista uzytkownikow. czy konieczna pozniej???

        userChosen = writingService.typeUserName();

        if(!doesntExist(userChosen)){
            password = writingService.typePassword();
            isPassCorrect = passwordService.isPasswordCorrect(password, userChosen);
            if(isPassCorrect) {

                System.out.println("Wybrano uzytkownika " + userChosen);
                userMenu.userMenuStartPage(userChosen);
            } else {
                System.out.println("Bledne haslo");
                chooseUser();}

        } else {

            Scanner input = new Scanner(System.in);
            String choice;

            System.out.println("Nie istnieje taki uzytkownik. Czy chcesz utworzyc nowe konto?");
            choice = input.nextLine();

            if(choice.equalsIgnoreCase("Tak")){

                addUser(userChosen);

            } else return;
        }


    }

    //dodaje nowego usera
    public void addUser() {

        try {
            Date thisDate = new Date();
            String userName;
            String password;

            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/pomodorodb", "toriahem", "Gk6tnmcj!");
            Statement statement = connection.createStatement();

            userName = writingService.typeUserName();

            if(doesntExist(userName)){
                password = writingService.typePassword();

                String uniqueID = UUID.randomUUID().toString();
                statement.executeUpdate("INSERT INTO user " + "VALUES('" + uniqueID + "', '" + userName + "', '" + password + "', '" + thisDate + "')");

                System.out.println("Utworzono nowego uzytkownika: " + userName);

            } else {
                System.out.println("Podana nazwa juz istnieje");
                addUser();
            }

        } catch (
                Exception e) {
            e.printStackTrace();
        }
    }

    public void addUser(String name){
        try {
            Date thisDate = new Date();
            String uniqueID = UUID.randomUUID().toString();
            String password;

            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/pomodorodb", "toriahem", "Gk6tnmcj!");
            Statement statement = connection.createStatement();

            password = writingService.typePassword();

            statement.executeUpdate("INSERT INTO user " + "VALUES('" + uniqueID + "', '" + name + "', '" + password + "', '" + thisDate + "')");

            System.out.println("Utworzono nowego uzytkownika: " + name);

        } catch (
                Exception e) {
            e.printStackTrace();
        }
    }

    //usuwa uzytkownika
    public void deleteUser(){

        String userName;
        String password;

        userName = writingService.typeUserName();
        password = writingService.typePassword();

        if(!doesntExist(userName)&&passwordService.isPasswordCorrect(password, userName)){
            try {
                String id;
                String query;

                id = getID(userName);
                query = "delete from user where id = ?";

                Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/pomodorodb", "toriahem", "Gk6tnmcj!");
                PreparedStatement preparedStmt = connection.prepareStatement(query);
                preparedStmt.setString(1,id);
                preparedStmt.execute();

                System.out.println("Usunieto uzytkownika uzytkownika: " + userName);

            } catch (
                    Exception e) {
                e.printStackTrace();
            }
        } else {
            System.out.println("Nie ma takiego uzytkownika badz podane haslo jest bledne");
        }
    }

    //wypluwa id nadane w bazie danych
    private static String getID(String userName){

        try {
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/pomodorodb", "toriahem", "Gk6tnmcj!");
            Statement statement = connection.createStatement();
            ResultSet resultSetID = statement.executeQuery("select * from user");

            while (resultSetID.next()) {
                if (resultSetID.getString("UserName").equalsIgnoreCase(userName)) {
                    return resultSetID.getString("id");
                }
            }
        } catch (
                Exception e) {
            e.printStackTrace();
        }

        return "Brak uzytkownika w bazie danych";
    }
    //drukuje wszystkich userów
    private static void printUsers() {

        try {
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/pomodorodb", "toriahem", "Gk6tnmcj!");
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("select * from user");

            int counter = 0;

            //resultser.next jest boolean wiec jesli jest nastepny rekord to pokazuje true a jesli nie to false
            while (resultSet.next()) {

                counter++;
                System.out.println(counter + ": " + resultSet.getString("UserName"));

            }
        } catch (
                Exception e) {
            e.printStackTrace();
        }
    }

    //sprawdza czy user istnieje
    private static boolean doesntExist(String name) {

        try {

            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/pomodorodb", "toriahem", "Gk6tnmcj!");
            Statement statement = connection.createStatement();
            ResultSet resultSetName = statement.executeQuery("select * from user");

            while (resultSetName.next()) {
                if (resultSetName.getString("UserName").equalsIgnoreCase(name)) {
                    return false;
                }
            }
        } catch (
                Exception e) {
            e.printStackTrace();
        }
        return true;
    }
}

