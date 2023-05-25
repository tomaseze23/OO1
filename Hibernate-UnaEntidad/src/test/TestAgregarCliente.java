package test;

import java.time.LocalDate;
import negocio.ClienteABM;
public class TestAgregarCliente {

	public static void main(String[] args) {
		String apellido = "tu apellido";
		String nombre = "tu nombre"; 
		int documento = 44093293;
		
		//tu fecha de nacimiento
		LocalDate fechaDeNacimiento = LocalDate.now();
		ClienteABM abm = new ClienteABM();
		//abm.eliminar(5);
		try {
			long ultimoIdCliente = ultimoIdCliente=abm.agregar(apellido, nombre, documento, fechaDeNacimiento);
		}catch(Exception e){
            System.out.println(e.getMessage());

		}
		try {
			abm.eliminar(9);
		}catch(Exception e) {
            System.out.println(e.getMessage());
		}
	}

}
