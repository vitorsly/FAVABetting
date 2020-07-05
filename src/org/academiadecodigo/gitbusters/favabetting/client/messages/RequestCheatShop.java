package org.academiadecodigo.gitbusters.favabetting.client.messages;

import org.academiadecodigo.gitbusters.favabetting.client.Client;
import org.academiadecodigo.gitbusters.favabetting.client.Print;
import org.academiadecodigo.gitbusters.favabetting.client.messages.Messages;

public class RequestCheatShop implements Messages {
    @Override
    public void run(Client client, String msg) {

        String shopItems=msg.substring(10);
        String[] cheatsAndHorses = shopItems.split("\\$");

        client.getMenu().makeInfluenceRaceMenu(cheatsAndHorses);
    }
}
