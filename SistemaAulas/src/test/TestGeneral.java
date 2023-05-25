package test;

import java.time.LocalDate;
import negocio.AulaABM;
import negocio.EdificioABM;
import negocio.EspacioABM;

public class TestGeneral {

	public static void main(String[] args) {
		AulaABM abmAula = new AulaABM();
		EdificioABM abmEdificio = new EdificioABM();
		EspacioABM abmEspacio = new EspacioABM();
		System.out.println("1) Traer Edficio con todas sus aulas: ");
		System.out.println("\n\n\n Edificio 1: "+ abmEdificio.traerEdificioConAulas(1) + "\nAULAS: " + abmEdificio.traerEdificioConAulas(1).getAulas());
		
		System.out.println("\n\n2) Traer aula id=5 con el edificio que se encuentra\n");
		System.out.println("\n\n\n Aula 5 y su edificio: " + abmAula.traer(5));
	
		System.out.println("\n\n3) Traer espacio fecha=2022-05-01, turno=M para el aula con id=5\n\n");
		System.out.println("\n\n\n" + abmEspacio.traer(LocalDate.of(2022, 5, 1), 'M', abmAula.traer(5)));
	}

}
