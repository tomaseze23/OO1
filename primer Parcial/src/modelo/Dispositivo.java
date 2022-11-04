package modelo;

import java.util.List;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;

public class Dispositivo {
	private int id;
	private String nombre;
	private String codigo;
	private List<Metrica> lstMetricas;
	private Empresa empresa;

	public Dispositivo(int id, String nombre, String codigo, Empresa empresa) throws Exception {
		this.id = id;
		this.nombre = nombre;
		setCodigo(codigo);
		this.codigo = codigo;
		this.empresa = empresa;
		lstMetricas = new ArrayList<Metrica>();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) throws Exception {
		if (!validarCodigo(codigo)) {
			throw new Exception("ERROR: El código es incorrecto.");
		}
		this.codigo = codigo;
	}

	public boolean validarCodigo(String codigo) {
		boolean esValido = false;
		int suma = 0;
		if (codigo.length() == 5) {
			if (codigo.charAt(0) == 'A' || codigo.charAt(0) == 'B') {
				if (codigo.charAt(0) == 'A') {
					for (int i = 1; i < codigo.length(); i++) {
						suma += Character.getNumericValue(codigo.charAt(i));
					}
					if (suma % 2 == 0) {
						esValido = true;
					}
				} else {
					for (int i = 1; i < codigo.length(); i++) {
						suma += Character.getNumericValue(codigo.charAt(i));
					}
					if (suma % 2 != 0) {
						esValido = true;
					}
				}
			}
		}
		return esValido;
	}

	public Empresa getEmpresa() {
		return empresa;
	}

	public void setEmpresa(Empresa empresa) {
		this.empresa = empresa;
	}

	public List<Metrica> getLstMetricas() {
		return lstMetricas;
	}

	public boolean equals(Dispositivo dispositivo) {
		return dispositivo.codigo.equals(codigo);
	}

	@Override
	public String toString() {
		return "Dispositivo ID: " + id + " Nombre:" + nombre + " Codigo: " + codigo + " Lista de Metricas: "
				+ lstMetricas + " Empresa: " + empresa.getNombre();
	}

	public boolean agregarMetrica(int valor, LocalDate fecha, LocalTime hora) {
		return lstMetricas.add(new Metrica(valor, fecha, hora));
	}

	public Metrica traerMetrica(LocalDate fecha, LocalTime hora) {
		int indice = 0;
		Metrica metricaAuxiliar = null;
		while (metricaAuxiliar == null && indice < lstMetricas.size()) {
			if (lstMetricas.get(indice).getFecha().equals(fecha) && lstMetricas.get(indice).getHora().equals(hora)) {
				metricaAuxiliar = lstMetricas.get(indice);
			}
			indice++;
		}
		return metricaAuxiliar;
	}

	public List<Metrica> traerMetricas(LocalDate desde, LocalDate hasta) {
		List<Metrica> metricas = new ArrayList<Metrica>();
		for(int i=0;i<lstMetricas.size();i++) {
			if (lstMetricas.get(i).getFecha().compareTo(desde)>=0&&lstMetricas.get(i).getFecha().compareTo(hasta)<=0) {
				metricas.add(lstMetricas.get(i));
			}
		}
		return metricas;
	}

	public List<Metrica> traerMetricas(Dispositivo dispositivo, LocalDate desde, LocalDate hasta, int menorAValor) {
		List<Metrica> metricas = traerMetricas(desde, hasta);
		List<Metrica> coincidentes = new ArrayList<Metrica>();
		for(int i=0;i<metricas.size();i++) {
			if (metricas.get(i).getValor() < menorAValor) {
				coincidentes.add(metricas.get(i));
			}
		}
		return metricas;
	}
}
