package negocio;

import dao.VacunaDao;
import datos.Vacuna;

public class VacunaAbm {
	
	private static VacunaAbm instancia = null;
	
	protected VacunaAbm() {}
	
	public static VacunaAbm getInstance() {
		if(instancia == null) {
			instancia = new VacunaAbm();
		}
		return instancia;
	}
	
	public Vacuna traer(long codigo) {
		return VacunaDao.getInstance().traer(codigo); 
	}

}
