package Unidad3y4;
//Clase Profesor


//Es una subclase de Persona que tiene una clave y un salario,
//además de un método abstracto calcularSalario que no recibe parámetros.

import java.util.Objects;

public abstract class Profesor extends Persona {
	protected String clave;
	protected Double salario;

	public Profesor(String curp, String nombre, String telefono, Fecha fnacimiento, String clave) {
		super(curp, nombre, telefono, fnacimiento);
		this.clave = clave;
		calcularSalario();
	}

	public String getClave() {
		return clave;
	}

	public void setClave(String clave) {
		this.clave = clave;
	}

	public Double getSalario() {
		return salario;
	}

	public void setSalario(Double salario) {
		this.salario = salario;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + Objects.hash(clave, salario);
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
		Profesor other = (Profesor) obj;
		return Objects.equals(clave, other.clave) && Objects.equals(salario, other.salario);
	}

	public abstract void calcularSalario();

	public String toString() {
		return super.toString() + "Clave: " + clave + "\nSalario: " + salario + "\n";
	}
}
