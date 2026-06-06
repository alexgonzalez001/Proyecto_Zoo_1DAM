package org.proyecto_zoo_1dam.controller;

import javafx.beans.property.*;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;
import org.proyecto_zoo_1dam.model.Animal;
import org.proyecto_zoo_1dam.service.*;

public class ListadoController {

    @FXML private TableView<Animal> tabla;
    @FXML private TableColumn<Animal, Number> colId;
    @FXML private TableColumn<Animal, String> colNombre;
    @FXML private TableColumn<Animal, String> colFecha;
    @FXML private TableColumn<Animal, Number> colPeso;

    private final AnimalService service = new AnimalServiceImpl();

    @FXML
    public void initialize() {
        colId.setCellValueFactory(c -> new SimpleIntegerProperty(c.getValue().getId()));
        colNombre.setCellValueFactory(c -> new SimpleStringProperty(c.getValue().getNombre()));
        colFecha.setCellValueFactory(c -> new SimpleStringProperty(c.getValue().getFechaIngreso().toString()));
        colPeso.setCellValueFactory(c -> new SimpleDoubleProperty(c.getValue().getPesoKg()));
        tabla.getItems().setAll(service.findAll());
    }

    @FXML
    public void onVolver() {
        try {
            Stage stage = (Stage) tabla.getScene().getWindow();
            stage.setScene(new Scene(FXMLLoader.load(
                getClass().getResource("/org/proyecto_zoo_1dam/proyecto2/fxml/menu.fxml"))));
            stage.setTitle("Gestión de Animales");
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}