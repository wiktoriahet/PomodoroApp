package com.pomodoro;

public class Activity implements IActivity{

    @Override
    public void chooseActivity(String id, String activityName){
        System.out.println("You chose activity");//for now
    }

    @Override
    public void createNewActivity(String id, String activityName) {
        System.out.println("Created new activity");//for now
    }

    @Override
    public void deleteActivity(String id, String activityName) {
        System.out.println("Deleted activity");//for now
    }

    @Override
    public void checkActivityStatistics(String id, String activityName) {
        System.out.println("Activity stats");//for now
    }
}
