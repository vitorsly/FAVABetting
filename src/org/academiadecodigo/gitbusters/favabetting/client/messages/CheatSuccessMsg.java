package org.academiadecodigo.gitbusters.favabetting.client.messages;

import org.academiadecodigo.gitbusters.favabetting.client.Client;
import org.academiadecodigo.gitbusters.favabetting.client.Print;

public class CheatSuccessMsg implements Messages{

    @Override
    public void run(Client client, String msg) {

        new Print("Your cheat was registered!");

        client.getMenu().mainMenu();
    }
}
