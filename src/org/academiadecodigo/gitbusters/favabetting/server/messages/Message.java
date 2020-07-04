package org.academiadecodigo.gitbusters.favabetting.server.messages;

import org.academiadecodigo.gitbusters.favabetting.server.Client;
import org.academiadecodigo.gitbusters.favabetting.server.Server;

public interface Message {
    public void send(Client client, Server server);
    public void receive(Client client,Server server);
}
