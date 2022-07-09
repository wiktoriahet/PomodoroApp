package com.pomodoro;

import java.util.Scanner;

public class WritingService implements IWritingService{

    public WritingService() {
    }


    @Override
    public void helloMessageMenu() {
        StringBuilder msg = new StringBuilder(NEW_LINE);
        msg.append(WELCOME).append(IN).append(POMODORO).append(APP).append("!");
        msg.append(NEW_LINE);
        msg.append(ONE).append(CHOOSE).append(USER);
        msg.append(NEW_LINE);
        msg.append(TWO).append(CREATE).append(N_EW).append(USER).append(ACCOUNT);
        msg.append(NEW_LINE);
        msg.append(THREE).append(CONTINUE).append(AS).append(A).append(GUEST);
        msg.append(NEW_LINE);
        msg.append(FOUR).append(DELETE).append(USER).append(ACCOUNT);
        msg.append(NEW_LINE);
        msg.append(FIVE).append(INFO).append(ABOUT).append(POMODORO).append(APP);
        msg.append(NEW_LINE);
        msg.append(SIX).append(EXIT);

        printMessage(msg);
    }

    public void deleteUserMessage(){
        StringBuilder msg = new StringBuilder(NEW_LINE);
        msg.append(DELETE).append(USER).append(ACCOUNT);

        printMessage(msg);
    }

    public void newUserCreatedMessage(String userName){
        StringBuilder msg = new StringBuilder(NEW_LINE);
        msg.append(N_EW).append(USER).append(ACCOUNT).append(CREATED).append(userName);

        printMessage(msg);
    }

    public void createNewUserMessage(){
        StringBuilder msg = new StringBuilder(NEW_LINE);
        msg.append(CREATE).append(N_EW).append(USER).append(ACCOUNT);

        printMessage(msg);
    }

    public void continueAsAGuestMessage(){
        StringBuilder msg = new StringBuilder(NEW_LINE);
        msg.append(CONTINUE).append(AS).append(A).append(GUEST);

        printMessage(msg);
    }

    public void typeUserNameMessage(){
        StringBuilder msg = new StringBuilder(NEW_LINE);
        msg.append(TYPE).append(USER).append(NAME);

        printMessage(msg);
    }

    public void typeYourChoiceMessage(){
        StringBuilder msg = new StringBuilder(NEW_LINE);
        msg.append(TYPE).append(YOUR).append(CHOICE);

        printMessage(msg);
    }

    public void typePasswordMessage(){
        StringBuilder msg = new StringBuilder(NEW_LINE);
        msg.append(TYPE).append(PASSWORD);

        printMessage(msg);
    }

    @Override
    public String typeUserName(){
        typeUserNameMessage();
        Scanner input = new Scanner(System.in);
        String userName = input.nextLine();
        return userName;
    }

    @Override
    public String typePassword(){
        typePasswordMessage();
        Scanner input = new Scanner(System.in);
        String password = input.nextLine();
        return password;
    }

    @Override
    public int typeChoiceNumber(){
        typeYourChoiceMessage();
        Scanner input = new Scanner(System.in);
        int choice = input.nextInt();
        return choice;
    }

    @Override
    public String typeChoiceText(){
        typeYourChoiceMessage();
        Scanner input = new Scanner(System.in);
        String choice = input.nextLine();
        return choice;
    }

    private void printMessage(StringBuilder sb){
        System.out.println(sb);
    }

}
