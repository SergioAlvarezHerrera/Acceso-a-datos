package Funeraria.funeraria;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Ataudes {
	
	List<Ataud> listaAtaud = new ArrayList<Ataud>();

	public Ataudes(List<Ataud> listaAtaud) {
		super();
		this.listaAtaud = listaAtaud;
	}
	
	public Ataudes() {
		
	}
	
	public List<Ataud> getListaAtaud() {
		return listaAtaud;
	}
	
	@XmlElement (name = "ataud")
	public void setListaAtaud(List<Ataud> listaAtaud) {
		this.listaAtaud = listaAtaud;
	}
	
	
	
	
}
