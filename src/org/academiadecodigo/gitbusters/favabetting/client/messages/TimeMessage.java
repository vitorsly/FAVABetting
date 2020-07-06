package org.academiadecodigo.gitbusters.favabetting.client.messages;

import org.academiadecodigo.gitbusters.favabetting.client.Client;
import org.academiadecodigo.gitbusters.favabetting.client.Print;

public class TimeMessage implements Messages {

    @Override
    public void run(Client client, String msg) {
        if(!msg.equals("time :0")) {
            new Print(msg);
        }else {
            new Print("Race Started !!!");
        }
    }
}
