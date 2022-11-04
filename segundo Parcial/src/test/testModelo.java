package test;

import java.time.LocalDate;
import java.util.List;
import modelo.Campamento;
import modelo.CampingNacional;
import modelo.Persona;
import modelo.Servicio;

public class testModelo {
	public static void main(String[] args) {
		CampingNacional sistema = new CampingNacional();
		System.out.println("1) Agregar e Imprimir siguientes personas: \n");
		try {
			sistema.agregarPersona("Lopez", "Sergio", 11111111);
			sistema.agregarPersona("Rodriguez", "Juan", 22222222);
			sistema.agregarPersona("Fernandez", "Maria", 33333333);
			sistema.agregarPersona("Vazquez", "Juan", 44444444);
			sistema.agregarPersona("Martinez", "Ana", 55555555);
			mostrarPersonas(sistema.getLstPersonas());
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

		System.out.println("\n2) Agregar e Imprimir los siguientes servicios: \n");
		try {
			sistema.agregarRecreo("7358902", LocalDate.of(2022, 9, 2), false, sistema.traerPersona(22222222), 5, 300.0);
			sistema.agregarCampamento("6573540", LocalDate.of(2022, 9, 3), false, sistema.traerPersona(22222222), null,
					1, 1500.0);
			sistema.agregarRecreo("3571398", LocalDate.of(2022, 9, 3), false, sistema.traerPersona(33333333), 10,
					300.0);
			sistema.agregarCampamento("2583941", LocalDate.of(2022, 9, 3), true, sistema.traerPersona(44444444),
					LocalDate.of(2022, 9, 8), 2, 1500.0);
			sistema.agregarRecreo("5243925", LocalDate.of(2022, 9, 3), true, sistema.traerPersona(55555555), 8, 300.0);
			mostrarServicios(sistema.getLstServicios());
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

		System.out.println(
				"\n3) Traer e Imprimir los Servicios con precio final mayor a 500 y que hayan finalizado su estadia: \n");
		mostrarServicios(sistema.traerServiciosPorPrecioFinal(500.0));

		System.out.println("\n4) Traer e Imprimir los Campamentos con más de 4 dias en el predio: \n");
		mostrarCampamentos(sistema.traerCampamentosPorDias(4));

		System.out.println("\n5) Intentar agregar a la siguiente Persona que ya existe en la lista: \n");
		try {
			sistema.agregarPersona("Vazquez", "Juan", 44444444);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

		System.out.println("\n6) Intentar agregar el siguiente servicio con codIngreso inválido: \n");
		try {
			sistema.agregarRecreo("3571394", LocalDate.of(2022, 9, 10), false, sistema.traerPersona(33333333), 5,
					300.0);
			mostrarServicios(sistema.getLstServicios());
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

	}

	public static void mostrarPersonas(List<Persona> personas) {
		for (int i = 0; i < personas.size(); i++) {
			System.out.println(personas.get(i));
		}
	}

	public static void mostrarServicios(List<Servicio> servicios) {
		for (int i = 0; i < servicios.size(); i++) {
			System.out.println(servicios.get(i));
		}
	}

	public static void mostrarCampamentos(List<Campamento> campamentos) {
		for (int i = 0; i < campamentos.size(); i++) {
			System.out.println(campamentos.get(i));
		}
	}
}
