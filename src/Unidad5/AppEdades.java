package Unidad5;

import java.util.Scanner;

public class AppEdades {

	public static void main(String[] args) throws EdadException {
		Scanner sc = new Scanner (System.in);
		do {
			System.out.println("Ingrese edad");
            int edad = sc.nextInt();
            if (edad < 0 || edad > 120) {
                throw new EdadException("Edad fuera de rango");
            }
        } while (true);
		
    }

}
