package org.academiadecodigo.gitbusters.favabetting.client.messages;

import org.academiadecodigo.gitbusters.favabetting.client.Client;

import java.util.Scanner;

public class BetStart implements Messages{
    @Override
    public void run(Client client, String msg) {
        System.out.println("betting Has Started");
        client.sendMessage("mainmenu");
        //client.getMenu().mainMenu();
    }
}
