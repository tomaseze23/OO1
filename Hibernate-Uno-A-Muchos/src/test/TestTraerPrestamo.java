package test;

import java.util.List;
import datos.Cliente;
import datos.Prestamo;
import negocio.ClienteABM;
import negocio.PrestamoABM;

public class TestTraerPrestamo {

	public static void main(String[] args) {
		PrestamoABM prestamoABM = new PrestamoABM();
		long idPrestamo = 1;

		try {
			System.out.println("\n---> TraerPrestamo idPrestamo: " + idPrestamo + "\n\n");
			Prestamo p = prestamoABM.traerPrestamo(idPrestamo);
			System.out.println(p + "\nPertenece a "+p.getCliente());
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		// implementar Si este cliente no tiene prestamos otorgados imprima el mensaje
		ClienteABM clienteABM = new ClienteABM();
		int dni = 44093293;
		Cliente c=null;
		try {
			c = clienteABM.traer(dni);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

		System.out.println("\n---> TraerPrestamos del Cliente=" + c.getApellido() + "\n\n");
		List<Prestamo> prestamos=null;
		try {
			prestamos = prestamoABM.traerPrestamo(c);
			for (Prestamo o : prestamos)
				System.out.println(o + "\nPertenece a " + o.getCliente());
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

	}

}
