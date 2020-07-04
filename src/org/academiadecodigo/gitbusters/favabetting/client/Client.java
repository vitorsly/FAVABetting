package org.academiadecodigo.gitbusters.favabetting.client;

import org.academiadecodigo.gitbusters.favabetting.client.menu.Menu;
import org.academiadecodigo.gitbusters.favabetting.client.messages.MessageHandler;

import java.io.*;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Client {

    private Socket socket;
    private BufferedReader inputStream;
    private BufferedWriter outPut;
    private ExecutorService executor= Executors.newCachedThreadPool();
    private Menu menu;

    Client(){
        try {
            socket=new Socket("localhost",8080);
            inputStream=new BufferedReader(new InputStreamReader(socket.getInputStream()));
            outPut=new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
            executor.submit(new listening());
            menu=new Menu(this);
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
            while (!socket.isClosed()){
                try {
                    receiveMsg();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static void main(String[] args) {
        Client c=new Client();
    }

    public Menu getMenu() {
        return menu;
    }
}
