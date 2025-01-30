package Concesionario.concesionario;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;


public class Menu {
	
	private static final String FILE = "vehiculo.xml";
	
	public static void main(String[] args) {
		boolean flag = true;
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int eleccion = 0;
		Vehiculos vehiculos = cargarDatos();
		
		
		
			while(flag) {
				System.out.println("selecciona una opcion");
				System.out.println("1Agregar vehiculo");
				System.out.println("2ver lista de vehilculos");
				System.out.println("3salir");
				
				
			try {			
					eleccion = Integer.parseInt(br.readLine());
					
					switch (eleccion) {
					case 1:
						System.out.println("Escribe un id");
						int id1 = Integer.parseInt(br.readLine());
						
						System.out.println("Escribe un modelo");
						String modelo1 = br.readLine();
						
						System.out.println("Escribe un precio");
						double precio1 = Double.parseDouble(br.readLine());
						
						
						System.out.println("Escribe un año ");
						int año1 = Integer.parseInt(br.readLine());
						
						System.out.println("Escribe el color");
						String color1 = br.readLine();
						
						System.out.println("Indica el numero de ruedas");
						int numRuedas1 = Integer.parseInt(br.readLine());
						
						
						
						agregar(vehiculos, id1,modelo1 ,precio1 ,año1 , color1 ,numRuedas1);
						guardar(vehiculos);
						
						
						
						break;
						
					case 2:
						
						listar(vehiculos);
						break;
						
					case 3:
						guardar(vehiculos);
						flag = false;
						System.out.println("...Saliendo...");
						
						break;
	
					default:
						guardar(cargarDatos());
						flag = false;
						System.out.println("...Saliendo...");
						break;
					}
					
				
				
			} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO: handle exception
			e.printStackTrace();
		
		}
			
				
			}
		
	}
	
	


	public static Vehiculos cargarDatos() {
		File archivo = new File(FILE);
		if (!archivo.exists()) {
			System.out.println("no hay nada agregado aun");
			return new Vehiculos();
		}
		
		try {
			JAXBContext contexto = JAXBContext.newInstance(Vehiculos.class);
			Unmarshaller unmarshaller = contexto.createUnmarshaller();
			
			System.out.println("la lista ha sido cargada con exito");
			return (Vehiculos) unmarshaller.unmarshal(archivo);
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		return new Vehiculos();
	}
	
	public static void guardar(Vehiculos vehiculos) {
		try {
			JAXBContext contexto = JAXBContext.newInstance(Vehiculos.class);
			Marshaller marshaller = contexto.createMarshaller();
			marshaller.setProperty(marshaller.JAXB_FORMATTED_OUTPUT, true);
			marshaller.marshal(vehiculos, new File(FILE));
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		
	}
	
	public static void listar(Vehiculos vehiculos) {
		if(vehiculos.getListaVehiculos().isEmpty()) {
			System.out.print("no hay registro de ningun vehiculo agrega tu uno");
			
		}else {
			for(Vehiculo vehiculo: vehiculos.getListaVehiculos()) {
				System.out.println(vehiculo);
			}
		}
		
	}
	
	
	public static void agregar(Vehiculos vehiculos , int id , String modelo , double precio , int año ,String color, int numRuedas) {
		vehiculos.getListaVehiculos().add(new Vehiculo(id , modelo ,precio,año , new Extra(color , numRuedas , true) ));
		System.out.println("el vehiculo ha sido añadido");
		
	}
	
	
	

}
