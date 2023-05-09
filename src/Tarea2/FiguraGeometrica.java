package Tarea2;

import java.util.Objects;

public abstract class FiguraGeometrica {
	protected double volumen;
	public FiguraGeometrica(double volumen) {
		super();
		this.volumen=volumen;
		calcularVolumen();
	}
	public FiguraGeometrica() {
		super();
		calcularVolumen();
	}
	
    public double getVolumen() {
		return volumen;
	}

	public void setVolumen(double volumen) {
		this.volumen = volumen;
	}
	

	@Override
	public int hashCode() {
		return Objects.hash(volumen);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		FiguraGeometrica other = (FiguraGeometrica) obj;
		return Double.doubleToLongBits(volumen) == Double.doubleToLongBits(other.volumen);
	}

	protected abstract void calcularVolumen();
	
    public String toString() {
    	return "\nEl volumen es: "+volumen;
    }
}