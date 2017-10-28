package Client;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Client extends Application {
    public static Stage mainStage;

    public Parent logInLayOut;
    public Parent registrationLayOut;

    public Scene logInScene;
    public Scene signUpScene;

    @Override
    public void start(Stage primaryStage) throws Exception{
        mainStage = primaryStage;

        mainStage.setMinHeight(400);
        mainStage.setMinWidth(600);

        logInLayOut = FXMLLoader.load(getClass().getResource("LogInScreen.fxml"));
        logInScene = new Scene(logInLayOut, 600, 400);

        mainStage.setTitle("LogIn Window");
        mainStage.setScene(logInScene);
        mainStage.show();
    }

    public void setLogInLayOut() throws Exception{
        mainStage.setMinHeight(400);
        mainStage.setMinWidth(600);
        logInLayOut = FXMLLoader.load(getClass().getResource("LogInScreen.fxml"));
        logInScene = new Scene(logInLayOut, 600, 400);
        mainStage.setTitle("LogIn Scene");
        mainStage.setScene(logInScene);
    }

    public void setRegistrationLayOut() throws Exception{
        mainStage.setMinHeight(400);
        mainStage.setMinWidth(600);
        registrationLayOut = FXMLLoader.load(getClass().getResource("Registration.fxml"));
        signUpScene = new Scene(registrationLayOut, 600, 400);
        mainStage.setTitle("Registration Scene");
        mainStage.setScene(signUpScene);
    }

    public static void main(String[] args) {
        launch(args);
    }
}
