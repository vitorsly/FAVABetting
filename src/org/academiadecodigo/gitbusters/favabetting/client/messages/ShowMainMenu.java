package org.academiadecodigo.gitbusters.favabetting.client.messages;

import org.academiadecodigo.gitbusters.favabetting.client.Client;

public class ShowMainMenu implements Messages {

    @Override
    public void run(Client client, String msg) {
        client.getMenu().mainMenu();
    }
}
