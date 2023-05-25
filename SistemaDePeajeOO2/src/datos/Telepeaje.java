package datos;

import java.time.LocalDate;
import java.time.LocalTime;

public class Telepeaje extends Peaje {
	
	private Rodado rodado;
	private String lector;
	
	public Telepeaje() {}

	public Telepeaje(LocalDate fecha, LocalTime hora, double precio, Rodado rodado, String lector) {
		super(fecha, hora, precio);
		
		this.rodado = rodado;
		this.lector = lector;
		
	}

	public Rodado getRodado() {
		return rodado;
	}

	public void setRodado(Rodado rodado) {
		this.rodado = rodado;
	}

	public String getLector() {
		return lector;
	}

	public void setLector(String lector) {
		this.lector = lector;
	}

	@Override
	public String toString() {
		return super.toString()+"Telepeaje [rodado=" + rodado + ", lector=" + lector + "]\n";
	}

}
