package modelo;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

public class Sistema {
	private List<Persona> lstPersonas;
	private List<Seguridad> lstSeguridad;

	public Sistema() {
		lstPersonas = new ArrayList<Persona>();
		lstSeguridad = new ArrayList<Seguridad>();
	}

	public List<Persona> getLstPersonas() {
		return lstPersonas;
	}

	public List<Seguridad> getLstSeguridad() {
		return lstSeguridad;
	}

	public boolean agregarEmpleado(String apellido, String nombre, int dni, int nroLegajo) {
		int id = 1;
		if (!lstPersonas.isEmpty()) {
			id = lstPersonas.get(lstPersonas.size() - 1).getId() + 1;
		}
		return lstPersonas.add(new Empleado(id, apellido, nombre, dni, nroLegajo));
	}

	public boolean agregarVisita(String apellido, String nombre, int dni, String empresa) {
		int id = 1;
		if (!lstPersonas.isEmpty()) {
			id = lstPersonas.get(lstPersonas.size() - 1).getId() + 1;
		}
		return lstPersonas.add(new Visita(id, apellido, nombre, dni, empresa));
	}

	public Persona traerPersona(int id) {
		Persona persona = null;
		int indice = 0;
		while (persona == null && indice < lstPersonas.size()) {
			if (lstPersonas.get(indice).getId() == id) {
				persona = lstPersonas.get(indice);
			}
			indice++;
		}
		return persona;
	}

	public List<Seguridad> traerSeguridad(LocalDate fecha, Persona persona) {
		List<Seguridad> seguridad = new ArrayList<Seguridad>();
		for (Seguridad seg : lstSeguridad) {
			if (seg.getFecha().equals(fecha) && seg.getPersona().equals(persona)) {
				seguridad.add(seg);
			}
		}
		return seguridad;
	}

	public boolean agregarSeguridad(LocalDate fecha, LocalTime hora, boolean entrada, Persona persona)
			throws Exception {
		int id = 1;
		if (!lstSeguridad.isEmpty()) {
			List<Seguridad> auxiliar = traerSeguridad(fecha, persona);
			int indice = 0;
			while (indice < auxiliar.size()) {
				if (auxiliar.get(indice).isEntrada() == entrada) {
					throw new Exception("ERROR: Una persona no puede registrar dos veces la salida o la entrada.");
				}
				indice++;
			}
			id = lstSeguridad.get(lstSeguridad.size() - 1).getId() + 1;
		}

		return lstSeguridad.add(new Seguridad(id, fecha, hora, entrada, persona));
	}

	public List<Seguridad> traerVisitas(LocalDate fecha) {
		List<Seguridad> seguridad = new ArrayList<Seguridad>();
		for (Seguridad seg : lstSeguridad) {
			if (seg.getFecha().equals(fecha) && seg.getPersona() instanceof Visita) {
				seguridad.add(seg);
			}
		}
		return seguridad;
	}

}
