package TareasRecuperadas;

public class SeleccionFutbol {
	protected int id;
	protected String Nombre;
	protected String Apellidos;
	protected int Edad;

	public SeleccionFutbol(int id, String Nombre, String Apellido, int Edad) {
		this.id = id;
		this.Nombre = Nombre;
		this.Apellidos = Apellido;
		this.Edad = Edad;

	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNombre() {
		return Nombre;
	}

	public void setNombre(String nombre) {
		Nombre = nombre;
	}

	public String getApellidos() {
		return Apellidos;
	}

	public void setApellidos(String apellidos) {
		Apellidos = apellidos;
	}

	public int getEdad() {
		return Edad;
	}

	public void setEdad(int edad) {
		Edad = edad;
	}

	public void Concentrarse() {
	    System.out.println("El entrenador " + this.getNombre() + " " + this.getApellidos() + " está concentrando al equipo.");
	}

	public void Viajar() {
	    System.out.println("El masajista " + this.getNombre() + " " + this.getApellidos() + " está viajando con el equipo.");
	}

}
