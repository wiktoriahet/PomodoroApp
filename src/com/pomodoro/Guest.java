package com.pomodoro;

import java.util.Scanner;

public class Guest {

    public void guestStart(){

        WritingService writingService = new WritingService();
        Pomodoro pomodoro = new Pomodoro();

        String name;
        int choice;
        String breakTypes;
        long workTime = 25;
        long shortBreakTime = 5;
        long longBreakTime = 10;
        int sessionCount = 5;

        name = writingService.typeUserName();

        System.out.println("Witaj " + name);
        System.out.println("Czy chcesz skorzystac z domyslnego ustawienia pomodoro(1), czy ustawic swoj wlasny czas(2)?");
        //wiecej info o sesjach dodac odnosnik do info

        choice = writingService.typeChoiceNumber();

        switch (choice){
            case 1:
                pomodoro.session(sessionCount, workTime, shortBreakTime);
                break;

            case 2:

                System.out.println("Ile ma wynosic ilosc sesji praca plus przerwa?");
                sessionCount = writingService.typeChoiceNumber();

                System.out.println("Ile czasu ma trwac twoja sesja pracy?");
                workTime = writingService.typeChoiceNumber();

                System.out.println("Czy chcesz miec dwie dlugosci przerwy do wyboru?(Y/N)");
                breakTypes = writingService.typeChoiceText();

                if(breakTypes.equalsIgnoreCase("Y")){

                    System.out.println("Ile minut ma trwac dluga przerwa?");
                    longBreakTime = writingService.typeChoiceNumber();
                    System.out.println("Ile minut ma trwac krotka przerwa?");
                    shortBreakTime = writingService.typeChoiceNumber();

                    pomodoro.session(sessionCount, workTime, shortBreakTime, longBreakTime);

                    System.out.println("Koniec wszystkich sesji!");

                } else {
                    pomodoro.session(sessionCount, workTime, shortBreakTime, longBreakTime);
                    System.out.println("Koniec wszystkich sesji!");
                }

                //dodac propozycje utworzenia konta i zapisu sesji jako nowa aktywnosc
        }
    }
}
