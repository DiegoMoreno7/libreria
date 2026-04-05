package com.spring.libreria.RepoLibros;

import com.spring.libreria.Model.Libros;

import java.util.List;
import java.util.Optional;

public interface I_RepoLibros {
    List<Libros> findAll();
    Optional<Libros> findById(Long id);

    void save(Libros libro);
    void deleteById(long id);

    void update(Libros libro);
}
