package org.proyecto_zoo_1dam.dao;

import org.proyecto_zoo_1dam.model.User;
import java.util.Optional;

public interface UserDao {
    Optional<User> findByUsername(String username);
}
