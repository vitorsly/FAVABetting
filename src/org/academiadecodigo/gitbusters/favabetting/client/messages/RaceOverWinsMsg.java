package org.academiadecodigo.gitbusters.favabetting.client.messages;

import org.academiadecodigo.gitbusters.favabetting.client.Client;

public class RaceOverWinsMsg implements Messages {
    @Override
    public void run(Client client, String msg) {
        //aqui dizemos qual foi o cavalo vensedor
        client.getMenu().mainMenu();
    }
}
