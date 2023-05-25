package test;

import negocio.ClienteABM;

import datos.Cliente;
import datos.Prestamo;

public class TestTraerClienteYPrestamos {

	public static void main(String[] args) {
		long idCliente = 1;
		ClienteABM clienteABM = new ClienteABM();
		Cliente c = clienteABM.traer(idCliente);
		System.out.println("\n---> Traer cliente y prestamos con idCliente=" + idCliente);
		System.out.println("\n\n" + c);
		for (Prestamo p : c.getPrestamos())
			System.out.println("\n" + p);
	}

}
