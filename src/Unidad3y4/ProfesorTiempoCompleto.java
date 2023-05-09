package Unidad3y4;
//Es una subclase de Profesor cuyo salario se calcula multiplicando 40 horas por una tarifa de 100 pesos la hora.

import java.util.Objects;

public class ProfesorTiempoCompleto extends Profesor {
	
	private double horas;
	private double pesos;
	
	
	public ProfesorTiempoCompleto(String curp, String nombre, long telefono, Fecha fnacimiento, String clave) {
	    super(curp, nombre, telefono, fnacimiento, clave);
	    
	    calcularSalario();
	}

	public double getHoras() {
		return horas;
	}

	public void setHoras(double horas) {
		this.horas = horas;
	}

	public double getPesos() {
		return pesos;
	}

	public void setPesos(double pesos) {
		this.pesos = pesos;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + Objects.hash(horas, pesos);
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
		ProfesorTiempoCompleto other = (ProfesorTiempoCompleto) obj;
		return Double.doubleToLongBits(horas) == Double.doubleToLongBits(other.horas)
				&& Double.doubleToLongBits(pesos) == Double.doubleToLongBits(other.pesos);
	}

	@Override
	public void calcularSalario() {
		horas=40;
		pesos=100;
		salario = horas*pesos;
	}

public String toString() {
	return super.toString()+"El salario es: "+ getSalario();
}
}

//L22050369@saltillo.tecnm.mx
//BaseSistema1.