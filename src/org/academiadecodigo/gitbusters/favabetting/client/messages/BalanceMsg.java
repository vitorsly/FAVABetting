package org.academiadecodigo.gitbusters.favabetting.client.messages;

import org.academiadecodigo.gitbusters.favabetting.client.Client;
import org.academiadecodigo.gitbusters.favabetting.client.Print;

public class BalanceMsg implements Messages {

    @Override
    public void run(Client client, String msg) {
        String balance = msg.split(" ")[1];

        new Print("Wallet balance: " + balance + "$");
        client.getMenu().mainMenu();
        //System.out.println("Wallet balance: " + balance + "$");

    }
}
