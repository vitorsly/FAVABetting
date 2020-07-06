package org.academiadecodigo.gitbusters.favabetting.client.messages;

import org.academiadecodigo.gitbusters.favabetting.client.Client;
import org.academiadecodigo.gitbusters.favabetting.client.Print;

public class RaceOverWinsMsg implements Messages {

    @Override
    public void run(Client client, String msg) {

        String[] strSplit = msg.split(" ");

        if(strSplit.length > 1){
            new Print("Race is over and the winner is....." + strSplit[1]);
        }
    }
}
