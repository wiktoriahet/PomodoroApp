package com.pomodoro;

import java.util.Collections;


public class Pomodoro {

    WritingService writingService = new WritingService();

    public Pomodoro() {
    }

    public void pomodoroTimer(long total) {

        long nTotal = total*60;//changes time typed in minutes to seconds

        for (int i = 1; i <= nTotal; i++) {
            try {
                Thread.sleep(1000);
                printProgress(nTotal, i);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    private static void printProgress( long total, long current) {

        long currentTime = current;

        long hours = total/60/60;
        long minutes = total/60;
        long seconds = total%60;

        if(minutes>59){
            minutes=0;
        }

        if(seconds>59){
            seconds=0;
        }

        long activityTime = currentTime;
        long currentHours = activityTime/60/60;
        long currentMinutes = activityTime/60;
        long currentSeconds = activityTime%60;

        if(currentMinutes>59){
            currentMinutes = 0;
        }
        if(currentSeconds>59){
            currentSeconds = 0;
        }

        StringBuilder string = new StringBuilder(140);
        int percent = (int) (current * 100 / total);
        string
                .append('\r')

                .append(String.join("",
                        Collections.nCopies(percent == 0 ? 2 : 2 - (int)
                                (Math.log10(percent)), " ")))

                .append(String.format(" %d%% [",
                        percent))

                .append(String.join("",
                        Collections.nCopies(percent, "=")))

                .append('>')

                .append(String.join("",
                        Collections.nCopies(100 - percent, " ")))

                .append(']')

                .append(String.format(" %s:%s:%s/%s:%s:%s",
                        zeroAdder(currentHours),
                        zeroAdder(currentMinutes),
                        zeroAdder(currentSeconds),
                        zeroAdder(hours),
                        zeroAdder(minutes),
                        zeroAdder(seconds)));

        System.out.print(string);
    }


    public void session(int sessionCount, long workTime, long shortBreakTime){
        int counter = sessionCount;
        while(counter>0) {

            writingService.newPomodoroSession();
            writingService.newWorkSession();
            String toStart = writingService.typeToStart();
            startingAfterTyping(toStart, workTime);
            writingService.newBreakSession();
            toStart = writingService.typeToStart();
            startingAfterTyping(toStart, shortBreakTime);
            counter--;

        }
    }

    public void session(int sessionCount, long workTime, long shortBreakTime, long longBreakTime){
        int counter = sessionCount;
        while(counter>0){

            writingService.newPomodoroSession();
            writingService.newWorkSession();
            String toStart = writingService.typeToStart();
            startingAfterTyping(toStart, workTime);
            writingService.newBreakSession();
            toStart = writingService.typeToStart();
            if(counter%2==0){
            startingAfterTyping(toStart, longBreakTime);}
            else{
                startingAfterTyping(toStart, shortBreakTime);
            }

            counter--;

            //to do: add possibility of choosing break time different then default after each work session
        }
    }

    public void defaultSession(){
        long workTime = 25;
        long shortBreakTime = 5;
        int sessionCount = 5;
        session(sessionCount, workTime, shortBreakTime);
    }

    private void startingAfterTyping(String type, long time){

        if(!type.isEmpty()){
            pomodoroTimer(time);
        } //to do: what if it's empty?


    }


    private static String zeroAdder(long time){
        if(time<10){
            return "0"+time;
        } else return ""+time;

    }

    }










