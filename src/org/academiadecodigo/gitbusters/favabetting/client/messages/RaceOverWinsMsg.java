package org.academiadecodigo.gitbusters.favabetting.client.messages;

import org.academiadecodigo.gitbusters.favabetting.client.Client;

public class RaceOverWinsMsg implements Messages {
    @Override
    public void run(Client client, String msg) {
        //aqui dizemos qual foi o cavalo vensedor
        String[] strSplit=msg.split(" ");
        if(strSplit.length>1){
            System.out.println("Race is over and the winner is....."+strSplit[1]);
        }
        client.getMenu().mainMenu();
    }
}
