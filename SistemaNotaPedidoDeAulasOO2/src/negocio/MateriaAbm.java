package negocio;

import dao.MateriaDao;
import datos.Materia;

public class MateriaAbm {
	
	public static MateriaAbm instancia = null;
	
	protected MateriaAbm () {}
	
	public static MateriaAbm getInstance() {
		if(instancia == null) {
			instancia = new MateriaAbm();
		}
		return instancia;
	}
	
	public Materia traerMateria(int idMateria) {
		return MateriaDao.getInstance().traerMateria(idMateria);
	}

}
