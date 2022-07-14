package com.pomodoro;

public class UserMenu {

    public void userMenuStartPage(String name){

        WritingService writingService = new WritingService();
        Activity activity = new Activity();
        User user = new User();
        int choice;
        String id = user.getID(name);

        do {
            writingService.helloMessageUserMenu(name);
            choice = writingService.typeChoiceNumber();

            switch (choice) {
                case 1 -> {System.out.println("Wybierz aktywnosc");
                    String activityName = "defaultForNow";//zanim zrobie zeby wpisywac nazwe
                activity.chooseActivity(id, activityName);

                }
                case 2 -> {System.out.println("Wpisz nowa aktywosc");
                    String activityName = "defaultForNow";//zanim zrobie zeby wpisywac nazwe
                    activity.createNewActivity(id, activityName);
                }
                case 3 -> {
                    Pomodoro pomodoro = new Pomodoro();
                    pomodoro.defaultSession();
                    //powinno wrocic do menu tego po zakonczonej sesji, ale propozycja zapisu na koniec dodac
                }
                case 4 -> {System.out.println("Usun istniejaca aktywnosc");
                    String activityName = "defaultForNow";//zanim zrobie zeby wpisywac nazwe
                    activity.deleteActivity(id, activityName);
                }
                case 5 -> {System.out.println("Sprawdz statystyki aktywnosci");
                    String activityName = "defaultForNow";//zanim zrobie zeby wpisywac nazwe
                    activity.checkActivityStatistics(id, activityName);
                }
                case 6 -> {System.out.println("Ustawienia uzytkownika");
                    String password = writingService.typePassword();
                user.userAccountSettings(name, password);//jeszcze nic sie nie dzieje
                }

                //System.exit(0);
                case 7 -> {
                    writingService.goodByeMessage();
                    System.exit(0);
                }
                default -> writingService.choiceDoesntExist();
            }
        }
        while(choice != 7 /*Exit loop when choice is 7*/);


    }

    }

