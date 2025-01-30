package biblioteca;

import org.w3c.dom.*;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.*;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.File;

public class BibliotecaXML {
	private Document document;
	private String xmlFilePath;

	public BibliotecaXML(String xmlFilePath) {
		this.xmlFilePath = xmlFilePath;
		this.document = leerXML(xmlFilePath);
	}

	public Document leerXML(String filePath) {
		try {
			DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
			DocumentBuilder builder = factory.newDocumentBuilder();
			return builder.parse(new File(filePath));
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	public void mostrarLibros() {
		NodeList libros = document.getElementsByTagName("libro");
		for (int i = 0; i < libros.getLength(); i++) {
			Element libro = (Element) libros.item(i);
			String titulo = libro.getElementsByTagName("titulo").item(0).getTextContent();
			String autor = libro.getElementsByTagName("autor").item(0).getTextContent();
			String año = libro.getElementsByTagName("año").item(0).getTextContent();
			System.out.println("Título: " + titulo + ", Autor: " + autor + ", Año: " + año);
		}
	}

	public boolean libroExiste(String titulo) {
		NodeList libros = document.getElementsByTagName("libro");
		for (int i = 0; i < libros.getLength(); i++) {
			Element libro = (Element) libros.item(i);
			String libroTitulo = libro.getElementsByTagName("titulo").item(0).getTextContent();
			if (libroTitulo.equalsIgnoreCase(titulo)) {
				return true;
			}
		}
		return false;
	}

	public void agregarLibro(String titulo, String autor, int año) {
		if (libroExiste(titulo)) {
			System.out.println("El libro ya existe en la biblioteca.");
			return;
		}

		Element nuevoLibro = document.createElement("libro");
		Element nuevoTitulo = document.createElement("titulo");
		Element nuevoAutor = document.createElement("autor");
		Element nuevoAño = document.createElement("año");

		nuevoTitulo.setTextContent(titulo);
		nuevoAutor.setTextContent(autor);
		nuevoAño.setTextContent(String.valueOf(año));

		nuevoLibro.appendChild(nuevoTitulo);
		nuevoLibro.appendChild(nuevoAutor);
		nuevoLibro.appendChild(nuevoAño);

		document.getDocumentElement().appendChild(nuevoLibro);
	}

	public void escribirXML(String outputPath) {
		try {
			TransformerFactory transformerFactory = TransformerFactory.newInstance();
			Transformer transformer = transformerFactory.newTransformer();
			DOMSource source = new DOMSource(document);
			StreamResult result = new StreamResult(new File(outputPath));
			transformer.transform(source, result);
		} catch (TransformerException e) {
			e.printStackTrace();
		}
	}

	public void borrarXML(String titulos) {
		// cogemos la lista de nodos
		NodeList libros = document.getElementsByTagName("libro");
		// recorremos la lista sacando otra lista de titulos
		for (int i = 0; i < libros.getLength(); i++) {
			// cogemos cada uno de los libros
			Element libro = (Element) libros.item(i);
			// de cada uno de estos libros se lo agregamos a la lista
			NodeList titulosNodeList = libro.getElementsByTagName("titulo");

			// comprobamos que la lista no esta vacia
			if (titulosNodeList.getLength() > 0) {
				// cogemos cada titulo de la lista
				String titulo = titulosNodeList.item(0).getTextContent();

				// de cada titulo comprobamos si es el mismo que el de la lista
				if (titulos != null && titulos.equals(titulo)) {
					// seleccionamos el nodo padre
					Node parent = libro.getParentNode();
					// de ese nodo padre lo eliminamos
					parent.removeChild(libro);
				}
			}
		}
	}

	public void modificarAñoXML(String titulos, String nuevoAño) {
		NodeList libros = document.getElementsByTagName("libro");
		for (int i = 0; i < libros.getLength(); i++) {

			Element libro = (Element) libros.item(i);

			NodeList titulosNodeList = libro.getElementsByTagName("titulo");
			if (titulosNodeList.getLength() > 0) {
				String titulo = titulosNodeList.item(0).getTextContent();

				if (titulos != null && titulos.equals(titulo)) {
					libro.getElementsByTagName("año").item(0).setTextContent(nuevoAño);
				}

			}
		}
	}
	
	public void listarAñosXML(String año1S, String año2S){
		NodeList libros = document.getElementsByTagName("libro");
		for (int i = 0; i < libros.getLength(); i++) {
			Element libro = (Element) libros.item(i);
			NodeList añoNodeList = libro.getElementsByTagName("año");
			
			int año1 = Integer.parseInt(año1S);
			int año2 = Integer.parseInt(año2S);
			
		if (añoNodeList.getLength() > 0) {
			String añoS = añoNodeList.item(0).getTextContent();	
			int año = Integer.parseInt(añoS);
			
			if(año >= año1 && año<= año2) {
				String titulo = libro.getElementsByTagName("titulo").item(0).getTextContent();
				String autor = libro.getElementsByTagName("autor").item(0).getTextContent();
				String añoX = libro.getElementsByTagName("año").item(0).getTextContent();
				System.out.println("Título: " + titulo + ", Autor: " + autor + ", Año: " + añoX);
			}
			
			
			
			}
		
		}
		
	}
	
	public int contarLibrosXML(String año1S) {
		int cantidad= 0;
		NodeList libros = document.getElementsByTagName("libro");
		for (int i = 0; i < libros.getLength(); i++) {
			Element libro = (Element) libros.item(i);
			NodeList añoNodeList = libro.getElementsByTagName("año");
			int año1 = Integer.parseInt(año1S);
			
			if (añoNodeList.getLength() > 0) {
				String añoS = añoNodeList.item(0).getTextContent();	
				int año = Integer.parseInt(añoS);
				
				if (año == año1) {
					cantidad ++ ;
					
				}
			}
				
			
				
		}
		return cantidad;
		
	}
	
}
