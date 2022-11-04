package test;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

import modelo.Adjunto;
import modelo.Mensaje;
import modelo.Sistema;

public class testModelo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Sistema sistema = new Sistema();
		
		try {
			System.out.println("1-1) Intentar agregar a la lista el objeto SMS: \n");
			sistema.agregarSMS(LocalDate.of(2020, 12, 19), LocalTime.of(21, 34), 1576543210, 158765432, "Estoy en la UNLa");
		}catch (Exception e) {
			System.out.println(e.getMessage());
		}
		try {
			System.out.println("\n1-2) Intentar agregar a la lista el objeto SMS: \n");
			sistema.agregarSMS(LocalDate.of(2020, 12, 19), LocalTime.of(21, 34), 1576543210, 1587654321, "Estoy en la UNLa");
			System.out.println("Agregado con exito :)");
		}catch (Exception e) {
			System.out.println(e.getMessage());
		}
		try {
			System.out.println("\n1-3) Intentar agregar a la lista el objeto Email: \n");
			sistema.agregarEmail(LocalDate.of(2020, 11, 20), LocalTime.of(19, 04), "informacion@unla.gob.ar", "alumno.com", 
					"Información - UNLa", "Estimado alumno, adjuntamos las notas de cursada de OO1.", 
					new Adjunto("Notas_cursada", "XLSX"));
		}catch (Exception e) {
			System.out.println(e.getMessage());
		}
		try {
			System.out.println("\n1-4) Intentar agregar a la lista el objeto Email: \n");
			sistema.agregarEmail(LocalDate.of(2020, 11, 20), LocalTime.of(19, 04), "informacion@unla.gob.ar", "alumno@gmail.com", 
					"Información - UNLa", "Estimado alumno, adjuntamos las notas de cursada de OO1.", 
					new Adjunto("Notas_cursada", "XLSX"));
			System.out.println("Agregado con exito :)");
		}catch (Exception e) {
			System.out.println(e.getMessage());
		}
		System.out.println("\n2-1)Traer e imprimir el SMS con IdMensaje = 1 y cambiar el estado a Visto=true: \n");
		sistema.traerMensaje(1).cambiarDeEstado(true);
		System.out.println(sistema.traerMensaje(1));
		System.out.println("\n2-2)Traer e imprimir el Email con IdMensaje = 2 y cambiar el estado a Recibido=true: \n");
		sistema.traerMensaje(2).cambiarDeEstado(true);
		System.out.println(sistema.traerMensaje(2));
		try {
			System.out.println("\n3) Agregar los siguientes objetos a la lista, al finalizar la carga, imprimirla: \n");
			sistema.agregarSMS(LocalDate.of(2020, 12, 9), LocalTime.of(11, 45), 1576543210, 1598769976, "Estoy llegando");
			sistema.agregarSMS(LocalDate.of(2020, 12, 14), LocalTime.of(8, 49), 1576543210, 1598763741, "Ok. Nos vemos.");
			sistema.agregarEmail(LocalDate.of(2020, 11, 26), LocalTime.of(16, 28), "informacion@unla.gob.ar", "alumno@gmail.com.ar", 
					"Orientación a Objetos 1 - UNLa", "Se adjuntan las notas de los finales de Diciembre", 
					new Adjunto("NotasFinales", "XLSX"));
			sistema.agregarEmail(LocalDate.of(2020, 12, 9), LocalTime.of(14, 52), "info@gmail.com.ar", "cliente@gmail.com.ar", 
					"Ofertas", "Aproveche nuestras ofertas", new Adjunto("Ofertas", "JPG"));
			mostrarListaMensajes(sistema.getListaMensajes());
		}catch (Exception e) {
			System.out.println(e.getMessage());
		}
		System.out.println("\n4-1) Traer e imprimir los mensajes que tengan un adjunto con extensión JPG\n");
		mostrarListaMensajes(sistema.traerMensaje("JPG"));
		System.out.println("\n4-2) Traer e imprimir los mensajes que se hayan enviado el día 09/12/2020 entre las 11 y las 15Hs: \n");
		mostrarListaMensajes(sistema.traerMensaje(LocalDate.of(2020, 12, 9), LocalTime.of(11, 00), LocalTime.of(15, 00)));
		System.out.println("\n4-3) Traer e imprimir los mensajes que se hayan enviado el día 26/11/2020 entre las 15 y las 17Hs "
				+ "y que tengan adjuntos con extensión XLSX\n");
		mostrarListaMensajes(sistema.traerMensaje(LocalDate.of(2020, 11, 26), LocalTime.of(15, 00), LocalTime.of(17, 00), "XLSX"));
	}
	public static void mostrarListaMensajes(List<Mensaje> mensajes) {
		for(Mensaje mensaje: mensajes) {
			System.out.println(mensaje+"\n");
		}
	}
}
