package org.academiadecodigo.gitbusters.favabetting.server.messages;

import org.academiadecodigo.gitbusters.favabetting.server.Client;
import org.academiadecodigo.gitbusters.favabetting.server.Server;
import org.academiadecodigo.gitbusters.favabetting.server.cheats.CheatShop;

public class RegisterCheatMessage implements Message {

    String cheatName;
    String horseName;
    double cheatPrice;

    @Override
    public void send(Client client, Server server) {
        client.sendMessage("successCheat Cheat --> Horse: " + horseName + " | Cheat: " +
                cheatName + " | Price: " + cheatPrice + "$");
    }

    @Override
    public void receive(Client client, Server server, String msg) {

        String[] cheatAndHorse = msg.split(" ");

        if (cheatAndHorse.length < 3) {
            client.sendMessage("Invalid cheat or horse..");
            return;
        }

        int cheatIndex = Integer.parseInt(cheatAndHorse[1]) - 1;
        int horseIndex = Integer.parseInt(cheatAndHorse[2]) - 1;
        horseName = server.getRace().getEnrolledHorses().get(horseIndex).getName();
        cheatName = CheatShop.getCheats()[cheatIndex].getName();
        cheatPrice = CheatShop.getCheats()[cheatIndex].getPrice();

        if (!CheatShop.buyCheat(cheatIndex, client, server.getRace().getEnrolledHorses().get(horseIndex))) {
            client.sendMessage("Unable to buy cheat...");
            return;
        }

        send(client, server);
    }
}
