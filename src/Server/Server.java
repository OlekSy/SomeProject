package Server;

import Server.DataBase.DataBaseContextClasses.UserContext;
import Server.DataBase.HibernateManager;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import org.hibernate.Session;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

public class Server extends Application{
    MonoThreadClientHandler client;

    private static Stage mainStage;

    public static final int PORT = 8070;

    public static void main(String[] args) {
        launch(args);

    }

    @Override
    public void start(Stage primaryStage) throws Exception{
        mainStage = primaryStage;

        mainStage.setMinHeight(400);
        mainStage.setMinWidth(600);

        FXMLLoader loader = new FXMLLoader(getClass().getResource("Controllers/UserController.fxml"));
        mainStage = loader.load();
        //logInScene = new Scene(logInLayOut, 600, 400);

        mainStage.setTitle("LogIn Window");
        //mainStage.setScene(logInScene);
        mainStage.show();

        run();
    }


    public void run(){
        ServerSocket serverSocket;
        try{
            serverSocket = new ServerSocket(PORT);
            try{
                while(true){
                    Socket socket = serverSocket.accept();
                    client = new MonoThreadClientHandler(socket, this);
                    client.start();
                }
            } finally {
                serverSocket.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void send(String message, MonoThreadClientHandler client){
        client.getOut().println(message);
    }

    public void verifyUser(String input) {
        String[] userInput = input.split("%");
        Session s = HibernateManager.getSessionFactory().openSession();
        UserContext uc = new UserContext(s);
        if(uc.verifyUser(userInput[0],userInput[1])) System.out.println("Success");
        else System.out.println("Fail! Go away!");
        s.close();
    }
}
