package Unidad_6;

import java.io.DataOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class RutaArchivo {

	public static void main(String[] args) {
		String path = new RutaArchivo().getRutaCarpeta("MisArchivos");
		File archivo = new File(path,"Numeritos.dat");
		FileOutputStream fos = null;
		try{
			fos= new FileOutputStream (archivo);
			DataOutputStream dos = new DataOutputStream(fos);
			for(int valor=10; valor<2000; valor+=15) {
				dos.write(valor);
			}
			dos.close();
		}catch(FileNotFoundException e) {
			System.out.println(e.getMessage());
		}catch(IOException e) {
			System.out.println(e.getMessage());
		}
		System.out.println(path);

	}

	public String getRutaCarpeta(String nombre){
		File directorio = new File(nombre);
		if( !directorio.exists()){
			directorio.mkdir();
		}
		return directorio.getAbsolutePath();
	}
}
