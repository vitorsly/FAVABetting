package org.academiadecodigo.gitbusters.favabetting.server;

import org.academiadecodigo.gitbusters.favabetting.server.messages.MessageHandler;

import java.io.*;
import java.net.Socket;

public class Client implements Runnable {

    private Socket socket;
    private String name;
    private BufferedReader inputStream;
    private BufferedWriter outPut;
    private Server server;

    Client(Socket socket,String name,Server server){
        this.socket=socket;
        this.server=server;
        this.name=name;
        try {
            socket.setKeepAlive(true);
            inputStream=new BufferedReader(new InputStreamReader(socket.getInputStream()));
            outPut=new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void run() {

        while (!socket.isClosed()){
            System.out.println("Connected");
            try {
                readInput(inputStream);
            }catch (Exception e){
                System.out.println(e);
            }
        }
    }

    private void readInput(BufferedReader input) throws IOException {

        String line;
        while((line = input.readLine()) != null) {
            MessageHandler.getActionFromString(line).getMessage().receive(this,server,line);
        }
    }

    public void sendMessage(String msg){
        try {
            msg+="\n";
            outPut.write(msg);
            outPut.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
