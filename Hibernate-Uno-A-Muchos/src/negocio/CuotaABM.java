package negocio;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import datos.Cuota;
import datos.Prestamo;
import dao.CuotaDao;

public class CuotaABM {
	CuotaDao dao = new CuotaDao();

	public Cuota traerCuota(long idCuota) throws Exception {
		Cuota c = dao.traer(idCuota);
		if (c == null) {
			throw new Exception("ERROR: No existe una cuota con dicho ID.");
		}
		return c;
	}

	public Set<Cuota> calcularCuotas(Prestamo p) {
		Cuota c=null;
		// HashSet para evitar la repeticion de cuotas
		Set<Cuota> setCuotas = new HashSet<Cuota>();
		int nroCuota;
		double saldoPendiente = p.getMonto();
		double interes = p.getInteres();
		double amortizacion;
		double interesCuota;
		double cuota;
		double deuda;

		// Vencimiento
		LocalDate vencimiento = p.getFecha().plusMonths(1);

		if (vencimiento.getDayOfWeek() == DayOfWeek.SUNDAY) {
			vencimiento.plusDays(1);
		}
		if (vencimiento.getDayOfWeek() == DayOfWeek.SATURDAY) {
			vencimiento.plusDays(2);
		}

		// Logica matematica de la cuota
		// Segun la cantidad de cuotas que tenga el prestamo P, realizar el for
		for (int i = 1; i <= p.getCantCuotas(); i++) {
			nroCuota = i;
			if (i == 1) {
				amortizacion = (saldoPendiente * interes) / (Math.pow(1 + interes, p.getCantCuotas()) - 1);
			} else {
				amortizacion = (saldoPendiente * interes) / (Math.pow(1 + interes, p.getCantCuotas() - 1) - 1);
			}
			interesCuota = saldoPendiente * interes;
			cuota = amortizacion + interesCuota;
			deuda = saldoPendiente - amortizacion;

			// Creo el objeto cuota
			// Fecha de pago en Null porque no se pago ninguna cuota y punitorios en 0
			// porque no hay punitorios todavia
			c = new Cuota(nroCuota, vencimiento, saldoPendiente, amortizacion, interesCuota, 
					cuota, deuda, false, null, 0);
			saldoPendiente = saldoPendiente - amortizacion;
			c.setPrestamo(p);
			// Agrego la cuota al SET
			setCuotas.add(c);

		} // For
		return setCuotas;
	}
}
