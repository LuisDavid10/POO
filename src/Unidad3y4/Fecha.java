package Unidad3y4;

import java.io.Serializable;
import java.util.Objects;

public class Fecha implements Serializable {
	  private int dia;
	    private int mes;
	    private int año;
	    public Fecha(int dia, int mes, int año) {
	        super();
	        this.dia = dia;
	        this.mes = mes;
	        this.año = año;
	    }
	    public int getDia() {
	        return dia;
	    }
	    public void setDia(int dia) {
	        this.dia = dia;
	    }
	    public int getMes() {
	        return mes;
	    }
	    public void setMes(int mes) {
	        this.mes = mes;
	    }
	    public int getAño() {
	        return año;
	    }
	    public void setAño(int año) {
	        this.año = año;
	    }
	    
	    @Override
		public int hashCode() {
			return Objects.hash(año, dia, mes);
		}
		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			Fecha other = (Fecha) obj;
			return año == other.año && dia == other.dia && mes == other.mes;
		}
		@Override
	    public String toString() {
			return dia + "/" + mes + "/" + año;
		}
}
