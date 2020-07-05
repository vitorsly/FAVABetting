package org.academiadecodigo.gitbusters.favabetting.server.messages;

import org.academiadecodigo.gitbusters.favabetting.server.Client;
import org.academiadecodigo.gitbusters.favabetting.server.Server;
import org.academiadecodigo.gitbusters.favabetting.server.horses.Horse;

import java.util.List;

public class GetHorsesMessage implements Message {

    @Override
    public void send(Client client, Server server) {
       List<Horse> hl = server.getRace().getEnrolledHorses();
       StringBuilder message= new StringBuilder("HorseList ");
       for(Horse horse:hl){
           message.append(horse.getName()).append("#")
                   .append(horse.getDescription()).append("#")
                   .append(horse.getOdds()).append("#")
                   .append(horse.getWins()).append("#")
                   .append(horse.getRaces()).append("%");
       }
       client.sendMessage(message.toString());
    }

    @Override
    public void receive(Client client, Server server, String msg) {
        send(client,server);
    }
}
