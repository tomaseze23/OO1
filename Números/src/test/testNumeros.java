package test;

import numeros.Numeros;

public class testNumeros {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Numeros n1 = new Numeros(5);
		System.out.println("Caso Prueba n�mero 1: "+n1.sumar(3));
		System.out.println("Caso Prueba n�mero 2: "+n1.multiplicar(3));
		System.out.println("Caso Prueba n�mero 3: "+n1.esPar());
		System.out.println("Caso Prueba n�mero 4: "+n1.esPrimo());
		System.out.println("Caso Prueba n�mero 5: "+n1.convertirAString());
		System.out.println("Caso Prueba n�mero 6: "+n1.convertirADouble());
		System.out.println("Caso Prueba n�mero 7: "+n1.calcularPotencia(3));
		System.out.println("Caso Prueba n�mero 8: "+n1.pasarBase2());
		System.out.println("Caso Prueba n�mero 9: "+n1.calcularFactorial());
		System.out.println("Caso Prueba n�mero 10: "+n1.numeroCombinatorio(3));

	}

}
