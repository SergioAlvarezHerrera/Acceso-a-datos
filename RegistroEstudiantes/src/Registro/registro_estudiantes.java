package Registro;

import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.InputMismatchException;
import java.util.Scanner;

public class registro_estudiantes {


    public static void main(String[] args) {
        Scanner scaner = new Scanner(System.in);
        String nombreArchivo = "estudiantes.dat";

        try (RandomAccessFile archivo = new RandomAccessFile(nombreArchivo, "rw")) {
            boolean exit = false;
            while (!exit) {
                System.out.println("Menú:");
                System.out.println("1. Escribir registro");   
                System.out.println("2. Actualizar nota de un estudiante");
                System.out.println("3. Mostrar todos los registros ");
                System.out.println("4. Salir del programa");
                System.out.print("Elige una opción: ");
                int option = scaner.nextInt();

                switch (option) {
                    case 1:
                        int id = leerInt(scaner, "ID del estudiante: ");
                        scaner.nextLine(); 
                        String nombre = leerCadenaTexto(scaner, "Nombre del estudiante: ");
                        float nota = leerFloat(scaner, "Nota del estudiante: ");
                        escribirRegistro(archivo, id, nombre, nota);
                        break;
                    
                    case 2:
                    	int idActualizar = leerInt(scaner , "Id del estudiante que desea actualizar:");
                    	
                    	float notaActualizar = leerFloat(scaner , "Nueva Nota :");
                    	
                    		actualizarNota(archivo,idActualizar,notaActualizar);
                    	
                    	break;
                    	
                    case 3:
                    	mostrarTodosLosRegistros(archivo);
                        break;
                        
                    case 4:
                        exit = true;
                        break;
                    default:
                        System.out.println("Opción no válida.");
                }
            }
        } catch (IOException e) {
            System.err.println("Error al acceder al archivo: " + e.getMessage());
        } finally {
            scaner.close();
        }
    }


	public static int leerInt(Scanner scanner, String mensaje) {
        while (true) {
            try {
                System.out.print(mensaje);
                return scanner.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("Error: Por favor, ingresa un número entero.");
                scanner.next(); 
            }
        }
    }

    public static String leerCadenaTexto(Scanner scanner, String mensaje) {
        
    	while (true) {
            System.out.print(mensaje);
            String entrada = scanner.nextLine();
            if (entrada.matches("[a-zA-Z\\s]+")) {
                return entrada;
            } else {
                System.out.println("Error: El nombre solo debe contener letras y espacios.");
            }
        }
    	
    	
    }

    public static float leerFloat(Scanner scanner, String mensaje) {
        while (true) {
            try {
                System.out.print(mensaje);
                return scanner.nextFloat();
            } catch (InputMismatchException e) {
                System.out.println("Error: Por favor, ingresa un número decimal.");
                scanner.next();
            }
        }
    }

    public static void escribirRegistro(RandomAccessFile archivo, int id, String nombre, float nota) throws IOException {
        archivo.seek(id-1 * 48);
        archivo.writeInt(id);

        StringBuilder sb = new StringBuilder(nombre);
        if (sb.length() > 20) {
            sb.setLength(20);
        } else {
            while (sb.length() < 20) {
                sb.append(" ");
            }
        }
        archivo.writeChars(sb.toString());
        archivo.writeFloat(nota);
    }
    
    public static void leerRegistro(RandomAccessFile archivo, int id) throws IOException {
        long posicion = id * 48;
        if (posicion >= archivo.length()) {
            System.out.println("Registro no encontrado.");
            return;
        }

        archivo.seek(posicion);
        int idLeido = archivo.readInt();
        char[] nombreChars = new char[20];
        for (int i = 0; i < 20; i++) {
            nombreChars[i] = archivo.readChar();
        }
        String nombre = new String(nombreChars).trim();
        float nota = archivo.readFloat();

        System.out.printf("El estudiante con ID %d, de nombre %s tiene como calificación %.2f%n", idLeido, nombre, nota);
    }
    
    public static void actualizarNota(RandomAccessFile archivo , int id , float nuevanota) throws IOException { 
    	
    		 long posicion = id * 48 + 44;
    		 
    		 if (posicion> archivo.length()) {
    			 System.out.println("Registro no encontrado");
    			 return;
    		 }
    		 
    		 archivo.seek(posicion);
             archivo.writeFloat(nuevanota);
             System.out.println("Nota actualizada con éxito");
             
    	 
  	 
     }
    
    public static void mostrarTodosLosRegistros(RandomAccessFile archivo) {
        try {
            archivo.seek(0); 

            while (archivo.getFilePointer() < archivo.length()) {
                int id = archivo.readInt();
               
                char[] nombreChars = new char[20];
                for (int i = 0; i < 20; i++) {
                    nombreChars[i] = archivo.readChar();
                }
                String nombre = new String(nombreChars).trim(); 
                
                float nota = archivo.readFloat();

                System.out.printf("Estudiante %d, de nombre %s calificado con un %.1f%n", id, nombre, nota);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    	
  }
    	
    	
 
    
    
    
    

