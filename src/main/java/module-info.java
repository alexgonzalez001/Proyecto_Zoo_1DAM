/*module com.example.proyecto_zoo_1dam {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;


    opens org.proyecto_zoo_1dam to javafx.fxml;
    exports org.proyecto_zoo_1dam;
}*/
module com.example.proyecto_zoo_1dam {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.graphics;
    requires java.sql;
    opens org.proyecto_zoo_1dam to javafx.fxml;
    opens org.proyecto_zoo_1dam.controller to javafx.fxml;
    exports org.proyecto_zoo_1dam;
}