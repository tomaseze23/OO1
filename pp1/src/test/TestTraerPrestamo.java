package test;

import java.time.LocalDate;
import java.util.List;

import datos.Cliente;
import datos.Prestamo;
import negocio.ClienteABM;
import negocio.PrestamoABM;

public class TestTraerPrestamo {

	public static void main(String[] args) {
		PrestamoABM prestamoABM = new PrestamoABM();
		long idPrestamo = 1;
		System.out.println("\n---> TraerPrestamo idPrestamo=" + idPrestamo + "\n\n");
		Prestamo p;
		try {
			p = prestamoABM.traerPrestamo(idPrestamo);
			System.out.println(p + "\n pertenece a " + p.getCliente());
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

		ClienteABM clienteABM = new ClienteABM();
		int dni = 14000000;
		Cliente c = clienteABM.traer(dni);

		System.out.println("\n---> TraerPrestamos del cliente=" + c + "\n\n");
		List<Prestamo> prestamos = prestamoABM.traerPrestamos(c);
		for (Prestamo o : prestamos)
			System.out.println(o + "\nPertenece a " + o.getCliente());
		
		System.out.println("\n\n\n\n ------------- TRAER POR FECHA --------------------\n\n\n");
		try {
			List<Prestamo> prestamosFecha;
			prestamosFecha = prestamoABM.traerPrestamos(LocalDate.of(2016, 1, 8));
			for (Prestamo o : prestamosFecha)
				System.out.println(o);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
		System.out.println("\n\n\n\n ------------- TRAER PRESTAMOS ENTRE FECHAS --------------------\n\n\n");
		List<Prestamo> prestamosEntre = prestamoABM.traerPrestamos(LocalDate.of(2015, 1, 8), LocalDate.of(2016, 3, 2));
		for(Prestamo p1 : prestamosEntre) {
			System.out.println(p1);
		}
	}

}
