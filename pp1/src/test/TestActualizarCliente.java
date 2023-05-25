package test;

import datos.Cliente;
import negocio.ClienteABM;

public class TestActualizarCliente {

	public static void main(String[] args) {
		ClienteABM abm = new ClienteABM();
		long id = 1;
		
		Cliente c = abm.traer(id);
		System.out.println("El cliente a modificar es: " + c);
		
		try {
			c.setDni(44093293);
			abm.modificar(c);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		int dni = 44093293;
		Cliente mod = abm.traer(dni);
		System.out.println("El cliente modificado quedó: " + mod);
	}

}
