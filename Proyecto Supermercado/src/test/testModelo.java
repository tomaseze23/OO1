package test;

import modelo.Supermercado;
import modelo.Producto;
import modelo.ItemCarrito;
import modelo.AdmProducto;
import modelo.AdmCarrito;
import modelo.AdmCliente;

//import java.util.ArrayList;
import java.util.List;

import java.time.LocalDate;
import java.time.LocalTime;

public class testModelo {

	public static void main(String[] args) {
		AdmProducto adminProductos = new AdmProducto();
		AdmCarrito adminCarritos = new AdmCarrito();
		AdmCliente adminClientes = new AdmCliente();
		Supermercado coto = new Supermercado(adminProductos, adminCarritos, adminClientes);

		LocalTime hora = LocalTime.now();

		System.out.println("======ESCENARIO 1-> AGREGAR PRODUCTOS======\n");
		try {
			coto.agregarProducto("Coca Cola", 3);
			coto.agregarProducto("Papas Lay's", 5);
			coto.agregarProducto("Galletitas Surtidas", 10);
			coto.agregarProducto("Vino Uvita", 8);
			coto.agregarProducto("Yerba Mate", 7);
			coto.agregarProducto("Papel Higienico", 6);
			coto.agregarProducto("Fernet Branca", 12);
			coto.agregarProducto("Palitos Salados", 2);
			coto.agregarProducto("Coca Cola", 50);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

		System.out.println("\n======ESCENARIO 2-> TRAER PRODUCTOS======\n");
		try {
			System.out.println(coto.traerProducto(3));
			System.out.println(coto.traerProducto(9));
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

		System.out.println("\n======ESCENARIO 3-> MODIFICAR PRODUCTOS======\n");
		try {
			coto.modificarProducto(1, "Papitas Lay's", 25.5f);
			System.out.println(coto.traerProducto(1));
			coto.modificarProducto(8, "Agua Mineral", 35);
			System.out.println(coto.traerProducto(6));
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

		System.out.println("\n======ESCENARIO 4-> AGREGAR CLIENTE======\n");
		try {
			coto.agregarCliente("Tomás Zarich", 44093293, "Mayor Olivero 1385");
			coto.agregarCliente("Pablo Perez", 32168304, "AV. Siempre Viva 347");
			coto.agregarCliente("Gustavo Fernandez", 38680524, "AV. 29 de Septiembre 9867");
			coto.agregarCliente("Nora Leone", 13597893, "Gustavo Siciliano 1818");
			coto.agregarCliente("Eduardo Zarich", 13606094, "Gustavo Siciliano 1818");
			coto.agregarCliente("Tomás Zarich", 44093293, "Mayor Olivero 1385");
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

		System.out.println("\n======ESCENARIO 5-> TRAER CLIENTE======\n");
		try {
			System.out.println(coto.traerCliente(5));
		} catch (Exception e) {
			System.out.println(e.getMessage());

		}

		System.out.println("\n======ESCENARIO 6-> AGREGAR CARRITO======\n");
		System.out.println(coto.getAdmCliente());
		try {
			coto.agregarCarrito(LocalDate.of(2022, 9, 7), hora, coto.traerCliente(1));
			coto.agregarCarrito(LocalDate.of(2022, 9, 11), hora, coto.traerCliente(2));
			coto.agregarCarrito(LocalDate.of(2022, 8, 5), hora, coto.traerCliente(3));
			coto.agregarCarrito(LocalDate.of(2022, 9, 8), hora, coto.traerCliente(1));
			coto.agregarCarrito(LocalDate.of(2022, 9, 13), hora, coto.traerCliente(1));
			System.out.println("Los carritos fueron agregados con exito.");
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

		/*
		 * System.out.println("\n======ESCENARIO 7-> ELIMINAR CLIENTE======\n"); try {
		 * coto.eliminarCliente(0);
		 * System.out.println("El cliente fue eliminado con exito.");
		 * 
		 * } catch (Exception e) { System.out.println(e.getMessage()); }
		 */

		System.out.println("\n======ESCENARIO 8-> AGREGAR ITEMS AL CARRITO======\n");
		coto.traerCarrito(1).agregarItem(coto.traerProducto(0), 3);
		coto.traerCarrito(1).agregarItem(coto.traerProducto(0), 3);
		coto.traerCarrito(3).agregarItem(coto.traerProducto(1), 4);
		coto.traerCarrito(1).agregarItem(coto.traerProducto(4), 5);
		coto.traerCarrito(2).agregarItem(coto.traerProducto(2), 6);
		coto.traerCarrito(2).agregarItem(coto.traerProducto(5), 2);
		coto.traerCarrito(2).agregarItem(coto.traerProducto(4), 5);
		coto.traerCarrito(1).agregarItem(coto.traerProducto(2), 6);
		coto.traerCarrito(1).agregarItem(coto.traerProducto(6), 6);
		coto.traerCarrito(1).agregarItem(coto.traerProducto(3), 6);
		coto.traerCarrito(2).agregarItem(coto.traerProducto(5), 2);
		coto.traerCarrito(2).agregarItem(coto.traerProducto(4), 5);
		coto.traerCarrito(1).agregarItem(coto.traerProducto(2), 5);
		coto.traerCarrito(2).agregarItem(coto.traerProducto(5), 4);
		coto.traerCarrito(3).agregarItem(coto.traerProducto(1), 6);
		coto.traerCarrito(3).agregarItem(coto.traerProducto(4), 2);
		coto.traerCarrito(3).agregarItem(coto.traerProducto(1), 5);
		coto.traerCarrito(3).agregarItem(coto.traerProducto(3), 3);
		coto.traerCarrito(3).agregarItem(coto.traerProducto(6), 2);
		coto.traerCarrito(3).agregarItem(coto.traerProducto(3), 7);
		coto.traerCarrito(3).agregarItem(coto.traerProducto(2), 6);
		System.out.println("Los items fueron agregados exitosamente al carrito.");

		System.out.println("\n======ESCENARIO 9-> ELIMINAR ITEMS DEL CARRITO======\n");
		try {
			System.out.println("Carrito de " + coto.traerCarrito(0).getCliente().getCliente());
			System.out.println(coto.traerCarrito(0));
			coto.traerCarrito(0).eliminarItem(coto.traerProducto(0), 2);
			coto.traerCarrito(0).eliminarItem(coto.traerProducto(3), 3);
			System.out.println(coto.traerCarrito(0));
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

		System.out.println("\n======ESCENARIO 10-> ELIMINAR PRODUCTOS======\n");
		try {
			coto.eliminarProducto(5);
			System.out.println("El producto fue eliminado correctamente.");
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

		System.out.println("\n======ESCENARIO 11-> CALCULAR SUBTOTAL DE CARRITO======\n");
		System.out.println(coto.traerCarrito(1).calcularTotal());

		System.out.println("\n======ESCENARIO 12-> CALCULAR TOTAL DE CARRITO======\n");
		System.out.println("El total a pagar es: " + coto.traerCarrito(1).calcularTotal());

		System.out.println("\n======ESCENARIO 13-> TOTAL DE CLIENTES======\n");
		try {
			System.out.println("El total de " + coto.traerCliente(1).getCliente() + " es: "
					+ coto.calcularTotal(coto.traerCliente(1)));
			System.out.println("El total de " + coto.traerCliente(2).getCliente() + " es: "
					+ coto.calcularTotal(coto.traerCliente(2)));
			System.out.println("El total del cliente es: " + coto.calcularTotal(coto.traerCliente(6)));
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

		System.out.println("\n======ESCENARIO 14-> TOTAL ENTRE FECHAS======\n");
		try {
			System.out.println("El total entre los dias indicados es: "
					+ coto.calcularTotal(LocalDate.of(2022, 9, 6), LocalDate.of(2022, 9, 12)));
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

		System.out.println("\n======ESCENARIO 15-> TOTAL DE UN DÍA======\n");
		try {
			System.out.println("El total del día es: " + coto.calcularTotal(LocalDate.of(2022, 9, 7)));
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

		System.out.println("\n======ESCENARIO 16-> TOTAL DE UN MES======\n");
		try {
			System.out.println("El total del mes es: " + coto.calcularTotal(9, 2022));
			System.out.println("El total del mes es: " + coto.calcularTotal(14, 2022));
		} catch (Exception e) {
			System.out.println(e.getMessage());

		}

		System.out.println("\n======ESCENARIO 17-> TOTAL DE CLIENTE ENTRE FECHAS======\n");
		try {
			System.out.println("El total del cliente es: "
					+ coto.calcularTotal(LocalDate.of(2022, 9, 1), LocalDate.of(2022, 9, 14), coto.traerCliente(2)));
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

		System.out.println("\n======ESCENARIO 18-> TOTAL DE CLIENTE EN UN DÍA======\n");
		try {
			System.out.println("El total es: " + coto.calcularTotal(LocalDate.of(2022, 9, 7), coto.traerCliente(1)));
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

		System.out.println("\n======ESCENARIO 19-> TOTAL DE CLIENTE EN UN MES======\n");
		try {
			System.out.println("El total es: " + coto.calcularTotal(9, 2022, coto.traerCliente(1)));
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

		System.out.println("\n======ESCENARIO 20-> ELIMINAR CARRITO======\n");
		try {
			coto.eliminarCarrito(1);
			System.out.println("El carrito fue eliminado exitosamente.");
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	public static void mostrarGondola(List<Producto> productos) {
		for (int i = 0; i < productos.size(); i++) {
			System.out.println("[ID Producto: " + productos.get(i).getIdProducto() + " Nombre: "
					+ productos.get(i).getProducto() + " Precio: " + productos.get(i).getPrecio() + "]");
		}
	}

	public static void mostrarCarrito(List<ItemCarrito> productos) {
		if (productos.size() == 0) {
			System.out.println("El carrito está vacio.");
		} else {
			for (int i = 0; i < productos.size(); i++) {
				System.out.println(productos.get(i).getProducto() + " Cantidad: " + productos.get(i).getCantidad());
			}

		}
	}
}
