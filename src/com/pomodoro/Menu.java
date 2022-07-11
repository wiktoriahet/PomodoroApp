package com.pomodoro;

public class Menu {

    public void printMenu(){

        User user = new User();
        WritingService writingService = new WritingService();

        int choice;

        do {
            writingService.helloMessageMenu();
            choice = writingService.typeChoiceNumber();

            switch (choice) {
                case 1 -> {
                    user.chooseUser();
                    //TU SIE MA OTWIERAC DALSZA CZESC DO POMODORO
                    //dodaj aktywnosc
                    //usun aktywnosc
                    //sprawdz statystyki aktywnosci
                    //usun uzytkownika
                    choice = 6;//potrzebne?
                }
                case 2 -> {
                    choice = 6;
                    writingService.createNewUserMessage();
                    user.addUser();
                }
                case 3 -> {
                    choice = 6;
                    writingService.continueAsAGuestMessage();
                    Guest guest = new Guest();
                    guest.guestStart();
                }
                case 4 -> {
                    writingService.deleteUserMessage();
                    user.deleteUser();
                    choice = 6;
                }
                case 5 -> {
                    writingService.infoAboutPomAppMessage();
                    choice = 6;
                }
                //info o pomodoro
                //info o apce
                case 6 -> {
                    writingService.goodByeMessage();
                    System.exit(0);
                }
                default -> System.out.println("Nie istnieje taka opcja: " + choice + "\nProsze wybrac istniejaca opcje.");
            }
        }
            while(choice != 6 /*Exit loop when choice is 6*/);

        }
    }





