package modelo;

import java.time.LocalDate;

public class Ceta {
	private int idCeta;
	private LocalDate fecha;
	private Contribuyente comprador;
	private Contribuyente vendedor;
	private double valorTransferencia;
	private boolean firmaComprador;
	public Ceta(int idCeta, LocalDate fecha, Contribuyente comprador, Contribuyente vendedor,
			double valorTransferencia) {
		this.idCeta = idCeta;
		try {
			setFecha(fecha);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		try {
			setCompradorVendedor(comprador, vendedor);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		this.valorTransferencia = valorTransferencia;
		firmaComprador = false;
	}
	public int getIdCeta() {
		return idCeta;
	}
	public void setIdCeta(int idCeta) {
		this.idCeta = idCeta;
	}
	public LocalDate getFecha() {
		return fecha;
	}
	public void setFecha(LocalDate fecha) throws Exception {
		if(fecha.isAfter(LocalDate.now())) {
			throw new Exception("ERROR: La fecha no puede ser posterior al día de hoy");
		}
		
		this.fecha = fecha;
	}
	public Contribuyente getComprador() {
		return comprador;
	}
	public void setComprador(Contribuyente comprador) {
		this.comprador = comprador;
	}
	public Contribuyente getVendedor() {
		return vendedor;
	}
	public void setVendedor(Contribuyente vendedor) {
		this.vendedor = vendedor;
	}
	
	public void setCompradorVendedor(Contribuyente comprador, Contribuyente vendedor) throws Exception {
		if(comprador.equals(vendedor)) {
			throw new Exception("ERROR: : El vendedor y el comprador son los mismos");
		}
		setComprador(comprador);
		setVendedor(vendedor);
	}
	public double getValorTransferencia() {
		return valorTransferencia;
	}
	public void setValorTransferencia(double valorTransferencia) {
		this.valorTransferencia = valorTransferencia;
	}
	public boolean isFirmaComprador() {
		return firmaComprador;
	}
	public void setFirmaComprador(boolean firmaComprador) {
		this.firmaComprador = firmaComprador;
	}
	
	public boolean equals(Ceta ceta) {
		return (ceta.idCeta==idCeta);
	}
	@Override
	public String toString() {
		return "ID CETA:" + idCeta + " Fecha: " + fecha + " Comprador: " + comprador.getCuil()
		+ " Vendedor: " + vendedor.getCuil() + " Valor de la Transferencia: " + valorTransferencia;
	}
	
	
	
}
