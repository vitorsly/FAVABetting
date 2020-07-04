package org.academiadecodigo.gitbusters.favabetting.server.messages;

import org.academiadecodigo.gitbusters.favabetting.server.Client;
import org.academiadecodigo.gitbusters.favabetting.server.Server;

public class ForceMainMenu implements Message {
    @Override
    public void send(Client client, Server server) {
        client.sendMessage("mainmenu");
    }

    @Override
    public void receive(Client client, Server server, String msg) {
        send(client,server);
    }
}
