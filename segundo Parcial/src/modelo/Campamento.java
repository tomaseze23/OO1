package modelo;

import java.time.LocalDate;
import java.time.Period;

public class Campamento extends Servicio {
	private LocalDate fechaEgreso;
	private int cantCarpas;
	private double precioCarpa;

	protected Campamento(int idServicio, String codIngreso, LocalDate fechaIngreso, boolean checkOut,
			Persona responsable, LocalDate fechaEgreso, int cantCarpas, double precioCarpa) throws Exception {
		super(idServicio, codIngreso, fechaIngreso, checkOut, responsable);
		this.fechaEgreso = fechaEgreso;
		this.cantCarpas = cantCarpas;
		this.precioCarpa = precioCarpa;
	}

	public LocalDate getFechaEgreso() {
		return fechaEgreso;
	}

	public void setFechaEgreso(LocalDate fechaEgreso) {
		this.fechaEgreso = fechaEgreso;
	}

	public int getCantCarpas() {
		return cantCarpas;
	}

	public void setCantCarpas(int cantCarpas) {
		this.cantCarpas = cantCarpas;
	}

	public double getPrecioCarpa() {
		return precioCarpa;
	}

	public void setPrecioCarpa(double precioCarpa) {
		this.precioCarpa = precioCarpa;
	}

	@Override
	public String toString() {
		return "Campamento [fechaEgreso=" + fechaEgreso + ", cantCarpas=" + cantCarpas + ", precioCarpa=" + precioCarpa
				+ super.toString() + "]";
	}

	public int cantidadDias() {
		int dias = 0;
		if (checkOut) {
			dias = Period.between(fechaIngreso, fechaEgreso).getDays();
		} else {
			dias = Period.between(fechaIngreso, LocalDate.now()).getDays();
		}
		return dias;
	}

	public double calcularPrecioFinal() {
		return cantCarpas * precioCarpa * cantidadDias();
	}

}
