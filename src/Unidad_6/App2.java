package Unidad_6;

import java.io.BufferedReader;
import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

import javax.swing.JComboBox;
import javax.swing.JOptionPane;

import Unidad3y4.ProfesorPorHoras;
import Unidad3y4.ProfesorTiempoCompleto;
import Unidad3y4.Fecha;
import Unidad3y4.Persona;

public class App2{
	public static void crearObjetosDesdeArchivo() throws NumberFormatException, IOException {
		// Abrir contenido del archivo
		BufferedReader br = new BufferedReader(new FileReader("Profesores.txt"));
		ObjectOutputStream archivoBinarioProfesores = new ObjectOutputStream(new FileOutputStream("Profesores.dat"));
		Object nuevoProfe = null;
		// Separar datos en variables
		while (br.ready()) {
			String linea = br.readLine();
			String[] datos = linea.split(",");
			String curp = datos[0];
			String nombre = datos[1];
			String telefono = datos[2];
			String[] partesFecha = datos[3].split("-");
			int dia = Integer.parseInt(partesFecha[0]);
			int mes = Integer.parseInt(partesFecha[1]);
			int año = Integer.parseInt(partesFecha[2]);
			Fecha fechaNacimiento = new Fecha(dia, mes, año);
			String clave = datos[4];

			if (datos.length == 6) {
				int horas = Integer.parseInt(datos[5]);
				nuevoProfe = new ProfesorPorHoras(curp, nombre, telefono, fechaNacimiento, clave, horas);
			} else if (datos.length == 5) {
				nuevoProfe = new ProfesorTiempoCompleto(curp, nombre, telefono, fechaNacimiento, clave);
			}
			// Guardar objeto en el archivo binario
			archivoBinarioProfesores.writeObject(nuevoProfe);
		}
		archivoBinarioProfesores.close();
		br.close();
	}

	// Crear ArrayList desde archivo
	public static ArrayList<Persona> leerArchivoBinario() {
		ArrayList<Persona> profesores = new ArrayList<>();
		try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("Profesores.dat"))) {
			while (true) {
				Persona profesor = (Persona) ois.readObject();
				profesores.add(profesor);
			}
		} catch (EOFException e) {
		} catch (ClassNotFoundException | IOException e) {
			e.printStackTrace();
		}

		return profesores;
	}
	public static void main(String[] args) throws NumberFormatException, IOException {
		//Ejecutar menu desplagable
		String [] menu ={"Crear archivo", "Leer archivo", "Listar todas las personas", "Listar el nombre y telefono con base a un salario", "listar la clave, el nombre y la curp por su cumpleaños","salir"};
		JComboBox<String> comboBox = new JComboBox<>(menu);
		
//		ArrayList<Persona> profesores = leerArchivoBinario();
//		for(Persona profesor : profesores ) {
//			System.out.println(profesor);
		
		JOptionPane.showMessageDialog(null,comboBox, "Seleccione una opcion", JOptionPane.QUESTION_MESSAGE);
		if (comboBox.getSelectedIndex() == 1){
			//Crear archivo
			//llamar al metodo 1
			crearObjetosDesdeArchivo();
			System.out.println("Profesores.dat");


		}else if (comboBox.getSelectedIndex() == 2){
			//leer archivo
			//llama al metodo2
			//ArrayList<Persona> profesores = leerArchivoBinario();
		}else if(comboBox.getSelectedIndex() == 3){
			//listar a todas las personas
			
			System.out.println("Si seleccionaste bien");
			
			ArrayList<Persona> profesores = leerArchivoBinario();
			for(Persona profesor : profesores ) {
				System.out.println(profesor);
			}
			
		}else if (comboBox.getSelectedIndex() == 4){
			//Listar el nombre y telefono con base a un salario
		}else if (comboBox.getSelectedIndex() == 5){
			//listar la clave, el nombre y la curp por su cumpleaños
		


		}else if (comboBox.getSelectedIndex() == 6) {

				
			}
	
}
}