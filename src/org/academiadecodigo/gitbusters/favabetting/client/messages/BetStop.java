package org.academiadecodigo.gitbusters.favabetting.client.messages;

import org.academiadecodigo.gitbusters.favabetting.client.Client;

public class BetStop implements Messages {
    @Override
    public void run(Client client, String msg) {
        System.out.println("Race is going to Start");
    }
}
