package negocio;

import dao.PrestamoDao;

import java.time.LocalDate;
import java.util.List;
import datos.Cliente;
import datos.Prestamo;

public class PrestamoABM {
	private PrestamoDao dao = new PrestamoDao();
	
	public Prestamo traerPrestamo (long idPrestamo) throws Exception {
		//Implementar: si el no existe el prestamo lanzar la excepción
		Prestamo p = dao.traer(idPrestamo);
		if(p == null) {
			throw new Exception("ERROR el prestamo no existe.");
		}
		return p;
	}
	
	public List<Prestamo> traerPrestamo(Cliente c) throws Exception {
		List<Prestamo> prestamos = dao.traer(c);
		if(prestamos.isEmpty()) {
			throw new Exception("ERROR el cliente no posee prestamos.");
		}
		
		return prestamos;
	}
	
	public int agregar(LocalDate fecha, double monto, double interes, int cantCuotas,
			Cliente cliente) {
		Prestamo p = new Prestamo(fecha, monto, interes, cantCuotas,cliente);

		return dao.agregar(p);
	}
	
    public void eliminar(long idPrestamo) throws Exception{
        Prestamo p = dao.traer(idPrestamo);
        if(p == null){
            throw new Exception("ERROR: No se puede eliminar "
            		+ "porque no existe un prestamo con dicho ID.");
        }
        dao.eliminar(p);
    }

    public void modificar(Prestamo p) throws Exception{
        if(dao.traer(p.getIdPrestamo()) == null){
            throw new Exception("ERROR: No se puede actualizar "
            		+ "porque no existe un prestamo con dicho ID");
        }
        dao.actualizar(p);
    }
	
}
