package test;

import consultorio.Medico;
import consultorio.Paciente;

public class TestConsultorio2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Paciente paciente1 = new Paciente("José", "Pérez", 1.80f, 85);
		Paciente paciente2 = new Paciente("Jorge", "Férnandez", 1.60f, 90);
		Paciente[] pacientes = {paciente1, paciente2};
		Medico medico1 = new Medico("Daniel", "López", "Nutricionista", pacientes);
		paciente1.setPeso(78);
		paciente2.setPeso(82);
		System.out.println("Visita 2: ");
		System.out.println("Médico: " + medico1.traerNombreCompleto());
		System.out.println("Paciente " + paciente1.traerNombreCompleto() + " IMC: " + medico1.calcularIMC(paciente1));
		System.out.println("Paciente " + paciente2.traerNombreCompleto() + " IMC: " + medico1.calcularIMC(paciente2));

	}

}
