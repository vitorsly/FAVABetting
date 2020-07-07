package org.academiadecodigo.gitbusters.favabetting.graphicalinterface.message;

import org.academiadecodigo.gitbusters.favabetting.graphicalinterface.Client;

import java.awt.*;

public class BetOk implements Message{

    @Override
    public void run(Client client, String msg) {
        client.getGraphics().writeStatus("Bet OK", new Color(0,140,0));
    }
}
