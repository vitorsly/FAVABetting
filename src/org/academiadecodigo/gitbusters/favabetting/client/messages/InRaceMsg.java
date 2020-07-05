package org.academiadecodigo.gitbusters.favabetting.client.messages;

import org.academiadecodigo.gitbusters.favabetting.client.Client;
import org.academiadecodigo.gitbusters.favabetting.client.Print;

public class InRaceMsg implements Messages{

    @Override
    public void run(Client client, String msg) {
        new Print("A race has already started. Wait for the next round");
        client.getMenu().mainMenu();
    }
}
