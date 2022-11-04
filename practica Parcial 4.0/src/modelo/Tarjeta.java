package modelo;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

public class Tarjeta {
	private int idTarjeta;
	private String codigo;
	private String codigoCliente;
	private List<Compra> compras;
	protected Tarjeta(int idTarjeta, String codigo, String codigoCliente) throws Exception {
		this.idTarjeta = idTarjeta;
		setCodigo(codigo);
		this.codigoCliente = codigoCliente;
		compras = new ArrayList<Compra>();
	}
	public int getIdTarjeta() {
		return idTarjeta;
	}
	public void setIdTarjeta(int idTarjeta) {
		this.idTarjeta = idTarjeta;
	}
	public String getCodigo() {
		return codigo;
	}
	public void setCodigo(String codigo) throws Exception {
		if(codigo.length()!=12) {
			throw new Exception("ERROR: El largo del código debe ser 12.");
		}
		if(!validarCodigo(codigo)) {
			throw new Exception("ERROR: El código debe estar compuesto por 6 letras y 6 números.");
		}
		this.codigo = codigo;
	}
	public boolean validarCodigo(String codigo) {
		return codigo.matches("[^0-9]{6}[0-9]{6}");
	}
	public String getCodigoCliente() {
		return codigoCliente;
	}
	public void setCodigoCliente(String codigoCliente) {
		this.codigoCliente = codigoCliente;
	}
	public List<Compra> getCompras() {
		return compras;
	}
	
	public boolean agregarCompra(LocalDate fecha, LocalTime hora, double puntosPorLitro, double
			litrosComprados, double puntosExtra) {
		int id=1;
		if(!compras.isEmpty()) {
			id = compras.get(compras.size() - 1).getIdCompra() + 1;
		}
		return compras.add(new Efectivo(id, fecha, hora, puntosPorLitro, litrosComprados, puntosExtra));
	}
	
	public boolean agregarCompra(LocalDate fecha, LocalTime hora, double puntosPorLitro, double
			litrosComprados, String medio, double puntosDeRegalo) {
		int id=1;
		if(!compras.isEmpty()) {
			id = compras.get(compras.size() - 1).getIdCompra() + 1;
		}
		return compras.add(new Electronica(id, fecha, hora, puntosPorLitro, litrosComprados, medio, puntosDeRegalo));
	}
	@Override
	public String toString() {
		return "Tarjeta -> ID= " + idTarjeta + ", codigo=" + codigo + ", codigoCliente=" + codigoCliente
				+ ", compras=" + compras;
	}
}
