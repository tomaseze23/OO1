package test;

import negocio.ProductoAbm;
import negocio.StockAbm;

public class TestGeneral {

	public static void main(String[] args) {
		
		System.out.println("CU1");
		System.out.println(ProductoAbm.getInstance().traer("001"));
		System.out.println("CU2");
		System.out.println(StockAbm.getInstance().traerAlmacen(ProductoAbm.getInstance().traer("001")));
		System.out.println("CU3\nCantidad de Productos Existentes para el producto codigo 001");
		System.out.println(StockAbm.getInstance().traerAlmacen(ProductoAbm.getInstance().traer("001")).cantProductosExistentes());
		System.out.println("CU4");
		System.out.println(StockAbm.getInstance().traerPedido(ProductoAbm.getInstance().traer("001")));
		System.out.println("CU5\nCantidad Sin Entregar");
		System.out.println(StockAbm.getInstance().calcularCantidadAPedir(ProductoAbm.getInstance().traer("001")));
		

	}

}
