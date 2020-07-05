package org.academiadecodigo.gitbusters.favabetting.client.messages;

import org.academiadecodigo.gitbusters.favabetting.client.Client;
import org.academiadecodigo.gitbusters.favabetting.client.Print;

public class RequestCheatShop implements Messages {
    @Override
    public void run(Client client, String msg) {

        String shopItems=msg.substring(9);
        new Print(shopItems);

        //ta dividico como os cavalos
    }
}
