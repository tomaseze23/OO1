package negocio;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import dao.PersonaDao;
import datos.Persona;

public class PersonaAbm {
	
	private static PersonaAbm instancia = null;
	
	protected PersonaAbm() {}
	
	public static PersonaAbm getInstance() {
		if(instancia == null) {
			instancia = new PersonaAbm();
		}
		return instancia;
	}

	public List<Persona> traerPersona(int edadDesde, int edadHasta){
		
		List<Persona> aux = new ArrayList<Persona>();
		
		LocalDate hoy = LocalDate.now();
		
		for(Persona p : PersonaDao.getInstance().traer()) {
			int edad = p.calcularEdad(hoy);
			if(edad >= edadDesde && edad <= edadHasta) {
				aux.add(p);
			}
		}
		return aux;
	}
}
