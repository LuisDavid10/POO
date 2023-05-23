package Unidad_6;

import java.io.*;
import java.util.Arrays;

import javax.swing.JOptionPane;

public class ArchivoDeBajoNivel {

	public void crearArchivoDeBytes(String nombreArchivo) {
		byte[] arregloDeBytes = {10, 20, 30, 40, 50, 60, 70, 80};
		try {
			//apertura del archivo binario para escritura
			File objFile = new File(nombreArchivo);
			FileOutputStream flujoSalida = new FileOutputStream(objFile);
			//proceso del archivo
			flujoSalida.write(arregloDeBytes);
			//cerrar el archivo
			flujoSalida.close();
		}catch(FileNotFoundException e){
			System.out.println("No se pudo crear el archivo");
		}catch(IOException e ) {
			System.out.println("No se pudo escribir el archivo");
		}
		
		
	}
	public void leerArchivoDeBytes(String nombreArchivo) {
		try {
			File objFile = new File(nombreArchivo);
			FileInputStream flujoEntrada = new FileInputStream ( objFile);
			//procesar archivo -read-
			int cantBytes = (int)objFile.length();
			
			byte[]arregloDeBytes = new byte[cantBytes];
			
			flujoEntrada.read(arregloDeBytes);
			System.out.println(Arrays.toString(arregloDeBytes));
			
		}catch(FileNotFoundException e ) {
			System.out.println("No se pudo escribir el archivo");
		}catch(IOException e) {
			System.out.println("No se pudo escribir el archivo");
		}
	}
	
	public boolean esValido (String nombreArchivo) {
		if (nombreArchivo.contains(".dat")){
			if (nombreArchivo.endsWith(".dat")) {
				return true;
				//no deve empezar con numero
			}
		}
		return false;
	}
	
	public static void main(String[] args) {
		ArchivoDeBajoNivel obj = new ArchivoDeBajoNivel();
		String nombreArchivo = "";
		do {
			nombreArchivo = JOptionPane.showInputDialog("Nombre del archivo con extencion?");
		}while(!obj.esValido(nombreArchivo));
		obj.crearArchivoDeBytes(nombreArchivo);
		obj.leerArchivoDeBytes(nombreArchivo);
		
		System.out.println(nombreArchivo);
	}
	

}
