package org.proyecto_zoo_1dam.service;

import org.proyecto_zoo_1dam.model.Animal;

import java.util.List;
import java.util.Optional;

public interface AnimalService {

    Animal create(Animal a);

    boolean update(Animal a);

    boolean delete(int id);

    Optional<Animal> findById(int id);

    List<Animal> findAll();
}
