package negocio;

import dao.ProductoDao;
import datos.Producto;

public class ProductoAbm {
	
	private static ProductoAbm instancia = null;
	
	protected ProductoAbm() {}
	
	public static ProductoAbm getInstance () {
		if(instancia == null) {
			instancia = new ProductoAbm();
		}
		return instancia;
	}
	
	public Producto traer(String codigo) {
		return ProductoDao.getInstance().traer(codigo);
	}

}
