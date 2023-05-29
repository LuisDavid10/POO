package Unidad_6;

import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;


public class SalidaScroll {

	public static void imprimeScroll(String cadena) {
		JTextArea area = new JTextArea(cadena, 30,30);
		JScrollPane panel = new JScrollPane(area, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		
		JOptionPane.showMessageDialog(null, panel);

	}

}
