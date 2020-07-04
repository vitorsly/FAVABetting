package org.academiadecodigo.gitbusters.favabetting.client.messages;

import org.academiadecodigo.gitbusters.favabetting.client.Client;
import org.academiadecodigo.gitbusters.favabetting.client.Print;

import java.util.Scanner;

public class BetStart implements Messages{
    @Override
    public void run(Client client, String msg) {
        new Print("betting Has Started");
        client.sendMessage("mainmenu");
        //client.getMenu().mainMenu();
    }
}
