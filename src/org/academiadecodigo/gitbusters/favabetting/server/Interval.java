package org.academiadecodigo.gitbusters.favabetting.server;

public class Interval implements Runnable {

    private boolean inInterval;
    private int time;

    public Interval(Integer timer){
        time = timer;
        inInterval = true;
    }

    @Override
    public void run() {

        while (time > 0) {

            time--;

            try {
                Thread.currentThread().sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        inInterval = false;
    }

    public boolean getInInterval(){
        return inInterval;
    }
}
