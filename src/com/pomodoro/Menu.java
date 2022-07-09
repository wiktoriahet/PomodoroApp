package com.pomodoro;
import java.util.Scanner;


public class Menu {

    public void printMenu(){

        Scanner input = new Scanner(System.in);
        User user = new User();
        WritingService writingService = new WritingService();

        int choice;

        do {
            writingService.helloMessageMenu();
            choice = writingService.typeChoiceNumber();

            switch (choice) {

                case 1:

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
                    writingService.createNewUserMessage();
                    user.addUser();
                    break;

                case 3:
                    writingService.continueAsAGuestMessage();
                    Guest guest = new Guest();
                    guest.guestStart();
                    break;

                case 4:
                    writingService.deleteUserMessage();
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





