package negocio;

import java.time.LocalDate;
import java.util.List;
import dao.EventoDao;
import dao.ClienteDao;
import datos.Cliente;
import datos.Evento;

public class EventoABM {
	EventoDao dao = new EventoDao();
	ClienteDao daoC = new ClienteDao();
	public int agregar(String evento, LocalDate fecha) {
		Evento e = new Evento(evento, fecha);
		return dao.agregar(e);
	}
	
	public void modificar(Evento e) {
		dao.actualizar(e);
	}

	public void eliminar(long idEvento) {
		Evento e = dao.traer(idEvento);
		dao.eliminar(e);
	}

	public Evento traer (long idEvento) {
		Evento e = dao.traer(idEvento);
		return e;
	}
	
	public List<Evento> traer() {
		return dao.traer();
	}
	

	
	public void agregarClienteAEvento(long idCliente, long idEvento) {
		Cliente c = daoC.traer(idCliente);
		Evento e = dao.traer(idEvento);
		e.getClientes().add(c);
		dao.actualizar(e);
		
	}
	
	public void eliminarClienteAEvento(long idCliente, long idEvento) {
		Cliente c = daoC.traer(idCliente);
		Evento e = dao.traer(idEvento);
		e.eliminar(c);
		dao.actualizar(e);
	}
}
