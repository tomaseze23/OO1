package test;

import negocio.ClienteABM;
import negocio.EventoABM;

import java.time.LocalDate;

import datos.Cliente;
import datos.Evento;
public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		EventoABM abmE = new EventoABM();
		ClienteABM abmC = new ClienteABM();
		
		Cliente c = abmC.traerClienteYEventos(1);
		System.out.println("\n---> Traer Cliente y Eventos idCliente="+1);
		System.out.println("\n"+c);
		
		long idC =1;
		long idE =3;
		//abmE.agregarClienteAEvento(idC, idE);
		idC =1;
		idE =1;
		//abmE.agregarClienteAEvento(idC, idE);
		abmE.eliminarClienteAEvento(idC, idE);
		System.out.println("\n---> Traer Cliente y Eventos idCliente="+1);
		System.out.println("\n"+c);
	}

}
