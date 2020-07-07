package org.academiadecodigo.gitbusters.favabetting.graphicalinterface.message;

import org.academiadecodigo.gitbusters.favabetting.graphicalinterface.Client;

import java.text.DecimalFormat;

public class BalanceMsg implements Message {

    @Override
    public void run(Client client, String msg) {

        String balance = msg.split(" ")[1];

        double d = Double.parseDouble(balance);

        String str = String.format("%.2f",d);

        client.getGraphics().getBalance().setText(str + "$");
    }
}
