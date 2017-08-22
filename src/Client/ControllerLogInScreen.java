package Client;

import javafx.fxml.FXML;
import javafx.scene.control.Button;

public class ControllerLogInScreen {

    @FXML
    Button registrationButton;
    @FXML
    Button backButton;

    @FXML
    public void initialize(){

    }

    public void registrationButtonAction() {
        Client client = new Client();
        try {
            client.setRegistrationLayOut();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void backButtonAction() {
        Client client = new Client();
        try {
            client.setLogInLayOut();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}