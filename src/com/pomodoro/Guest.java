package com.pomodoro;

import java.util.Scanner;

public class Guest {

    public void guestStart(){
        Pomodoro pomodoro = new Pomodoro();
        System.out.println("Jak masz na imie?");

        Scanner input = new Scanner(System.in);
        String name;
        name = input.nextLine();

        System.out.println("Witaj " + name);
        System.out.println("Czy chcesz skorzystac z domyslnego ustawienia pomodoro(1), czy ustawic swoj wlasny czas(2)?");
        String chose;
        chose = input.nextLine();

        switch (chose){
            case "1":
                System.out.println("Zaczynam domyslny timer 25 minut");
                pomodoro.pomodoroTimer(25);
                System.out.println("");
                System.out.println("Czas na przerwe! (5m)");
                pomodoro.pomodoroTimer(5);
                break;
            case "2":
                System.out.println("Prosze wpisz ile minut chcesz aby trwal twoj timer");
                int time;
                time = input.nextInt();
                System.out.println("Zaczynam timer o dlugosci " + time + " minut");
                pomodoro.pomodoroTimer(time);
        }

    }


}
