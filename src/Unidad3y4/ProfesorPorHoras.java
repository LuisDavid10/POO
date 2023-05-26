package Unidad3y4;
//Es una subclase de Profesor que tiene el atributo horas,

import java.io.Serializable;

//cuyo salario se calcula multiplicando las primeras 40 horas trabajadas por 100 pesos
//y las horas excedentes se multiplican por 135 pesos.

import java.util.Objects;

public class ProfesorPorHoras extends Profesor implements Serializable {

	private double horas;

	public ProfesorPorHoras(String curp, String nombre, String telefono, Fecha fechaNacimiento, String clave,int horas) {
		super(curp, nombre, telefono, fechaNacimiento, clave);
		this.horas = horas;
		calcularSalario();
		
	}

	public double getHoras() {
		return horas;
	}

	public void setHoras(double horas) {
		this.horas = horas;
	}

	

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + Objects.hash(horas);
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
		ProfesorPorHoras other = (ProfesorPorHoras) obj;
		return Double.doubleToLongBits(horas) == Double.doubleToLongBits(other.horas);
	}

	@Override
	public void calcularSalario() {
		double pesos = 100;
		if (horas <= 40) {
			salario = horas * pesos;
		} else {
			double pesosextra = 135;
			double horasextras = horas - 40;
			salario = horasextras * pesosextra + 4000;
		}
	}

	@Override
	public String toString() {
		return super.toString()+"El salario es: "+ getSalario();

	}

}

