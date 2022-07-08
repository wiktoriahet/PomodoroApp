package com.pomodoro;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class Main {

    public static void main(String[] args) {

        //UserPrinter userPrinter = new UserPrinter();
        //userPrinter.printUsers();

        Menu menu = new Menu();
        menu.printMenu();

        //Pomodoro pomodoro = new Pomodoro();
        //pomodoro.pomodoroTimer(3);



        /*
        TO DO
        -class with strings to choose (with messages)
        -add choosing break time after each session
        -add information about app and pomodoro
        -add possibility of creating account after ending session in guest section
         */





    }
}
