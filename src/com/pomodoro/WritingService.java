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

    @Override
    public void helloMessageUserMenu(String userName){
        welcomeNameMessage(userName);
        StringBuilder msg = new StringBuilder(NEW_LINE);
        msg.append(ONE).append(CHOOSE).append(ACTIVITY).append(FROM).append(EXISTING);
        msg.append(NEW_LINE);
        msg.append(TWO).append(CREATE).append(N_EW).append(ACTIVITY);
        msg.append(NEW_LINE);
        msg.append(THREE).append(USE).append(DEFAULT).append(POMODORO).append(WITHOUT).append(CREATING).append(ACTIVITY);
        msg.append(NEW_LINE);
        msg.append(FOUR).append(DELETE).append(EXISTING).append(ACTIVITY);
        msg.append(NEW_LINE);
        msg.append(FIVE).append(CHECK).append(ACTIVITY).append(STATISTICS);
        msg.append(NEW_LINE);
        msg.append(SIX).append(USER).append(ACCOUNT).append(SETTINGS);
        msg.append(NEW_LINE);
        msg.append(SEVEN).append(EXIT);

        printMessage(msg);
    }

    public void newPomodoroSession(){
        StringBuilder msg = new StringBuilder(NEW_LINE);
        msg.append(N_EW).append(POMODORO).append(SESSIONs);
        printMessage(msg);
    }

    public void newWorkSession(){
        StringBuilder msg = new StringBuilder(NEW_LINE);
        msg.append(N_EW).append(WORK).append(SESSIONs);
        printMessage(msg);
    }

    public void newBreakSession(){
        StringBuilder msg = new StringBuilder(NEW_LINE);
        msg.append(N_EW).append(BREAK).append(SESSIONs);
        printMessage(msg);
    }

    public String typeToStart(){
        StringBuilder msg = new StringBuilder(NEW_LINE);
        msg.append(TYPE).append(ANYTHING).append(TO).append(START);
        printMessage(msg);
        Scanner input = new Scanner(System.in);
        return input.nextLine();
    }

    //never used yet
    public String typeToStop(){
        StringBuilder msg = new StringBuilder(NEW_LINE);
        msg.append(TYPE).append(ANYTHING).append(TO).append(STOP);
        printMessage(msg);
        Scanner input = new Scanner(System.in);
        return input.nextLine();
    }

    public void userDeleted(String userName){
        StringBuilder msg = new StringBuilder(NEW_LINE);
        msg.append(USER).append(userName).append(DELETED);
        printMessage(msg);
    }

    public void loggedAsUserNameMessage(String userName){
        StringBuilder msg = new StringBuilder(NEW_LINE);
        msg.append(LOGGED).append(AS).append(userName);
        printMessage(msg);
    }

    public void userNameAlreadyExists(){
        StringBuilder msg = new StringBuilder(NEW_LINE);
        msg.append(USER).append(NAME).append(ALREADY).append(EXISTS);
        printMessage(msg);
    }

    public void pleaseTryAgain(){
        StringBuilder msg = new StringBuilder(NEW_LINE);
        msg.append(PLEASE).append(CHOOSE).append(AGAIN);
        printMessage(msg);
    }

    public void yesOrNo(){
        StringBuilder msg = new StringBuilder(NEW_LINE);
        msg.append(ONE).append(YES);
        msg.append(TWO).append(NO);
        printMessage(msg);
    }

    public void createAnAccountToSave(){
        StringBuilder msg = new StringBuilder(NEW_LINE);
        msg.append(CREATE).append(AN).append(ACCOUNT).append(TO).append(SAVE).append(YOUR).append(DATA);
        printMessage(msg);
    }

    public void doYouWantToCreateNewAccount(){
        StringBuilder msg = new StringBuilder(NEW_LINE);
        msg.append(DO).append(YOU).append(WANT).append(TO).append(CREATE).append(N_EW).append(ACCOUNT).append("?");
        printMessage(msg);
    }

    public void choiceDoesntExist(){
        StringBuilder msg = new StringBuilder(NEW_LINE);
        msg.append(CHOICE).append(DOES).append(NOT).append(EXIST);
        printMessage(msg);
    }

    public void shortBreakDurationMessage(){
        StringBuilder msg = new StringBuilder(NEW_LINE);
        msg.append(SHORT).append(BREAK).append(DURATION);
        printMessage(msg);
    }

    public void longBreakDurationMessage(){
        StringBuilder msg = new StringBuilder(NEW_LINE);
        msg.append(LONG).append(BREAK).append(DURATION);
        printMessage(msg);
    }

    public void sessionCountMessage(){
        StringBuilder msg = new StringBuilder(NEW_LINE);
        msg.append(SESSIONs).append(COUNT);
        printMessage(msg);
    }

    public void typeWorkTimeMessage(){
        StringBuilder msg = new StringBuilder(NEW_LINE);
        msg.append(WORK).append(TIME).append(DURATION);
        printMessage(msg);
    }

    public StringBuilder wrongPassword(){
        StringBuilder msg = new StringBuilder(NEW_LINE);
        return msg.append(WRONG).append(PASSWORD);
    }
    public void wrongPasswordMessage(){
        printMessage(wrongPassword());
    }

    public StringBuilder wrongUserName(){
        StringBuilder msg = new StringBuilder(NEW_LINE);
        return msg.append(WRONG).append(USER).append(NAME);
    }
    public void wrongUserNameMessage(){
        printMessage(wrongUserName());
    }

    public void wrongPasswordOrUserName(){
        StringBuilder msg = new StringBuilder(NEW_LINE);
        msg.append(wrongPassword()).append(OR).append(wrongUserName());
        printMessage(msg);
    }

    public void defaultOrCustomSettings(){
        StringBuilder msg = new StringBuilder(NEW_LINE);
        msg.append(ONE).append(CHOOSE).append(DEFAULT).append(POMODORO).append(SETTINGS);
        msg.append(NEW_LINE);
        msg.append(TWO).append(CHOOSE).append(YOUR).append(OWN).append(SETTINGS);
        msg.append(NEW_LINE);
        msg.append(THREE).append(INFO).append(ABOUT).append(POMODORO).append(APP).append(AND).append(SETTINGS);

        printMessage(msg);
    }

    public void welcomeNameMessage(String userName){
        StringBuilder msg = new StringBuilder(NEW_LINE);
        msg.append(WELCOME).append(userName);

        printMessage(msg);
    }

    public void goodByeMessage(){
        StringBuilder msg = new StringBuilder(NEW_LINE);
        msg.append(GOOD_BYE);

        printMessage(msg);
    }

    public void infoAboutPomAppMessage(){
        StringBuilder msg = new StringBuilder(NEW_LINE);
        msg.append(INFO).append(ABOUT).append(POMODORO).append(APP);

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
        return input.nextLine();
    }

    @Override
    public String typePassword(){
        typePasswordMessage();
        Scanner input = new Scanner(System.in);
        return input.nextLine();
    }

    @Override
    public int typeChoiceNumber(){
        typeYourChoiceMessage();
        Scanner input = new Scanner(System.in);
        return input.nextInt();
    }

    //not used anywhere yet. to delete?
    @Override
    public String typeChoiceText(){
        typeYourChoiceMessage();
        Scanner input = new Scanner(System.in);
        return input.nextLine();
    }

    private void printMessage(StringBuilder sb){
        System.out.println(sb);
    }

}
