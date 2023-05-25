package negocio;

import dao.EdificioDao;
import datos.Edificio;
public class EdificioABM {
	EdificioDao dao = new EdificioDao();
	
	// CU 1
	public Edificio traerEdificioConAulas(int idEdificio) {
		return dao.traerEdificioConAulas(idEdificio);
	}
}
