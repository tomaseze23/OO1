package negocio;

import java.time.LocalDateTime;
import java.util.List;

import dao.EventoDao;
import datos.Dispositivo;
import datos.Evento;
public class EventoABM {
	EventoDao dao = new EventoDao();
	
	public Evento traer(Dispositivo dispositivo, LocalDateTime fechaHora) {
		return dao.traer(dispositivo, fechaHora);
	}
	
	public int agregar(String descripcion, Dispositivo dispositivo, LocalDateTime fechaHora) throws Exception {
		if(dao.traer(dispositivo, fechaHora) != null) {
			throw new Exception("Ya existe un evento destinado a esa fecha y hora");
		}
		Evento evento = new Evento(descripcion, dispositivo, fechaHora);
		return dao.agregar(evento);
	}
	
	public List<Evento> traer(){
		return dao.traer();
	}
	public List<Evento> traer(LocalDateTime fechaHoraDesde, LocalDateTime fechaHoraHasta){
		return dao.traer(fechaHoraDesde, fechaHoraHasta);
	}
	
	public List<Evento> traer(LocalDateTime fechaHoraDesde, LocalDateTime fechaHoraHasta, Dispositivo dispositivo){
		return dao.traer(fechaHoraDesde, fechaHoraHasta, dispositivo);
	}
}
