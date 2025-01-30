package Concesionario.concesionario;

import java.util.List;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
class Vehiculo {
	
	private int id;
	private String modelo;
	private Double precio; 
	private int año;
	private Extra extra;
	
	public Vehiculo(int id , String modelo, double precio , int año , Extra extra) {
		super();
		this.id = id;
		this.modelo=modelo;
		this.precio=precio;
		this.año=año;
		this.extra = extra;
		
	}
	
	public Vehiculo() {
		
	}
	
	@XmlAttribute
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	@XmlElement
	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}
	
	@XmlElement
	public double getPrecio() {
		return precio;
	}

	public void setPrecio(double precio) {
		this.precio = precio;
	}
	
	@XmlElement
	public int getAño() {
		return año;
	}

	public void setAño(int año) {
		this.año = año;
	}

	@XmlElement
	public Extra getExtra() {
		return extra;
	}

	public void setExtra(Extra extra) {
		this.extra = extra;
	}
	
	@Override
	public String toString() {
		return "Vehiculo [id=" + id + ", modelo=" + modelo + ", precio=" + precio + ", año=" + año + ", extra=" + extra
				+ "]";
	}
	
	

	
	
	
	

}
