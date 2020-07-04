package org.academiadecodigo.gitbusters.favabetting.server.messages;

import org.academiadecodigo.gitbusters.favabetting.server.Client;
import org.academiadecodigo.gitbusters.favabetting.server.Server;

import javax.xml.catalog.Catalog;

public class BetMessage implements Message {

    @Override
    public void send(Client client, Server server) {
        //Send Confirmation to client
        client.sendMessage("bet ok");
    }

    @Override
    public void receive(Client client, Server server, String msg) {

        String[]msgSplit=msg.split(" ");
        if(msgSplit.length<3){
            System.out.println("nao contem todos os campos");
            return;
        }
        try {
            int horseNumber = Integer.parseInt(msgSplit[1]);
            int betAmount= Integer.parseInt(msgSplit[2]);
        } catch (Exception e){
            client.sendMessage("bet Not Register");
            System.out.println("Variable is not INT "+e.getMessage());
            return;
        }

        send(client,server);
    }
}
