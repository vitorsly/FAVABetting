package org.academiadecodigo.gitbusters.favabetting.client.messages;

import org.academiadecodigo.gitbusters.favabetting.client.Client;
import org.academiadecodigo.gitbusters.favabetting.client.Print;

public class NoFunds implements Messages {
    @Override
    public void run(Client client, String msg) {
        new Print("You don't have funds to complete the operation");
        //System.out.println("You don't have funds to complete the operation");
        client.getMenu().mainMenu();
    }
}
