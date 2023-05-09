package Unidad3y4;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class AppGPT {
	public static void main(String[] args) {

		int n = Integer.parseInt(JOptionPane.showInputDialog(null, "Cantidad de profesores por registrar: "));

		Persona[] profesores = new Persona[n];
		int seguir = JOptionPane.showConfirmDialog(null, "Desea registrar un profesor? ");
		int i = 0;

		while (seguir == 0 && i < n) {

			JLabel lblTituloProfesores = new JLabel("----Datos del profesor----\n");
			JLabel lblCurp = new JLabel("CURP");
			JTextField txtCurp = new JTextField();
			JLabel lblNombre = new JLabel("Nombre");
			JTextField txtNombre = new JTextField();
			JLabel lblTelefono = new JLabel("Telefono");
			JTextField txtTelefono = new JTextField();
			JLabel lblClave = new JLabel("Clave");
			JTextField txtClave = new JTextField();
			JLabel lblTituloFechaNac = new JLabel("----Fecha de nacimiento del profesor----\n");
			JLabel lblDiaNac = new JLabel("Dia (nn)");
			JTextField txtDiaNac = new JTextField();
			JLabel lblMesNac = new JLabel("Mes (nn)");
			JTextField txtMesNac = new JTextField();
			JLabel lblAnioNac = new JLabel("Año (nnnn)");
			JTextField txtAnioNac = new JTextField();

			Object[] entrada = { lblTituloProfesores, lblCurp, txtCurp, lblNombre, txtNombre, lblTelefono, txtTelefono,
					lblClave, txtClave, lblTituloFechaNac, lblDiaNac, txtDiaNac, lblMesNac, txtMesNac, lblAnioNac,
					txtAnioNac };

			JOptionPane.showMessageDialog(null, entrada);

			String curp = txtCurp.getText();
			String nombre = txtNombre.getText();
			long telefono = Long.parseLong(txtTelefono.getText());
			String clave = txtClave.getText();

			int dia = Integer.parseInt(txtDiaNac.getText());
			int mes = Integer.parseInt(txtMesNac.getText());
			int año = Integer.parseInt(txtAnioNac.getText());

			Object[] opcionesProfesor = { "Profesor de tiempo completo", "Profesor por horas" };

			String tipo = (String) JOptionPane.showInputDialog(null, "Seleccione una opción", "Tipo de profesor",
					JOptionPane.PLAIN_MESSAGE, null, opcionesProfesor, opcionesProfesor[0]);

			switch (tipo) {
			case "Profesor de tiempo completo":
				profesores[i] = new ProfesorTiempoCompleto(curp, nombre, telefono, new Fecha(dia, mes, año), clave);
				//(curp, nombre, telefono, new Fecha(dia, mes, año),clave);
				break;
			case "Profesor por horas":
				int horas = Integer.parseInt(JOptionPane.showInputDialog(null, "Horas trabajadas: "));
				profesores[i] = new ProfesorPorHoras(curp, nombre, telefono, new Fecha(dia, mes, año), clave, horas);
						//(curp, nombre, telefono, new Fecha(dia, mes, año), clave,horas);
				break;
			}

			((Profesor) profesores[i]).calcularSalario();

			seguir = JOptionPane.showConfirmDialog(null, "Desea registrar otro profesor? ");
			i++;
		}

		String salida = "     Lista de personas: ";

		for (Persona unProfesor : profesores) {
			if (unProfesor != null) {
				salida += (unProfesor.toString() + "\n");
			}
		}
		salida += "\n\nProfesores que ganan mas de 2000 pesos: ";

		for (Persona unProfesor : profesores) {
			if (unProfesor != null) {
				if (((Profesor) unProfesor).getSalario() >= 2000) {
					salida += ("\n- " + unProfesor.getNombre() + "  " + ((Profesor) unProfesor).getClave());
				}
			}
		}

		salida += ("\n\nProfesores que cumplen años en abril: ");

		for (Persona unaPersona : profesores) {
			if (unaPersona != null) {
				if (unaPersona.getFnacimiento().getMes() == 4) {
					salida += ("\n- " + unaPersona.getNombre() + "  " + ((Profesor) unaPersona).getClave());
				}
			}
		}

		JOptionPane.showMessageDialog(null, salida);

	}

}
