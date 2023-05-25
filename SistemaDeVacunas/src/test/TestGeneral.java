package test;

import java.time.LocalTime;

import negocio.DosisAbm;
import negocio.PersonaAbm;
import negocio.VacunaAbm;

public class TestGeneral {

	public static void main(String[] args) {
		System.out.println("CU1");
		System.out.println(VacunaAbm.getInstance().traer(800011));
		System.out.println("CU2");
		System.out.println(PersonaAbm.getInstance().traerPersona(30, 40));
		System.out.println("CU3");
		System.out.println(DosisAbm.getInstance().traer(VacunaAbm.getInstance().traer(800011)));
		System.out.println("CU4");
		LocalTime horaDesde = LocalTime.of(11, 15);
		LocalTime horaHasta = LocalTime.of(11, 45);
		System.out.println(DosisAbm.getInstance().traer(horaDesde, horaHasta));
		System.out.println("CU5");
		System.out.println(DosisAbm.getInstance().traer(horaDesde, horaHasta, false));

	}

}
