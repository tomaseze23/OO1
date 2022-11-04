
package test;

import java.time.LocalDate;
import java.time.LocalTime;

public class TestLocalDateyLocalTime {

	public static void main(String[] args) {
		//Creamos una fecha
		LocalDate fecha = LocalDate.of(2019, 3, 19);
		// Creamos otra fecha, restamos 5 dias a la anterior
		LocalDate fecha1 = fecha.minusDays(5);
		//  Creamos otra fecha, sumamos 4 meses a la anterior
		LocalDate fecha2 = fecha1.plusMonths(4);

		System.out.println(
				"Primer Fecha: " + fecha.getDayOfMonth() + "/" + fecha.getMonthValue() + "/" + fecha.getYear());
		System.out.println(
				"Segunda Fecha: " + fecha1.getDayOfMonth() + "/" + fecha1.getMonthValue() + "/" + fecha1.getYear());
		System.out.println(
				"Tercer Fecha: " + fecha2.getDayOfMonth() + "/" + fecha2.getMonthValue() + "/" + fecha2.getYear());

		System.out.println("La primer fecha es anterior a la segunda?: " + fecha.isBefore(fecha1));
		System.out.println("Y la segunda a la tercera?: " + fecha1.isBefore(fecha2));
		System.out.println("La primer fecha es posterior a la segunda?: " + fecha.isAfter(fecha1));
		System.out.println("Y la segunda a la tercera?: " + fecha1.isAfter(fecha2));
		if(fecha.compareTo(fecha2)<0) {
			System.out.println("La fecha "+fecha+" es anterior a "+fecha2);
		}else if(fecha.compareTo(fecha2)>0) {
			System.out.println("La fecha es "+fecha+" posterior a "+fecha2);
		}else {
			System.out.println("Las fechas son iguales.");
		}
		LocalTime ahora = LocalTime.now();
		System.out.println(ahora.getHour() + ":" + ahora.getMinute());
		LocalTime hora = ahora.plusMinutes(15).minusHours(5);
		LocalTime hora1 = ahora.minusHours(3).plusMinutes(12);
		System.out.println(hora.getHour() +":" + hora.getMinute());
		System.out.println(hora1.getHour() +":" + hora1.getMinute());
		
		System.out.println("La primer hora es anterior a la segunda?: " + ahora.isBefore(hora));
		System.out.println("Y la segunda a la tercera?: " + hora.isBefore(hora1));
		System.out.println("La primer hora es posterior a la segunda?: " + ahora.isAfter(hora));
		System.out.println("Y la segunda a la tercera?: " + hora.isAfter(hora1));

	}
}
