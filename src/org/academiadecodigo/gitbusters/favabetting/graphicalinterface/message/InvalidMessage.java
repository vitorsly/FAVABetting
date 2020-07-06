package org.academiadecodigo.gitbusters.favabetting.graphicalinterface.message;

import org.academiadecodigo.gitbusters.favabetting.graphicalinterface.Client;

public class InvalidMessage implements Message {
    @Override
    public void run(Client client, String msg) {
        client.getGraphics().writeStatus("Message Not Recognize");
    }
}
