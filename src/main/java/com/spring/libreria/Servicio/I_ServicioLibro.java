package com.spring.libreria.Servicio;

import com.spring.libreria.Model.Libros;

import java.util.List;
import java.util.Optional;

public interface I_ServicioLibro {
    List<Libros> ObtenerTodos();
    Optional<Libros> ObtenerPorId(long id);
    Libros guardar(Libros libro);
    void eliminarPorId(long id);
    String buscarTitulo(String titulo);
    void actualizar(Libros libro);

}
