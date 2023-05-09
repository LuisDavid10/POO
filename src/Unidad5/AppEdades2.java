package Unidad5;

import java.util.Scanner;

public class AppEdades2 {

	public static void main(String[] args) {
		Scanner sc = new Scanner (System.in);
		do {
			try {
			System.out.println("Ingrese edad");
			int edad = sc.nextInt();
			if(edad<0 || edad>120) {
				throw new EdadException("Edad fuera de rango");
			}else if (edad==50) {
				throw new Exception("Edad 50 no valida");
			}
			sc.close();
			break;
			}catch(EdadException e) {
				System.out.println(e.getMessage());
				System.out.println("Intentar de nuevo ingresar la edad 0-120");
			}catch(Exception a){
				System.out.println(a.getMessage());
				System.out.println("Intentar de nuevo ingresar la edad 0-120 que no sea 50");
			}
		}while(true);

	}

	}

