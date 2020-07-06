package org.academiadecodigo.gitbusters.favabetting.client;

import java.io.IOException;

public class Print extends Thread {

    String msg;
    public Print(String msg){
        this.msg = msg;
        start();
    }

    @Override
    public void run() {

        try {
            Runtime.getRuntime().exec("cls");
        } catch (IOException e) {
        }

        System.out.println("");
        System.out.println(msg);
    }
}
