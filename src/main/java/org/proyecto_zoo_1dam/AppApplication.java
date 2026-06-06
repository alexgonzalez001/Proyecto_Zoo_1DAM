package org.proyecto_zoo_1dam;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class AppApplication extends Application {

    @Override
    public void start(Stage stage) throws Exception {
        Scene scene = new Scene(FXMLLoader.load(
            getClass().getResource("/org/proyecto_zoo_1dam/proyecto2/fxml/login.fxml")));
        stage.setTitle("Zoo - Login");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
