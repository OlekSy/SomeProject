package Authentication;

import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

import java.awt.event.MouseEvent;
import java.io.IOException;

public class ControllerLogInScreen {

    @FXML
    Button registrationButton;
    @FXML
    Button backButton;

    @FXML
    public void initialize(){

    }

    public void registrationButtonAction() {
        Main main = new Main();
        try {
            main.setRegistrationLayOut();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void backButtonAction() {
        Main main = new Main();
        try {
            main.setLogInLayOut();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}