package test;

import datos.Cliente;
import negocio.ClienteABM;

public class TestEliminarCliente {

	public static void main(String[] args) {
		ClienteABM abm = new ClienteABM();
		long id = 1;
		try {
			abm.eliminar(id);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

}
