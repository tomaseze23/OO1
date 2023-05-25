package test;
import java.time.LocalDate;

import negocio.ClienteABM;
public class TestAgregarCliente {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ClienteABM cliABM = new ClienteABM();
		cliABM.agregar("Zarich", "Tomás", 44093293, LocalDate.of(2002, 6, 14));
	}

}
