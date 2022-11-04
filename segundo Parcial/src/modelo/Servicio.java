package modelo;

import java.time.LocalDate;

public abstract class Servicio {
	protected int idServicio;
	protected String codIngreso;
	protected LocalDate fechaIngreso;
	protected boolean checkOut;
	protected Persona responsable;

	protected Servicio(int idServicio, String codIngreso, LocalDate fechaIngreso, boolean checkOut, Persona responsable)
			throws Exception {
		this.idServicio = idServicio;
		setCodIngreso(codIngreso);
		this.fechaIngreso = fechaIngreso;
		this.checkOut = checkOut;
		this.responsable = responsable;
	}

	public int getIdServicio() {
		return idServicio;
	}

	public void setIdServicio(int idServicio) {
		this.idServicio = idServicio;
	}

	public String getCodIngreso() {
		return codIngreso;
	}

	public void setCodIngreso(String codIngreso) throws Exception {
		if (!esValidoDigitoControl(codIngreso)) {
			throw new Exception("ERROR: el codigo ingresado es invalido.");
		}
		this.codIngreso = codIngreso;
	}

	public boolean esValidoDigitoControl(String codIngreso) {
		int suma = 0;
		boolean valido = false;
		char[] auxiliar = codIngreso.toCharArray();
		for (int i = 0; i < codIngreso.length() - 1; i++) {
			suma += Character.getNumericValue(auxiliar[i]);
		}
		int dVerificador = suma % 10;
		if (dVerificador == Character.getNumericValue(auxiliar[6])) {
			valido = true;
		}
		return valido;
	}

	public LocalDate getFechaIngreso() {
		return fechaIngreso;
	}

	public void setFechaIngreso(LocalDate fechaIngreso) {
		this.fechaIngreso = fechaIngreso;
	}

	public boolean isCheckOut() {
		return checkOut;
	}

	public void setCheckOut(boolean checkOut) {
		this.checkOut = checkOut;
	}

	public Persona getResponsable() {
		return responsable;
	}

	public void setResponsable(Persona responsable) {
		this.responsable = responsable;
	}

	@Override
	public String toString() {
		return "Servicio [idServicio=" + idServicio + ", codIngreso=" + codIngreso + ", fechaIngreso=" + fechaIngreso
				+ ", checkOut=" + checkOut + ", responsable=" + responsable.toString() + "]";
	}

	public abstract double calcularPrecioFinal();

}
