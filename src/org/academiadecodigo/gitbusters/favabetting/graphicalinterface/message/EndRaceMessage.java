package org.academiadecodigo.gitbusters.favabetting.graphicalinterface.message;

import org.academiadecodigo.gitbusters.favabetting.graphicalinterface.Client;

import javax.swing.*;
import java.awt.*;

public class EndRaceMessage implements Message {
    @Override
    public void run(Client client, String msg) {
        client.getGraphics().getRaceLabel().setText("Place your bets");
        client.getGraphics().getRaceLabel().setBorder(BorderFactory.createEtchedBorder(Color.GREEN,Color.black));
        client.sendMessage("getHorses");
        client.sendMessage("balance");
        client.getGraphics().paintLeadingHorse("noHorse");
    }
}
