package org.academiadecodigo.gitbusters.favabetting.server;

public class Interval implements Runnable {
    private boolean inInterval=false;
    private int time=0;

    Interval(Integer timer){
        time=timer;
        inInterval=true;
    }

    public boolean getInInterval(){
        return inInterval;
    }

    @Override
    public void run() {
        while (time>0){
            time--;
            try {
                Thread.currentThread().sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        inInterval=false;
    }


}
