package Client;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

/**
 * Created by damaz on 11.11.2017.
 */
public class ControllerRegistrationScreen {
    @FXML Button backButton;
    @FXML TextField username;
    @FXML PasswordField password;
    @FXML PasswordField repeat;

    public void backButtonAction() {
        Client client = new Client();
        try {
            client.setLogInLayOut();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void receive(String message){

    }
}
