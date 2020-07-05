package org.academiadecodigo.gitbusters.favabetting.server.messages;

import org.academiadecodigo.gitbusters.favabetting.server.Client;
import org.academiadecodigo.gitbusters.favabetting.server.Server;
import org.academiadecodigo.gitbusters.favabetting.server.cheats.CheatShop;
import org.academiadecodigo.gitbusters.favabetting.server.cheats.Cheats;
import org.academiadecodigo.gitbusters.favabetting.server.horses.Horse;

import java.util.List;

public class CheatsMessage implements Message {

    @Override
    public void send(Client client, Server server) {
        Cheats[] allCheats= CheatShop.getCheats();
        StringBuilder msg= new StringBuilder("CheatShop ");
        for (int i = 0; i < allCheats.length; i++) {
            msg.append(allCheats[i].getName()).append("#")
                    .append(allCheats[i].getDescription()).append("#")
                    .append(allCheats[i].getPrice()).append("%");
        }
        msg.append("$");

        List<Horse> hl = server.getRace().getEnrolledHorses();
        for(Horse horse:hl){
            msg.append(horse.getName()).append("#")
                    .append(horse.getDescription()).append("#")
                    .append(horse.getOdds()).append("#")
                    .append(horse.getWins()).append("#")
                    .append(horse.getRaces()).append("%");
        }

        client.sendMessage(msg.toString());
    }

    @Override
    public void receive(Client client, Server server, String msg) {
        send(client,server);
    }
}
