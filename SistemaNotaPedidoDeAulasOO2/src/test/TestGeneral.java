package test;

import java.time.LocalDate;

import negocio.MateriaAbm;
import negocio.NotaPedidoAbm;

public class TestGeneral {

	public static void main(String[] args) {
		
		System.out.println("CU1");
		System.out.println(MateriaAbm.getInstance().traerMateria(1));
		System.out.println("CU2");
		System.out.println(NotaPedidoAbm.getInstance().traerNotaPedido(1));
		System.out.println("CU3");
		System.out.println(NotaPedidoAbm.getInstance().traer(LocalDate.of(2022, 5, 9)));
		System.out.println("CU4");
		System.out.println(NotaPedidoAbm.getInstance().traerFinales(LocalDate.of(2022, 5, 10), LocalDate.of(2022, 5, 11)));
		System.out.println("CU5");
		System.out.println(NotaPedidoAbm.getInstance().traerFinalesConJoin(LocalDate.of(2022, 5, 10), LocalDate.of(2022, 5, 11), MateriaAbm.getInstance().traerMateria(3)));
		System.out.println(NotaPedidoAbm.getInstance().traerFinales(LocalDate.of(2022, 5, 10), LocalDate.of(2022, 5, 11), MateriaAbm.getInstance().traerMateria(3)));
		System.out.println("CU6");
		NotaPedidoAbm.getInstance().agregar(LocalDate.of(2022, 06, 15), 100, MateriaAbm.getInstance().traerMateria(3), "101");
		
		

	}

}
