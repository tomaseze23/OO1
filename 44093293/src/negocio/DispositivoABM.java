package negocio;

import java.util.ArrayList;
import java.util.List;

import dao.DispositivoDao;
import datos.Dispositivo;
import datos.SensorCortinaVentana;
public class DispositivoABM {
	DispositivoDao dao = new DispositivoDao();
	
	public List<Dispositivo> traer(){
		return dao.traer();
	}
	
	public Dispositivo traer(String nombre) {
		Dispositivo dispositivo = dao.traer(nombre);
		
		return dispositivo;
	}
	public List<Dispositivo> traerTodosLosDispositivosSensorCortinaVenta(){
		List<Dispositivo> lista = new ArrayList<Dispositivo>();
		for(Dispositivo d: dao.traer()) {
			if(d instanceof SensorCortinaVentana) {
				lista.add(d);
			}
		}
		return lista;
	}
}
