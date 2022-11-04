package modelo;

import java.util.ArrayList;
import java.util.List;

public class AdmProducto {
	private List<Producto> lstProducto;

	public AdmProducto() {
		this.lstProducto = new ArrayList<Producto>();
	}

	public List<Producto> getLstProducto() {
		return lstProducto;
	}

	@Override
	public String toString() {
		String ret = "";
		for (Producto p : lstProducto)
			ret = ret + p.toString() + "\n";
		return ret;
	}

	public boolean agregarProducto(String producto, float precio) throws Exception {
		//Si el producto existe en la lista lanzar la excepción
		int indice = 0;
		if (traerProducto(producto)!=null) {
			throw new Exception("ERROR: El producto '" + producto + "' ya se encuentra en la gondola.");
		}
		if(!lstProducto.isEmpty()) {
			indice=lstProducto.get(lstProducto.size()-1).getIdProducto()+1;
		}
		return lstProducto.add(new Producto(indice, producto, precio));
	}

	public Producto traerProducto(String producto) {
		int indice = 0;
		Producto auxiliar = null;
		while (auxiliar == null && indice < lstProducto.size()) {
			if (lstProducto.get(indice).getProducto().equals(producto))
				auxiliar = lstProducto.get(indice);
			indice++;
		}
		return auxiliar;

	}

	public Producto traerProducto(int idProducto) {
		//Si el producto no existe devolver null
		Producto producto = null;
		int indice = 0;
		while (producto==null&&indice < lstProducto.size()) {
			if (lstProducto.get(indice).getIdProducto() == idProducto) {
				producto = lstProducto.get(indice);
			}
			indice++;
		}

		return producto;
	}

	public void modificarProducto(int idProducto, String producto, float precio) throws Exception {
		//traer producto por id, si no existe el objeto levantar la excepción, de lo contrario
		//volver setear producto y precio.
		if (traerProducto(idProducto) == null) {
			throw new Exception("ERROR: El producto " + producto + " no se encuentra en la gondola.");
		}
		traerProducto(idProducto).setProducto(producto);
		traerProducto(idProducto).setPrecio(precio);
	}

	public boolean eliminarProducto(int idProducto) throws Exception {
		//traer producto por id, si no existe el objeto o existe en algún carrito levantar la
		//excepción, de lo contrario eliminar el objeto (remove).
		if (traerProducto(idProducto) == null) {
			throw new Exception("ERROR: El producto no se encuentra en la gondola.");
		}
		return lstProducto.remove(traerProducto(idProducto));
	}
}
