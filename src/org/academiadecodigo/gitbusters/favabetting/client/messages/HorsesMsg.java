package org.academiadecodigo.gitbusters.favabetting.client.messages;

import org.academiadecodigo.gitbusters.favabetting.client.Client;

public class HorsesMsg implements Messages {

    @Override
    public void run(Client client, String msg) {

        String str=msg.substring(10);
        String[]horsesByLine = str.split("%");

        client.getMenu().makeBetMenu(horsesByLine);
        //now you can make the menu
    }
}
