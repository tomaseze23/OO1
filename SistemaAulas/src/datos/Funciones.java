package datos;

import java.time.LocalDate;
import java.time.LocalTime;

public class Funciones {

	public static double convertirADouble(int n) {
		return ((double) n);
	}

	public static boolean esBisiesto(int anio) {
		return (anio % 4 == 0 & anio % 100 != 0 || anio % 400 == 0);
	}


	public static String traerFechaCorta(LocalDate fecha) {
		return (fecha.getDayOfMonth() + "/" + fecha.getMonthValue() + "/" + fecha.getYear());
	}

	public static String traerHoraCorta(LocalTime hora) {
		return (hora.getHour() + ":" + hora.getMinute());
	}

	public static boolean esDiaHabil(LocalDate fecha) {
		// int d = fecha.getDayOfWeek().getValue();
		/*
		 * Help: LocalDate fecha=LocalDate.of (2019,9,30); int
		 * nroDiaSem=fecha.getDayOfWeek().getValue(); //nroDiaSem=1,from 1 (Monday) to 7
		 * (Sunday)
		 */
		return ((fecha.getDayOfWeek().getValue() >= 1) && (fecha.getDayOfWeek().getValue() <= 5));
	}

	public static String traerDiaDeLaSemana(LocalDate fecha) {
		String dia = "";
		switch (fecha.getDayOfWeek().getValue()) {
		case 1:
			dia = "Lunes";
			break;
		case 2:
			dia = "Martes";
			break;
		case 3:
			dia = "Miércoles";
			break;
		case 4:
			dia = "Jueves";
			break;
		case 5:
			dia = "Viernes";
			break;
		case 6:
			dia = "Sábado";
			break;
		case 7:
			dia = "Domingo";
			break;

		}
		return dia;
	}

	public static String traerMesEnLetras(LocalDate fecha) {
		String mes = "";
		switch (fecha.getMonthValue()) {
		case 1:
			mes = "Enero";
			break;
		case 2:
			mes = "Febero";
			break;
		case 3:
			mes = "Marzo";
			break;
		case 4:
			mes = "Abril";
			break;
		case 5:
			mes = "Mayo";
			break;
		case 6:
			mes = "Junio";
			break;
		case 7:
			mes = "Julio";
			break;
		case 8:
			mes = "Agosto";
			break;
		case 9:
			mes = "Septiembre";
			break;
		case 10:
			mes = "Octubre";
			break;
		case 11:
			mes = "Noviembre";
			break;
		case 12:
			mes = "Diciembre";
			break;

		}
		return mes;
	}

	public static String traerFechaLarga(LocalDate fecha) {
		return (Funciones.traerDiaDeLaSemana(fecha) + " de " + fecha.getDayOfMonth() + " de "
				+ Funciones.traerMesEnLetras(fecha) + " del " + fecha.getYear());
	}

	public static int traerCantDiasDeUnMes(int anio, int mes) {
		int diasMes = 0;
		switch (mes) {
		case 1:
		case 3:
		case 5:
		case 7:
		case 8:
		case 10:
		case 12:
			diasMes = 31;
			break;
		case 4:
		case 6:
		case 9:
		case 11:
			diasMes = 30;
			break;
		case 2:
			if (esBisiesto(anio)) {
				diasMes = 29;
			} else {
				diasMes = 28;
			}
			break;

		}
		return diasMes;
	}
	
	public static double aproximar2Decimal (double valor){
		return Math.round(valor*100.0)/100.0;
	}
	
	public static boolean esNumero (char c){
		return Character.isDigit(c);
	}

	public static boolean esLetra(char c) {
		return Character.isLetter(c);
	}

	public static boolean esCadenaNros(String cadena) {
		boolean numero = true;
        for (int i = 0; i < cadena.length(); i++) {
            if (!Character.isDigit(cadena.charAt(i))) {
                numero = false;
            }
        }
        
        return numero;
	}
	public static boolean esCandenaLetras(String cadena) {
		boolean letra = true;
        for (int i = 0; i < cadena.length(); i++) {
            if (!Character.isLetter(cadena.charAt(i))) {
                letra = false;
            }
        }
        
        return letra;
	}
}
