package test;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

import modelo.SistemaYPF;
import modelo.Tarjeta;

public class testModelo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SistemaYPF sistema = new SistemaYPF();
		System.out.println("1) Tratar de agregar las siguientes tarjetas: \n");
		try {
			sistema.agregarTarjeta("ABCDEFG123456", "DNI11222333");
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		try {
			sistema.agregarTarjeta("ABCDE1234567", "DNI11222333");
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		try {
			sistema.agregarTarjeta("ABCDEFG12345", "DNI11222333");
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
		System.out.println("\n2) Agregar las siguientes tarjetas e imprimir la lista: \n");
		try {
			sistema.agregarTarjeta("ABCDEF123456", "DNI11222333");
			sistema.agregarTarjeta("GHIJKL987654", "DNI44555666");
			sistema.agregarTarjeta("MNOPQR456654", "DNI77888999");
			mostrarTarjetas(sistema.getTarjetas());
		}catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
		System.out.println("\n3.1) Traer la tarjeta del cliente codigo DNI11222333, agregar las siguientes compras e imprimir la\r\n"
				+ "tarjeta. Por cada compra deben mostrarse todos sus atributos + el puntaje final correspondiente: \n");
		sistema.traerTarjeta("DNI11222333").agregarCompra(LocalDate.of(2021, 9, 10), LocalTime.of(10, 30), 100.0, 25.0, 20.0);
		sistema.traerTarjeta("DNI11222333").agregarCompra(LocalDate.of(2021, 10, 1), LocalTime.of(20, 30), 200.0, 40.0, 50.0);
		sistema.traerTarjeta("DNI11222333").agregarCompra(LocalDate.of(2021, 9, 15), LocalTime.of(10, 30), 100.0, 30.0, "MODO", 500.0);
		sistema.traerTarjeta("DNI11222333").agregarCompra(LocalDate.of(2021, 10, 1), LocalTime.of(20, 30), 200.0, 20.0, "MODO", 500.0);
		System.out.println(sistema.traerTarjeta("DNI11222333"));
	}
	public static void mostrarTarjetas(List<Tarjeta> tarjetas) {
		for(int i=0;i<tarjetas.size();i++) {
			System.out.println(tarjetas.get(i));
		}
	}
}
