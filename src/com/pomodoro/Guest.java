package com.pomodoro;


public class Guest {

    public void guestStart(){

        WritingService writingService = new WritingService();
        Pomodoro pomodoro = new Pomodoro();
        User user = new User();

        String name;
        int choice;
        long workTime;
        long shortBreakTime;
        long longBreakTime;
        int sessionCount;

        name = writingService.typeUserName();
        writingService.welcomeNameMessage(name);
        writingService.defaultOrCustomSettings();
        //add new page choice with info about app and pomodoro method

        choice = writingService.typeChoiceNumber();

        switch (choice) {
            case 1 -> pomodoro.defaultSession();
            case 2 -> {

                writingService.sessionCountMessage();
                sessionCount = writingService.typeChoiceNumber();

                writingService.typeWorkTimeMessage();
                workTime = writingService.typeChoiceNumber();

                writingService.shortBreakDurationMessage();
                shortBreakTime = writingService.typeChoiceNumber();

                writingService.longBreakDurationMessage();
                longBreakTime = writingService.typeChoiceNumber();

                pomodoro.session(sessionCount, workTime, shortBreakTime, longBreakTime);

            }
            case 3 -> {

                writingService.infoAboutPomAppMessage();

            }
            default -> {

                writingService.choiceDoesntExist();

            }
        }

        //ask if guest wants to create new account to save data
        writingService.createAnAccountToSave();
        writingService.yesOrNo();
        int yesOrNo = writingService.typeChoiceNumber();
        if(yesOrNo==1) {
            user.addUser();
        } else {writingService.goodByeMessage();}

    }
}
