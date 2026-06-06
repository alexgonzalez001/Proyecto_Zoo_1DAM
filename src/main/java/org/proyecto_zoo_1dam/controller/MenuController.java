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

    @FXML private TextField idCampo, nombreCampo, fechaCampo, pesoCampo;
    @FXML private Label statusLabel;

    private final AnimalService service = new AnimalServiceImpl();

    @FXML
    public void onCrear() {
        try {
            Animal a = new Animal(nombreCampo.getText(),
                LocalDate.parse(fechaCampo.getText()),
                Double.parseDouble(pesoCampo.getText()));
            service.create(a);
            statusLabel.setText("Creado con id " + a.getId());
        } catch (Exception e) {
            statusLabel.setText("Error: " + e.getMessage());
        }
    }

    @FXML
    public void onActualizar() {
        try {
            Animal a = new Animal(Integer.parseInt(idCampo.getText()),
                nombreCampo.getText(),
                LocalDate.parse(fechaCampo.getText()),
                Double.parseDouble(pesoCampo.getText()));
            boolean i = service.update(a);
            statusLabel.setText(i ? "Actualizado" : "No existe el id");
        } catch (Exception e) {
            statusLabel.setText("Error: " + e.getMessage());
        }
    }

    @FXML
    public void onEliminar() {
        try {
            boolean i = service.delete(Integer.parseInt(idCampo.getText()));
            statusLabel.setText(i ? "Eliminado" : "No existe el id");
        } catch (Exception e) {
            statusLabel.setText("Error: " + e.getMessage());
        }
    }

    @FXML
    public void onBuscar() {
        try {
            Optional<Animal> op = service.findById(Integer.parseInt(idCampo.getText()));
            if (op.isPresent()) {
                Animal a = op.get();
                nombreCampo.setText(a.getNombre());
                fechaCampo.setText(a.getFechaIngreso().toString());
                pesoCampo.setText(Double.toString(a.getPesoKg()));
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
        ((Stage) idCampo.getScene().getWindow()).close();
    }

    private void load(String fxml, String title) {
        try {
            Stage stage = (Stage) idCampo.getScene().getWindow();
            stage.setScene(new Scene(FXMLLoader.load(getClass().getResource(fxml))));
            stage.setTitle(title);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}