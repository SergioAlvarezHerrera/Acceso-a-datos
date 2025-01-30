package Funeraria.funeraria;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Muerto {
	
	private int edad;
	private String nombre;
	private String fecha;
	
	public Muerto(int edad, String nombre, String fecha) {
		super();
		this.edad = edad;
		this.nombre = nombre;
		this.fecha = fecha;
	}
	
	public Muerto() {
		
	}
	
	@XmlElement
	public int getEdad() {
		return edad;
	}

	public void setEdad(int edad) {
		this.edad = edad;
	}
	
	@XmlElement
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	@XmlElement
	public String getFecha() {
		return fecha;
	}

	public void setFecha(String fecha) {
		this.fecha = fecha;
	}

	@Override
	public String toString() {
		return "Muerto [edad=" + edad + ", nombre=" + nombre + ", fecha=" + fecha + "]";
	}
	
	

	
	
}
