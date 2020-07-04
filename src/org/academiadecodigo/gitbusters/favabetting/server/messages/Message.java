package org.academiadecodigo.gitbusters.favabetting.server.messages;

import org.academiadecodigo.gitbusters.favabetting.server.Client;
import org.academiadecodigo.gitbusters.favabetting.server.Server;

public interface Message {

    void send(Client client, Server server);

    void receive(Client client,Server server,String msg);
}
