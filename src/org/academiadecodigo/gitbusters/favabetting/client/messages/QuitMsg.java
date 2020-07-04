package org.academiadecodigo.gitbusters.favabetting.client.messages;

import org.academiadecodigo.gitbusters.favabetting.client.Client;

public class QuitMsg implements  Messages{


    @Override
    public void run(Client client, String msg) {
        System.exit(1);
    }
}
