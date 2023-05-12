package Unidad5;

import java.util.Arrays;

import javax.swing.JOptionPane;

public class EjemploReferencias {
	public static void main(String[] args) {
		int tam=Integer.parseInt(JOptionPane.showInputDialog("Tamaño del primer arreglo\"arr1\""));
		
		char[] arr1 = new char[tam];
		tam=Integer.parseInt(JOptionPane.showInputDialog("Tamaño del segundo arreglo\"arr2\""));
		char[]arr2 = new char[tam];
		
		char[]arr = arr1;
		
		char caracter = 'A';
		
		for(int ind=0;ind<arr.length; ind++) {
			arr[ind]= caracter++;
		}

		
		arr = arr2;
		caracter = 'a';
		for(int ind=0;ind<arr.length;ind++) {
			arr[ind]=caracter++;
		}
		System.out.println("\nContenido de arr1\n" + Arrays.toString(arr1));
		System.out.println("\nContenido de arr2\n" + Arrays.toString(arr2));
	}

}

