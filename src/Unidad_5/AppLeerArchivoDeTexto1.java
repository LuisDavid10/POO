package Unidad_5;

import java.io.BufferedReader;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.JOptionPane;

public class AppLeerArchivoDeTexto1 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		ArrayList<Articulo> lista = new ArrayList<>();
		// Abrir archivo de texto para lectura
		BufferedReader br = new BufferedReader ( new FileReader("ArchivoTExto1.txt"));
		//Procesar contenido del archivo
		int cont=0;
		while (br.ready()) {
			String linea = br.readLine();
			if (cont ==0) {
				String[] titulos = linea.split(",");//va a estar separando por la coma.   csv archivos de textos separados por comas 
			}else {
				String[] datos = linea.split(",");
				int clave = Integer.parseInt(datos[0]);
				double precio = Double.parseDouble(datos[1]);
				if(datos.length==3) {
					
					lista.add(new Articulo(clave,precio, datos[2]));
				}else if(datos.length==2) {
					lista.add(new Articulo(clave, precio));
					
				}
			}
			cont ++;
		}
		//cerrar 
		br.close();
		
		JOptionPane.showMessageDialog(null, lista);
		
		String salida = "";
		for(Articulo elemento :lista) {
			salida+= elemento.toString();
		}
		JOptionPane.showMessageDialog(null, salida);

	}

}
