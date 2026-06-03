module org.proyecto_zoo_1dam {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;
    requires org.xerial.sqlitejdbc;


    opens org.proyecto_zoo_1dam to javafx.fxml;
    exports org.proyecto_zoo_1dam;
}