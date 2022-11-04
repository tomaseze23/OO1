package test;

import numeros.Numeros;

public class testNumeros {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Numeros n1 = new Numeros(5);
		System.out.println("Caso Prueba número 1: "+n1.sumar(3));
		System.out.println("Caso Prueba número 2: "+n1.multiplicar(3));
		System.out.println("Caso Prueba número 3: "+n1.esPar());
		System.out.println("Caso Prueba número 4: "+n1.esPrimo());
		System.out.println("Caso Prueba número 5: "+n1.convertirAString());
		System.out.println("Caso Prueba número 6: "+n1.convertirADouble());
		System.out.println("Caso Prueba número 7: "+n1.calcularPotencia(3));
		System.out.println("Caso Prueba número 8: "+n1.pasarBase2());
		System.out.println("Caso Prueba número 9: "+n1.calcularFactorial());
		System.out.println("Caso Prueba número 10: "+n1.numeroCombinatorio(3));

	}

}
