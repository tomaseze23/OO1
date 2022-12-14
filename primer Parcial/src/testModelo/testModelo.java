package testModelo;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

import modelo.Dispositivo;
import modelo.Empresa;
import modelo.Metrica;
/*
import java.time.LocalDate;

import modelo.Funciones;*/
import modelo.SistemaSaludDispositivos;

public class testModelo {

	public static void main(String[] args) {
		SistemaSaludDispositivos sistema = new SistemaSaludDispositivos();
		System.out.println("CASOS DE USO: ");
		System.out.println("\n1) Agregar Empresas e Imprimir Lista: \n");
		sistema.agregarEmpresa("Empresa 1");
		sistema.agregarEmpresa("Empresa 2");
		mostrarEmpresas(sistema.getLstEmpresas());
		System.out.println("\n2) Traer Empresa por ID: \n" + sistema.traerEmpresa("Empresa 1"));
		System.out.println("\n3) Agregar Dispositivos e Imprimir Lista: \n");
		try {
			sistema.agregarDispositivo("Sensor Calor", "A2020", sistema.traerEmpresa("Empresa 1"));
			sistema.agregarDispositivo("Sensor Presi?n", "A2325", sistema.traerEmpresa("Empresa 1"));
			sistema.agregarDispositivo("Sensor Temperatura", "B2021", sistema.traerEmpresa("Empresa 2"));
			sistema.agregarDispositivo("Sensor Humedad", "B2326", sistema.traerEmpresa("Empresa 2"));
			sistema.agregarDispositivo("Sensor Presi?n", "A2325", sistema.traerEmpresa("Empresa 1"));
			mostrarDispositivos(sistema.getLstDispositivos());

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		System.out.println("\n4) Agregar dispositivo incorrecto: \n");
		try {
			sistema.agregarDispositivo("Sensor Movimiento", "B2022", sistema.traerEmpresa("Empresa 1"));
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		System.out.println("\n5) traer dispositivo por nombre: \n" + sistema.traerDispositivo("A2020"));
		System.out.println("\n6) Agregar metricas a dispositivo por nombre e imprimir lista: \n");
		sistema.traerDispositivo("A2020").agregarMetrica(18, LocalDate.of(2022, 9, 18), LocalTime.of(10, 00));
		sistema.traerDispositivo("A2020").agregarMetrica(19, LocalDate.of(2022, 9, 19), LocalTime.of(12, 30));
		sistema.traerDispositivo("A2020").agregarMetrica(23, LocalDate.of(2022, 9, 20), LocalTime.of(15, 00));
		sistema.traerDispositivo("A2020").agregarMetrica(20, LocalDate.of(2022, 9, 21), LocalTime.of(18, 30));
		sistema.traerDispositivo("A2020").agregarMetrica(18, LocalDate.of(2022, 9, 22), LocalTime.of(22, 30));
		mostrarMetricas(sistema.traerDispositivo("A2020").getLstMetricas());
		System.out.println("\n7) traer metrica por fecha y hora: \n");
		System.out.println(
				sistema.traerDispositivo("A2020").traerMetrica(LocalDate.of(2022, 9, 19), LocalTime.of(12, 30)));
		System.out.println("\n8) traer todas las metricas desde una fecha hasta otra: \n");
		List<Metrica> metricas = sistema.traerDispositivo("A2020").traerMetricas(LocalDate.of(2022, 9, 19),
				LocalDate.of(2022, 9, 21));
		mostrarMetricas(metricas);
		System.out.println(
				"\n9) traer todas las metricas desde una fecha hasta otra y con menor valor al solicitado: \n");
		List<Metrica> metricasMenorAValor = sistema.traerDispositivo("A2020").traerMetricas(
				sistema.traerDispositivo("A2020"), LocalDate.of(2022, 9, 19), LocalDate.of(2022, 9, 21), 22);
		mostrarMetricas(metricasMenorAValor);

	}

	public static void mostrarDispositivos(List<Dispositivo> dispositivos) {
		for (int i = 0; i < dispositivos.size(); i++) {
			System.out.println(dispositivos.get(i));
		}
	}

	public static void mostrarEmpresas(List<Empresa> empresas) {
		for (int i = 0; i < empresas.size(); i++) {
			System.out.println(empresas.get(i));
		}
	}

	public static void mostrarMetricas(List<Metrica> metricas) {
		for (int i = 0; i < metricas.size(); i++) {
			System.out.println(metricas.get(i));
		}
	}
}
