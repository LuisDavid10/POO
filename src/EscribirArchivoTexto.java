import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Random;

public class EscribirArchivoTexto {

	public static void main(String[] args) {
		Random objRandom = new Random();
		try {

			// Abrir un archivo de texto para escritura, si no existe lo crea
			File file = new File("NumerosAleatoriosCP2.txt");
			FileWriter fwriter = new FileWriter(file);
			PrintWriter pWriter = new PrintWriter(fwriter);
			
			//escribir el archivo
			for(int cont=1; cont<=5;cont++) {
				pWriter.println(objRandom.nextInt(100));
			}
//			pWriter.println(25);
			
			//cerrar el archivo
			pWriter.close();
			fwriter.close();
			System.out.println(file.getAbsolutePath());

			
		} catch (IOException e) {
			System.out.println("No se pudo abrir el archivo");
		}
	}

}
