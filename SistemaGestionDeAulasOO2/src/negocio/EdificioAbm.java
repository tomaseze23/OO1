package negocio;

import dao.EdificioDao;
import datos.Edificio;

public class EdificioAbm {
	
	public static EdificioAbm instancia = null;
	
	protected EdificioAbm() {}
	
	public static EdificioAbm getInstance() {
		if(instancia == null) {
			instancia = new EdificioAbm();
		}
		return instancia;
	}
	
	public Edificio traer(int id) {
		return EdificioDao.getInstance().traer(id);
	}

}
