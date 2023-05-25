package Unidad_6;

import java.io.BufferedReader;


import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import Unidad3y4.Fecha;
import Unidad3y4.ProfesorPorHoras;
import Unidad3y4.ProfesorTiempoCompleto;

/*//
 * Crear una aplicación en java que tenga:

-	Un método que lea el archivo de texto Profesores.txt separe cada dato en una variable del tipo adecuado para poder crear un objeto ProfesorTiempoCompleto 
o ProfesorPorHoras, según la cantidad de datos en la línea leída del archivo, cree el objeto y guárdelo en un archivo binario de objetos.

-	Un método que lea el archivo binario de objetos y los coloque en un ArrayList de referencias a Persona y regrese el ArrayList<Persona>

-	Un método principal que presente un menú con las opciones:

o	Crear archivo de objetos (llamar al primer método)

o	Leer archivo de objetos (llamar al segundo método)

o	Listar todas las personas

o	Listar el nombre y el teléfono de las personas con un salario menor al indicado por el usuario (ejemplo: 4,200.00)

o	Listar la clave, el nombre y la CURP de las personas que cumplan años en el mes indicado por el usuario (ejemplo: 12).

o	Salir


 */

public class AppProyecto {
	public void crearArchivos() throws NumberFormatException, IOException {
		//Abrir contenido del archivo
		ObjectoOutputStream archivoBinarioProfesores = new ObjectOutputStream(new FileOutputStream("Profesores.txt"));
	// Abrir archivo de texto para lectura
	BufferedReader br = new BufferedReader ( new FileReader("Profesores.txt"));
	//Procesar contenido del archivo
	while (br.ready()) {
	String linea = br.readLine();
	String[] datos = linea.split(",");
	String curp = datos[0] ;
	String nombre= datos[1];
	String telefono = datos[2];
	
	String[] partesFecha = datos[3].split("-");
	int dia = Integer.parseInt(partesFecha[0]);
	int mes = Integer.parseInt(partesFecha[1]);
	int año = Integer.parseInt(partesFecha[2]);
	Fecha fnacimiento = new Fecha(dia,mes,año);
	
	String clave = datos[4];
	int horas = Integer.parseInt(datos[5]);

if (datos.length==4){
	//Se agrega en Profesor Tiempo Ccompleto
	ProfesorTiempoCompleto objTiempoCompleto = new ProfesorTiempoCompleto(curp, nombre, telefono, fnacimiento, clave);


}else if(datos.length==5){
	//Se agrega en Profesor Por Horas
	ProfesorPorHoras objProfesorPorHoras=new ProfesorPorHoras(curp, nombre, telefono, fnacimiento, clave, horas);
}

	
	ArchivoDeBajoNivel obj = new ArchivoDeBajoNivel();
	String nombreArchivo = "";
	do {
		nombreArchivo = "Profesores";
	}while(!obj.esValido(nombreArchivo));
	obj.crearArchivoDeBytes(nombreArchivo);
	obj.leerArchivoDeBytes(nombreArchivo);
	
	System.out.println(nombreArchivo);

//cerrar
	br.close();

	}
	}


	public static void main(String[] args) {
		
	}

}
