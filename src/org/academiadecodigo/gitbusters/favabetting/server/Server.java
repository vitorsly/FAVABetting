package org.academiadecodigo.gitbusters.favabetting.server;

import java.io.IOException;
import java.net.ServerSocket;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Server {

    private ServerSocket server;
    private ExecutorService ex = Executors.newCachedThreadPool();
    private Race race;
    //private CopyOnWriteArrayList<Client> sockets=new CopyOnWriteArrayList<>();

    private List<Client> sockets = new ArrayList<>();

    private int clientIterator;

    public Server(int port) {
        race = new Race(this);
        ex.submit(race);
        initialyzeServer(port);
    }

    public static void main(String[] args) {
        Server s = new Server(56000);
    }

    // Initiate server and register client to broker
    private void initialyzeServer(int port) {

        try {
            server = new ServerSocket(port);
        } catch (IOException e) {
            e.printStackTrace();
        }

        while (true) {
            try {

                Client c = new Client(server.accept(), "client " + clientIterator, this);

                sockets.add(c);
                ex.submit(c);

                System.out.println(race);

                race.getBroker().registerClient(c);

            } catch (IOException e) {
                e.printStackTrace();
            }

            clientIterator++;

            System.out.println("Client" + clientIterator + " has connected the server");
        }
    }

    // Send messages to clients
    public void broadcastMsg(String msg) {
        for (Client c : sockets) {
            c.sendMessage(msg);
        }
    }

    // Send messages to all clients except to the sender
    public void broadcastExceptMe(Client client, String msg) {
        for (Client c : sockets) {
            if (c == client) {
                continue;
            }
            c.sendMessage(msg);
        }
    }

    // Remove client from server
    public void removeClient(Client client) {
        race.getBroker().unregisterClient(client);
        sockets.remove(client);
        client.closeSocket();
    }

    // Define interval
    public Interval interval(int time) {
        Interval in = new Interval(time);
        ex.submit(in);
        return in;
    }

    public List<Client> getSockets() {
        return sockets;
    }

    // Return race object
    public Race getRace() {
        return race;
    }
}
