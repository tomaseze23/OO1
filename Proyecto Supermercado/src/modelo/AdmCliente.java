package modelo;

import java.util.ArrayList;
import java.util.List;

public class AdmCliente {
	private List<Cliente> lstCliente;

	public AdmCliente() {
		this.lstCliente = new ArrayList<Cliente>();
	}

	public List<Cliente> getLstCliente() {
		return lstCliente;
	}

	@Override
	public String toString() {
		String ret = "";
		for (Cliente c : lstCliente)
			ret = ret + c.toString() + "\n";
		return ret;
	}

	public boolean agregarCliente(String cliente, long dni, String direccion) throws Exception {
		//Si el cliente existe en la lista levantar una excepción.
		int indice = 1;
		if (existeCliente(dni)!=null) {
			throw new Exception("ERROR: El cliente ya se encuentra en nuestro sistema.");
		}
		if (!lstCliente.isEmpty()) {
				indice = lstCliente.get(lstCliente.size() - 1).getIdCliente() + 1;
		}
		return lstCliente.add(new Cliente(indice, cliente, dni, direccion));
	}

	public Cliente existeCliente(long dni) {
		int i = 0;
		Cliente cliente=null;
		while (cliente==null&&i < lstCliente.size()) {
			if (dni == lstCliente.get(i).getDni()) {
				cliente = lstCliente.get(i);
			}
			i++;
		}
		return cliente;
	}

	public Cliente traerCliente(int idCliente) throws Exception {
		//Si el cliente no existe devolver null.
		Cliente cliente = null;
		int indice = 0;
		while (indice < lstCliente.size()) {
			if (idCliente == lstCliente.get(indice).getIdCliente()) {
				cliente = lstCliente.get(indice);
			}
			indice++;
		}
		if (cliente==null) {
			throw new Exception("ERROR: El cliente no existe.");
		}
		return cliente;
	}

	public boolean eliminarCliente(int idCliente) throws Exception {
		//Si el cliente no existe o tiene algún carrito se debe levantar una excepción.
		if (traerCliente(idCliente) == null) {
			throw new Exception("ERROR: El cliente no se encuentra en la lista.");
		} 
		return lstCliente.remove(traerCliente(idCliente));
	}
}
