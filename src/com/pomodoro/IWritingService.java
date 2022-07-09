package com.pomodoro;

public interface IWritingService {

    String NEW_LINE = "\n";
    String WELCOME = "WELCOME ";
    String CREATE = "CREATE ";
    String CREATED = "CREATED ";
    String CONTINUE = "CONTINUE ";
    String DELETE = "DELETE ";
    String ACCOUNT = "ACCOUNT ";
    String PASSWORD = "PASSWORD ";
    String REPEAT = "REPEAT ";
    String OLD = "OLD ";
    String AGAIN = "AGAIN ";
    String ALREADY = "ALREADY ";
    String EXISTS = "EXISTS ";
    String AS = "AS ";
    String A = "A ";
    String AN = "AN ";
    String THE = "THE ";
    String IN = "IN ";
    String ABOUT = "ABOUT ";
    String GUEST = "GUEST ";
    String N_EW = "NEW ";
    String CHOOSE = "CHOOSE ";
    String CHOICE = "CHOICE ";
    String TYPE = "TYPE ";
    String USER = "USER ";
    String YOUR = "YOUR ";
    String NAME = "NAME ";
    String APP = "APP ";
    String POMODORO = "POMODORO ";
    String INFO = "INFO ";
    String EXIT = "EXIT ";
    String PREVIOUS = "PREVIOUS";
    String NEXT = "NEXT";
    String ONE = "(1). ";
    String TWO = "(2). ";
    String THREE = "(3). ";
    String FOUR = "(4). ";
    String FIVE = "(5). ";
    String SIX = "(6). ";
    String SEVEN = "(7). ";
    String EIGHT = "(8). ";
    String NINE = "(9). ";
    String TEN = "(10). ";

    public void helloMessageMenu();
    public String typeUserName();
    public String typePassword();
    public int typeChoiceNumber();
    public String typeChoiceText();

}
