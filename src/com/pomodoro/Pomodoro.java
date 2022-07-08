package com.pomodoro;

import java.util.Collections;


public class Pomodoro {

    public Pomodoro() {
    }

    public void pomodoroTimer(long total) {

        long nTotal = total*60;//zamienia wpisany czas w minutach na czas w sekundach

        for (int i = 1; i <= nTotal; i++) {
            try {
                Thread.sleep(1000);
                printProgress(nTotal, i);
            } catch (InterruptedException e) {
            }
        }
    }
    //elo

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
                                (Math.log10(percent)), " ")))  //formatuje tak, zeby znak % sie nie przesuwal w konsoli

                .append(String.format(" %d%% [",
                        percent)) //ilosc % plus [

                .append(String.join("",
                        Collections.nCopies(percent, "="))) //tyle ile % tyle znakow =

                .append('>')  //> po =

                .append(String.join("",
                        Collections.nCopies(100 - percent, " "))) //miejsce przed kolejnym ]

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

    private static String zeroAdder(long time){
        if(time<10){
            return "0"+time;
        } else return ""+time;

    }


    }










