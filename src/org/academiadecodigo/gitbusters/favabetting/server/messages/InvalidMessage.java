package org.academiadecodigo.gitbusters.favabetting.server.messages;

import org.academiadecodigo.gitbusters.favabetting.server.Client;
import org.academiadecodigo.gitbusters.favabetting.server.Server;

public class InvalidMessage implements Message{
    @Override
    public void send(Client client, Server server) {
        System.out.println("Invalid Message");
        client.sendMessage("Invalid Command");
    }

    @Override
    public void receive(Client client, Server server, String msg) {
        System.out.println("Invalid Message");
        send(client,server);
    }
}
