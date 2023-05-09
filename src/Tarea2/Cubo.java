package Tarea2;

import java.util.Objects;

public class Cubo extends FiguraGeometrica {
	private double arista;
	
	public Cubo (double arista) {
		this.arista=arista;
		calcularVolumen();
	}

	public double getArista() {
		return arista;
	}

	public void setArista(double arista) {
		this.arista = arista;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + Objects.hash(arista);
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		Cubo other = (Cubo) obj;
		return Double.doubleToLongBits(arista) == Double.doubleToLongBits(other.arista);
	}

	public void calcularVolumen(){
		volumen=arista*arista*arista;
	}

	@Override
    public String toString() {
        return "Arista del cubo: " + arista + super.toString();
    }
}

