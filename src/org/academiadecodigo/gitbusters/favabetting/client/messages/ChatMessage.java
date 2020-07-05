package org.academiadecodigo.gitbusters.favabetting.client.messages;

import org.academiadecodigo.gitbusters.favabetting.client.Client;
import org.academiadecodigo.gitbusters.favabetting.client.Print;

public class ChatMessage implements Messages {
    @Override
    public void run(Client client, String msg) {
        if(client.getMenu().getInChat()){
            String message=msg.substring(5);
            new Print(message);
        }
    }
}
