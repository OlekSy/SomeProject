package Client;

import java.io.*;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;

/**
 * Created by damaz on 11.11.2017.
 */
public class ClientSocketPart extends Thread{
    private ControllerLogInScreen controllerLogInScreen;
    private ControllerRegistrationScreen controllerRegistrationScreen;
    private boolean registrationControllerIsSet = false;
    private int controller = 1;

    private BufferedReader in;
    private PrintWriter out;

    public ClientSocketPart(ControllerLogInScreen controllerLogInScreen){
        this.controllerLogInScreen = controllerLogInScreen;
        setDaemon(true);
    }

    @Override
    public void run(){
        String message;
        InetAddress address = null;
        try{
            address = InetAddress.getByName("localhost");
        } catch(UnknownHostException e){
            e.printStackTrace();
        }
        Socket socket;
        try{
            socket = new Socket(address, 8070);

            in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(socket.getOutputStream())), true);

            while(true){
                message = in.readLine();
//                if(message == null) break;
                switch(controller){
                    case 1: {
                        controllerLogInScreen.receive(message);
                        break;
                    }
                    case 2: {
                        controllerRegistrationScreen.receive(message);
                        break;
                    }
                }
            }

        } catch(IOException e){
            e.printStackTrace();
        }
    }

    public void setControllerRegistrationScreen(ControllerRegistrationScreen controllerRegistrationScreen){
        this.controllerRegistrationScreen = controllerRegistrationScreen;
        registrationControllerIsSet = true;
    }

    public boolean getRegistrationControllerIsSet(){return registrationControllerIsSet;}

    public void setController(int controller){this.controller = controller;}

    public void send(String message){
        out.println(message);
    }

}
