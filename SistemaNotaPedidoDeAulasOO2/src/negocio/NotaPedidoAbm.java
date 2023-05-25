package negocio;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import dao.NotaPedidoDao;
import datos.Curso;
import datos.Materia;
import datos.NotaPedido;

public class NotaPedidoAbm {
	
	public static NotaPedidoAbm instancia = null;
	
	protected NotaPedidoAbm () {}
	
	public static NotaPedidoAbm getInstance() {
		if(instancia == null) {
			instancia = new NotaPedidoAbm();
		}
		return instancia;
	}
	
	public NotaPedido traerNotaPedido(int idNotaPedido) {
		return NotaPedidoDao.getInstance().traerMateria(idNotaPedido);
	}
	
	public List<NotaPedido> traer(LocalDate fechaExamen) {
		return NotaPedidoDao.getInstance().traer(fechaExamen);
	}
	
	public List<NotaPedido> traerFinales(LocalDate desde, LocalDate hasta){
		return NotaPedidoDao.getInstance().traerFinales(desde, hasta);
	}
	
	public List<NotaPedido> traerFinales(LocalDate desde, LocalDate hasta, Materia materia){
		List<NotaPedido> aux = new ArrayList<NotaPedido>();
		for(NotaPedido np : traerFinales(desde, hasta)) {
			if(np.getMateria().getIdMateria() == materia.getIdMateria()) {
				aux.add(np);
			}
		}
		return aux;
	}
	
	public List<NotaPedido> traerFinalesConJoin(LocalDate desde, LocalDate hasta, Materia materia){
		return NotaPedidoDao.getInstance().traerFinales(desde, hasta, materia);
	}
	
	public int agregar(LocalDate fecha, int cantEstudiantes, Materia materia, String codCurso) {
		return NotaPedidoDao.getInstance().agregar(new Curso(fecha, cantEstudiantes, materia, codCurso));
	}
}
