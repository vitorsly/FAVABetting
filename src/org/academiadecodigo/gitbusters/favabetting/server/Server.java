package org.academiadecodigo.gitbusters.favabetting.server;

import java.io.IOException;
import java.net.ServerSocket;
import java.security.PublicKey;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Server {

    ServerSocket server;
    //private CopyOnWriteArrayList<Client> sockets=new CopyOnWriteArrayList<>();

    private List<Client> sockets = new ArrayList<>();
    int clientIterator;
    ExecutorService ex = Executors.newCachedThreadPool();
    Race race;
    Server(int port) {
        race = new Race(this);
        ex.submit(race);
        initialyzeServer(port);
    }

    private void initialyzeServer(int port){

        try {
            server = new ServerSocket(port);
        } catch (IOException e) {
            e.printStackTrace();
        }

        while (true) {
                try {
                    Client c = new Client(server.accept(),"client " + clientIterator,this);
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

    public void broadcastMsg(String msg){
        for (Client c :sockets){
            c.sendMessage(msg);
        }
    }

    public void removeClient(Client client){

        race.getBroker().unregisterClient(client);
        sockets.remove(client);
        client.closeSocket();
    }

    public static void main(String[] args) {
        Server s = new Server(8080);
    }

    public List<Client> getSockets() {
        return sockets;
    }

    public Race getRace() {
        return race;
    }

    public Interval interval(int time){
        Interval in=new Interval(time);
        ex.submit(in);
        return in;
    }
}
