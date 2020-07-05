package org.academiadecodigo.gitbusters.favabetting.client.messages;

import org.academiadecodigo.gitbusters.favabetting.client.Client;
import org.academiadecodigo.gitbusters.favabetting.client.Print;

public class LeadingHorse implements Messages {
    @Override
    public void run(Client client, String msg) {
        String[] msgSplit=msg.split(" ");
        if(msgSplit.length>1){
            new Print("The horse :"+msgSplit[1]+" is in the lead");
        }
        else{
            new Print("2222222222222222222222222222222222222222222222");
        }

    }
}
