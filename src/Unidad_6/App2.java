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

import javax.swing.JOptionPane;

import Unidad3y4.ProfesorPorHoras;
import Unidad3y4.ProfesorTiempoCompleto;
import Unidad3y4.Fecha;
import Unidad3y4.Persona;
import Unidad3y4.Profesor;

public class App2 {
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
			e.getMessage();
		} catch (ClassNotFoundException | IOException e) {
			System.out.println("No se encontró y no se pudo crear el archivo");
		}

		return profesores;
	}

	public static void main(String[] args) throws NumberFormatException, IOException, ClassNotFoundException {
		ArrayList<Persona> profesores=null;
		int n = 0;
		String menu = "¿Qué desea hacer?" + "\n1.Crear Archivo de Objetos" + "\n2.Leer Archivos de Objetos"
				+ "\n3.Listar Personas" + "\n4.Ingresar Salario y mostrar las personas con salario menor a éste"
				+ "\n5.Ingresar Mes y listar personar que cumplan años en ese mes" + "\n6.Salir";
		while (n != 6) {
			n = Integer.parseInt(JOptionPane.showInputDialog(null, menu, "Menú",
					JOptionPane.PLAIN_MESSAGE));
			switch (n) {
			case 1:
					crearObjetosDesdeArchivo();
				break;
			case 2:
				profesores = leerArchivoBinario();
				break;
			case 3:
				try {
					String listaProfesores="Lista Completa de Profesores"+"\n";
					for (Persona profesor : profesores) {
						listaProfesores+=profesor.toString()+"\n----------------------\n";
					}
					SalidaScroll.imprimeScroll(listaProfesores);
				}catch(NullPointerException e) {
					System.out.println("Aún no se han leído el archivo de Objetos");
				}
				break;
			case 4:
				try {
					String listaMenorSalario="";
					double ingresarSalario= Double.parseDouble(JOptionPane.showInputDialog("Ingrese el Salario"));
					listaMenorSalario="Lista de Profesores con salario menor a "+ingresarSalario+"\n"+"\n";
					for (Persona profesor : profesores) {
						if(profesor !=null && ((Profesor)profesor).getSalario()<ingresarSalario) {
							listaMenorSalario+="Nombre: "+profesor.getNombre()+"\n"+"Teléfono: "+profesor.getTelefono()+"\n---------------------------------------------------\n";
						}
					}
					SalidaScroll.imprimeScroll(listaMenorSalario);
				}catch(NullPointerException e) {
					System.out.println("Aún no se han leído el archivo de Objetos");
				}
				break;
			case 5:
				try {
					String listaCumpleEnMes="";
					int ingresarMes= Integer.parseInt(JOptionPane.showInputDialog("Ingrese el Mes"));
					listaCumpleEnMes="Lista de personas que cumplen en el mes "+ingresarMes+"\n"+"\n";
					for (Persona profesor : profesores) {
						if(profesor !=null && (profesor.getFnacimiento().getMes()==ingresarMes)) {
							listaCumpleEnMes+="Clave: "+((Profesor)profesor).getClave()+"\n"+"Nombre: "+profesor.getNombre()+"\n"+"Curp: "+profesor.getCurp()+"\n---------------------------------------------------\n";
						}
					}
					SalidaScroll.imprimeScroll(listaCumpleEnMes);
				}catch(NullPointerException e) {
					System.out.println("Aún no se han leído el archivo de Objetos");
				}
				break;
			case 6:
				n = 6;
			}
		}
	}
}
