package Ejemplos_JAXB.InventarioTienda_JAXB;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

public class Menu {
	private static final String RUTA_XML = "producto.xml";

	public static void main(String[] args) {
		boolean flag = true;
		int eleccion = 3;
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		Productos productos = cargarXMl();
		
		System.out.println("---Bienvendio a nuestra tienda---");
		while (flag) {
			System.out.println("Selecciona la opcción que desses");
			System.out.println(".    1-Listar los productos");
			System.out.println(".    2-Agregar un producto");
			System.out.println(".    3-Salir");
			try {
				eleccion = Integer.parseInt(in.readLine());

				
				switch (eleccion) {
				case 1:
					listarProductos(productos);
					break;
				case 2:
					System.out.println("Escribe un id");
					int idnuevo = Integer.parseInt(in.readLine());
					System.out.println("Escribe un nombre");
					String nuevonombre = in.readLine();
					System.out.println("Escribe una cantidad");
					int cantidadnuevo = Integer.parseInt(in.readLine());
					System.out.println("Escribe un precio");
					double precionuevo = Double.parseDouble(in.readLine());
					agregarProducto(productos, idnuevo, nuevonombre, cantidadnuevo, precionuevo);
					guardarListaAlXML(productos);

					break;
				case 3:
					guardarListaAlXML(productos);
					flag = false;
					System.out.println("...Saliendo...");
					break;
				default:
					guardarListaAlXML(productos);
					flag = false;
					System.out.println("...Saliendo...");
					break;
				}

			} catch (NumberFormatException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	private static Productos cargarXMl() {
		File archivo= new File(RUTA_XML);
		if (!archivo.exists()) {
			System.out.println("Demomento no hay nada agregado -- Agrega un nuevo producto a la lista");
			return new Productos();
		} 
			try {
				JAXBContext contexto = JAXBContext.newInstance(Productos.class);
				Unmarshaller unmarshaller = contexto.createUnmarshaller();

				System.out.println("La lista se cargo exitosamente ");
				return (Productos) unmarshaller.unmarshal(archivo);

			} catch (JAXBException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				return new Productos();
			}
	}

	private static void listarProductos(Productos productos) {
		if (productos.getListaProducto().isEmpty()) {
			System.out.println("No hay ningun producto -- Agrega uno");
		} else {
			for (Producto producto : productos.getListaProducto()) {
				System.out.println(producto);
			}
		}
	}

	private static void agregarProducto(Productos productos, int id, String nombre, int cantidad, double precio) {
		productos.agregarProducto(new Producto(id, nombre, cantidad, precio));
		System.out.println("El producto se agrego correctamente");
	}

	private static void guardarListaAlXML(Productos productos) {
		try {
			JAXBContext contexto = JAXBContext.newInstance(Productos.class);
			Marshaller marshaller = contexto.createMarshaller();
			marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
			marshaller.marshal(productos, new File(RUTA_XML));
		} catch (JAXBException e) {
			e.printStackTrace();
		}
	}

}
