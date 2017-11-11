package Client;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

public class ControllerLogInScreen {

    @FXML Button registrationButton;
    @FXML Button signIn;
    @FXML TextField username;
    @FXML PasswordField password;

    Client client;

    @FXML
    public void initialize(){
        client = new Client();
    }

    public void registrationButtonAction() {
        try {
            client.setRegistrationLayOut();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void signInOnAction(){
        client.send(username.getText());
        username.clear();
    }

    public void receive(String message){
        password.setText(message);
    }
}