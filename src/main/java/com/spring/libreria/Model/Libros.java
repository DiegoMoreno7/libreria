package com.spring.libreria.Model;

import java.time.LocalDate;

public class Libros implements Cloneable {
    private long idLibro;
    private String autor;
    private String titulo;
    private LocalDate fechaPublicacion;

    public Libros(long idLibro, String autor, String titulo, LocalDate fechaPublicacion) {
        this.idLibro = idLibro;
        this.autor = autor;
        this.titulo = titulo;
        this.fechaPublicacion = fechaPublicacion;
    }

    public long getIdLibro() {
        return idLibro;
    }

    public String getAutor() {
        return autor;
    }

    public String getTitulo() {
        return titulo;
    }

    public LocalDate getFechaPublicacion() {
        return fechaPublicacion;
    }

    public void setIdLibro(long idLibro) {
        this.idLibro = idLibro;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public void setFechaPublicacion(LocalDate fechaPublicacion) {
        this.fechaPublicacion = fechaPublicacion;
    }

    @Override
    public Libros clone() {
        try {
            return (Libros) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new AssertionError();
        }
    }

    @Override
    public String toString() {
        return "Libros: {"+
                " Id = "+idLibro + " Titulo = "+titulo+" Autor = "+autor+" Fecha = "+fechaPublicacion+"}";
    }

    public void remove(Libros exist) {
        Libros libro = exist;
        libro.remove(exist);
    }
}
