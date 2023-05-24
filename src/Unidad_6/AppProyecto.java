package Unidad_6;

import java.io.BufferedReader;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import Unidad3y4.Fecha;
import Unidad_5.Articulo;

import java.io.BufferedReader;

public class AppProyecto {
	public void crearArchivos() throws NumberFormatException, IOException {
		//Abrir contenido del archivo
	// Abrir archivo de texto para lectura
	BufferedReader br = new BufferedReader ( new FileReader("Profesores.txt"));
	//Procesar contenido del archivo
	while (br.ready()) {
		String linea = br.readLine();
	String[] datos = linea.split(",");
	String curp = datos[0] ;
	String nombre= datos[1];
	long telefono = Long.parseLong(datos[2]);
	
	String[] partesFecha = datos[3].split("-");
	int dia = Integer.parseInt(partesFecha[0]);
	int mes = Integer.parseInt(partesFecha[1]);
	int año = Integer.parseInt(partesFecha[2]);
	
	Fecha fnacimiento = new Fecha(dia,mes,año);
	String clave = datos[4];
	
	
	
		
	
	if(datos.length==3) {
		
		lista.add(new Articulo(clave,precio, datos[2]));
	}else if(datos.length==2) {
		lista.add(new Articulo(clave, precio));
		
	}
}
cont ++;
	}
	}
//cerrar 
br.close();

	}

	public static void main(String[] args) {
		
	}

}
