package com.pomodoro;

import java.util.Scanner;

public class WritingService {

    public WritingService() {
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
