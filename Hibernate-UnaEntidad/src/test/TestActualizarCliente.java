package test;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import datos.Cliente;
import negocio.ClienteABM;
public class TestActualizarCliente {

	public static void main(String[] args) {
		ClienteABM abm = new ClienteABM();

		try {
			long id = 8;
			
			//traer objeto a modificar
			Cliente c = abm.traer(id);
			System.out.println("Cliente a modificar --> "+ c);
			
			//modificar por set los atributos
			c.setDni(44093293);
			c.setApellido("Zarich");
			c.setNombre("Tomás");
			c.setFechaDeNacimiento(LocalDate.of(2002, 6, 14));
			abm.modificar(c); //update del objeto
			int dni = 44093293;
			Cliente cModif = abm.traer(dni);
			System.out.println("Cliente modificado --> " + cModif);
		}catch (Exception e) {
            System.out.println(e.getMessage());
		}
		mostrarClientes(abm.traer());
	
	}
	public static void mostrarClientes (List<Cliente> lstCliente) {
		for (Cliente c:lstCliente) {
			System.out.println(c.toString());
		}
	}
}
