package test;

import java.time.LocalDate;

import datos.Cliente;
import negocio.ClienteABM;
import negocio.ContactoABM;

public class TestAgregarContacto {

	public static void main(String[] args) {
		ClienteABM abmCliente = new ClienteABM();
		/*long idCliente = 1;
		Cliente cliente = abmCliente.traer(idCliente);
		System.out.println(cliente);
		ContactoABM abmContacto = new ContactoABM();
		abmContacto.agregar("ajaramillo@unla.edu.ar","11-1111-1111","011-1111-1111", cliente);
		long idCliente = 4;
		Cliente cliente = abmCliente.traer(idCliente);
		System.out.println(cliente);
		ContactoABM abmContacto = new ContactoABM();
		abmContacto.agregar("zarichtomas@gmail.com","22-2222-2222","022-2222-2222", cliente);*/
		ContactoABM abmContacto = new ContactoABM();
		/*try {
			abmCliente.agregar("Leone", "Nora", 13597893, LocalDate.of(1960, 2, 25), null);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
		long id = 5;
		Cliente cliente = abmCliente.traer(id);
		abmContacto.agregar("norita.1914@hotmail.com","33-3333-3333","033-3333-3333", cliente);


	}
}
