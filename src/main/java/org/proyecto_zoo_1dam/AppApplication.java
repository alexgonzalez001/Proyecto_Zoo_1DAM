package org.proyecto_zoo_1dam;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

public class AppApplication extends Application {

    @Override
    public void start(Stage stage) throws Exception {
        Scene scene = new Scene(FXMLLoader.load(getClass().getResource
                ("/org/proyecto_zoo_1dam/proyecto2/fxml/login.fxml")));
        stage.setTitle("Zoo - Login");
        stage.setScene(scene);
        stage.setResizable(false); // Bloquea el tamaño para que nadie rompa el diseño estirando la ventana
        stage.centerOnScreen();    // Hace que aparezca justo en el centro de la pantalla del monitor
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
