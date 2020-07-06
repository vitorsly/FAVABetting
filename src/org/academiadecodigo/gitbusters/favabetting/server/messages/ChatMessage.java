package org.academiadecodigo.gitbusters.favabetting.server.messages;

import org.academiadecodigo.gitbusters.favabetting.server.Client;
import org.academiadecodigo.gitbusters.favabetting.server.Server;

public class ChatMessage implements Message{



    @Override
    public void send(Client client, Server server) {  }

    @Override
    public void receive(Client client, Server server, String msg) {

        String message = msg.split("#")[1];

        server.broadcastExceptMe(client,"chat "+ client.getName()+": "+ message);

    }
}
