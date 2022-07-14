package com.pomodoro;

public interface IActivity {

    void chooseActivity(String id, String activityName);
    void createNewActivity(String id, String activityName);
    void deleteActivity(String id, String activityName);
    void checkActivityStatistics(String id, String activityName);
}
