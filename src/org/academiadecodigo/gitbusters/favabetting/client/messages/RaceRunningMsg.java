package org.academiadecodigo.gitbusters.favabetting.client.messages;

import org.academiadecodigo.gitbusters.favabetting.client.Client;
import org.academiadecodigo.gitbusters.favabetting.client.Print;

public class RaceRunningMsg implements Messages {

    @Override
    public void run(Client client, String msg) {
        new Print("A race is still running, wait for the next round");
        //System.out.println("A race is still running, wait for the next round");
    }
}
