package org.academiadecodigo.gitbusters.favabetting.client.messages;

import org.academiadecodigo.gitbusters.favabetting.client.Client;

public class RaceRunningMsg implements Messages{
    @Override
    public void run(Client client, String msg) {

        System.out.println("A race is still running, wait for the next round");

    }
}
