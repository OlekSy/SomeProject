package Server;

import java.io.DataInputStream;
import java.io.DataOutput;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.rmi.registry.Registry;
import java.rmi.registry.LocateRegistry;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class Server{
    public Server() {}

    public String sayHello() {
        return "Hello, world!";
    }

    public static void main(String args[]) throws InterruptedException{
        try (ServerSocket server = new ServerSocket(3345)){
            Socket client = server.accept();
            DataOutputStream out = new DataOutputStream(client.getOutputStream());
            DataInputStream in = new DataInputStream(client.getInputStream());

            while(!client.isClosed()){

            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
