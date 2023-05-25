package test;

import datos.Cliente;
import negocio.ClienteABM;

public class TestCliente {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int idCliente=1;
		ClienteABM abm = new ClienteABM();
		System.out.println("+ traer("+idCliente+")");
		System.out.println(abm.traer(idCliente));
		idCliente=2;
		System.out.println("\n+ traer("+idCliente+")");
		System.out.println(abm.traer(idCliente));
		System.out.println("\n+ traer()");
		for (Cliente c: abm.traer()) {
		System.out.println(c);
		}
	}

}
