package org.academiadecodigo.gitbusters.favabetting.server.messages;

import org.academiadecodigo.gitbusters.favabetting.server.Client;
import org.academiadecodigo.gitbusters.favabetting.server.Server;

public class NameChangeMsg implements Message {
    @Override
    public void send(Client client, Server server) {
        client.sendMessage("name was changed successful");
    }

    @Override
    public void receive(Client client, Server server, String msg) {
        String[] nameSplit=msg.split(" ");
        if(nameSplit.length<2){
            System.out.println("name invalid");
            return;
        }
        client.setName(nameSplit[1]);
        send(client,server);
    }
}
