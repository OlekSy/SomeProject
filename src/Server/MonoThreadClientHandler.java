package Server;

import java.io.*;
import java.net.Socket;

/**
 * Created by damaz on 30.10.2017.
 */
public class MonoThreadClientHandler extends Thread{
    Socket client;
    String input;
    BufferedReader in;
    PrintWriter out;
    Server server;

    public MonoThreadClientHandler(Socket socket, Server server){
        client = socket;
        this.server = server;
        this.setDaemon(true);
    }

    @Override
    public void run(){
        try{
            in = new BufferedReader(new InputStreamReader(client.getInputStream()));
            out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(client.getOutputStream())), true);
            while(true){
                input = in.readLine();
//                System.out.println("Message: " + input);
                server.send(input);
            }
        } catch (IOException e){}
    }

    public PrintWriter getOut(){return out;}
}
