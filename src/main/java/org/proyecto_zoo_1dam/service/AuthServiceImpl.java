package org.proyecto_zoo_1dam.service;

public class AuthServiceImpl implements AuthService {

    @Override
    public boolean login(String username, String password) {
        return "zoo".equals(username) && "zoo".equals(password);
    }
}