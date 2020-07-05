package org.academiadecodigo.gitbusters.favabetting.server.messages;

import org.academiadecodigo.gitbusters.favabetting.server.Client;
import org.academiadecodigo.gitbusters.favabetting.server.Server;

public class RegisterCheatMessage implements Message{


    @Override
    public void send(Client client, Server server) {
        client.sendMessage("Your cheat was registered!");
        client.sendMessage("mainmenu");
    }

    @Override
    public void receive(Client client, Server server, String msg) {
        String[] cheat = msg.split(" ");
        if(cheat.length<3){
            client.sendMessage("Invalid name");
            return;
        }
        client.setName(cheat[1]);
        send(client,server);
    }
}
