package org.academiadecodigo.gitbusters.favabetting.client.messages;

import org.academiadecodigo.gitbusters.favabetting.client.Client;

public class BetOkMsg implements Messages{
    @Override
    public void run(Client client, String msg) {
        System.out.println("Your bet was Placed");
        client.getMenu().saveTransaction(msg);
        client.getMenu().mainMenu();
    }
}
