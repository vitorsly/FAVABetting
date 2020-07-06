package org.academiadecodigo.gitbusters.favabetting.server.messages;

import org.academiadecodigo.gitbusters.favabetting.server.Client;
import org.academiadecodigo.gitbusters.favabetting.server.Server;

public class BetMessage implements Message {

    int betAmount;
    int horseNumber;

    @Override
    public void send(Client client, Server server) {
        client.sendMessage("betOK Horse: " + horseNumber+" | Amount: " + betAmount +
                " | Balance: " + client.getWallet().getBalance());
    }

    @Override
    public void receive(Client client, Server server, String msg) {

        if(server.getRace().getInRace()) {
            client.sendMessage("racerunning");
            return;
        }

        String[]msgSplit = msg.split(" ");

        if(msgSplit.length < 3){
            return;
        }

        try {

            horseNumber = Integer.parseInt(msgSplit[1]);
            betAmount = Integer.parseInt(msgSplit[2]);

            if(client.getWallet().Withdraw(betAmount)){
                server.getRace().placeBet(client,horseNumber - 1,betAmount);
                send(client,server);
            } else{
                client.sendMessage("noFunds");
                return;
            }

        } catch (Exception e){
            e.getMessage();
        }
    }
}
