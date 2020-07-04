package org.academiadecodigo.gitbusters.favabetting.client.messages;

import org.academiadecodigo.gitbusters.favabetting.client.Client;

public class BetOkMsg implements Messages{
    @Override
    public void run(Client client, String msg) {
        System.out.println("Your bet was Placed");
        // Às vezes guarda bem as transações e volta ao menu, outras nem recebe
        // mensagem betOk por isso nem entra aqui. Talvez tenha a haver com as threads (IDK)...

        client.getMenu().saveTransaction(msg);
        client.getMenu().mainMenu();
    }
}
