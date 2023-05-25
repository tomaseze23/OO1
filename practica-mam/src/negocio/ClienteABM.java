package negocio;

import java.time.LocalDate;
import java.util.List;

import dao.ClienteDao;
import datos.Cliente;
public class ClienteABM {
	ClienteDao dao = new ClienteDao();
	
	public Cliente traer(long idCliente) {
		Cliente c = dao.traer(idCliente);
		return c;
	}
	
	public int agregar(String apellido, String nombre, int dni, LocalDate fechaDeNacimiento) {
		Cliente c = new Cliente(apellido, nombre, dni, fechaDeNacimiento);
		return dao.agregar(c);
	}
	
	public void actualizar(Cliente cliente) {
		dao.actualizar(cliente);
	}
	
	public void eliminar(Cliente cliente) {
		dao.eliminar(cliente);
	}
	
	public List<Cliente> traer(){
		return dao.traer();
	}
	
	public Cliente traerClienteYEventos(long idCliente) {
		return dao.traerClienteYEventos(idCliente);
	}
	
}
