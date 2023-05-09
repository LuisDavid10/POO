package Tarea2;

import javax.swing.JComboBox;
import javax.swing.JOptionPane;

public class AppVolFiguras {

	public static void main(String[] args) {
		int cant = Integer.parseInt(JOptionPane.showInputDialog("Cuantos cuerpos geometricos tienes???"));
		FiguraGeometrica[] volumen = new FiguraGeometrica[cant];

		int seguir = 0;
		for (int i = 0; seguir == 0 && i < volumen.length; i++) {
			// Capturar datos para un Profesor
			String[] opciones = { "Cubo", "Paralelepípedo", "Cilindro", "Esfera", "Salir" };
			JComboBox<String> comboBox = new JComboBox<>(opciones);

			JOptionPane.showMessageDialog(null, comboBox, "Que volumen quieres calcular???",
					JOptionPane.QUESTION_MESSAGE);

			if (comboBox.getSelectedIndex() == 0) {
				// Capturar datos para un ProfesorTiempoCompleto
				double arista = Double.parseDouble(JOptionPane.showInputDialog("Cual es el arista de su cubo???"));
				Cubo cubo = new Cubo(arista);
				Cubo[] cube = new Cubo[1];
				cube[0] = cubo;
				volumen[i] = cubo;

				String salida = "Acabas de calcular: \n";
				for (FiguraGeometrica vol : cube) {
					if (vol != null) {
						salida = salida + vol.toString() + "\n======================================\n";
					}
				}
				JOptionPane.showMessageDialog(null, salida);
				seguir = JOptionPane.showConfirmDialog(null, "Calcular otro volumen???");

			} else if (comboBox.getSelectedIndex() == 1) {
				// Capturar datos para un ProfesorPorHoras
				double a = Double.parseDouble(JOptionPane.showInputDialog("Ingrese el lado a"));
				double b = Double.parseDouble(JOptionPane.showInputDialog("Ingrese el lado b"));
				double c = Double.parseDouble(JOptionPane.showInputDialog("Ingrese el lado c"));
				Paralelepipedo paralelepipedo = new Paralelepipedo(a, b, c);

				volumen[i] = paralelepipedo;

				String salida = "Acabas de calcular: \n" + paralelepipedo.toString()
						+ "\n======================================\n";
				JOptionPane.showMessageDialog(null, salida);
				seguir = JOptionPane.showConfirmDialog(null, "Calcular otro volumen???");

			} else if (comboBox.getSelectedIndex() == 2) {
				double r = Double.parseDouble(JOptionPane.showInputDialog("Ingrese el radio de su cilindro"));
				double h = Double.parseDouble(JOptionPane.showInputDialog("Ingrese la altura de su cilindro"));

				Cilindro cilindro = new Cilindro(r, h);
				volumen[i] = cilindro;

				String salida = "Acabas de calcular: \n"+ cilindro.toString();
				JOptionPane.showMessageDialog(null, salida);
				seguir = JOptionPane.showConfirmDialog(null, "Calcular otro volumen???");

			} else if (comboBox.getSelectedIndex() == 3) {
				double r = Double.parseDouble(JOptionPane.showInputDialog("Ingrese el radio de su esfera"));
				Esfera esfera = new Esfera(r);
				volumen[i] = esfera;

				String salida = "Acabas de calcular: \n"+esfera.toString()+"\n======================================\n";
				
				JOptionPane.showMessageDialog(null, salida);
				seguir = JOptionPane.showConfirmDialog(null, "Calcular otro volumen???");

			} else if (comboBox.getSelectedIndex() == 4) {

				seguir = 1;
				i = volumen.length + 1;

			}

			// seguir = JOptionPane.showConfirmDialog(null, "Calcular otro volumen???");
		}

		if (seguir != 0) {
			// Listar las Personas
			String salida = "Acabas de calcular: \n";
			for (FiguraGeometrica vol : volumen) {
				if (vol != null) {
					salida = salida + vol.toString() + "\n======================================\n";
				}
			}
			JOptionPane.showMessageDialog(null, salida);
		}
	}
}