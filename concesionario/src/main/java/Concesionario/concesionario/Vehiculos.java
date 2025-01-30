package Concesionario.concesionario;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Vehiculos {
	
	List<Vehiculo> listaVehiculos = new ArrayList<Vehiculo>();

	public Vehiculos(List<Vehiculo> listaVehiculos) {
		super();
		this.listaVehiculos = listaVehiculos;
	}

	public Vehiculos() {
		
	}
	
	public List<Vehiculo> getListaVehiculos() {
		return listaVehiculos;
	}
	@XmlElement (name= "Vehiculo")
	public void setListaVehiculos(List<Vehiculo> listaVehiculos) {
		this.listaVehiculos = listaVehiculos;
	}
	
	
}
