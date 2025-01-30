package modelo;

import java.io.Serializable;

public class Libro implements Serializable {
    private int id;
    private String autor;
    private double precio;
    private boolean eliminado;
    private String titulo;

    public Libro(int id, String autor, double precio, String titulo) {
        this.id = id;
        this.autor = autor;
        this.precio = precio;
        this.eliminado = false;
        this.titulo = titulo;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public boolean isEliminado() {
        return eliminado;
    }

    public void setEliminado(boolean eliminado) {
        this.eliminado = eliminado;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    @Override
    public String toString() {
        return "Datos del libro seleccionado: " +
                "Id = " + id +
                ", Autor = " + autor +
                ", Título = " + titulo +
                ", Precio = " + precio;
    }
}
