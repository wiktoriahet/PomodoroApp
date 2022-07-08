package com.pomodoro;

import java.sql.*;
import java.util.Date;
import java.text.SimpleDateFormat;
import java.util.Scanner;
import java.util.UUID;

public class User {

    //wybiera uzytkownika z istniejacych, jesli nie istnieje to daje mozliwosc utworzenia nowego
    public void chooseUser(){
        String userChosen;
        String password;
        Boolean isPassCorrect;

        UserMenu userMenu = new UserMenu();

        printUsers();//lista uzytkownikow. czy konieczna pozniej???

        userChosen = typeUserName();
        password = typePassword();
        isPassCorrect = isPasswordCorrect(password, userChosen);

        if(!doesntExist(userChosen)&&isPassCorrect){

            System.out.println("Wybrano uzytkownika " + userChosen);
            userMenu.userMenuStartPage(userChosen);

        } else if(!doesntExist(userChosen) && !isPassCorrect){

            System.out.println("Bledne haslo");
            chooseUser();

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

    //dodaje nowego usera
    public void addUser() {

        try {
            Date thisDate = new Date();
            String userName;
            String password;

            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/pomodorodb", "toriahem", "Gk6tnmcj!");
            Statement statement = connection.createStatement();

            userName = typeUserName();

            if(doesntExist(userName)){
                password = typePassword();

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

            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/pomodorodb", "toriahem", "Gk6tnmcj!");

            Statement statement = connection.createStatement();

            System.out.println("Utworz haslo: ");
            Scanner input2 = new Scanner(System.in);
            String password = input2.nextLine();

            Date thisDate = new Date();

            String uniqueID = UUID.randomUUID().toString();

                ResultSet resultSetCount = statement.executeQuery("select * from user");
                statement.executeUpdate("INSERT INTO user " + "VALUES('" + uniqueID + "', '" + name + "', '" + password + "', '" + thisDate + "')");
            System.out.println("Utworzono nowego uzytkownika: " + name);

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

    //usuwa uzytkownika
    public void deleteUser(){


        System.out.println("Wpisz nazwe uzytkownika, ktorego chcesz usunac");
        Scanner input = new Scanner(System.in);
        String userName;
        userName = input.nextLine();
        System.out.println("Wpisz haslo");
        Scanner input2 = new Scanner(System.in);
        String password;
        password = input2.nextLine();
        //isPasswordCorrect(password, userName);

        if(!doesntExist(userName)&&isPasswordCorrect(password, userName)){
            try {


                String id = getID(userName);
                String query = "delete from user where id = ?";
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

        return "0";
    }

    //sprawdza poprawnosc hasla

    private static boolean isPasswordCorrect(String password, String name){

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

    public String typeUserName(){
        System.out.println("Wpisz nazwe uzytkownika");
        Scanner input = new Scanner(System.in);
        String userName = input.nextLine();
        return userName;
    }

    public String typePassword(){
        System.out.println("Wpisz haslo");
        Scanner input = new Scanner(System.in);
        String password = input.nextLine();
        return password;
    }


}

