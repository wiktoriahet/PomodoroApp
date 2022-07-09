package com.pomodoro;

import java.util.Scanner;

public class UserMenu {

    public void userMenuStartPage(String name){

        Scanner input = new Scanner(System.in);
        int choice;

        do {
            System.out.println("Witaj " + name +"!!!");
            System.out.println("1.) Wybierz aktywnosc"); //z tych, ktore uzytkownik utworzyl juz wczesniej, jesli brak, to propozycja "brak utworzonych aktywnosci, czy chcesz utworzyn nowa?"
            System.out.println("2.) Wpisz nowa aktywosc");//wpisuje i zapisuje nowa aktywnosc w bazie danych, jesli istnieje "istnieje aktywnosc o tej nazwie, czy chcesz ja uruchomic?"
            System.out.println("3.) Uzyj domyslnego pomodoro bez tworzenia aktywnosci");//odpala pomodoro 25/5 bez zapisywania aktywnosci ale proponuje jej zapis na samym koncu
            System.out.println("4.) Usun istniejaca aktywnosc");//usuwa wybrana aktywnosc z bazy danych
            System.out.println("5.) Sprawdz statystyki aktywnosci");//sprawdza statystyki wybranej aktywnosci badz odpala tabele??
            System.out.println("6.) Ustawienia uzytkownika");//zmiana nazwy uzytkownika, hasla, maila
            System.out.println("7.) Wyjscie");

            System.out.println("Wpisz wybor ");
            choice = input.nextInt();


            switch (choice) {
                case 1 -> System.out.println("Wybierz aktywnosc");
                case 2 -> System.out.println("Wpisz nowa aktywosc");
                case 3 -> {
                    System.out.println("Uzyj domyslnego pomodoro bez tworzenia aktywnosci");
                    Pomodoro pomodoro = new Pomodoro();
                    System.out.println("Rozpoczxynam domyslnmy timer 25m");
                    pomodoro.pomodoroTimer(25);
                    System.out.println("");
                    System.out.println("Czas na przerwe!");
                    pomodoro.pomodoroTimer(5);
                }
                case 4 -> System.out.println("Usun istniejaca aktywnosc");
                case 5 -> System.out.println("Sprawdz statystyki aktywnosci");
                case 6 -> System.out.println("Ustawienia uzytkownika");

                //System.exit(0);
                case 7 -> {
                    System.out.println("Wyjscie");
                    System.exit(0);
                }
                default -> System.out.println("Nie istnieje taka opcja: " + choice + "\nProsze wybrac istniejaca opcje.");
            }
        }
        while(choice != 7 /*Exit loop when choice is 7*/);


    }

    }

