package Unidad5;

import java.util.Random;

public class NumerosAleatorios {
	public static void main (String[] args) {
		Random ran = new Random();
		int[] numeros = new int[10];
		for(int cont=1; cont<=10; cont++) {
			numeros[cont-1] = ran.nextInt(100)+1;
			System.out.println(numeros[cont-1]);
		}
	}
}
