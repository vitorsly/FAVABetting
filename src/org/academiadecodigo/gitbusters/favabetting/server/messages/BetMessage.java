package org.academiadecodigo.gitbusters.favabetting.server.messages;

import org.academiadecodigo.gitbusters.favabetting.server.Client;
import org.academiadecodigo.gitbusters.favabetting.server.Server;


public class BetMessage implements Message {

    @Override
    public void send(Client client, Server server) {
        client.sendMessage("betOK");
    }

    @Override
    public void receive(Client client, Server server, String msg) {
        if(server.getRace().getInRace()){
            client.sendMessage("racerunning");
            return;
        }
        String[]msgSplit=msg.split(" ");
        if(msgSplit.length<3){
            System.out.println("nao contem todos os campos");
            return;
        }
        try {
            int horseNumber = Integer.parseInt(msgSplit[1]);
            int betAmount= Integer.parseInt(msgSplit[2]);
            if(client.getWallet().Withdraw(betAmount)){
                server.getRace().placeBet(client,horseNumber-1,betAmount);
                client.sendMessage("betOK Horse: "+horseNumber+" amount: "+betAmount+" balance: "+client.getWallet().getBalance());
            }
            else{
                client.sendMessage("noFunds");
            }
        } catch (Exception e){
            e.getMessage();
        }

        send(client,server);
    }
}
