package U5_Excepciones;


import java.util.Arrays;

/**
 * 
 * @author luis
 *Escriba una aplicación en java, que genere números aleatorios en el rango de 1 a 100,
*inclusive, hasta obtener primero un arreglo de cinco números terminados en 4 y después,
*un arreglo de cinco números terminados en 8.
 */

import java.util.Random;

public class Arreglos4y8 {

	public static void main(String[] args) {
		int[] arr4 = new int[5];
		int[] arr8 = new int[5];
		int[] arr = arr4;
		int indice = 0;
		Random ran = new Random();
		int num;

		while (true) {
			num = ran.nextInt(100) + 1;
			try {
				if (arr == arr4 && num % 10 == 4) {
					arr[indice] = num;
					indice++;
				}
			} catch (ArrayIndexOutOfBoundsException e) {
				System.out.println("Fuera de .length");
				System.out.println(Arrays.toString(arr4));
				if (arr == arr4) {
					arr = arr8;
					indice = 0;

				} else {
					System.out.println("arregloCompleto");
					break;
				}

			}
			try {

				if (arr == arr8 && num % 10 == 8) {
					arr[indice] = num;
					indice++;
				}
			} catch (ArrayIndexOutOfBoundsException a) {
				System.out.println("Se lleno el 8");
				System.out.println(Arrays.toString(arr8));
				break;
			}
		}
		System.out.println("arr4" + Arrays.toString(arr4));
		System.out.println("arr8" + Arrays.toString(arr8));

	}

}
