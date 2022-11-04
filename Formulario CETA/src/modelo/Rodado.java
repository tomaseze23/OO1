package modelo;

import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Rodado {
	private int idRodado;
	private String dominio;
	private int modelo;
	private String marca;
	
	public Rodado(int idRodado, String dominio, int modelo, String marca) {
		this.idRodado = idRodado;
		setDominio(dominio);
		this.modelo = modelo;
		this.marca = marca;
	}

	public int getIdRodado() {
		return idRodado;
	}

	public void setIdRodado(int idRodado) {
		this.idRodado = idRodado;
	}

	public String getDominio() {
		return dominio;
	}

	public void setDominio(String dominio) {
		try {
			if(validarDominio(dominio)) {
				this.dominio=dominio;
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	public int getModelo() {
		return modelo;
	}

	public void setModelo(int modelo) {
		this.modelo = modelo;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	@Override
	public String toString() {
		return "ID Rodado:" + idRodado + " Dominio: " + dominio + " Modelo: " + modelo + " Marca: " + marca;
	}

	@Override
	public int hashCode() {
		return Objects.hash(dominio, idRodado, marca, modelo);
	}

	public boolean equals(Rodado rodado) {
		return (rodado.getDominio().equals(dominio));
	}
	
	public boolean validarDominio(String dominio) throws Exception {
		Pattern patronNuevo= Pattern.compile("[A-Z]{2} [0-9]{3} [A-Z]{2}");
		Pattern patronViejo = Pattern.compile("[A-Z]{3} [0-9]{3}");
		Matcher m = patronViejo.matcher(dominio);
		Matcher m1 = patronNuevo.matcher(dominio);
		if (!m.matches()) {
			if(!m1.matches()) {
				throw new Exception("ERROR: patente no valida");
			}
		}
		return true;
	}
}
