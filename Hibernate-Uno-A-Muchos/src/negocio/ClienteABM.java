package negocio;

import java.time.LocalDate;
import java.util.List;
import dao.ClienteDao;
import datos.Cliente;

public class ClienteABM {
	ClienteDao dao = new ClienteDao();

	public Cliente traer(long idCliente) throws Exception {
		Cliente c = dao.traer(idCliente);
		if (c==null) {
			throw new Exception("ERROR: No existe un cliente con dicho ID.");
		}
		return c;
	}

	public Cliente traer(int dni) throws Exception {
		Cliente c = dao.traer(dni);
		if (c==null) {
			throw new Exception("ERROR: No existe un cliente con dicho DNI.");
		}
		return c;
	}

	public int agregar(String apellido, String nombre, int dni, LocalDate fechaDeNacimiento) throws Exception {
		Cliente c = new Cliente(apellido, nombre, dni, fechaDeNacimiento);
		if(dao.traer(dni) != null) {
			throw new Exception("ERROR: El cliente con dicho DNI ya existe.");

		}
		return dao.agregar(c);
	}

	public void modificar(Cliente c) throws Exception {
        if(dao.traer(c.getDni()) == null){
            throw new Exception("No se puede actualizar. No existe un cliente con ese dni");
        }
        if(dao.traer(c.getIdCliente()) == null){
            throw new Exception("No se puede actualizar. No existe un cliente con ese Id");
        }
		dao.actualizar(c);
	}

	public void eliminar(long idCliente) throws Exception {
		Cliente c = dao.traer(idCliente);
        if(c == null){
            throw new Exception("No se puede eliminar. No existe un cliente con ese Id");
        }
		dao.eliminar(c);
	}

	public List<Cliente> traer() {
		return dao.traer();
	}

	public Cliente traerClienteYPrestamos(long idCliente) {
		return dao.traerClienteYPrestamos(idCliente);
	}
}
