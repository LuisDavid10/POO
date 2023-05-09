package Unidad_5;

public class Articulo {
	private int clave;
	private double precio;
	private String promo;
	public Articulo(int clave, double precio, String promo) {
		super();
		this.clave = clave;
		this.precio = precio;
		this.promo = promo;
	}
	public Articulo(int clave, double precio) {
		super();
		this.clave = clave;
		this.precio = precio;
	}
	
	public int getClave() {
		return clave;
	}
	public void setClave(int clave) {
		this.clave = clave;
	}
	public double getPrecio() {
		return precio;
	}
	public void setPrecio(double precio) {
		this.precio = precio;
	}
	public String getPromo() {
		return promo;
	}
	public void setPromo(String promo) {
		this.promo = promo;
	}
	@Override
	public String toString() {
		return "Clave:" + clave + "\nPrecio:" + precio +(promo==null?"": "\nPromo:" + promo) +"\n===================\n";
	}
	
	

}
