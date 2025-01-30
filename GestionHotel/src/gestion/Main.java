package gestion;
import java.text.SimpleDateFormat;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Hotel hotel = new Hotel();
        Scanner scanner = new Scanner(System.in);
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

        
        hotel = Hotel.cargarDatos("hotel_data.dat");

        while (true) {
            
            System.out.println("\nMenu:");
            System.out.println("1. Registrar cliente");
            System.out.println("2. Registrar habitación");
            System.out.println("3. Crear reserva");
            System.out.println("4. Listar clientes");
            System.out.println("5. Listar habitaciones");
            System.out.println("6. Listar reservas");
            System.out.println("7. Salir");
            System.out.print("Selecciona una opción: ");
            int opcion = scanner.nextInt();
            scanner.nextLine(); 
            switch (opcion) {
                case 1:
                    
                    System.out.print("Nombre: ");
                    String nombre = scanner.nextLine();
                    System.out.print("Documento de identidad: ");
                    String documento = scanner.nextLine();
                    System.out.print("Teléfono: ");
                    String telefono = scanner.nextLine();
                    Cliente cliente = new Cliente(nombre, documento, telefono);
                    hotel.agregarCliente(cliente);
                    break;

                case 2:
                    
                    System.out.print("Número de habitación: ");
                    int numero = scanner.nextInt();
                    scanner.nextLine();  
                    System.out.print("Tipo de habitación (Simple, Doble, Suite): ");
                    String tipo = scanner.nextLine();
                    System.out.print("Precio por noche: ");
                    double precio = scanner.nextDouble();
                    Habitacion habitacion = new Habitacion(numero, tipo, precio);
                    hotel.agregarHabitacion(habitacion);
                    break;

                case 3:
                    
                    System.out.print("Documento de identidad del cliente: ");
                    String docCliente = scanner.nextLine();
                    Cliente clienteReserva = null;
                   
                    for (Cliente c : hotel.getClientes()) {
                        if (c.getDocumentoIdentidad().equals(docCliente)) {
                            clienteReserva = c;
                            break;
                        }
                    }
                    if (clienteReserva == null) {
                        System.out.println("Cliente no encontrado.");
                        break;
                    }

                    System.out.println("Habitaciones disponibles:");
                    boolean hayHabitacionesDisponibles = false;
                    for (Habitacion h : hotel.getHabitaciones()) {  
                        if (h.isDisponible()) {
                            System.out.println(h);
                            hayHabitacionesDisponibles = true;
                        }
                    }

                    if (!hayHabitacionesDisponibles) {
                        System.out.println("No hay habitaciones disponibles.");
                        break;
                    }

                    
                    System.out.print("Número de habitación: ");
                    int numHabitacion = scanner.nextInt();
                    Habitacion habitacionReserva = null;
                    for (Habitacion h : hotel.getHabitaciones()) {  
                        if (h.getNumero() == numHabitacion && h.isDisponible()) {
                            habitacionReserva = h;
                            break;
                        }
                    }

                    if (habitacionReserva == null) {
                        System.out.println("Habitación no disponible o no existe.");
                        break;
                    }

                    scanner.nextLine(); 
                    System.out.print("Fecha de entrada (dd/MM/yyyy): ");
                    Date fechaEntrada = null;
                    try {
                        fechaEntrada = sdf.parse(scanner.nextLine());
                    } catch (Exception e) {
                        System.out.println("Fecha inválida.");
                        break;
                    }

                    System.out.print("Fecha de salida (dd/MM/yyyy): ");
                    Date fechaSalida = null;
                    try {
                        fechaSalida = sdf.parse(scanner.nextLine());
                    } catch (Exception e) {
                        System.out.println("Fecha inválida.");
                        break;
                    }

                    if (hotel.crearReserva(clienteReserva, habitacionReserva, fechaEntrada, fechaSalida)) {
                        System.out.println("Reserva creada con éxito.");
                    } else {
                        System.out.println("No se pudo crear la reserva.");
                    }
                    break;

                case 4:
                    
                    hotel.listarClientes();
                    break;

                case 5:
                    
                    hotel.listarHabitaciones();
                    break;

                case 6:
                    
                    hotel.listarReservas();
                    break;

                case 7:
                    
                    hotel.guardarDatos("hotel_data.dat");
                    System.out.println("Datos guardados. ¡Adiós!");
                    return;

                default:
                    System.out.println("Opción no válida.");
            }
        }
    }
}