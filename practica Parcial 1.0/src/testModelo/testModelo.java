package testModelo;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

import modelo.Persona;
import modelo.Seguridad;
import modelo.Sistema;

public class testModelo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Sistema sistema = new Sistema();
		System.out.println("1) Agregar e Imprimir las siguientes personas: \n");
		sistema.agregarVisita("Martino", "Marcelo", 44444444, "Coop TIC");
		sistema.agregarEmpleado("López", "Martín", 33333333, 3829);
		sistema.agregarEmpleado("Rodriguez", "Lucia", 11111111, 3840);
		sistema.agregarVisita("Molina", "Rocio", 22222222, "UNLa");
		sistema.agregarVisita("Martino", "Marcelo", 44444444, "Coop TIC");
		mostrarPersonas(sistema.getLstPersonas());
		System.out.println("\n2) Traer e Imprimir persona id=1: \n");
		System.out.println(sistema.traerPersona(1));
		System.out.println("\n3) Agregar e Imprimir los siguientes objetos Seguridad: \n");
		try {
			sistema.agregarSeguridad(LocalDate.of(2021, 9, 6), LocalTime.of(7, 50), true, sistema.traerPersona(1));
			sistema.agregarSeguridad(LocalDate.of(2021, 9, 6), LocalTime.of(8, 00), true, sistema.traerPersona(2));
			sistema.agregarSeguridad(LocalDate.of(2021, 9, 6), LocalTime.of(18, 10), false, sistema.traerPersona(1));
			sistema.agregarSeguridad(LocalDate.of(2021, 9, 6), LocalTime.of(18, 20), false, sistema.traerPersona(2));
			sistema.agregarSeguridad(LocalDate.of(2021, 9, 7), LocalTime.of(9, 00), true, sistema.traerPersona(3));
			sistema.agregarSeguridad(LocalDate.of(2021, 9, 7), LocalTime.of(9, 10), true, sistema.traerPersona(4));
			sistema.agregarSeguridad(LocalDate.of(2021, 9, 7), LocalTime.of(18, 10), false, sistema.traerPersona(3));
			sistema.agregarSeguridad(LocalDate.of(2021, 9, 7), LocalTime.of(18, 20), false, sistema.traerPersona(4));
			mostrarSeguridad(sistema.getLstSeguridad());
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		System.out.println("\n4) Traer e Imprimir objetos Seguridad para persona id=4 y fecha=2021-09-07: \n");
		mostrarSeguridad(sistema.traerSeguridad(LocalDate.of(2021, 9, 7), sistema.traerPersona(4)));
		System.out.println(
				"\n5) Intentar Agregar Seguridad: fecha=2021-09-07, hora=18:25, entrada=false, persona id=4: \n");
		try {
			sistema.agregarSeguridad(LocalDate.of(2021, 9, 7), LocalTime.of(18, 25), false, sistema.traerPersona(4));
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		System.out.println("\n6) Traer todos los objetos Seguridad de las visitas fecha=2021-09-07: \n");
		mostrarSeguridad(sistema.traerVisitas(LocalDate.of(2021, 9, 7)));
	}

	public static void mostrarPersonas(List<Persona> personas) {
		for (int i = 0; i < personas.size(); i++) {
			System.out.println(personas.get(i));
		}
	}

	public static void mostrarSeguridad(List<Seguridad> seguridad) {
		for (int i = 0; i < seguridad.size(); i++) {
			System.out.println(seguridad.get(i));
		}
	}
}
