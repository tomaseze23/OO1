package negocio;

import java.time.LocalDate;
import java.util.List;

import dao.ClienteDao;
import datos.Cliente;
import datos.Contacto;

public class ClienteABM {

	ClienteDao dao = new ClienteDao();
	
	public Cliente traer (long idCliente) {
		Cliente c = dao.traer(idCliente);
		return c;
	}
	
	public Cliente traer(int dni) {
		Cliente c = dao.traer(dni);
		return c;
	}
	
	public Cliente traerClienteYContacto(long idCliente) {
		Cliente c = dao.traerClienteYContacto(idCliente);
		return c;
	}
	
	public int agregar (String apellido, String nombre, int dni, LocalDate fechaDeNacimiento, Contacto contacto) throws Exception {
		//consultar si existe cliente con el mismo dni, si existe arrojar excepcion
		Cliente c = new Cliente(apellido, nombre, dni, fechaDeNacimiento, contacto);
		if(traer(c.getDni()) != null) {
            throw new Exception("ERROR: Ya existe un cliente con ese dni");
		}
		return dao.agregar(c);
	}
	
	public void modificar (Cliente c) throws Exception{
		//implementar antes de actualizar que no exista un cliente con el mismo
		//documento a modificar y con el mismo id, lanzar la Exception
		if (traer(c.getDni())!= null || traer(c.getIdCliente())!= null) {
            throw new Exception("ERROR: no puede modificarse porque tiene el mismo dni");
		}
		dao.actualizar(c);
	}
	
	public void eliminar (long idCliente) throws Exception{
		//en este caso es física en gral. no se se aplicaría este caso de uso, si
		//se hiciera habría que validar que el cliente no tenga dependencias	
		Cliente c = dao.traer(idCliente);
		// Implementar que si es null que arroje la excepción la Excepción
		if(c==null) {
            throw new Exception("ERROR: el cliente no puede ser eliminado porque no existe.");

		}
		dao.eliminar(c);
	}
	
	public List<Cliente> traer(){
		return dao.traer();
	}
	
	
}
