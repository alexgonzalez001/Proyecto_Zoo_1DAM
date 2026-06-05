package org.proyecto_zoo_1dam.controller;

import org.proyecto_zoo_1dam.service.*;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;

public class LoginController {

    @FXML private TextField usernameField;
    @FXML private PasswordField passwordField;
    @FXML private Label messageLabel;

    private final AuthService auth = new AuthServiceImpl();

    @FXML
    public void onLogin() {
        if (auth.login(usernameField.getText(), passwordField.getText())) {
            try {
                Stage stage = (Stage) usernameField.getScene().getWindow();
                stage.setScene(new Scene(FXMLLoader.load(
                    getClass().getResource("/org/proyecto2/fxml/menu.fxml"))));
                stage.setTitle("Gestión de Animales");
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            messageLabel.setText("Credenciales no válidas");
        }
    }
}