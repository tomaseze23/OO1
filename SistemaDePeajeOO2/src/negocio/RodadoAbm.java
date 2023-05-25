package negocio;

import dao.RodadoDao;
import datos.Rodado;

public class RodadoAbm {
	
	public static RodadoAbm instancia = null;
	protected RodadoAbm() {}
	public static RodadoAbm getInstance() {
		if(instancia == null) {
			instancia = new RodadoAbm();
		}
		return instancia;
	}
	
	public Rodado traerRodado(String dominio) {
		return RodadoDao.getInstance().traerRodado(dominio);
	}

}
