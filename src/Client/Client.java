package Client;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class Client extends Application {
    public static Stage mainStage;

    public Parent logInLayOut;
    public Parent registrationLayOut;

    public Scene logInScene;
    public Scene signUpScene;

    @Override
    public void start(Stage primaryStage) throws Exception{
        mainStage = primaryStage;

        logInLayOut = FXMLLoader.load(getClass().getResource("LogInScreen.fxml"));
        logInScene = new Scene(logInLayOut, 600, 400);

        mainStage.setTitle("LogIn Window");
        mainStage.setScene(logInScene);
        mainStage.show();
    }

    public void setLogInLayOut() throws Exception{
        logInLayOut = FXMLLoader.load(getClass().getResource("LogInScreen.fxml"));
        logInScene = new Scene(logInLayOut, 600, 400);
        mainStage.setTitle("LogIn Scene");
        mainStage.setScene(logInScene);
    }

    public void setRegistrationLayOut() throws Exception{
        registrationLayOut = FXMLLoader.load(getClass().getResource("Registration.fxml"));
        signUpScene = new Scene(registrationLayOut, 600, 400);
        mainStage.setTitle("Registration Scene");
        mainStage.setScene(signUpScene);
    }

    public static void main(String[] args) {
        String host = (args.length < 1) ? null : args[0];
        try {
            Registry registry = LocateRegistry.getRegistry(host);
            ServerRI stub = (ServerRI) registry.lookup("ServerRI");
            String response = stub.sayHello();
            System.out.println("response: " + response);
        } catch (Exception e) {
            System.err.println("Client exception: " + e.toString());
            e.printStackTrace();
        }

        launch(args);
    }
}
