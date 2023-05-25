package negocio;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import dao.PeajeDao;
import datos.Abonado;
import datos.Manual;
import datos.Rodado;
import datos.Telepeaje;

public class PeajeAbm {
	
	private static PeajeAbm instancia = null;// Patrón Singleton
	protected PeajeAbm() {}
	public static PeajeAbm getInstance(){
		if(instancia==null)
			instancia=new PeajeAbm();
		return instancia;
	}
	
	public List<Manual> traerManual(){
		return PeajeDao.getInstance().traerManual();
	}
	
	public List<Telepeaje> traerTelepeaje(){
		return PeajeDao.getInstance().traerTelepeaje();
	}
	
	public List<Manual> traerManual(LocalDate fecha) {
		List<Manual> listFechaSel = new ArrayList<Manual>();
		for(Manual m : traerManual()) {
			if(m.getFecha().isEqual(fecha)) {
				listFechaSel.add(m);
			}
		}
		return listFechaSel;
	}
	
	public double cerrarCaja(LocalDate fecha) {
		double totalDelDia = 0;
		for(Manual m : traerManual(fecha)) {
			totalDelDia += m.getPrecio();
		}
		return totalDelDia;
	}
	
	public List<Telepeaje> traerTelepeaje(Abonado abonado){
		return PeajeDao.getInstance().traerTelepeaje(abonado);
	}

}
