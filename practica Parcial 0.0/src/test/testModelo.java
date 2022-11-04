package test;

import java.time.LocalDate;

import modelo.Sistema;

public class testModelo {

	public static void main(String[] args) {
		Sistema sistema = new Sistema();
		/*1) agregar los siguientes empleadosEmpleado [apellido=Melo, nombre=Tomas, nroLegajo=3724, valorHora=430.0],
		Empleado [apellido=Navarro, nombre=Mónica, nroLegajo=3125, valorHora=410.0]*/
		sistema.agregarEmpleado("Melo", "Tomas", "3724", 430.0);
		sistema.agregarEmpleado("Navarro", "Mónica", "3125", 410.0);
		System.out.println("2) Traer empleado por legajo=3125");
		System.out.println(sistema.traerEmpleado("3125"));
		/*3) Agregar los siguientes tareas
		Tarea [idTarea=1, tarea=Reparación Catelli altura 1700-1800, fechaInicio=2021-05-13,
		fechaFin=2021-06-21, responsable=
		Empleado [apellido=Melo, nombre=Tomas, nroLegajo=3724, valorHora=430.0], cantHorasDiarias=6,
		habil=true],
		Tarea [idTarea=2, tarea=Reparación semaforo peatonal Alsina y Boedo, fechaInicio=2021-06-17,
		fechaFin=2021-07-25, responsable=
		Empleado [apellido=Navarro, nombre=Mónica, nroLegajo=3125, valorHora=410.0], cantHorasDiarias=6,
		habil=false]*/
		sistema.agregarTarea("Reparación Catelli altura 1700-1800", LocalDate.of(2021, 5, 31), LocalDate.of(2021, 6, 21), sistema.traerEmpleado("3724"), 6, true);
		sistema.agregarTarea("Reparación semaforo peatonal Alsina y Boedo", LocalDate.of(2021, 6, 17), LocalDate.of(2021, 7, 25), sistema.traerEmpleado("3125"), 6, false);
		System.out.println("4) Traer tarea con id=1: "+sistema.traerTarea(1));
		System.out.println("5) El jornal de tarea con id 1 es: "+sistema.traerTarea(1).calcularJornal());
		System.out.println("6) Dias trabajados tarea 1: "+sistema.traerTarea(1).calcularCantDiasTrabajados(6, 2021));
		System.out.println("7) Honorarios del mes 6 para tarea 1: "+sistema.traerTarea(1).calcularHonorarios(6, 2021));
		System.out.println("8) Traer tarea con id=2: "+sistema.traerTarea(2));
		System.out.println("9) El jornal de tarea con id 2 es: "+sistema.traerTarea(2).calcularJornal());
		System.out.println("10) Dias trabajados para tarea 2: "+sistema.traerTarea(2).calcularCantDiasTrabajados(6, 2021));
		System.out.println("11) Honorarios del mes 6 para tarea 2: "+sistema.traerTarea(2).calcularHonorarios(6, 2021));
		//System.out.println(sistema.toString());
	}

}
