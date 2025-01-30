package manejo;

import java.io.IOException;
import java.io.RandomAccessFile;

public class manejoNumeros {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//cargamos el archivo de almacenamiento
		String nombreArchivo = "numeros.dat";
		
		try (RandomAccessFile archivo = new RandomAccessFile(nombreArchivo , "rw")){
			
			//Escribimos 10 numeros en el archivo
			
			System.out.println("escribiendo numeros");
			for (int i = 1 ; i<=10 ; i++) {
				archivo.writeInt(i);	
			}
			
			//leer los numeros del archivo y mostrarlos
			
			System.out.println("numeros en el archivo");
			 mostrarNumeros(archivo);
			
			 //actualizar el tercer numero 
			 int nuevoNumero = 100;
			 archivo.seek(2*Integer.BYTES);
			 archivo.writeInt(nuevoNumero);
			 
			 //Mostrar los numeros actualizados
			 
			 System.out.println("NUmeros despues de actualizar");
			 mostrarNumeros(archivo);
			
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("error al acceder al archivo" + e.getMessage());
		}
		
		
	}
	
	//Metodo auxiliar que se encarga de mostrar los numeros del archivos 
	private static void mostrarNumeros(RandomAccessFile archivo) throws IOException {
		
		archivo.seek(0);//inicio del archivo
		while (archivo.getFilePointer() < archivo.length()) {
			
			System.out.println(archivo.readInt() + " ");
		}		
		System.out.println();
					
	}

}
