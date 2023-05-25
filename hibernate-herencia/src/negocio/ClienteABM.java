package negocio;

import java.util.List;
import dao.ClienteDao;
import datos.Cliente;

public class ClienteABM {
	ClienteDao dao = new ClienteDao();

	public Cliente traer(int idCliente) {
		Cliente c = dao.traer(idCliente);
		return c;
	}

	public List<Cliente> traer() {
		return dao.traer();
	}
}
