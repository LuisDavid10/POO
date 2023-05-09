package Tarea2;


public class Esfera extends FiguraGeometrica {
	private double r;
	public Esfera(double r) {
		this.r=r;
		calcularVolumen();
		
	}

	public double getR() {
		return r;
	}

	public void setR(double r) {
		this.r = r;
	}

	@Override
	public void calcularVolumen() {
		double pi =3.1416;
		volumen=(4.0/3.0) *(pi*r*r*r);
	}

	@Override
	public String toString() {
		return "El r es: "+ r+ super.toString() ;
	}

}
