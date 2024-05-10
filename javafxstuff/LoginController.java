import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;

public class LoginController{
    @FXML
    private TextField usernameTextField;

    @FXML
    private PasswordField passwordTextField;

    @FXML
    private Label error_lab;

    private Login login;

    public void initialize(){
        login = new Login();
    }

    @FXML
    private void handleLogin(){
        String username = usernameTextField.getText();
        String password = passwordTextField.getText();

        if (login.authenticate(username, password)){
            String userType = login.getUserType(username);
            System.out.println("Login Successful as " + userType);
            Alert msg = new Alert(AlertType.CONFIRMATION);
            msg.setTitle(usernameTextField.getText());
            msg.setContentText("Login Successful! \n Welcome, " + username);
            msg.showAndWait();

        } else {
            
        }
    }
}