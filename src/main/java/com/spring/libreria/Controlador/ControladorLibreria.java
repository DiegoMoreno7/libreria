package com.spring.libreria.Controlador;

import com.spring.libreria.Model.Libros;
import com.spring.libreria.RepoLibros.RepoLibros;
import com.spring.libreria.Servicio.I_ServicioLibro;
import com.spring.libreria.Servicio.ServicioLibro;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/libros")
public class ControladorLibreria {

    private final I_ServicioLibro i_servicioLibro;

    public ControladorLibreria(I_ServicioLibro i_servicioLibro) {
        this.i_servicioLibro = i_servicioLibro;
    }

    @GetMapping("/todo")
    public List<Libros> listar(){
        return i_servicioLibro.ObtenerTodos();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Libros> obtenerLibros(@PathVariable Integer id){
        Optional<Libros> libro = i_servicioLibro.ObtenerPorId(id);
        return libro.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping("/post")
    public ResponseEntity<Libros> crearLibro(@RequestBody Libros libro){
        i_servicioLibro.guardar(libro);
        return ResponseEntity.ok(libro);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Libros> eliminarLibro(@PathVariable long id){
        i_servicioLibro.eliminarPorId(id);
        return ResponseEntity.noContent().build();
    }
}
