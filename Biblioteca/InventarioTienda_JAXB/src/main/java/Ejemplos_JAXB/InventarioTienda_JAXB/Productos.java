package Ejemplos_JAXB.InventarioTienda_JAXB;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Productos {
	 private  List<Producto> listaProducto= new ArrayList<Producto>();
	 
	 public void Productos() {
		 
	 }

	public List<Producto> getListaProducto() {
		return listaProducto;
	}
	
	@XmlElement (name="Producto")
	public void setListaProducto(List<Producto> listaProducto) {
		this.listaProducto = listaProducto;
	}
	
	public void agregarProducto(Producto nuevoProducto) {
		listaProducto.add(nuevoProducto);
	}
	 
	 
}
