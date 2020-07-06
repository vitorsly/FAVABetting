package org.academiadecodigo.gitbusters.favabetting.client.messages;

import org.academiadecodigo.gitbusters.favabetting.client.Client;
import org.academiadecodigo.gitbusters.favabetting.client.Print;

public class NameChangedMsg implements Messages {

    @Override
    public void run(Client client, String msg) {

        new Print("Your name was changed successfully!");

        client.getMenu().mainMenu();
    }
}
