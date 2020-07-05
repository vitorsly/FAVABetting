package org.academiadecodigo.gitbusters.favabetting.client.messages;

import org.academiadecodigo.gitbusters.favabetting.client.Client;
import org.academiadecodigo.gitbusters.favabetting.client.Print;

public class BetStop implements Messages {
    @Override
    public void run(Client client, String msg) {
        new Print("Race is going to Start");
    }
}
