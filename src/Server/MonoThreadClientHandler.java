package Server;

import java.io.*;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

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
        String command;
        try{
            in = new BufferedReader(new InputStreamReader(client.getInputStream()));
            out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(client.getOutputStream())), true);
            while(true){
                input = in.readLine();
                System.out.println(input);
                command = input.substring(0, 3);
                System.out.println(command);
                switch (command){
                    case "001": input = input.substring(3);
                                System.out.println(input);
                                server.verifyUser(input);
                                break;
                }
//                server.send(input, this);
            }
        } catch (IOException e){}
    }

    public PrintWriter getOut(){return out;}

}
