package Tarea2;

public class Paralelepipedo extends FiguraGeometrica {
	private double a;
	private double b;
	private double c;
	public Paralelepipedo(double a, double b, double c) {
		this.a = a;
		this.b = b;
		this.c = c;
		calcularVolumen();
	}
	

	public double getA() {
		return a;
	}


	public void setA(double a) {
		this.a = a;
	}


	public double getB() {
		return b;
	}


	public void setB(double b) {
		this.b = b;
	}


	public double getC() {
		return c;
	}


	public void setC(double c) {
		this.c = c;
	}


	@Override
	public void calcularVolumen() {
		volumen= a*b*c;
	}

	@Override
	public String toString() {
		return "Lado a: "+a+"\nLado b: "+ b+ "\nLado c: "+ c + super.toString()  ;
	}

}
