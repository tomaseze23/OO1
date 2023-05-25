package test;

import negocio.EventoABM;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

import datos.Evento;
import negocio.DispositivoABM;
public class Test {

	public static void main(String[] args) {
		DispositivoABM abmDispositivo = new DispositivoABM();
		EventoABM abmEvento = new EventoABM();
		System.out.println("Test 1: Imprimir listado de dispositivos: \n\n" + abmDispositivo.traer());
		
		System.out.println("\n\nTest 2: Agregar eventos a la base de datos.\nLuego imprimir la lista de eventos");
		
		try {
			abmEvento.agregar("Apertura de la cortina", abmDispositivo.traer("cortina pieza"), 
					LocalDateTime.of(LocalDate.of(2023, 4, 3), LocalTime.of(9, 10)));
			abmEvento.agregar("Cierre de la cortina", abmDispositivo.traer("cortina pieza"), 
					LocalDateTime.of(LocalDate.of(2023, 4, 3), LocalTime.of(19, 05)));
			abmEvento.agregar("Apertura de la cortina", abmDispositivo.traer("cortina pieza"), 
					LocalDateTime.of(LocalDate.of(2023, 4, 4), LocalTime.of(9, 00)));
			abmEvento.agregar("Cierre de la cortina", abmDispositivo.traer("cortina pieza"), 
					LocalDateTime.of(LocalDate.of(2023, 4, 4), LocalTime.of(19, 01)));
			abmEvento.agregar("Prender aire acondicionado", abmDispositivo.traer("temp pieza"), 
					LocalDateTime.of(LocalDate.of(2023, 4, 4), LocalTime.of(11, 30)));
			abmEvento.agregar("Apagar aire acondicionado", abmDispositivo.traer("temp pieza"), 
					LocalDateTime.of(LocalDate.of(2023, 4, 4), LocalTime.of(12, 00)));
			abmEvento.agregar("Apertura de la cortina", abmDispositivo.traer("cortina pieza"), 
					LocalDateTime.of(LocalDate.of(2023, 4, 5), LocalTime.of(9, 05)));
			abmEvento.agregar("Cierre de la cortina", abmDispositivo.traer("cortina pieza"), 
					LocalDateTime.of(LocalDate.of(2023, 4, 5), LocalTime.of(19, 05)));
			
			System.out.println(abmEvento.traer());
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

		
		System.out.println("\n\nTest 3 traer todos los eventos entre fechas");
		System.out.println(abmEvento.traer(LocalDateTime.of(LocalDate.of(2023, 4, 3), 
				LocalTime.of(12, 00)), LocalDateTime.of(LocalDate.of(2023, 4, 5), LocalTime.of(12, 00))));
		

		System.out.println("\n\nTest 4 traer todos los eventos entre fechas y que sean de un dispositivo");
		System.out.println(abmEvento.traer(LocalDateTime.of(LocalDate.of(2023, 4, 3), 
				LocalTime.of(12, 00)), LocalDateTime.of(LocalDate.of(2023, 4, 5), LocalTime.of(12, 00)), 
					abmDispositivo.traer("cortina pieza")));
		
		System.out.println("\n\nTest 5: Devolver todos los dispositivos del tipo sensorCortinaVentana");
		System.out.println(abmDispositivo.traerTodosLosDispositivosSensorCortinaVenta());
	}

}
