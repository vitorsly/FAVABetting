package org.academiadecodigo.gitbusters.favabetting.client.messages;

import org.academiadecodigo.gitbusters.favabetting.client.Client;
import org.academiadecodigo.gitbusters.favabetting.client.Print;

public class BetOkMsg implements Messages{
    @Override
    public void run(Client client, String msg) {
        new Print("Your bet was Placed");
        client.getMenu().saveTransaction(msg);
        client.getMenu().mainMenu();
    }
}
