package org.academiadecodigo.gitbusters.favabetting.graphicalinterface.message;

import org.academiadecodigo.gitbusters.favabetting.graphicalinterface.Client;

public class BalanceMsg implements Message {
    @Override
    public void run(Client client, String msg) {
        String balance = msg.split(" ")[1];
        client.getGraphics().getBalance().setText(balance);
    }
}
