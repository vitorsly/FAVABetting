package org.academiadecodigo.gitbusters.favabetting.server;

import java.io.IOException;
import java.net.ServerSocket;
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
        initialyzeServer(port);
        race = new Race(this);
        ex.submit(race);
    }

    private void initialyzeServer(int port){
        try {
            server = new ServerSocket(port);
            while (true) {
                try {
                    Client c = new Client(server.accept(),"client " + clientIterator,this);
                    sockets.add(c);
                    ex.submit(c);
                    race.getBroker().registerClient(c);
                } catch (IOException e) {
                    e.printStackTrace();
                }
                clientIterator++;
                System.out.println("Client" + clientIterator + " has connected the server");
            }

        }catch (Exception e){
            System.out.println(e);
        }
    }

    public void broadcastMsg(String msg){
        for (Client c :sockets){
            c.sendMessage("server:"+msg);
        }
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
}
