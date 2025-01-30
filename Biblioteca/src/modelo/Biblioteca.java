package modelo;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Biblioteca {
    private List<Libro> libros;
    private static final String NOMBRE_ARCHIVO = "libros.dat";

    public Biblioteca() {
        libros = new ArrayList<>();
        cargarLibros();
    }

  
    public void cargarLibros() {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(NOMBRE_ARCHIVO))) {
            libros = (List<Libro>) ois.readObject();
        } catch (FileNotFoundException e) {
            System.out.println("El archivo no existe. Se creará uno nuevo al guardar libros.");
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void guardarLibros() {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(NOMBRE_ARCHIVO))) {
            oos.writeObject(libros);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void agregarNuevoLibro(Libro libro) {
        for (Libro l : libros) {
            if (l.getId() == libro.getId()) {
                System.out.println("El libro con el ID " + libro.getId() + " ya existe y no se puede agregar.");
                return;
            }
        }
        libros.add(libro);
        guardarLibros();
    }

    public Libro consultarLibro(int id) {
        for (Libro l : libros) {
            if (l.getId() == id) {
                return l;
            }
        }
        return null;
    }
    
    public void modificarLibro(int id, double nuevoPrecio) {
        for (Libro l : libros) {
            if (l.getId() == id) {
                l.setPrecio(nuevoPrecio);
                guardarLibros();
                System.out.println("Precio del libro con ID " + id + " actualizado a " + nuevoPrecio);
                return;
            }
        }
        System.out.println("No se encontró un libro con ID " + id);
    }

    public void eliminarLibro(int id) {
        for (Libro l : libros) {
            if (l.getId() == id) {
                l.setEliminado(true);
                guardarLibros();
                System.out.println("Libro con ID " + id + " eliminado.");
                return;
            }
        }
        System.out.println("No se puede eliminar el libro con ID " + id + " porque no existe en la base de datos.");
    }

    public void listarLibros() {
        for (Libro l : libros) {
            if (!l.isEliminado()) {
                System.out.println(l);
            }
        }
    }
}
