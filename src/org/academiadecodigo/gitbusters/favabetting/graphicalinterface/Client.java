package org.academiadecodigo.gitbusters.favabetting.graphicalinterface;



import org.academiadecodigo.gitbusters.favabetting.graphicalinterface.graphics.Graphics;
import org.academiadecodigo.gitbusters.favabetting.graphicalinterface.message.MessageHandler;

import java.io.*;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Client {
    private Socket socket;
    private BufferedReader inputStream;
    private BufferedWriter outPut;
    private ExecutorService executor= Executors.newCachedThreadPool();
    private Graphics graphics=new Graphics(this);

    Client(String ip,int port){
        try {
            System.out.println("connecting: "+ip+" "+port);
            socket=new Socket(ip,port);
            inputStream=new BufferedReader(new InputStreamReader(socket.getInputStream()));
            outPut=new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
            executor.submit(new listening());
        } catch (IOException e) {
            System.out.println(e.getMessage());
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

    private void receiveMsg() throws IOException {
        String line;
        while((line = inputStream.readLine()) != null) {
            MessageHandler.getActionFromString(line).getAction().run(this,line);
        }
    }

    private class listening implements Runnable{

        @Override
        public void run() {
            sendMessage("getHorses");
            sendMessage("balance");
            while (!socket.isClosed()){
                try {
                    receiveMsg();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public Graphics getGraphics() {
        return graphics;
    }

    public static void main(String[] args) {
        if(args.length<1){
            Client c=new Client("localhost",56000);
        }
        else{
            Client c=new Client(args[0],Integer.parseInt(args[1]));
        }

    }
}
