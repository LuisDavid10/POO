package Unidad5;

	import java.util.Random;
	import javax.swing.JOptionPane;


	//
	//Problema 1 - Adivina el número
	//Escribe un programa que, utilizando excepciones, juegue con el usuario para adivinar un
	//número. El programa debe generar un número aleatorio entre 1 y 100 y el usuario debe
	//intentar adivinarlo. Para ello, cada vez que el usuario ingresa un valor, la computadora debe
	//decirle al usuario si el número que tiene que adivinar es mayor o menor que el número que
	//ingresó. Cuando el usuario adivina el número, el programa debe indicarlo e imprimir en la
	//pantalla el número de veces que el usuario ha intentado adivinar el número. Si el usuario
	//ingresa algo que no es un número, debe mostrar un mensaje al usuario, contarlo como un
	//intento y permitir que el usuario continúe jugando.

	class FueraDeRango extends Exception {
	    public FueraDeRango(String mensaje) {
	        super(mensaje);
	    }
	}
	class NumerosDecimales extends Exception {
	    public NumerosDecimales(String mensaje) {
	        super(mensaje);
	    }
	}


	public class AdivinaNumero {

		public static void main(String[] args)  {

			boolean quiereJugar = true;
			int intentos = 0;

			do {
				int respuesta = JOptionPane.showConfirmDialog(null, "¿Quieres jugar a adivinar el número???");

				if (respuesta == JOptionPane.YES_OPTION) {
					JOptionPane.showMessageDialog(null, "¡Bienvenido al juego!");
					// Aquí pondrías el código del juego
					// pensar en un numero aleatorio
					Random ran = new Random();
					int num = ran.nextInt(100) + 1;
					System.out.println(num);
					do {
						try {
							String entrada = JOptionPane.showInputDialog("Dame un numero del 1 al 100");
							// preguntar si aplano cancelar o la tacha
							if(entrada == null) {
								JOptionPane.showMessageDialog(null, "Gracias por jugar. Hasta pronto.");
								System.exit(0);
							}
							int adivino = Integer.parseInt(entrada);
							intentos++;

							if (num == adivino) {
								String felicidades = "Felicidades has logrado adivinar el numero en el intento:" + intentos;
								JOptionPane.showMessageDialog(null, felicidades);
								break;
								
							}else if (num <1 || num >100) {
								throw new FueraDeRango("Esta fuera de rango ");
							} else if (num > adivino ) {
								String abajo = "Estas abajo ";
								JOptionPane.showMessageDialog(null, abajo);
							} else if (num < adivino ) {
								String arriba = "Estas arriba";
								JOptionPane.showMessageDialog(null, arriba);
								
							}else if (num !=(int)adivino) {
								throw new NumerosDecimales("El numero ingresado tiene decimales");
							
							}
							// esta fuera de rango
						} catch (FueraDeRango a) {
							JOptionPane.showMessageDialog(null, "Exception");
							JOptionPane.showMessageDialog(null, "Mensaje de la excepcion: " + a.getMessage());
							JOptionPane.showMessageDialog(null, "Intenta ingresar un numeros positivos entre el 0 y el 100");

						}catch(NumerosDecimales e) {
							JOptionPane.showMessageDialog(null, "Exception");
							JOptionPane.showMessageDialog(null, "Mensaje de la excepcion: " + e.getMessage());
							JOptionPane.showMessageDialog(null, "Intenta ingresar un numeros enteros entre el 0 y el 100");

						}catch(NumberFormatException i) {
							JOptionPane.showMessageDialog(null, "Exception");
							JOptionPane.showMessageDialog(null, "Mensaje de la excepcion: " + i.getMessage());
							JOptionPane.showMessageDialog(null, "Intenta ingresar un numero entre el 1 y el 100");

						}
					} while (true);
				} else {
					JOptionPane.showMessageDialog(null, "¡Hasta luego!");
					quiereJugar = false; // Termina el bucle
				}
			} while (quiereJugar);
		}


	}

	// solicitar ingresar un número

	// comparar el numero que tiene con el numero ingresado
	// Excepcion fuera de rango esta es <0 o >100

	//letras
	//numeros fuera de rango
	//decimales
	//numero de intentos 

