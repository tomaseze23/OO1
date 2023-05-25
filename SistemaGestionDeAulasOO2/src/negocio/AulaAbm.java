package negocio;

import dao.AulaDao;
import datos.Aula;

public class AulaAbm {
	
	private static AulaAbm instancia = null;
	
	protected AulaAbm() {}
	
	public static AulaAbm getInstance() {
		if(instancia == null) {
			instancia = new AulaAbm();
		}
		return instancia;
	}
	
	public Aula traer(int id) {
		return AulaDao.getInstance().traer(id);
	}

}
