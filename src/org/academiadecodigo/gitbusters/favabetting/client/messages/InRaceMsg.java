package org.academiadecodigo.gitbusters.favabetting.client.messages;

import org.academiadecodigo.gitbusters.favabetting.client.Client;

public class InRaceMsg implements Messages{

    @Override
    public void run(Client client, String msg) {
        System.out.println("Horses are running wait for the next roll");
    }
}
