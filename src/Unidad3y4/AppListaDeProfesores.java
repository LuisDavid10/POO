package Unidad3y4;

import javax.swing.JOptionPane;
import javax.swing.JComboBox;

//pida al usuario la cantidad de profesores a procesar, 
//entonces cree una lista de objetos Persona, 
//posteriormente capture los datos para los objetos ProfesorTiempoCompleto o ProfesorPorHoras,
//según indique el usuario. Crear un objeto de la clase correspondiente e
//insertarlo en el arreglo hasta que éste se llene o el usuario no desee capturar más objetos. 

//pida al usuario la cantidad de profesores a procesar, entonces cree una lista de objetos Persona,
//posteriormente capture los datos para los objetos ProfesorTiempoCompleto o ProfesorPorHoras, según indique el usuario.
//Crear un objeto de la clase correspondiente e insertarlo en el arreglo hasta que éste se llene o el usuario no desee capturar más objetos. 
public class AppListaDeProfesores {

	public static void main(String[] args) {
		// Poblar un arreglo
		int cant = Integer.parseInt(JOptionPane.showInputDialog("Cuantos profesores quieres procesar???"));
		Persona[] lista = new Persona[cant];

		int seguir = 0;
		for (int i = 0; seguir == 0 && i < lista.length; i++) {

			String nombre = JOptionPane.showInputDialog("Dame el nombre del Profesor");
			String curp = JOptionPane.showInputDialog("Curp de " + nombre);
			String telefono = JOptionPane.showInputDialog("Telefono de " + nombre);

			int dia = Integer.parseInt(JOptionPane.showInputDialog("Día de nacimiento de " + nombre));
			int mes = Integer.parseInt(JOptionPane.showInputDialog("Mes de nacimiento de " + nombre));
			int año = Integer.parseInt(JOptionPane.showInputDialog("Año de nacimiento de " + nombre));

			String clave = JOptionPane.showInputDialog("Ingrese la clave del profesor: " + nombre);

			// Capturar datos para un Profesor
			String[] opciones = { "Profesor de tiempo completo", "Profesor por horas " };
			JComboBox<String> comboBox = new JComboBox<>(opciones);

			JOptionPane.showMessageDialog(null, comboBox, "¿Cómo trabaja el profesor?", JOptionPane.QUESTION_MESSAGE);

			if (comboBox.getSelectedIndex() == 0) {
				// Capturar datos para un ProfesorTiempoCompleto
				
				
				//ProfesorTiempoCompleto profeTiempo 
				lista[i]= new ProfesorTiempoCompleto(curp, nombre, telefono,new Fecha(dia, mes, año), clave);
				//lista[i] = profeTiempo;

			} else if (comboBox.getSelectedIndex() == 1) {
				// Capturar datos para un ProfesorPorHoras
				
				int horas = Integer.parseInt(JOptionPane.showInputDialog("Ingrese las horas que trabajó " + nombre));
				ProfesorPorHoras profeHoras = new ProfesorPorHoras(curp, nombre, telefono, new Fecha(dia, mes, año),clave,horas);
				lista[i] = profeHoras;

				// Crear y agregar objeto ProfesorPorHoras al arreglo de Personas
			}

		((Profesor) lista[i]).calcularSalario();
		 

			seguir = JOptionPane.showConfirmDialog(null, "Capturar otro profesor???");
		}
		// Listar las Personas
		String salida = "Listado de las personas \n";
		for (Persona persona : lista) {
			if (persona != null) {
				salida = salida + persona.toString() + "\n======================================\n";
			}
		}
		JOptionPane.showMessageDialog(null, salida);
		// una lista con la clave y el nombre de cada profesor que tenga un salario
		// mayor a 2000 pesos.

		String respuesta = "Profesores con un salario mayor a 2K pesos \n";
		// falta el poder convertir la lista de Persona a Profesor

		for (Persona unProfe : lista) {
			if (unProfe != null) {
				if (((Profesor) unProfe).getSalario() >= 2000) {
					respuesta += unProfe.getNombre() + "\n======================================\n";
				}
			}
		}
		JOptionPane.showMessageDialog(null, respuesta);
		// una lista de los profesores que cumplan años en el mes de abril.
		String resultado = "Los profesores que cumplen años en el mes de abril son: \n";
		for (Persona unProfe : lista) {
			if (unProfe != null) {
				if (((Profesor) unProfe).getFnacimiento().getMes() == 4) {
					resultado += unProfe.getNombre() + "\n======================================\n";
				}
			}
		}
		JOptionPane.showMessageDialog(null, resultado);
	}
}