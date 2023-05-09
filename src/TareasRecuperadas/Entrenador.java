package TareasRecuperadas;

public class Entrenador extends SeleccionFutbol {
	
private String idFedercion;

public Entrenador(int id, String Nombre, String Apellido, int Edad, String idFedercion) {
	super(id, Nombre, Apellido, Edad);
	this.idFedercion = idFedercion;
}

public String getIdFedercion() {
	return idFedercion;
}

public void setIdFedercion(String idFedercion) {
	this.idFedercion = idFedercion;
}
public void dirigirPartido() {
}
public void dirigirEntrenamiento() {
}
}
