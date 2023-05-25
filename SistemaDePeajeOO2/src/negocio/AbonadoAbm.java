package negocio;

import dao.AbonadoDao;
import datos.Abonado;

public class AbonadoAbm {
	
	public static AbonadoAbm instancia = null;
	
	protected AbonadoAbm  () {}
	
	public static AbonadoAbm getInstance() {
		if(instancia == null) {
			instancia = new AbonadoAbm();
		}
		return instancia;
	}
	
	public Abonado traerAbonado(int dni) {
		return AbonadoDao.getInstancia().traer(dni);
	}

}
