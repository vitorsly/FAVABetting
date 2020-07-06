package org.academiadecodigo.gitbusters.favabetting.server.messages;

import org.academiadecodigo.gitbusters.favabetting.server.Client;
import org.academiadecodigo.gitbusters.favabetting.server.Server;

public class ChatMessage implements Message{

    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_BLACK = "\u001B[30m";
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_YELLOW = "\u001B[33m";
    public static final String ANSI_BLUE = "\u001B[34m";
    public static final String ANSI_PURPLE = "\u001B[35m";
    public static final String ANSI_CYAN = "\u001B[36m";
    public static final String ANSI_WHITE = "\u001B[37m";

    @Override
    public void send(Client client, Server server) {  }

    @Override
    public void receive(Client client, Server server, String msg) {

        String message = msg.split("#")[1];

        server.broadcastExceptMe(client,"chat " + ANSI_YELLOW + client.getName() +
                ANSI_RESET + ": " + ANSI_CYAN + message + ANSI_RESET);

    }
}
