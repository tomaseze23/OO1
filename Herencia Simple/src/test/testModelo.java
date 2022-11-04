package test;

import java.time.LocalDate;

import modelo.Cliente;
import modelo.Empleado;
import modelo.Persona;

public class testModelo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Persona [] personas = new Persona[4];
		personas[0] = new Cliente("Tomás", "Zarich", 44093293, LocalDate.of(2002, 6, 14), "20-44093293-3", 103);
		personas[1] = new Cliente("Pedro", "Sánchez", 40017018, LocalDate.of(1997, 2, 24), "20-40017018-5", -62);
		personas[2] = new Empleado("Nora", "Leone", 13597893, LocalDate.of(1960, 2, 25), 5656, 43000);
		personas[3] = new Empleado("Eduardo", "Zarich", 13606093, LocalDate.of(1957, 11, 8), 2834, 55000);
		for (int i=0;i<4;i++) {
			if(personas[i].calcularEdad(LocalDate.now())>30)
				System.out.println(personas[i]);
		}
	}

}
