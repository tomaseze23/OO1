package test;

import java.time.LocalDate;

import negocio.AbonadoAbm;
import negocio.PeajeAbm;
import negocio.RodadoAbm;

public class TestGeneral {

	public static void main(String[] args) {
		
		System.out.println("CU1");
		System.out.println(PeajeAbm.getInstance().traerManual());
		System.out.println("CU2");
		System.out.println(PeajeAbm.getInstance().traerTelepeaje());
		System.out.println("CU3");
		System.out.println(PeajeAbm.getInstance().traerManual(LocalDate.of(2020, 11, 2)));
		System.out.println("CU4");
		System.out.println(PeajeAbm.getInstance().cerrarCaja(LocalDate.of(2020, 11, 2)));
		System.out.println("CU5");
		System.out.println(RodadoAbm.getInstance().traerRodado("AAA111"));
		System.out.println("CU7");
		System.out.println(PeajeAbm.getInstance().traerTelepeaje(AbonadoAbm.getInstance().traerAbonado(11111111)));
		System.out.println("CU8");
		System.out.println(AbonadoAbm.getInstance().traerAbonado(11111111));

	}

}
