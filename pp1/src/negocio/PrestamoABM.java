package negocio;

import dao.PrestamoDao;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import datos.Cliente;
import datos.Prestamo;

public class PrestamoABM {
	private PrestamoDao dao = new PrestamoDao();
	
	public Prestamo traerPrestamo(long idPrestamo) throws Exception {
		if(dao.traer(idPrestamo)==null) {
			throw new Exception("ERROR el prestamo no existe.");
		}
		Prestamo p = dao.traer(idPrestamo);
		return p;
	}
	
	public List<Prestamo> traerPrestamo(Cliente c){
		return dao.traer(c);
	}
	
	public int agregar(LocalDate fecha, double monto, double interes, int cantCuotas, Cliente cliente) {
		Prestamo p = new Prestamo(fecha, monto, interes, cantCuotas, cliente);
		return dao.agregar(p);
	}
	
	public void modificar(Prestamo p){
		dao.actualizar(p);
	}
	
	public void eliminar(long idPrestamo) throws Exception {
		Prestamo p = dao.traer(idPrestamo);
		if(p==null) {
			throw new Exception("ERROR el prestamo no existe");
		}
		dao.eliminar(p);
	}
	public List<Prestamo> traerPrestamos(Cliente cliente){
		/*List<Prestamo> prestamosDelCliente = new ArrayList<Prestamo>();
		for(Prestamo p: dao.traerPrestamos(cliente)) {
			prestamosDelCliente.add(p);
		}*/
		
		return dao.traerPrestamos(cliente);
	}
	
	public List<Prestamo> traerPrestamos(LocalDate fecha) throws Exception{
		if(dao.traerPrestamos(fecha).isEmpty()) {
			throw new Exception("No hay prestamos de esa fecha");
		}
		return dao.traerPrestamos(fecha);
	}
	
	public List<Prestamo> traerPrestamos(LocalDate desde, LocalDate hasta){
		return dao.traerPrestamos(desde, hasta);
	}
}
