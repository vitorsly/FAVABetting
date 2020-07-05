package org.academiadecodigo.gitbusters.favabetting.server.messages;

import org.academiadecodigo.gitbusters.favabetting.server.Client;
import org.academiadecodigo.gitbusters.favabetting.server.Server;
import org.academiadecodigo.gitbusters.favabetting.server.cheats.CheatShop;
import org.academiadecodigo.gitbusters.favabetting.server.cheats.Cheats;

public class CheatsMessage implements Message {

    @Override
    public void send(Client client, Server server) {
        Cheats[] allCheats= CheatShop.getCheats();
        StringBuilder msg= new StringBuilder("CheatShop ");
        for (int i = 0; i < allCheats.length; i++) {
            msg.append(allCheats[i].getName()).append("#")
                    .append(allCheats[i].getDescription()).append("#")
                    .append(allCheats[i].getPrice()).append("$");
        }
        client.sendMessage(msg.toString());
    }

    @Override
    public void receive(Client client, Server server, String msg) {
        send(client,server);
    }
}
