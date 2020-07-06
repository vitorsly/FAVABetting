package org.academiadecodigo.gitbusters.favabetting.server.messages;

import org.academiadecodigo.gitbusters.favabetting.server.Client;
import org.academiadecodigo.gitbusters.favabetting.server.Server;
import org.academiadecodigo.gitbusters.favabetting.server.horses.Horse;

public class BetMessage implements Message {

    int betAmount;
    int horseNumber;
    String horseName;

    @Override
    public void send(Client client, Server server) {
        client.sendMessage("betOK   Bet --> Horse: " + horseName + " | Amount: " + betAmount +
                "$ | Your balance: " + client.getWallet().getBalance() + "$");
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
            Horse horse = server.getRace().getEnrolledHorses().get(horseNumber -1);
            horseName = horse.getName();

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
