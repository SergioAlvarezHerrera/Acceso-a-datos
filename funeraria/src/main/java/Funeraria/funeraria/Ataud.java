package Funeraria.funeraria;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Ataud {
	
	private int id;
	private double largo;
	private double ancho;
	private String material;
	private boolean vacio;
	private Muerto muerto;
	
	public Ataud(int id ,double largo, double ancho, String material, Muerto muerto) {
		super();
		this.id= id;
		this.largo = largo;
		this.ancho = ancho;
		this.material = material;
		this.vacio = false;
		this.muerto = muerto;
	}
	
	
	public Ataud() {
		
	}
	
	
	@XmlAttribute
	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}

	@XmlElement
	public double getLargo() {
		return largo;
	}

	public void setLargo(double largo) {
		this.largo = largo;
	}
	
	@XmlElement
	public double getAncho() {
		return ancho;
	}

	public void setAncho(double ancho) {
		this.ancho = ancho;
	}
	
	@XmlElement
	public String getMaterial() {
		return material;
	}

	public void setMaterial(String materia) {
		this.material = materia;
	}

	@XmlElement
	public boolean isVacio() {
		return vacio;
	}
	
	public void setVacio(boolean vacio) {
		this.vacio = vacio;
	}

	@XmlElement
	public Muerto getMuerto() {
		return muerto;
	}


	public void setMuerto(Muerto muerto) {
		this.muerto = muerto;
	}


	@Override
	public String toString() {
		return "Ataud [id=" + id + ", largo=" + largo + ", ancho=" + ancho + ", materia=" + material + ", vacio=" + vacio
				+ ", muerto=" + muerto + "]";
	}
	
	
	
	
	
	
	
	

}
