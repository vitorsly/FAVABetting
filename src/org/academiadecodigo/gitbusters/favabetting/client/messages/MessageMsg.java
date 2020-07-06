package org.academiadecodigo.gitbusters.favabetting.client.messages;

import org.academiadecodigo.gitbusters.favabetting.client.Client;
import org.academiadecodigo.gitbusters.favabetting.client.Print;

public class MessageMsg implements Messages {

    @Override
    public void run(Client client, String msg) {

        String message = msg.substring(8);

        new Print(message);

        client.getMenu().mainMenu();
    }
}
