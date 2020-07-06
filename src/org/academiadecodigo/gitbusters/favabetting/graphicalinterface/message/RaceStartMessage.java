package org.academiadecodigo.gitbusters.favabetting.graphicalinterface.message;

import org.academiadecodigo.gitbusters.favabetting.graphicalinterface.Client;

import javax.swing.*;
import java.awt.*;

public class RaceStartMessage implements Message {
    @Override
    public void run(Client client, String msg) {
        client.getGraphics().getRaceLabel().setText("Racing");
        client.getGraphics().getRaceLabel().setBorder(BorderFactory.createEtchedBorder(Color.red,Color.black));
    }
}
