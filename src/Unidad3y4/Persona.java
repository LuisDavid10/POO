package Unidad3y4;

import java.io.Serializable;
import java.util.Objects;

public class Persona implements Serializable {
	protected String curp;
	protected String nombre;
	protected String telefono;
	protected Fecha fnacimiento;

	public Persona(String curp, String nombre, String telefono, Fecha fnacimiento) {
		super();
		this.curp = curp;
		this.nombre = nombre;
		this.telefono = telefono;
		this.fnacimiento = fnacimiento;
	}

	public String getCurp() {
		return curp;
	}

	public void setCurp(String curp) {
		this.curp = curp;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public Fecha getFnacimiento() {
		return fnacimiento;
	}

	public void setFnacimiento(Fecha fnacimiento) {
		this.fnacimiento = fnacimiento;
	}

	@Override
	public int hashCode() {
		return Objects.hash(curp, fnacimiento, nombre, telefono);
	}

	@Override
	public String toString() {
		return "Nombre: " + nombre + "\nCURP: " + curp + "\nTelefono: " + telefono + "\nFecha de nacimiento: "
				+ fnacimiento + "\n";
	}
}
