package Client;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Client extends Application {
    private static Stage mainStage;

    private Parent logInLayOut;
    private Parent registrationLayOut;

    private Scene logInScene;
    private Scene signUpScene;

    private static ClientSocketPart clientSocketPart;

    @Override
    public void start(Stage primaryStage) throws Exception{
        mainStage = primaryStage;

        mainStage.setMinHeight(400);
        mainStage.setMinWidth(600);

        FXMLLoader loader = new FXMLLoader(getClass().getResource("LogInScreen.fxml"));
        logInLayOut = loader.load();
        logInScene = new Scene(logInLayOut, 600, 400);

        mainStage.setTitle("LogIn Window");
        mainStage.setScene(logInScene);
        mainStage.show();

        clientSocketPart = new ClientSocketPart(loader.getController());
        clientSocketPart.start();
    }

    public void setLogInLayOut() throws Exception{
        mainStage.setMinHeight(400);
        mainStage.setMinWidth(600);
        logInLayOut = FXMLLoader.load(getClass().getResource("LogInScreen.fxml"));
        logInScene = new Scene(logInLayOut, 600, 400);
        mainStage.setTitle("LogIn Scene");
        mainStage.setScene(logInScene);
        clientSocketPart.setController(1);
    }

    public void setRegistrationLayOut() throws Exception{
        mainStage.setMinHeight(400);
        mainStage.setMinWidth(600);
        FXMLLoader loader = new FXMLLoader(getClass().getResource("Registration.fxml"));
        registrationLayOut = loader.load();
        signUpScene = new Scene(registrationLayOut, 600, 400);
        mainStage.setTitle("Registration Scene");
        mainStage.setScene(signUpScene);
        clientSocketPart.setControllerRegistrationScreen(loader.getController());
        clientSocketPart.setController(2);
    }

    public static void main(String[] args) {
        launch(args);
    }

    public void send(String message){
        clientSocketPart.send(message);
    }
}
