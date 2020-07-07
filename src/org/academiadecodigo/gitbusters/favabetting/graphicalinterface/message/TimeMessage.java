package org.academiadecodigo.gitbusters.favabetting.graphicalinterface.message;

import org.academiadecodigo.gitbusters.favabetting.graphicalinterface.Client;

public class TimeMessage implements Message {

    @Override
    public void run(Client client, String msg) {
        if(!msg.equals("time :0")) {
            client.getGraphics().getRaceLabel().setText(msg);
        }else {
            client.getGraphics().getRaceLabel().setText("Racing");
        }
    }
}
