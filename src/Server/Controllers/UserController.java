package Server.Controllers;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

public class UserController {
    @FXML Button btnAddEdit;
    @FXML TextField txtNickName;
    @FXML TextField txtPassword;
    @FXML TextField txtEmail;
    @FXML TableView tblMainTable;

    public void btn_clickHandler() {
        System.out.println("Hi");
    }
}
