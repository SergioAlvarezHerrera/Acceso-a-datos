package analisisFicheros;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class AnalisisSecuencialFichero {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		String rutaentrada = "texto_ejemplo.txt";
		String rutasalida = "resultado_analisis.txt";
		
		int numlineas=0;
		int numPalabras=0;
		int numCaracteres=0;
		
		try(BufferedReader br=new BufferedReader(new FileReader(rutaentrada))){
			
			String linea;
			
		while((linea=br.readLine()) != null) {
			numlineas++;
			numCaracteres+=linea.length();
			String[]palabras=linea.split("\\s");
			numPalabras+=palabras.length;
			
		}
			
		}catch (IOException e) {
		
			System.out.println("Error al leer el archivo" +e.getMessage());
			
		}
		
		
		try(BufferedWriter bw= new BufferedWriter (new FileWriter(rutasalida))){
			
			bw.write ("Resultado del analisis");
			bw.newLine();
			bw.write("Archivo analizado: " + rutaentrada);
			bw.newLine();
			bw.write("Numero de lineas: " + numlineas);
			bw.newLine();
			bw.write("Numero de palabras: " + numPalabras);
			bw.newLine();
			bw.write("Numero de caracteres: " + numCaracteres);
			
			
		}catch(IOException e){
			System.out.println("Error al escribir en el archivo");
			
		}
		
		
		
		System.out.println("Archivo analizado: " + rutaentrada);
		System.out.println("Numero de lineas: " + numlineas);
		System.out.println("Numero de palabras: " + numPalabras);
		System.out.println("Numero de caracteres: " + numCaracteres);
		System.out.println("Los resultados se han guardado en el archivo: " + rutasalida);
		
		
		
		

	}
	
	

}
