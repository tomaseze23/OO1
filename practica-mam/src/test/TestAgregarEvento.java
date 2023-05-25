package test;

import java.time.LocalDate;

import negocio.EventoABM;
public class TestAgregarEvento {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		EventoABM abm = new EventoABM();
		abm.agregar("Credito Personal", LocalDate.of(2016, 6, 11));
	}

}
