package modelo;

import java.util.List;
import java.time.LocalDate;
import java.util.ArrayList;

public class CampingNacional {
	private List<Persona> lstPersonas;
	private List<Servicio> lstServicios;

	public CampingNacional() {
		lstPersonas = new ArrayList<Persona>();
		lstServicios = new ArrayList<Servicio>();
	}

	public List<Persona> getLstPersonas() {
		return lstPersonas;
	}

	public List<Servicio> getLstServicios() {
		return lstServicios;
	}

	public Persona traerPersona(long dni) {
		Persona auxiliar = null;
		int indice = 0;
		while (auxiliar == null && indice < lstPersonas.size()) {
			if (lstPersonas.get(indice).getDni() == dni) {
				auxiliar = lstPersonas.get(indice);
			}
			indice++;
		}

		return auxiliar;
	}

	public boolean agregarPersona(String apellido, String nombre, long dni) throws Exception {
		int id = 1;
		if (traerPersona(dni) != null) {
			throw new Exception("ERROR: ya existe una persona con dicho DNI.");
		}
		if (!lstPersonas.isEmpty()) {
			id = lstPersonas.get(lstPersonas.size() - 1).getIdPersona() + 1;
		}

		return lstPersonas.add(new Persona(id, apellido, nombre, dni));
	}

	public boolean agregarRecreo(String codIngreso, LocalDate fechaIngreso, boolean checkOut, Persona responsable,
			int cantPersonas, double precioPersona) throws Exception {
		int id = 1;
		if (!lstServicios.isEmpty()) {
			id = lstServicios.get(lstServicios.size() - 1).getIdServicio() + 1;
		}

		return lstServicios
				.add(new Recreo(id, codIngreso, fechaIngreso, checkOut, responsable, cantPersonas, precioPersona));
	}

	public boolean agregarCampamento(String codIngreso, LocalDate fechaIngreso, boolean checkOut, Persona responsable,
			LocalDate fechaEgreso, int cantCarpas, double precioCarpa) throws Exception {
		int id = 1;
		if (!lstServicios.isEmpty()) {
			id = lstServicios.get(lstServicios.size() - 1).getIdServicio() + 1;
		}
		return lstServicios.add(new Campamento(id, codIngreso, fechaIngreso, checkOut, responsable, fechaEgreso,
				cantCarpas, precioCarpa));
	}

	public List<Servicio> traerServiciosPorPrecioFinal(double mayorIgualA) {
		List<Servicio> serviciosCoincidentes = new ArrayList<Servicio>();
		for (int i = 0; i < lstServicios.size(); i++) {
			if (lstServicios.get(i).isCheckOut() == true && lstServicios.get(i).calcularPrecioFinal() > mayorIgualA) {
				serviciosCoincidentes.add(lstServicios.get(i));
			}
		}
		return serviciosCoincidentes;
	}

	public List<Campamento> traerCampamentosPorDias(int mayorIgualA) {
		List<Campamento> campamentosCoincidentes = new ArrayList<Campamento>();
		for (int i = 0; i < lstServicios.size(); i++) {
			if (lstServicios.get(i) instanceof Campamento) {
				Campamento auxiliar = (Campamento) lstServicios.get(i);
				if (auxiliar.cantidadDias() >= mayorIgualA) {
					campamentosCoincidentes.add(auxiliar);
				}
			}
		}

		return campamentosCoincidentes;
	}
}
