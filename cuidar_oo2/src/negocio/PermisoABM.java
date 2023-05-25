package negocio;
import dao.PermisoDao;
import datos.Permiso;

public class PermisoABM {
	PermisoDao dao = new PermisoDao();
	public Permiso traerPermiso(int idPermiso) {
		Permiso p = dao.traerPermiso(idPermiso);
		return p;
	}
}
