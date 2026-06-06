package org.proyecto_zoo_1dam.controller;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;
import org.proyecto_zoo_1dam.model.Animal;
import org.proyecto_zoo_1dam.service.*;
import java.time.LocalDate;
import java.util.Optional;

public class MenuController {

    @FXML private TextField idField, nombreField, fechaField, pesoField;
    @FXML private Label statusLabel;

    private final AnimalService service = new AnimalServiceImpl();

    @FXML
    public void onCrear() {
        try {
            Animal a = new Animal(nombreField.getText(),
                LocalDate.parse(fechaField.getText()),
                Double.parseDouble(pesoField.getText()));
            service.create(a);
            statusLabel.setText("Creado con id " + a.getId());
        } catch (Exception e) {
            statusLabel.setText("Error: " + e.getMessage());
        }
    }

    @FXML
    public void onActualizar() {
        try {
            Animal a = new Animal(Integer.parseInt(idField.getText()),
                nombreField.getText(),
                LocalDate.parse(fechaField.getText()),
                Double.parseDouble(pesoField.getText()));
            boolean ok = service.update(a);
            statusLabel.setText(ok ? "Actualizado" : "No existe el id");
        } catch (Exception e) {
            statusLabel.setText("Error: " + e.getMessage());
        }
    }

    @FXML
    public void onEliminar() {
        try {
            boolean ok = service.delete(Integer.parseInt(idField.getText()));
            statusLabel.setText(ok ? "Eliminado" : "No existe el id");
        } catch (Exception e) {
            statusLabel.setText("Error: " + e.getMessage());
        }
    }

    @FXML
    public void onBuscar() {
        try {
            Optional<Animal> op = service.findById(Integer.parseInt(idField.getText()));
            if (op.isPresent()) {
                Animal a = op.get();
                nombreField.setText(a.getNombre());
                fechaField.setText(a.getFechaIngreso().toString());
                pesoField.setText(Double.toString(a.getPesoKg()));
                statusLabel.setText("Encontrado");
            } else {
                statusLabel.setText("No existe el id");
            }
        } catch (Exception e) {
            statusLabel.setText("Error: " + e.getMessage());
        }
    }

    @FXML
    public void onVerListado() {
        load("/org/proyecto_zoo_1dam/proyecto2/fxml/listado.fxml", "Listado de animales");
    }

    @FXML
    public void onSalir() {
        ((Stage) idField.getScene().getWindow()).close();
    }

    private void load(String fxml, String title) {
        try {
            Stage stage = (Stage) idField.getScene().getWindow();
            stage.setScene(new Scene(FXMLLoader.load(getClass().getResource(fxml))));
            stage.setTitle(title);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}