package Unidad_6;

import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

/*
 * El programa creará un flujo de escritura utilizando un objeto 
 * de la clase FileOutputStream.
 * Luego todos los calores se escribirán en el flujo mediante 
 * un ciclo, utilizando el método write() de la clase 
 * FileOutputStream.Finalmente, el flujo se cierra.
 */
public class ArchivoCon100Numeros {
	public static void main (String[]args) {
		FileOutputStream flujoDeSalida;
		try {
			flujoDeSalida = new FileOutputStream("NumerosNaturales.dat");
			for(int i=0; i<100; i++) {
				try {
					flujoDeSalida.write(i);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			try {
				flujoDeSalida.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}


///*
// *
// * Programa de la profe
// * Public class ArchivoCon100Numeros{
// *public static void main(String[ ] args){
//*try{
//* FileOutputStream flujoDeSalida = new FileOutputStream(“NumerosNaturales.dat”);
// *for(int i=0; i < 100; i++){
//* flujoDeSalida.write(i);
// *}
// *flujoDeSalida.close();
// *}catch(IOException e){
// System.out.println(“Error de escritura ” + e.toString());
// }
//}

/**
 * El método define un flujo para lectura del archivo recibido,
 * creando un objeto de la clase FileInputStream. 
 * Se utiliza un ciclo para leer en cada interación un valor entero 
 * desde el flujo de entrada, mediante el método read().
 * Cada valor será sumado en la variable para este fin.
 * El flujo de entrada se cierra y el método regresa la suma calculada. 
 * @throws IOException 
 */
public int getSumaNumerosArchivo(String nombreArchivo) throws IOException {
	FileInputStream flujoNumeros= new FileInputStream(nombreArchivo);
	int numero , suma=0;
	while((numero=flujoNumeros.read())!=-1) {
		suma = suma + numero;
	}
	flujoNumeros.close();
	return suma;
	
}

/**
 * El métod debe crear un flujo de escritura mediante un objeto de la clase FileWriter,
 * para el archivo que se reciba por parámetro. La clase FileWriter proporciona un método write() que permite escribir caracteres en el flujo de salida.
 * Por lo tanto, se escribiran un ciclo, para pasar por las cadenas del arreglo recibido por parametro. 
 * Dichas cadenas se escribirán carácter por cáracter, en el archivo con ayuda del método write().
 * Al final, cada cadena en el archivo, se escribirá un asterisco.
 * Para terminar, se cierra el flujo de salida.
 * @throws IOException 
 */

public void escribirCadenasAarchivos(String nombreArchivo, String[]arreglo) throws IOException {
	FileWriter fileWriter = new FileWriter(nombreArchivo);
	for(String str : arreglo) {
		for(int i=0; i<str.length();i++) {
			fileWriter.write(str.charAt(i));
		}
		fileWriter.write('*');
	}
	fileWriter.close();
}

/**
 * El  método comienza creando un flujo de salida/escritura asociado con el nombre del archivo.
 * Para obtener este flujo, un objeto PrintWriter será creado a partir de un flujo que permita escribir caracteres Unicode, 
 * este se implementa mediante un objeto de la clase FileWriter, asociado con un objeto de la clase BufferedWriter.
 * El método a definir, tendrá un ciclo para recorrer el arreglo de cadenas, para que, en cada interacion, una cadena sea enviada al archivo mediante el flujo de salida.
 * Para terminar, se cierra el flujo de salida.
 * @throws IOException 
 */

public void escribirCadenasAarchivo(String[]cadenas, String nombreArchivo) throws IOException {
	PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter(nombreArchivo)));
	for(String str : cadenas) {
		if(str!=null ) {
			pw.println(str);
		}
	}
	pw.close();
}


}
