package testModelo;

import java.time.LocalDate;
import java.util.List;

import modelo.Sistema;
import modelo.Servicio;
public class testModelo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Sistema sistema = new Sistema();
		
		System.out.println("1-1) Intentar crear el siguiente objeto Gastronomia: \n");
		try {
			sistema.agregarGastronomia("4892", 15.0, true, "Hamburguesa Criolla", 180.0, 4);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
		System.out.println("\n1-2) Crear el siguiente objeto gastronomia: \n");
		try {
			sistema.agregarGastronomia("489235", 15.0, true, "Hamburguesa Criolla", 180.0, 4);
			System.out.println("AGREGADO CON EXITO!");
		}catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
		System.out.println("\n1-3) Intentar crear el siguiente objeto Hospedaje: \n");
		try {
			sistema.agregarHospedaje("2872", 10.0, true, "Cabaña 3 personas", 1500.0);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
		System.out.println("\n1-4) Crear el siguiente objeto Hospedaje: \n");
		try {
			sistema.agregarHospedaje("287282", 10.0, true, "Cabaña 3 personas", 1500.0);
			System.out.println("AGREGADO CON EXITO!");
		}catch (Exception e) {
			System.out.println(e.getMessage());
		}	
		
		System.out.println("\n2-1) Calcular e imprimir precio final del servicio con código 489235: \n");
		System.out.println("El precio final es: " + sistema.traerServicio("489235").calcularPrecioFinal(LocalDate.of(2020, 10, 28)));
		
		System.out.println("\n2-2) Calcular e imprimir precio final del servicio con código 287282: \n");
		System.out.println("El precio final es: " + sistema.traerServicio("287282").calcularPrecioFinal(LocalDate.of(2020, 10, 27)));
	
		System.out.println("\n3) Agregar los siguientes objetos e imprimir la lista de servicios: \n");
		try {
			sistema.agregarGastronomia("858927", 15.0, true, "Milanesa con pure", 350.0, 3);
			sistema.agregarHospedaje("489259", 10.0, true, "Habitación triple", 2200.0);
			sistema.agregarGastronomia("182835", 20.0, false, "Gaseosa", 120.0, 3);
			sistema.agregarHospedaje("758972", 15.0, false, "Habitación simple", 1000.0);
			mostrarServicios(sistema.getLstServicio());
		}catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
		System.out.println("\n4-1) Traer todos los objetos Servicios enPromocion=true: \n");
		mostrarServicios(sistema.traerServicio(true));
		
		System.out.println("\n4-2) Traer todos los objetos Servicios del dia=2020-10-28 y enPromocion=true: \n");
		mostrarServicios(sistema.traerServicio(true, LocalDate.of(2020, 10, 28)));
	}
	
	public static void mostrarServicios(List<Servicio> servicios) {
		for(int i=0;i<servicios.size();i++) {
			System.out.println(servicios.get(i));
		}
	}
}
