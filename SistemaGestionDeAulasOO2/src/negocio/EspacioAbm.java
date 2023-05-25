package negocio;

import java.time.LocalDate;

import dao.EspacioDao;
import datos.Aula;
import datos.Espacio;

public class EspacioAbm {
	
	public static EspacioAbm instancia = null;
	
	protected EspacioAbm() {}
	
	public static EspacioAbm getInstance() {
		if(instancia == null) {
			instancia = new EspacioAbm();
		}
		return instancia;
	}
	
	public Espacio traerQuery(LocalDate fecha,char turno, Aula aula) {
		return EspacioDao.getInstance().traer2(fecha, turno, aula);
	}
	
	public int agregar(LocalDate fecha, char turno, Aula aula, boolean libre) throws Exception {
		Espacio aux = traerQuery(fecha, turno, aula);
		if(aux != null) {
			throw new Exception ("Ya existe el objeto que intenta agregar!");
		}
		return EspacioDao.getInstance().agregar(new Espacio(fecha, turno, aula, libre));
	}
	
	public Espacio traer(int id) {
		return EspacioDao.getInstance().traer(id);
	}
	
	public void agregarEspacioMes(int mes, int anio, char turno, Aula aula) throws Exception {
		int ultimoDiaMes = LocalDate.of(anio, mes, 1).getMonth().length(false);
		LocalDate fechaInicio = LocalDate.of(anio, mes, 1);
		LocalDate fechaFin = LocalDate.of(anio, mes, ultimoDiaMes);
		
		while(!(fechaInicio.isEqual(fechaFin))) {
			agregar(fechaInicio, turno, aula, true);
			fechaInicio = fechaInicio.plusDays(1);
		}
	}

}
