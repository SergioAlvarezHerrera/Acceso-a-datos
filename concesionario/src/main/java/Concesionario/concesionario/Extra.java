package Concesionario.concesionario;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Extra {
	
	private String color ;
	private int numRuedas ;
	private boolean aleron;
	
	public Extra() {
		
	}
	
	public Extra(String color, int numRuedas, boolean aleron) {
		super();
		this.color = color;
		this.numRuedas = numRuedas;
		this.aleron = aleron;
	}
	
	@XmlElement
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	
	@XmlElement
	public int getNumRuedas() {
		return numRuedas;
	}
	public void setNumRuedas(int numRuedas) {
		this.numRuedas = numRuedas;
	}
	
	@XmlElement
	public boolean isAleron() {
		return aleron;
	}
	public void setAleron(boolean aleron) {
		this.aleron = aleron;
	}

	@Override
	public String toString() {
		return "Extra [color=" + color + ", numRuedas=" + numRuedas + ", aleron=" + aleron + "]";
	}
	
	
	

}
