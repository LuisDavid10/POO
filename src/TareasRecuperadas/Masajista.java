package TareasRecuperadas;

public class Masajista extends SeleccionFutbol {

	private String Titulacion;
	private int aniosExperiencia;
	public Masajista(int id, String Nombre, String Apellido, int Edad, String Titulacion, int aniosExperiencia) {
		super(id, Nombre, Apellido, Edad);
		this.Titulacion=Titulacion;
		this.aniosExperiencia=aniosExperiencia;
	}
	
	public String getTitulacion() {
		return Titulacion;
	}

	public void setTitulacion(String titulacion) {
		Titulacion = titulacion;
	}

	public int getAniosExperiencia() {
		return aniosExperiencia;
	}

	public void setAniosExperiencia(int aniosExperiencia) {
		this.aniosExperiencia = aniosExperiencia;
	}

	public void darMasaje() {
	}
	}


