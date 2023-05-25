package negocio;

import java.util.ArrayList;
import java.util.List;

import dao.StockDao;
import datos.Almacen;
import datos.NotaPedido;
import datos.Pedido;
import datos.Producto;

public class StockAbm {
	
	private static StockAbm instancia = null;
	
	protected StockAbm() {}
	
	public static StockAbm getInstance() {
		if(instancia == null) {
			instancia = new StockAbm();
		}
		return instancia;
	}
	
	public Almacen traerAlmacen(Producto p) {
		return StockDao.getInstance().traer(p);
	}
	
	public Pedido traerPedido(Producto p) {
		return StockDao.getInstance().traerPedido(p);
	}
	
	public int calcularCantidadAPedir(Producto p) {
		int unidadesTotales = 0;
		for(NotaPedido np : StockDao.getInstance().traerPedido(p).getNotasPedidos()) {
			if(np.isEntregado() == false) {
				unidadesTotales += np.getCantidad();
			}
		}
		return unidadesTotales;
	}

}
