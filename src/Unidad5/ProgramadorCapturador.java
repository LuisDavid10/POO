package Unidad5;

public class ProgramadorCapturador {

	public static void main(String[] args) {
		ProgramadorCapturador obj = new ProgramadorCapturador();
		System.out.println("main llama al métodoA");
		obj.metodoA();
	}
	//método capturador - tiene un bloque try/catch
	public void metodoA() {
		try {
			metodoB();
		}catch(Exception e) {
			System.out.println("metodoA capturo la exception");
			System.out.println("Mensaje de la excepcion: "+ e.getMessage());
		}
	}
	//método programador
	public void metodoB() throws Exception{
		throw new Exception("metodoB lanzó la excepción");
	}

}
//lanzar, capturar y propagar
