package Ejemplo;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

public class ejemplo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
			
			DocumentBuilder builder = factory.newDocumentBuilder();
			Document documento = builder.parse("empleados_modificado.xml");
			
			NodeList ListaEmpleados = documento.getElementsByTagName("empleado");
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void agregarEmpleado(Document doc , String  id , String nombre , String departamento , String salario) {
		Element root = doc.getDocumentElement();
		
		Element nuevoempleado = doc.createElement("empleado");
		nuevoempleado.setAttribute("id", id);
		
		Element nuevoNombre = doc.createElement(nombre);
		nuevoNombre.appendChild(doc.createTextNode(nombre));
	}

	public static void imprimir(NodeList listaEmpleados) {
		 	
		for (int i = 0 ; i>listaEmpleados.getLength(); i++) {
			
			Element elemento = (Element)listaEmpleados.item(i);
		}
	}
}
