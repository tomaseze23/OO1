package negocio;
import dao.LugarDao;
import datos.Ubicacion;
import datos.Localidad;
import datos.Lugar;
public class LugarABM {
	LugarDao dao = new LugarDao();
	
	public Lugar traer(int idLugar) {
		Lugar lugar = dao.traer(idLugar);
		return lugar;
	}
	
	public Lugar traerUbicacion(int idUbicacion) throws Exception {
		if(!(dao.traer(idUbicacion) instanceof Ubicacion)) {
			throw new Exception("El lugar solicitado no corresponde a una ubicacion");
		}
		
		return dao.traer(idUbicacion);
	}
	public Lugar traerLocalidad(int idLocalidad) throws Exception {
		if(!(dao.traer(idLocalidad) instanceof Localidad)) {
			throw new Exception("El lugar solicitado no corresponde a una localidad");
		}
		
		return dao.traer(idLocalidad);
	}
}
