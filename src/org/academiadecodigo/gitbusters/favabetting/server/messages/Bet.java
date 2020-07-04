package org.academiadecodigo.gitbusters.favabetting.server.messages;

import org.academiadecodigo.gitbusters.favabetting.server.Client;
import org.academiadecodigo.gitbusters.favabetting.server.Server;

public class Bet implements Message {

    @Override
    public void send(Client client, Server server) {
        //Send Confirmation to client
    }

    @Override
    public void receive(Client client, Server server) {
        //recieve bet
    }
}
