package com.spring.libreria.Servicio;

import com.spring.libreria.Model.Libros;
import com.spring.libreria.RepoLibros.I_RepoLibros;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class ServicioLibro implements I_ServicioLibro{
    private final I_RepoLibros i_repoLibros;

    public ServicioLibro(I_RepoLibros repoLibros) {
        this.i_repoLibros = repoLibros;
    }

    @Override
    public List<Libros> ObtenerTodos(){
        return i_repoLibros.findAll();
    }

    @Override
    public Optional<Libros> ObtenerPorId(long id){
        return i_repoLibros.findById(id);
    }

    @Override
    public Libros guardar(Libros libro) {
        i_repoLibros.save(libro);
        return libro;
    }

    @Override
    public void eliminarPorId(long id) {
        i_repoLibros.deleteById(id);
    }

    @Override
    public String buscarTitulo(String titulo){
        boolean encontrado = i_repoLibros.findAll().stream().anyMatch(libro -> libro.getTitulo().equals(titulo));
        return encontrado ? "Libro encontrado" : "Libro no encontrado";
    }

    @Override
    public void actualizar(Libros libro) {
        i_repoLibros.update(libro);
    }
}
