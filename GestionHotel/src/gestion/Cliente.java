package gestion;

import java.io.Serializable;

public class Cliente implements Serializable {
    private String nombre;
    private String documentoIdentidad;
    private String telefono;

    public Cliente(String nombre, String documentoIdentidad, String telefono) {
        this.nombre = nombre;
        this.documentoIdentidad = documentoIdentidad;
        this.telefono = telefono;
    }

    public String getNombre() {
        return nombre;
    }

    public String getDocumentoIdentidad() {
        return documentoIdentidad;
    }

    public String getTelefono() {
        return telefono;
    }

    @Override
    public String toString() {
        return "Nombre: " + nombre + ", Documento: " + documentoIdentidad + ", Teléfono: " + telefono;
    }
}