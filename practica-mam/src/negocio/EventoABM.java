package negocio;

import java.time.LocalDate;
import java.util.List;

import dao.EventoDao;
import datos.Evento;
public class EventoABM {
	EventoDao dao = new EventoDao();
	
	public Evento traer(long idEvento) {
		Evento e = dao.traer(idEvento);
		return e;
	}
	
	public int agregar(String evento, LocalDate fecha) {
		Evento e = new Evento(evento, fecha);
		return dao.agregar(e);
	}
	
	public void actualizar(Evento evento) {
		dao.actualizar(evento);
	}
	
	public void eliminar(Evento evento) {
		dao.eliminar(evento);
	}
	
	public List<Evento> traer(){
		return dao.traer();
	}
	
	public Evento traerEventoYClientes(long idEvento) {
		return dao.traerEventoYClientes(idEvento);
	}
	
	
}
