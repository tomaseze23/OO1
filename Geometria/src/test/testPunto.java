package test;

import geometria.Circulo;
import geometria.Punto;
public class testPunto {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Caso de Prueba, Escenario 1: ");
		Punto punto1 = new Punto(1, 1);
		Punto punto2 = new Punto(4, 5);
		System.out.println("Punto 1: "+punto1.toString()+"\nPunto 2: "+punto2.toString());
		System.out.println("¿Son iguales? "+punto1.equals(punto2));
		
		System.out.println("Caso de Prueba, Escenario 2: ");
		Punto punto3 = new Punto(1, 2);
		Punto punto4 = new Punto(1, 2);
		System.out.println("Punto 3: "+punto3.toString()+"\nPunto 4: "+punto4.toString());
		System.out.println("¿Son iguales? "+punto3.equals(punto4));	
		
		System.out.println("Caso de Prueba, Escenario 3: ");
		System.out.println("La distancia entre los puntos "+punto1+" y "+punto2+" es de: "+punto1.calcularDistancia(punto2));
		System.out.println("La distancia entre los puntos "+punto3+" y "+punto2+" es de: "+punto3.calcularDistancia(punto2));

		System.out.println("Caso de Prueba, Escenario 4: ");
		Circulo c1 = new Circulo(punto1, 5);
		Circulo c2 = new Circulo(punto2, 7);
		System.out.println("¿son los circulos iguales? "+c1.equals(c2));
		
		System.out.println("Caso de Prueba, Escenario 5: ");
		System.out.println("El perimetro del ciruclo "+c1+" es: "+c1.calcularPerimetro());
		
		System.out.println("Caso de Prueba, Escenario 6: ");
		System.out.println("El área del ciruclo "+c1+" es: "+c1.calcularArea());		
		
		System.out.println("Caso de Prueba, Escenario 7: ");
		System.out.println("La distancia entre el ciruclo "+c1+" y "+c2+ " es: "+c1.calcularDistancia(c2));	
	}

}
