package TareasRecuperadas;

public class Futbolista extends SeleccionFutbol {
	
	private int dorsal;
	private String demarcacion;
	public Futbolista(int id, String Nombre, String Apellido, int Edad,int dorsal, String demarcacion) {
		super( id, Nombre, Apellido, Edad);
		this.dorsal=dorsal;
		this.demarcacion=demarcacion;
	
		
	}
	
	public int getDorsal() {
		return dorsal;
	}

	public void setDorsal(int dorsal) {
		this.dorsal = dorsal;
	}

	public String getDemarcacion() {
		return demarcacion;
	}

	public void setDemarcacion(String demarcacion) {
		this.demarcacion = demarcacion;
	}

	public void jugarPartido() {
		
	}
	public void entrenar() {
		
	}
	

}
