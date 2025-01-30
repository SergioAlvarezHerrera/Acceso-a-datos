package gestion;

import java.io.Serializable;
import java.util.Date;

public class Reserva implements Serializable {
    private Cliente cliente;
    private Habitacion habitacion;
    private Date fechaEntrada;
    private Date fechaSalida;

    public Reserva(Cliente cliente, Habitacion habitacion, Date fechaEntrada, Date fechaSalida) {
        this.cliente = cliente;
        this.habitacion = habitacion;
        this.fechaEntrada = fechaEntrada;
        this.fechaSalida = fechaSalida;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public Habitacion getHabitacion() {
        return habitacion;
    }

    public Date getFechaEntrada() {
        return fechaEntrada;
    }

    public Date getFechaSalida() {
        return fechaSalida;
    }

    public double calcularCostoTotal() {
        long diff = fechaSalida.getTime() - fechaEntrada.getTime();
        long dias = diff / (1000 * 60 * 60 * 24);
        return dias * habitacion.getPrecioPorNoche();
    }

    @Override
    public String toString() {
        return "Cliente: " + cliente.getNombre() + ", Habitación: " + habitacion.getNumero() + ", Entrada: " + fechaEntrada + ", Salida: " + fechaSalida + ", Costo: " + calcularCostoTotal();
    }
}
