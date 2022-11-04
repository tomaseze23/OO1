package modelo;

import java.time.LocalDate;

public abstract class Servicio {
	protected String codServicio;
	protected double porcentajeDescuento;
	protected boolean enPromocion;
	
	public Servicio(String codServicio, double porcentajeDescuento, boolean enPromocion) throws Exception {
		setCodServicio(codServicio);
		this.porcentajeDescuento = porcentajeDescuento;
		this.enPromocion = enPromocion;
	}
	
	public String getCodServicio() {
		return codServicio;
	}
	public void setCodServicio(String codServicio) throws Exception {
		if(!validarCodigo(codServicio)) {
			throw new Exception("ERROR: El código no tiene una longitud de 6.");
		}
		this.codServicio = codServicio;
	}
	public boolean validarCodigo(String codigo) {
		return codigo.length()==6;
	}
	public double getPorcentajeDescuento() {
		return porcentajeDescuento;
	}
	public void setPorcentajeDescuento(double porcentajeDescuento) {
		this.porcentajeDescuento = porcentajeDescuento;
	}
	public boolean isEnPromocion() {
		return enPromocion;
	}
	public void setEnPromocion(boolean enPromocion) {
		this.enPromocion = enPromocion;
	}

	@Override
	public String toString() {
		return "Servicio [codServicio=" + codServicio + ", porcentajeDescuento=" + porcentajeDescuento
				+ ", enPromocion=" + enPromocion + "]";
	}

	public abstract double calcularPrecioFinal(LocalDate dia);
	
}
