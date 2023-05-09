package Tarea2;

public class Cilindro extends FiguraGeometrica {
	private double r;
	private double h;
	
	public Cilindro (double r, double h) {
		this.r=r;
		this.h=h;
		calcularVolumen();
	}

	public double getR() {
		return r;
	}

	public void setR(double r) {
		this.r = r;
	}

	public double getH() {
		return h;
	}

	public void setH(double h) {
		this.h = h;
	}

	@Override
	public void calcularVolumen() {
		double pi = 3.1416;
		volumen = pi*r*r*h;
	}

	@Override
	public String toString() {
		return "El r del cilindro: "+r+"\nLa altura del cilindro es: "+ h +super.toString();
	}

}
