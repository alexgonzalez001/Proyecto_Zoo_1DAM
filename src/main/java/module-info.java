module com.example.proyecto_zoo_1dam {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;

    opens org.proyecto2 to javafx.fxml;
    exports org.proyecto2;
}