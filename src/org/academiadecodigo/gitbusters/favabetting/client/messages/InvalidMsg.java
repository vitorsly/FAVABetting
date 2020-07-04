package org.academiadecodigo.gitbusters.favabetting.client.messages;

import org.academiadecodigo.gitbusters.favabetting.client.Client;

public class InvalidMsg implements Messages {
    @Override
    public void run(Client client, String msg) {
        System.out.println("message not recognized "+msg);
    }
}
