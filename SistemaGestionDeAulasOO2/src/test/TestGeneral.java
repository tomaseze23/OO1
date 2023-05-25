package test;

import java.time.LocalDate;

import dao.EdificioDao;
import negocio.AulaAbm;
import negocio.EspacioAbm;

public class TestGeneral {

	public static void main(String[] args) {

		System.out.println("CU1");
		System.out.println(EdificioDao.getInstance().traer(1));
		System.out.println("CU2");
		System.out.println(AulaAbm.getInstance().traer(5));
		System.out.println("CU3");
		LocalDate fecha = LocalDate.of(2022, 5, 1);
		//System.out.println(EspacioAbm.getInstance().traer(1));
		System.out.println(EspacioAbm.getInstance().traerQuery(fecha, 'M',AulaAbm.getInstance().traer(5) ));
		System.out.println("CU4");
		try {
			EspacioAbm.getInstance().agregar(LocalDate.of(2022, 5, 1), 'M', AulaAbm.getInstance().traer(5), true );
		}catch(Exception e) {
			System.out.println(e);
		}
		
		System.out.println(LocalDate.of(2022, 5, 1).getMonth().length(false)); //.lengthOfMonth()
		System.out.println("CU5");
		try {
			EspacioAbm.getInstance().agregarEspacioMes(5, 2022, 'M', AulaAbm.getInstance().traer(3));
		}catch(Exception e) {
			System.out.println(e);
		}
	}

}
