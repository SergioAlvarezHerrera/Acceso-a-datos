package biblioteca;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        BibliotecaXML biblioteca = new BibliotecaXML("biblioteca.xml");

        int opcion;
        do {
            System.out.println("Menú:");
            System.out.println("1. Mostrar libros");
            System.out.println("2. Agregar libro");
            System.out.println("3. Eliminar");
            System.out.println("4. Modificar Año del libro");
            System.out.println("5. Listar libros entre un rango de años");
            System.out.println("6. Listar libros de un año");
            System.out.println("7. Salir");
            
            System.out.print("Seleccione una opción: ");
            opcion = scanner.nextInt();
            scanner.nextLine(); // Limpiar el buffer

            switch (opcion) {
                case 1:
                    biblioteca.mostrarLibros();
                    break;
                case 2:
                    System.out.print("Ingrese el título del libro: ");
                    String titulo = scanner.nextLine();
                    System.out.print("Ingrese el autor del libro: ");
                    String autor = scanner.nextLine();
                    System.out.print("Ingrese el año del libro: ");
                    int año = scanner.nextInt();
                    biblioteca.agregarLibro(titulo, autor, año);
                    biblioteca.escribirXML("biblioteca_modificada.xml"); // Guarda el archivo modificado
                    System.out.println("Libro agregado y archivo guardado como 'biblioteca_modificada.xml'.");
                    break;
                case 3:
                	System.out.println("Escriba el titulo del libro que desee eliminar: ");
                	String titulo1 = scanner.nextLine();
                	biblioteca.borrarXML(titulo1);
                	break;
                    
                    
                case 4:
                	System.out.println("Escriba el titulo del libro que desee modificar el año : ");
                	String titulo2 = scanner.nextLine();
                	System.out.println("Escriba el nuevo año que quiere reemplazar : ");
                	String año1 = scanner.nextLine();
                	biblioteca.modificarAñoXML(titulo2,año1);
                	break;
                	
                case 5:
                	System.out.println("Escriba el primer año : ");
                	String añoS1 = scanner.nextLine();
                	System.out.println("Escriba el ultimo año : ");
                	String añoS2 = scanner.nextLine();
                	biblioteca.listarAñosXML(añoS1 ,añoS2);
                	
                	
                	break;
                	
                case 6:
                	System.out.println("Escriba el año del que quieras obtener los libros : ");
                	String añoL1 = scanner.nextLine();
                	
                	System.out.println(biblioteca.contarLibrosXML(añoL1));
                	
                	break;
                    
                case 7:
                	System.out.println("Saliendo...");
                    break;
                	
                default:
                    System.out.println("Opción no válida. Intente de nuevo.");
            }
        } while (opcion != 3);

        scanner.close();
    }
}