package modelo;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

public class AdmCarrito {
	private List<Carrito> lstCarrito;

	public AdmCarrito() {
		this.lstCarrito = new ArrayList<Carrito>();
	}

	public List<Carrito> getLstCarrito() {
		return lstCarrito;
	}

	@Override
	public String toString() {
		String ret = "";
		for (Carrito c : lstCarrito)
			ret = ret + c.toString() + "\n";
		return ret;
	}

	public boolean agregarCarrito(LocalDate fecha, LocalTime hora, Cliente cliente) throws Exception {
		// Si el carrito existe en la lista levantar una excepción.
		int indice = 1;
		if (existeCarritoCliente(fecha, hora, cliente)) {
			throw new Exception("ERROR: El carrito ya existe en nuestro sistema.");
		}
		if (!lstCarrito.isEmpty()) {
			indice = lstCarrito.get(lstCarrito.size() - 1).getIdCarrito() + 1;
		}
		return lstCarrito.add(new Carrito(indice, fecha, hora, cliente));
	}

	public Carrito traerCarrito(int idCarrito) {
		// Si el carrito no existe devolver null.
		Carrito auxiliar = null;
		int indice = 0;
		while (auxiliar == null && indice < lstCarrito.size()) {
			if (lstCarrito.get(indice).getIdCarrito() == idCarrito) {
				auxiliar = lstCarrito.get(indice);
			}
			indice++;
		}

		return auxiliar;
	}

	public boolean existeCarritoCliente(LocalDate fecha, LocalTime hora, Cliente cliente) {
		boolean encontrado = false;
		int indice = 0;
		while (!encontrado && indice < lstCarrito.size()) {
			if (lstCarrito.get(indice).equals(fecha, hora, cliente)) {
				encontrado = true;
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
		return lstCarrito.remove(traerCarrito(idCarrito));
	}

	public float calcularTotal(Long dni) {
		float total = 0;

		for (int index = 0; index < lstCarrito.size(); index++) {
			if (lstCarrito.get(index).getCliente().getDni() == dni)
				total = total + lstCarrito.get(index).calcularTotal();
		}
		return total;
	}

	public float calcularTotal(LocalDate fechaInicio, LocalDate fechaFin) throws Exception {
		float total = 0;
		if (fechaFin.isBefore(fechaInicio)) {
			throw new Exception("ERROR: Las fechas son incorrectas, no se pudo realizar el total.");
		}
		int indice = 0;
		while (indice < lstCarrito.size()) {
			if (fechaInicio.compareTo(lstCarrito.get(indice).getFecha()) <= 0
					&& fechaFin.compareTo(lstCarrito.get(indice).getFecha()) >= 0) {
				total = total + lstCarrito.get(indice).calcularTotal();
			}
			indice++;
		}
		return total;
	}

	public float calcularTotal(LocalDate fechaInicio, LocalDate fechaFin, Cliente cliente) throws Exception {
		float total = 0;
		if (fechaFin.isBefore(fechaInicio)) {
			throw new Exception("ERROR: Las fechas son incorrectas, no se pudo realizar el total.");
		}
		for (int index = 0; index < lstCarrito.size(); index++) {
			if (fechaInicio.compareTo(lstCarrito.get(index).getFecha()) <= 0
					&& fechaFin.compareTo(lstCarrito.get(index).getFecha()) >= 0
					&& lstCarrito.get(index).getCliente().equals(cliente))
				total += lstCarrito.get(index).calcularTotal();
		}
		return total;
	}
}
