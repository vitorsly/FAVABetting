package org.academiadecodigo.gitbusters.favabetting.client.messages;

import org.academiadecodigo.gitbusters.favabetting.client.Client;

public class NoFunds implements Messages {
    @Override
    public void run(Client client, String msg) {
        System.out.println("You don't have funds to complete the operation");
    }
}
