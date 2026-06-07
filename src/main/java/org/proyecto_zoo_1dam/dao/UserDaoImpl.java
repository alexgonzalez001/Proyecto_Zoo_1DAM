package org.proyecto_zoo_1dam.dao;

import org.proyecto_zoo_1dam.database.DatabaseConnection;
import org.proyecto_zoo_1dam.model.User;

import java.sql.*;
import java.util.Optional;

public class UserDaoImpl implements UserDao {

    @Override
    public Optional<User> findByUsername(String username) {
        String sql = "SELECT * FROM usuarios WHERE username = ?";

        try (Connection conexion = DatabaseConnection.getConnection();
             PreparedStatement statement = conexion.prepareStatement(sql)) {

            statement.setString(1, username);

            ResultSet resultado = statement.executeQuery();

            if (resultado.next()) {
                User user = new User(
                        resultado.getInt("id"),
                        resultado.getString("username"),
                        resultado.getString("password")
                );

                return Optional.of(user);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return Optional.empty();
    }
}