package org.proyecto_zoo_1dam.service;

import org.proyecto_zoo_1dam.dao.UserDao;
import org.proyecto_zoo_1dam.dao.UserDaoImpl;

public class AuthServiceImpl implements AuthService {

    private final UserDao userDao = new UserDaoImpl();

    public boolean login(String username, String password) {

        if (username == null || username.isBlank() || password == null || password.isBlank()) {
            return false;
        }

        return userDao.findByUsername(username)
                .map(u -> u.getPassword().equals(password))
                .orElse(false);
    }
}