package com.spring.libreria.Controlador;

import com.spring.libreria.Model.Libros;
import com.spring.libreria.RepoLibros.RepoLibros;
import com.spring.libreria.Servicio.ServicioLibro;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/libros")
public class ControladorLibreria {

    private final ServicioLibro LibroServicio;
    private final RepoLibros LibroRepo;

    public ControladorLibreria(ServicioLibro LibroServicio,  RepoLibros LibroRepo) {
        this.LibroServicio = LibroServicio;
        this.LibroRepo = LibroRepo;
    }

    @GetMapping("/{titulo}")
    public String DameLibro(@PathVariable String titulo) {
        return LibroServicio.buscaLibro(titulo);
    }

    @GetMapping("/todos")
    public List<Libros> allLibros() {
        return LibroRepo.findAll();
    }

    @GetMapping("/id/{id}")
    public ResponseEntity<Libros> buscaLibro(@PathVariable long id) {
        return LibroRepo.findById(id)
                .map(l -> ResponseEntity.ok(l)).orElse(ResponseEntity.notFound().build());
    }
}
