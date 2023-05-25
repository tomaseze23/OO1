package test;

import datos.Cliente;
import negocio.ClienteABM;
public class TestCliente {

	public static void main(String[] args) {
		ClienteABM abm = new ClienteABM();
		int idCliente = 1;
		System.out.println("+ traer(" + idCliente+")");
		System.out.println(abm.traer(1));
		
		idCliente = 2;
		System.out.println("+ traer(" + idCliente+")");
		System.out.println(abm.traer(2));
		
		System.out.println("\n\n\n +traer()");
		for(Cliente c: abm.traer()) {
			System.out.println(c);
		}
	}

}
