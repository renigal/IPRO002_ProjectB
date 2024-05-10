import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

public class LoginPageController{
    @FXML
    private TextField email_textField;

    @FXML
    private PasswordField password_textField;

    @FXML
    private Label error_lab;

    @FXML
    public void signupButton(ActionEvent){
        openWindow();
    }

    @FXML
    public void loginButton(ActionEvent event) throws Exception{
        Path path = Paths.get("");

        long count = Files.lines(path).count();

        for(int i = 0;i < count; i++){
            String line = Files.readAllLines(path).get(i);
            if(!line.trim().equals(""))
            {
                
            }
        }
    }
}