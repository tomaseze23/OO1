package modelo;

import java.time.LocalDate;
import java.time.LocalTime;

public class Supermercado {
	private AdmProducto admProducto;
	private AdmCarrito admCarrito;
	private AdmCliente admCliente;

	public Supermercado(AdmProducto admProducto, AdmCarrito admCarrito, AdmCliente admCliente) {
		this.admProducto = admProducto;
		this.admCarrito = admCarrito;
		this.admCliente = admCliente;
	}

	public AdmProducto getAdmProducto() {
		return admProducto;
	}

	public AdmCarrito getAdmCarrito() {
		return admCarrito;
	}

	public AdmCliente getAdmCliente() {
		return admCliente;
	}

	@Override
	public String toString() {
		String ret = "";
		for (Producto p : admProducto.getLstProducto())
			ret = ret + p.toString() + "\n";
		return ret;
	}

	public boolean agregarProducto(String producto, float precio) throws Exception {
		return admProducto.agregarProducto(producto, precio);
	}

	public Producto traerProducto(int idProducto) {
		return admProducto.traerProducto(idProducto);
	}

	public void modificarProducto(int idProducto, String producto, float precio) throws Exception {
		admProducto.modificarProducto(idProducto, producto, precio);
	}

	public boolean eliminarProducto(int idProducto) throws Exception {
		return admProducto.eliminarProducto(idProducto);
	}

	public boolean agregarCliente(String cliente, long dni, String direccion) throws Exception {
		return admCliente.agregarCliente(cliente, dni, direccion);
	}

	public Cliente traerCliente(int idCliente) throws Exception {
		return admCliente.traerCliente(idCliente);
	}

	public boolean eliminarCliente(int idCliente) throws Exception {
		return admCliente.eliminarCliente(idCliente);
	}

	public boolean agregarCarrito(LocalDate fecha, LocalTime hora, Cliente cliente) throws Exception {
		// Si el carrito existe en la lista levantar una excepción.
		int indice = 0;
		boolean encontrado = false;
		while (!(encontrado) && indice < admCarrito.getLstCarrito().size()) {
			if (traerCarrito(admCarrito.getLstCarrito().get(indice).getIdCarrito()) == null) {
				encontrado = true;
			}
			indice++;
		}
		if ((encontrado)) {
			throw new Exception("El carrito ya existe.");
		}
		return admCarrito.getLstCarrito().add(new Carrito(indice, fecha, hora, cliente));
	}

	public Carrito traerCarrito(int idCarrito) {
		// Si el carrito no existe devolver null.
		Carrito auxiliar = null;
		int indice = 0;
		while (auxiliar == null && indice < admCarrito.getLstCarrito().size()) {
			if (admCarrito.getLstCarrito().get(indice).getIdCarrito() == idCarrito) {
				auxiliar = admCarrito.getLstCarrito().get(indice);
			}
			indice++;
		}

		return auxiliar;
	}

	public Carrito traerCarrito(Producto producto) {
		Carrito auxiliar = null;
		int indice = 0;
		while (auxiliar == null && indice < admCarrito.getLstCarrito().size()) {
			if (admCarrito.getLstCarrito().get(indice).getLstItem().get(indice).getProducto().equals(producto)) {
				auxiliar = admCarrito.getLstCarrito().get(indice);
			}
			indice++;
		}

		return auxiliar;
	}

	public Carrito existeCarritoCliente(int idCliente) {
		Carrito encontrado = null;
		int indice = 0;
		while (indice < admCarrito.getLstCarrito().size()) {
			if (admCarrito.getLstCarrito().get(indice).getCliente().getIdCliente() == idCliente) {
				encontrado = admCarrito.getLstCarrito().get(indice);
			}
			indice++;
		}
		return encontrado;
	}

	public boolean eliminarCarrito(int idCarrito) throws Exception {
		// Si el carrito no existe en la lista levantar una excepción.
		if (traerCarrito(idCarrito) == null) {
			throw new Exception("ERROR: El carrito no existe.");
		}
		return admCarrito.getLstCarrito().remove(traerCarrito(idCarrito));
	}

	public float calcularTotal(Cliente cliente) throws Exception {
		return admCarrito.calcularTotal(cliente.getDni());
	}

	public float calcularTotal(long dni) {
		return admCarrito.calcularTotal(dni);
	}

	public float calcularTotal(LocalDate fechaInicio, LocalDate fechaFin) throws Exception {
		return admCarrito.calcularTotal(fechaInicio, fechaFin);
	}

	public float calcularTotal(LocalDate fecha) throws Exception {
		return admCarrito.calcularTotal(fecha, fecha);
	}

	public float calcularTotal(int mes, int anio) throws Exception {
		if (mes < 1 || mes > 12) {
			throw new Exception("ERROR: El número ingresado no corresponde a ninguno de los meses.");
		}
		LocalDate fechaInicio = LocalDate.of(anio, mes, Funciones.traerCantDiasDeUnMes(anio, mes));
		LocalDate fechaFin = LocalDate.of(anio, mes, Funciones.traerCantDiasDeUnMes(anio, mes));
		return admCarrito.calcularTotal(fechaInicio, fechaFin);
	}

	public float calcularTotal(LocalDate fechaInicio, LocalDate fechaFin, Cliente cliente) throws Exception {
		if (traerCliente(cliente.getIdCliente()) == null) {
			throw new Exception("ERROR: El cliente no existe.");
		}
		return admCarrito.calcularTotal(fechaInicio, fechaFin, cliente);
	}

	public float calcularTotal(LocalDate fecha, Cliente cliente) throws Exception {
		if (traerCliente(cliente.getIdCliente()) == null) {
			throw new Exception("ERROR: El cliente no existe.");
		}
		return admCarrito.calcularTotal(fecha, fecha, cliente);
	}

	public float calcularTotal(int mes, int anio, Cliente cliente) throws Exception {
		// Si el cliente no existe y/o el mes es incorrecto levantar una excepción.
		if (mes < 1 || mes > 12) {
			throw new Exception("ERROR: El número ingresado no corresponde a ningún mes.");
		}
		if (traerCliente(cliente.getIdCliente()) == null) {
			throw new Exception("ERROR: El cliente no existe.");
		}
		LocalDate fechaInicio = LocalDate.of(anio, mes, Funciones.traerCantDiasDeUnMes(anio, mes));
		LocalDate fechaFin = LocalDate.of(anio, mes, Funciones.traerCantDiasDeUnMes(anio, mes));
		return admCarrito.calcularTotal(fechaInicio, fechaFin, cliente);
	}

	public float calcularTotal(int mes, int anio, int dniCliente) throws Exception {
		// Si el cliente no existe y/o el mes es incorrecto levantar una excepción.
		if (mes < 1 || mes > 12) {
			throw new Exception("ERROR: el mes ingresado no es valido");
		}
		if (traerCliente(dniCliente) == null) {
			throw new Exception("ERROR: El cliente no existe.");
		}
		LocalDate fechaInicio = LocalDate.of(anio, mes, Funciones.traerCantDiasDeUnMes(anio, mes));
		LocalDate fechaFin = LocalDate.of(anio, mes, Funciones.traerCantDiasDeUnMes(anio, mes));
		return admCarrito.calcularTotal(fechaInicio, fechaFin, traerCliente(dniCliente));
	}
}
