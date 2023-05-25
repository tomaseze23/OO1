package test;

import datos.Permiso;
import negocio.PermisoAbm;
import negocio.PersonaAbm;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("*****RESOLUCION*****\n\n");
		
		System.out.println("1) + traer(int id) : Persona\ncon id=2");
		System.out.println(PersonaAbm.getInstance().traer(2));
		
		System.out.println("\n\n2) + traerPermisoDiario(int id) : PermisoDiario\ncon id=3");


	}

}
