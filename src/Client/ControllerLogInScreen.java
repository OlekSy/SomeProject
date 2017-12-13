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
        StringBuilder message = new StringBuilder();
        message.append("001").append(username.getText()).append("%").append(password.getText());
        String messageToSend = message.toString();
        client.send(messageToSend);
        username.clear();
        password.clear();
    }

    public void receive(String message){
        password.setText(message);
    }
}