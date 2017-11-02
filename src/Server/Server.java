package Server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

public class Server extends Thread{
    List<MonoThreadClientHandler> clients;

    public static final int PORT = 8080;

    public static void main(String[] args){
        new Server().run();
    }

    @Override
    public void run(){
        MonoThreadClientHandler temp;
        ServerSocket serverSocket;
        clients = new ArrayList<>();
        try{
            serverSocket = new ServerSocket(PORT);
            try{
                while(true){
                    Socket socket = serverSocket.accept();
                    temp = new MonoThreadClientHandler(socket, this);
                    clients.add(temp);
                    temp.start();
                }
            } finally {
                serverSocket.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void send(String message){
        for(MonoThreadClientHandler temp : clients){
            temp.getOut().println(message);
        }
    }
}
