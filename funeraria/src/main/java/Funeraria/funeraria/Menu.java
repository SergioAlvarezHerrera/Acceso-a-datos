package Funeraria.funeraria;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

public class Menu {
	
	private final static String FILE = "funeraria.xml";
	
	public static void main(String[] args) {
		
		boolean flag = true ;
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int eleccion = 0;
		Ataudes ataudes = cargarXML();
		
		while (flag) {
			
			System.out.println("Selecciona una opcion");
			System.out.println("1-Agregar Ataud");
			System.out.println("2-Listar Ataud");
			System.out.println("3-Salir");
			
			try {
				
				eleccion = Integer.parseInt(br.readLine());
				
				switch (eleccion) {
				case 1:
					
					System.out.println("indica un id");
					int id1 = Integer.parseInt(br.readLine());
					
					System.out.println("indica un ancho");
					double ancho1 = Double.parseDouble(br.readLine());
					
					System.out.println("indica un largo");
					double largo1  = Double.parseDouble(br.readLine());
					
					System.out.println("indica un material");
					String material1 = br.readLine();
					
					System.out.println("indica una edad del muerto");
					int edad1 = Integer.parseInt(br.readLine());
					
					System.out.println("indica el nombre del muerto");
					String nombre1 = br.readLine();
					
					System.out.println("indica una fecha del muerto");
					String fecha1 = br.readLine();
					
					agregar(ataudes ,id1, ancho1 ,largo1,material1,edad1,nombre1,fecha1);
					guardarXML(ataudes);
					
					
					break;
					
				case 2:
					Listar(ataudes);
					break;
				
				case 3:
					guardarXML(ataudes);
					flag = false;
					break;

				default:
					guardarXML(ataudes);
					flag = false;
					break;
				}
				
				
			} catch (IOException e) {
				// TODO: handle exception
				e.printStackTrace();
			} catch (NumberFormatException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
			
		}
		
		
	}
	
	
	public static Ataudes cargarXML() {
		File archivo = new File(FILE);
		if(!archivo.exists()){
			System.out.println("no hay ningun archivo xml");
			return new Ataudes();
		}
		
	
		try {
			JAXBContext contexto = JAXBContext.newInstance(Ataudes.class);
			Unmarshaller unmarshaller = contexto.createUnmarshaller();
			
			return(Ataudes) unmarshaller.unmarshal(archivo);
			
		} catch (JAXBException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return new Ataudes();
		}
	}
	
	public static void guardarXML(Ataudes ataudes) {
		try {
			JAXBContext contexto = JAXBContext.newInstance(Ataudes.class);
			Marshaller marshaller = contexto.createMarshaller();
			marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
			marshaller.marshal(ataudes, new File(FILE));
			
		} catch (JAXBException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public static void Listar(Ataudes ataudes){
		
		if(ataudes.getListaAtaud().isEmpty()) {
			System.out.println("no hay ningun ataud");
		
		}else {
			for(Ataud ataud : ataudes.getListaAtaud()) {
				System.out.println(ataud);
				
			}
		}
		
	}
	
	public static void agregar (Ataudes ataudes ,int id ,double largo, double ancho , String material, int edad , String nombre , String fecha) {
		ataudes.getListaAtaud().add(new Ataud(id,largo,ancho,material, new Muerto (edad , nombre ,fecha)));
		System.out.println("se ha agregado un ataud");
	}
	

}
