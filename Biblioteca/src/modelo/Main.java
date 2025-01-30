package modelo;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        List<Biblioteca> listaBibliotecas = new ArrayList<>();
        listaBibliotecas.add(new Biblioteca()); 
        Biblioteca biblioteca = listaBibliotecas.get(0); 
        Scanner scanner = new Scanner(System.in);
        int opcion;
        
        do {
            System.out.println("Menú de opciones:");
            System.out.println("1. Agregar nuevo libro");
            System.out.println("2. Consultar libro por ID");
            System.out.println("3. Modificar libro");
            System.out.println("4. Eliminar libro");
            System.out.println("5. Listar libros");
            System.out.println("6. Salir");
            System.out.print("Elige una opción: ");
            opcion = scanner.nextInt();
            
            switch (opcion) {
                case 1:
                    System.out.print("ID del libro: ");
                    int id = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("Autor del libro: ");
                    String autor = scanner.nextLine();
                    System.out.print("Precio del libro: ");
                    double precio = scanner.nextDouble();
                    scanner.nextLine();
                    System.out.print("Título del libro: ");
                    String titulo = scanner.nextLine();
                    Libro libro = new Libro(id, autor, precio, titulo);
                    biblioteca.agregarNuevoLibro(libro);
                    break;
                    
                case 2:
                    System.out.print("ID del libro: ");
                    int idConsulta = scanner.nextInt();
                    Libro libroConsultado = biblioteca.consultarLibro(idConsulta);
                    if (libroConsultado != null) {
                        System.out.println(libroConsultado);
                    } else {
                        System.out.println("El libro con el ID " + idConsulta + " no existe.");
                    }
                    break;
                    
                case 3:
                    System.out.print("ID del libro a modificar: ");
                    int idModificar = scanner.nextInt();
                    System.out.print("Nuevo precio del libro: ");
                    double nuevoPrecio = scanner.nextDouble();
                    biblioteca.modificarLibro(idModificar, nuevoPrecio);
                    break;
                    
                case 4:
                    System.out.print("ID del libro a eliminar: ");
                    int idEliminar = scanner.nextInt();
                    biblioteca.eliminarLibro(idEliminar);
                    break;
                    
                case 5:
                    biblioteca.listarLibros();
                    break;
                    
                case 6:
                    System.out.println("Saliendo...");
                    break;
                    
                default:
                    System.out.println("Opción no válida. Intente de nuevo.");
            }
        } while (opcion != 6);
        
        scanner.close();
    }
}
