package modelo;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

public class Carrito {
	private int idCarrito;
	private LocalDate fecha;
	private LocalTime hora;
	private List<ItemCarrito> lstItem;
	private Cliente cliente;

	public Carrito(int idCarrito, LocalDate fecha, LocalTime hora, Cliente cliente) {
		this.idCarrito = idCarrito;
		this.fecha = fecha;
		this.hora = hora;
		this.cliente = cliente;
		this.lstItem = new ArrayList<ItemCarrito>();
	}

	public int getIdCarrito() {
		return idCarrito;
	}

	public void setIdCarrito(int idCarrito) {
		this.idCarrito = idCarrito;
	}

	public LocalDate getFecha() {
		return fecha;
	}

	public void setFecha(LocalDate fecha) {
		this.fecha = fecha;
	}

	public LocalTime getHora() {
		return hora;
	}

	public void setHora(LocalTime hora) {
		this.hora = hora;
	}

	public List<ItemCarrito> getLstItem() {
		return lstItem;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	@Override
	public String toString() {
		String ret = "";
		for (ItemCarrito i : lstItem)
			ret = ret + i.toString() + "\n";
		return ret;
	}

	public boolean equals(LocalDate date, LocalTime hour, Cliente client) {
		return this.fecha.equals(date) && this.hora.equals(hour) && this.cliente.equals(client);
	}

	public ItemCarrito traerItemCarrito(Producto producto) {
		int indice = 0;
		ItemCarrito auxiliar = null;
		while (auxiliar == null && indice < lstItem.size()) {
			if (lstItem.get(indice).getProducto().equals(producto))
				auxiliar = lstItem.get(indice);
			indice++;
		}
		return auxiliar;
	}

	public boolean agregarItem(Producto producto, int cantidad) {
		// Cuando se agrega un producto al carrito si producto existe en algún item solo
		// se incrementará la
		// cantidad de lo contrario se agregará el item.
		if (traerItemCarrito(producto) != null) {
			traerItemCarrito(producto).setCantidad(traerItemCarrito(producto).getCantidad() + cantidad);
		}
		int id = 1;
		if (!lstItem.isEmpty()) {
			id = lstItem.get(lstItem.size() - 1).getIdItem() + 1;
		}

		return lstItem.add(new ItemCarrito(id, producto, cantidad));
	}

	public boolean eliminarItem(Producto producto, int cantidad) throws Exception {
		/*
		 * En el caso de eliminar un producto del carrito si la cantidad es la misma se
		 * eliminará el item, si es menor se decrecerá la cantidad y de lo contrario, si
		 * no existe el ítem que contenga el producto lanzará una excepción
		 */
		if (traerItemCarrito(producto) == null) {
			throw new Exception("ERROR: El producto no existe en el carrito.");
		}
		if (cantidad < 0) {
			throw new Exception("ERROR: Cantidad invalida");
		}
		if (traerItemCarrito(producto).getCantidad() <= cantidad) {
			traerItemCarrito(producto).setCantidad(traerItemCarrito(producto).getCantidad() - cantidad);
		}
		return lstItem.remove(traerItemCarrito(producto));

	}

	public float calcularTotal() {
		float suma = 0;
		for (int indice = 0; indice < lstItem.size(); indice++) {
			suma += lstItem.get(indice).calcularSubTotal();
		}
		return suma;
	}

}
