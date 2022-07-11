package com.pomodoro;


public class Guest {

    public void guestStart(){

        WritingService writingService = new WritingService();
        Pomodoro pomodoro = new Pomodoro();
        User user = new User();

        String name;
        int choice;
        String breakTypes;
        long workTime = 25;
        long shortBreakTime = 5;
        long longBreakTime = 10;
        int sessionCount = 5;

        name = writingService.typeUserName();
        writingService.welcomeNameMessage(name);
        writingService.defaultOrCustomSettings();
        //wiecej info o sesjach dodac odnosnik do info

        choice = writingService.typeChoiceNumber();

        switch (choice) {
            case 1 -> pomodoro.session(sessionCount, workTime, shortBreakTime);
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
        writingService.createAnAccountToSave();
        writingService.yesOrNo();
        int yesOrNo = writingService.typeChoiceNumber();
        if(yesOrNo==1) {
            user.addUser();
        } else {writingService.goodByeMessage();}

    }
}
