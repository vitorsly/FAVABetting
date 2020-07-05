package org.academiadecodigo.gitbusters.favabetting.server.messages;

import org.academiadecodigo.gitbusters.favabetting.server.Client;
import org.academiadecodigo.gitbusters.favabetting.server.Server;

public class QuitMessage implements Message{


    @Override
    public void send(Client client, Server server) {

    }

    @Override
    public void receive(Client client, Server server, String msg) {
        server.removeClient(client);
    }
}
