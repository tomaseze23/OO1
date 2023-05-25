package negocio;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

import dao.DosisDao;
import datos.Dosis;
import datos.Vacuna;

public class DosisAbm {
	
	private static DosisAbm instancia = null;
	
	protected DosisAbm() {}
	
	public static DosisAbm getInstance() {
		if(instancia == null) {
			instancia = new DosisAbm();
		}
		return instancia;
	}
	
	public List<Dosis> traer(Vacuna vacuna){
		return DosisDao.getInstance().traer(vacuna);
	}
	
	public List<Dosis> traer(LocalTime horaDesde, LocalTime horaHasta){
		return DosisDao.getInstance().traer(horaDesde, horaHasta);
	}
	
	public List<Dosis> traer(LocalTime horaDesde, LocalTime horaHasta, boolean tieneComorbilidad){
		List<Dosis> retornar = new ArrayList<Dosis>();
		for(Dosis d : traer(horaDesde, horaHasta)) {
			if(d.getPersona().isTieneComorbilidad() == tieneComorbilidad) {
				retornar.add(d);
			}
		}
		return retornar;
	}

}
