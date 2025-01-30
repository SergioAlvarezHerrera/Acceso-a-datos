package gestion;

import java.io.Serializable;

public class Habitacion implements Serializable {
    private int numero;
    private String tipo;
    private double precioPorNoche;
    private boolean disponible;

    public Habitacion(int numero, String tipo, double precioPorNoche) {
        this.numero = numero;
        this.tipo = tipo;
        this.precioPorNoche = precioPorNoche;
        this.disponible = true; // Por defecto, la habitación está disponible
    }

    public int getNumero() {
        return numero;
    }

    public String getTipo() {
        return tipo;
    }

    public double getPrecioPorNoche() {
        return precioPorNoche;
    }

    public boolean isDisponible() {
        return disponible;
    }

    public void ocupar() {
        this.disponible = false;
    }

    public void liberar() {
        this.disponible = true;
    }

    @Override
    public String toString() {
        return "Número: " + numero + ", Tipo: " + tipo + ", Precio/Noche: " + precioPorNoche + ", Estado: " + (disponible ? "Disponible" : "Ocupada");
    }
}