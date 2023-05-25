package test;
	import datos.Cliente;
	import negocio.ClienteABM;
	import java.util.List;
public class TestTraerClientes {

	public static void main(String[] args) {
		ClienteABM abm = new ClienteABM();
		mostrarLista(abm.traer());
	}
	public static void mostrarLista(List<Cliente> lista) {
		for(Cliente c: lista) {
			System.out.println(c);
		}
	}
}
