package org.proyecto_zoo_1dam.dao;

import org.proyecto_zoo_1dam.database.DatabaseConnection;
import org.proyecto_zoo_1dam.model.Animal;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class AnimalDaoImpl implements AnimalDao {

    @Override
    public Animal insert(Animal animal) {
        String sql = "INSERT INTO animales(nombre, fecha_ingreso, peso_kg) VALUES (?, ?, ?)";

        try (Connection conexion1 = DatabaseConnection.getConnection();
             PreparedStatement statement1 = conexion1.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {

            statement1.setString(1, animal.getNombre());
            statement1.setString(2, animal.getFechaIngreso().toString());
            statement1.setDouble(3, animal.getPesoKg());

            statement1.executeUpdate();

            ResultSet resultado1 = statement1.getGeneratedKeys();

            if (resultado1.next()) {
                animal.setId(resultado1.getInt(1));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return animal;
    }

    @Override
    public boolean update(Animal animal) {
        String sql = "UPDATE animales SET nombre=?, fecha_ingreso=?, peso_kg=? WHERE id=?";

        try (Connection conexion2 = DatabaseConnection.getConnection();
             PreparedStatement statement2 = conexion2.prepareStatement(sql)) {

            statement2.setString(1, animal.getNombre());
            statement2.setString(2, animal.getFechaIngreso().toString());
            statement2.setDouble(3, animal.getPesoKg());
            statement2.setInt(4, animal.getId());

            return statement2.executeUpdate() > 0;

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return false;
    }

    @Override
    public boolean delete(int id) {
        String sql = "DELETE FROM animales WHERE id=?";

        try (Connection conexion3 = DatabaseConnection.getConnection();
             PreparedStatement statement3 = conexion3.prepareStatement(sql)) {

            statement3.setInt(1, id);

            return statement3.executeUpdate() > 0;

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return false;
    }

    @Override
    public Optional<Animal> findById(int id) {
        String sql = "SELECT * FROM animales WHERE id=?";

        try (Connection conexion4 = DatabaseConnection.getConnection();
             PreparedStatement statement4 = conexion4.prepareStatement(sql)) {

            statement4.setInt(1, id);

            ResultSet resultado4 = statement4.executeQuery();

            if (resultado4.next()) {
                Animal animal = new Animal(
                        resultado4.getInt("id"),
                        resultado4.getString("nombre"),
                        LocalDate.parse(resultado4.getString("fecha_ingreso")),
                        resultado4.getDouble("peso_kg")
                );

                return Optional.of(animal);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return Optional.empty();
    }

    @Override
    public List<Animal> findAll() {
        List<Animal> animales = new ArrayList<>();

        String sql = "SELECT * FROM animales";

        try (Connection conexion5 = DatabaseConnection.getConnection();
             PreparedStatement stmt = conexion5.prepareStatement(sql);
             ResultSet resultado5 = stmt.executeQuery()) {

            while (resultado5.next()) {
                animales.add(new Animal(
                        resultado5.getInt("id"),
                        resultado5.getString("nombre"),
                        LocalDate.parse(resultado5.getString("fecha_ingreso")),
                        resultado5.getDouble("peso_kg")
                ));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return animales;
    }
}
