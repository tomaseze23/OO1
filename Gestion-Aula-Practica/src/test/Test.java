package test;

import java.time.LocalDate;

import negocio.AulaABM;
import negocio.EdificioABM;
import negocio.EspacioABM;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		EdificioABM abmEdif = new EdificioABM();
		AulaABM abmAula = new AulaABM();
		EspacioABM abmEsp = new EspacioABM();
		System.out.println("1) " + abmEdif.traerEdificioConAulas(1));
		System.out.println("2) " + abmAula.traer(5));
		System.out.println("3) " + abmEsp.traer(LocalDate.of(2022, 05, 01).plusDays(1), 'M', abmAula.traer(5)));
		try {
			System.out.println("4) " + abmEsp.agregar(LocalDate.of(2022, 05, 01), 'M', abmAula.traer(5), true));
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		try {
			System.out.println("5) ");
			abmEsp.agregarEspacioMes(5, 2022, 'M', abmAula.traer(5));
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

}
