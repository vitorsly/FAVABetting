package org.academiadecodigo.gitbusters.favabetting.graphicalinterface.message;

import org.academiadecodigo.gitbusters.favabetting.graphicalinterface.Client;

public class ChatMessage implements Message {

    @Override
    public void run(Client client, String msg) {
        String message = msg.substring(5);
        client.getGraphics().getChatMenu().getChatWindow().append("\n" + message);
    }
}
