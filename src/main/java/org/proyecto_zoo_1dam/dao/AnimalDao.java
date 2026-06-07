package org.proyecto_zoo_1dam.dao;

import org.proyecto_zoo_1dam.model.Animal;
import java.util.List;
import java.util.Optional;

public interface AnimalDao {

    Animal insert(Animal animal);

    boolean update(Animal animal);

    boolean delete(int id);

    Optional<Animal> findById(int id);

    List<Animal> findAll();
}