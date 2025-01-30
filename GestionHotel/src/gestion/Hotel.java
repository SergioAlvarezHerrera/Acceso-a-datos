package gestion;

import java.io.*;
import java.util.*;

public class Hotel implements Serializable {
    private List<Cliente> clientes;
    private List<Habitacion> habitaciones;
    private List<Reserva> reservas;

    public Hotel() {
        this.setClientes(new ArrayList<>());
        this.habitaciones = new ArrayList<>();
        this.reservas = new ArrayList<>();
    }

    // Getter para la lista de habitaciones
    public List<Habitacion> getHabitaciones() {
        return habitaciones;
    }

    // Método para agregar clientes
    public void agregarCliente(Cliente cliente) {
        getClientes().add(cliente);
    }

    // Método para agregar habitaciones
    public void agregarHabitacion(Habitacion habitacion) {
        habitaciones.add(habitacion);
    }

    // Método para crear reserva
    public boolean crearReserva(Cliente cliente, Habitacion habitacion, Date fechaEntrada, Date fechaSalida) {
        if (!verificarColisionReserva(habitacion, fechaEntrada, fechaSalida)) {
            Reserva reserva = new Reserva(cliente, habitacion, fechaEntrada, fechaSalida);
            reservas.add(reserva);
            habitacion.ocupar();  // Marcar la habitación como ocupada
            return true;
        }
        return false;
    }

    // Método para verificar colisiones de reserva
    public boolean verificarColisionReserva(Habitacion habitacion, Date fechaEntrada, Date fechaSalida) {
        for (Reserva reserva : reservas) {
            if (reserva.getHabitacion().equals(habitacion)) {
                if ((fechaEntrada.before(reserva.getFechaSalida()) && fechaSalida.after(reserva.getFechaEntrada()))) {
                    return true;  // Hay colisión de fechas
                }
            }
        }
        return false;
    }

    // Métodos para listar clientes, habitaciones y reservas
    public void listarClientes() {
        for (Cliente cliente : getClientes()) {
            System.out.println(cliente);
        }
    }

    public void listarHabitaciones() {
        for (Habitacion habitacion : habitaciones) {
            System.out.println(habitacion);
        }
    }

    public void listarReservas() {
        for (Reserva reserva : reservas) {
            System.out.println(reserva);
        }
    }

    // Método para cargar datos desde archivo
    public static Hotel cargarDatos(String archivo) {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(archivo))) {
            return (Hotel) ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            return new Hotel();  // Si no se encuentra el archivo, crear una nueva instancia
        }
    }

    // Método para guardar datos en archivo
    public void guardarDatos(String archivo) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(archivo))) {
            oos.writeObject(this);
        } catch (IOException e) {
            System.out.println("Error al guardar los datos.");
        }
    }

	public List<Cliente> getClientes() {
		return clientes;
	}

	public void setClientes(List<Cliente> clientes) {
		this.clientes = clientes;
	}
}