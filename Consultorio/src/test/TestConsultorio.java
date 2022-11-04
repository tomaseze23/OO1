package test;

import consultorio.Paciente;
import consultorio.Medico;
public class TestConsultorio {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Paciente paciente1 = new Paciente("Jos�","P�rez",1.72f,85);
		Paciente paciente2 = new Paciente("Jorge","Fern�ndez",1.60f,90);
		Paciente paciente3 = new Paciente("Tom�s","Zarich",1.73f,72);
		Paciente paciente4 = new Paciente("Graciela","Perez",1.65f,67);

		Paciente[] pacientes = {paciente1,paciente2, paciente3, paciente4};
		Medico medico1 = new Medico("Daniel", "L�pez", "Nutricionista", pacientes);
		
		System.out.println("Visita 1: ");
		System.out.println("M�dico: "+medico1.traerNombreCompleto());
		System.out.println("Paciente "+paciente1.traerNombreCompleto()+" IMC: "+medico1.calcularIMC(paciente1));
		System.out.println("Paciente "+paciente2.traerNombreCompleto()+" IMC: "+medico1.calcularIMC(paciente2));
		System.out.println("Paciente "+paciente2.traerNombreCompleto()+" IMC: "+medico1.calcularIMC(paciente3));
		System.out.println("Paciente "+paciente2.traerNombreCompleto()+" IMC: "+medico1.calcularIMC(paciente4));

		System.out.println("\nVisita 2: ");
		medico1.mostrarPacientes();
		System.out.println("El promedio de peso de los pacientes es de: "+medico1.traerPromedioPeso());
		System.out.println("El paciente m�s alto es: "+medico1.traerPacienteMayorEstatura());
		System.out.println("El paciente con menor IMC es: "+medico1.traerPacienteMenorIMC());

	}

}
