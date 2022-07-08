package com.pomodoro;
import java.util.Scanner;


public class Menu {

    public void printMenu(){

        Scanner input = new Scanner(System.in);
        User user = new User();
        WritingService writingService = new WritingService();

        int choice;

        do {
            System.out.println("WITAJ W APLIKACJI POMODORO");
            System.out.println("1.) Wybierz uzytkownika");
            System.out.println("2.) Stworz nowego uzytkownika");
            System.out.println("3.) Kontynuuj jako gosc");
            System.out.println("4.) Usun uzytkownika");
            System.out.println("5.) Informacje o pomodoro i aplikacji");
            System.out.println("6.) Wyjscie");

            choice = writingService.typeChoiceNumber();

            switch (choice) {

                case 1:
                    System.out.println("Wybierz uzytkownika");
                    user.chooseUser();

                    //TU SIE MA OTWIERAC DALSZA CZESC DO POMODORO
                    //dodaj aktywnosc
                    //usun aktywnosc
                    //sprawdz statystyki aktywnosci
                    //usun uzytkownika
                    choice = 6;//potrzebne?
                    break;

                case 2:
                    choice = 6;
                    System.out.println("Stworz nowego uzytkownika");
                    user.addUser();
                    break;

                case 3:
                    System.out.println("Kontynuuj jako gosc");
                    Guest guest = new Guest();
                    guest.guestStart();
                    break;

                case 4:
                    System.out.println("Usun uzytkownika");
                    user.deleteUser();
                    choice = 6;
                    break;

                case 5:
                    System.out.println("Informacje: ");
                    //info o pomodoro
                    //info o apce
                    break;
                case 6:
                    System.out.println("DO ZOBACZENIA");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Nie istnieje taka opcja: "+ choice + "\nProsze wybrac istniejaca opcje.");

            }
        }
            while(choice != 6 /*Exit loop when choice is 6*/);

        }
    }





